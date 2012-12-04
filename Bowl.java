
  public class Bowl {
    
    private int stones;
    private int pendingDeposits;

    public Bowl(int stones) {
      this.stones = stones;
    }

    public int getStones() {
      return stones;
    }
    
    public int takeAllStones() {
      int removedStones = 0;
      removedStones = stones;
      stones = 0;
      return removedStones;
    }

    public void depositStone() {
      pendingDeposits++;
    }

    public int updateAndGetScore() {
      stones += pendingDeposits;
      pendingDeposits = 0;
      return stones;
    }
  }
