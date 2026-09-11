package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionDutyCycle;
import com.ctre.phoenix6.controls.VelocityDutyCycle;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Motor extends SubsystemBase{

    private final TalonFX motor = new TalonFX(0);
    private final PositionDutyCycle positionClosedCycle = new PositionDutyCycle(0.0d).withEnableFOC(false);
    private final VelocityDutyCycle velocityClosedCycle = new VelocityDutyCycle(0);

    public Motor() {
        TalonFXConfiguration motorConfig = new TalonFXConfiguration();
        
        motorConfig.CurrentLimits.SupplyCurrentLimit = 40;
        motorConfig.CurrentLimits.SupplyCurrentLimitEnable = true;

        motorConfig.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
        motorConfig.MotorOutput.NeutralMode = NeutralModeValue.Coast;

        motor.getConfigurator().apply(motorConfig);

    }

    public void setVelocity(double velocity) {
        motor.setControl(velocityClosedCycle.withVelocity(velocity * Constants.MotorConstants.kMotorMaxRPS));
        SmartDashboard.putNumber("Motor Velocity", velocity * Constants.MotorConstants.kMotorMaxRPS);
    }

    public void setPosition(double position) {
        motor.setControl(positionClosedCycle.withPosition(position * Constants.MotorConstants.kMotorMaxRPS));
        SmartDashboard.putNumber("Motor Position", position * Constants.MotorConstants.kMotorMaxRPS);
    }

}
