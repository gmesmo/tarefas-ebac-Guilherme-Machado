package br.com.gmesmo;

import br.com.gmesmo.dao.ClienteMapDAO;
import br.com.gmesmo.dao.IClienteDAO;
import br.com.gmesmo.domain.Cliente;

import javax.swing.*;

public class App {

    private static IClienteDAO iClienteDAO;

    public static void main(String args[]) {
        iClienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null,
            "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
            "Cadastro", JOptionPane.INFORMATION_MESSAGE);

        while(!isOpcaoValida(opcao)) {
            if("".equals(opcao)) {
                sair();
            }
            opcao = JOptionPane.showInputDialog(null,
                    "Opção inválida, digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                    "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }

        while(isOpcaoValida(opcao)) {
            if(isOpcaoSair(opcao)) {
                sair();
            } else if (isCadastro(opcao)) {
                String dados = JOptionPane.showInputDialog(null, "Digite os dados do cliente separados por vírgula confome exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            } else if (isConsulta(opcao)) {
                String dados = JOptionPane.showInputDialog(null, "Digite o CPF",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);
            } else if (isExcluir(opcao)) {
                String dados = JOptionPane.showInputDialog(null, "Digite o CPF",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                excluir(dados);
            } else if (isAlterar(opcao)) {
                String dados = JOptionPane.showInputDialog(null, "Digite os dados do cliente separados por vírgula confome exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado",
                        "Alteração cadastral", JOptionPane.INFORMATION_MESSAGE);
                alterar(dados);
            }
        opcao = JOptionPane.showInputDialog(null,
                "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");

        if (dadosSeparados[0] != null && dadosSeparados[1] != null && dadosSeparados[2] != null && dadosSeparados[3] != null && dadosSeparados[4] != null && dadosSeparados[5] != null && dadosSeparados[6] != null) {
            Cliente cliente = new Cliente(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2], dadosSeparados[3], dadosSeparados[4], dadosSeparados[5], dadosSeparados[6]);
            Boolean isCadastrado = iClienteDAO.cadastrar(cliente);

            if (isCadastrado) {
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Cliente já se encontra cadastrado.", "Duplicidade", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campos obrigatórios não informados", "Erro!", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private static void consultar(String dados) {
        try {
            Long valor = Long.parseLong(dados);
            Cliente cliente = iClienteDAO.consultar(valor);

            if (cliente != null) {
                JOptionPane.showMessageDialog(null, "Cliente encontrado: " + cliente.toString(), "Consulta Concluída", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado. ", "Consulta Concluída", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "CPF informado incorretamente!", "Erro!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void excluir(String dados) {
        try {
            Long valor = Long.parseLong(dados);
            iClienteDAO.excluir(valor);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "CPF informado incorretamente!", "Erro!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void alterar(String dados) {
        try {
            String[] dadosSeparados = dados.split(",");

            if (dadosSeparados[0] != null && dadosSeparados[1] != null && dadosSeparados[2] != null && dadosSeparados[3] != null && dadosSeparados[4] != null && dadosSeparados[5] != null && dadosSeparados[6] != null) {
                Cliente cliente = new Cliente(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2], dadosSeparados[3], dadosSeparados[4], dadosSeparados[5], dadosSeparados[6]);
                iClienteDAO.alterar(cliente);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "CPF informado incorretamente!", "Erro!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isCadastro(String opcao) {
        if("1".equals(opcao)) {
            return true;
        }

        return false;
    }

    private static boolean isConsulta(String opcao) {
        if("2".equals(opcao)) {
            return true;
        }

        return false;
    }

    private static boolean isAlterar(String opcao) {
        if("3".equals(opcao)) {
            return true;
        }

        return false;
    }

    private static boolean isExcluir(String opcao) {
        if("4".equals(opcao)) {
            return true;
        }

        return false;
    }

    private static boolean isOpcaoSair(String opcao) {
        if("5".equals(opcao)) {
            return true;
        }

        return false;
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até logo!", "Saindo...", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoValida(String opcao) {
        if("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static boolean isOpcaoCadastro(String opcao) {
        if("1".equals(opcao)) {
            return true;
        }

        return false;
    }
}
