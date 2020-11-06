package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase{

    private WPI_TalonSRX master;

    public Shooter(WPI_TalonSRX master,WPI_VictorSPX slave){
        this.master=master;
        slave.follow(this.master);
    }

    public void shoot(double speed){
        master.set(speed);
    }

    public void stop(){
        master.stopMotor();
    }

    public double getVelocity(){
        return master.getSelectedSensorVelocity();
    }

}
