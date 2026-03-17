package com.backend.CoCe_OrderService.models;

import com.backend.CoCe_OrderService.ConfigurationConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderId;

    @Convert(converter = ConfigurationConverter.class)
    @Column(columnDefinition = "text")
    private ConfigurationDTO configurationDTO;
    private String url;
    private String placedAt;

    public Order() {
    }

    public Order(String orderId, ConfigurationDTO configurationDTO, String url, String placedAt) {
        this.orderId = orderId;
        this.configurationDTO = configurationDTO;
        this.url = url;
        this.placedAt = placedAt;
    }

}
