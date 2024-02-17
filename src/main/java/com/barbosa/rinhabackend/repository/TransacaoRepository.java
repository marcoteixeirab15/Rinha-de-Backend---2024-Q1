package com.barbosa.rinhabackend.repository;

import com.barbosa.rinhabackend.domain.Cliente;
import com.barbosa.rinhabackend.domain.Transacao;
import com.barbosa.rinhabackend.domain.dto.TransacaoResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Arrays;
import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    @Query(value = "SELECT t.id, t.valor, t.tipo, t.descricao, t.data, t.cliente_id  FROM Transacoes t where t.cliente_id = :clienteId order by t.id desc limit 10", nativeQuery = true)
    List<Transacao> getTransacoesClienteId(@Param("clienteId") Long clienteId);

}
