package br.com.helison.core.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "custom_values")
@Getter
@Setter
public class CustomValue extends PanacheEntity{

    @Column(name = "customized_type")
    private String customizedType;

    @Column(name = "customized_id")
    private Long customizedId;
    
    @ManyToOne
    @JoinColumn(name = "custom_field_id")
    private CustomField customField;

    private String value;

    public static List<Long> getIssuesByCustomField(Long customFieldId, String value){
        List <CustomValue> customValues = list(
            "customField.id = ?1 and customizedType = 'Issue' and value = ?2", customFieldId, value);
        
        List <Long> customizedIds = new ArrayList<Long>();
        for(CustomValue customValue : customValues){
            customizedIds.add(customValue.customizedId);
        }
        return customizedIds;
    }
}