package dungeons;

public class Dungeon {

    private int[][] matrix = new int[10][10];

    public Dungeon() {
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; i++){
                matrix[i][j] = 1;
            }
        }
    }
}
