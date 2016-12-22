package org.usfirst.frc.team1155.robot.subsystems;

import org.usfirst.frc.team1155.robot.PortMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem{
	
	public CANTalon driveFrontL, driveBackL, driveFrontR, driveBackR;
	public CANTalon steerFrontL, steerBackL, steerFrontR, steerBackR;
	
	public DriveSubsystem() {
		driveFrontL = new CANTalon(PortMap.FrontL_DRIVE); // Initialize the SRX on device 1.
		steerFrontL = new CANTalon(PortMap.FrontL_STEER); 
		driveBackL = new CANTalon(PortMap.BackL_DRIVE); 
		steerBackL = new CANTalon(PortMap.BackL_STEER);
		driveFrontR = new CANTalon(PortMap.FrontR_DRIVE);
		steerFrontR = new CANTalon(PortMap.FrontR_STEER);
		driveBackR = new CANTalon(PortMap.BackR_DRIVE);
		steerBackR = new CANTalon(PortMap.BackR_STEER);

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
	
	public void setSpeed(double fr, double fl, double br, double bl){
    	driveFrontR.set(fr);
    	driveFrontL.set(fl);
    	driveBackR.set(br);
    	driveBackL.set(bl);
	}
	
	public void setAngle(double fr, double fl, double bl, double br){
		steerFrontR.set(fr); //move the math to command
    	steerFrontL.set(fl);
    	steerBackL.set(bl);
    	steerBackR.set(br);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
