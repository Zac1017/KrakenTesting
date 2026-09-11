// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.PositionCommand;
import frc.robot.commands.VelocityCommand;
import frc.robot.subsystems.Motor;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;


public class RobotContainer {
  private final CommandXboxController kOperatorController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);
  
      private final Motor motor = new Motor();
  
  public RobotContainer() {

    configureBindings();
  }


  private void configureBindings() {
    motor.setDefaultCommand(
      new VelocityCommand(
        motor, 
        () -> kOperatorController.getLeftY())
    );

    kOperatorController.a().onTrue(
      new PositionCommand(motor, Constants.PositionConstants.kPosition1)
    );
    kOperatorController.x().onTrue(
      new PositionCommand(motor, Constants.PositionConstants.kPosition2)
    );
    kOperatorController.y().onTrue(
      new PositionCommand(motor, Constants.PositionConstants.kPosition3)
    );
    kOperatorController.b().onTrue(
      new PositionCommand(motor, Constants.PositionConstants.kPosition4)
    );

  }


}
