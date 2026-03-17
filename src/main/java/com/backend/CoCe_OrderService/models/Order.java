package com.backend.CoCe_OrderService.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {

    private Long id;

    private ConfigurationDTO configurationDTO;
    private String url;
    private String placedAt;

    public Order(Long id, ConfigurationDTO configurationDTO, String url, String placedAt) {
        this.id = id;
        this.configurationDTO = configurationDTO;
        this.url = url;
        this.placedAt = placedAt;
    }

}
