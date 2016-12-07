package org.usfirst.frc.team1155.robot.subsystems;

import org.usfirst.frc.team1155.robot.Hardware;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {

	private Joystick leftJoy, rightJoy;
	// private CANTalon frontLeft, frontRight, backLeft, backRight;
	private CANTalon frontLeftDM, frontRightDM, backLeftDM, backRightDM, frontLeftSM, frontRightSM, backLeftSM,
			backRightSM;
	private CANTalon[] DMArray = {frontLeftDM, frontRightDM, backLeftDM, backRightDM};
	private CANTalon[] SMArray = {frontLeftSM, frontRightSM, backLeftSM, backRightSM};

	public DriveSubsystem() {
		leftJoy = Hardware.INSTANCE.leftJoy;
		rightJoy = Hardware.INSTANCE.rightJoy;
		
		
		frontLeftDM = Hardware.INSTANCE.frontLeftDM;
		frontRightDM = Hardware.INSTANCE.frontRightDM;
		backLeftDM = Hardware.INSTANCE.backLeftDM;
		backRightDM = Hardware.INSTANCE.backRightDM;
		frontLeftSM = Hardware.INSTANCE.frontLeftSM;
		frontRightSM = Hardware.INSTANCE.frontRightSM;
		backLeftSM = Hardware.INSTANCE.backLeftSM;
		backRightSM = Hardware.INSTANCE.backRightSM;

	}

	public void crab() {
		
		frontRightDM.changeControlMode(TalonControlMode.Follower);
		frontRightDM.set(frontLeftDM.getDeviceID());
		backLeftDM.changeControlMode(TalonControlMode.Follower);
		backLeftDM.set(frontLeftDM.getDeviceID());
		backRightDM.changeControlMode(TalonControlMode.Follower);
		backRightDM.set(frontLeftDM.getDeviceID());
		
		frontRightSM.changeControlMode(TalonControlMode.Follower);
		frontRightSM.set(frontLeftSM.getDeviceID());
		backLeftSM.changeControlMode(TalonControlMode.Follower);
		backLeftSM.set(frontLeftSM.getDeviceID());
		backRightSM.changeControlMode(TalonControlMode.Follower);
		backRightSM.set(frontLeftSM.getDeviceID());
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
