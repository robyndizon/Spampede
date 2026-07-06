package com.gradescope.hw10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * The "view" in MVC that is responsible for drawing the board on the screen.
 * 
 * @author HMC CS 60 Instructors
 * @version Fall 2025
 */
class SpampedeView {
  /** The board/spampede data being drawn. */
  private SpampedeModel model;

  /** The controller, receiving actions from buttons/menus */
  private final SpampedeController controller;

  /** The display where the board is drawn. */
  private final Graphics screen;

  // TODO HW #10.0C Add final where appropriate to members below!

  /** The width of the display in pixels. */
  private int width;

  /** The height of the display in pixels. */
  private int height;

  /** The overall game window */
  private JFrame frame;

  /** The off-screen buffer of image */
  private BufferedImage image;

  /** The panel to display the image */
  SpampedeImagePanel panel;

  /** A picture of a can of spam. */
  private static Image imageSpam;

  /**
   * Creates a new SpampedeView.
   *
   * @param controller the model controller
   * @param model      the model data
   * @param width      the width of the display (in pixels)
   * @param height     the height of the display (in pixels)
   */
  public SpampedeView(SpampedeController controller, SpampedeModel model, int width, int height) {
    this.controller = controller;
    this.model = model;
    this.height = height;
    this.width = width;

    // Initialize the frame
    this.frame = new JFrame("Spampede Game"); 
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.frame.setLayout(new BorderLayout());

    // Initialize controls
    this.initializeButtons();
    this.initializeMenu();
    this.initializeImage();

    // Set up the (off-screen) buffer for drawing, named image
    // image = createImage(Preferences.GAMEBOARDWIDTH, Preferences.GAMEBOARDHEIGHT);
    this.image = new BufferedImage(Preferences.BOARD_WIDTH, Preferences.BOARD_HEIGHT, BufferedImage.TYPE_INT_RGB);
    this.screen = this.image.getGraphics(); // screen holds the drawing routines
    this.panel = new SpampedeImagePanel(this.image);

    // Add a central panel which holds the buffer (the game board)
    this.frame.add(this.panel, BorderLayout.SOUTH);

    this.frame.pack();
    this.frame.setSize(Preferences.BOARD_WIDTH, 600);
    this.frame.setVisible(true);
  }

  /**
   * Initializes all buttons.
   */
  private void initializeButtons() {
    // add a panel for buttons
    JPanel buttonPane = new JPanel(new FlowLayout());
    buttonPane.setBackground(Preferences.COLOR_BACKGROUND);

    JButton newGameButton = new JButton("New Game"); // the text in the button
    newGameButton.addActionListener(this.controller); // watch for button presses
    newGameButton.setActionCommand("New Game"); // command to send when button is pressed
    newGameButton.setFocusable(false);
    buttonPane.add(newGameButton); // add button to the panel

    JButton pauseButton = new JButton("Pause"); // a second button
    pauseButton.addActionListener(this.controller);
    pauseButton.setActionCommand("Pause");
    pauseButton.addKeyListener(this.controller); // unclear why Java likes listener here but doesn't work with it
                                                 // on other buttons
    buttonPane.add(pauseButton);

    JButton startButton = new JButton("Start"); // a third button
    startButton.addActionListener(this.controller);
    startButton.setActionCommand("Start");

    startButton.addKeyListener(this.controller); // something needs a KeyListener
    buttonPane.add(startButton);
    this.frame.add(buttonPane);
  }

  /**
   * Initializes all menu items.
   */
  private void initializeMenu() {
    // set up the menu bar
    JMenuBar menuBar = new JMenuBar();

    // add a menu to contain items
    JMenu gameMenu = new JMenu("Game"); // the menu name
    menuBar.add(gameMenu); // add the menu to the menu bar

    JMenuItem newGameItem = new JMenuItem("New Game"); // the text in the menu
    newGameItem.addActionListener(this.controller); // watch for button presses
    newGameItem.setActionCommand("New Game");
    gameMenu.add(newGameItem); // add the item to the menu

    JMenuItem pauseItem = new JMenuItem("Pause"); // a second menu item
    pauseItem.addActionListener(this.controller);
    pauseItem.setActionCommand("Pause");
    gameMenu.add(pauseItem);

    JMenuItem startItem = new JMenuItem("Start"); // a third menu item
    startItem.addActionListener(this.controller);
    startItem.setActionCommand("Start");
    gameMenu.add(startItem);

    this.frame.add(menuBar, BorderLayout.PAGE_START);
  }

  /** Initializes the spam image. */
  private void initializeImage() {
    try {
      File spamFile = new File("media/spam.gif").getAbsoluteFile();
      imageSpam = new ImageIcon(spamFile.toString()).getImage();
    } catch (Exception e) {
      System.out.println("Problem loading image media/spam.gif!");
      imageSpam = null;
    }
  }

  // TODO HW #10.0C Add missing Javadoc!

  public void updateModel(SpampedeModel model) {
    this.model = model;
    this.updateGraphics();
  }

  /* -------------------- */
  /* Displaying the board */
  /* -------------------- */

  /**
   * Re-draws the board, spam, and snake (but not the buttons).
   */
  public void updateGraphics() {
    // Draw the background -- DO NOT REMOVE!
    this.clear();

    // Draw the title
    this.displayTitle();

    // pixel width/height of the board
    int boardPixelWidth = Preferences.NUM_CELLS_WIDE * Preferences.CELL_SIZE;

    // center horizontally
    int offsetX = (this.width - boardPixelWidth) / 2;

    // vertical offset (below title)
    int offsetY = Preferences.TITLE_Y + 40;

    for (int row = 0; row < Preferences.NUM_CELLS_TALL; row++) {
        for (int col = 0; col < Preferences.NUM_CELLS_WIDE; col++) {
            // Use the model helper that accepts row and column
            Color color = this.model.getCellColor(row, col);

            int pixelX = offsetX + col * Preferences.CELL_SIZE;
            int pixelY = offsetY + row * Preferences.CELL_SIZE;

            this.drawSquare(pixelX, pixelY, color);
        }
    }

    // Display an image, just for fun
    if (SpampedeView.imageSpam != null) {
      int x = (this.width / 2) - 54;
      int y = 370;
      this.screen.drawImage(SpampedeView.imageSpam, x, y, null);
    }

    // Draw the game-over message, if appropriate
    if (this.model.getGameOver()) {
      this.displayGameOver();
    }

    // send the new drawing to the screen
    this.panel.repaint();
  }

  /**
   * Draws a cell-sized square with its upper-left corner at the specified pixel
   * coordinates (i.e. x pixels to the right and y pixels below the upper-left
   * corner) on the display.
   * 
   * @param x         the x-coordinate, between 0 and width-1 inclusive
   * @param y         the y-coordinate, between 0 and height-1 inclusive
   * @param cellColor the color of the square being drawn
   */
  private void drawSquare(int x, int y, Color cellColor) {
    this.screen.setColor(cellColor);
    this.screen.fillRect(x, y, Preferences.CELL_SIZE, Preferences.CELL_SIZE);
  }

  /**
   * Draws the background. DO NOT MODIFY!
   */
  private void clear() {
    this.screen.setColor(Preferences.COLOR_BACKGROUND);
    this.screen.fillRect(0, 0, this.width, this.height);
    this.screen.setColor(Preferences.TITLE_COLOR);
    this.screen.drawRect(0, 0, this.width - 1, Preferences.BOARD_HEIGHT - 1);
  }

  /* ------------ */
  /* Text display */
  /* ------------ */

  /**
   * Displays the title of the game.
   */
  private void displayTitle() {
    this.screen.setFont(Preferences.TITLE_FONT);
    this.screen.setColor(Preferences.TITLE_COLOR);
    this.screen.drawString(Preferences.TITLE, Preferences.TITLE_X, Preferences.TITLE_Y);
  }

  /**
   * Displays the game-over message.
   */
  private void displayGameOver() {
    this.screen.setFont(Preferences.GAME_OVER_FONT);
    this.screen.setColor(Preferences.GAME_OVER_COLOR);
    this.screen.drawString(Preferences.GAME_OVER_TEXT, Preferences.GAME_OVER_X, Preferences.GAME_OVER_Y);
  }
}
