
package org.usfirst.frc.team2363.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team2363.robot.commands.AutoStart;
import org.usfirst.frc.team2363.robot.commands.RunRelayCommand;
import org.usfirst.frc.team2363.robot.commands.ThrottleCommand;
import org.usfirst.frc.team2363.robot.subsystems.RunRelay;
import org.usfirst.frc.team2363.robot.subsystems.StarterRelay;
import org.usfirst.frc.team2363.robot.subsystems.Steering;
import org.usfirst.frc.team2363.robot.subsystems.ThrottleServo;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static ThrottleServo throttleServo;
	public static RunRelay runRelay;
	public static StarterRelay starterRelay;
	public static Steering steering;

    Command autonomousCommand;
    SendableChooser chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		throttleServo = new ThrottleServo();
		runRelay = new RunRelay();
		starterRelay = new StarterRelay();
		steering = new Steering();
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", new ThrottleCommand());
//        chooser.addObject("My Auto", new MyAutoCommand());
//        SmartDashboard.putData("Auto mode", chooser);
        oi = new OI();
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){
    	runRelay.kill(); //Relay should automatically open, but doesn't hurt to put it here...
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
//		SmartDashboard.putNumber("Actual Servo Position", newServo.getServo());
		 SmartDashboard.putNumber("Steering Encoder", steering.getEncoder());
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        runRelay.on(); //Allows engine to prepare for use when robot is enabled and key has been turned to the "run" position. 
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Stick Input", oi.getThrottle());
        SmartDashboard.putBoolean("Run State", runRelay.isOn());
        SmartDashboard.putData("Run Engine", new RunRelayCommand(true));
        SmartDashboard.putData("KILL ENGINE", new RunRelayCommand(false));
        SmartDashboard.putBoolean("Starting?", starterRelay.isStarting());
        SmartDashboard.putData("Auto-Start", new AutoStart());
        steering.set(oi.getSteering());
        SmartDashboard.putBoolean("Right Steering Limit", steering.getLimitRight());
        SmartDashboard.putBoolean("Left Steering Limit", steering.getLimitLeft());
        SmartDashboard.putNumber("Steering Encoder", steering.getEncoder());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
