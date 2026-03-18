package com.backend.CoCe_OrderService;

import com.backend.CoCe_OrderService.models.Car;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import tools.jackson.databind.ObjectMapper;

@Converter
public class CarConverter implements AttributeConverter<Car, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Car attribute) {
        if (attribute == null) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error converting Car to JSON", e);
        }
    }

    @Override
    public Car convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        try {
            return objectMapper.readValue(dbData, Car.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error converting JSON to Car", e);
        }
    }

}
