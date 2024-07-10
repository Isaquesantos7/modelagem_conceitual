package com.isaquesantos7.modelagem_conceitual.services;

import com.isaquesantos7.modelagem_conceitual.model.Client;
import com.isaquesantos7.modelagem_conceitual.repositories.ClientRepository;
import com.isaquesantos7.modelagem_conceitual.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client find(Integer id) {

        return this.clientRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Object not found!")
        );
    }

    public List<Client> listAll() {

        return this.clientRepository.findAll();
    }

}
