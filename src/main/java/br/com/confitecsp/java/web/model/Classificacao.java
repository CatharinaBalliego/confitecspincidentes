package br.com.confitecsp.java.web.model;

import org.hibernate.type.descriptor.java.LocalDateTimeJavaDescriptor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

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


    @ManyToOne(cascade={CascadeType.PERSIST})
    @JoinColumn(name = "cd_grupo") //adicionar not null depois
    private GrupoDesignado cd_grupo;

    @ManyToOne(cascade={CascadeType.PERSIST})
    @JoinColumn(name = "cd_email_usuario") //adicionar not null depois
    private EmailUsuario cd_email_usuario;


    @Column(name = "data_cadastro", columnDefinition = "DATETIME")
    private LocalDateTime data_cadastro;


    @Size(max = 200)
    @Column(name = "observacao_chamado")
    private String classificacao_observacao;


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

    public GrupoDesignado getCd_grupo() {
        return cd_grupo;
    }

    public void setCd_grupo(GrupoDesignado cd_grupo) {
        this.cd_grupo = cd_grupo;
    }

    public EmailUsuario getCd_email_usuario() {
        return cd_email_usuario;
    }

    public void setCd_email_usuario(EmailUsuario cd_email_usuario) {
        this.cd_email_usuario = cd_email_usuario;
    }

    public LocalDateTime getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(LocalDateTime data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getClassificacao_observacao() {
        return classificacao_observacao;
    }

    public void setClassificacao_observacao(String classificacao_observacao) {
        this.classificacao_observacao = classificacao_observacao;
    }



    @Override
    public String toString() {
        return "Classificacao{" +
                "cd_incidente=" + cd_incidente +
                ", num_incidente='" + num_incidente + '\'' +
                ", cd_abertura=" + cd_abertura +
                ", cd_encerramento=" + cd_encerramento +
                ", cd_grupo=" + cd_grupo +
                ", cd_email_usuario=" + cd_email_usuario +
                ", data_cadastro=" + data_cadastro +
                ", classificacao_observacao='" + classificacao_observacao + '\'' +
                '}';
    }
}