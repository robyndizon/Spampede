package com.gradescope.hw10;

import java.awt.Color;
import java.awt.Font;

/**
 * Represents settings for Spampede. Constants are stored in this file to avoid
 * "magic strings" and "magic numbers" and allow greater configurability.
 * 
 * @author HMC CS 60 Instructors
 * @version Fall 2025
 */
public final class Preferences {
  private Preferences() {}

  /* ------ */
  /* Timing */
  /* ------ */

  /** The rate to refresh when drawing. */
  public static final int REFRESH_RATE = 2;

  /** The rate to add spam to the board. */
  public static final int SPAM_ADD_RATE = 25;

  /** The time in milliseonds to wait between updates. */
  public static final int SLEEP_TIME = 30;

  /* ------ */
  /* Sizing */
  /* ------ */

  /** The number of cells wide in the game board. */
  public static final int NUM_CELLS_WIDE = 50;

  /** The number of cells tall in the game board. */
  public static final int NUM_CELLS_TALL = 30;

  /** The size of the individual board cells. */
  public static final int CELL_SIZE = 10;

  /** The space to leave for the buttons. */
  private static final int SPACE_FOR_BUTTONS = 190;

  /** The calculated game board height. */
  public static final int BOARD_HEIGHT = NUM_CELLS_TALL * CELL_SIZE + SPACE_FOR_BUTTONS;

  /** The calculated game board width. */
  public static final int BOARD_WIDTH = NUM_CELLS_WIDE * CELL_SIZE + 80;

  /* ------ */
  /* Colors */
  /* ------ */

  /** The color of the background. */
  public static final Color COLOR_BACKGROUND = Color.ORANGE;

  /** The color of the walls. */
  public static final Color COLOR_WALL = Color.BLUE;

  /** The color of spam. */
  public static final Color COLOR_SPAM = Color.ORANGE;

  /** The color of open cells. */
  public static final Color COLOR_OPEN = Color.WHITE;

  /** The color of the snake head. */
  public static final Color COLOR_HEAD = Color.BLACK;

  /** The color of the snake body. */
  public static final Color COLOR_BODY = Color.GREEN;

  /* -------------------- */
  /* Text display - Title */
  /* -------------------- */

  /** The title x position. */
  public static final int TITLE_X = 100;

  /** The title y position. */
  public static final int TITLE_Y = 40;

  /** The title font. */
  public static final Font TITLE_FONT = new Font("Arial", Font.PLAIN, 30);

  /** The title color. */
  public static final Color TITLE_COLOR = Color.BLUE;
  
  /** The title text. */
  public static final String TITLE = "Spampede"; 

  /* ------------------------ */
  /* Text display - Game Over */
  /* ------------------------ */

  /** The game over message y position. */
  public static final int GAME_OVER_X = 150;

  /** The game over message y position. */
  public static final int GAME_OVER_Y = 200;

  /** The game over message font. */
  public static final Font GAME_OVER_FONT = new Font("Arial", Font.BOLD, 60);

  /** The game over message color. */
  public static final Color GAME_OVER_COLOR = Color.BLUE;

  /** The game over message text. */
  public static final String GAME_OVER_TEXT = "Game Over";
}
