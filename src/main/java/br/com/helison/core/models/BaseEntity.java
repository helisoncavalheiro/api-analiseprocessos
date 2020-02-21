package br.com.helison.core.models;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Setter;

@MappedSuperclass
public abstract class BaseEntity implements BaseModel<Long> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Setter
    @Column(name = "id")
    private Long id;

    @Override
    public Long getId(){
        return id;
    }
}