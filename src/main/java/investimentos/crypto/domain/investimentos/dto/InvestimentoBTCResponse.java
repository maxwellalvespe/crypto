package investimentos.crypto.domain.investimentos.dto;

import investimentos.crypto.domain.investimentos.entity.Investimento;
import investimentos.crypto.domain.investimentos.usecase.ConversorDeMoedas;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvestimentoBTCResponse {

    private String totalInvestido;
    private String satochesAdiquiridos;
    private LocalDate dataDaOperacao;
    private String cotacaoDoDia;

    private String idInvestidor;

    private String nomeInvestidor;


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

    public static List<InvestimentoBTCResponse> convertToInvestimentoBTCResponse(List<Investimento> investimento){
    return  investimento.stream()
            .map(i -> {
                var request = InvestimentoBTCRequest.builder()
                        .contacaoAtual(i.getContacaoAtual())
                        .valorDoInvestimento(i.getValorDoInvestimento())
                        .dataDaCompra(i.getMomentoDaTransacao().toLocalDate())
                        .quantidadeAdiquirida(i.getQuantidadeAdiquirida().toString())
                        .build();

                ConversorDeMoedas conversor = new ConversorDeMoedas();
                return InvestimentoBTCResponse.builder()
                        .cotacaoDoDia(String.format("R$ %.2f", request.getContacaoAtual()))
                        .dataDaOperacao( request.getMomentoDaTransacao())
                        .totalInvestido(String.format("R$ %.2f", request.getValorDoInvestimento()))
                        .idInvestidor(i.getInvestidor().getId().toString())
                        .nomeInvestidor(i.getInvestidor().getNome().toUpperCase())
                        .satochesAdiquiridos(String.format("%.8f",
                                conversor.converterEmSatoches(
                                        request.getContacaoAtual(),
                                        request.getValorDoInvestimento())))
                        .build();
            })
            .collect(Collectors.toList());
    }
}

