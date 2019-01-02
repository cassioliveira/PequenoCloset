package br.com.cassioliveira.pequenocloset.services;

import br.com.cassioliveira.pequenocloset.repository.Produtos;
import br.com.cassioliveira.pequenocloset.model.Produto;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class ProdutoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Produtos produtos;

    @Transactional
    public void salvar(Produto produto) {
        produto.setCadastro(new Date());
        this.produtos.save(produto);
    }

    @Transactional
    public void deletar(Produto produto) {
        produtos.delete(findById(produto.getId()));
    }

    public Produto findById(Long id) {
        return produtos.porId(id);
    }

    public List<Produto> findAll() {
        return produtos.todos();
    }
}
