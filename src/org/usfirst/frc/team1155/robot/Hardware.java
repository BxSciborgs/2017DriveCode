package org.usfirst.frc.team1155.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;

public enum Hardware {
	INSTANCE;
	
	public Joystick leftJoy, rightJoy;
	public CANTalon frontLeftDM, frontRightDM, backLeftDM, backRightDM, frontLeftSM, frontRightSM, backLeftSM, backRightSM;
	
	Hardware() {
		leftJoy = new Joystick(PortMap.PORT.leftJoy);
		rightJoy = new Joystick(PortMap.PORT.rightJoy);
				
		frontLeftDM = new CANTalon(PortMap.PORT.frontLeftTalonDM);
		frontRightDM = new CANTalon(PortMap.PORT.frontRightTalonDM);
		backLeftDM = new CANTalon(PortMap.PORT.backLeftTalonDM);
		backRightDM = new CANTalon(PortMap.PORT.backRightTalonDM);
		frontLeftSM = new CANTalon(PortMap.PORT.frontLeftTalonSM);
		frontRightSM = new CANTalon(PortMap.PORT.frontRightTalonSM);
		backLeftSM = new CANTalon(PortMap.PORT.backLeftTalonSM);
		backRightSM = new CANTalon(PortMap.PORT.backRightTalonSM);
	}
}
