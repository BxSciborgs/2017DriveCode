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
	
	public void setSpeed(double fr, double fl, double rr, double rl){
    	FRdrive.set(fr);
    	FLdrive.set(fl);
    	RRdrive.set(rr);
    	RLdrive.set(rl);
	}
	
	public void setAngle(double fr, double fl, double rl, double rr){
		FRsteer.set((fr+180) * (1023/360)); //move the math to command
    	FLsteer.set((fl+180) * (1023/360));
    	RLsteer.set((rl+180) * (1023/360));
    	RRsteer.set((rr+180) * (1023/360));
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
