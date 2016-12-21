package org.usfirst.frc.team1155.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem{
	
	CANTalon FLdrive, FLsteer, RLdrive, RLsteer, FRdrive, FRsteer, RRdrive, RRsteer;
	Joystick rightJoy, leftJoy;
	AnalogGyro gyro;
	
	public DriveSubsystem() {
		
	}
	
	public void setSpeed(double fr, double fl, double br, double bl){
    	FRdrive.set(fr);
    	FLdrive.set(fl);
    	RRdrive.set(br);
    	RLdrive.set(bl);
	}
	
	public void setAngle(double fr, double fl, double bl, double br){
		FRsteer.set(fr); //move the math to command
    	FLsteer.set(fl);
    	RLsteer.set(bl);
    	RRsteer.set(br);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
