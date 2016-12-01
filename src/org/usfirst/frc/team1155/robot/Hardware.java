package org.usfirst.frc.team1155.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;

public enum Hardware {
	INSTANCE;
	
	public Joystick leftJoy, rightJoy;
	public CANTalon frontLeft, frontRight, backLeft, backRight;
	
	Hardware() {
		leftJoy = new Joystick(PortMap.PORT.leftJoy);
		rightJoy = new Joystick(PortMap.PORT.rightJoy);
				
		frontLeft = new CANTalon(PortMap.PORT.frontLeftTalon);
		frontRight = new CANTalon(PortMap.PORT.frontRightTalon);
		backLeft = new CANTalon(PortMap.PORT.backLeftTalon);
		backRight = new CANTalon(PortMap.PORT.backRightTalon);

	}
}
