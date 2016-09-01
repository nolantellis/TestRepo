/*
 * 
 * 
 * Run main program from here.
 * type bbye if anything goes wrong  and you want to exit.
 * Any invalid inputs will catch the exception and get you back to inputs for new operation.
 */
package au.com.rearobot;

import au.com.rearobot.entity.Robot;
import au.com.rearobot.service.RobotUtilityService;

/**
 *
 * @author nolan
 */
public class ReaRobotProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       Robot robot ;
       RobotUtilityService robotUtilityService=new RobotUtilityService();
       robotUtilityService.executeProgram();
       
    }
    
}
