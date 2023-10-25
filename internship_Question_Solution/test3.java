import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m, n;
        System.out.print("Dimensions of matrix: ");
        m = scanner.nextInt();
        n = scanner.nextInt();

        int[][] vect = new int[m][n];

        System.out.println("Enter elements of the matrix:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vect[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Entered matrix is:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(vect[i][j] + " ");
            }
            System.out.println(); // Print a new line after each row
        }

        int moves = 0;
        for (int i = 0; i < m; i++) {
            int x = 0;
            int currentMoves = findMoves(vect, i, x);
            moves = Math.max(moves, currentMoves);
        }

        System.out.println("Valid moves are: " + moves);
        scanner.close();
    }

    public static int findMoves(int[][] vect, int a, int b) {
        int moves = 0;
        int m = vect.length;
        int n = vect[0].length;

        if (a < 0 || a >= m || b < 0 || b >= n) {
            return 0; // Out of bounds, terminate recursion
        }

        if (b + 1 < n) {
            if (a > 0 && vect[a - 1][b + 1] > vect[a][b]) {
                moves = Math.max(moves, 1 + findMoves(vect, a - 1, b + 1));
            }
            if (vect[a][b + 1] > vect[a][b]) {
                moves = Math.max(moves, 1 + findMoves(vect, a, b + 1));
            }
            if (a + 1 < m && vect[a + 1][b + 1] > vect[a][b]) {
                moves = Math.max(moves, 1 + findMoves(vect, a + 1, b + 1));
            }
        }

        return moves;
    }
}