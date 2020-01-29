package br.com.confitecsp.java.web.bean;


import br.com.confitecsp.java.web.dao.ClassificacaoDao;
import br.com.confitecsp.java.web.model.Classificacao;
import br.com.confitecsp.java.web.model.MotivoAbertura;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@ManagedBean
@ViewScoped
public class ClassificacaoBean implements Serializable {

    private static final long serialVersionUID = 2L;

    private Classificacao classificacao;
    private ClassificacaoDao classificacaoDao;
    private List<Classificacao> incidentes;

    @PostConstruct
    public void init(){
        classificacaoDao = new ClassificacaoDao();
        classificacao = new Classificacao();

        try{
            incidentes = classificacaoDao.listarTodos();
        } catch (Exception e){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public List<Classificacao> getIncidentes(){
        return incidentes;
    }

    public String cadastrar(){
        try{
            classificacao.setData_cadastro(LocalDateTime.now());
            classificacaoDao.cadastrar(classificacao);

            incidentes = classificacaoDao.listarTodos();
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
        classificacaoDao.atualizar(classificacao);

        incidentes = classificacaoDao.listarTodos();
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
            classificacaoDao.excluir(classificacao.getCd_incidente());
            incidentes = classificacaoDao.listarTodos();
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
            classificacao = classificacaoDao.selecionar(classificacao.getCd_incidente());

            if (classificacao == null || classificacao.getCd_incidente() == 0){
                classificacao = new Classificacao();
                throw new Exception("Incidente nao encontrado");
            }
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(e.getMessage());
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

}
