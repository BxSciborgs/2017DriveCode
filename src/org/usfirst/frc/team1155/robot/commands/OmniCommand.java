package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Hardware;
import org.usfirst.frc.team1155.robot.Robot;
import org.usfirst.frc.team1155.robot.subsystems.OmniDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class OmniCommand extends Command {

	private Joystick directionJoystick, rotationJoystick;
	private OmniDrive driveControl;
	private Gyro gyro;

	private double driveAngle, driveMagnitude, motorPair1, motorPair2;

	public OmniCommand() {
		requires(Robot.drive);

		directionJoystick = Hardware.INSTANCE.leftJ;
		rotationJoystick = Hardware.INSTANCE.rightJ;
		gyro = Hardware.INSTANCE.gyro;

		driveControl = Robot.drive;

		driveAngle = 0;
		driveMagnitude = 0;
	}

	@Override
	protected void initialize() {
		gyro.reset();
	}

	@Override
	protected void execute() {

		// robot rotation
		if (rotationJoystick.getX() != 0) {
			if (rotationJoystick.getX() > 0) {
				driveControl.setTalonsTo(1, -1, -1, 1); // rotate right
			} else if (rotationJoystick.getY() < 0) {
				driveControl.setTalonsTo(-1, 1, 1, -1); // rotate left
			}
		} else {
			driveAngle = directionJoystick.getDirectionDegrees() - calibrateAngle(gyro.getAngle()) + 45;

			// adjusts speed relative to joystick magnitude
			driveMagnitude = directionJoystick.getMagnitude();

			// motors 1 & 3
			motorPair1 = Math.sin(driveAngle) * driveMagnitude;
			// motors 2 & 4
			motorPair2 = Math.cos(driveAngle) * driveMagnitude;

			driveControl.setTalonsTo(motorPair1, motorPair2, motorPair1, motorPair2);
		}
	}

	// changes angle to be in a range between 0 <= angle <= 360
	public double calibrateAngle(double angle) {
		return angle % 360;
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
