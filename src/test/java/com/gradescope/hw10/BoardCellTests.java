package com.gradescope.hw10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Tests the {@link BoardCell} class.
 * 
 * @author HMC CS 60 Instructors
 * @version Fall 2025
 */
public class BoardCellTests {
  /* ----------------------------- */
  /* toString and toString helpers */
  /* ----------------------------- */

  @Test
  public void testToString() {
    BoardCell wallCell = new BoardCell(10, 15, CellType.WALL);
    BoardCell openCell = new BoardCell(10, 15, CellType.OPEN);
    BoardCell spamCell = new BoardCell(10, 15, CellType.SPAM);
    BoardCell bodyCell = new BoardCell(10, 15, CellType.BODY);
    BoardCell headCell = new BoardCell(10, 15, CellType.HEAD);
    assertEquals("[10, 15, *]", wallCell.toString());
    assertEquals("[10, 15,  ]", openCell.toString());
    assertEquals("[10, 15, X]", spamCell.toString());
    assertEquals("[10, 15, B]", bodyCell.toString());
    assertEquals("[10, 15, H]", headCell.toString());
  }

  @Test
  public void testToStringHelper() {
    BoardCell wallCell = new BoardCell(10, 15, CellType.WALL);
    BoardCell openCell = new BoardCell(10, 15, CellType.OPEN);
    BoardCell spamCell = new BoardCell(10, 15, CellType.SPAM);
    BoardCell bodyCell = new BoardCell(10, 15, CellType.BODY);
    BoardCell headCell = new BoardCell(10, 15, CellType.HEAD);
    assertEquals("*", wallCell.toStringType());
    assertEquals(" ", openCell.toStringType());
    assertEquals("X", spamCell.toStringType());
    assertEquals("B", bodyCell.toStringType());
    assertEquals("H", headCell.toStringType());
  }

  /* ------------------------------------- */
  /* Access basic information about a cell */
  /* ------------------------------------- */

  // Row and column tests

  @Test
  public void testGetRow() {
    BoardCell wallCell = new BoardCell(10, 15, CellType.WALL);
    assertEquals(10, wallCell.getRow());
  }

  @Test
  public void testGetColumn() {
    BoardCell wallCell = new BoardCell(10, 15, CellType.WALL);
    assertEquals(15, wallCell.getColumn());
  }

  // Tests for type

  @Test
  public void testTypeWall() {
    BoardCell wallCell = new BoardCell(10, 15, CellType.WALL);
    assertTrue(wallCell.isWall());
    assertFalse(wallCell.isOpen());
    assertFalse(wallCell.isSpam());
    assertFalse(wallCell.isBody());
    assertFalse(wallCell.isHead());
  }

  @Test
  public void testTypeOpen() {
    BoardCell openCell = new BoardCell(10, 15, CellType.OPEN);
    assertFalse(openCell.isWall());
    assertTrue(openCell.isOpen());
    assertFalse(openCell.isSpam());
    assertFalse(openCell.isBody());
    assertFalse(openCell.isHead());
  }

  @Test
  public void testTypeSpam() {
    BoardCell spamCell = new BoardCell(10, 15, CellType.SPAM);
    assertFalse(spamCell.isWall());
    assertTrue(spamCell.isOpen()); // Spam is open
    assertTrue(spamCell.isSpam());
    assertFalse(spamCell.isBody());
    assertFalse(spamCell.isHead());
  }

  @Test
  public void testTypeBody() {
    BoardCell bodyCell = new BoardCell(10, 15, CellType.BODY);
    assertFalse(bodyCell.isWall());
    assertFalse(bodyCell.isOpen());
    assertFalse(bodyCell.isSpam());
    assertTrue(bodyCell.isBody());
    assertFalse(bodyCell.isHead());
  }

  @Test
  public void testTypeHead() {
    BoardCell headCell = new BoardCell(10, 15, CellType.HEAD);
    assertFalse(headCell.isWall());
    assertFalse(headCell.isOpen());
    assertFalse(headCell.isSpam());
    assertFalse(headCell.isBody());
    assertTrue(headCell.isHead());
  }

  // Test color

  @Test
  public void testCellColorWall() {
    BoardCell wallCell = new BoardCell(10, 15, CellType.WALL);
    assertEquals(Preferences.COLOR_WALL, wallCell.getCellColor());
  }

  @Test
  public void testCellColorOpen() {
    BoardCell openCell = new BoardCell(10, 15, CellType.OPEN);
    assertEquals(Preferences.COLOR_OPEN, openCell.getCellColor());
  }

  @Test
  public void testCellColorSpam() {
    BoardCell spamCell = new BoardCell(10, 15, CellType.SPAM);
    assertEquals(Preferences.COLOR_SPAM, spamCell.getCellColor());
  }

  @Test
  public void testCellColorBody() {
    BoardCell bodyCell = new BoardCell(10, 15, CellType.BODY);
    assertEquals(Preferences.COLOR_BODY, bodyCell.getCellColor());
  }

  @Test
  public void testCellColorHead() {
    BoardCell headCell = new BoardCell(10, 15, CellType.HEAD);
    assertEquals(Preferences.COLOR_HEAD, headCell.getCellColor());
  }

  /* ------------------------------ */
  /* Modify basic info about a cell */
  /* ------------------------------ */

  @Test
  public void testBecomeOpenWall() {
    BoardCell cell = new BoardCell(10, 15, CellType.WALL);
    cell.becomeOpen();
    assertFalse(cell.isWall());
    assertTrue(cell.isOpen());
    assertFalse(cell.isSpam());
    assertFalse(cell.isBody());
    assertFalse(cell.isHead());
  }

  @Test
  public void testBecomeOpenSpam() {
    BoardCell cell = new BoardCell(10, 15, CellType.SPAM);
    cell.becomeOpen();
    assertFalse(cell.isWall());
    assertTrue(cell.isOpen());
    assertFalse(cell.isSpam());
    assertFalse(cell.isBody());
    assertFalse(cell.isHead());
  }

  @Test
  public void testBecomeOpenBody() {
    BoardCell cell = new BoardCell(10, 15, CellType.BODY);
    cell.becomeOpen();
    assertFalse(cell.isWall());
    assertTrue(cell.isOpen());
    assertFalse(cell.isSpam());
    assertFalse(cell.isBody());
    assertFalse(cell.isHead());
  }

  @Test
  public void testBecomeOpenHead() {
    BoardCell cell = new BoardCell(10, 15, CellType.HEAD);
    cell.becomeOpen();
    assertFalse(cell.isWall());
    assertTrue(cell.isOpen());
    assertFalse(cell.isSpam());
    assertFalse(cell.isBody());
    assertFalse(cell.isHead());
  }

  @Test
  public void testBecomeSpamOpen() {
    BoardCell cell = new BoardCell(10, 15, CellType.OPEN);
    cell.becomeSpam();
    assertFalse(cell.isWall());
    assertTrue(cell.isOpen());
    assertTrue(cell.isSpam());
    assertFalse(cell.isBody());
    assertFalse(cell.isHead());
  }

  @Test
  public void testBecomeHeadOpen() {
    BoardCell cell = new BoardCell(10, 15, CellType.OPEN);
    cell.becomeHead();
    assertFalse(cell.isWall());
    assertFalse(cell.isOpen());
    assertFalse(cell.isSpam());
    assertFalse(cell.isBody());
    assertTrue(cell.isHead());
  }

  @Test
  public void testBecomeHeadBody() {
    BoardCell cell = new BoardCell(10, 15, CellType.BODY);
    cell.becomeHead();
    assertFalse(cell.isWall());
    assertFalse(cell.isOpen());
    assertFalse(cell.isSpam());
    assertFalse(cell.isBody());
    assertTrue(cell.isHead());
  }

  @Test
  public void testBecomeBodyOpen() {
    BoardCell cell = new BoardCell(10, 15, CellType.OPEN);
    cell.becomeBody();
    assertFalse(cell.isWall());
    assertFalse(cell.isOpen());
    assertFalse(cell.isSpam());
    assertTrue(cell.isBody());
    assertFalse(cell.isHead());
  }

  @Test
  public void testBecomeBodyHead() {
    BoardCell cell = new BoardCell(10, 15, CellType.HEAD);
    cell.becomeBody();
    assertFalse(cell.isWall());
    assertFalse(cell.isOpen());
    assertFalse(cell.isSpam());
    assertTrue(cell.isBody());
    assertFalse(cell.isHead());
  }

  /* ------------------------------------------ */
  /* Methods used to access and set search info */
  /* ------------------------------------------ */

  @Test
  public void testSearchMethods() {
    BoardCell cell = new BoardCell(10, 15, CellType.OPEN);
    assertFalse(cell.alreadySearched());
    cell.addToSearch();
    assertTrue(cell.alreadySearched());
    cell.resetSearch();
    assertFalse(cell.alreadySearched());
  }

  @Test
  public void testParentMethods() {
    BoardCell cell1 = new BoardCell(10, 15, CellType.OPEN);
    BoardCell cell2 = new BoardCell(10, 15, CellType.OPEN);
    cell1.setParent(cell2);
    assertEquals(cell2, cell1.getParent());
  }
}
