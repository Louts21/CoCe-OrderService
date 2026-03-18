package com.backend.CoCe_OrderService;

import com.backend.CoCe_OrderService.models.Car;

public class Validator {

    public static boolean IsCarExtraUnderSix(Car configurationDTO) {
        if (configurationDTO != null && configurationDTO.getCarExtraDTOs() != null) {
            return configurationDTO.getCarExtraDTOs().length <= 5;
        }
        return true;
    }

}
