package br.com.helison.core.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tracker extends BaseEntity{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Column
    private String name;
    
    @Column
    private Boolean isInChLog;

    @Column
    private Integer position;

    @Column
    private Boolean isInRoadmap;

}