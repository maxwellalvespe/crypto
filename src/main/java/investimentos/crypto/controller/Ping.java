package investimentos.crypto.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping
public class Ping {

    private final String RESOURCE_PING = "/ping";

    @GetMapping(path = RESOURCE_PING, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> ping() {
        var status = new HashMap<String, String>();
        status.put("RESOURCE", "ping");
        status.put("SERVER", "ON");
        return ResponseEntity.ok(status);
    }
}
