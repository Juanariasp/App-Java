package com.usa.reto3d.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "message")
public class Message implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idMensajes;

    @ManyToOne
    @JoinColumn(name = "roomId")
    @JsonIgnoreProperties({"messages","reservations"})
    private Costume costume;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;

    public Integer getIdMensajes() {
        return idMensajes;
    }

    public void setIdMensajes(Integer idMensajes) {
        this.idMensajes = idMensajes;
    }
}
