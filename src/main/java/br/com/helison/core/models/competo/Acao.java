package br.com.helison.core.models.competo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.helison.core.models.redmine.Role;
import br.com.helison.core.models.redmine.Status;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cs_workflow")
@Getter
@Setter
public class Acao extends PanacheEntityBase{
    
    @Id
    private Integer codigo;

    @Column(name = "codigo_catalogo_servicos")
    private Integer servico;

    @ManyToMany
    @JoinTable(name = "cs_workflow_papel", joinColumns = {@JoinColumn(name = "workflow")}, inverseJoinColumns = {@JoinColumn(name = "papel")})
    private List<Role> disponivelPara;

    @ManyToOne
    @JoinColumn(name = "origem")
    private Status origem;

    @ManyToOne
    @JoinColumn(name = "destino")
    private Status destino;

    private String css;

    private String icone;

    @Column(name = "template_comentario")
    private String templateComentario;

    private Boolean detalhamento;

    private String alertas;

    private String texto;

    @Column(name = "email_default_solicitante")
    private Boolean emailDefaultSolicitante;

    @Column(name = "email_default_executor")
    private Boolean emailDefualtExecutor;

    @Column(name = "email_default_outros")
    private String emailDefaultOutros;

    @Column(name = "email_default_atribuido")
    private Boolean emailDefaultAtribuido;

    private Boolean atribuir;

    @ManyToMany
    @JoinTable(name =  "cs_workflow_atribuir_papel", joinColumns = {@JoinColumn(name = "acao")}, inverseJoinColumns = {@JoinColumn(name = "papel")})
    private List<Role> atribuiveis;

    private String alteracao;

    @Column(name = "mensagem_confirmacao")
    private String mensagemConfirmacao;

    private Boolean ativo;
}