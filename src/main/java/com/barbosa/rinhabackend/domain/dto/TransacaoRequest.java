package com.barbosa.rinhabackend.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public record TransacaoRequest(@NotNull @Positive Integer valor, @NotBlank @Length(max = 1) @Pattern(regexp = "[cd]") String tipo, @NotBlank @Length(max = 10) String descricao) {
}
