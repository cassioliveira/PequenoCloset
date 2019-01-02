package br.com.cassioliveira.pequenocloset.repository;

import br.com.cassioliveira.pequenocloset.model.Cliente;
import java.io.Serializable;

/**
 * Classe que contém métodos específicos que podem ser usados para fornecer 
 * serviços relacionados à comunicação com o banco de dados. Essa classe, ainda, 
 * herda todos os métodos abstratos da classe.
 * 
 * @see DaoAbstrato
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class Clientes extends DaoAbstrato<Cliente> implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public Clientes() {
        super(Cliente.class);
    }
}
