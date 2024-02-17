package com.barbosa.rinhabackend.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record TransacaoResponse(Integer valor, String tipo, String descricao, @JsonProperty("realizada_em") Date realizadaEm) {
}
