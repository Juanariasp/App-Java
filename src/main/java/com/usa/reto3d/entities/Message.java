package com.usa.reto3d.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "message")
public class Message implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idMensajes;

    public Integer getIdMensajes() {
        return idMensajes;
    }

    public void setIdMensajes(Integer idMensajes) {
        this.idMensajes = idMensajes;
    }
}
