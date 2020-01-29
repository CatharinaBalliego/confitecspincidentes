package br.com.confitecsp.java.web.dao;

import br.com.confitecsp.java.web.bean.JpaResourceBean;
import br.com.confitecsp.java.web.model.GrupoDesignado;
import br.com.confitecsp.java.web.model.MotivoEncerramento;

import javax.persistence.EntityManager;
import java.util.List;

public class GrupoDesignadoDao {

    public List<GrupoDesignado> listarTodos() throws  Exception {
        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();
        List<GrupoDesignado> listaGrupo = null;


        try{
            listaGrupo = em.createQuery(": from GrupoDesignado").getResultList();
        }catch (Exception e){
            throw new Exception(e);
        }finally {
            em.close();
        }

        return listaGrupo;
    }

    // se necessario inserir os metodos para excluir e atualizar.

    public GrupoDesignado selecionar(long cd_grupo) throws Exception{
        GrupoDesignado selecionarGrupo;
        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

        try{
            selecionarGrupo = em.find(GrupoDesignado.class, cd_grupo);
        }finally {
            em.close();
        }

        return selecionarGrupo;
    }
}
