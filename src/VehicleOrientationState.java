
public interface VehicleOrientationState {

	Coords Move(Coords input);
	
	VehicleOrientationState TurnLeft();
	
	VehicleOrientationState TurnRight();
	
}
