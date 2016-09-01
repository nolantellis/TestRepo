/*
 * Robot interface for de-coupling. Any robo of anytype can be on the table hence interface.
 */
package au.com.rearobot.entity;

import au.com.rearobot.exception.RobotMovementException;

/**
 *
 * @author nolan
 */
public interface Robot {
    
    public int getXposition();
    public int getYposition();
    public void setXposition(int xPosition);
    public void setYposition(int yPosition);
    public void move() throws RobotMovementException;
    public void turn(RelativeDirection direction);
    public String report();
}
