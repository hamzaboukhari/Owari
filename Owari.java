
public class Owari {

  public static void main(String[] args) {
  
    Game game = new Game();

    game.display();
    
    while(!game.isOver()) {
    
      System.out.println("Player " + game.getCurrentPlayer() + 
                         ", choose a bowl.");
      int response = IOUtil.readInt();
      
      while(!game.isValidMove(response)) {
        System.out.println("Invalid move, please choose another bowl.");
        response = IOUtil.readInt();
      }
        
        game.move(response);
        game.display();

        if(game.isOver()) {
          break;
        }

        if(game.getLeadingPlayer() == 0) {
          System.out.println("You are drawing.");
          System.out.println("");
          } else {
          System.out.println("Player " + game.getLeadingPlayer() + 
                             " is winning.");
          System.out.println("");
          }
        
        game.swapPlayers();
        if(!game.canCurrentPlayerMove()) {
          System.out.println("Player " + game.getCurrentPlayer() + 
                             " cannot move.");
        game.swapPlayers();
        }
        
    }
    System.out.println("Game over, Player " + game.getLeadingPlayer() + 
                       " wins!");
  }
}
