package br.com.confitecsp.java.web.model;

import br.com.confitecsp.java.web.bean.JpaResourceBean;
import br.com.confitecsp.java.web.bean.MotivoAberturaBean;
import br.com.confitecsp.java.web.dao.MotivoAberturaDao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
@ManagedBean
@SessionScoped
@FacesConverter("aberturaConverter")
public class AberturaConverter implements Converter {

    private MotivoAberturaBean motivoAberturaBean;
    private MotivoAbertura motivoAbertura;
    private MotivoAberturaDao motivoAberturaDao;



    public AberturaConverter(){
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

        try {
            Long id = Long.valueOf(value);
            System.out.println(id);

            MotivoAbertura incidenteAberto;
            EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();
            incidenteAberto = em.find(MotivoAbertura.class, id);
            System.out.println(incidenteAberto);
            return  incidenteAberto;


//            motivoAbertura = motivoAberturaDao.selecionar(motivoAbertura.getCd_abertura());
////            motivoAbertura = motivoAberturaDao.selecionar(id);
//            System.out.println("teste");
//            return motivoAbertura;
//
//
//            Collection items = (Collection) uic.getAttributes().get("items");
//            return findById(items, id);
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
    }
//        if (value == null)
//            return "";
//        return ((Long) value).toString();


//    private Object findById(Collection collection, Long idToFind) {
//        for (Object obj : collection) {
//            Long id = getIdByReflection(obj);
//            if (id == idToFind)
//                return obj;
//        }
//        return null;
//    }

    private Long getIdByReflection(Object bean) {
        try {
            Field idField = bean.getClass().getDeclaredField("cd_abertura");
            idField.setAccessible(true);
            return (Long) Long.valueOf(idField.get(bean).toString());
        } catch (Exception ex) {
            throw new RuntimeException("Não foi possível obter a propriedade 'equipeId' do item", ex);
        }
    }

}