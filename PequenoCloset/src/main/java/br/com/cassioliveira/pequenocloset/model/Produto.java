package br.com.cassioliveira.pequenocloset.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author cassio
 */
@Data
@Entity
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cadastro")
    private Date cadastro;

    @NotNull(message = "A descrição do produto deve ser informada")
    @Column(name = "descricao", length = 50)
    private String descricao;

    @Column(name = "unidade", length = 30)
    private String unidade;

    @Column(name = "categoria", length = 30)
    private String categoria;

    @Column(name = "valor")
    private BigDecimal valor;

    @Temporal(TemporalType.DATE)
    @Column(name = "validade")
    private Date validade;

}
