package com.barbosa.rinhabackend.repository;

import com.barbosa.rinhabackend.domain.Cliente;
import com.barbosa.rinhabackend.domain.dto.ClienteResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    @Query("SELECT new com.barbosa.rinhabackend.domain.dto.ClienteResponse(c.limite, c.saldo) FROM Cliente c WHERE c.id = :clienteId")
    Optional<ClienteResponse> buscaCliente(@Param("clienteId") Long clienteId);

    @Modifying
    @Query(value = "UPDATE Clientes SET saldo = :novoSaldo WHERE id = :clienteId", nativeQuery = true)
    void updateSaldoCliente(@Param("clienteId") Long clienteId, @Param("novoSaldo") int novoSaldo);
}
