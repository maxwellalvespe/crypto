package investimentos.crypto.controller;

import investimentos.crypto.domain.investimentos.dto.InvestimentoBTCRequest;
import investimentos.crypto.domain.investimentos.dto.InvestimentoBTCResponse;
import investimentos.crypto.domain.investimentos.entity.Investimento;
import investimentos.crypto.services.InvestimentoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static investimentos.crypto.AppConstants.BASE_URL;
import static investimentos.crypto.AppConstants.INVESTIMENTOS;

@Slf4j
@RestController
@RequestMapping(BASE_URL)
public class InvestimentosController {

    @Autowired
    InvestimentoService investimentoService;

    @PostMapping(path = "{idInvestidor}/"+INVESTIMENTOS)
    public ResponseEntity<InvestimentoBTCResponse> obterTotalDeBitcoinsObtidosNaTransacao(@PathVariable String idInvestidor,
                                                                                          @RequestBody InvestimentoBTCRequest investimentoBTC){
        log.info("id obtido no path == {}",idInvestidor);
        return  ResponseEntity.ok(investimentoService.processarInvestimentoCrypto(investimentoBTC,idInvestidor));
    }

    @GetMapping(path = INVESTIMENTOS)
    public ResponseEntity<List<InvestimentoBTCResponse>> findAll(){
        return ResponseEntity.ok(investimentoService.findAll());
    }

}
