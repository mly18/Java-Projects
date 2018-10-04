import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.event.EventHandler;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Labeled;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;

/**
 * <h1>TootAndOtto Class</h1>
 * Contins the mechanics and interactive screen for the
 * Toot and Otto game, has execution that runs the game 
 * and shows the results
 * <p>
 *
 * @author  Matthew Yoon
 * @since   2018-04-23
 */

/* Represents the TootAndOtto class, extends the application class */
public class TootAndOtto extends Application {
  /* the amount of rows on the board */
  private int rows;
 
  /* the amount of columns on the board */
  private int columns;
  
  /* the first player of the game */
  private String player = "T";
  
  /* an array of the button on the game board */
  private Button[][] buttonArray;
  
  /* the button that is clicked last on the game board */
  private Button finalDestination;
  
  /* determines if the game is done */
  private boolean endGame = false;
  
  /**
   * Create the board with amount of columns and rows according to the 
   * the command line arguments, or set as default as 6x6
   * @param primaryStage the JavaFX main window
   */
  @Override
  public void start(Stage primaryStage) {
    GridPane gridPane = new GridPane();
    if (this.getParameters().getRaw().size() == 0) {
      setBoardRows(6);
      setBoardColumns(6);
    } 
    else {
      setBoardRows(Integer.parseInt(this.getParameters().getRaw().get(0)));
      setBoardColumns(Integer.parseInt(this.getParameters().getRaw().get(1)));
    }
    buttonArray = new Button[rows][columns]; 
    // Traverses through the buttonarray to set each button to specfic settings
    for (int i = 0; i < buttonArray.length; i++) {
      for (int j = 0; j < buttonArray.length; j++) {
        buttonArray[i][j] = new Button();
        buttonArray[i][j].setPrefSize(50,50);
        buttonArray[i][j].setOnAction(new ButtonHandler());
        gridPane.add(buttonArray[i][j], j, i);
      }
    }  
    Scene scene = new Scene(gridPane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  /*
   * Returns the number of rows on the board
   * @return the number of rows on the board
   */
  public int getBoardRows() {
    return rows;
  }
  
  /*
   * Sets the number of rows on the board
   * @param rows the number of rows on the board
   */
  public void setBoardRows(int rows) {
    this.rows = rows; 
  }
  
  /*
   * Returns the number of columns on the board
   * @return the number of columns on the board
   */
  public int getBoardColumns() {
    return columns;
  }
  
  /*
   * Sets the number of columns on the board
   * @param columns the number of columns on the board
   */
  public void setBoardColumns(int columns) {
    this.columns = columns;
  }
  
  /*
   * Finds the row in which the button was clicked
   * @param the button that was clicked
   */
  public int findRow(Button b) {
    int rowSub = -1;                                                       // the row at which the button is located 
    // traverses through the rows to find the location of the button
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (b.equals(buttonArray[i][j])){
          rowSub = i;
        }
      }   
    }               
    return rowSub;
  }
  
  /*
   * Finds the column in which the button was clicked
   * @param the row that the button was found in
   * @param the button that was clicked
   */
  public int findColumn(int rowSub, Button b) {
    int columnSub = -1;                                                   // the column at which the button is located
    // traverses through the columns ot find the location of the button
    for (int z = 0; z < columns; z++) {
      if (b.equals(buttonArray[rowSub][z])) {
        columnSub = z;
      }
    }
    return columnSub;
  }
  
  /*
   * Sets the player to the location in which is the lowest 
   * row of the column that was selected.
   * @param the column that is being selected
   */
  public void placeLabel(int columnSub) {
    boolean playMade = false;                                            // condition that determines if a play was made in the column
    // traverses through the rows and columns to check if a play has been made in that column
    for(int i = rows-1; i >= 0; i--) {
      if(buttonArray[i][columnSub].getText().isEmpty() && playMade == false) {
        buttonArray[i][columnSub].setText(player);
        playMade = true;
        finalDestination = buttonArray[i][columnSub];
        if (player.equals("T"))
          player = "O";
        else 
          player = "T";
      }
    }
  }
  
  /*
   * finds the coordinates of the button that was placed 
   * after it was clicked
   * @param the button that was placed
   */
  public int[] findCoordinates(Button b) {
    int[] coordinates = new int[2];                                     // array that stores the coordinates of the button parameter
    // traverses through the rows and columns
    for (int i = 0; i < buttonArray.length; i++) {
      for (int j = 0; j < buttonArray.length; j++) {
        if (b.equals(buttonArray[i][j])) {
          coordinates[0] = i;
          coordinates[1] = j;
        }
      }
    }
    return coordinates;
  }
    
  /* checks for any vertical win results */
  public void checkVertical(Button b) {
    int[] location = findCoordinates(b);
    String wordCheck = "";                                              // empty string that will store attempts
    try {
      wordCheck = buttonArray[location[0]][location[1]].getText() + buttonArray[location[0]+1][location[1]].getText() + buttonArray[location[0]+2][location[1]].getText() + buttonArray[location[0]+3][location[1]].getText();
      if (wordCheck.equals("OTTO") || wordCheck.equals("TOOT")) {
        b.setTextFill(Color.RED);
        buttonArray[location[0]+1][location[1]].setTextFill(Color.RED);
        buttonArray[location[0]+2][location[1]].setTextFill(Color.RED);
        buttonArray[location[0]+3][location[1]].setTextFill(Color.RED);
        endGame = true;
      }
    }
    catch (ArrayIndexOutOfBoundsException e) {
      ;
    }
  }
  
  /* checks for any horizontal (right side) win results */
  public void checkHorizontalRight(Button b) {
    int[] location = findCoordinates(b);
    String wordCheck = "";                                              // empty string that will store attempts
    try {
      wordCheck = buttonArray[location[0]][location[1]].getText() + buttonArray[location[0]][location[1]+1].getText() + buttonArray[location[0]][location[1]+2].getText() + buttonArray[location[0]][location[1]+3].getText();
      if (wordCheck.equals("OTTO") || wordCheck.equals("TOOT")) {
        b.setTextFill(Color.RED);
        buttonArray[location[0]][location[1]+1].setTextFill(Color.RED);
        buttonArray[location[0]][location[1]+2].setTextFill(Color.RED);
        buttonArray[location[0]][location[1]+3].setTextFill(Color.RED);
        endGame = true;
      }
    }
    catch (ArrayIndexOutOfBoundsException e) {
      ;
    }
  }
  
  /* checks for any horizontal (left side) win results */
  public void checkHorizontalLeft(Button b) {
    int[] location = findCoordinates(b);
    String wordCheck = "";                                              // empty string that will store attempts
    try {
      wordCheck = buttonArray[location[0]][location[1]].getText() + buttonArray[location[0]][location[1]-1].getText() + buttonArray[location[0]][location[1]-2].getText() + buttonArray[location[0]][location[1]-3].getText();
      if (wordCheck.equals("OTTO") || wordCheck.equals("TOOT")) {
        b.setTextFill(Color.RED);
        buttonArray[location[0]][location[1]-1].setTextFill(Color.RED);
        buttonArray[location[0]][location[1]-2].setTextFill(Color.RED);
        buttonArray[location[0]][location[1]-3].setTextFill(Color.RED);
        endGame = true;
      }
    }
    catch (ArrayIndexOutOfBoundsException e) {
      ;
    }
  }
  
  /* checks for any horizontal (middle left side) win results */
  public void checkHorizontalMiddleLeft(Button b) {
    int[] location = findCoordinates(b);
    String wordCheck = "";                                              // empty string that will store attempts
    try {
      wordCheck = buttonArray[location[0]][location[1]+1].getText() + buttonArray[location[0]][location[1]].getText() + buttonArray[location[0]][location[1]-1].getText() + buttonArray[location[0]][location[1]-2].getText();
      if (wordCheck.equals("OTTO") || wordCheck.equals("TOOT")) {
        b.setTextFill(Color.RED);
        buttonArray[location[0]][location[1]-1].setTextFill(Color.RED);
        buttonArray[location[0]][location[1]-2].setTextFill(Color.RED);
        buttonArray[location[0]][location[1]+1].setTextFill(Color.RED);
        endGame = true;
      }
    }
    catch (ArrayIndexOutOfBoundsException e) {
      ;
    }
  }
  
  /* checks for any horizontal (middle right side) win results */
  public void checkHorizontalMiddleRight(Button b) {
    int[] location = findCoordinates(b);
    String wordCheck = "";                                              // empty string that will store attempts
    try {
      wordCheck = buttonArray[location[0]][location[1]-1].getText() + buttonArray[location[0]][location[1]].getText() + buttonArray[location[0]][location[1]+1].getText() + buttonArray[location[0]][location[1]+2].getText();
      if (wordCheck.equals("OTTO") || wordCheck.equals("TOOT")) {
        b.setTextFill(Color.RED);
        buttonArray[location[0]][location[1]-1].setTextFill(Color.RED);
        buttonArray[location[0]][location[1]+1].setTextFill(Color.RED);
        buttonArray[location[0]][location[1]+2].setTextFill(Color.RED);
        endGame = true;
      }
    }
    catch (ArrayIndexOutOfBoundsException e) {
      ;
    }
  }
  
  /* checks for any diagonal (top directional up) win results */
  public void checkVerticalTopUp(Button b) {
    int[] location = findCoordinates(b);
    String wordCheck = "";                                              // empty string that will store attempts
    try {
      wordCheck = buttonArray[location[0]][location[1]].getText() + buttonArray[location[0]-1][location[1]-1].getText() + buttonArray[location[0]-2][location[1]-2].getText() + buttonArray[location[0]-3][location[1]-3].getText();
      if (wordCheck.equals("OTTO") || wordCheck.equals("TOOT")) {
        b.setTextFill(Color.RED);
        buttonArray[location[0]-1][location[1]-1].setTextFill(Color.RED);
        buttonArray[location[0]-2][location[1]-2].setTextFill(Color.RED);
        buttonArray[location[0]-3][location[1]-3].setTextFill(Color.RED);
        endGame = true;
      }
    }
    catch (ArrayIndexOutOfBoundsException e) {
      ;
    }
  }
  
  /* checks for any diagonal (top directional down) win results */
  public void checkVerticalTopDown(Button b) {
    int[] location = findCoordinates(b);
    String wordCheck = "";                                              // empty string that will store attempts
    try {
      wordCheck = buttonArray[location[0]][location[1]].getText() + buttonArray[location[0]+1][location[1]+1].getText() + buttonArray[location[0]+2][location[1]+2].getText() + buttonArray[location[0]+3][location[1]+3].getText();
      if (wordCheck.equals("OTTO") || wordCheck.equals("TOOT")) {
        b.setTextFill(Color.RED);
        buttonArray[location[0]+1][location[1]+1].setTextFill(Color.RED);
        buttonArray[location[0]+2][location[1]+2].setTextFill(Color.RED);
        buttonArray[location[0]+3][location[1]+3].setTextFill(Color.RED);
        endGame = true;
      }
    }
    catch (ArrayIndexOutOfBoundsException e) {
      ;
    }
  }
  
  /* checks for any diagonal (bottom directional up) win results */
  public void checkVerticalBottomUp(Button b) {
    int[] location = findCoordinates(b);
    String wordCheck = "";                                              // empty string that will store attempts
    try {
      wordCheck = buttonArray[location[0]][location[1]].getText() + buttonArray[location[0]+1][location[1]-1].getText() + buttonArray[location[0]+2][location[1]-2].getText() + buttonArray[location[0]+3][location[1]-3].getText();
      if (wordCheck.equals("OTTO") || wordCheck.equals("TOOT")) {
        b.setTextFill(Color.RED);
        buttonArray[location[0]+1][location[1]-1].setTextFill(Color.RED);
        buttonArray[location[0]+2][location[1]-2].setTextFill(Color.RED);
        buttonArray[location[0]+3][location[1]-3].setTextFill(Color.RED);
        endGame = true;
      }
    }
    catch (ArrayIndexOutOfBoundsException e) {
      ;
    }
  }
  
  /* checks for any diagonal (bottom directional down) win results */
  public void checkVerticalBottomDown(Button b) {
    int[] location = findCoordinates(b);
    String wordCheck = "";                                              // empty string that will store attempts
    try {
      wordCheck = buttonArray[location[0]][location[1]].getText() + buttonArray[location[0]-1][location[1]+1].getText() + buttonArray[location[0]-2][location[1]+2].getText() + buttonArray[location[0]-3][location[1]+3].getText();
      if (wordCheck.equals("OTTO") || wordCheck.equals("TOOT")) {
        b.setTextFill(Color.RED);
        buttonArray[location[0]-1][location[1]+1].setTextFill(Color.RED);
        buttonArray[location[0]-2][location[1]+2].setTextFill(Color.RED);
        buttonArray[location[0]-3][location[1]+3].setTextFill(Color.RED);
        endGame = true;
      }
    }
    catch (ArrayIndexOutOfBoundsException e) {
      ;
    }
  }
  
  /* checks for any diagonal (left middle directional down) win results */
  public void checkVerticalLeftMiddleDown(Button b) {
    int[] location = findCoordinates(b);
    String wordCheck = "";                                              // empty string that will store attempts
    try {
      wordCheck = buttonArray[location[0]+1][location[1]-1].getText() + buttonArray[location[0]][location[1]].getText() + buttonArray[location[0]-1][location[1]+1].getText() + buttonArray[location[0]-2][location[1]+2].getText();
      if (wordCheck.equals("OTTO") || wordCheck.equals("TOOT")) {
        b.setTextFill(Color.RED);
        buttonArray[location[0]-1][location[1]+1].setTextFill(Color.RED);
        buttonArray[location[0]-2][location[1]+2].setTextFill(Color.RED);
        buttonArray[location[0]+1][location[1]-1].setTextFill(Color.RED);
        endGame = true;
      }
    }
    catch (ArrayIndexOutOfBoundsException e) {
      ;
    }
  }
  
  /* checks for any diagonal (right middle directional up) win results */
  public void checkVerticalRightMiddleUp(Button b) {
    int[] location = findCoordinates(b);
    String wordCheck = "";                                              // empty string that will store attempts
    try {
      wordCheck = buttonArray[location[0]-1][location[1]+1].getText() + buttonArray[location[0]][location[1]].getText() + buttonArray[location[0]+1][location[1]-1].getText() + buttonArray[location[0]+2][location[1]-2].getText();
      if (wordCheck.equals("OTTO") || wordCheck.equals("TOOT")) {
        b.setTextFill(Color.RED);
        buttonArray[location[0]+1][location[1]-1].setTextFill(Color.RED);
        buttonArray[location[0]+2][location[1]-2].setTextFill(Color.RED);
        buttonArray[location[0]-1][location[1]+1].setTextFill(Color.RED);
        endGame = true;
      }
    }
    catch (ArrayIndexOutOfBoundsException e) {
      ;
    }
  }
  
  /* checks for any diagonal (left middle directional up) win results */
  public void checkVerticalLeftMiddleUp(Button b) {
    int[] location = findCoordinates(b);
    String wordCheck = "";                                              // empty string that will store attempts
    try {
      wordCheck = buttonArray[location[0]+1][location[1]+1].getText() + buttonArray[location[0]][location[1]].getText() + buttonArray[location[0]-1][location[1]-1].getText() + buttonArray[location[0]-2][location[1]-2].getText();
      if (wordCheck.equals("OTTO") || wordCheck.equals("TOOT")) {
        b.setTextFill(Color.RED);
        buttonArray[location[0]-1][location[1]-1].setTextFill(Color.RED);
        buttonArray[location[0]-2][location[1]-2].setTextFill(Color.RED);
        buttonArray[location[0]+1][location[1]+1].setTextFill(Color.RED);
        endGame = true;
      }
    }
    catch (ArrayIndexOutOfBoundsException e) {
      ;
    }
  }
  
  /* checks for any diagonal (right middle directional down) win results */
  public void checkVerticalRightMiddleDown(Button b) {
    int[] location = findCoordinates(b);
    String wordCheck = "";                                              // empty string that will store attempts
    try {
      wordCheck = buttonArray[location[0]-1][location[1]-1].getText() + buttonArray[location[0]][location[1]].getText() + buttonArray[location[0]+1][location[1]+1].getText() + buttonArray[location[0]+2][location[1]+2].getText();
      if (wordCheck.equals("OTTO") || wordCheck.equals("TOOT")) {
        b.setTextFill(Color.RED);
        buttonArray[location[0]+1][location[1]+1].setTextFill(Color.RED);
        buttonArray[location[0]+2][location[1]+2].setTextFill(Color.RED);
        buttonArray[location[0]-1][location[1]-1].setTextFill(Color.RED);
        endGame = true;
      }
    }
    catch (ArrayIndexOutOfBoundsException e) {
      ;
    }
  }
  
  /* 
   * nested class called ButtonHandler that implements EventHandler to run
   * the ActionEvent
   */
  private class ButtonHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
      Button buttonHandler = (Button)e.getSource();
      int rowSet = findRow(buttonHandler);
      int columnSet = findColumn(rowSet, buttonHandler); 
      if (endGame == false)
        placeLabel(columnSet);
      checkVertical(finalDestination);
      checkHorizontalRight(finalDestination);      
      checkHorizontalLeft(finalDestination);
      checkHorizontalMiddleLeft(finalDestination);
      checkHorizontalMiddleRight(finalDestination);
      checkVerticalBottomDown(finalDestination);
      checkVerticalBottomUp(finalDestination);
      checkVerticalTopDown(finalDestination);
      checkVerticalTopUp(finalDestination);
      checkVerticalLeftMiddleDown(finalDestination);
      checkVerticalRightMiddleDown(finalDestination);
      checkVerticalLeftMiddleUp(finalDestination);
      checkVerticalRightMiddleUp(finalDestination);
    }
  }
  
  /*
   * Runs the program and starts the board game
   */
  public static void main(String[] args) {
    Application.launch(args);
  }
}