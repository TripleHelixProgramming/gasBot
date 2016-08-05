package org.usfirst.frc.team2363.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import static org.usfirst.frc.team2363.robot.RobotMap.*;

import org.usfirst.frc.team2363.robot.commands.RunRelayCommand;

/**
 *This is the subsystem for the run permissive relay on the gas powered robot. This relay allows the gas engine to run or not run.
 */
public class RunRelay extends Subsystem {
    
    private Relay relay = new Relay(RUN_RELAY);

    /**
     * runs engine/ preps engine for ignition
     */
    public void on(){
    	relay.set(Relay.Value.kForward);
    }
    
    /**
     * kill engine
     */
    public void kill(){
    	relay.set(Relay.Value.kReverse);
    }
    
    public boolean isOn() {
    	return relay.get() == Relay.Value.kForward; //Mainly for SmartDash
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new RunRelayCommand(true));
    }
}

