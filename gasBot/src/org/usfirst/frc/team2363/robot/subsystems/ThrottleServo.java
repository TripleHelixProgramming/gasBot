package org.usfirst.frc.team2363.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

import static org.usfirst.frc.team2363.robot.RobotMap.*;

import org.usfirst.frc.team2363.robot.commands.ThrottleCommand;

/**
 *
 */
public class ThrottleServo extends Subsystem {
    
	private Servo servo = new Servo(SERVO_PORT);
	
	public void set(double value){
		servo.set(value);
	}
	
	public double get() {
		return servo.get();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ThrottleCommand());
    }
}

