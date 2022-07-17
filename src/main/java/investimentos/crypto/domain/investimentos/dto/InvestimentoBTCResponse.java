package investimentos.crypto.domain.investimentos.dto;

import investimentos.crypto.calculadora.Conversor;
import investimentos.crypto.domain.investimentos.InvestimentoBTC;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class InvestimentoBTCResponse {

    private String totalInvestido;
    private String satochesAdiquiridos;
    private LocalDate dataDaOperacao;
    private String cotacaoDoDia;


    public InvestimentoBTCResponse obterTotalAdiquirido(InvestimentoBTC investimentoBTC) {
        Conversor conversor = new Conversor();
        dataDaOperacao = investimentoBTC.getMomentoDaTransacao();
        satochesAdiquiridos = String.format("%.8f",
                conversor.converterEmSatoches(
                        investimentoBTC.getCotacaoDoBitcoin(),
                        investimentoBTC.getValorInvestido()));
        totalInvestido = String.format("R$ %.2f", investimentoBTC.getValorInvestido());
        cotacaoDoDia = String.format("R$ %.2f", investimentoBTC.getCotacaoDoBitcoin());
        return this;
    }
}

