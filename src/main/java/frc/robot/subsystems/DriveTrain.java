package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj2.command.ScheduleCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
    WPI_TalonSRX left;
    WPI_TalonSRX right;

    public DriveTrain(WPI_TalonSRX left, WPI_VictorSPX downLeft, WPI_TalonSRX right, WPI_VictorSPX downRight) {
        this.left = left;
        this.right = right;
        downLeft.follow(this.left);
        downRight.follow(this.right);

    }

    public void moveTank(double speedLeft, double speedRight) {
        left.set(speedLeft);
        right.set(speedRight);
    }

    public void stop() {
        // left.set(0);
        // right.set(0);
        // MoveTank(0,0);
        left.stopMotor();
        right.stopMotor();
    }
}
