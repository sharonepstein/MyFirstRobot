package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Feed;
import frc.robot.commands.Grip;


import frc.robot.subsystems.Fedeer;
import frc.robot.subsystems.Gripper;
import frc.robot.subsystems.Shooter;


public class OI {
    //oi

    private Joystick joystickRight = new Joystick(0);
    private Joystick joystickLeft = new Joystick(1);
    private JoystickButton gripButton = new JoystickButton(joystickLeft, 3);
    private JoystickButton shootButton = new JoystickButton(joystickLeft, 4);

    public OI(Gripper gripper, Fedeer fedeer, Shooter shooter){
        gripButton.whenPressed(new Grip(gripper).andThen(new Feed(fedeer),
                new InstantCommand(fedeer::incrementCurrentCapacity, fedeer)));
        shootButton.whenPressed(new Feed(fedeer).andThen(new ShootPID(shooter, Shooter.KP,
                        Shooter.KI, Shooter.KD, Shooter.TOLERANCE, Shooter.SETPOINT),
                new InstantCommand(fedeer::decrementCurrentCapacity, fedeer)));
    }

    public double getLeftX() {
        return this.joystickLeft.getX();
    }

    public double getLeftY() {
        return -this.joystickLeft.getY();
    }

    public double getRightX() {
        return this.joystickRight.getX();
    }

    public double getRightY() {
        return -this.joystickRight.getY();
    }

}

