package com.backend.CoCe_OrderService.models;

import com.backend.CoCe_OrderService.CarConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderId;

    @Convert(converter = CarConverter.class)
    @Column(columnDefinition = "text")
    private Car car;
    private String url;
    private String placedAt;

    public Order() {
    }

    public Order(String orderId, Car car, String url, String placedAt) {
        this.orderId = orderId;
        this.car = car;
        this.url = url;
        this.placedAt = placedAt;
    }

}
