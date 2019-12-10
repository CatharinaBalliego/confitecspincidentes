package br.com.confitecsp.java.web.bean;


import br.com.confitecsp.java.web.dao.MotivoAberturaDao;
import br.com.confitecsp.java.web.model.MotivoAbertura;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class MotivoAberturaBean implements Serializable {

    private static final long serialVersionUID = 2L;

    private MotivoAbertura motivoAbertura;
    private MotivoAberturaDao motivoAberturaDao;
    private List<MotivoAbertura> incidentesAbertos;

    @PostConstruct
    public void init(){
        motivoAberturaDao = new MotivoAberturaDao();
        motivoAbertura = new MotivoAbertura();


        try{
            incidentesAbertos = motivoAberturaDao.listarTodos();

        } catch (Exception e){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }
    }

    public MotivoAbertura getMotivoAbertura() {
        return motivoAbertura;
    }

    public List<MotivoAbertura> getIncidentesAbertos(){
        return incidentesAbertos;
    }

    public String cadastrar(){
        try{
            motivoAberturaDao.cadastrar(motivoAbertura);

            motivoAbertura = new MotivoAbertura(); // testar

            incidentesAbertos = motivoAberturaDao.listarTodos();

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Incidente cadastrado com sucesso"));
            context.getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }
        return "home";
    }

    public String atualizar() {
        try{
            motivoAberturaDao.atualizar(motivoAbertura);

            incidentesAbertos = motivoAberturaDao.listarTodos();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Incidente atualizado com sucesso"));
            context.getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }
        return "home";

    }

    public String excluir(){
        try{
            motivoAberturaDao.excluir(motivoAbertura.getCd_abertura());
            incidentesAbertos = motivoAberturaDao.listarTodos();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Incidente atualizado com sucesso"));
            context.getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }
        return "home";
    }

    public void selecionar(){
        try{
            motivoAbertura = motivoAberturaDao.selecionar(motivoAbertura.getCd_abertura());

            if (motivoAbertura == null || motivoAbertura.getCd_abertura() == 0){
                motivoAbertura = new MotivoAbertura();
                throw new Exception("Incidente nao encontrado");
            }
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(e.getMessage());
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
