package br.com.helison.core.models.competo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.helison.core.models.redmine.Project;
import br.com.helison.core.models.redmine.Role;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cs_catalogo_servicos")
@Getter
@Setter
public class Servico extends PanacheEntityBase {
    
    @Id
    private Integer codigo;

    private String servico;
    
    @ManyToOne
    @JoinColumn(name = "codigo_projeto")
    private Project projeto;

    private String descricao;

    private String status;

    @ManyToMany
    @JoinTable(name = "cs_servico_papel", joinColumns = {@JoinColumn(name="servico")}, inverseJoinColumns = {@JoinColumn(name = "papel")})
    private List<Role> solicitantes;

    @ManyToMany
    @JoinTable(name = "cs_observadores", joinColumns = {@JoinColumn(name="servico")}, inverseJoinColumns = {@JoinColumn(name = "permissao")})
    private List<Role> observadores;

}