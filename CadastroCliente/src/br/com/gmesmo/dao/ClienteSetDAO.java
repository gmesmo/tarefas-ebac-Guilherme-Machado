package br.com.gmesmo.dao;

import br.com.gmesmo.domain.Cliente;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ClienteSetDAO implements IClienteDAO {

    private Set<Cliente> set;

    public ClienteSetDAO() {
        this.set = new HashSet<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        // O HashSet vai impedir a duplicação, caso o cliente já exista, não será adicionado
        return this.set.add(cliente);
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteCadastrado = consultar(cpf);

        if (clienteCadastrado != null) {
            this.set.remove(clienteCadastrado);
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        // Não há uma chave de acesso como no Map, então precisamos remover e adicionar novamente
        excluir(cliente.getCpf());  // Primeiro excluímos o cliente
        cadastrar(cliente);  // E então cadastramos o novo cliente alterado
    }

    @Override
    public Cliente consultar(Long cpf) {
        // A busca é feita por iteração, já que o HashSet não possui acesso direto por chave
        for (Cliente cliente : set) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.set;
    }
}
