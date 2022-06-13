/* Game Class Starter File
 * Last Edit: 5/6/2021
 * Author: _____________________
 */

public class Game {

  private Grid grid;
  private int userRow;
  private int userCol;
  private int key;
  private int totalTimeLeft;
  private int msElapsed;
  private int timesGet;
  private int timesAvoid;
  private String userPic = "images/character2.gif";
  private String bgPic = "images/room.jpg";
  
  public Game() {

    grid = new Grid(6, 9);
    userRow = 3;
    userCol = 6;
    totalTimeLeft = 15;
    key = 0;
    msElapsed = 0;
    timesGet = 0;
    timesAvoid = 0;
    updateTitle();
    grid.setBackground(bgPic);
    grid.setImage(new Location(userRow, userCol), userPic);

    WavPlayer.play("sounds/SB18.wav");
    grid.fullscreen();
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
    //user entrance
    if(userRow == 3 && userCol == 6){
      //System.out.println("strange room");
      grid.showMessageDialog("You find yourself in a strange room...");
      grid.showMessageDialog("There's a note. It says, \"You have 15 minutes to find the key to escape!\"");
      userRow--;
      
      //shift the user picture up in the array
      Location loc = new Location(userRow, userCol);
      grid.setImage(loc, userPic);
      grid.setImage(new Location(3,6), null);
    }

    //couch
    if(userRow == 3 && userCol == 8){
      //System.out.println("strange room");
      grid.showMessageDialog("That looks comfy... you lay on the couch and accidentally fall asleep. You lost a lot of time.");
      totalTimeLeft-=15;
      if(totalTimeLeft == 0 || totalTimeLeft < 0){
        grid.showMessageDialog("Time's Up!");
        grid.showMessageDialog("Game Over.");
      }else{
        userCol--;
      
        //shift the user picture up in the array
        Location loc = new Location(userRow, userCol);
        grid.setImage(loc, userPic);
        grid.setImage(new Location(3,8), null);
      }
    }

    //table 1
    if(userRow == 4 && userCol == 8){
      //System.out.println("strange room");
      grid.showMessageDialog("You look around the table and find something under it... It's a riddle!");
      grid.showMessageDialog("It says,\"I hold things with spines. I am a home of knowledge.\"");
      totalTimeLeft--;
      if(totalTimeLeft == 0 || totalTimeLeft < 0){
        grid.showMessageDialog("Time's Up!");
        grid.showMessageDialog("Game Over.");
      }else{
      userCol--;
      
      //shift the user picture up in the array
      Location loc = new Location(userRow, userCol);
      grid.setImage(loc, userPic);
      grid.setImage(new Location(4,8), null);
      }
    }

    //arm stand
    if(userRow == 5 && userCol == 7){
      //System.out.println("strange room");
      grid.showMessageDialog("You look inside the coat pockets... Nothing here.");
      totalTimeLeft--;
      if(totalTimeLeft == 0 || totalTimeLeft < 0){
        grid.showMessageDialog("Time's Up!");
        grid.showMessageDialog("Game Over.");
      }else{
      userRow--;
      
      //shift the user picture up in the array
      Location loc = new Location(userRow, userCol);
      grid.setImage(loc, userPic);
      grid.setImage(new Location(5,7), null);
    }
  }

    //book shelf
    if(userRow == 1 && userCol == 7){
      //System.out.println("strange room");
      grid.showMessageDialog("You look in between the books, one of them have a missing cover...");
      totalTimeLeft-=3;
      if(totalTimeLeft == 0 || totalTimeLeft < 0){
        grid.showMessageDialog("Time's Up!");
        grid.showMessageDialog("Game Over.");
      }else{
      userRow++;
      
      //shift the user picture up in the array
      Location loc = new Location(userRow, userCol);
      grid.setImage(loc, userPic);
      grid.setImage(new Location(1,7), null);
    }
  }

    //chair
    if(userRow == 5 && userCol == 5){
      //System.out.println("strange room");
      grid.showMessageDialog("That looks comfy... you relax on the couch. You lost a lot of time.");
      totalTimeLeft-=5;
      if(totalTimeLeft == 0 || totalTimeLeft < 0){
        grid.showMessageDialog("Time's Up!");
        grid.showMessageDialog("Game Over.");
      }else{
      userRow--;
      
      //shift the user picture up in the array
      Location loc = new Location(userRow, userCol);
      grid.setImage(loc, userPic);
      grid.setImage(new Location(5,5), null);
    }
  }

    //big cabinet
    if(userRow == 1 && userCol == 5){
      //System.out.println("strange room");
      grid.showMessageDialog("You look inside and find a book cover!");
      grid.showMessageDialog("The back says, \"The key is where time flys.\"");
      totalTimeLeft-=5;
      if(totalTimeLeft == 0 || totalTimeLeft < 0){
        grid.showMessageDialog("Time's Up!");
        grid.showMessageDialog("Game Over.");
      }else{
      userRow++;
      
      //shift the user picture up in the array
      Location loc = new Location(userRow, userCol);
      grid.setImage(loc, userPic);
      grid.setImage(new Location(1,5), null);
    }
  }

    //clock
    if(userRow == 2 && userCol == 4){
      //System.out.println("strange room");
      grid.showMessageDialog("You found the key!");
      totalTimeLeft-=2;
      key++;
      if(totalTimeLeft == 0 || totalTimeLeft < 0){
        grid.showMessageDialog("Time's Up!");
        grid.showMessageDialog("Game Over.");
      }else{
      userRow--;
      
      //shift the user picture up in the array
      Location loc = new Location(userRow, userCol);
      grid.setImage(loc, userPic);
      grid.setImage(new Location(2,4), null);
    }
    key++;
  }

    //table 2
    if(userRow == 5 && userCol == 1){
      //System.out.println("strange room");
      grid.showMessageDialog("You look around the table... Nothing here.");
      totalTimeLeft-=15;
      if(totalTimeLeft == 0 || totalTimeLeft < 0){
        grid.showMessageDialog("Time's Up!");
        grid.showMessageDialog("Game Over.");
      }else{
      userRow--;
      
      //shift the user picture up in the array
      Location loc = new Location(userRow, userCol);
      grid.setImage(loc, userPic);
      grid.setImage(new Location(5,1), null);
    }
  }

    //stairs (win/lose)
    if(userRow == 3 && userCol == 2){
      //System.out.println("strange room");
      if(key > 0){
        grid.showMessageDialog("You found the key!");
        grid.showMessageDialog("You win!");
      }else{
        grid.showMessageDialog("You need a key.");
        userRow--;

      //shift the user picture up in the array
      Location loc = new Location(userRow, userCol);
      grid.setImage(loc, userPic);
      grid.setImage(new Location(3,2), null);
      }
      
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