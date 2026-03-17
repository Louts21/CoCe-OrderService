package com.backend.CoCe_OrderService;

import com.backend.CoCe_OrderService.models.Order;
import com.backend.CoCe_OrderService.models.OrderDTO;

import java.time.LocalDateTime;

public class Mapper {

    public static Order toOrder(OrderDTO orderDTO) {
        return new Order(orderDTO.getId(), orderDTO.getConfigurationDTO(), orderDTO.getUrl(),
                LocalDateTime.now().toString());
    }

    public static OrderDTO toOrderDTO(Order order) {
        return new OrderDTO(String.valueOf(order.getOrderId()), order.getConfigurationDTO(), order.getUrl());
    }

}
