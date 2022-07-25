package investimentos.crypto.domain.investimentos.entity;

import investimentos.crypto.domain.Investidor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Investimento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "cotacao_bitcoin", nullable = false)
    private Double contacaoAtual;

    @Column(name = "valor_investido", nullable = false)
    private Double valorDoInvestimento;

    @Column(name = "satoches_adiquiridos", nullable = false)
    private Double quantidadeAdiquirida;

    @Column(name = "taxa")
    private Double taxa;

    @Column(name = "quantidade_taxa" )
    private Double quantidadeTaxaPaga;

    @Column(name = "data_da_compra")
    private  LocalDateTime dataDaCompra;

    @Column(name = "data", nullable = false)
    private final LocalDateTime momentoDaTransacao = LocalDateTime.now();

    @ManyToOne
    private Investidor investidor;


}
