package org.usfirst.frc.team1155.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Joystick;

public enum Hardware {
	INSTANCE;


	CANTalon FLdrive, FLsteer, RLdrive, RLsteer, FRdrive, FRsteer, RRdrive, RRsteer;
	Joystick rightJoy, leftJoy;
	AnalogGyro gyro;

	Hardware() {
		FLdrive = new CANTalon(1); // Initialize the SRX on device 1.
		FLsteer = new CANTalon(2); 
		RLdrive = new CANTalon(3); 
		RLsteer = new CANTalon(4);
		FRdrive = new CANTalon(5);
		FRsteer = new CANTalon(6);
		RRdrive = new CANTalon(7);
		RRsteer = new CANTalon(8);
		rightJoy = new Joystick(1);
		leftJoy = new Joystick(2);
		gyro = new AnalogGyro(0);// gyro on RoboRio analog input port 0

		FLdrive.changeControlMode(TalonControlMode.PercentVbus);
		RLdrive.changeControlMode(TalonControlMode.PercentVbus);
		FRdrive.changeControlMode(TalonControlMode.PercentVbus);
		RRdrive.changeControlMode(TalonControlMode.PercentVbus);
		FLsteer.changeControlMode(TalonControlMode.PercentVbus);
		RLsteer.changeControlMode(TalonControlMode.PercentVbus);
		FRsteer.changeControlMode(TalonControlMode.PercentVbus);
		RRsteer.changeControlMode(TalonControlMode.PercentVbus);

		FLsteer.setFeedbackDevice(FeedbackDevice.AnalogPot);
		RLsteer.setFeedbackDevice(FeedbackDevice.AnalogPot);
		FRsteer.setFeedbackDevice(FeedbackDevice.AnalogPot);
		RRsteer.setFeedbackDevice(FeedbackDevice.AnalogPot);
		FLdrive.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		RLdrive.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		FRdrive.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		RRdrive.setFeedbackDevice(FeedbackDevice.QuadEncoder);


		FLsteer.setPID(1, 0, 0);
		RLsteer.setPID(1, 0, 0);
		FRsteer.setPID(1, 0, 0);
		RRsteer.setPID(1, 0, 0);
	}
}
