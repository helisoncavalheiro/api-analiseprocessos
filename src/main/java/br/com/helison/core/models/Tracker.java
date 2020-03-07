package br.com.helison.core.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "trackers")
@Getter
@Setter
public class Tracker extends PanacheEntity {

    @Column
    private String name;
    
    @Column(name = "is_in_chlog")
    private Boolean isInChLog;

    @Column
    private Integer position;

    @Column(name = "is_in_roadmap")
    private Boolean isInRoadmap;

}