package br.com.confitecsp.java.web.dao;

import br.com.confitecsp.java.web.bean.JpaResourceBean;
import br.com.confitecsp.java.web.model.Classificacao;

import javax.persistence.EntityManager;
import java.util.List;

public class ClassificacaoDao {

    public List<Classificacao>listarTodos() throws Exception {
        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();
        List<Classificacao> listarIncidentes = null;

        try {
            listarIncidentes = em.createQuery("from Classificacao").getResultList();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            em.close();
        }

        return listarIncidentes;
    }

    public void cadastrar(Classificacao classificacao) throws  Exception {
        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

        try{
            em.getTransaction().begin();
            em.merge(classificacao);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();

            throw new Exception(e);

        } finally {
            em.close();

        }
    }

    public void atualizar(Classificacao classificacao) throws Exception {
        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(classificacao);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();

            throw new Exception(e);

        } finally {
            em.close();

        }
    }

    public void excluir(long cd_incidente) throws Exception {
        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

        try{
            em.getTransaction().begin();
            Classificacao incidente = em.find(Classificacao.class, cd_incidente);
            em.remove(incidente);
            em.getTransaction().commit();

        }catch (Exception e){
            em.getTransaction().rollback();

            throw new Exception(e);

        } finally {
            em.close();

        }
    }

    public Classificacao selecionar(long cd_incidente) throws Exception {
        Classificacao incidente;
        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

        try{
            incidente = em.find(Classificacao.class, cd_incidente);
        } finally {
            em.close();
        }
        return incidente;
    }

}
