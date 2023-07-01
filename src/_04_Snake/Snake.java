package _04_Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class Snake {
	public static final Color SNAKE_COLOR = Color.BLUE;
	public static final int BODY_SIZE = 50;

	private SnakeSegment head;
	private ArrayList<SnakeSegment> snake;

	private Direction currentDirection;

	private boolean canMove = true;

	public Snake(Location location) {
		snake = new ArrayList<SnakeSegment>();
		head = new SnakeSegment(location, BODY_SIZE);
		snake.add(head);
		currentDirection = Direction.RIGHT;
	}

	public void feed() {
		snake.add(new SnakeSegment(snake.get(0).getLocation(), BODY_SIZE));
	}

	public Location getHeadLocation() {
		return head.getLocation();
	}

	public void update() {

		/*
		 * Create variables for the next X and Y location of the snake's head.
		 * Initialize them to the current X and Y locations.
		 */
		int snakeX = head.getLocation().getX();
		int snakeY = head.getLocation().getY();
		/*
		 * Use a switch statement to check on the currentDirection of the snake and
		 * calculate the head's next x and y position. Depending on the direction, the
		 * variables you created may increase or decrease by 1.
		 */
		switch (currentDirection) {

		case LEFT:
			snakeX -= 1;
			break;

		case RIGHT:
			snakeX += 1;
			break;

		case UP:
			snakeY -= 1;
			break;

		case DOWN:
			snakeY += 1;
			break;

		}
		

		/*
		 * Change the Location of each SnakeSegment in your snake ArrayList to the
		 * Location of the segment in front of it.
		 * 
		 * Use a loop starting at the end of the ArrayList and stop before the head of
		 * the snake (index 0) or you will go out of bounds.
		 */
		for (int i = snake.size()-1; i > 0; i--) {
				snake.get(i).setLocation(snake.get(i-1).getLocation());
		}
		/*
		 * Create a new Location object and initialize it with the values calculated in
		 * the first step. Then set the head's location equal to the new location.
		 */
		Location loc = new Location(snakeX, snakeY);
		head.setLocation(loc);
		// Set the canMove member variable to true.
		canMove = true;
	}

	public void setDirection(Direction direction) {

		/*
		 * If the passed in direction is not the opposite direction of currentDirection
		 * and canMove is true, set currentDirection to the passed in direction and
		 * canMove to false
		 * 
		 * Hint: Use the isNotOppositeDirection method.
		 */
		boolean tof = isNotOppositeDirection(direction);

		if (tof == true && canMove == true) {
			currentDirection = direction;
			canMove = false;
		}
	}

	private boolean isNotOppositeDirection(Direction direction) {

		switch (direction) {

		case UP:
			if (currentDirection != direction.DOWN) {
				return true;
			} else {
				return false;
			}

		case DOWN:
			if (currentDirection != direction.UP) {
				return true;
			} else {
				return false;
			}

		case LEFT:
			if (currentDirection != direction.RIGHT) {
				return true;
			} else {
				return false;
			}

		case RIGHT:
			if (currentDirection != direction.LEFT) {
				return true;
			} else {
				return false;
			}
		default:
			System.out.println("ur mom");
			return false;
		}
		/*
		 * Complete the method so it returns true if the passed in direction is not the
		 * opposite direction of currentDirection.
		 * 
		 * For example, if currentDirection is UP and the passed in direction is DOWN
		 * this method should return false.
		 */

	}

	public void resetLocation() {

		// Clear the snake.
		snake.clear();
		/*
		 * Create a new Location object for the head at SnakeGame.WIDTH / 2,
		 * SnakeGame.HEIGHT / 2.
		 */
		Location loca = new Location(SnakeGame.WIDTH / 2, SnakeGame.HEIGHT / 2);
		/*
		 * Set the head member variable equal to a new SnakeSegment object. Use the
		 * Location created in step 2 for the Location and the BODY_SIZE constant for
		 * the size.
		 */
		head = new SnakeSegment(loca, BODY_SIZE);
		// Add the head to the snake.
		snake.add(head);
	}

	public boolean isOutOfBounds() {

		/*
		 * Complete the method so it returns true if the head of the snake is outside of
		 * the window and false otherwise.
		 */
		if (head.getLocation().getX() > SnakeGame.WIDTH) {
			return true;
		}
		if (head.getLocation().getX() < 0) {
			return true;
		} 
		if (head.getLocation().getY() > SnakeGame.HEIGHT) {
			return true;
		} 
		if (head.getLocation().getY() < 0) {
			return true;
		} else {
			return false;
		}

	}

	public boolean isHeadCollidingWithBody() {

		/*
		 * Complete the method so it returns true if the head is located in the same
		 * location as any other body segment.
		 */
		for(int i = 1; i < snake.size(); i++) {
			if (head.getLocation() == snake.get(i).getLocation()) {
				return true;
			} 
		}

		return false;
	}

	public boolean isLocationOnSnake(Location loc) {

		/*
		 * Complete the method so it returns true if the passed in location is located
		 * on the snake.
		 */
		for (int i = 0; i < snake.size(); i++) {
			if (loc.equals(snake.get(i).getLocation())) {
				return true;
			}
		}
		return false;
	}

	public void draw(Graphics g) {
		for (SnakeSegment s : snake) {
			s.draw(g);
		}
	}
}
