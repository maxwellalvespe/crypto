package investimentos.crypto.domain.investimentos.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Builder
@Getter
@ToString
public class InvestimentoBTCRequest {

    private Double cotacaoDoBitcoin;
    private Double valorInvestido;
    private final LocalDate momentoDaTransacao = LocalDate.now();

}
