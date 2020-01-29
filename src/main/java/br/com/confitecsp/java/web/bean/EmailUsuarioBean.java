package br.com.confitecsp.java.web.bean;


import br.com.confitecsp.java.web.dao.EmailUsuarioDao;
import br.com.confitecsp.java.web.model.EmailUsuario;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;


@ManagedBean
@ViewScoped
public class EmailUsuarioBean implements Serializable {

    private static final long serialVersionUID = 2L;

    private EmailUsuario emailUsuario;
    private EmailUsuarioDao emailUsuarioDao;
    private List<EmailUsuario> listarEmail;

    @PostConstruct
    public void init() {
        emailUsuario = new EmailUsuario();
        emailUsuarioDao = new EmailUsuarioDao();

        try {
            listarEmail = emailUsuarioDao.listarTodos();
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }
    }

    public EmailUsuario getEmailUsuario() {return emailUsuario;};

    public List<EmailUsuario> getListarEmail() {return listarEmail;};

    // não é necessario metodo para cadastrar, excluir ou atualizar.

    public void selecionar() {
        try{
            emailUsuario = emailUsuarioDao.selecionar(emailUsuario.getCd_email_usuario());

            if(emailUsuario == null || emailUsuario.getCd_email_usuario() == 0){
                emailUsuario = new EmailUsuario();
                throw new Exception("Email nao encontrado");
            }

        }catch (Exception e){
            FacesMessage message = new FacesMessage(e.getMessage());
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }
}
