import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class VulcanizerTest {

	CarThresholds carThreshold;
	Car tadeuszCar;
	Vulcanizer wulkanizator;
	@BeforeEach
	void setUp() {
		carThreshold = new CarThresholds(10,5,90);
		tadeuszCar = new Car("tadeusz Car",65,FuelType.PB,carThreshold);
		wulkanizator = new Vulcanizer();
	}

	@DisplayName("Should let to change tires")
	@Test
	void test00() {

		//given
		tadeuszCar.setTireWearStatus(80);
		//when
		double valueToPay= wulkanizator.changeTires(tadeuszCar);
		//then
		assertThat(valueToPay).isEqualTo(wulkanizator.getChangingTiresPrice());
		assertThat(tadeuszCar.getTireWearStatus()).isEqualTo(0);
	}



}