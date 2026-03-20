package com.backend.CoCe_OrderService;

import com.backend.CoCe_OrderService.models.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class CoCeOrderServiceApplicationTests {

	private final Car car = new Car("1",
			new CarModelDTO("1", "Verbrenner", 100L),
			new CarEngineDTO("1", "V6", 200L),
			new CarPaintDTO("1", "Rot", 50L),
			new CarWheelDTO("1", "18 Zoll", 150L),
			new CarExtraDTO[]{new CarExtraDTO("1", "Sitzheizung", 100L)},
			600L);

	@Test
	public void testToOrder() {
		OrderDTO orderDTO = new OrderDTO("1", car, "http://localhost:1234/order/1");

		Order order = Mapper.toOrder(orderDTO);

		assert order.getOrderId().equals("1");
		assert order.getCar().getCarModelDTO().getName().equals("Verbrenner");
		assert order.getCar().getCarModelDTO().getPrice() == 100L;
		assert order.getCar().getCarEngineDTO().getName().equals("V6");
		assert order.getCar().getCarEngineDTO().getPrice() == 200L;
		assert order.getCar().getCarPaintDTO().getName().equals("Rot");
		assert order.getCar().getCarPaintDTO().getPrice() == 50L;
		assert order.getCar().getCarWheelDTO().getName().equals("18 Zoll");
		assert order.getCar().getCarWheelDTO().getPrice() == 150L;
		assert order.getCar().getTotalPrice() == 600L;
		assert order.getUrl().equals("http://localhost:1234/order/1");
	}

	@Test
	public void testToOrderDTO() {
		Order order = new Order("1", car, "http://localhost:1234/order/1", LocalDateTime.now().toString());

		OrderDTO orderDTO = Mapper.toOrderDTO(order);

		assert order.getOrderId().equals("1");
		assert order.getCar().getCarModelDTO().getName().equals("Verbrenner");
		assert order.getCar().getCarModelDTO().getPrice() == 100L;
		assert order.getCar().getCarEngineDTO().getName().equals("V6");
		assert order.getCar().getCarEngineDTO().getPrice() == 200L;
		assert order.getCar().getCarPaintDTO().getName().equals("Rot");
		assert order.getCar().getCarPaintDTO().getPrice() == 50L;
		assert order.getCar().getCarWheelDTO().getName().equals("18 Zoll");
		assert order.getCar().getCarWheelDTO().getPrice() == 150L;
		assert order.getCar().getTotalPrice() == 600L;
		assert order.getUrl().equals("http://localhost:1234/order/1");
	}

}
