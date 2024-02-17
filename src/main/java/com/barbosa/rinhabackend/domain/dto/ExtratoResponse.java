package com.barbosa.rinhabackend.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public record ExtratoResponse(SaldoResponse saldo, @JsonProperty("ultimas_transacoes") List<TransacaoResponse> ultimasTransacoes) {
}
