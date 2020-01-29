package br.com.confitecsp.java.web.model;

import br.com.confitecsp.java.web.bean.JpaResourceBean;
import br.com.confitecsp.java.web.dao.EmailUsuarioDao;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

@FacesConverter("emailConverter")
public class EmailConverter implements Converter{
    EmailUsuario emailUsuario;
    EmailUsuarioDao emailUsuarioDao;

    public EmailConverter(){

    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        try {
            Long id = Long.valueOf(value);
            EmailUsuario emailUsuario;
            EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

            emailUsuario = em.find(EmailUsuario.class, id);
            return emailUsuario;

        }catch (Exception e){
            throw new ConverterException("Não foi possível aplicar conversão de item com valor [" + value
                    + "] no componente [" + uic.getId() + "]", e);
        }


    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String id = ((Object) value).toString();
        String codigo = id.replaceAll("[^0-9]", "");
        return codigo;
    }
}
