import lombok.*;


@RequiredArgsConstructor
class Car {

	@Getter
	final String name;

	@Setter
	@Getter
	int currentFuelLevel;

	@Getter
	final int maxFuelLevel;

	@Getter
	final FuelType fuelType;

	@Setter
	@Getter
	int cleanValue;

	@Setter
	@Getter
	int TireWearStatus;

	@NonNull
	CarThresholds carThresholds;

	int getFuelThreshold(){return carThresholds.getFuelThreshold();}
	int getTiresThreshold(){return carThresholds.getTiresThreshold();}
	int getCleanThreshold(){return carThresholds.getCleanThreshold();}
}

