package br.com.helison.core.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "journals")
@Getter
@Setter
public class Journal extends PanacheEntity {

    @Column(name = "journalized_id")
    private Integer journalizedId;

    @Column(name = "journalized_type")
    private String journalizedType;

    
    /* TODO: Transform to FK*/
    /*
    @Column
    private Integer userId;
    */

    @Column
    private String notes;

    @Column(name = "created_on")
    private Date createdOn;
}