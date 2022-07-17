package investimentos.crypto.services;

import investimentos.crypto.domain.investimentos.dto.InvestimentoBTCRequest;
import investimentos.crypto.domain.investimentos.dto.InvestimentoBTCResponse;
import org.springframework.stereotype.Service;

@Service
public class InvestimentoService {
    public InvestimentoBTCResponse processarArquisicao(InvestimentoBTCRequest investimentoBTC) {
        InvestimentoBTCResponse response = new InvestimentoBTCResponse();
        return response.obterTotalAdiquirido(investimentoBTC);
    }
}
