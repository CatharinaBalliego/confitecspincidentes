package br.com.confitecsp.java.web.dao;

import br.com.confitecsp.java.web.bean.JpaResourceBean;
import br.com.confitecsp.java.web.model.MotivoAbertura;

import javax.persistence.EntityManager;
import java.util.List;

public class MotivoAberturaDao {
    public List<MotivoAbertura> listarTodos() throws Exception {
        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();
        List<MotivoAbertura> listaAbertura = null;



        try {
            listaAbertura = em.createQuery("from MotivoAbertura").getResultList();


        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            em.close();
        }

        return listaAbertura;
    }

    public void cadastrar(MotivoAbertura motivoAbertura) throws  Exception {
        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

        try{
            em.getTransaction().begin();
            em.merge(motivoAbertura);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();

            throw new Exception(e);

        } finally {
            em.close();

        }
    }

    public void atualizar(MotivoAbertura motivoAbertura) throws Exception {
        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(motivoAbertura);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();

            throw new Exception(e);

        } finally {
            em.close();

        }
    }

    public void excluir(long cd_abertura) throws Exception {
        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

        try{
            em.getTransaction().begin();
            MotivoAbertura incidenteAberto = em.find(MotivoAbertura.class, cd_abertura);
            em.remove(incidenteAberto);
            em.getTransaction().commit();

        }catch (Exception e){
            em.getTransaction().rollback();

            throw new Exception(e);

        } finally {
            em.close();

        }
    }

    public MotivoAbertura selecionar(long cd_abertura) throws Exception {
        MotivoAbertura incidenteAberto;
        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

        try{
            incidenteAberto = em.find(MotivoAbertura.class, cd_abertura);
        } finally {
            em.close();
        }
        return incidenteAberto;
    }
}
