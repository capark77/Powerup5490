package org.usfirst.frc.team5490.robot.commands;

import org.usfirst.frc.team5490.robot.PathRecord;
import org.usfirst.frc.team5490.robot.RobotMap;

/**
 *
 */
public class AutoCenter extends AutonomousBase {

	// ToDo determine this....
	public static final double ScaleHeight = 800;
	public static final double SwitchHeight = 300;
	
	public static final double Off = 0;
	public static final double Fwd = 1;
	public static final double Rev = -1;
	public static final double Right = 1;
	public static final double Left = -1;
	public static final double CW = 1;
	public static final double CCW = -1;
	

	// un-tested
	PathRecord[] 	ToLeftNearSwitch =  {    			
			new PathRecord(  Off,  Fwd, Off,    .45, 2),	 	// forward 5.7'			
			new PathRecord(  Off,  Off, -90,      0, 0),		// rotate left  90
			new PathRecord(  Off,  Fwd, Off,    .57, 2),	 	// forward 13'
			new PathRecord(  Off,  Off, 0,       0, 0),			// rotate right back to 0
			new PathRecord(  Off,  Fwd, Off,    .49, 1.65),  	// forward 10'
			new PathRecord(  Off,  Fwd, Off,     0, 0.25),  	// stop
			new PathRecord(  Off,  Off,  90,     0, 0),			// rotate right 90
			new PathRecord(  Off,  Fwd, Off,    .4, 1),			// forward 2			
   	};
	
	PathRecord[] 	ToRightNearSwitch =  {    			
			new PathRecord(  Off,  Fwd, Off,    .4, 2),	 		// forward 5.7'
			new PathRecord(  Off,  Off, 90,      0, 0),			// rotate   90
			//
			new PathRecord(  Off,  Fwd, Off,    .5, 2),  		// forward 10'
			new PathRecord(  Off,  Fwd, Off,     0, 0.25),  	// stop
			new PathRecord(  Off,  Off, 0,       0, 0),			// rotate left  90
			
			new PathRecord(  Off,  Fwd, Off,    .49, 1.65),  	// forward 10'
			new PathRecord(  Off,  Fwd, Off,     0, 0.25),  	// stop
			new PathRecord(  Off,  Off,  -90,     0, 0),		// rotate right 90			
			new PathRecord(  Off,  Fwd, Off,    .4, 1),			// forward 2
   	};
	
	//
	PathRecord[] 	ToLeftScale =  {    			
			new PathRecord(  Off,  Fwd, Off,    .45, 2),	 	// forward 5.7'			
			new PathRecord(  Off,  Off, -90,      0, 0),		// rotate left  90
			new PathRecord(  Off,  Fwd, Off,    .57, 2),	 	// forward 13'
			new PathRecord(  Off,  Off, 0,       0, 0),			// rotate right back to 0
			new PathRecord(  Off,  Fwd, Off,    .5, 5),  		// forward 25'
			new PathRecord(  Off,  Fwd, Off,     0, 0.25),  	// stop
			new PathRecord(  Off,  Off,  90,     0, 0),			// rotate right 90
			new PathRecord(  Off,  Fwd, Off,    .4, 1),			// forward 2			

   	};
	// tested
	PathRecord[] 	ToRightScale =  {  			

			new PathRecord(  Off,  Fwd, Off,    .4, 2),	 		// forward 5.7'
			new PathRecord(  Off,  Off, 90,      0, 0),			// rotate   90
			//
			new PathRecord(  Off,  Fwd, Off,    .5, 2),  		// forward 10'
			new PathRecord(  Off,  Fwd, Off,     0, 0.25),  	// stop
			new PathRecord(  Off,  Off, 0,       0, 0),			// rotate left  90
			
			new PathRecord(  Off,  Fwd, Off,    .5, 5),  		// forward 25'
			new PathRecord(  Off,  Fwd, Off,     0, 0.25),  	// stop
			new PathRecord(  Off,  Off,  -90,     0, 0),		// rotate right 90			
			new PathRecord(  Off,  Fwd, Off,    .4, 1),			// forward 2			
   	};
	PathRecord[] 	ToLeftFarSwitch =  {   			
			new PathRecord(  Off,  Fwd, Off,    .45, 2),	 	// forward 5.7'			
			new PathRecord(  Off,  Off, -90,      0, 0),		// rotate left  90
			new PathRecord(  Off,  Fwd, Off,    .57, 2),	 	// forward 13'
			new PathRecord(  Off,  Off, 0,       0, 0),			// rotate right back to 0
			new PathRecord(  Off,  Fwd, Off,    .6, 5),  		// forward 30'
			new PathRecord(  Off,  Fwd, Off,     0, 0.25),  	// stop
			new PathRecord(  Off,  Off,  90,     0, 0),			// rotate right 90
			new PathRecord(  Off,  Fwd, Off,    .4, 1),			// forward 2			

   	};
	// tested
	PathRecord[] 	ToRightFarSwitch =  {

			new PathRecord(  Off,  Fwd, Off,    .4, 2),	 		// forward 5.7'
			new PathRecord(  Off,  Off, 90,      0, 0),			// rotate   90
			//
			new PathRecord(  Off,  Fwd, Off,    .5, 2),  		// forward 10'
			new PathRecord(  Off,  Fwd, Off,     0, 0.25),  	// stop
			new PathRecord(  Off,  Off, 0,       0, 0),			// rotate left  90
			
			new PathRecord(  Off,  Fwd, Off,    .6, 5),  		// forward 30'
			new PathRecord(  Off,  Fwd, Off,     0, 0.25),  	// stop
			new PathRecord(  Off,  Off,  -90,     0, 0),		// rotate right 90			
			new PathRecord(  Off,  Fwd, Off,    .4, 1),			// forward 2			
			
   	};
	
	PathSequence PathDriver;
	LiftSetpoint liftdriver;
	
    public AutoCenter() {
    	state = AutoStart.Center;
    	
    	//addParallel(new WinchToOperate());    	
    	PathDriver= new PathSequence();
    	addSequential(PathDriver);
    	//
    	liftdriver = new LiftSetpoint(SwitchHeight);
    	addSequential(liftdriver);    	
    	addSequential(new Forward2());    	
    	addSequential(new GripperRelease());
    	addSequential(new Reverse2());
    	addSequential(new LiftDown());    	

    }

    // Called just before this Command runs the first time
    // establish the path we want for the driving code.
    protected void initialize() {    	

   	 	PathRecord[] p = ToRightScale; 
	 
		 if(gameData.length() > 0)        	
	     {
	     	switch(gameData) {
	     	case "LLL":
	     		p = ToLeftNearSwitch;
	     		
	     		break;
	     	case "LLR":
	     		p = ToLeftNearSwitch;
	     		
	     		break;
	     	case "LRL":
	     		p = ToLeftNearSwitch;
	     		
	     		break;
	     	case "LRR":
	     		p = ToLeftNearSwitch;
	     		
	     		break;
	     	case "RLL":
	     		p = ToRightNearSwitch;
	     		
	     		break;
	     	case "RLR":
	     		p = ToRightNearSwitch;
	     		
	     		break;
	     	case "RRL":
	     		p = ToRightNearSwitch;
	     		
	     		break;
	     	case "RRR":
	     		p = ToRightNearSwitch;
	     		
	     		break;
	     	default:
	     		// can't decode message - just assume far right switch
	     		p = ToRightScale;
	     		liftdriver.ChangeSetpoint(RobotMap.ScaleHeight);
	     		break;
	     	}
	     }
		 else {
        	 p = ToRightNearSwitch;
         }
		 PathDriver.path = p;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
