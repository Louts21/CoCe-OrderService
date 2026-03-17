package com.backend.CoCe_OrderService.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ConfigurationDTO {

    private String id;

    private CarModelDTO carModelDTO;
    private CarEngineDTO carEngineDTO;
    private CarPaintDTO carPaintDTO;
    private CarWheelDTO carWheelDTO;
    private CarExtraDTO[] carExtraDTOs;

    private double totalPrice;

    public ConfigurationDTO(String id, CarModelDTO carModelDTO, CarEngineDTO carEngineDTO, CarPaintDTO carPaintDTO,
                            CarWheelDTO carWheelDTO, CarExtraDTO[] carExtraDTOs, double totalPrice) {
        this.id = id;
        this.carModelDTO = carModelDTO;
        this.carEngineDTO = carEngineDTO;
        this.carPaintDTO = carPaintDTO;
        this.carWheelDTO = carWheelDTO;
        this.carExtraDTOs = carExtraDTOs;
        this.totalPrice = totalPrice;
    }

}
