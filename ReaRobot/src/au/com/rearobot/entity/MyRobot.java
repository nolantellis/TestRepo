/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rearobot.entity;

import au.com.rearobot.exception.RobotMovementException;

/**
 *
 * @author nolan
 */
public class MyRobot implements Robot {

    int xPosition = -1;
    int yPosition = -1;

    public static final int MAX_XPOSITION = 4;
    public static final int MAX_YPOSITION = 4;

    public static final int MIN_XPOSITION = 0;
    public static final int MIN_YPOSITION = 0;

    Direction direction;

    public MyRobot(int xPosition, int yPosition, Direction direction) throws RobotMovementException {

        validateRobotPosition(xPosition, yPosition);
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.direction = direction;
    }

    @Override
    public int getXposition() {
        return xPosition;
    }

    @Override
    public int getYposition() {
        return yPosition;
    }

    @Override
    public void setXposition(int xPosition) {
        this.xPosition = xPosition;
    }

    @Override
    public void setYposition(int yPosition) {
        this.yPosition = yPosition;
    }

    @Override
    public void move() throws RobotMovementException {
        int newXPosition = getNewXPosition();
        int newYPosition = getNewYPositon();
        validateRobotPosition(newXPosition, newYPosition);
        this.xPosition=newXPosition;
        this.yPosition=newYPosition;
        

    }

    private static void validateRobotPosition(int newXPosition, int newYPosition) throws RobotMovementException {
        if (!isValidPositions(newXPosition, newYPosition)) {
            throw new RobotMovementException("Hey there,I am expensive!! I will fall of the table and break on that move");
        }
    }

    @Override
    public void turn(RelativeDirection relativeDirection) {

        switch (relativeDirection) {
            case LEFT:
                this.direction = this.direction.getDirectionRule().getLeftTurn();
                break;
            case RIGHT:
                this.direction = this.direction.getDirectionRule().getRightTurn();
                break;
        }
    }

    @Override
    public String report() {
        return this.toString();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        final String outPut = xPosition + "," + yPosition + "," + direction.toString();
        return outPut;
    }

    private static boolean isValidXposition(int newXPosition) {
        return (newXPosition <= MAX_XPOSITION && newXPosition >= MIN_XPOSITION);
    }

    private static boolean isValidYposition(int newYPosition) {
        return (newYPosition <= MAX_YPOSITION && newYPosition >= MIN_YPOSITION);
    }

    private static boolean isValidPositions(int newXPosition, int newYPosition) {
        return isValidXposition(newXPosition) && isValidYposition(newYPosition);
    }

    private int getNewYPositon() {
        return this.yPosition + (this.direction.getDirectionRule().getyPositionIncrement());
    }

    private int getNewXPosition() {
        return this.xPosition + (this.direction.getDirectionRule().getxPositionIncrement());
    }
}
