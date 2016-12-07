package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Robot;
import org.usfirst.frc.team1155.robot.subsystems.MecanumDriveSubsystem;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class MecanumDrive extends Command {
	private static MecanumDriveSubsystem mecanum = Robot.mecanum;
	private Joystick controller;
	private CANTalon topLeft, topRight, botLeft, botRight;
	private final double BUFFER = 0.1;
	private final double ANGLE_BUFFER = 10;

	public MecanumDrive(Joystick c) {
		controller = c;
		topLeft = mecanum.topLeftTalon;
		topRight = mecanum.topRightTalon;
		botLeft = mecanum.botLeftTalon;
		botRight = mecanum.botRightTalon;
	}

	@Override
	protected void initialize() {
		requires(mecanum);
	}

	@Override
	protected void execute() {
		// Tests for twisting first.
		if (controller.getTwist() >= BUFFER || controller.getTwist() <= -BUFFER) {
			mecanum.setWheelSpeed(topRight, controller.getTwist());
			mecanum.setWheelSpeed(botRight, controller.getTwist());
			mecanum.setWheelSpeed(topLeft, -controller.getTwist());
			mecanum.setWheelSpeed(botLeft, -controller.getTwist());
		}
		// Tests for x and y
		else if (Math.abs(controller.getX()) > BUFFER && Math.abs(controller.getY()) > BUFFER) {
			double x = controller.getX();
			double y = controller.getY();
			double angle = Math.toDegrees(Math.atan(y / x));
			if (x < 0 && y > 0 || x == 0 && y == 1)
				angle += 90;
			else if (x < 0 && y < 0 || x == -1 && y == 0)
				angle += 180;
			else if (x > 0 && y < 0 || x == 0 && y == -1)
				angle += 270;
			// Now moves in direction of angle.
			if ((angle <= ANGLE_BUFFER || angle >= 360 - ANGLE_BUFFER) || Math.abs(180 - angle) <= ANGLE_BUFFER) {
				// LEFT OR RIGHT
				mecanum.setWheelSpeed(topRight, -x);
				mecanum.setWheelSpeed(botRight, x);
				mecanum.setWheelSpeed(topLeft, x);
				mecanum.setWheelSpeed(botLeft, -x);
			} else if (Math.abs(90 - angle) <= ANGLE_BUFFER || Math.abs(270 - angle) <= ANGLE_BUFFER) {
				// UP OR DOWN
				mecanum.setWheelSpeed(topRight, y);
				mecanum.setWheelSpeed(botRight, y);
				mecanum.setWheelSpeed(topLeft, y);
				mecanum.setWheelSpeed(botLeft, y);
			} else if ((angle < 90 - ANGLE_BUFFER && angle > ANGLE_BUFFER)
					|| (angle < 270 - ANGLE_BUFFER && angle > 180 + ANGLE_BUFFER)) {
				// UPRIGHT or DOWNLEFT
				double speed = Math.sqrt(x * x + y * y) / Math.sqrt(2) * (y > 0 ? 1 : -1);
				mecanum.setWheelSpeed(topLeft, speed);
				mecanum.setWheelSpeed(botRight, speed);
			} else if ((angle < 180 - ANGLE_BUFFER && angle > 90 + ANGLE_BUFFER)
					|| (angle < 360 - ANGLE_BUFFER && angle > 270 + ANGLE_BUFFER)) {
				// UPLEFT or DOWNRIGHT
				double speed = Math.sqrt(x * x + y * y) / Math.sqrt(2) * (y > 0 ? 1 : -1);
				mecanum.setWheelSpeed(botLeft, speed);
				mecanum.setWheelSpeed(topRight, speed);
			}

		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		mecanum.setWheelSpeed(topRight, 0);
		mecanum.setWheelSpeed(botRight, 0);
		mecanum.setWheelSpeed(topLeft, 0);
		mecanum.setWheelSpeed(botLeft, 0);

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
