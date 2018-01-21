package org.usfirst.frc.team5490.robot.subsystems;

import org.usfirst.frc.team5490.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {

	
    // Winch objects
    private Talon motorLift = new Talon(RobotMap.mtrLift);    
    
    //private Encoder 		m_LiftEncoder;
    
    //Limit switches
    private DigitalInput m_lsTop = new DigitalInput(RobotMap.LS_LiftUp);
	private DigitalInput m_lsBottom = new DigitalInput(RobotMap.LS_LiftDown);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Lift() {
		super();

		// Let's name everything on the LiveWindow
		addChild("Motor", motorLift);
		addChild("Up Limit Switch", m_lsTop);
		addChild("Down Limit Switch", m_lsBottom);
	}
	
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	 
    }
    
    public void log() {
	}
    
    /**
	 * Set the lift motor to move in the down direction.
	 */
	public void lower() {
		motorLift.set(-1);
	}

	/**
	 * Set the lift motor to move in the up direction.
	 */
	public void raise() {
		motorLift.set(1);
	}

	/**
	 * Stops the lift motor from moving.
	 */
	public void stop() {
		motorLift.set(0);
	}
    
	/**
	 * Return true when the which lift triggers the "top" limit switch.
	 */
	public boolean isAtTop() {
		return m_lsTop.get();
	}

	/**
	 * Return true when the which lift triggers the "bottom" limit switch.
	 */
	public boolean isAtBottom() {
		return m_lsBottom.get();
	}
}
