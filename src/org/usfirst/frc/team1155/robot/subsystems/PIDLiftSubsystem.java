package org.usfirst.frc.team1155.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class PIDLiftSubsystem extends PIDSubsystem {
	public CANTalon liftTalon = new CANTalon(4);
	public Encoder encoder = new Encoder(0,1);
	private static final double P_VALUE = 0;
	private static final double I_VALUE = 0;
	private static final double D_VALUE = 0;
	private static final double ABSOLUTE_TOLERANCE = 0; 

	public PIDLiftSubsystem() {
		super("PIDLiftSubsystem",  P_VALUE, I_VALUE, D_VALUE);
		setAbsoluteTolerance(ABSOLUTE_TOLERANCE);
		getPIDController().setContinuous(false);
	}
	
	public void setSpeed(double speed) {
		liftTalon.set(speed);
	}
	
	public double getEncoderDistance() {
		return encoder.getDistance();
	}

	public void correctSpeed() {
		usePIDOutput(returnPIDInput());
	}
	

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}

	@Override
	protected double returnPIDInput() {
		return encoder.getDistance();
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		liftTalon.pidWrite(output);
	}

}
