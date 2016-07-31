package org.usfirst.frc.team2363.robot.commands;

import static org.usfirst.frc.team2363.robot.Robot.*;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ThrottleCommand extends Command {

    public ThrottleCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(throttleServo);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	throttleServo.set(((-oi.getThrottle() * 0.5) + 0.5));
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
