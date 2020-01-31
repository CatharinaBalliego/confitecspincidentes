package br.com.confitecsp.java.web.dao;

import br.com.confitecsp.java.web.bean.JpaResourceBean;
import br.com.confitecsp.java.web.model.EmailUsuario;

import javax.persistence.EntityManager;
import java.util.List;

public class EmailUsuarioDao {
    public List<EmailUsuario> listarTodos() throws Exception {
        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();
        List<EmailUsuario> listarEmail = null;

        try{
            listarEmail = em.createQuery(" from EmailUsuario").getResultList();
        }catch (Exception e){
            throw new Exception(e);
        }finally {
            em.close();
        }
        return listarEmail;
    }

    // se necessario inserir os metodos para atualizar e excluir


    public EmailUsuario selecionar(long cd_email_usuario) throws Exception{
        EmailUsuario selecionarEmail;
        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

        try{
            selecionarEmail = em.find(EmailUsuario.class, cd_email_usuario);
        }finally {
            em.close();
        }
        return selecionarEmail;
    }
}
