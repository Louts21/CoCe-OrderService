package com.backend.CoCe_OrderService;

import com.backend.CoCe_OrderService.models.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static com.backend.CoCe_OrderService.Validator.IsCarExtraUnderSix;

@SpringBootTest
class CoCeOrderServiceApplicationTests {

	private final Car car = new Car("1",
			new CarModelDTO("1", "Verbrenner", 100L),
			new CarEngineDTO("1", "V6", 200L),
			new CarPaintDTO("1", "Rot", 50L),
			new CarWheelDTO("1", "18 Zoll", 150L),
			new CarExtraDTO[]{
					new CarExtraDTO("1", "Sitzheizung", 100L),
					new CarExtraDTO("2", "Navigationssystem", 200L),
					new CarExtraDTO("3", "Ledersitze", 300L),
					new CarExtraDTO("4", "Panoramadach", 400L),
					new CarExtraDTO("5", "Sportpaket", 500L)
			},
			1250L);

	@Test
	public void testToOrder() {
		OrderDTO orderDTO = new OrderDTO("1", car, "http://localhost:1234/order/1");

		Order order = Mapper.toOrder(orderDTO);

		assert order.getOrderId().equals("1");
		assert order.getCar().getId().equals("1");
		assert order.getCar().getCarModelDTO().getName().equals("Verbrenner");
		assert order.getCar().getCarModelDTO().getPrice() == 100L;
		assert order.getCar().getCarEngineDTO().getName().equals("V6");
		assert order.getCar().getCarEngineDTO().getPrice() == 200L;
		assert order.getCar().getCarPaintDTO().getName().equals("Rot");
		assert order.getCar().getCarPaintDTO().getPrice() == 50L;
		assert order.getCar().getCarWheelDTO().getName().equals("18 Zoll");
		assert order.getCar().getCarWheelDTO().getPrice() == 150L;
		assert order.getCar().getCarExtraDTOs()[0].getName().equals("Sitzheizung");
		assert order.getCar().getCarExtraDTOs()[0].getPrice() == 100L;
		assert order.getCar().getCarExtraDTOs()[1].getName().equals("Navigationssystem");
		assert order.getCar().getCarExtraDTOs()[1].getPrice() == 200L;
		assert order.getCar().getCarExtraDTOs()[2].getName().equals("Ledersitze");
		assert order.getCar().getCarExtraDTOs()[2].getPrice() == 300L;
		assert order.getCar().getCarExtraDTOs()[3].getName().equals("Panoramadach");
		assert order.getCar().getCarExtraDTOs()[3].getPrice() == 400L;
		assert order.getCar().getCarExtraDTOs()[4].getName().equals("Sportpaket");
		assert order.getCar().getCarExtraDTOs()[4].getPrice() == 500L;
		assert order.getUrl().equals("http://localhost:1234/order/1");
	}

	@Test
	public void testToOrderDTO() {
		Order order = new Order("1", car, "http://localhost:1234/order/1", LocalDateTime.now().toString());

		OrderDTO orderDTO = Mapper.toOrderDTO(order);

		assert orderDTO.getId().equals("1");
		assert orderDTO.getCar().getId().equals("1");
		assert orderDTO.getCar().getCarModelDTO().getName().equals("Verbrenner");
		assert orderDTO.getCar().getCarModelDTO().getPrice() == 100L;
		assert orderDTO.getCar().getCarEngineDTO().getName().equals("V6");
		assert orderDTO.getCar().getCarEngineDTO().getPrice() == 200L;
		assert orderDTO.getCar().getCarPaintDTO().getName().equals("Rot");
		assert orderDTO.getCar().getCarPaintDTO().getPrice() == 50L;
		assert orderDTO.getCar().getCarWheelDTO().getName().equals("18 Zoll");
		assert orderDTO.getCar().getCarWheelDTO().getPrice() == 150L;
		assert orderDTO.getCar().getCarExtraDTOs()[0].getName().equals("Sitzheizung");
		assert orderDTO.getCar().getCarExtraDTOs()[0].getPrice() == 100L;
		assert orderDTO.getCar().getCarExtraDTOs()[1].getName().equals("Navigationssystem");
		assert orderDTO.getCar().getCarExtraDTOs()[1].getPrice() == 200L;
		assert orderDTO.getCar().getCarExtraDTOs()[2].getName().equals("Ledersitze");
		assert orderDTO.getCar().getCarExtraDTOs()[2].getPrice() == 300L;
		assert orderDTO.getCar().getCarExtraDTOs()[3].getName().equals("Panoramadach");
		assert orderDTO.getCar().getCarExtraDTOs()[3].getPrice() == 400L;
		assert orderDTO.getCar().getCarExtraDTOs()[4].getName().equals("Sportpaket");
		assert orderDTO.getCar().getCarExtraDTOs()[4].getPrice() == 500L;
		assert orderDTO.getUrl().equals("http://localhost:1234/order/1");
	}

	@Test
	public void testIsCarExtraUnderSix() {
		Car carWithSixExtras = new Car("2",
				new CarModelDTO("1", "Verbrenner", 100L),
				new CarEngineDTO("1", "V6", 200L),
				new CarPaintDTO("1", "Rot", 50L),
				new CarWheelDTO("1", "18 Zoll", 150L),
				new CarExtraDTO[]{
						new CarExtraDTO("1", "Sitzheizung", 100L),
						new CarExtraDTO("2", "Navigationssystem", 200L),
						new CarExtraDTO("3", "Ledersitze", 300L),
						new CarExtraDTO("4", "Panoramadach", 400L),
						new CarExtraDTO("5", "Sportpaket", 500L),
						new CarExtraDTO("6", "Sound System Upgrade", 600L)
				},
				1850L);

		assert IsCarExtraUnderSix(car);
		assert !IsCarExtraUnderSix(carWithSixExtras);
	}

}
