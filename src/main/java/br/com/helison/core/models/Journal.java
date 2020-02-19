package br.com.helison.core.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Journal extends BaseEntity{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Column
    private Integer journalizedId;

    @Column
    private String journalizedType;

    /* TODO: Transform to FK*/
    @Column
    private Integer userId;

    @Column
    private String notes;

    @Column
    private Date createdOn;
}