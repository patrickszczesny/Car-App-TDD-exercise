import lombok.Getter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Race {

	@Getter
	int fuelLostValue = 1;
	@Getter
	int tiresWearIncreaseValue = 5;
	@Getter
	int cleanDecreaseValue = 2;

	@Getter
	Map<String, Map<String, List<Integer>>> pitstops = new HashMap<>();


	void race(int lapsNumber, Car car, Pitstop pitstop) {

		Map<String, List<Integer>> services = new HashMap<>();
		services.put("Fuel Services", new ArrayList<Integer>());
		services.put("Tires Services", new ArrayList<Integer>());
		services.put("Clean Services", new ArrayList<Integer>());
		pitstops.put(car.getName(), services);

		for (int i = 1; i < lapsNumber+1; i++) {
			threshold(car);
			if (check(car, pitstop)) {
				MadeServices madeServices = pitstop.pitstop(car);
				pitstops.replace(car.getName(), checkServices(madeServices, i, services));
			}
		}
	}


	void threshold(Car car) {
		car.setCurrentFuelLevel(car.getCurrentFuelLevel()-fuelLostValue);
		car.setTireWearStatus(car.getTireWearStatus()+tiresWearIncreaseValue);
		car.setCleanValue(car.getCleanValue()-cleanDecreaseValue);
	}

	boolean check(Car car,Pitstop pitstop) {
		return pitstop.fuelCheck(car) ||
			pitstop.wheelCheck(car) ||
			pitstop.cleanCheck(car);
	}
	private Map<String, List<Integer>> checkServices(MadeServices madeServices, int currentLap, Map<String, List<Integer>> services) {


		if (madeServices.isFuelService()) {
			List<Integer> currentLapsNumber = services.get("Fuel Services");
			currentLapsNumber.add(currentLap);
			services.put("Fuel Services", currentLapsNumber);
		}
		if (madeServices.isTiresService()) {
			List<Integer> currentLapsNumber = services.get("Tires Services");
			currentLapsNumber.add(currentLap);
			services.put("Tires Services", currentLapsNumber);
		}
		if (madeServices.isCleanService()) {
			List<Integer> currentLapsNumber = services.get("Clean Services");
			currentLapsNumber.add(currentLap);
			services.put("Clean Services", currentLapsNumber);
		}
		return services;
	}




}
