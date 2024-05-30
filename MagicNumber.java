/*
* This is the magic squares program.
*
* @author  Andi Cucka
* @version 1.0
* @since   2020-05-06
*/

final class MagicNumber {
    private MagicNumber() {
        // Prevent instantiation
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    /** The middle left index. */
    public static final int INDEX_3 = 3;
    /** The center index. */
    public static final int INDEX_4 = 4;
    /** The middle right index. */
    public static final int INDEX_5 = 5;
    /** The lower left index. */
    public static final int INDEX_6 = 6;
    /** The lower center index. */
    public static final int INDEX_7 = 7;
    /** The lower right index. */
    public static final int INDEX_8 = 8;
    /** The maximum number for magicNumbers. */
    public static final int INDEX_9 = 9;
    /** The magic number sum for rows, columns, and diagonals. */
    public static final int MAGIC_SUM = 15;

    private static int processCount = 0;
    private static int magicSquareCount = 0;

    public static void generateSquare(final int[] square, final int[] usedNumbers, final int position) {
        for (int i = 0; i < square.length; i++) {
            processCount++;
            if (usedNumbers[i] == 0) {
                square[position] = i + 1;
                usedNumbers[i] = 1;

                if (position < square.length - 1) {
                    generateSquare(square, usedNumbers, position + 1);
                } else if (isMagicSquare(square)) {
                    displayMagicSquare(square);
                    magicSquareCount++;
                }
                usedNumbers[i] = 0;
            }
        }
    }

    public static boolean isMagicSquare(final int[] square) {
        int rowSum1 = square[0] + square[1] + square[2];
        int rowSum2 = square[INDEX_3] + square[INDEX_4] + square[INDEX_5];
        int rowSum3 = square[INDEX_6] + square[INDEX_7] + square[INDEX_8];
        int colSum1 = square[0] + square[INDEX_3] + square[INDEX_6];
        int colSum2 = square[1] + square[INDEX_4] + square[INDEX_7];
        int colSum3 = square[2] + square[INDEX_5] + square[INDEX_8];
        int diagSum1 = square[0] + square[INDEX_4] + square[INDEX_8];
        int diagSum2 = square[2] + square[INDEX_4] + square[INDEX_6];

        return rowSum1 == MAGIC_SUM && rowSum2 == MAGIC_SUM && rowSum3 == MAGIC_SUM
                && colSum1 == MAGIC_SUM && colSum2 == MAGIC_SUM
                && colSum3 == MAGIC_SUM && diagSum1 == MAGIC_SUM && diagSum2 == MAGIC_SUM;
    }

    public static void displayMagicSquare(final int[] square) {
        System.out.println("\n*****");
        for (int i = 0; i < square.length; i++) {
            if (i == INDEX_3 || i == INDEX_6) {
                System.out.println();
            }
            System.out.print(square[i] + " ");
        }
        System.out.println("\n*****");
    }

    public static void main(final String[] args) {
        int[] initialSquare = {1, 2, INDEX_3, INDEX_4, INDEX_5, INDEX_6, INDEX_7, INDEX_8, INDEX_9};
        int[] helperArray = new int[9];
        System.out.println("\nAll Possible Magic Squares (3x3):\n");
        generateSquare(initialSquare, helperArray, 0);
    }
}
