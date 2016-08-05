package org.usfirst.frc.team2363.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.command.Subsystem;
import static org.usfirst.frc.team2363.robot.RobotMap.*;

/**
 *
 */
public class Steering extends Subsystem {
    
    private CANTalon steer = new CANTalon(STEERING_CAN);
    
    public Steering() {
    	steer.configEncoderCodesPerRev(1);
		steer.reverseSensor(true);
		steer.setEncPosition(0);
		steer.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		steer.enableLimitSwitch(true, true);
//		steer.enableControl();
	}
    
    public void set(double value) {
    	steer.set(value);
    }
    
    public double getEncoder() {
    	return steer.get();
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

