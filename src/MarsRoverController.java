import java.util.HashMap;
import java.util.Map;

public class MarsRoverController {
	
	private Vehicle vehicle;
	
	private Map<Character, Instruction> charMap = new HashMap<Character,Instruction>() {{
		put('M', new MoveInstruction());
		put('L', new TurnRightInstruction());
		put('R', new TurnRightInstruction());
	}};
	
	MarsRoverController(Vehicle vehicle){
		this.vehicle = vehicle;
	}
	
	void ProcessInstructions(String instructions) 
	{
		for(int i = 0; i < instructions.length(); i++){
			char instruction = instructions.charAt(i);
			TryInstruction(instruction);
		}
	}

	private void TryInstruction(char instructionChar){
		try{
			Instruction instruction= charMap.get(instructionChar);
			instruction.Execute(vehicle);
			}
		catch(Exception e){
				throw new IllegalArgumentException("The instruction is invalid");
			}
	}
	
	String GetVehicleOutput () {
		return vehicle.toString();
	}
}
