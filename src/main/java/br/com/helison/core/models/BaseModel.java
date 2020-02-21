package br.com.helison.core.models;

import java.io.Serializable;

public interface BaseModel<PK extends Serializable> extends Serializable{
    PK getId();
}