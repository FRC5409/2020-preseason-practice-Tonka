// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5409.DriveCodeForTonka.subsystems;


import org.usfirst.frc5409.DriveCodeForTonka.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

import com.ctre.phoenix.motorcontrol.ControlMode;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class DriveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private WPI_TalonSRX m_LeftDriveFront_TalonSRX_C1;
    private WPI_TalonSRX m_LeftDriveRear_TalonSRX_C2;
    private SpeedControllerGroup leftMotorSpeedControllerGroup;
    private WPI_TalonSRX m_RightDriveFront_TalonSRX_C3;
    private WPI_TalonSRX m_RightDriveRear_TalonSRX_C4;
    private SpeedControllerGroup rightMotorSpeedControllerGroup;
    private DifferentialDrive differentialDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public DriveTrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        m_LeftDriveFront_TalonSRX_C1 = new WPI_TalonSRX(1);
        
        
        
        m_LeftDriveRear_TalonSRX_C2 = new WPI_TalonSRX(2);
        
        
        
        
        
        //Set SlaveSpeedControllers to Follow MasterSpeedController
        m_LeftDriveRear_TalonSRX_C2.follow(m_LeftDriveFront_TalonSRX_C1);
                
                
        
        m_RightDriveFront_TalonSRX_C3 = new WPI_TalonSRX(3);
        
        
        
        m_RightDriveRear_TalonSRX_C4 = new WPI_TalonSRX(4);
        
        
        
        
        
        //Set SlaveSpeedControllers to Follow MasterSpeedController
        m_RightDriveRear_TalonSRX_C4.follow(m_RightDriveFront_TalonSRX_C3);
                
                
        
        differentialDrive = new DifferentialDrive(leftMotorSpeedControllerGroup, rightMotorSpeedControllerGroup);
        addChild("Differential Drive ",differentialDrive);
        differentialDrive.setSafetyEnabled(true);
        differentialDrive.setExpiration(0.1);
        differentialDrive.setMaxOutput(1.0);

        

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void curvatureDrive(double xSpeed, double zRotation, boolean quickTurn){
        m_LeftDriveFront_TalonSRX_C1.set(ControlMode.PercentOutput, -xSpeed);
        m_RightDriveFront_TalonSRX_C3.set(ControlMode.PercentOutput, xSpeed);
        //setting forward and backwards

        m_LeftDriveFront_TalonSRX_C1.set(ControlMode.PercentOutput, zRotation);
        m_RightDriveFront_TalonSRX_C3.set(ControlMode.PercentOutput, zRotation);
        //setting turning 

        if (quickTurn = true){
            m_LeftDriveFront_TalonSRX_C1.set(ControlMode.PercentOutput, zRotation);
            m_RightDriveFront_TalonSRX_C3.set(ControlMode.PercentOutput, zRotation);

            xSpeed = 0; 
            //if quickTurn is true do this, if false do nothing 
            
        }

    }


}

