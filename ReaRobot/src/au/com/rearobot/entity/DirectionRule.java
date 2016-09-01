/*
 * 
* Created this enum to avoid over populating the drection enum as well as for support for new rules in the future.
 */
package au.com.rearobot.entity;

/**
 *
 * @author nolan
 */
public enum DirectionRule {
    NORTH(0, 1, "WEST", "EAST"),
    SOUTH(0, -1, "EAST", "WEST"),
    EAST(1, 0, "NORTH", "SOUTH"),
    WEST(-1, 0, "SOUTH", "NORTH");
    
    int xPositionIncrement;
    int yPositionIncrement;
    String leftTurn;
    String rightTurn;
    
    DirectionRule(int xPositionIncrement,int yPositionIncrement,String leftTurn,String rightTurn)
    {
      this.xPositionIncrement=xPositionIncrement;
      this.yPositionIncrement=yPositionIncrement;
      this.leftTurn=leftTurn;
      this.rightTurn=rightTurn;
    }

    public int getxPositionIncrement() {
        return xPositionIncrement;
    }

    public int getyPositionIncrement() {
        return yPositionIncrement;
    }

    public Direction getLeftTurn() {
        return Direction.valueOf(leftTurn);
    }

    public Direction getRightTurn() {
        return Direction.valueOf(rightTurn);
    }
    
    
    
}
