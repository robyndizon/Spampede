package com.gradescope.hw10;

import java.awt.Color;

/**
 * Represents a single cell within a board.
 * 
 * @author HMC CS 60 Instructors
 * @version Fall 2025
 * 
 * @see CellType
 * @see SpampedeModel
 */
public class BoardCell {
  /* ----------------------------- */
  /* Basic contents of a BoardCell */
  /* ----------------------------- */

  /** The row of this cell within the board (non-negative). */
  private final int row;

  /** The column of this cell within the board (non-negative). */
  private final int column;

  /** The current contents of this cell. */
  private CellType type;

  /* ---------------------------- */
  /* Variables used during search */
  /* ---------------------------- */

  /** Has this cell been added to the search queue yet? */
  private boolean addedToSearch;

  /** Where did we came from, when search first reached this BoardCell? */
  private BoardCell parent;

  /**
   * Creates a new BoardCell.
   * 
   * @param row    the row of this cell
   * @param column the column of this cell
   * @param type   the initial contents of this cell
   */
  public BoardCell(int row, int column, CellType type) {
    this.row = row;
    this.column = column;
    this.type = type;

    this.addedToSearch = false;
    this.parent = null;
  }

  /* ------------------------------------- */
  /* Access basic information about a cell */
  /* ------------------------------------- */

  // Demonstrates a quick way to generate Javadoc for getter/get methods
  // https://docs.oracle.com/en/java/javase/21/docs/specs/javadoc/doc-comment-spec.html

  /** {@return the row of this cell} */
  public int getRow() {
    return this.row;
  }

  /** {@return the column of this cell} */
  public int getColumn() {
    return this.column;
  }

  /** {@return true if this cell is a wall} */
  public boolean isWall() {
    return this.type == CellType.WALL;
  }

  /** {@return true if this cell is open (not a wall or a snake body part)} */
  public boolean isOpen() {
    return this.type == CellType.OPEN || this.isSpam();
  }

  /** {@return true if this cell contains spam} */
  public boolean isSpam() {
    return this.type == CellType.SPAM;
  }

  /** {@return true if this cell contains a snake body part (not the head)} */
  public boolean isBody() {
    return this.type == CellType.BODY;
  }

  /** {@return true if this cell contains the head of the snake} */
  public boolean isHead() {
    return this.type == CellType.HEAD;
  }

  /** {@return the color for drawing this cell} */
  public Color getCellColor() {
    if (this.isWall()) {
      return Preferences.COLOR_WALL;
    } else if (this.isSpam()) {
      return Preferences.COLOR_SPAM;
    } else if (this.isOpen()) {
      return Preferences.COLOR_OPEN;
    } else if (this.isHead()) {
      return Preferences.COLOR_HEAD;
    } else if (this.isBody()) {
      return Preferences.COLOR_BODY;
    } else {
      return Preferences.COLOR_OPEN;
    }
  }

  /* ------------------------------ */
  /* Modify basic info about a cell */
  /* ------------------------------ */

  /** Marks this cell as spam. */
  public void becomeSpam() {
    this.type = CellType.SPAM;
  }

  /** Marks this cell as open. */
  public void becomeOpen() {
    this.type = CellType.OPEN;
  }

  /** Marks this cell as the snake's head. */
  public void becomeHead() {
    this.type = CellType.HEAD;
  }

  /** Marks this cell as part of the snake's body. */
  public void becomeBody() {
    this.type = CellType.BODY;
  }

  /* -------------------------- */
  /* Access and set search info */
  /* -------------------------- */

  /** Marks this cell as having been added to our BFS search queue. */
  public void addToSearch() {
    this.addedToSearch = true;
  }

  /**
   * {@return {@code true} if this cell has been added to our BFS search queue}
   */
  public boolean alreadySearched() {
    return this.addedToSearch;
  }

  /** Reset the search-related info for this cell (to allow a new search). */
  public void resetSearch() {
    this.addedToSearch = false;
    this.parent = null;
  }

  /**
   * Sets the parent of this cell in our BFS search.
   * 
   * @param parent the new parent cell
   */
  public void setParent(BoardCell parent) {
    this.parent = parent;
  }

  /** {@return the parent of this cell in our BFS search} */
  public BoardCell getParent() {
    return this.parent;
  }

  /* ---------------------------- */
  /* Helper functions for testing */
  /* ---------------------------- */

  /** {@return this cell as a string "[row, col, type]"} */
  @Override
  public String toString() {
    return "[" + this.row + ", " + this.column + ", " + this.toStringType() + "]";
  }

  /** {@return the contents of this cell, as a single character} */
  public String toStringType() {
    return this.type.getDisplayChar();
  }

  /** {@return the parent of this cell, as a string "[null]" or "[row, col]"} */
  public String toStringParent() {
    if (this.parent == null) {
      return "[null]";
    } else {
      return "[" + this.parent.row + ", " + this.parent.column + "]";
    }
  }
}
