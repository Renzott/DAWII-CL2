package com.renzo.spring.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
public class Distrito implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "distrito_id")
    private int id;

    @Column(name = "distrito_nombre")
    @NotEmpty
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
