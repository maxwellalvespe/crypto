package investimentos.crypto.calculadora;

import lombok.Getter;
import lombok.experimental.UtilityClass;

@Getter
public class Conversor {

    public Double converterEmSatoches(Double cotacaoAtual ,Double valorInvestido){
        return valorInvestido / cotacaoAtual;
    }
}
