public class Game {

  private Grid grid;
  private int userRow;
  private int userCol;

  private int msElapsed;
  private int timesGet;
  private int timesAvoid;
  private String userPic = "naruto.jpg";
  private int health = 1;
  
  public Game() {

    grid = new Grid(5, 10, "game-forest-background-5.jpg");
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
        moveRocks();
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
    if(key == 38){
        //check case where out of bounds
        
         if(grid.getNumRows() < 0){
          System.out.println("Can't jump");
        }
        
        //change the field for userrow

        Location oldLoc = new Location(userRow, userCol);
        grid.setImage(oldLoc, null);

        userRow--;

        //shift the user picture up in the array
        Location loc = new Location(userRow, userCol);
        grid.setImage(loc, "naruto.jpg");
  
    }
 
    //if I push down arrow, then plane goes down
        if(key == 40){
          userRow++;
        }
      
  
        if(key == 37){
          if(userCol > 0){
            userCol--;
          }
          else{
            userCol += 0;
          }
        }
     


  }

  
  
  public void populateRightEdge(){
    
    for(int i = 0; i < grid.getNumRows(); i++){ 

      Location a = new Location(i, grid.getNumCols()-1);

      double usenUM = Math.random();
      if(usenUM <= 0.4){
        grid.setImage(a, "rock.png");




    }
  }


  }
  
  public void moveRocks(){

 
 
 
  }
  
  public void handleCollision(Location loc) {
    //if(grid.getImage(loc)==null);
      

    
  }
  // if( grid.getImage(loc)==)
  
    
  
  
  public int getScore() {
 return -1;
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