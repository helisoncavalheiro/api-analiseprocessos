package br.com.helison.core.models.redmine;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User extends PanacheEntity {

    @Column
    private String login;

    @Column(name = "hashed_password")
    private String hashedPassword;

    @Column
    private String firstname;
    
    @Column
    private String lastname;
/*
    @Column(name = "mail_notification")
    private Boolean mailNotification;
*/
    @Column
    private Boolean admin;

    @Column
    private Long status;
    
    @Column(name = "last_login_on")
    private Date lastLoginOn;

    @Column
    private String language;
    
    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "updated_on")
    private Date updatedOn;

    @Column
    private String type;

    @Column(name = "identity_url")
    private String identityUrl;
}