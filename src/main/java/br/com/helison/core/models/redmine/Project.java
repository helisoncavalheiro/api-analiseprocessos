package br.com.helison.core.models.redmine;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "projects")
@Getter
@Setter
public class Project extends PanacheEntity{
    
    private String name;

    private String description;

    private String homepage;

    @Column(name = "is_public")
    private Boolean isPublic;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "updated_on")
    private Date updatedOn;

    private String identifier;

    private Integer status;

    private Integer lft;

    private Integer rgt;

}