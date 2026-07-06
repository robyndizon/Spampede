package com.gradescope.hw10;

/**
 * The mode of a snake: going north, going south, going east, going west, or if
 * the snake is in AI mode (direction determined by AI).
 * 
 * <p>
 * Refer to {@link CellType} for a description of enum types.
 * </p>
 * 
 * @author HMC CS 60 Instructors
 * @version Fall 2025
 */
enum SnakeMode {
  /** Indicates the snake is heading in the north direction. */
  GOING_NORTH,

  /** Indicates the snake is heading in the south direction. */
  GOING_SOUTH,

  /** Indicates the snake is heading in the east direction. */
  GOING_EAST,

  /** Indicates the snake is heading in the west direction. */
  GOING_WEST,

  /**
   * Indicates the snake is automonously heading towards spam in a direction
   * determined by the AI.
   */
  AI_MODE;
}
