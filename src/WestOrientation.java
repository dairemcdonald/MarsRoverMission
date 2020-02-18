
public class WestOrientation implements VehicleOrientationState {
	
	@Override
	public Coords Move(Coords input) {
		input.MoveXByAmount(-1);
		return input;
	}

	@Override
	public VehicleOrientationState TurnLeft() {
		return new SouthOrientation();
	}

	@Override
	public VehicleOrientationState TurnRight() {
		return new NorthOrientation();
	}

	@Override
	public String toString() {
		return new String("W");
	}
	
}
