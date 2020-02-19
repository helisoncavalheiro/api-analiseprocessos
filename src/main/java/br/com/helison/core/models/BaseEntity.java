package br.com.helison.core.models;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Setter;

@MappedSuperclass
public abstract class BaseEntity implements BaseModel<Integer> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Setter
    private Integer pk;

    @Override
    public Integer getPk(){
        return pk;
    }

}