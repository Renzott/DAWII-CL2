package com.renzo.spring.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "cliente_id")
    private int id;

    @Column(name = "cliente_nombre")
    @NotEmpty
    private String nombre;

    @Column(name = "cliente_apellido")
    @NotEmpty
    private String apellido;

    @Column(name = "cliente_telefono")
    @NotEmpty
    @Pattern(regexp="[0-9]{9}")
    private String telefono;

    @Column(name = "cliente_email")
    @NotEmpty
    @Email
    private String email;

    @ManyToOne
    @JoinColumn(name = "distrito_id", nullable = false)
    private Distrito distrito;

    @Column(name = "cliente_direccion")
    @NotEmpty
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "tipo_id", nullable = false)
    private TipoCliente tipoCliente;

    private boolean isEdit;

    public boolean isEdit() {
        return isEdit;
    }

    public void setEdit(boolean edit) {
        isEdit = edit;
    }

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}
