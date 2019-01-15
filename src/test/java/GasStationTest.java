import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GasStationTest {

	Car tadeuszCar;
	GasStation shell;
	CarThresholds carThreshold;
	Map<FuelType,Double> shellPriceses = new HashMap<>();

	@BeforeEach
	void setUp() {
	carThreshold = new CarThresholds(10,5,90);
	tadeuszCar = new Car("tadeusz Car",65,FuelType.PB,carThreshold);
	shell = new GasStation();
	shellPriceses.put(FuelType.PB,5.0);
	shellPriceses.put(FuelType.OIL,4.0);
	shellPriceses.put(FuelType.ELECTRICITY,0.5);
	shell.setPrices4Liter(shellPriceses);
	}

	@DisplayName("Should calculate the cost for filling the car's tank to full and check is it full")
	@Test
	void test00() {

		//given
		tadeuszCar.setCurrentFuelLevel(10);
		//when
		double valueToPay = shell.fillTofull(tadeuszCar);
		//then
		assertThat(valueToPay).isEqualTo(275);
		assertThat(tadeuszCar.getCurrentFuelLevel()).isEqualTo(100);
	}

	@DisplayName("Should calculate the cost for filling the car's tank to given Value and check is the current " +
		"fuel level correct")
	@Test
	void test01() {

		//given
		tadeuszCar.setCurrentFuelLevel(10);
		int fillValue = 20;
		//when
		double valueToPay = shell.fill(tadeuszCar,fillValue);
		//then
		assertThat(valueToPay).isEqualTo(fillValue*shell.getPrices4Liter().get(tadeuszCar.getFuelType()));
		assertThat(tadeuszCar.getCurrentFuelLevel()).isEqualTo(30);
	}




}
