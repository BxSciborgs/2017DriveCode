package org.usfirst.frc.team1155.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public enum Hardware {
	INSTANCE;
	public CANTalon frontLeftT, frontRightT, backLeftT, backRightT;
	public Joystick rightJ, leftJ, gamePad;
	public Gyro gyro;

	Hardware() {
		frontLeftT = new CANTalon(1);
		frontRightT = new CANTalon(2);
		backLeftT = new CANTalon(3);
		backRightT = new CANTalon(4);
		leftJ = new Joystick(0);
		rightJ = new Joystick(1);
		gamePad = new Joystick(2);
		gyro = new AnalogGyro(1);
	}
}
