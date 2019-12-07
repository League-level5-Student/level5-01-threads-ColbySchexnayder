package _02_Advanced_Robot_Race;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace extends Thread{
	// Re-do the robot race recipe from level 3 module 0. 
	// This time, use threads to make all of the robots go at the same time.
	Robot rob;
	Random rand;
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new AdvancedRobotRace(i).start();
		}
	}
	
	public AdvancedRobotRace(int position) {
		rob = new Robot(250+200*position, 500);
		rob.setSpeed(10);
		
		rand = new Random();
	}
	
	@Override
	public void run() {
		while(rob.getY() > 0)
			rob.move(rand.nextInt(50));
	}
}
