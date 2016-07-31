package org.usfirst.frc.team2363.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import static org.usfirst.frc.team2363.robot.RobotMap.*;

import org.usfirst.frc.team2363.robot.commands.RunRelayCommand;

/**
 *
 */
public class RunRelay extends Subsystem {
    
    private Relay relay = new Relay(RUN_RELAY);

    /**
     * run engine/ prep engine for ignition
     */
    public void on(){
    	relay.set(Relay.Value.kOn);
    }
    
    /**
     * kill engine
     */
    public void kill(){
    	relay.set(Relay.Value.kOff);
    }
    
    public boolean isOn() {
    	return relay.get() == Relay.Value.kOn; //Mainly for SmartDash
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new RunRelayCommand(true));
    }
}

