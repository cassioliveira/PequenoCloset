package br.com.cassioliveira.pequenocloset.services;

import br.com.cassioliveira.pequenocloset.enumerations.Estados;
import br.com.cassioliveira.pequenocloset.model.Cliente;
import br.com.cassioliveira.pequenocloset.repository.Clientes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import lombok.Getter;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class ClienteService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Clientes clientes;

    @Getter
    private List<Estados> estados;

    public ClienteService() {
        estados = new ArrayList<>();
        estados = Arrays.asList(Estados.values());
    }

    @Transactional
    public void salvar(Cliente cliente) {
        if (cliente.getId() == null) {
            cliente.setCadastro(new Date());
        }
        this.clientes.save(cliente);
    }

    @Transactional
    public void deletar(Cliente cliente) {
        clientes.delete(findById(cliente.getId()));
    }

    public Cliente findById(Long id) {
        return clientes.porId(id);
    }

    public List<Cliente> todos() {
        return clientes.todos();
    }

}
