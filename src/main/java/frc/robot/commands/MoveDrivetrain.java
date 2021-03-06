package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

import java.util.function.Supplier;

public class MoveDrivetrain extends CommandBase {
    private Supplier<Double> speedLeft;
    private Supplier<Double> speedRight;


    private DriveTrain driveTrain;


    public  MoveDrivetrain(Supplier<Double> speedLeft, Supplier<Double> speedRight, DriveTrain driveTrain){
        this.speedLeft=speedLeft;
        this.speedRight=speedRight;
        this.driveTrain=driveTrain;
        addRequirements(driveTrain);
        
    }

    @Override
    public void execute() {
        driveTrain.moveTank(speedLeft.get(),speedRight.get());

    }

    @Override
    public void end(boolean interrupted) {
        driveTrain.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}

