package br.com.cassioliveira.pequenocloset.repository;

import br.com.cassioliveira.pequenocloset.model.Produto;
import java.io.Serializable;

/**
 * Classe que contém métodos específicos que podem ser usados para fornecer
 * serviços relacionados à comunicação com o banco de dados. Essa classe, ainda,
 * herda todos os métodos abstratos da classe.
 *
 * @see DaoAbstrato
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class Produtos extends Generic<Produto> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Produtos() {
        super(Produto.class);
    }
}
