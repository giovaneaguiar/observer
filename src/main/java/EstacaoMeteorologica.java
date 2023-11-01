import java.util.Observable;

public class EstacaoMeteorologica extends Observable {
    private float temperatura;
    private float umidade;
    private float pressao;

    public void setMedicoes(float temperatura, float umidade, float pressao) {
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.pressao = pressao;
        medidasMudaram();
    }

    public void medidasMudaram() {
        setChanged();
        notifyObservers();
    }

    public float getTemperatura() {
        return temperatura;
    }

    public float getUmidade() {
        return umidade;
    }

    public float getPressao() {
        return pressao;
    }
}