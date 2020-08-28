package br.com.helison.core.models.redmine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

/* TODO: Map class to database table*/
@Entity
@Table(name = "issue_statuses")
@Getter
@Setter
public class Status extends PanacheEntity {

    @Column
    private String name;
    
    @Column(name = "is_closed")
    private Boolean isClosed;
    /*
    @Column(name = "is_default")
    private Boolean isDefault;
    */
    @Column
    private Integer position;

    @Column(name = "default_done_ratio")
    private Integer defaultDoneRatio;


}