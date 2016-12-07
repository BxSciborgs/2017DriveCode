

package org.usfirst.frc.team1155.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class MecanumDriveSubsystem extends Subsystem {
	public CANTalon topLeftTalon,topRightTalon,botLeftTalon,botRightTalon;
	
	public MecanumDriveSubsystem() {
		topLeftTalon = new CANTalon(0);
		topRightTalon = new CANTalon(1);
		botLeftTalon = new CANTalon(2);
		botRightTalon = new CANTalon(3);
	}
	
	public void setWheelSpeed(CANTalon wheel, double speed) {
		wheel.set(speed);
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}
	
}
