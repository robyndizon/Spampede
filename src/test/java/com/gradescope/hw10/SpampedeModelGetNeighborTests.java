package com.gradescope.hw10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

/**
 * Tests the get____Neighbor methods in {@link SpampedeModel}.
 * 
 * @author HMC CS 60 Instructors
 * @version Fall 2025
 * 
 * @see SpampedeModel#getNorthNeighbor(BoardCell)
 * @see SpampedeModel#getSouthNeighbor(BoardCell)
 * @see SpampedeModel#getEastNeighbor(BoardCell)
 * @see SpampedeModel#getWestNeighbor(BoardCell)
 */
public class SpampedeModelGetNeighborTests {
  // Pictures of test boards at http://tinyurl.com/spampedeTestBoards

  @Test
  public void testNorthNeighborCell() {
    SpampedeModel model = new SpampedeModel(TestGame.G1);
    BoardCell focalCell = model.getCell(2, 3);
    BoardCell neighborCell = model.getNorthNeighbor(focalCell);

    // check the cell looks correct
    assertEquals("[1, 3, X]", neighborCell.toString());

    // check they're the same object using == (not a new BoardCell!)
    assertSame(model.getCell(1, 3), neighborCell);
  }

  @Test
  public void testNorthNeighbor() {
    SpampedeModel model = new SpampedeModel(TestGame.G1);
    BoardCell neighborCell = model.getNorthNeighbor();

    // check the cell looks correct
    assertEquals("[0, 2, *]", neighborCell.toString());

    // check they're the same object using == (not a new BoardCell!)
    assertSame(model.getCell(0, 2), neighborCell);

  }

  @Test
  public void testSouthNeighborCell() {
    SpampedeModel model = new SpampedeModel(TestGame.G1);
    BoardCell focalCell = model.getCell(2, 3);
    BoardCell neighborCell = model.getSouthNeighbor(focalCell);

    // check the cell looks correct
    assertEquals("[3, 3,  ]", neighborCell.toString());

    // check they're the same object using == (not a new BoardCell!)
    assertSame(model.getCell(3, 3), neighborCell);
  }

  @Test
  public void testSouthNeighbor() {
    SpampedeModel model = new SpampedeModel(TestGame.G1);
    BoardCell neighborCell = model.getSouthNeighbor();

    // check the cell looks correct
    assertEquals("[2, 2,  ]", neighborCell.toString());

    // check they're the same object using == (not a new BoardCell!)
    assertSame(model.getCell(2, 2), neighborCell);
  }

  @Test
  public void testEastNeighborCell() {
    SpampedeModel model = new SpampedeModel(TestGame.G1);
    BoardCell focalCell = model.getCell(2, 3);
    BoardCell neighborCell = model.getEastNeighbor(focalCell);

    // check the cell looks correct
    assertEquals("[2, 4,  ]", neighborCell.toString());

    // check they're the same object using == (not a new BoardCell!)
    assertSame(model.getCell(2, 4), neighborCell);
  }

  @Test
  public void testEastNeighbor() {
    SpampedeModel model = new SpampedeModel(TestGame.G1);
    BoardCell neighborCell = model.getEastNeighbor();

    // check the cell looks correct
    assertEquals("[1, 3, X]", neighborCell.toString());

    // check they're the same object using == (not a new BoardCell!)
    assertSame(model.getCell(1, 3), neighborCell);
  }

  @Test
  public void testWestNeighborCell() {
    SpampedeModel model = new SpampedeModel(TestGame.G1);
    BoardCell focalCell = model.getCell(2, 3);
    BoardCell neighborCell = model.getWestNeighbor(focalCell);

    // check the cell looks correct
    assertEquals("[2, 2,  ]", neighborCell.toString());

    // check they're the same object using == (not a new BoardCell!)
    assertSame(model.getCell(2, 2), neighborCell);
  }

  @Test
  public void testWestNeighbor() {
    SpampedeModel model = new SpampedeModel(TestGame.G1);
    BoardCell neighborCell = model.getWestNeighbor();

    // check the cell looks correct
    assertEquals("[1, 1, B]", neighborCell.toString());

    // check they're the same object using == (not a new BoardCell!)
    assertSame(model.getCell(1, 1), neighborCell);
  }
}
