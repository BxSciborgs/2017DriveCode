package org.usfirst.frc.team1155.robot.subsystems;

import org.usfirst.frc.team1155.robot.PortMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class PIDLift extends PIDSubsystem {
    public CANTalon liftTalon = new CANTalon(PortMap.LIFT_TALON);
    public Encoder liftEncoder = new Encoder(PortMap.LIFT_ENCODER, 1);
    private static final double P_VALUE = 0;
    private static final double I_VALUE = 0;
    private static final double D_VALUE = 0;
    private static final double ABSOLUTE_TOLERANCE = 0; 

    public PIDLift() {
        super("PIDLiftSubsystem",  P_VALUE, I_VALUE, D_VALUE);
        setAbsoluteTolerance(ABSOLUTE_TOLERANCE);
        getPIDController().setContinuous(false);
    }

    public void setSpeed(double speed) {
        liftTalon.set(speed);
    }

    public double getEncoderDistance() {
        return liftEncoder.getDistance();
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
        return liftEncoder.getDistance();
    }

    @Override
    protected void usePIDOutput(double output) {
        // TODO Auto-generated method stub
        liftTalon.pidWrite(output);
    }

}
