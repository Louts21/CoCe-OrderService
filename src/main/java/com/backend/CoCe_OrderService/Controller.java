package com.backend.CoCe_OrderService;

import com.backend.CoCe_OrderService.models.Order;
import com.backend.CoCe_OrderService.models.OrderDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.backend.CoCe_OrderService.Validator.IsCarExtraUnderSix;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    private final OrderRepository orderRepository;

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
        orderDTO.setUrl(Generator.urlGenerator(orderDTO.getId()));
        Order saved = orderRepository.save(Mapper.toOrder(orderDTO));
        return new ResponseEntity<>(Mapper.toOrderDTO(saved), HttpStatus.CREATED);
    }

}
