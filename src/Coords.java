
public class Coords {
 private int x;
 private int y;
 
 Coords(int x, int y){
	 this.x = x;
	 this.y = y;
 }

 
 public int MoveXByAmount(int amount) {
	 return x = x + amount;
 }
 
 public int MoveYByAmount(int amount){
	 return y = y + amount; 
 }
 
 @Override
 public String toString() {
	 return x + " " + y;
 }


public boolean IsNegative() {
	if(x < 0 || y < 0) {
		return true;
	}
	else{
		return false;
	}
}

public boolean Compare(Coords coords) {
	if(x > coords.x || y > coords.y) {
		return true;
	}
	
	else{
		return false;
	}
}
}
