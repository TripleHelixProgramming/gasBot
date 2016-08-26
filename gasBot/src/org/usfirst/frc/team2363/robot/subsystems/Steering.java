package org.usfirst.frc.team2363.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import static org.usfirst.frc.team2363.robot.RobotMap.*;

/**
 *
 */
public class Steering extends Subsystem {
    
    private CANTalon steer = new CANTalon(STEERING_CAN);
    private final int rightLimit = 23850;
    private final int leftLimit = 22713;
    private final int center = (rightLimit + leftLimit) / 2;
    
    public Steering() {
//		steer.reverseSensor(true);
		steer.setFeedbackDevice(FeedbackDevice.AnalogEncoder);
		steer.changeControlMode(TalonControlMode.Position);
		steer.enableControl();
		steer.enable();
		steer.reverseOutput(true);
//		steer.setPID(0.0000001, 0, 0);
	}
    
    public void set(double value) {
    	steer.setSetpoint(center + value * (center));
    }
    
    public double getEncoder() {
    	return steer.getAnalogInPosition();
    }
    
    public boolean getLimitLeft() {
    	return steer.isFwdLimitSwitchClosed();
    }
    
    public boolean getLimitRight() {
    	return steer.isRevLimitSwitchClosed();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

