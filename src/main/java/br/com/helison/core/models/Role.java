package br.com.helison.core.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role extends PanacheEntity{
    
    String name;

    Integer position;

    Boolean assignable;

    Integer builtin;

    String permissions;

    @Column(name = "issues_visibility")
    String issuesVisibility;

    @Column(name = "users_visibility")
    String usersVisibility;

    @Column(name = "time_entries_visibility")
    String timeEntriesVisibility;

    @Column(name = "all_roles_managed")
    Boolean allRolesManaged;

    String settings;
    
}