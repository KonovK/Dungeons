package dungeons;

public class Dungeon {

    private Room[][] matrix;

    public Dungeon(int str, int column) {
        this.matrix = new Room[str][column];
        int length = matrix.length;
        int length1 = matrix[0].length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length1; j++) {
                matrix[i][j] = new Room();
            }
        }
    }
}
