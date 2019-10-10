import org.junit.Assert;
import org.junit.Test;

public class GameOfLifeTest {

    @Test
    public void givenClusterWithAllDead_whenEvolve_thenReturnClusterOFAllDead() {
        int[][] initialCluster = {{0, 0}, {0, 0}};
        GameOfLife gameOfLife = new GameOfLife(initialCluster);
        int[][] evolvedCluster = {{0, 0}, {0, 0}};

        Assert.assertArrayEquals(evolvedCluster, gameOfLife.evolvePattern());
    }

    @Test
    public void givenOneClusterWithThreeAliveAndOneDead_whenEvolve_thenReturnClusterOfAllAlive() {
        int[][] initialCluster = {{1, 1}, {1, 0}};
        GameOfLife gameOfLife = new GameOfLife(initialCluster);
        int[][] getCluster = {{1, 1}, {1, 1}};

        Assert.assertArrayEquals(getCluster, gameOfLife.evolvePattern());
    }
}
