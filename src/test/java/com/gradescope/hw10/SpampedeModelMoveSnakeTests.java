package com.gradescope.hw10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests the {@link SpampedeModel#moveSnakeForward(BoardCell)} method.
 * 
 * @author HMC CS 60 Instructors
 * @version Fall 2025
 */
public class SpampedeModelMoveSnakeTests {
  @Test
  public void testEatSpam() {
    SpampedeModel data = new SpampedeModel(TestGame.G1);
    data.moveSnakeForward(data.getNextCellInDir());
    String boardString = data.toString();
    String correctBoardString = "******\n" + "*BBH *\n" + "*    *\n" + "*    *\n" + "*    *\n" + "******\n";

    // Sample debugging output:
    // System.out.println("G1");
    // System.out.println("Expected:");
    // System.out.println(correctBoardString);
    // System.out.println("Actual:");
    // System.out.println(boardString);

    assertEquals(correctBoardString, boardString);
  }

  @Test
  public void testNoSpamEaten() {
    SpampedeModel data = new SpampedeModel(TestGame.G2);
    data.moveSnakeForward(data.getNextCellInDir());
    String boardString = data.toString();
    String correctBoardString = "******\n" + "* BH *\n" + "* X  *\n" + "*    *\n" + "*    *\n" + "******\n";

    // Sample debugging output:
    // System.out.println("G2");
    // System.out.println("Expected:");
    // System.out.println(correctBoardString);
    // System.out.println("Actual:");
    // System.out.println(boardString);

    assertEquals(correctBoardString, boardString);
  }
}