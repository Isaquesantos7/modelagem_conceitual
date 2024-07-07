package com.isaquesantos7.modelagem_conceitual.resources;

import com.isaquesantos7.modelagem_conceitual.model.Client;
import com.isaquesantos7.modelagem_conceitual.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientResource {

    @Autowired
    private ClientService clientService;

    @GetMapping("/api/clientes/{id}")
    public ResponseEntity<Client> findById(@PathVariable(value = "id") Integer id) {
        Client client = this.clientService.find(id);

        return ResponseEntity.status(HttpStatus.OK).body(client);
    }
}
