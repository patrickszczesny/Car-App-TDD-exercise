import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
 class Pitstop {

	@NonNull
	GasStation gasStation;
	@NonNull
	Vulcanizer wulkanizator;
	@NonNull
	CarMyjka myjka;



	boolean fuelCheck(Car car){
		return car.getCurrentFuelLevel()<car.getFuelThreshold();
	}

	 boolean wheelCheck(Car car) {

		return car.getTireWearStatus()>car.getTiresThreshold();
	}

	boolean cleanCheck(Car car) {

		return car.getCleanValue()<car.getCleanThreshold();
	}

	 MadeServices pitstop(Car car) {
		MadeServices madeServices= new MadeServices();
		if (fuelCheck(car)){
			gasStation.fillTofull4Free(car);
			madeServices.setFuelService(true);
		}
		if (wheelCheck(car)){
			wulkanizator.changeTires4Free(car);
			madeServices.setTiresService(true);
		}
		if (cleanCheck(car)){
			myjka.cleanTheCar4Free(car);
			madeServices.setCleanService(true);
		}
		return madeServices;
	}
}
