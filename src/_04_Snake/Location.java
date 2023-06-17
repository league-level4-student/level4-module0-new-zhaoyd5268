package _04_Snake;

public class Location {

	private int x;
	private int y;

	public boolean equals(Location location) {
		if (this.x == location.x && this.y == location.y) {
			return true;
		} else {
			return false;			
		}

	}
}
