public class GameOfLife {
    private int[][] evolvedCluster;
    private int[][] paddedCluster;
    private int[][] initialCluster;

    public GameOfLife(int[][] initialCluster) {
        this.initialCluster = initialCluster;
    }

    public int[][] evolvePattern() {
        evolvedCluster = new int[initialCluster.length][initialCluster.length];
        pad(initialCluster);

        for (int i = 1; i < paddedCluster.length - 1; i++)
            for (int j = 1; j < paddedCluster[i].length - 1; j++) {
                this.evolve(i, j);
            }

        return evolvedCluster;
    }

    private void evolve(int x, int y) {        //evolve   //current x=1 y=1
        int totalAlive = 0, totalDead = 0;

        for (int i = x - 1; i <= x - 1 + 2; i++) { // TODO - too many magic numbers
            for (int j = y - 1; j <= y - 1 + 2; j++) {
                if (i == x && j == y) {
                    continue;
                }
                if (paddedCluster[i][j] == 1) {
                    ++totalAlive;
                } else
                    ++totalDead;
            }
        }
        if (paddedCluster[x][y] == 0 && totalAlive == 3) {
            evolvedCluster[x - 1][y - 1] = 1;
        }
        if (totalAlive == 2 || totalAlive == 3) {
            evolvedCluster[x - 1][y - 1] = 1;
        } else evolvedCluster[x - 1][y - 1] = 0;
    }


    private void pad(int[][] cluster) {
        paddedCluster = new int[initialCluster.length + 2][initialCluster.length + 2];

        for (int row = 1; row < paddedCluster.length - 1; row++) {
            for (int column = 1; column < paddedCluster[row].length - 1; column++) {
                paddedCluster[row][column] = cluster[row - 1][column - 1];
            }
        }
    }
}
