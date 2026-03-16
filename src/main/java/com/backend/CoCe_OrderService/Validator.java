package com.backend.CoCe_OrderService;

import com.backend.CoCe_OrderService.models.ConfigurationDTO;

public class Validator {

    public static boolean IsCarExtraUnderSix(ConfigurationDTO configurationDTO) {
        if (configurationDTO != null && configurationDTO.getCarExtraDTOs() != null) {
            return configurationDTO.getCarExtraDTOs().length <= 5;
        }
        return true;
    }

}
