package br.com.helison.core.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/* TODO: Map class to database table*/
@Entity
@Table(name = "issue_statuses")
@Getter
@Setter
public class Status extends BaseEntity{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

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