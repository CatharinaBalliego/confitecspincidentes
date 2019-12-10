package br.com.confitecsp.java.web.bean;

import br.com.confitecsp.java.web.dao.MotivoEncerramentoDao;
import br.com.confitecsp.java.web.model.MotivoEncerramento;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;


@ManagedBean
@ViewScoped
public class MotivoEncerramentoBean implements Serializable {

    private static final long serialVersionUID = 2L;

    private MotivoEncerramento motivoEncerramento;
    private MotivoEncerramentoDao motivoEncerramentoDao;
    private List<MotivoEncerramento> incidentesFechados;

    @PostConstruct
    public void init(){
        motivoEncerramentoDao = new MotivoEncerramentoDao();
        motivoEncerramento = new MotivoEncerramento();

        try{
            incidentesFechados = motivoEncerramentoDao.listarTodos();
        } catch (Exception e){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }
    }

    public MotivoEncerramento getMotivoEncerramento() {
        return motivoEncerramento;
    }

    public List<MotivoEncerramento> getIncidentes(){
        return incidentesFechados;
    }

    public String cadastrar(){
        try{
            motivoEncerramentoDao.cadastrar(motivoEncerramento);

            incidentesFechados = motivoEncerramentoDao.listarTodos();
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
            motivoEncerramentoDao.atualizar(motivoEncerramento);

            incidentesFechados = motivoEncerramentoDao.listarTodos();
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
            motivoEncerramentoDao.excluir(motivoEncerramento.getCd_encerramento());
            incidentesFechados = motivoEncerramentoDao.listarTodos();
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
            motivoEncerramento = motivoEncerramentoDao.selecionar(motivoEncerramento.getCd_encerramento());

            if (motivoEncerramento == null || motivoEncerramento.getCd_encerramento() == 0){
                motivoEncerramento = new MotivoEncerramento();
                throw new Exception("Incidente nao encontrado");
            }
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(e.getMessage());
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
