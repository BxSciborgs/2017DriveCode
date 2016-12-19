package org.usfirst.frc.team1155.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Joystick;

public enum Hardware {
	INSTANCE;


	CANTalon driveFrontL, steerFrontL, driveBackL, steerBackL, driveFrontR, steerFrontR, driveBackR, steerBackR;
	Joystick rightJoy, leftJoy;
	AnalogGyro gyro;

	Hardware() {
		driveFrontL = new CANTalon(1); // Initialize the SRX on device 1.
		steerFrontL = new CANTalon(2); 
		driveBackL = new CANTalon(3); 
		steerBackL = new CANTalon(4);
		driveFrontR = new CANTalon(5);
		steerFrontR = new CANTalon(6);
		driveBackR = new CANTalon(7);
		steerBackR = new CANTalon(8);
		rightJoy = new Joystick(1);
		leftJoy = new Joystick(2);
		gyro = new AnalogGyro(0);// gyro on RoboRio analog input port 0

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
