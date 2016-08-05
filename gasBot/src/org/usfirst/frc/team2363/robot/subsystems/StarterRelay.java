package org.usfirst.frc.team2363.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import static org.usfirst.frc.team2363.robot.RobotMap.*;

import org.usfirst.frc.team2363.robot.commands.AutoStart;

/**
 *This is the subsystem for the engine starter relay on the gas powered robot. This allows the gas engine to be started remotely.
 */
public class StarterRelay extends Subsystem {
    
    private Relay relay = new Relay(STARTER_RELAY);
    
    /**
     * Run this method to run an automated remote start of the gas engine on the gas powered robot. This runs the starter for 3 seconds.
     */
/*    public void autoOn() {
    	on();
    	try {
			wait(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	off();
    }*/
    
    /**
     * Closes the starter relay.
     */
    public void on() {
    	relay.set(Relay.Value.kForward);
    }
    
    /**
     * Opens the starter relay.
     */
    public void off() {
    	relay.set(Relay.Value.kReverse);
    }
    
    public boolean isStarting() {
    	return relay.get() == Relay.Value.kForward;
    }
    
    public void initDefaultCommand() {
//        setDefaultCommand(new AutoStart());
    }
}

