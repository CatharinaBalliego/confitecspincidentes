package br.com.confitecsp.java.web.model;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Table(name="motivo_abertura")

public class MotivoAbertura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cd_abertura")
    private long cd_abertura;

    @Size(max = 200)
    @Column(name="desc_abertura", nullable = false)
    private String desc_abertura;

//    @OneToMany(mappedBy = "motivoAbertura",  cascade = CascadeType.ALL)
//    private Set<Classificacao> incidentes;

    public MotivoAbertura() {
    }

    public long getCd_abertura() {
        return cd_abertura;
    }

    public void setCd_abertura(long cd_abertura) {
        this.cd_abertura = cd_abertura;
    }

    public String getDesc_abertura() {
        return desc_abertura;
    }

    public void setDesc_abertura(String desc_abertura) {
        this.desc_abertura = desc_abertura;
    }

    @Override
    public String toString() {
        return "MotivoAbertura{" +
                "cd_abertura=" + cd_abertura +
                ", desc_abertura='" + desc_abertura + '\'' +
                '}';
    }
}
