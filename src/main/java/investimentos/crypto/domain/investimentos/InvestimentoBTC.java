package investimentos.crypto.domain.investimentos;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Builder
@Getter
@ToString
public class InvestimentoBTC {

    private Double cotacaoDoBitcoin;
    private Double valorInvestido;
    private final LocalDate momentoDaTransacao = LocalDate.now();

}
