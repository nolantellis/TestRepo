/*
 * Thi is an enoum. Used to define movement rules
 */
package au.com.rearobot.entity;

/**
 *
 * @author nolan
 * 
 */
public enum Direction {
    EAST(DirectionRule.EAST),
    WEST(DirectionRule.WEST),
    NORTH(DirectionRule.NORTH),
    SOUTH(DirectionRule.SOUTH);
    

    DirectionRule directionRule;

    Direction(DirectionRule directionRule) {
        this.directionRule = directionRule;
    }

    public DirectionRule getDirectionRule() {
        return directionRule;
    }

}
