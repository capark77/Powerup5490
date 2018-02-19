/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5490.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// The following mapping is final as of 1/29/18
	public static int mtrFrontLeft = 0;
	public static int mtrFrontRight = 1;
	public static int mtrRearRight = 2;
	public static int mtrRearLeft = 3;	
	
	
	public static int mtrLift = 4; 	
	public static int mtrGripperLeft = 5;
	public static int mtrGripperRight = 6;
	public static int mtrWinch = 7;
	
	// IMU Reservations
	// The IMU is located on the RoboRio MXP port and uses some of the DIO channels
	// this means that the SPI
	//
	// m_interrupt - MXP DIO0 -> DIO10 - IMU interrupt
	// m_reset = MXP DIO8 -> DIO18 - IMU reset
	// MOSI = MXP DIO7 -> DIO17 - SPI MOSI
	// MISO = MXP DIO6 -> DIO16 - SPI MISO
	// CLK = MXP DIO5 -> DIO15 - SPI CLK
	// CS = MXP DIO4 -> DIO14 - SPI CS
	
	// reserve these too..
	// I2C SDA = MXP DIO 15 - DIO25
	// I2C SCL = MXP DIO 14 - DIO24
	
	// MXP available (encoder)
	// pin used
	// MXP DIO1   -> DIO11/PWM11  (gripper ls)
	// MXP DIO2   -> DIO12/PWM12  (gripper ls)
	// MXP DIO3   -> DIO13/PWM13
	// block used...
	// MXP DIO9   -> DIO19/PWM15
	// MXP DIO10  -> DIO20/PWM16
	// MXP DIO11  -> DIO21/PWM17	
	// MXP DIO12  -> DIO22/PWM18  
	// MXP DIO13  -> DIO23/PWM19
	
	// Analog outputs AO0, AO1
	// Analog inputs AI4, AI5, AI6, AI7
	
	
	
	
	// Encoder map
	public static int LiftEncoderA = 0;
	public static int LiftEncoderB = 1;	
	public static int WinchEncoderA = 2;
	public static int WinchEncoderB = 3;
	public static int GripperEncoderA = 4;
	public static int GripperEncoderB = 5;
	
	// Limit switches
	public static int LS_WinchUp = 6;
	public static int LS_WinchDown = 7;

	public static int LS_LiftUp = 8;
	public static int LS_LiftDown = 9;

	public static int LS_GripperOpen = 11;
	public static int LS_GripperClosed = 12;
	
	
	
}
