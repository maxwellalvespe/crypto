package investimentos.crypto.services;

import investimentos.crypto.domain.investimentos.dto.InvestimentoBTCRequest;
import investimentos.crypto.domain.investimentos.dto.InvestimentoBTCResponse;
import investimentos.crypto.domain.investimentos.entity.Investimento;
import investimentos.crypto.domain.investimentos.usecase.Conversor;
import investimentos.crypto.repository.InvestidorRepository;
import investimentos.crypto.repository.InvestimentoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class InvestimentoService {

    @Autowired
    private InvestimentoRepository investimentoRepository;

    @Autowired
    private InvestidorRepository investidorRepository;

    public InvestimentoBTCResponse processarInvestimentoCrypto(InvestimentoBTCRequest btcRequest,String idInvestidor) {
        InvestimentoBTCResponse response = new InvestimentoBTCResponse();

        Investimento invest = new Investimento();
        invest.setCotacaoDoBitcoin(btcRequest.getCotacaoDoBitcoin());
        invest.setValorInvestido(btcRequest.getValorInvestido());
        invest.setInvestidor(investidorRepository.findById(UUID.fromString(idInvestidor)).orElseThrow());
        invest.setSatochesAdiquiridos(new Conversor().converterEmSatoches(btcRequest.getCotacaoDoBitcoin(), btcRequest.getValorInvestido()));

        log.info("Iniciando persistencia no banco dade dados ..");
        var responseDb = investimentoRepository.save(invest);
        log.info("Processamento concluido com sucesso , gerado o registro : {} para transação",responseDb.getId());
        return response.obterTotalAdiquirido(btcRequest);
    }
}
