package investimentos.crypto.domain.investimentos.usecase;

import lombok.Getter;

@Getter
public class Conversor {

    public Double converterEmSatoches(Double cotacaoAtual ,Double valorInvestido){
        return valorInvestido / cotacaoAtual;
    }
}
