package org.usfirst.frc.team2363.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
	//PS4 port
	public static final int PS4_PORT = 0;
	
	//PS4 Axis
	public static final int LEFT_STICK_X = 0; //steering
//	public static final int LEFT_STICK_Y = 1;
//	public static final int RIGHT_STICK_X = 2;	
	public static final int LEFT_TRIGGER = 3; //brake
	public static final int RIGHT_TRIGGER = 4; //throttle
//	public static final int RIGHT_STICK_Y = 5;
	
	//PS4 Buttons
//	public static final int SQUARE = 1;
//	public static final int X = 2;
	public static final int CIRCLE = 3; //kill engine
//	public static final int TRIANGLE = 4;
//	public static final int L1 = 5;
//	public static final int R1 = 6;
//	public static final int L2 = 7;
//	public static final int R2 = 8;
//	public static final int SHARE = 9;
//	public static final int OPTIONS = 10;
//	public static final int L3 = 11;
//	public static final int R3 = 12;
//	public static final int PS = 13;
//	public static final int TOUCHPAD = 14;
	
	//PWM
	public static final int SERVO_PORT = 0; //Used for throttle control
	
	//Relays
	public static final int RUN_RELAY = 0; //kill switch
	public static final int STARTER_RELAY = 1; //remote start
	public static final int PERFORMANCE_RELAY = 2; //switch between race/economical modes
}
