package com.barbosa.rinhabackend.controller;

import com.barbosa.rinhabackend.domain.Cliente;
import com.barbosa.rinhabackend.domain.dto.ClienteResponse;
import com.barbosa.rinhabackend.domain.dto.ExtratoResponse;
import com.barbosa.rinhabackend.domain.dto.TransacaoRequest;
import com.barbosa.rinhabackend.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping("/{id}/extrato")
    public ExtratoResponse getExtratoClienteId(@PathVariable("id") Long id){
        return service.getExtratoClienteId(id);
    }

    @PostMapping("/{id}/transacoes")
    public ClienteResponse addTransacaoCliente(@PathVariable("id") Long id, @Valid @RequestBody TransacaoRequest transacaoRequest){
        return service.addTransacaoCliente(id, transacaoRequest);
    }


}
