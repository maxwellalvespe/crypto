package investimentos.crypto.domain.investimentos.usecase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConversorTest {

    private final double COTACAO_ATUAL = 125000.00d;
    private final double VALOR_INVESTIDO = 250.00d;
    private final double VALOR_ESPERADO = 0.00200000;
    ConversorDeMoedas conversor;

    @BeforeEach
    void setup() {
        conversor = new ConversorDeMoedas();
    }

    @Test
    void deveRealizarAConversaoDeReaisEmFracoesDeCrypto() {

        var conversorDireto = VALOR_INVESTIDO / COTACAO_ATUAL;
        var quantidadeDeSatoches = conversor.converterEmSatoches(VALOR_INVESTIDO, COTACAO_ATUAL);
        Assertions.assertEquals(formatoDefault(VALOR_ESPERADO), formatoDefault(quantidadeDeSatoches));
        Assertions.assertEquals(formatoDefault(VALOR_ESPERADO), formatoDefault(conversorDireto));
    }

    @Test
    void deveRealizarAConversaoDosSatochesEmRealReferenteATaxaDeTransacao() {
        Assertions.assertEquals(VALOR_INVESTIDO, conversor.converterEmReal(VALOR_ESPERADO, COTACAO_ATUAL));
    }

    private String formatoDefault(Double value){
        return  String.format("%.8f", value);
    }
}
