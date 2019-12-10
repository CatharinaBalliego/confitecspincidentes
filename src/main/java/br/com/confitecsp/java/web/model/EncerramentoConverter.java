package br.com.confitecsp.java.web.model;

import br.com.confitecsp.java.web.bean.JpaResourceBean;
import br.com.confitecsp.java.web.dao.MotivoEncerramentoDao;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import java.lang.reflect.Field;
import java.util.Collection;


@FacesConverter("encerramentoConverter")
public class EncerramentoConverter  implements Converter {

    MotivoEncerramento motivoEncerramento;
    MotivoEncerramentoDao motivoEncerramentoDao;

    public EncerramentoConverter(){

    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

        try {
            Long id = Long.valueOf(value);
            MotivoEncerramento incidenteFechado;
            EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

            incidenteFechado = em.find(MotivoEncerramento.class, id);

          return incidenteFechado;
        } catch (Exception ex) {
            throw new ConverterException("Não foi possível aplicar conversão de item com valor [" + value
                    + "] no componente [" + uic.getId() + "]", ex);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String id = ((Object) value).toString();
        String codigo = id.replaceAll("[^0-9]","");
        return codigo;
        // return getIdByReflection(value).toString();
    }

//    private Object findById(Collection collection, Long idToFind) {
//        for (Object obj : collection) {
//            Long id = getIdByReflection(obj);
//            if (id == idToFind)
//                return obj;
//        }
//        return null;
//    }

//    private Long getIdByReflection(Object bean) {
//        try {
//            Field idField = bean.getClass().getDeclaredField("cd_encerramento");
//            idField.setAccessible(true);
//            return (Long) Long.valueOf(idField.get(bean).toString());
//        } catch (Exception ex) {
//            throw new RuntimeException("Não foi possível obter a propriedade 'equipeId' do item", ex);
//        }
//    }


}
