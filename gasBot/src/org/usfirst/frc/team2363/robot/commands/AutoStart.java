package org.usfirst.frc.team2363.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team2363.robot.Robot.*;

/**
 *Use this command to automatically start the gas engine.
 */
public class AutoStart extends Command {

    public AutoStart() {
        requires(starterRelay);
        setTimeout(3);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	starterRelay.on();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	starterRelay.off();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
