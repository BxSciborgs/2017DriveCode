package org.usfirst.frc.team1155.robot.subsystems;

import org.usfirst.frc.team1155.robot.Hardware;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class OmniDrive extends Subsystem {

	private CANTalon frontLeft, frontRight, backLeft, backRight;

	public OmniDrive() {
		frontLeft = Hardware.INSTANCE.frontLeftT;
		frontRight = Hardware.INSTANCE.frontRightT;
		backLeft = Hardware.INSTANCE.backLeftT;
		backRight = Hardware.INSTANCE.backRightT;
	}

	// The motors go in order of frontLeft, frontRight, BackRight, BackLeft
	public void setTalonsTo(double... motors) {
		frontLeft.set(motors[0]);
		frontRight.set(motors[1]);
		backRight.set(motors[2]);
		backLeft.set(motors[3]);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
