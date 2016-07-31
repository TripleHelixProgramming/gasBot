package org.usfirst.frc.team2363.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team2363.robot.Robot.*;

/**
 *
 */
public class RunRelayCommand extends Command {
	
	private boolean run;
	
	/**
     * Use to open or close the run permissive relay.  Put "true" in the parameter to allow the engine to run/prep for ignition.  Put "false" to kill the engine.
     */
    public RunRelayCommand(boolean run) {
        requires(runRelay);
        this.run = run;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (run) {
    		runRelay.on();
    	} else {
    		runRelay.kill();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
