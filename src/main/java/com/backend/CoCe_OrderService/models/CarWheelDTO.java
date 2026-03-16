package com.backend.CoCe_OrderService.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarWheelDTO {

    private String id;

    private String name;
    private String price;

    public CarWheelDTO(String id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

}
