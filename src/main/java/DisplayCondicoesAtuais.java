import java.util.Observable;
import java.util.Observer;

public class DisplayCondicoesAtuais implements Observer {
    private float temperatura;
    private float umidade;
    private float pressao;

    public void update(Observable o, Object arg) {
        if (o instanceof EstacaoMeteorologica) {
            EstacaoMeteorologica estacao = (EstacaoMeteorologica) o;
            this.temperatura = estacao.getTemperatura();
            this.umidade = estacao.getUmidade();
            this.pressao = estacao.getPressao();
        }
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