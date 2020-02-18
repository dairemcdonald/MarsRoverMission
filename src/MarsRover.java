import java.util.*;

public class MarsRover implements Vehicle {
	
	private Coords position;
	private Coords limits;
	private VehicleOrientationState currentOrientation;
	private Map<Character, VehicleOrientationState> orientationMap = new HashMap<Character,VehicleOrientationState>() {{
		put('N', new NorthOrientation());
		put('S', new SouthOrientation());
		put('E', new EastDirection());
		put('W', new WestOrientation());
		}}; 
	
	
	public MarsRover(Coords limits, Coords position, char orientation) {
		ValidateLimits(limits);
		this.limits = limits;
		
		ValidatePosition(position, "Invalid positions was inputted for vehicle");
		this.position = position;
		
		ValidateOrientation(orientation);
		currentOrientation = orientationMap.get(orientation);
	}
	
	private void ValidateLimits(Coords limits) {
		if (limits.IsNegative()){
			throw new IllegalArgumentException("Invalid limits were inputted for vehicle");
		}
	}
	
	private void ValidatePosition(Coords position, String message) {
		if (position.IsNegative() || position.Compare(limits)){
			throw new IllegalArgumentException(message);
		}
	}
	
	private void ValidateOrientation(Character orientation) {
		if (!orientationMap.containsKey(orientation)){
			throw new IllegalArgumentException("Invalid orientation was inputted for vehicle");
		}
	}
	
	@Override
	public void Move() {
		currentOrientation.Move(position);
		ValidatePosition(position, "Vehicle has moved out of bounds");
	}

	@Override
	public void TurnLeft() {
		currentOrientation = currentOrientation.TurnLeft();
	}

	@Override
	public void TurnRight() {
		currentOrientation = currentOrientation.TurnRight();
	}

	@Override
	public String toString() {
		return position.toString() + " " + currentOrientation.toString();
	}

	
}
