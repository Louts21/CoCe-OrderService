package com.backend.CoCe_OrderService;

import com.backend.CoCe_OrderService.models.Order;
import com.backend.CoCe_OrderService.models.OrderDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.backend.CoCe_OrderService.Validator.IsCarExtraUnderSix;

@RestController
@RequestMapping("/api")
public class Controller {

    private final OrderRepository orderRepository;

    @Value("${spring.application.frontend-url}")
    private String frontendUrl;

    public Controller(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @GetMapping("/healthy")
    public ResponseEntity<String> healthCheck() {
        return new ResponseEntity<>("Order Service is up and running!", HttpStatus.OK);
    }

    @PostMapping("/order")
    public ResponseEntity<OrderDTO> create(@RequestBody OrderDTO orderDTO) {
        if (!IsCarExtraUnderSix(orderDTO.getConfigurationDTO())) {
            return new ResponseEntity<>(orderDTO, HttpStatus.BAD_REQUEST);
        }
        orderDTO.setUrl(frontendUrl + orderDTO.getId());
        Order saved = orderRepository.save(Mapper.toOrder(orderDTO));
        return new ResponseEntity<>(Mapper.toOrderDTO(saved), HttpStatus.CREATED);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderDTO> getById(@PathVariable String id) {
        return orderRepository.findAll().stream().map(Mapper::toOrderDTO)
                .filter(orderDTO -> orderDTO.getId().equals(id)).findFirst()
                .map(orderDTO -> new ResponseEntity<>(orderDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
