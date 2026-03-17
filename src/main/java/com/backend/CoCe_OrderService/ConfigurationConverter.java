package com.backend.CoCe_OrderService;

import com.backend.CoCe_OrderService.models.ConfigurationDTO;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import tools.jackson.databind.ObjectMapper;

@Converter
public class ConfigurationConverter implements AttributeConverter<ConfigurationDTO, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(ConfigurationDTO attribute) {
        if (attribute == null) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error converting ConfigurationDTO to JSON", e);
        }
    }

    @Override
    public ConfigurationDTO convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        try {
            return objectMapper.readValue(dbData, ConfigurationDTO.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error converting JSON to ConfigurationDTO", e);
        }
    }

}
