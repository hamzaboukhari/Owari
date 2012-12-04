
  public class Game {
    
    private final Player[] players;
    private final Bowl[] board;
    private int playerTurn = 1;
  
    public Game() {
      this.players = new Player[] {
        new Player(),
        new Player()
      };

      this.board = new Bowl[] {
        new Bowl(4),
        new Bowl(4),
        new Bowl(4),
        new Bowl(4),
        new Bowl(4),
        new Bowl(4),
        new Bowl(4),
        new Bowl(4),
        new Bowl(4),
        new Bowl(4),
        new Bowl(4),
        new Bowl(4)
      };   
    }
   
    public int getCurrentPlayer() {
      return playerTurn;
    }

    public void swapPlayers() {
      playerTurn = 2/playerTurn;
    }  

    public boolean isValidMove(int bowl) {
      if(bowl > (playerTurn - 1) * 6 && bowl <= playerTurn * 6) {
        return (board[bowl - 1].getStones() > 0);
      }
      return false;
    }

    public boolean canCurrentPlayerMove() {
      boolean existsValidMove = false;
      for(int i = 1 ; i <= 12 ; i++) {
        existsValidMove = isValidMove(i) || existsValidMove;
      }
      return existsValidMove;
    }
    
    public void move(int bowl) {
      int stonesTaken = board[bowl - 1].takeAllStones();
      for(int i = bowl ; i < (bowl + stonesTaken) ; i++) {
        if (i >= 12) {
          int j = 12;
          if(board[i - j].getStones() == 1) {
            players[playerTurn - 1].addToScore(board[i - j].takeAllStones() + 1);
          } else {
            board[i - j].depositStone();
          }
          board[i - j].updateAndGetScore();
        } else {
            if(board[i].getStones() == 1) {
              players[playerTurn - 1].addToScore(board[i].takeAllStones() + 1);
            } else {
              board[i].depositStone();
            }
          board[i].updateAndGetScore();
          }
      }  
      
    }

    public int getLeadingPlayer() {
      if(players[0].getScore() > players[1].getScore()) {
        return 1;
      } else if(players[0].getScore()< players[1].getScore()) {
        return 2;
      } else {
        return 0;
      }
    }

    public boolean isOver() {
      return players[0].getScore() >= 24 || players[1].getScore() >= 24;
    }

    public void display() {

      String topBowls = "";
      String bottomBowls = "";

      for(int i = 11 ; i >= 6 ; i--) {
        topBowls += "( " + board[i].getStones() + " ) ";
      }

      for(int i = 0 ; i <= 5 ; i++) {
        bottomBowls += "( " + board[i].getStones() + " ) ";
      }

      System.out.println("Player 2: " + players[1].getScore());
      System.out.println("");
      System.out.println("  12    11    10    9     8     7");
      System.out.println(topBowls);
      System.out.println("");
      System.out.println(bottomBowls);
      System.out.println("  1     2     3     4     5     6");
      System.out.println("");
      System.out.println("Player 1: " + players[0].getScore());
      System.out.println("");
       
    }








  }
