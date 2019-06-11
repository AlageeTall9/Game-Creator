public class Game {

  private Grid grid;
  private int userRow;
  private int userCol;

  private int msElapsed;
  private int timesGet;
  private int timesAvoid;
  private String userPic = "user.gif";
  private int health = 1;
  
  public Game() {

    grid = new Grid(3, 5, "user.gif");
    userRow = 4;
    userCol = (int) (Math.random()*5 + 1);
    msElapsed = 0;
    timesGet = 0;
    timesAvoid = 0;
    updateTitle();
    grid.setImage(new Location(userRow, userCol), userPic);
  }
  
  public void play() {

    while (!isGameOver()) {
      grid.pause(100);
      handleKeyPress();
      if (msElapsed % 200 == 0) {
        scrollLeft();
        populateRightEdge();
      }
      if(msElapsed %  200 == 0) {
        
      }
      updateTitle();
      msElapsed += 100;
    }
  }

  public void handleKeyPress(){

    //check last key pressed
    int key = grid.checkLastKeyPressed();
    System.out.println(key);

    //set "w" key to move the jummup
    if(key == 18){
        //check case where out of bounds
        
         if(grid.getRow() < 0){
          System.out.println("Can't jump");
        }
        
        //change the field for userrow

        Location oldLoc = new Location(userRow, userCol);
        grid.setImage(oldLoc, null);

        userRow--;

        //shift the user picture up in the array
        Location loc = new Location(userRow, userCol);
        grid.setImage(loc, "user.gif");
        userRow--;
    }
    //if I push down arrow, then plane goes down
        if(key == 40){

        }
        userRow++;
      }

  }
  
  public void populateRightEdge(){
    for(int i = 0; i < grid.getNumRows(); i++){ 
      Location a = new Location(userRow, 2);
      double usenUM = Math.random();
      if(usenUM <= 0.4){
        grid.setImage(a, "user.gif");
      }
      else
      {
         grid=grid;
      }



    }


  }
  
  public void scrollLeft(){
    if(key == 37){
      if(userCol >0 && userCol < numCols){
        userCol--;
      }
      else(){
        userColl += 0;
      }
    }
  }
  
  public void handleCollision(Location loc) {
    
  }
  
  public int getScore() {

 }
  
  public void updateTitle() {
    grid.setTitle("Game:  " + getScore());
  }
  
  public boolean isGameOver() {
    if(health == 0){
      return true;
    }
    else{
      return false;
    }
  }
    
  public static void main(String[] args) {
    Game game = new Game();
    game.play();   
  }
}