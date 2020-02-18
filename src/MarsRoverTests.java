import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MarsRoverTests {

	Coords limits;
	Coords position;
	Vehicle vehicle;

	@BeforeEach
	void setUp() {
		limits = new Coords(5, 5);
		position = new Coords(1, 1);
		vehicle = new MarsRover(limits, position, 'N');
	}

	@Test
	void InstructionsSuccess1() {
		position = new Coords(1, 2);
		vehicle = new MarsRover(limits, position,  'N');
		MarsRoverController controller = new MarsRoverController(vehicle);
		String instructions = "LMLMLMLMM";
		controller.ProcessInstructions(instructions);
		assertEquals("1 3 N", controller.GetVehicleOutput());
	}

	
	@Test
	void InstructionsSuccess2() {
		position = new Coords(3, 3);
		vehicle = new MarsRover(limits, position, 'E');
		MarsRoverController controller = new MarsRoverController(vehicle);
		String instructions = "MMRMMRMRRM";
		controller.ProcessInstructions(instructions);
		assertEquals("5 1 E", controller.GetVehicleOutput());
	}
	
	
	@Test
	void InvalidInstructionsInput() {
		MarsRoverController controller = new MarsRoverController(vehicle);
		String instructions = "TTTT";
		assertThrows(IllegalArgumentException.class, () -> {controller.ProcessInstructions(instructions);});
	}
	
	
	@Test
	void InvalidVehicleInput() {
		position = new Coords(-1, 1);
		assertThrows(IllegalArgumentException.class, () -> { new MarsRover(limits, position, 'N');});

		position = new Coords(1, -1);
		assertThrows(IllegalArgumentException.class, () -> { new MarsRover(limits, position, 'N');});
		
		position = new Coords(1, 1);
		assertThrows(IllegalArgumentException.class, () -> { new MarsRover(limits, position, 'Q');});
	}
	
	@Test
	void InvalidLimitsInput() {
		limits = new Coords (-1, -1);
		assertThrows(IllegalArgumentException.class, () -> new MarsRover(limits, position, 'N'));
	}
	
	@Test
	void VehicleMovement() {
		vehicle.Move();
		assertEquals("1 2 N", vehicle.toString());
		
		vehicle = new MarsRover(limits, position, 'S');
		vehicle.Move();
		assertEquals("1 1 S", vehicle.toString());
		
		vehicle = new MarsRover(limits, position, 'E');
		vehicle.Move();
		assertEquals("2 1 E", vehicle.toString());
		
		vehicle = new MarsRover(limits, position, 'W');
		vehicle.Move();
		assertEquals("1 1 W", vehicle.toString());
	}
	
	@Test
	void VehicleStateMovement() {
		Coords coordsActual = new Coords(1, 1);
		Coords coordsExpected = new Coords(1, 2);
		VehicleOrientationState state = new NorthOrientation();
		assertEquals(coordsExpected.toString(), state.Move(coordsActual).toString());
		

		coordsActual = new Coords(1, 1);
		coordsExpected = new Coords(1, 0);
		state = new SouthOrientation();
		assertEquals(coordsExpected.toString(), state.Move(coordsActual).toString());
		

		coordsActual = new Coords(1, 1);
		coordsExpected = new Coords(2, 1);
		state = new EastDirection();
		assertEquals(coordsExpected.toString(), state.Move(coordsActual).toString());
		

		coordsActual = new Coords(1, 1);
		coordsExpected = new Coords(0, 1);
		state = new WestOrientation();
		assertEquals(coordsExpected.toString(), state.Move(coordsActual).toString());
	}
	
	@Test
	void CoordsMovement() {

		Coords coordsActual = new Coords(1, 1);
		Coords coordsExpected = new Coords(2, 1);
		coordsActual.MoveXByAmount(1);
		assertEquals(coordsExpected.toString(), coordsActual.toString());
		
		coordsActual = new Coords(1, 1);
		coordsExpected = new Coords(0, 1);
		coordsActual.MoveXByAmount(-1);
		assertEquals(coordsExpected.toString(), coordsActual.toString());
		
		coordsActual = new Coords(1, 1);
		coordsExpected = new Coords(1, 1);
		coordsActual.MoveXByAmount(0);
		assertEquals(coordsExpected.toString(), coordsActual.toString());
		
		coordsActual = new Coords(1, 1);
		coordsExpected = new Coords(1, 2);
		coordsActual.MoveYByAmount(1);
		assertEquals(coordsExpected.toString(), coordsActual.toString());
		
		coordsActual = new Coords(1, 1);
		coordsExpected = new Coords(1, 0);
		coordsActual.MoveYByAmount(-1);
		assertEquals(coordsExpected.toString(), coordsActual.toString());
		
		coordsActual = new Coords(1, 1);
		coordsExpected = new Coords(1, 1);
		coordsActual.MoveYByAmount(0);
		assertEquals(coordsExpected.toString(), coordsActual.toString());
		
	}
	
	@Test
	void VehicleTurnLeft() {
		vehicle.TurnLeft();
		assertEquals("1 1 W", vehicle.toString());
		
		vehicle.TurnLeft();
		assertEquals("1 1 S", vehicle.toString());
		
		vehicle.TurnLeft();
		assertEquals("1 1 E", vehicle.toString());
		
		vehicle.TurnLeft();
		assertEquals("1 1 N", vehicle.toString());
		
	}
	
	@Test
	void VehicleStateTurnLeft() {
		VehicleOrientationState stateActual = new NorthOrientation();
		VehicleOrientationState stateExpected = new WestOrientation();
		
		assertEquals(stateExpected.toString(), stateActual.TurnLeft().toString());
		
		stateActual = new WestOrientation();
		stateExpected = new SouthOrientation();
		assertEquals(stateExpected.toString(), stateActual.TurnLeft().toString());
		
		stateActual = new SouthOrientation();
		stateExpected = new EastDirection();
		assertEquals(stateExpected.toString(), stateActual.TurnLeft().toString());
		
		stateActual = new EastDirection();
		stateExpected = new NorthOrientation();
		assertEquals(stateExpected.toString(), stateActual.TurnLeft().toString());
	}
	
	@Test
	void VehicleTurnRight() {
		vehicle.TurnRight();
		assertEquals("1 1 E", vehicle.toString());
		
		vehicle.TurnRight();
		assertEquals("1 1 S", vehicle.toString());
		
		vehicle.TurnRight();
		assertEquals("1 1 W", vehicle.toString());
		
		vehicle.TurnRight();
		assertEquals("1 1 N", vehicle.toString());
	}
	
	@Test
	void VehicleStateTurnRight() {
		VehicleOrientationState stateActual = new NorthOrientation();
		VehicleOrientationState stateExpected = new EastDirection();
		assertEquals(stateExpected.toString(), stateActual.TurnRight().toString());
		
		stateActual = new EastDirection();
		stateExpected = new SouthOrientation();
		assertEquals(stateExpected.toString(), stateActual.TurnRight().toString());
		
		stateActual = new SouthOrientation();
		stateExpected = new WestOrientation();
		assertEquals(stateExpected.toString(), stateActual.TurnRight().toString());
		
		stateActual = new WestOrientation();
		stateExpected = new NorthOrientation();
		assertEquals(stateExpected.toString(), stateActual.TurnRight().toString());
	}
	
	@Test
	void MoveOutOfBoundaries() {
		limits = new Coords (1, 1);
		vehicle = new MarsRover(limits, position, 'N');
		MarsRoverController controller = new MarsRoverController(vehicle);
		String instructions = "M";
		assertThrows(IllegalArgumentException.class, () -> controller.ProcessInstructions(instructions));
	}
	
	@Test
	void ToStringValid() {
		VehicleOrientationState state = new NorthOrientation();
		Coords coords = new Coords(1, 1);
		
		assertEquals("1 1", coords.toString());
		assertEquals("N", state.toString());
		assertEquals("1 1 N", vehicle.toString());
	}
}
