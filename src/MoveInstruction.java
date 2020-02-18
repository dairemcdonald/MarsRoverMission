
public class MoveInstruction implements Instruction {

	@Override
	public Vehicle Execute(Vehicle vehicle) {
		vehicle.Move();
		return vehicle;
	}

}
