/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.rearobot.test;

import au.com.rearobot.entity.MyRobot;
import au.com.rearobot.entity.Direction;
import au.com.rearobot.entity.RelativeDirection;
import au.com.rearobot.entity.Robot;
import au.com.rearobot.exception.RobotMovementException;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author nolan
 */
public class ReaRobotTest {

    Robot robot;

    @Before
    public void setUp() throws RobotMovementException {
        robot = new MyRobot(0, 0, Direction.NORTH);
    }

    @After
    public void tearDown() {
    }

    @Test(expected = RobotMovementException.class)
    public void testRobotPlaceMentException() throws RobotMovementException {
        Robot robot = new MyRobot(-1, 2, Direction.EAST);

    }

    @Test
    public void testRobotCreation() throws RobotMovementException {
        Assert.assertNotNull(robot);

    }

    @Test
    public void testRobotMovementTurnEastDirection() throws RobotMovementException {

        robot.move();
        robot.move();
        robot.move();
        robot.turn(RelativeDirection.RIGHT);
        robot.move();
        Assert.assertEquals("Report does not match", "1,3,EAST", robot.report());

    }

    @Test
    public void testRobotMovementPlaceMentAgain() throws RobotMovementException {

        robot.move();
        robot.move();
        robot.move();
        robot = new MyRobot(2, 2, Direction.WEST);
        robot.move();
        Assert.assertEquals("Report does not match", "1,2,WEST", robot.report());
    }

    @Test(expected = RobotMovementException.class)
    public void testRobotMovementTurnWestExceptionDirection() throws RobotMovementException {

        robot.move();
        robot.move();
        robot.move();
        robot.turn(RelativeDirection.LEFT);
        robot.move();
//        Assert.assertEquals("Report does not match", "1,3,EAST", robot.report());

    }

    @Test(expected = RobotMovementException.class)
    public void testRobotMovementTopException() throws RobotMovementException {
        robot.move();
        robot.move();
        robot.move();
        robot.move();
        robot.move();
    }

    @Test
    public void testRobotMovementTop() throws RobotMovementException {

        robot.move();
        robot.move();
        robot.move();
        robot.move();
        Assert.assertEquals("Report does not match", "0,4,NORTH", robot.report());
  
    }

}
