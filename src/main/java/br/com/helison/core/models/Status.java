package br.com.helison.core.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

/* TODO: Map class to database table*/
@Entity
@Getter
@Setter
public class Status extends BaseEntity{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Column
    private String name;
    
    @Column
    private Boolean isClosed;

    @Column
    private Boolean isDefault;

    @Column
    private Integer position;

    @Column
    private Integer defaultDoneRatio;


}