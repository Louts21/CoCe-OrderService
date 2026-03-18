package com.backend.CoCe_OrderService.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarEngineDTO {

    private String id;

    private String name;
    private long price;

    public CarEngineDTO(String id, String name, long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

}
