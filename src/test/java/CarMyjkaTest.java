import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CarMyjkaTest {

	CarThresholds carThreshold;
	Car tadeuszCar;
	CarMyjka myjka;
	@BeforeEach
	void setUp() {
		carThreshold = new CarThresholds(10,5,90);
		tadeuszCar = new Car("tadeusz Car",65,FuelType.PB,carThreshold);
		myjka = new CarMyjka();
	}


	@DisplayName("Should let to clean car")
	@Test
	void test00() {

		//given
		tadeuszCar.setCleanValue(20);
		//when
		double valueToPay= myjka.cleanTheCar(tadeuszCar);
		//then
		assertThat(valueToPay).isEqualTo(myjka.getCleaningPrice());
		assertThat(tadeuszCar.getCleanValue()).isEqualTo(100);
	}


}
