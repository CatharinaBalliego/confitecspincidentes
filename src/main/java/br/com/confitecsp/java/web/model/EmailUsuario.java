package br.com.confitecsp.java.web.model;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Table(name="controle_email_usuario")
public class EmailUsuario implements  Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cd_email_usuario")
    private long cd_email_usuario;

    @Size(max = 200)
    @Column(name="desc_usuario_email")
    private String desc_usuario_email;

    public EmailUsuario(){

    }

    public long getCd_email_usuario() {
        return cd_email_usuario;
    }

    public void setCd_email_usuario(long cd_email_usuario) {
        this.cd_email_usuario = cd_email_usuario;
    }

    public String getDesc_usuario_email() {
        return desc_usuario_email;
    }

    public void setDesc_usuario_email(String desc_usuario_email) {
        this.desc_usuario_email = desc_usuario_email;
    }

    @Override
    public String toString() {
        return "EmailUsuario{" +
                "cd_email_usuario=" + cd_email_usuario +
                ", desc_usuario_email='" + desc_usuario_email + '\'' +
                '}';
    }
}
