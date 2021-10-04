package br.com.zupacademy.dmagliano.casadocodigo.controller;

import br.com.zupacademy.dmagliano.casadocodigo.controller.dto.ClienteForm;
import br.com.zupacademy.dmagliano.casadocodigo.model.Cliente;
import br.com.zupacademy.dmagliano.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.dmagliano.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.dmagliano.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    PaisRepository paisRepository;
    @Autowired
    EstadoRepository estadoRepository;

    @PostMapping
    @RequestMapping("/clientes")
    public ResponseEntity cadastra(@RequestBody @Valid ClienteForm clienteForm) {
        Cliente cliente = Cliente.toEntity(clienteForm, paisRepository, estadoRepository);
        clienteRepository.save(cliente);
        return ResponseEntity.ok("Cliente criado com id: " + cliente.getId().toString());
    }


}
