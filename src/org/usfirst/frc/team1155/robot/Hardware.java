package org.usfirst.frc.team1155.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;

public enum Hardware {
	INSTANCE;
	
	public Joystick leftJoy, rightJoy;
	public CANTalon frontLeft, frontRight, backLeft, backRight;
	
	Hardware() {
		leftJoy = new Joystick(0);
		rightJoy = new Joystick(0);
				
		frontLeft = new CANTalon(0);
		frontRight = new CANTalon(1);
		backLeft = new CANTalon(2);
		backRight = new CANTalon(3);

	}
}
