package br.com.cassioliveira.pequenocloset.controllers;

import br.com.cassioliveira.pequenocloset.enumerations.Estados;
import br.com.cassioliveira.pequenocloset.model.Cliente;
import br.com.cassioliveira.pequenocloset.services.ClienteService;
import br.com.cassioliveira.pequenocloset.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;

/**
 * Managed bean usado pela página de cadastro de consulta. É responsável por
 * ligar a classe de modelo Consulta à página de visualização processando as
 * solicitações do usuário e retornando os dados à visualização.
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Model
public class ClienteBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Cliente cliente;

    @Getter
    @Setter
    @Inject
    private ClienteService clienteService;

    @Getter
    @Setter
    private Cliente clienteSelecionado;

    @Getter
    private List<Cliente> clientes;

    private List<Estados> estados = new ArrayList<>();

    /**
     * Construtor da classe
     */
    public ClienteBean() {
        cliente = new Cliente();
        clienteSelecionado = new Cliente();
        estados = Arrays.asList(Estados.values());
    }

    @PostConstruct
    public void init() {
        this.clientes = clienteService.todos();

    }

    /**
     * Lista os estados da federação previamente cadastrados no banco.
     *
     * @return
     */
    public List<Estados> getEstados() {
        this.estados = clienteService.getEstados();
        return estados;
    }
    
    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo Cliente e salvar.
     *
     */
    public void salvar() {
        clienteService.salvar(cliente);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro de '" + cliente.getNome() + "' atualizado com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirecionaPara("listar-clientes.xhtml");
        cliente = new Cliente();
    }

    /**
     * Método responsável por excluir um objeto do tipo Cliente e exibir ao
     * final do processo uma mensagem informativa.
     *
     */
    public void excluir() {
        this.clienteService.deletar(clienteSelecionado);
        this.clientes = clienteService.todos();
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.cliente.getId() != null;
    }

}
