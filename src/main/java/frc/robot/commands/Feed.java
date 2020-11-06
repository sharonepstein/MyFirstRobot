package frc.robot.commands;

        import edu.wpi.first.wpilibj.Timer;
        import edu.wpi.first.wpilibj2.command.CommandBase;
        import frc.robot.subsystems.Fedeer;

public class Feed extends CommandBase {
    //Feed  command

    private Fedeer fedeer;
    private double time;

    public Feed (Fedeer fedeer) {
        this.fedeer = fedeer;
    }

    @Override
    public void initialize() {
        time = Timer.getFPGATimestamp();
    }

    @Override
    public void execute() {
        fedeer.move();
    }

    @Override
    public boolean isFinished() {
        return Timer.getFPGATimestamp() - time >= 3;
    }

    @Override
    public void end(boolean interrupted) {
        fedeer.stop();
    }


}