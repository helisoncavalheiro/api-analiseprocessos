package br.com.helison.core.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "custom_fields")
@Getter
@Setter
public class CustomField extends PanacheEntity{

    private String type;
    private String name;

    @Column(name = "field_format")
    private String fieldFormat;

    @Column(name = "possible_values")
    private String possibleValues;

    private String regexp;
    
    @Column(name = "min_length")
    private Long minLength;

    @Column(name = "max_length")
    private Long maxLength;

    @Column(name = "is_required")
    private Boolean isRequired;

    @Column(name = "is_for_all")
    private Boolean isForAll;

    @Column(name = "is_filter")
    private Boolean isFilter;

    private Long position;

    private Boolean searchable;

    @Column(name = "default_value")
    private String defaultValue;

    private Boolean editable;

}