package com.gradescope.hw10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Tests the {@link SpampedeModel#getNextCellFromBFS()} method.
 * 
 * @author HMC CS 60 Instructors
 * @version Fall 2025
 */
public class SpampedeModelBFSGetNextCellTests {
  // Pictures of test boards at http://tinyurl.com/spampedeTestBoards

  @Test
  public void testG1BFS() {
    SpampedeModel model = new SpampedeModel(TestGame.G1);
    BoardCell nextCell = model.getNextCellFromBFS();
    assertEquals("[1, 3, X]", nextCell.toString());
  }

  @Test
  public void testG2BFS() {
    SpampedeModel model = new SpampedeModel(TestGame.G2);
    BoardCell nextCell = model.getNextCellFromBFS();
    assertEquals("[2, 2, X]", nextCell.toString());
  }

  @Test
  public void testG3BFS() {
    SpampedeModel model = new SpampedeModel(TestGame.G3);
    BoardCell nextCell = model.getNextCellFromBFS();
    assertEquals("[1, 3,  ]", nextCell.toString());
  }

  @Test
  public void testG4BFS() {
    SpampedeModel model = new SpampedeModel(TestGame.G4);
    BoardCell nextCell = model.getNextCellFromBFS();
    assertEquals("[2, 2,  ]", nextCell.toString());
  }

  @Test
  public void testG5BFS() {
    SpampedeModel model = new SpampedeModel(TestGame.G5);
    BoardCell nextCell = model.getNextCellFromBFS();
    assertEquals("[2, 2,  ]", nextCell.toString());
  }

  @Test
  public void testG6BFS() {
    SpampedeModel model = new SpampedeModel(TestGame.G6);
    BoardCell nextCell = model.getNextCellFromBFS();
    assertEquals("[1, 3, X]", nextCell.toString());
  }

  @Test
  public void testG7BFS() {
    SpampedeModel model = new SpampedeModel(TestGame.G7);
    BoardCell nextCell = model.getNextCellFromBFS();
    assertEquals("[2, 2, X]", nextCell.toString());
  }

  @Test
  public void testG8BFS() {
    SpampedeModel model = new SpampedeModel(TestGame.G8);
    BoardCell nextCell = model.getNextCellFromBFS();
    assertEquals("[1, 3,  ]", nextCell.toString());
  }

  @Test
  public void testG9BFS() {
    SpampedeModel model = new SpampedeModel(TestGame.G9);
    BoardCell nextCell = model.getNextCellFromBFS();
    assertEquals("[2, 2,  ]", nextCell.toString());
  }

  @Test
  public void testGGame10BFS() {
    SpampedeModel model = new SpampedeModel(TestGame.G10);
    BoardCell nextCell = model.getNextCellFromBFS();
    assertEquals("[2, 2,  ]", nextCell.toString());
  }

  @Test
  public void testGGame11BFS() {
    SpampedeModel model = new SpampedeModel(TestGame.G11);
    BoardCell nextCell = model.getNextCellFromBFS();

    // NEED AN OR!
    String possibleResult1 = "[1, 3,  ]";
    String possibleResult2 = "[2, 2,  ]";
    String nextCellString = nextCell.toString();
    assertTrue(possibleResult1.equals(nextCellString) || possibleResult2.equals(nextCellString));
  }
}
