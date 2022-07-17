package investimentos.crypto.controller;

import investimentos.crypto.domain.investimentos.InvestimentoBTC;
import investimentos.crypto.domain.investimentos.dto.InvestimentoBTCResponse;
import investimentos.crypto.services.InvestimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequestMapping("investimentos")
public class Investimentos {

    @Autowired
    InvestimentoService investimentoService;

    @PostMapping
    public ResponseEntity<InvestimentoBTCResponse> obterTotalDeBitcoinsObtidosNaTransacao(@RequestBody InvestimentoBTC investimentoBTC){
        return  ResponseEntity.ok(investimentoService.processarArquisicao(investimentoBTC));
    }
}
