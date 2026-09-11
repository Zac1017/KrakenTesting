package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Motor;

public class VelocityCommand extends Command {
    private final Motor motor;
    private final double velocity;

    public VelocityCommand(Motor motor, DoubleSupplier velocitySupplier) {
        this.motor = motor;
        this.velocity = velocitySupplier.getAsDouble();
        addRequirements(motor);
    }

    @Override
    public void execute() {
        motor.setVelocity(velocity);

    }
}
