package br.com.cassioliveira.pequenocloset.converters;

import br.com.cassioliveira.pequenocloset.exceptions.NegocioException;
import br.com.cassioliveira.pequenocloset.model.Produto;
import br.com.cassioliveira.pequenocloset.services.ProdutoService;
import br.com.cassioliveira.pequenocloset.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@FacesConverter(forClass = Produto.class)
public class ProdutoConverter implements Converter {

    private final ProdutoService produtoServico;

    public ProdutoConverter() throws NegocioException {
        this.produtoServico = CDIServiceLocator.getBean(ProdutoService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Produto objectToReturn = null;
        if (value != null) {
            objectToReturn = this.produtoServico.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Long code = ((Produto) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }

}
