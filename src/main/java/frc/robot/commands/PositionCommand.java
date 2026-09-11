package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Motor;

public class PositionCommand extends Command {
    private final Motor motor;
    private final double position;
    public PositionCommand(Motor motor, double position) {
        this.motor = motor;
        this.position = position;
        addRequirements(motor);
    }

    @Override
    public void initialize() {
        motor.setPosition(position);
    }
    @Override
    public boolean isFinished() {
        return true;
    }
}
