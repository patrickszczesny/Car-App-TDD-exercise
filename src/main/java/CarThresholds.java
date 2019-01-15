import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class CarThresholds {
	@Getter
	final int fuelThreshold;

	@Getter
	final int cleanThreshold;

	@Getter
	final int tiresThreshold;

}
