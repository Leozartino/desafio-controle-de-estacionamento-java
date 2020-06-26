package challenge;

import java.util.Objects;

public class Carro {

    private final Motorista motorista;

    private final String placa;

    private final Cor cor;

    private Carro(final Motorista motorista, final String placa, final Cor cor) {
        this.motorista = motorista;
        this.placa = placa;
        this.cor = cor;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public String getPlaca() {
        return placa;
    }

    public Cor getCor() {
        return cor;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Carro carro = (Carro) o;
        return Objects.equals(motorista, carro.motorista) && Objects.equals(placa, carro.placa) && cor == carro.cor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(motorista, placa, cor);
    }

    @Override
    public String toString() {
        return "Carro{" + "motorista=" + motorista + ", placa='" + placa + '\'' + ", cor=" + cor + '}';
    }

    public static CarroBuilder builder() {
        return new CarroBuilder();
    }

    public static class CarroBuilder {

        private Motorista motorista;

        private String placa;

        private Cor cor;

        private CarroBuilder() {
        }

        public CarroBuilder withMotorista(final Motorista motorista) {
            this.motorista = motorista;
            return this;
        }

        public CarroBuilder withPlaca(final String placa) {
            if (placa.isEmpty()) {
                throw new IllegalArgumentException("O carro deve possuir uma placa");
            }
            this.placa = placa;
            return this;
        }

        public CarroBuilder withCor(final Cor cor) {
            this.cor = cor;
            return this;
        }

        public Carro build() {
            if (this.placa == null) {
                throw new NullPointerException("O carro deve ter uma placa!");
            }
            if (this.cor == null) {
                throw new NullPointerException("O carro deve ter uma cor!");
            }
            if (this.motorista == null) {
                throw new EstacionamentoException("O carro deve ter um motorista!");
            }
            return new Carro(motorista, placa, cor);
        }
    }
}
