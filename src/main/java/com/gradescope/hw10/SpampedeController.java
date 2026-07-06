package com.gradescope.hw10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * SpampedeController
 * 
 * @author HMC CS 60 Instructors
 * @version Fall 2025
 */
public class SpampedeController extends JPanel implements ActionListener, KeyListener, Runnable {
  /** The "view" in MVC. */
  private SpampedeView view;

  /** The "model" in MVC. */
  public SpampedeModel model;

  /** The sound for spam. */
  public AudioInputStream audioSpam;
  
  /** The sound when the snake eats spam. */
  public AudioInputStream audioCrunch;

  /** The thread controlling the updates. */
  Thread thread;

  /** Tracks whether or not the thread is suspended. */
  boolean threadSuspended;

  /** Tracks whether or not the thread is stopped. */
  boolean running;

  // The mappings between direction (names) and keys.

  /** Key to reverse snake. */
  private static final char REVERSE = 'r';

  /** Key to move up. */
  private static final char UP = 'i';

  /** Key to move down. */
  private static final char DOWN = 'k';

  /** Key to move left. */
  private static final char LEFT = 'j';

  /** Key to move right. */
  private static final char RIGHT = 'l';

  /** Key to start AI mode. */
  private static final char AI_MODE = 'a';

  /** Key to play the spam noise. */
  private static final char PLAY_SPAM_NOISE = 's';

  /**
   * Helper function for loading audio clips.
   * 
   * @param path the file path to load
   * @return {@code null} if unable to load clip
   */
  private AudioInputStream loadClip(String path) {
    try {
      File audioFile = new File(path).getAbsoluteFile();
      return AudioSystem.getAudioInputStream(audioFile);
    } catch (NullPointerException e) {
      System.out.println("Problem loading audio " + path + " : file is null");
    } catch (UnsupportedAudioFileException e) {
      System.out.println("Problem loading audio " + path
          + " : this audio file data is not recognized/supported; it may need to be reencoded");
    } catch (IOException e) {
      System.out.println(
          "Problem loading audio " + path + " : an IOException has occured; check the file name and path!");
    } catch (Exception e) {
      System.out.println("Unknown problem loading audio from " + path);
    }

    return null;
  }

  /**
   * Constructor for the controller
   */
  public SpampedeController() {
    // Loading audio using the helper function loadClip
    this.audioSpam = this.loadClip("media/spam.wav");
    this.audioCrunch = this.loadClip("media/crunch.wav");

    // Initialize the view and start the game
    this.view = new SpampedeView(this, null, Preferences.BOARD_WIDTH, 600);
    this.startNewGame(); // Set up the game internals!
  }

  /**
   * Processes buttons and menu items.
   */
  @Override
  public void actionPerformed(ActionEvent evt) {
    String actionCommand = evt.getActionCommand();
    switch (actionCommand) {
    case "New Game":
      this.startNewGame();
      this.go();
      break;
    case "Pause":
      this.pause();
      break;
    case "Start":
      this.go();
      break;
    }
    this.requestFocus(); // makes sure this applet keeps keyboard focus
  }

  /**
   * Reacts to characters typed by the user.
   * 
   * <p>
   * SpampedeCibtrikker registers as an "observer" for key presses on the
   * keyboard. So, whenever the user presses a key, Java automatically calls this
   * keyPressed method and passes it a KeyEvent describing the specific key press.
   * </p>
   */
  @Override
  public void keyPressed(KeyEvent evt) {
    switch (evt.getKeyChar()) { // get the char of the pressed key
    
    case REVERSE:
        this.model.reverseSnake();
        break;

    case UP:
        this.model.setDirectionNorth();
        break;

    case DOWN:
        this.model.setDirectionSouth();
        break;

    case LEFT:
        this.model.setDirectionWest();
        break;

    case RIGHT:
        this.model.setDirectionEast();
        break;

    case AI_MODE:
      this.model.setAIMode();
      break;

    case PLAY_SPAM_NOISE:
      this.playSound_spam();
      break;
    }
  }

  @Override
  public void keyReleased(KeyEvent evt) {}

  @Override
  public void keyTyped(KeyEvent evt) {}

  /**
   * Called to run this applet.
   */
  @Override
  public void run() {
    // calls the "model.cycle()" method every so often (every sleepTime
    // milliseconds)
    while (this.running) {
      try {
        if (this.thread != null) {
          Thread.sleep(Preferences.SLEEP_TIME);
          synchronized (this) {
            while (this.threadSuspended) {
              this.wait(); // sleeps until notify() wakes it up
            }
          }
        }
      } catch (InterruptedException e) {
        ;
      }

      this.model.cycle(); // this represents 1 update cycle for the environment
    }
    this.thread = null;
  }

  /**
   * Called when the "Start" button is pressed.
   */
  public synchronized void go() {
    if (this.thread == null) {
      this.thread = new Thread(this);
      this.running = true;
      this.thread.start();
      this.threadSuspended = false;
    } else {
      this.threadSuspended = false;
    }
    this.notify(); // wakes up the call to wait(), above
  }

  /**
   * Called when the "Pause" button is pressed.
   */
  void pause() {
    if (this.thread != null)
      this.threadSuspended = true;
  }

  /** Starts a new game. */
  public void startNewGame() {
    this.model = new SpampedeModel(this, this.view);
    this.model.placeSnakeAtStartLocation();
    this.model.setStartDirection();

    this.view.updateModel(this.model);

    /**
     * Hack because pictures have a delay in loading, and we do not redraw the
     * screen again until the game actually starts, which means we would not see the
     * image until the game does start. Wait a fraction of a second (200 ms), by
     * which time the picture should have been fetched from disk, and redraw.
     */
    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }

    this.view.updateGraphics();
    this.playSound(this.audioSpam);
  }

  /** Declares the game over. */
  public void gameOver() {
    if (this.thread != null)
      this.threadSuspended = true;
    this.model.setGameOver(); // tell the model that the game is over
  }

  /* ------ */
  /* Sounds */
  /* ------ */

  /** Plays crunch noise. */
  public void playSound_spamEaten() {
    this.playSound("media/crunch.wav");
  }

  /** Plays spam noise. */
  public void playSound_spam() {
    this.playSound("media/spam.wav");
  }

  /**
   * Places a sound from the given input stream.
   * 
   * @param sound the input stream for the sound
   */
  public void playSound(AudioInputStream sound) {
    if (sound != null) {
      try {
        Clip clip = AudioSystem.getClip();
        clip.open(sound);
        clip.start();
      } catch (Exception e) {
        System.out.println("Problem playing sound " + sound);
      }
    }
  }

  /**
   * Places a sound from the given file name.
   * 
   * @param filename the file name of the sound to play
   */
  public void playSound(String filename) {
    AudioInputStream sound = null;
    File f = new File(filename).getAbsoluteFile();

    try {
      sound = AudioSystem.getAudioInputStream(f);
    } catch (Exception e) {
      System.out.println("Problem loading sound " + filename);
    }

    if (sound != null) {
      try {
        Clip clip = AudioSystem.getClip();
        clip.open(sound);
        clip.start();
      } catch (Exception e) {
        System.out.println("Problem playing sound " + filename);
      }
    }
  }

  /* ---------------------- */
  /* Main */
  /* ---------------------- */

  /**
   * Starts the Spampede game. WARNING: Make sure to close the last game before
   * running a new one!
   * 
   * @param args unused command-line arguments
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new SpampedeController();
      }
    });
  }
}
