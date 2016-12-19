package org.usfirst.frc.team1155.robot;

import edu.wpi.first.wpilibj.CANTalon;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic static final numbers
 * floating around.
 */
public static final enum PortMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static final static static final int leftMotor = 1;
	// public static final static static final int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static final static static final int rangefinderPort = 1;
	// public static final static static final int rangefinderModule = 1;

	PORT;

	public static final int leftJoy = 0;
	public static final int rightJoy = 1;

	public static final int FLdrive = 1;
	public static final int FLsteer = 2;
	public static final int RLdrive = 3;
	public static final int RLsteer = 4;
	public static final int RRdrive = 5;
	public static final int RRsteer = 6;
	public static final int FRdrive = 7;
	public static final int FRsteer = 8;
	
	public static final int gyro = 0;
}
