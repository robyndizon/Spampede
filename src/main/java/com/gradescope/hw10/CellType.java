package com.gradescope.hw10;

/**
 * The type of a board cell (wall, open, spam, head, body).
 * 
 * <p>
 * {@link CellType} is an enumeration (aka enum) rather than an class.
 * Enumerations are used when we want behavior like a class (i.e. methods), but
 * we want to define a fixed set of values that an enum can take on.
 * </p>
 * 
 * <p>
 * In the declaration of an enum, Java requires that the constants be defined
 * first, prior to any fields or methods. Each constant calls the constructor,
 * possibly with some arguments. When there are fields and methods, the list of
 * enum constants must end with a semicolon.
 * </p>
 * 
 * <p>
 * Because an enum can only take on particular values, we want to prevent people
 * from making additional objects of the type. Notice that the constructor is
 * private. We get an error if we try to make the constructor public!
 * </p>
 * 
 * <p>
 * Instead of creating this enum, we could have had {@link BoardCell} store a
 * {@link String} (e.g. "*", "X", "H", "B", or " ") to keep track of the type.
 * However, with this approach, if we accidentally set the type to be "M" or
 * some other invalid {@link String}, we would not get a compile error! But, we
 * use this enum (i.e. {@link CellType}), Java prevents us from setting the type
 * of a {@link BoardCell} to something invalid.
 * </p>
 * 
 * <p>
 * STYLE NOTE: No other class except {@link BoardCell} needs to know that
 * {@link CellType} exists. So it would be better to define this enum and set it
 * as private inside of {@link BoardCell}. But since we are introducing enums
 * for the first time, we thought that approach would be more confusing!
 * Instead, as a compromise, we decided to limit the enum so that nobody outside
 * the package can access it. When the modifiers {@code public},
 * {@code protected}, or {@code private} are not used, then the access level is
 * considered package-private by default. Unlike the {@code protected} modifier,
 * package-protected classes and enums are not accessible to subclasses!
 * </p>
 * 
 * @author HMC CS 60 Instructors
 * @version Fall 2025
 * 
 * @see <a href=
 *      "http://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html">
 *      Access Control</a>
 * 
 * @see BoardCell
 */
enum CellType {
  /** Indicates this cell is a wall (cannot be inhabited by the snake or spam). */
  WALL("*"),

  /** Indicates this cell is open (available for the snake or spam). */
  OPEN(" "),

  /** Indicates this cell contains spam. */
  SPAM("X"),

  /** Indicates this cell in inhabited by the snake's head. */
  HEAD("H"),

  /** Indicates this cell is inhabited by the snake's body. */
  BODY("B");

  /** The character used for display. */
  private final String displayChar;

  /**
   * Initializes this cell type.
   * 
   * @param displayChar the character to use for display
   */
  private CellType(String displayChar) {
    this.displayChar = displayChar;
  }

  /** {@return a {@link String} representing the {@link CellType}} */
  public String getDisplayChar() {
    return this.displayChar;
  }
}
