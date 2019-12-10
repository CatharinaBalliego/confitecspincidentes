package br.com.confitecsp.java.web.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Table(name="motivo_encerramento")
public class MotivoEncerramento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cd_encerramento")
    private long cd_encerramento;

    @Size(max = 200)
    @Column(name="desc_encerramento", nullable = false)
    private String desc_encerramento;

    public MotivoEncerramento() {
    }

    public long getCd_encerramento() {
        return cd_encerramento;
    }

    public void setCd_encerramento(long cd_encerramento) {
        this.cd_encerramento = cd_encerramento;
    }

    public String getDesc_encerramento() {
        return desc_encerramento;
    }

    public void setDesc_encerramento(String desc_encerramento) {
        this.desc_encerramento = desc_encerramento;
    }


    @Override
    public String toString() {
        return "MotivoEncerramento{" +
                "cd_encerramento=" + cd_encerramento +
                ", desc_encerramento='" + desc_encerramento + '\'' +
                '}';
    }
}
