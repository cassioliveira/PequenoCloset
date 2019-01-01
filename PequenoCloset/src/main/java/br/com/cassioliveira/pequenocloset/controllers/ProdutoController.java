package br.com.cassioliveira.pequenocloset.controllers;

import br.com.cassioliveira.pequenocloset.util.jsf.FacesUtil;
import br.com.cassioliveira.pequenocloset.model.Produto;
import br.com.cassioliveira.pequenocloset.services.ProdutoService;
import java.io.Serializable;
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
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Model
public class ProdutoController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Produto produto;

    @Getter
    @Setter
    @Inject
    private ProdutoService produtoService;

    @Getter
    @Setter
    private Produto produtoSelecionado;

    @Getter
    private List<Produto> produtos;

    public ProdutoController() {
        produto = new Produto();
        produtoSelecionado = new Produto();
    }

    @PostConstruct
    public void init() {
        this.produtos = produtoService.findAll();
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo Produto e salvar.
     *
     */
    public void salvar() {
        produtoService.salvar(produto);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro de '" + produto.getDescricao()+ "' atualizado com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirecionaPara("listar-produtos.xhtml");
        produto = new Produto();
    }

    /**
     * Método responsável por excluir um objeto do tipo Produto e exibir ao final
     * do processo uma mensagem informativa.
     *
     */
    public void excluir() {
        this.produtoService.deletar(produtoSelecionado);
        this.produtos = produtoService.findAll();
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return produto.getId() == null;
    }

}
