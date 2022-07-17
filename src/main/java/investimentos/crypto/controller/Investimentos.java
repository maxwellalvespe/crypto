package investimentos.crypto.controller;

import investimentos.crypto.domain.investimentos.dto.InvestimentoBTCRequest;
import investimentos.crypto.domain.investimentos.dto.InvestimentoBTCResponse;
import investimentos.crypto.services.InvestimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("investimentos")
public class Investimentos {

    @Autowired
    InvestimentoService investimentoService;

    @PostMapping
    public ResponseEntity<InvestimentoBTCResponse> obterTotalDeBitcoinsObtidosNaTransacao(@RequestBody InvestimentoBTCRequest investimentoBTC){
        return  ResponseEntity.ok(investimentoService.processarArquisicao(investimentoBTC));
    }
}
