package _04_Snake;

public class Location {

	private int x;
	private int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean equals(Location location) {
		if (this.x == location.x && this.y == location.y) {
			return true;
		} else {
			return false;			
		}

	}

	public int getX() {
		
		return x;
	}

	public int getY() {
		
		return y;
	}
}
