package investimentos.crypto.domain.investimentos.usecase;

import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ConversorDeMoedas {

    public Double converterEmSatoches(Double valorInvestido, Double cotacaoAtual) {
        return valorInvestido / cotacaoAtual;
    }

    public Double converterEmReal(double quantidadeDeSatoches, Double cotacaoAtual) {
        return quantidadeDeSatoches * cotacaoAtual;
    }

}
