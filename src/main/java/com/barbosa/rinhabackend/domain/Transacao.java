package com.barbosa.rinhabackend.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**
 * A Transacao.
 */
@Entity
@Table(name = "transacoes")
public class Transacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transacoes_seq")
    @SequenceGenerator(name = "transacoes_seq", sequenceName = "transacoes_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    private Integer valor;

    private Date data;

    private String tipo;

    private String descricao;

    @Column(name = "cliente_id")
    private Long cliente;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getValor() {
        return this.valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

}
