package br.com.helison.core.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Issue extends BaseEntity{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    //Tracker id (FK) - Tipo de tarefa
    /* TODO:  Transform to FK*/
    @Column
    private Integer trackerId;


    /* TODO: Transform to FK */
    @Column
    private Integer projectId;

    //Assunto da tarefa
    @Column
    private String subject;

    //Descrição da tarefa
    @Column
    private String description;

    @Column
    private Date dueDate;

    // TODO: Transform to FK
    @Column
    private Integer categoryId;

    @Column
    private Integer statusId;

    /* TODO: Transform to FK*/
    @Column
    private Integer assignedToId;

    /* TODO: Transform to FK*/
    @Column
    private Integer priorityId;

    /* TODO: Transform to FK*/
    @Column
    private Integer fixedVersionId;

    /* TODO: Transform to FK*/
    @Column
    private Integer authorId;

    @Column
    private Integer lockVersion;

    @Column
    private Date createdOn;

    @Column
    private Date updatedOn;

    @Column
    private Date startDate;

    @Column
    private Integer doneRatio;

    @Column
    private Long estimatedHours;

    /* TODO: Transform to FK*/
    @Column
    private Integer parentId;

    /* TODO: Transform to FK*/
    @Column
    private Integer rootId;

    @Column
    private Integer lft;

    @Column
    private Integer rgt;
}