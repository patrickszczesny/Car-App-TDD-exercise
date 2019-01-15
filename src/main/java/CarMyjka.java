import lombok.Getter;

class CarMyjka {
	@Getter
	double cleaningPrice =20;

	double cleanTheCar(Car car) {
	car.setCleanValue(100);
	return cleaningPrice;
	}

	void cleanTheCar4Free(Car car) {
		car.setCleanValue(100);
	}
}
