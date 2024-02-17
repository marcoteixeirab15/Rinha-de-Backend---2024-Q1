package com.barbosa.rinhabackend.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record SaldoResponse(Integer total, @JsonProperty("data_extrato") Date dataExtrato, Integer limite) {
}
