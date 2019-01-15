import lombok.Getter;
import lombok.Setter;

import java.util.Map;
class GasStation {

	@Setter
	@Getter
	Map<FuelType, Double> prices4Liter;

	double fillTofull(Car car) {

		double payment = (car.getMaxFuelLevel()-car.getCurrentFuelLevel())*prices4Liter.get(car
			.getFuelType());
		car.setCurrentFuelLevel(car.getMaxFuelLevel());
		return payment;
	}


	double fill(Car car, int fillValue) {

		double payment = fillValue*prices4Liter.get(car.getFuelType());

		if ((car.getCurrentFuelLevel()+fillValue)>car.getMaxFuelLevel())
			{
			car.setCurrentFuelLevel(car.getMaxFuelLevel());
			}
		else	{
			car.setCurrentFuelLevel(car.getCurrentFuelLevel()+fillValue);
			}
		return payment;
	}

	void fillTofull4Free(Car car) {

		car.setCurrentFuelLevel(car.getMaxFuelLevel());
	}

}
