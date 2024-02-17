package com.barbosa.rinhabackend.service;

import com.barbosa.rinhabackend.domain.Cliente;
import com.barbosa.rinhabackend.domain.Transacao;
import com.barbosa.rinhabackend.domain.dto.*;
import com.barbosa.rinhabackend.exception.NoCompleteTransactionException;
import com.barbosa.rinhabackend.exception.ObjectNotFoundException;
import com.barbosa.rinhabackend.repository.ClienteRepository;
import com.barbosa.rinhabackend.repository.TransacaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;
    private final TransacaoRepository transacaoRepository;

    public ClienteService(ClienteRepository repository, TransacaoRepository transacaoRepository) {
        this.repository = repository;
        this.transacaoRepository = transacaoRepository;
    }


    public List<Cliente> getAllClientes() {
        return repository.findAll();
    }

    private Cliente getClienteId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Não encontrado " + id));
    }

    public ExtratoResponse getExtratoClienteId(Long id) {
        Cliente cliente = getClienteId(id);
        SaldoResponse saldoResponse = new SaldoResponse(cliente.getSaldo(), new Date(), cliente.getLimite());
        List<TransacaoResponse> transacoesClienteId = transacaoRepository.getTransacoesClienteId(id).stream()
                .map(transacao -> new TransacaoResponse(transacao.getValor(), transacao.getTipo(), transacao.getDescricao(), transacao.getData()))
                .toList();
        return new ExtratoResponse(saldoResponse, transacoesClienteId);
    }

    @Transactional
    public ClienteResponse addTransacaoCliente(Long id, TransacaoRequest transacaoRequest) {
        Cliente cliente = getClienteId(id);
        Transacao transacao = new Transacao();
        transacao.setData(new Date());
        transacao.setDescricao(transacaoRequest.descricao());
        transacao.setTipo(transacaoRequest.tipo());
        transacao.setValor(transacaoRequest.valor());
        transacao.setCliente(id);
        transacaoRepository.save(transacao);

        int novoSaldo = cliente.getSaldo() + transacaoRequest.valor();
        if (transacaoRequest.tipo().equals("d")) {
            novoSaldo = cliente.getSaldo() - transacaoRequest.valor();
            if (novoSaldo < (cliente.getLimite() * -1)) {
                throw new NoCompleteTransactionException("Sem saldo");
            }
        }
        repository.updateSaldoCliente(id, novoSaldo);

        return new ClienteResponse(cliente.getLimite(), novoSaldo);

    }
}
