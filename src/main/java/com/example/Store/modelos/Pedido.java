package com.example.Store.modelos;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido;
    @Column(name = "fechaYHora",nullable = true)
    private String fechaYHora; // no vacio y formato internacional

    @ManyToOne
    @JoinColumn(name="id_usuario", referencedColumnName = "id_usuario")
    Usuario usuario;

    public Pedido() {
    }

    public Pedido(Integer id, String fechaYHora) {
        this.id_pedido = id;
        fechaYHora = fechaYHora;
    }

    public String getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(String fechaYHora) {
        this.fechaYHora = fechaYHora;
    }
}
