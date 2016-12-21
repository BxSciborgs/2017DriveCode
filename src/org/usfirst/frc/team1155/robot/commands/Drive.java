package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Robot;
import org.usfirst.frc.team1155.robot.subsystems.MecanumDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {
    private static MecanumDrive mecanum = Robot.mecanum;
    private Joystick controller;
    private CANTalon frontLeft, frontRight, backLeft, backRight;
    private final double BUFFER = 0.1;
    private final double ANGLE_BUFFER = 10;

    public Drive(Joystick c) {
        controller = c;
        frontLeft = mecanum.frontLeftTalon;
        frontRight = mecanum.frontRightTalon;
        backLeft = mecanum.backLeftTalon;
        backRight = mecanum.backRightTalon;
    }

    @Override
    protected void initialize() {
        requires(mecanum);
    }

    @Override
    protected void execute() {
        // Tests for twisting first.
        if (controller.getTwist() >= BUFFER || controller.getTwist() <= -BUFFER) {
            mecanum.setWheelSpeed(frontRight, controller.getTwist());
            mecanum.setWheelSpeed(backRight, controller.getTwist());
            mecanum.setWheelSpeed(frontLeft, -controller.getTwist());
            mecanum.setWheelSpeed(backLeft, -controller.getTwist());
        }
        // Tests for x and y
        else if (Math.abs(controller.getX()) > BUFFER && Math.abs(controller.getY()) > BUFFER) {
            double x = controller.getX();
            double y = controller.getY();
            double angle = Math.toDegrees(Math.atan(y / x));
            if (x < 0 && y > 0 || x == 0 && y == 1) {
                angle += 90;
            } else if (x < 0 && y < 0 || x == -1 && y == 0) {
                angle += 180;
            } else if (x > 0 && y < 0 || x == 0 && y == -1) {
                angle += 270;
            }
            // Now moves in direction of angle.
            if ((angle <= ANGLE_BUFFER || angle >= 360 - ANGLE_BUFFER) || Math.abs(180 - angle) <= ANGLE_BUFFER) {
                // LEFT OR RIGHT
                mecanum.setWheelSpeed(frontRight, -x);
                mecanum.setWheelSpeed(backRight, x);
                mecanum.setWheelSpeed(frontLeft, x);
                mecanum.setWheelSpeed(backLeft, -x);
            } else if (Math.abs(90 - angle) <= ANGLE_BUFFER || Math.abs(270 - angle) <= ANGLE_BUFFER) {
                // UP OR DOWN
                mecanum.setWheelSpeed(frontRight, y);
                mecanum.setWheelSpeed(backRight, y);
                mecanum.setWheelSpeed(frontLeft, y);
                mecanum.setWheelSpeed(backLeft, y);
            } else if ((angle < 90 - ANGLE_BUFFER && angle > ANGLE_BUFFER)
                    || (angle < 270 - ANGLE_BUFFER && angle > 180 + ANGLE_BUFFER)) {
                // UPRIGHT or DOWNLEFT
                double speed = Math.sqrt(x * x + y * y) / Math.sqrt(2) * (y > 0 ? 1 : -1);
                mecanum.setWheelSpeed(frontLeft, speed);
                mecanum.setWheelSpeed(backRight, speed);
            } else if ((angle < 180 - ANGLE_BUFFER && angle > 90 + ANGLE_BUFFER)
                    || (angle < 360 - ANGLE_BUFFER && angle > 270 + ANGLE_BUFFER)) {
                // UPLEFT or DOWNRIGHT
                double speed = Math.sqrt(x * x + y * y) / Math.sqrt(2) * (y > 0 ? 1 : -1);
                mecanum.setWheelSpeed(backLeft, speed);
                mecanum.setWheelSpeed(frontRight, speed);
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
        mecanum.setWheelSpeed(frontRight, 0);
        mecanum.setWheelSpeed(backRight, 0);
        mecanum.setWheelSpeed(frontLeft, 0);
        mecanum.setWheelSpeed(backLeft, 0);

    }

    @Override
    protected void interrupted() {
        // TODO Auto-generated method stub

    }

}
