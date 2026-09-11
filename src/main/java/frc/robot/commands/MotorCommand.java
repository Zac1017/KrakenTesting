package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Motor;

public class MotorCommand extends Command {
    private final Motor motor;
    private final double velocity;
    private final double position;
    private final boolean useVelocity;
    public MotorCommand(Motor motor, double velocity, double position, boolean useVelocity) {
        this.motor = motor;
        this.velocity = velocity;
        this.position = position;
        this.useVelocity = useVelocity;
        addRequirements(motor);
    }

    @Override
    public void execute() {
        if (useVelocity) {
            motor.setVelocity(velocity);
        } else {
            motor.setPosition(position);
        }

    }
}
