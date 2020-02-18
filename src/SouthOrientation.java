
public class SouthOrientation implements VehicleOrientationState {

	@Override
	public Coords Move(Coords input) {
		input.MoveYByAmount(-1);
		return input;
	}

	@Override
	public VehicleOrientationState TurnLeft() {
		return new EastDirection();
	}

	@Override
	public VehicleOrientationState TurnRight() {
		return new WestOrientation();
	}

	@Override
	public String toString() {
		return "S";
	}

}
