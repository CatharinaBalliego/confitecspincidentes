package br.com.confitecsp.java.web.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="classificacao_incidente")
public class Classificacao  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cd_incidente")
    private long cd_incidente;


    @Size(max = 10)
    @Column(name="num_incidente", nullable = false, unique = true)
    private String num_incidente;

    @ManyToOne(cascade={CascadeType.PERSIST})
    @JoinColumn(name = "cd_abertura", nullable = false)
    private MotivoAbertura cd_abertura;

    @ManyToOne(cascade={CascadeType.PERSIST})
    @JoinColumn(name = "cd_encerramento",  nullable = false)
    private MotivoEncerramento cd_encerramento;




    public Classificacao() {
    }


    public long getCd_incidente() {
        return cd_incidente;
    }

    public void setCd_incidente(long cd_incidente) {
        this.cd_incidente = cd_incidente;
    }


    public String getNum_incidente() {
        return num_incidente;
    }

    public void setNum_incidente(String num_incidente) {
        this.num_incidente = num_incidente;
    }

    public MotivoAbertura getCd_abertura() {
        return cd_abertura;
    }

    public void setCd_abertura(MotivoAbertura cd_abertura) {
        this.cd_abertura = cd_abertura;
    }

    public MotivoEncerramento getCd_encerramento() {
        return cd_encerramento;
    }

    public void setCd_encerramento(MotivoEncerramento cd_encerramento) {
        this.cd_encerramento = cd_encerramento;
    }

    @Override
    public String toString() {
        return "ClassificacaoIncidente{" +
                "cd_incidente='" + cd_incidente + '\'' +
                ", motivo_abertura=" + cd_abertura +
                ", motivo_encerramento=" + cd_encerramento +
                '}';
    }
}