import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class PitstopTest {

	CarThresholds carThreshold;
	Car tadeuszCar;
	GasStation shell;
	CarMyjka myjka;
	Vulcanizer wulkanizator;
	Pitstop pitstop;
	Race race;

	Map<String,Map<String,List<Integer>>> pitstops;

	@BeforeEach
	void setUp() {
		carThreshold = new CarThresholds(10,5,90);
		tadeuszCar = new Car("tadeusz Car",65,FuelType.PB,carThreshold);
		shell = new GasStation();
		myjka = new CarMyjka();
		wulkanizator = new Vulcanizer();
		race = new Race();
		pitstop = new Pitstop(shell,wulkanizator,myjka);


	}
	@DisplayName("Should let to ride 100 laps race and check fuel status & tire status & filth status ")
	@Test
	void test00() {

		//given
		tadeuszCar.setCurrentFuelLevel(tadeuszCar.getMaxFuelLevel());
		tadeuszCar.setCleanValue(100);
		tadeuszCar.setTireWearStatus(0);
		int lapsNumber = 100;
		//when
		race.race(lapsNumber,tadeuszCar,pitstop);
		//then
		assertThat((race.getPitstops())).isNotEmpty();

	}
	@DisplayName("Should let to ride 100 laps race and if needed get pitstop")
	@Test
	void test01() {

		//given
		tadeuszCar.setCurrentFuelLevel(tadeuszCar.getMaxFuelLevel());
		tadeuszCar.setCleanValue(100);
		tadeuszCar.setTireWearStatus(0);
		int lapsNumber = 100;
		//when
		race.race(lapsNumber,tadeuszCar,pitstop);
		//then
		assertThat(race.getPitstops().get(tadeuszCar.getName()).get("Fuel Services")).containsExactly(56);
		assertThat(race.getPitstops().get(tadeuszCar.getName()).get("Tires Services")).containsExactly(19,38,
			57,76,95);
		assertThat(race.getPitstops().get(tadeuszCar.getName()).get("Clean Services")).containsExactly(48,96);
	}
}
