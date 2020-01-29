package br.com.confitecsp.java.web.model;

import br.com.confitecsp.java.web.bean.JpaResourceBean;
import br.com.confitecsp.java.web.dao.GrupoDesignadoDao;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

@FacesConverter("grupoConverter")
public class GrupoConverter implements Converter {

    GrupoDesignado grupoDesignado;
    GrupoDesignadoDao grupoDesignadoDao;

    public GrupoConverter() {

    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        try {
            Long id = Long.valueOf(value);
            GrupoDesignado grupoDesignado;
            EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

            grupoDesignado = em.find(GrupoDesignado.class, id);
            return grupoDesignado;
        } catch (Exception e) {
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
