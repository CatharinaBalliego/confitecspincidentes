package br.com.confitecsp.java.web.bean;


import br.com.confitecsp.java.web.dao.GrupoDesignadoDao;
import br.com.confitecsp.java.web.model.GrupoDesignado;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class GrupoDesignadoBean implements Serializable{

    private static final long serialVersionUID = 2L;

    private GrupoDesignado grupoDesignado;
    private GrupoDesignadoDao grupoDesignadoDao;
    private List<GrupoDesignado> listarGrupos;

    @PostConstruct
    public void init(){
        grupoDesignadoDao = new GrupoDesignadoDao();
        grupoDesignado = new GrupoDesignado();

        try{
            listarGrupos = grupoDesignadoDao.listarTodos();

        }catch (Exception e){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }

    }

    public GrupoDesignado getGrupoDesignado() {return grupoDesignado;}
    public List<GrupoDesignado> getListarGrupos() {return listarGrupos;}


    //nao precisa de metodos para cadastro, atualização e exclusao


    public void selecionar(){

        try{
            grupoDesignado =  grupoDesignadoDao.selecionar(grupoDesignado.getCd_grupo());

        }catch (Exception e){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }
    }


}
