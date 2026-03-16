package com.backend.CoCe_OrderService;

import com.backend.CoCe_OrderService.models.OrderDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.backend.CoCe_OrderService.Validator.IsCarExtraUnderSix;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    @PostMapping("/order")
    public ResponseEntity<OrderDTO> create(@RequestBody OrderDTO orderDTO) {
        return IsCarExtraUnderSix(orderDTO.getConfigurationDTO()) ?
                new ResponseEntity<>(orderDTO, HttpStatus.CREATED) :
                new ResponseEntity<>(orderDTO, HttpStatus.BAD_REQUEST);
    }

}
