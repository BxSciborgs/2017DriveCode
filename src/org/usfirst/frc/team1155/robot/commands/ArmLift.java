
package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Robot;
import org.usfirst.frc.team1155.robot.subsystems.PIDLiftSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmLift extends Command {
	private PIDLiftSubsystem pidLift = Robot.pidLift;
	private final double BUFFER_TICKS = 8;
	
	//In encoder pulses.
	private double requestedDistance = 0;

	public ArmLift(double distance) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.pidLift);
		requestedDistance = distance;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		// TODO: Fill these mofos in hollah
		pidLift.setSpeed(0);
		pidLift.encoder.reset();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		pidLift.correctSpeed();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
        return (Math.abs(pidLift.getEncoderDistance() - requestedDistance) < BUFFER_TICKS);
    }

	// Called once after isFinished returns true
	protected void end() {
		initialize();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
