/* Game Class Starter File
 * Last Edit: 5/6/2021
 * Author: _____________________
 */

public class Game {

  private Grid grid;
  private int userRow;
  private int userCol;
  private int totalTimeLeft;
  private int msElapsed;
  private int timesGet;
  private int timesAvoid;
  private String userPic = "images/character2.gif";
  private String bgPic = "images/room.jpg";
  
  public Game() {

    grid = new Grid(5, 8);
    userRow = 3;
    userCol = 6;
    totalTimeLeft = 15;
    msElapsed = 0;
    timesGet = 0;
    timesAvoid = 0;
    updateTitle();
    grid.setBackground(bgPic);
    grid.setImage(new Location(userRow, userCol), userPic);

    WavPlayer.play("sounds/SB18.wav");
  }
  
  public void play() {

    while (!isGameOver()) {
      grid.pause(100);
      handleKeyPress();

      action();

      if (msElapsed % 300 == 0) {
        scrollLeft();
        populateRightEdge();
      }
      updateTitle();
      msElapsed += 100;
    }
  }
  
  public void handleKeyPress(){

    //check last key pressed
    int key = grid.checkLastKeyPressed();
    if(key != -1){
      System.out.println(key);
      System.out.println(new Location(userRow,userCol));
    }

    //set "w" key to move the plane up
    if(key == 87 && userRow != 0){
        //check case where out of bounds
        if (userRow != grid.getNumRows()-1){
          
        }
        //change the field for userrow

        userRow--;

        //shift the user picture up in the array
        Location loc = new Location(userRow, userCol);
        grid.setImage(loc, userPic);
        
        Location oldLoc = new Location(userRow+1, userCol);
        grid.setImage(oldLoc, null);

  }
    //if I push "s", then plane goes down
      if(key == 83   && userRow != 0){
        if (userRow != grid.getNumRows()-1){
          
        }
        //change the field for userrow

        userRow++;


        //shift the user picture up in the array
        Location loc = new Location(userRow, userCol);
        grid.setImage(loc, userPic);
        
        Location oldLoc = new Location(userRow-1, userCol);
        grid.setImage(oldLoc, null);
  }
//
//if I push "d", then plane goes down
if(key == 68   && userRow != 0){
  if (userCol != grid.getNumCols()-1){
          
  }
  //change the field for usercol

  userCol++;


  //shift the user picture up in the array
  Location loc = new Location(userRow, userCol);
  grid.setImage(loc, userPic);
  
  Location oldLoc = new Location(userRow, userCol-1);
  grid.setImage(oldLoc, null);
}

if(key == 65   && userRow != 0){
  if (userCol != grid.getNumCols()-1){
          
  }
  //change the field for usercol

  userCol--;


  //shift the user picture up in the array
  Location loc = new Location(userRow, userCol);
  grid.setImage(loc, userPic);
  
  Location oldLoc = new Location(userRow, userCol+1);
  grid.setImage(oldLoc, null);
}

  }

  public void action(){
    if(userRow == 3 && userCol == 6){
      //System.out.println("strange room");
      grid.showMessageDialog("You find yourself in a strange room...");
      userRow--;
      
      //shift the user picture up in the array
      Location loc = new Location(userRow, userCol);
      grid.setImage(loc, userPic);
  grid.setImage(new Location(3,6), null);
      // Location oldLoc = new Location(userRow, userCol+1);
      // grid.setImage(oldLoc, null);
    }

    if(userRow == 3 && userCol == 5){
      totalTimeLeft--;
      grid.showMessageDialog("You find a note. It says, \"You have 15 minutes to find the key.\"");

    }

  }
  
  public void populateRightEdge(){

  }
  
  public void scrollLeft(){

  }
  
  public void handleCollision(Location loc) {

  }
  
  public int getTimeLeft() {
    return this.totalTimeLeft;
  }
  
  public void updateTitle() {
    grid.setTitle("Time Left:  " + getTimeLeft());
  }
  
  public boolean isGameOver() {
    return false;
  }
    

}