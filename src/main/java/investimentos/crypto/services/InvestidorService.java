package investimentos.crypto.services;

import investimentos.crypto.domain.Investidor;
import investimentos.crypto.repository.InvestidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestidorService {

    @Autowired
    private InvestidorRepository investidorRepository;

    public String cadastrarInvestidor(Investidor investidor){
        var response = investidorRepository.save(investidor);
        return  response.getId().toString();
    }

    public List<Investidor> findAll() {
        return  investidorRepository.findAll();
    }
}
