package com.gradescope.hw10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests the {@link SpampedeModel#getNextCellFromBFS()} method.
 * 
 * @author HMC CS 60 Instructors
 * @version Fall 2025
 */
public class SpampedeModelBFSCheckParentsTests {
  // Pictures of test boards at http://tinyurl.com/spampedeTestBoards

  /*
   * IMPORTANT: The tests in this file assume that you write the algorithm as
   * suggested in class, that is, the BFS runs until spam is dequeued, rather than
   * stopping as soon as it is enqueued. If you stop when spam is enqueued, most
   * or all of these tests will fail.
   */

  @Test
  public void testG1BFS() {
    SpampedeModel model = new SpampedeModel(TestGame.G1);
    model.getNextCellFromBFS();

    // not checking nextCell only checking parent content
    String parentString = model.toStringParents();
    String correctParentString = "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
        + "[null]\t[null]\t[null]\t[1, 2]\t[null]\t[null]\t\n" + "[null]\t[2, 2]\t[1, 2]\t[2, 2]\t[null]\t[null]\t\n"
        + "[null]\t[null]\t[2, 2]\t[null]\t[null]\t[null]\t\n" + "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
        + "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n";

    // Sample debugging output:
    // System.out.println("G1");
    // System.out.println("Expected:");
    // System.out.println(correctParentString);
    // System.out.println("Actual:");
    // System.out.println(model.toStringParents());

    assertEquals(correctParentString, parentString);
  }

  @Test
  public void testG2BFS() {
    SpampedeModel model = new SpampedeModel(TestGame.G2);
    model.getNextCellFromBFS();

    // not checking nextCell only checking parent content
    String parentString = model.toStringParents();
    String correctParentString = "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
        + "[null]\t[null]\t[null]\t[1, 2]\t[null]\t[null]\t\n" + "[null]\t[null]\t[1, 2]\t[null]\t[null]\t[null]\t\n"
        + "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n" + "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
        + "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n";

    // Sample debugging output:
    // System.out.println("G2");
    // System.out.println("Expected:");
    // System.out.println(correctParentString);
    // System.out.println("Actual:");
    // System.out.println(model.toStringParents());

    assertEquals(correctParentString, parentString);
  }

  @Test
  public void testG3BFS() {
    SpampedeModel model = new SpampedeModel(TestGame.G3);
    model.getNextCellFromBFS();

    // not checking nextCell only checking parent content
    String parentString = model.toStringParents();
    String correctParentString = "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
        + "[null]\t[null]\t[null]\t[1, 2]\t[1, 3]\t[null]\t\n" + "[null]\t[2, 2]\t[1, 2]\t[2, 2]\t[2, 3]\t[null]\t\n"
        + "[null]\t[3, 2]\t[2, 2]\t[3, 2]\t[null]\t[null]\t\n" + "[null]\t[null]\t[3, 2]\t[null]\t[null]\t[null]\t\n"
        + "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n";

    // Sample debugging output:
    // System.out.println("G3");
    // System.out.println("Expected:");
    // System.out.println(correctParentString);
    // System.out.println("Actual:");
    // System.out.println(model.toStringParents());

    assertEquals(correctParentString, parentString);
  }

  @Test
  public void testG4BFS() {
    SpampedeModel model = new SpampedeModel(TestGame.G4);
    model.getNextCellFromBFS();

    // not checking nextCell only checking parent content
    String parentString = model.toStringParents();
    String correctParentString = "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
        + "[null]\t[null]\t[null]\t[1, 2]\t[1, 3]\t[null]\t\n" + "[null]\t[2, 2]\t[1, 2]\t[2, 2]\t[2, 3]\t[null]\t\n"
        + "[null]\t[3, 2]\t[2, 2]\t[3, 2]\t[null]\t[null]\t\n" + "[null]\t[null]\t[3, 2]\t[null]\t[null]\t[null]\t\n"
        + "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n";

    // Sample debugging output:
    // System.out.println("G4");
    // System.out.println("Expected:");
    // System.out.println(correctParentString);
    // System.out.println("Actual:");
    // System.out.println(model.toStringParents());

    assertEquals(correctParentString, parentString);
  }

  @Test
  public void testG5BFS() {
    SpampedeModel model = new SpampedeModel(TestGame.G5);
    model.getNextCellFromBFS();

    // not checking nextCell only checking parent content
    String parentString = model.toStringParents();
    String correctParentString = "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
        + "[null]\t[null]\t[null]\t[1, 2]\t[1, 3]\t[null]\t\n" + "[null]\t[2, 2]\t[1, 2]\t[2, 2]\t[2, 3]\t[null]\t\n"
        + "[null]\t[3, 2]\t[2, 2]\t[3, 2]\t[3, 3]\t[null]\t\n" + "[null]\t[4, 2]\t[3, 2]\t[4, 2]\t[4, 3]\t[null]\t\n"
        + "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n";

    // Sample debugging output:
    // System.out.println("G5");
    // System.out.println("Expected:");
    // System.out.println(correctParentString);
    // System.out.println("Actual:");
    // System.out.println(model.toStringParents());

    assertEquals(correctParentString, parentString);
  }

  @Test
  public void testG6BFS() {
    SpampedeModel model = new SpampedeModel(TestGame.G6);
    model.getNextCellFromBFS();

    // not checking nextCell only checking parent content
    String parentString = model.toStringParents();
    String correctParentString = "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
        + "[null]\t[null]\t[null]\t[1, 2]\t[null]\t[null]\t\n" + "[null]\t[2, 2]\t[1, 2]\t[2, 2]\t[null]\t[null]\t\n"
        + "[null]\t[null]\t[2, 2]\t[null]\t[null]\t[null]\t\n" + "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
        + "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n";

    // Sample debugging output:
    // System.out.println("G6");
    // System.out.println("Expected:");
    // System.out.println(correctParentString);
    // System.out.println("Actual:");
    // System.out.println(model.toStringParents());

    assertEquals(correctParentString, parentString);
  }

  @Test
  public void testG7BFS() {
    SpampedeModel model = new SpampedeModel(TestGame.G7);
    model.getNextCellFromBFS();

    // not checking nextCell only checking parent content
    String parentString = model.toStringParents();
    String correctParentString = "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
        + "[null]\t[null]\t[null]\t[1, 2]\t[null]\t[null]\t\n" + "[null]\t[null]\t[1, 2]\t[null]\t[null]\t[null]\t\n"
        + "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n" + "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
        + "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n";

    // Sample debugging output:
    // System.out.println("G7");
    // System.out.println("Expected:");
    // System.out.println(correctParentString);
    // System.out.println("Actual:");
    // System.out.println(model.toStringParents());

    assertEquals(correctParentString, parentString);
  }

  @Test
  public void testG8BFS() {
    SpampedeModel model = new SpampedeModel(TestGame.G8);
    model.getNextCellFromBFS();

    // not checking nextCell only checking parent content
    String parentString = model.toStringParents();
    String correctParentString = "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
        + "[null]\t[null]\t[null]\t[1, 2]\t[1, 3]\t[null]\t\n" + "[null]\t[2, 2]\t[1, 2]\t[2, 2]\t[2, 3]\t[null]\t\n"
        + "[null]\t[3, 2]\t[2, 2]\t[3, 2]\t[null]\t[null]\t\n" + "[null]\t[null]\t[3, 2]\t[null]\t[null]\t[null]\t\n"
        + "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n";

    // Sample debugging output:
    // System.out.println("G8");
    // System.out.println("Expected:");
    // System.out.println(correctParentString);
    // System.out.println("Actual:");
    // System.out.println(model.toStringParents());

    assertEquals(correctParentString, parentString);
  }

  @Test
  public void testG9BFS() {
    SpampedeModel model = new SpampedeModel(TestGame.G9);
    model.getNextCellFromBFS();

    // not checking nextCell only checking parent content
    String parentString = model.toStringParents();
    String correctParentString = "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
        + "[null]\t[null]\t[null]\t[1, 2]\t[1, 3]\t[null]\t\n" + "[null]\t[2, 2]\t[1, 2]\t[2, 2]\t[2, 3]\t[null]\t\n"
        + "[null]\t[3, 2]\t[2, 2]\t[3, 2]\t[null]\t[null]\t\n" + "[null]\t[null]\t[3, 2]\t[null]\t[null]\t[null]\t\n"
        + "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n";

    // Sample debugging output:
    // System.out.println("G9");
    // System.out.println("Expected:");
    // System.out.println(correctParentString);
    // System.out.println("Actual:");
    // System.out.println(model.toStringParents());

    assertEquals(correctParentString, parentString);
  }

  @Test
  public void testG10BFS() {
    SpampedeModel model = new SpampedeModel(TestGame.G10);
    model.getNextCellFromBFS();

    // not checking nextCell only checking parent content
    String parentString = model.toStringParents();
    String correctParentString = "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
        + "[null]\t[null]\t[null]\t[1, 2]\t[1, 3]\t[null]\t\n" + "[null]\t[2, 2]\t[1, 2]\t[2, 2]\t[2, 3]\t[null]\t\n"
        + "[null]\t[3, 2]\t[2, 2]\t[3, 2]\t[3, 3]\t[null]\t\n" + "[null]\t[4, 2]\t[3, 2]\t[4, 2]\t[4, 3]\t[null]\t\n"
        + "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n";

    // Sample debugging output:
    // System.out.println("G10");
    // System.out.println("Expected:");
    // System.out.print(correctParentString);
    // System.out.println("Actual:");
    // System.out.print(model.toStringParents());

    assertEquals(correctParentString, parentString);
  }

  @Test
  public void testG11BFS() {
    SpampedeModel model = new SpampedeModel(TestGame.G11);
    model.getNextCellFromBFS();

    // not checking nextCell only checking parent content
    String parentString = model.toStringParents();
    String correctParentString = "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n"
        + "[null]\t[null]\t[null]\t[1, 2]\t[1, 3]\t[null]\t\n" + "[null]\t[2, 2]\t[1, 2]\t[2, 2]\t[2, 3]\t[null]\t\n"
        + "[null]\t[3, 2]\t[2, 2]\t[3, 2]\t[3, 3]\t[null]\t\n" + "[null]\t[4, 2]\t[3, 2]\t[4, 2]\t[4, 3]\t[null]\t\n"
        + "[null]\t[null]\t[null]\t[null]\t[null]\t[null]\t\n";

    // Sample debugging output:
    // System.out.println("G11");
    // System.out.println("Expected:");
    // System.out.println(correctParentString);
    // System.out.println("Actual:");
    // System.out.println(model.toStringParents());

    assertEquals(correctParentString, parentString);
  }
}
