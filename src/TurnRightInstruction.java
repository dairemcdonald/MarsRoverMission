
public class TurnRightInstruction implements Instruction {

	@Override
	public Vehicle Execute(Vehicle vehicle) {
		vehicle.TurnRight();
		return vehicle;
	}

}
