
public class EastDirection implements VehicleOrientationState {

	@Override
	public Coords Move(Coords input) {
		input.MoveXByAmount(1);
		return input;
	}

	@Override
	public VehicleOrientationState TurnLeft() {
		return new NorthOrientation();
	}

	@Override
	public VehicleOrientationState TurnRight() {
		return new SouthOrientation();
	}

	@Override
	public String toString() {
		return "E";
	}


}
