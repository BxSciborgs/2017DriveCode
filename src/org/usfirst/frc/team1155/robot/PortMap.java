package org.usfirst.frc.team1155.robot;

import edu.wpi.first.wpilibj.CANTalon;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public enum PortMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	PORT;
	
	public int leftJoy = 0;
	public int rightJoy = 1;
	
	public int frontLeftTalonDM = 0, frontRightTalonDM = 1, backLeftTalonDM = 2, backRightTalonDM = 3, frontLeftTalonSM = 4, frontRightTalonSM = 5, backLeftTalonSM = 6, backRightTalonSM = 7;

}
