package br.com.confitecsp.java.web.dao;

import br.com.confitecsp.java.web.bean.JpaResourceBean;
import br.com.confitecsp.java.web.model.MotivoEncerramento;

import javax.persistence.EntityManager;
import java.util.List;

public class MotivoEncerramentoDao {
    public List<MotivoEncerramento> listarTodos() throws Exception {
        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();
        List<MotivoEncerramento> listaEncerramento = null;

        try {
            listaEncerramento = em.createQuery("from MotivoEncerramento order by desc_encerramento").getResultList();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            em.close();
        }

        return listaEncerramento;
    }

    public void cadastrar(MotivoEncerramento motivoEncerramento) throws  Exception {
        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

        try{
            em.getTransaction().begin();
            em.persist(motivoEncerramento);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();

            throw new Exception(e);

        } finally {
            em.close();

        }
    }

    public void atualizar(MotivoEncerramento motivoEncerramento) throws Exception {
        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(motivoEncerramento);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();

            throw new Exception(e);

        } finally {
            em.close();

        }
    }

    public void excluir(long cd_encerramento) throws Exception {
        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

        try{
            em.getTransaction().begin();
            MotivoEncerramento incidenteFechado = em.find(MotivoEncerramento.class, cd_encerramento);
            em.remove(incidenteFechado);
            em.getTransaction().commit();

        }catch (Exception e){
            em.getTransaction().rollback();

            throw new Exception(e);

        } finally {
            em.close();

        }
    }

    public MotivoEncerramento selecionar(long cd_encerramento) throws Exception {
        MotivoEncerramento incidenteFechado;
        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

        try{
            incidenteFechado = em.find(MotivoEncerramento.class, cd_encerramento);
        } finally {
            em.close();
        }
        return incidenteFechado;
    }
}
