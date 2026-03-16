package com.backend.CoCe_OrderService.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {

    private String id;

    private ConfigurationDTO configurationDTO;

    public OrderDTO(String id, ConfigurationDTO configurationDTO) {
        this.id = id;
        this.configurationDTO = configurationDTO;
    }

}
