import java.lang.reflect.Constructor;

public class Exerc_13 {
    public abstract class Pessoa {

        //Nome ou Razão Social
        private String nome;
        //Idade da pessoa ou tempo de existência da empresa
        private Integer idade;
        //telefone da pessoa ou empresa
        private String fone;

        public Pessoa(String nome, Integer idade, String fone) {
            this.nome = nome;
            this.idade = idade;
            this.fone = fone;
        }

        public String getNome() {
            return nome;
        }

        public Integer getIdade() {
            return idade;
        }

        public String getFone() {
            return fone;
        }
    }

    public class PessoaFisica extends Pessoa {
        //Numero do CPF
        private String cpf;
        //Sexo da pessoa
        private String sexo;

        public PessoaFisica(String nome, Integer idade, String fone, String cpf, String sexo) {
            super(nome, idade, fone);
            this.cpf = cpf;
            this.sexo = sexo;
        }

        public String getCpf() {
            return cpf;
        }

        public String getSexo() {
            return sexo;
        }
    }

    public class PessoaJuridica extends Pessoa {
        //CNPJ da empresa
        private String cnpj;
        //Regime SIMPLES ou Geral
        private String regime;


        public PessoaJuridica(String nome, Integer idade, String fone, String cnpj, String regime) {
            super(nome, idade, fone);
            this.cnpj = cnpj;
            this.regime = regime;
        }

        public String getCnpj() {
            return cnpj;
        }

        public String getRegime() {
            return regime;
        }
    }
}
