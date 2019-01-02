package br.com.cassioliveira.pequenocloset.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author cassio
 */
@Data
@Entity
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "hora")
    private Date hora;

    @Column(name = "forma_pagamento", length = 30)
    private String formaPagamento;

    @Column(name = "valor")
    private BigDecimal valor;

//    private List<Cliente> clientes;
//
//    private List<Produto> itens;

}
