package investimentos.crypto.controller;

import investimentos.crypto.AppConstants;
import investimentos.crypto.domain.Investidor;
import investimentos.crypto.services.InvestidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(AppConstants.BASE_URL+AppConstants.INVESTIDORES)
public class InvestidorController {


    @Autowired
    private InvestidorService investidorService;

    @PostMapping
    public ResponseEntity<String> cadastrarInvestidor(@RequestBody Investidor investidor) {
        var response = investidorService.cadastrarInvestidor(investidor);
        return ResponseEntity.created(URI.create(AppConstants.BASE_URL.concat(AppConstants.INVESTIDORES) + "/" + response)).body(response);
    }

    @GetMapping
    public ResponseEntity<List<Investidor>> listarInvestidores(){
       return ResponseEntity.ok(investidorService.findAll());
    }
}
