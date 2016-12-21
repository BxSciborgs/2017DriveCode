package org.usfirst.frc.team1155.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class PortMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;

    // Fill in with the real ports
    public static final char JOYSTICK = 0;
    public static final char LIFT_TALON = 4;
    public static final char LIFT_ENCODER = 0;
    public static final char FRONT_LEFT_TALON = 0;
    public static final char FRONT_RIGHT_TALON = 1;
    public static final char BACK_LEFT_TALON = 2;
    public static final char BACK_RIGHT_TALON = 3;
}
