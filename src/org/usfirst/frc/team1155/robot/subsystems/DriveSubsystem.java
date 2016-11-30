package org.usfirst.frc.team1155.robot.subsystems;

import org.usfirst.frc.team1155.robot.Hardware;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {

	private Joystick leftJoy, rightJoy;
	private CANTalon frontLeft, frontRight, backLeft, backRight;
	
	
	public DriveSubsystem() {
		leftJoy = Hardware.INSTANCE.leftJoy;
		rightJoy = Hardware.INSTANCE.rightJoy;
		
		frontLeft = Hardware.INSTANCE.frontLeft;
		frontRight = Hardware.INSTANCE.frontRight;
		backLeft = Hardware.INSTANCE.backLeft;
		backRight = Hardware.INSTANCE.backRight;

	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	
}
