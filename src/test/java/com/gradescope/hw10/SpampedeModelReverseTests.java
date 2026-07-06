package com.gradescope.hw10;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests the {@link SpampedeModel#reverseSnake()} method.
 * 
 * @author HMC CS 60 Instructors
 * @version Fall 2025
 */
public class SpampedeModelReverseTests {
  // Pictures of test boards at http://tinyurl.com/spampedeTestBoards

  @Test
  public void testReverseNorth() {
    SpampedeModel model = new SpampedeModel(TestGame.G14);
    model.reverseSnake();
    BoardCell nextCell = model.getNextCellInDir();
    assertEquals("[1, 2,  ]", nextCell.toString());
  }

  @Test
  public void testReverseSouth() {
    SpampedeModel model = new SpampedeModel(TestGame.G13);
    model.reverseSnake();
    BoardCell nextCell = model.getNextCellInDir();
    assertEquals("[4, 2,  ]", nextCell.toString());
  }

  @Test
  public void testReverseEast() {
    SpampedeModel model = new SpampedeModel(TestGame.G12);
    model.reverseSnake();
    BoardCell nextCell = model.getNextCellInDir();
    assertEquals("[2, 4,  ]", nextCell.toString());
  }

  @Test
  public void testReverseWest() {
    SpampedeModel model = new SpampedeModel(TestGame.G15);
    model.reverseSnake();
    BoardCell nextCell = model.getNextCellInDir();
    assertEquals("[3, 1,  ]", nextCell.toString());
  }
}
