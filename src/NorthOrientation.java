
public class NorthOrientation implements VehicleOrientationState {

	@Override
	public Coords Move(Coords input) {
		input.MoveYByAmount(1);
		return input;
	}

	@Override
	public VehicleOrientationState TurnLeft() {
		return new WestOrientation();
	}

	@Override
	public VehicleOrientationState TurnRight() {
		return new EastDirection();
	}

	@Override
	public String toString() {
		return "N";
	}



}
