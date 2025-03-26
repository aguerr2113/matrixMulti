import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get matrix dimensions
        System.out.print("Enter the number of rows for Matrix A: ");
        int rowsA = scanner.nextInt();
        System.out.print("Enter the number of columns for Matrix A: ");
        int colsA = scanner.nextInt();
        
        System.out.print("Enter the number of rows for Matrix B: ");
        int rowsB = scanner.nextInt();
        System.out.print("Enter the number of columns for Matrix B: ");
        int colsB = scanner.nextInt();

        // Validate matrix multiplication condition
        if (colsA != rowsB) {
            System.out.println("Matrix multiplication is not possible! Columns of A must equal rows of B.");
            return;
        }

        // Create and populate matrices
        int[][] matrixA = getMatrix(scanner, rowsA, colsA, "A");
        int[][] matrixB = getMatrix(scanner, rowsB, colsB, "B");

        // Multiply matrices
        int[][] result = multiplyMatrices(matrixA, matrixB);

        // Print result
        printMatrix(result);

        scanner.close();
    }

    public static int[][] getMatrix(Scanner scanner, int rows, int cols, String name) {
        System.out.println("Enter elements of Matrix " + name + ":");
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return result;
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println("Resulting Matrix:");
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}




// Steps to Complete the Project
//  Step 1: Accept User Input for Matrices
    //  Task 1.1: Create a function to ask for matrix dimensions.(do I create another function under the main function? if so tell me,  create a object to capture user input(as one task command),  )
    //  Task 1.2: Ensure the number of columns in Matrix A equals the rows in Matrix B (otherwise, print an error and exit).(should I use a while loop or for loop or IF else statements? if so say something like"using a while loop check if the first and last characters are the same etc")
    //  Task 1.3: Create a function to populate matrices using user input.
//  Step 2: Multiply the Matrices Using Nested Loops
    //  Task 2.1: Create a function that takes two matrices as parameters and returns a new matrix containing the result.
    //  Task 2.2: Use three nested loops to perform matrix multiplication.
//  Step 3: Display the Resulting Matrix
    //  Task 3.1: Create a function to print the result matrix in a readable format.
//  Step 4: Handle Edge Cases (Bonus)
    //  Task 4.1: If the user enters an invalid matrix size (like 0x3), prompt them again.
    //  Task 4.2: If the user enters a non-integer value, catch the exception.
    //  Task 4.3: Optimize for large matrices using efficient memory management.