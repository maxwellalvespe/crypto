package investimentos.crypto.domain.investimentos.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Builder
@Getter
@ToString
public class InvestimentoBTCRequest {

    private Double contacaoAtual;
    private Double valorDoInvestimento;
    private String quantidadeAdiquirida;
    private double taxaPagaEmSatoches;
    private LocalDate dataDaCompra;
    private final LocalDate momentoDaTransacao = LocalDate.now();

}
