package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix6.controls.PositionDutyCycle;
import com.ctre.phoenix6.controls.VelocityDutyCycle;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Motor extends SubsystemBase{

    private final TalonFX motor = new TalonFX(0);
    private final PositionDutyCycle positionClosedCycle = new PositionDutyCycle(0.0d).withEnableFOC(false);
    private final VelocityDutyCycle velocityClosedCycle = new VelocityDutyCycle(0);

    public Motor() {
        //TODO: Configure the motor settings here
    }

    public void setVelocity(double velocity) {
        motor.setControl(velocityClosedCycle.withVelocity(velocity));
    }

    public void setPosition(double position) {
        motor.setControl(positionClosedCycle.withPosition(position));
    }

}
