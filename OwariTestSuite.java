public class OwariTestSuite {

    public static void main(String[] args) {
        System.out.println("Running tests...");

        playerTests();
        bowlTests();
        gameTests();

        System.out.println("...tests complete.");
    }

    public static void playerTests() {
      testAddAndGetScore(1, 1);
      testAddAndGetScore(10, 10);
      testAddAndGetScore(5, 5);
    }

    public static void bowlTests() {
      testGetStones(1, 1);
      testGetStones(10, 10);
      testGetStones(5, 5);
      testDepositAndUpdate(1, 2, 3);
      testDepositAndUpdate(15, 5, 20);
      testDepositAndUpdate(6, 4, 10);
    }
    
    public static void gameTests() {
      testTurn(1, 2);
      testTurn(2, 1);
      testTurn(5, 2);
      testValidMove(1, 1, false);
      testValidMove(3, 12, false);
      testValidMove(1, 2, true);
    }

    private static void testAddAndGetScore(int n, int expected) {
      Player player = new Player();  
      player.addToScore(n);
      int actual = player.getScore();
      if (expected != actual) {
        System.out.println("player.getScore()" + "; expected: " +
        expected + " got: " + actual);
      }
    }

    private static void testGetStones(int n, int expected) {
      Bowl bowl = new Bowl(n);  
      int actual = bowl.getStones();
      if (expected != actual) {
        System.out.println("bowl.getStones()" + "; expected: " + expected
        + " got: " + actual);
      }
    }

    private static void testDepositAndUpdate(int n, int deposits, 
                                             int expected) {
      Bowl bowl = new Bowl(n);
      for(int i = 0 ; i < deposits ; i++) {
        bowl.depositStone();
      }
      int actual = bowl.updateAndGetScore();
      if (expected != actual) {
        System.out.println("bowl.updateAndGetScore()" + "; expected: " +
        expected + " got: " + actual);
      }
    }

    private static void testTurn(int swaps, int expected) {
      Game game = new Game();
      for(int i = 0 ; i < swaps ; i++) {
        game.swapPlayers();
      }
      int actual = game.getCurrentPlayer();
      if (expected != actual) {
        System.out.println("game.getCurrentPlayer()" + "; expected: "
        + expected + " got: " + actual);
      }
    }

    private static void testValidMove(int bowl, int checkBowl, 
                                      boolean expected) {
      Game game = new Game();
      game.move(bowl);
      boolean actual = game.isValidMove(checkBowl);
      if (expected != actual) {
        System.out.println("game.isValidMove(" + checkBowl + ")" + "; expected: "
        + expected + " got: " + actual);
      }
    }

}
