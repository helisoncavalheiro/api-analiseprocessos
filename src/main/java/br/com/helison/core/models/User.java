package br.com.helison.core.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User extends PanacheEntity {

    @Column
    private String login;

    @Column
    private String hashedPassword;

    @Column
    private String firstname;
    
    @Column
    private String lastname;

    @Column
    private String mail;

    @Column
    private Boolean mailNotification;

    @Column
    private Boolean admin;
    
}