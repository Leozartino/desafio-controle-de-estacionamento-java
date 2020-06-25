package challenge;

import java.util.Objects;

public class Motorista {

    private final String nome;

    private final int idade;

    private final int pontos;

    private final String habilitacao;

    private Motorista(String nome, int idade, int pontos, String habilitacao) {
        this.nome = nome;
        this.idade = idade;
        this.pontos = pontos;
        this.habilitacao = habilitacao;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getPontos() {

        return pontos;
    }

    public String getHabilitacao() {

        return habilitacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Motorista motorista = (Motorista) o;
        return Objects.equals(habilitacao, motorista.habilitacao);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(habilitacao);
    }

    @Override
    public String toString() {
        return "Motorista{" + "nome='" + nome + '\'' + ", idade=" + idade + ", pontos=" + pontos + ", habilitacao='"
                + habilitacao + '\'' + '}';
    }

    public static MotoristaBuilder builder() {

        return new MotoristaBuilder();
    }

    public static class MotoristaBuilder {

        private String nome;

        private int idade;

        private int pontos;

        private String habilitacao;

        private MotoristaBuilder() {
        }

        public MotoristaBuilder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public MotoristaBuilder withIdade(int idade) {
            if (idade < 0) {
                throw new IllegalArgumentException("O motorista deve ter uma idade válida!");
            }
            this.idade = idade;
            return this;
        }

        public MotoristaBuilder withPontos(int pontos) {
            if (pontos < 0) {
                throw new IllegalArgumentException("A carteira não deve possuir pontos negativos!");
            }
            this.pontos = pontos;
            return this;
        }

        public MotoristaBuilder withHabilitacao(String habilitacao) {
            if (habilitacao.isEmpty()) {
                throw new IllegalArgumentException("A habilitação deve ser válida!");
            }
            this.habilitacao = habilitacao;
            return this;
        }

        public Motorista build() {
            if (this.habilitacao == null) {
                throw new NullPointerException("A habilitação deve existir!");
            }
            if (this.nome == null) {
                throw new NullPointerException("O motorista deve possuir um nome!");
            }
            if (idade < 18) {
                throw new EstacionamentoException("O motorista deve ser maior de idade!");
            }
            if (pontos > 20) {
                throw new EstacionamentoException("A habilitação não pode estar suspensa!");
            }
            return new Motorista(nome, idade, pontos, habilitacao);
        }
    }
}
