package com.example.demo.entities;


import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_payments")
public class Payments implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Remova @MapsId
    private Long id;  // Altere para Long para ser consistente com o tipo de ID da entidade

    private Instant moment;

    @OneToOne
    @JoinColumn(name = "order_id")  // Adicione a chave estrangeira explicitamente
    private Order order;

    public Payments() {}

    public Payments(Long id, Instant moment, Order order) {
        this.id = id;
        this.moment = moment;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Payments payments)) return false;
        return id != null && id.equals(payments.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


