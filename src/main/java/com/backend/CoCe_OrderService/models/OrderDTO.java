package com.backend.CoCe_OrderService.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {

    private String id;

    private Car car;
    private String url;

    public OrderDTO(String id, Car car, String url) {
        this.id = id;
        this.car = car;
        this.url = url;
    }

}
