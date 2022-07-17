package investimentos.crypto.controller;

import investimentos.crypto.AppConstants;
import investimentos.crypto.domain.Investidor;
import investimentos.crypto.services.InvestidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(AppConstants.BASE_URL)
public class InvestidorController {


    @Autowired
    private InvestidorService investidorService;

    @PostMapping(path = AppConstants.INVESTIDORES)
    public ResponseEntity<String> cadastrarInvestidor(@RequestBody Investidor investidor) {
        var response = investidorService.cadastrarInvestidor(investidor);
        return ResponseEntity.created(URI.create(AppConstants.BASE_URL.concat(AppConstants.INVESTIDORES) + "/" + response)).body(response);
    }
}
