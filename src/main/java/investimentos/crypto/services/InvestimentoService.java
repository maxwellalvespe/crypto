package investimentos.crypto.services;

import investimentos.crypto.domain.investimentos.dto.InvestimentoBTCRequest;
import investimentos.crypto.domain.investimentos.dto.InvestimentoBTCResponse;
import investimentos.crypto.domain.investimentos.entity.Investimento;
import investimentos.crypto.domain.investimentos.usecase.ConversorDeMoedas;
import investimentos.crypto.repository.InvestidorRepository;
import investimentos.crypto.repository.InvestimentoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class InvestimentoService {

    @Autowired
    private InvestimentoRepository investimentoRepository;

    @Autowired
    private InvestidorRepository investidorRepository;

    @Autowired
    private ConversorDeMoedas conversor;

    @Transactional
    public InvestimentoBTCResponse processarInvestimentoCrypto(InvestimentoBTCRequest btcRequest, String idInvestidor) {
        return getInvestimentoBTCResponse(btcRequest, idInvestidor);
    }

    private InvestimentoBTCResponse getInvestimentoBTCResponse(InvestimentoBTCRequest btcRequest, String idInvestidor) {
        InvestimentoBTCResponse response = new InvestimentoBTCResponse();

        Investimento invest = new Investimento();
        invest.setContacaoAtual(btcRequest.getContacaoAtual());
        invest.setValorDoInvestimento(btcRequest.getValorDoInvestimento());
        invest.setInvestidor(investidorRepository.findById(UUID.fromString(idInvestidor)).orElseThrow());
        invest.setQuantidadeAdiquirida(new ConversorDeMoedas().converterEmSatoches(btcRequest.getValorDoInvestimento(), btcRequest.getContacaoAtual()));
        invest.setTaxa(conversor.converterEmReal(btcRequest.getTaxaPagaEmSatoches(), btcRequest.getContacaoAtual()));
        invest.setQuantidadeTaxaPaga(btcRequest.getTaxaPagaEmSatoches());
        log.info("Iniciando persistencia no banco dade dados ..\n");
        var responseDb = investimentoRepository.save(invest);
        log.info("Processamento concluido com sucesso , gerado o registro : {} para transação", responseDb.getId());
        return response.obterTotalAdiquirido(btcRequest);
    }


    public List<InvestimentoBTCResponse> findAll() {
        return InvestimentoBTCResponse.convertToInvestimentoBTCResponse(investimentoRepository.findAll());
    }
}
