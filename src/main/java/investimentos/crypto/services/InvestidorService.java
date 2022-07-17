package investimentos.crypto.services;

import investimentos.crypto.domain.Investidor;
import investimentos.crypto.domain.investimentos.entity.Investimento;
import investimentos.crypto.repository.InvestidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestidorService {

    @Autowired
    private InvestidorRepository investidorRepository;

    public String cadastrarInvestidor(Investidor investidor){
        var response = investidorRepository.save(investidor);
        return  response.getId().toString();
    }
}
