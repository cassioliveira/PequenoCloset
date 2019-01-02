package br.com.cassioliveira.pequenocloset.converters;

import br.com.cassioliveira.pequenocloset.exceptions.NegocioException;
import br.com.cassioliveira.pequenocloset.model.Cliente;
import br.com.cassioliveira.pequenocloset.services.ClienteService;
import br.com.cassioliveira.pequenocloset.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter {

    private final ClienteService clienteServico;

    public ClienteConverter() throws NegocioException {
        this.clienteServico = CDIServiceLocator.getBean(ClienteService.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Cliente objectToReturn = null;

        if (value != null) {
            objectToReturn = this.clienteServico.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Long code = ((Cliente) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }

}
