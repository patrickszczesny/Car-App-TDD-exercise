import lombok.Getter;

class Vulcanizer {

	@Getter
	double changingTiresPrice =1000;


	double changeTires(Car car) {
		car.setTireWearStatus(0);
		return changingTiresPrice;
	}
	void changeTires4Free(Car car) {
		car.setTireWearStatus(0);
	}
}
