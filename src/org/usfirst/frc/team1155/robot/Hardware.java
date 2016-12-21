package org.usfirst.frc.team1155.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Joystick;

public enum Hardware {
	INSTANCE;


	public CANTalon driveFrontL;
	public CANTalon steerFrontL;
	public CANTalon driveBackL;
	public CANTalon steerBackL;
	public CANTalon driveFrontR;
	public CANTalon steerFrontR;
	public CANTalon driveBackR;
	public CANTalon steerBackR;
	public Joystick rightJoy, leftJoy;
	public AnalogGyro gyro;

	Hardware() {
		driveFrontL = new CANTalon(PortMap.PORT.FL_DRIVE); // Initialize the SRX on device 1.
		steerFrontL = new CANTalon(PortMap.PORT.FL_STEER); 
		driveBackL = new CANTalon(PortMap.PORT.BL_DRIVE); 
		steerBackL = new CANTalon(PortMap.PORT.BL_STEER);
		driveFrontR = new CANTalon(PortMap.PORT.FR_DRIVE);
		steerFrontR = new CANTalon(PortMap.PORT.FR_STEER);
		driveBackR = new CANTalon(PortMap.PORT.BR_DRIVE);
		steerBackR = new CANTalon(PortMap.PORT.BR_STEER);
		rightJoy = new Joystick(PortMap.PORT.RIGHT_JOY);
		leftJoy = new Joystick(PortMap.PORT.LEFT_JOY);
		gyro = new AnalogGyro(PortMap.PORT.GYRO);// gyro on RoboRio analog input port 0

		driveFrontL.changeControlMode(TalonControlMode.PercentVbus);
		driveBackL.changeControlMode(TalonControlMode.PercentVbus);
		driveFrontR.changeControlMode(TalonControlMode.PercentVbus);
		driveBackR.changeControlMode(TalonControlMode.PercentVbus);
		steerFrontL.changeControlMode(TalonControlMode.PercentVbus);
		steerBackL.changeControlMode(TalonControlMode.PercentVbus);
		steerFrontR.changeControlMode(TalonControlMode.PercentVbus);
		steerBackR.changeControlMode(TalonControlMode.PercentVbus);

		steerFrontL.setFeedbackDevice(FeedbackDevice.AnalogPot);
		steerBackL.setFeedbackDevice(FeedbackDevice.AnalogPot);
		steerFrontR.setFeedbackDevice(FeedbackDevice.AnalogPot);
		steerBackR.setFeedbackDevice(FeedbackDevice.AnalogPot);
		driveFrontL.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		driveBackL.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		driveFrontR.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		driveBackR.setFeedbackDevice(FeedbackDevice.QuadEncoder);


		steerFrontL.setPID(1, 0, 0);
		steerBackL.setPID(1, 0, 0);
		steerFrontR.setPID(1, 0, 0);
		steerBackR.setPID(1, 0, 0);
	}
}
