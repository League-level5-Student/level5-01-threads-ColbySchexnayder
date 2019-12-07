package _01_Olympic_Rings;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		Robot rob[] = new Robot[5];
		
		for(int i = 0; i < rob.length; i++) {
			rob[i] = new Robot();
			rob[i].setSpeed(500);
			rob[i].setX(300 + 50*i);
			rob[i].setY(300 - 50*(i%2));
			
			rob[i].hide();
			rob[i].penDown();
		}
		
		Thread th0 = new Thread(()->circle(rob[0]));
		Thread th1 = new Thread(()->circle(rob[1]));
		Thread th2 = new Thread(()->circle(rob[2]));
		Thread th3 = new Thread(()->circle(rob[3]));
		Thread th4 = new Thread(()->circle(rob[4]));
		
		th0.start();
		th1.start();
		th2.start();
		th3.start();
		th4.start();
	}
	
	public static void circle(Robot r) {
		for (int i = 0; i < 360; i++) {
			r.move(1);
			r.turn(1);
		}
	}
}

