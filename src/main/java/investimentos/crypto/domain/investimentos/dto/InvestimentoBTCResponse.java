package investimentos.crypto.domain.investimentos.dto;

import investimentos.crypto.domain.investimentos.usecase.ConversorDeMoedas;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class InvestimentoBTCResponse {

    private String totalInvestido;
    private String satochesAdiquiridos;
    private LocalDate dataDaOperacao;
    private String cotacaoDoDia;


    public InvestimentoBTCResponse obterTotalAdiquirido(InvestimentoBTCRequest investimentoBTC) {
        ConversorDeMoedas conversor = new ConversorDeMoedas();
        dataDaOperacao = investimentoBTC.getMomentoDaTransacao();
        satochesAdiquiridos = String.format("%.8f",
                conversor.converterEmSatoches(
                        investimentoBTC.getContacaoAtual(),
                        investimentoBTC.getValorDoInvestimento()));
        totalInvestido = String.format("R$ %.2f", investimentoBTC.getValorDoInvestimento());
        cotacaoDoDia = String.format("R$ %.2f", investimentoBTC.getContacaoAtual());
        return this;
    }
}

