// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.cameraserver.CameraServer;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
  private final VictorSP m_leftDrive = new VictorSP(1);
  private final VictorSP m_rightDrive = new VictorSP(0);
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftDrive, m_rightDrive);
  private final Joystick m_stick = new Joystick(0);
  private final Timer m_timer = new Timer();

  private final VictorSP m_lifter = new VictorSP(3);
  private final VictorSP m_shooter = new VictorSP(5);
  private final VictorSP m_collector = new VictorSP(4);
  
  
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead. 
    m_rightDrive.setInverted(true);
    CameraServer.startAutomaticCapture();
  }

  /** This function is run once each time the robot enters autonomous mode. */
  @Override
  public void autonomousInit() {
    m_timer.reset();
    m_timer.start();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
  

// Auto Code 1 Brings Three balls to human player
//   if (m_timer.get() < 3.2) {
//     m_robotDrive.arcadeDrive(0.6, 0.0); // Turn Left to position for terminal
//   } else {
//     m_robotDrive.stopMotor(); // stop robot
//   }

//   if (m_timer.get() > 3.5) {
//     m_collector.set(0.2);
//   } else if (m_timer.get()> 4.2)
//   m_collector.stopMotor();

//   if (m_timer.get() > 5.3) {
//     m_robotDrive.arcadeDrive(0.0, 0.4); // Drives Forwards
//  } else if (m_timer.get() > 6.3 )
//     m_robotDrive.stopMotor();

//   if (m_timer.get() > 6.8) {
//    m_robotDrive.arcadeDrive(0.6, 0.0); // Drives Forwards
//  } else if (m_timer.get() > 8.8 )
//       m_robotDrive.stopMotor();
   
//   if (m_timer.get() > 8.4) {
//     m_collector.set(-0.15);
//  } else if (m_timer.get()> 8.8)
//       m_collector.stopMotor();

//   if (m_timer.get() > 9.8) {
//    m_robotDrive.arcadeDrive(0.5, 0.0); // Drives Forwards
//  } else if (m_timer.get() > 11.5 )
//       m_robotDrive.stopMotor();
    
//       if (m_timer.get() > 11.7) {
//         m_robotDrive.arcadeDrive(-0.5, 0.0); // Drives Forwards
//       } else if (m_timer.get() > 12.5 )
//            m_robotDrive.stopMotor();

//       if (m_timer.get() > 12.7) {
//         m_robotDrive.arcadeDrive(0.0, 0.5); // Drives Forwards
//         } else if (m_timer.get() > 13.5 )
//                m_robotDrive.stopMotor();

// Auto Code 2 Collects two enemy balls and gives human player one ball
  //   if (m_timer.get() < 3.2) {
  //     m_robotDrive.arcadeDrive(0.6, 0.0); // Drives forward
  //   } else {
  //     m_robotDrive.stopMotor(); // stop robot
  //   }
   
  //   if (m_timer.get() > 3.5) {
  //     m_collector.set(0.2);   //Collect enemy ball
  //   } else if (m_timer.get()> 4.2)
  //   m_collector.stopMotor();

  //   if (m_timer.get() > 5.3) {
  //     m_robotDrive.arcadeDrive(0.0, -0.4); // Drives Forwards
  //  } else if (m_timer.get() > 6.3 )
  //     m_robotDrive.stopMotor();

  //   if (m_timer.get() > 6.8) {
  //    m_robotDrive.arcadeDrive(0.6, 0.0); // Drives Forwards
  //  } else if (m_timer.get() > 9.8 )
  //       m_robotDrive.stopMotor();

  //   if (m_timer.get() > 9.8) {
  //    m_robotDrive.arcadeDrive(-0.5, 0.0); // Drives Forwards
  //  } else if (m_timer.get() > 10.3 )
    
  //  m_robotDrive.stopMotor();
  //       if (m_timer.get() > 10.5) {
  //         m_robotDrive.arcadeDrive(0.0, 0.5); // Drives Forwards
  //       } else if (m_timer.get() > 11.5 )
  //            m_robotDrive.stopMotor();

  // Auto Code 3 Moves out of tarmac and collects enemy ball

           if (m_timer.get() < 3.5) {
            m_robotDrive.arcadeDrive(-0.5, 0.0); // Drives Forwards
          } else 
               m_robotDrive.stopMotor();

            
      
  }
    
  /** This function is called once each time the robot enters teleoperated mode. */
  @Override
  public void teleopInit() {
    m_timer.reset();
    m_timer.start();
  }
  /** This function is called periodically during teleoperated mode. */
  @Override
  public void teleopPeriodic() {
    m_robotDrive.arcadeDrive(m_stick.getY(), m_stick.getX());
    

if (m_stick.getRawButton(5)) {
  m_lifter.set(0.5); // 60% forward
} else if (m_stick.getRawButton(6))  {
  m_lifter.set(-0.5); // 60% backwards
} else {
  m_lifter.set(0);
}

if (m_stick.getRawButton(3)) {
  m_shooter.set(0.6); // 60% forward
} else if (m_stick.getRawButton(4))  {
  m_shooter.set(-0.6); // 60% backwards
} else {
  m_shooter.set(0);
}





if (m_stick.getRawButton(10)) {
  m_collector.set(0.5); // 60% forward
} else if (m_stick.getRawButton(12))  {
  m_collector.set(-0.5); // 60% backwards
} else { 
  m_collector.set(0);
}

}
   
 
  /** This function is called once each time the robot enters test mode. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
