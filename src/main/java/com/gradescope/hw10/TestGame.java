package com.gradescope.hw10;

/**
 * Sets up game boards for testing purposes. Find pictures of test boards at:
 * http://tinyurl.com/spampedeTestBoards
 * 
 * @author HMC CS 60 Instructors
 * @version Fall 2025
 */
enum TestGame {
  // Pictures of test boards at http://tinyurl.com/spampedeTestBoards
  G1(true), G2(true), G3(true), G4(true), G5(true), G6(true), G7(true), G8(true), 
  G9(true), G10(true), G11(true), G12(false), G13(false), G14(false), G15(false);

  /** Indicates whether the snake is at the starting location. */
  private boolean snakeAtStart;

  /**
   * Initializes a new game board.
   * 
   * @param snakeAtStart whether the snake is at the starting location
   */
  private TestGame(boolean snakeAtStart) {
    this.snakeAtStart = snakeAtStart;
  }

  /** {@return {@code true} if the snake is at the starting location} */
  public boolean snakeAtStart() {
    return this.snakeAtStart;
  }
}
