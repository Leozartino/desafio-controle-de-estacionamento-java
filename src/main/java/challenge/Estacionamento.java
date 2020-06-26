package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    final private int LIMITE_VAGAS = 10;
    private final List<Carro> carros;

    public Estacionamento() {
        carros = new ArrayList<>();
    }

    public void estacionar(Carro carro) {
        if (carrosEstacionados() == LIMITE_VAGAS) {
            for (int i = 0; i < 10; i++) {
                if (carros.get(i).getMotorista().getIdade() <= 55) {
                    carros.add(i, carro);
                    carros.remove(i + 1);
                    return;
                }
            }
        } else {
            carros.add(carro);
            return;
        }
        throw new EstacionamentoException("Não é possível estacionar no momento!");
    }

    public int carrosEstacionados() {
        return this.carros.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carros.contains(carro);
    }
}
