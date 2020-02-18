
public class TurnLeftInstruction implements Instruction {

	@Override
	public Vehicle Execute(Vehicle vehicle) {
		vehicle.TurnLeft();
		return vehicle;
	}

}
