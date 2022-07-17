package investimentos.crypto.services;

import investimentos.crypto.domain.investimentos.InvestimentoBTC;
import investimentos.crypto.domain.investimentos.dto.InvestimentoBTCResponse;
import org.springframework.stereotype.Service;

@Service
public class InvestimentoService {
    public InvestimentoBTCResponse processarArquisicao(InvestimentoBTC investimentoBTC) {
        InvestimentoBTCResponse response = new InvestimentoBTCResponse();
        return response.obterTotalAdiquirido(investimentoBTC);
    }
}
