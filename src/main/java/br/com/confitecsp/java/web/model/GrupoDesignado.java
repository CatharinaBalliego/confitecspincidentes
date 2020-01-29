package br.com.confitecsp.java.web.model;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Table(name="controle_grupo_designado")


public class GrupoDesignado implements  Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cd_grupo")
    private long cd_grupo;

    @Column(name="desc_grupo_nome")
    @Size(max = 200)
    private String desc_grupo_nome;


    public GrupoDesignado (){

    }
    public long getCd_grupo() {
        return cd_grupo;
    }

    public void setCd_grupo(long cd_grupo) {
        this.cd_grupo = cd_grupo;
    }

    public String getDesc_grupo_nome() {
        return desc_grupo_nome;
    }

    public void setDesc_grupo_nome(String desc_grupo_nome) {
        this.desc_grupo_nome = desc_grupo_nome;
    }

    @Override
    public String toString() {
        return "GrupoDesignado{" +
                "cd_grupo=" + cd_grupo +
                ", desc_grupo_nome='" + desc_grupo_nome + '\'' +
                '}';
    }
}
