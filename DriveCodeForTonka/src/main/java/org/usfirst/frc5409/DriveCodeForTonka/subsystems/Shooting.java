/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc5409.DriveCodeForTonka.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc5409.DriveCodeForTonka.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

/**
 * Add your docs here.
 */
public class Shooting extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private WPI_VictorSPX m_Rotation_VictorSPX_C0; 
  private Spark m_Shooter1_SparkMAX_C1; 
  private Spark m_Shooter2_SparkMac_C0; 
  private SpeedControllerGroup ShooterSpeedControllerGroup; 

  public Shooting(){

    m_Rotation_VictorSPX_C0 = new WPI_VictorSPX(0);

    m_Shooter1_SparkMAX_C1 = new Spark(1); 

    m_Shooter2_SparkMac_C0 = new Spark(0); 

     //m_Shooter2_SparkMac_C0.follow(m_Shooter1_SparkMAX_C1);

    ShooterSpeedControllerGroup = new SpeedControllerGroup(m_Shooter1_SparkMAX_C1, m_Shooter2_SparkMac_C0);

  }

  public void Shooting(double s_output){
    ShooterSpeedControllerGroup.set(s_output);
  }

  public void Rotation(double r_output){
    m_Rotation_VictorSPX_C0.set(ControlMode.PercentOutput, r_output);
  }

  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
