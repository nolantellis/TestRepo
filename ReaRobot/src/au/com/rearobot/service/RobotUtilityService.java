/*
 * 
 * Using this service as it decouples main from using the robot interface directly.
 *  
 */
package au.com.rearobot.service;

import au.com.rearobot.entity.Direction;
import au.com.rearobot.entity.MyRobot;
import au.com.rearobot.entity.RelativeDirection;
import au.com.rearobot.entity.Robot;
import au.com.rearobot.exception.RobotMovementException;
import java.util.Scanner;

/**
 *
 * @author nolan
 */
public class RobotUtilityService {

    public void executeProgram() {
        System.out.println("type BBYE to end program");
        String operation;
        Robot robot = null;
        Scanner scan = new Scanner(System.in);
        do {
            operation = scan.next();
            try {
                
                switch (operation.toUpperCase()) {
                    case "PLACE" :
                    {
                        try {
                            robot = getRobot(scan.next());
                        } catch (RobotMovementException e) {
                            System.out.println("Hey mate!! I will fall on that move");
                        }
                        
                        break;
                    }
                    case "MOVE":
                        try {
                            moveRobot(robot);
                        } catch (RobotMovementException e) {
                            System.out.println("Hey mate!! I will fall on that move");
                        }
                        break;
                    case "LEFT":
                        turnRobot(robot, RelativeDirection.LEFT);
                        break;

                    case "RIGHT":
                        turnRobot(robot, RelativeDirection.RIGHT);
                        break;

                    case "REPORT":
                        reportRobotDetails(robot);
                        break;
                }
            } catch (Exception e) {
                System.out.println("OOPS something went wrong.! No Worries continue with operataion");
            }
        } while (!"BBYE".equalsIgnoreCase(operation));
    }

    private Robot getRobot(String coordnates) throws NumberFormatException, RobotMovementException {
        Robot robot;
        String[] cordinates = coordnates.split(",");
        robot = new MyRobot(Integer.parseInt(cordinates[0]),
                Integer.parseInt(cordinates[1]), Direction.valueOf(cordinates[2].toUpperCase()));
        return robot;
    }

    private void moveRobot(Robot robot) throws RobotMovementException {
        if (isRobotPlaced(robot)) {
            robot.move();
        }
    }

    private boolean isRobotPlaced(Robot robot) {
        return robot != null;
    }

    private void turnRobot(Robot robot, RelativeDirection relativeDirection) {
        if (isRobotPlaced(robot)) {
            robot.turn(relativeDirection);
        }
    }

    private void reportRobotDetails(Robot robot) {
        if (isRobotPlaced(robot))
        {
        System.out.println(robot.report());
        }
    }
}
