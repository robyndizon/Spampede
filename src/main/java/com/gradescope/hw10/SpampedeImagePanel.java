package com.gradescope.hw10;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

/**
 * Implements low-level graphics work.
 * 
 * DO NOT MODIFY.
 * 
 * @author HMC CS 60 Instructors
 * @version Fall 2025
 */
public class SpampedeImagePanel extends JPanel {
  /** The image that this panel draws */
  private Image image;

  /**
   * Constructs a new image panel.
   * 
   * @param image the image to use for this panel
   */
  public SpampedeImagePanel(Image image) {
    // store the image
    this.image = image;

    // calculate the dimensions of the panel
    int height = image.getHeight(null);
    int width = image.getWidth(null);
    Dimension dimensions = new java.awt.Dimension(width, height);
    super.setPreferredSize(dimensions);
  }

  /* Draws the image on the panel */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(this.image, 0, 0, this);
  }
}
