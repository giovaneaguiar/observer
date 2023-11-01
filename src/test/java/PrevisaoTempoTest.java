import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrevisaoTempoTest {
    private EstacaoMeteorologica estacao;
    private DisplayCondicoesAtuais display;

    @BeforeEach
    void setUp() {
        estacao = new EstacaoMeteorologica();
        display = new DisplayCondicoesAtuais();
        estacao.addObserver(display);
    }

    @Test
    void testAtualizacaoDeCondicoesAtuais() {
        estacao.setMedicoes(28.5f, 65, 1013.2f);
        assertEquals(28.5f, display.getTemperatura());
        assertEquals(65, display.getUmidade());
        assertEquals(1013.2f, display.getPressao());

        estacao.setMedicoes(27.8f, 63, 1012.8f);
        assertEquals(27.8f, display.getTemperatura());
        assertEquals(63, display.getUmidade());
        assertEquals(1012.8f, display.getPressao());
    }

    @Test
    void testAtualizacaoMultipla() {
        estacao.setMedicoes(28.5f, 65, 1013.2f);
        estacao.setMedicoes(30.0f, 70, 1012.0f);
        assertEquals(30.0f, display.getTemperatura());
        assertEquals(70, display.getUmidade());
        assertEquals(1012.0f, display.getPressao());
    }

    @Test
    void testNotificacaoSemAlteracoes() {
        estacao.setMedicoes(28.5f, 65, 1013.2f);
        estacao.setMedicoes(28.5f, 65, 1013.2f);
        assertEquals(28.5f, display.getTemperatura());
        assertEquals(65, display.getUmidade());
        assertEquals(1013.2f, display.getPressao());
    }

    @Test
    void testMultiplosObservadores() {
        DisplayCondicoesAtuais display2 = new DisplayCondicoesAtuais();
        estacao.addObserver(display2);

        estacao.setMedicoes(28.5f, 65, 1013.2f);
        assertEquals(28.5f, display.getTemperatura());
        assertEquals(65, display.getUmidade());
        assertEquals(1013.2f, display.getPressao());

        assertEquals(28.5f, display2.getTemperatura());
        assertEquals(65, display2.getUmidade());
        assertEquals(1013.2f, display2.getPressao());
    }
}
