package org.usfirst.frc.team1155.robot.subsystems;

import org.usfirst.frc.team1155.robot.PortMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class MecanumDrive extends Subsystem {
    public CANTalon frontLeftTalon, frontRightTalon, backLeftTalon,backRightTalon;

    public MecanumDrive() {
        frontLeftTalon = new CANTalon(PortMap.FRONT_LEFT_TALON);
        frontRightTalon = new CANTalon(PortMap.FRONT_RIGHT_TALON);
        backLeftTalon = new CANTalon(PortMap.BACK_LEFT_TALON);
        backRightTalon = new CANTalon(PortMap.BACK_RIGHT_TALON);
    }

    public void setWheelSpeed(CANTalon wheel, double speed) {
        wheel.set(speed);
    }

    @Override
    protected void initDefaultCommand() {

    }

}
