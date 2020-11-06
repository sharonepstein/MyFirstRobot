package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

import java.util.function.Supplier;

public class ShootPID extends CommandBase {
    Shooter shooter;
    Supplier<Double>kp;
    Supplier<Double>ki;
    Supplier<Double>kd;
    Supplier<Double>setpoint;

PIDController pidController;
    public ShootPID(Shooter shooter, Supplier<Double> kp, Supplier<Double> ki, Supplier<Double> kd,Supplier<Double>setpoint) {
        this.shooter = shooter;
        this.kp = kp;
        this.ki = ki;
        this.kd = kd;
        this.pidController = new PIDController(kp.get(),ki.get(),kd.get());
        this.setpoint = setpoint;
    }

    @Override
    public void execute() {
        double speed= pidController.calculate(shooter.getVelocity(),setpoint.get());
        shooter.shoot(speed);
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stop();
    }

    @Override
    public boolean isFinished() {
        return shooter.getVelocity() >= setpoint.get();
    }

}
