import java.util.Random;

public class Lab1Task3 {
    private static int[][] getRandomMatrix(int matrixSize, int minVal, int maxVal) {
        int[][] randomMatrix = new int[matrixSize][matrixSize];
        Random random = new Random();

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                randomMatrix[i][j] = random.nextInt(minVal, maxVal);
            }
        }
        return randomMatrix;
    }

    private static int[] addElementToArr(int[] arr, int newElement) {
        int[] newArr = null;
        if (arr != null) {
            int newLength = arr.length + 1;
            newArr = new int[newLength];
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            newArr[newArr.length - 1] = newElement;
        } else {
            newArr = new int[1];
            newArr[0] = newElement;
        }
        return newArr;
    }

    public static int[] function(int[][] matrix) {
        int[] newArr = null;
        int posElementCounter = 0;
        int arrSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0) {
                    posElementCounter++;
                    arrSum += Math.abs(matrix[i][j]);
                } else if (matrix[i][j] == 0) {
                    throw new CustomArithmeticException("zero element: ["+i+"]["+j+"]" );
                }
            }
            if (posElementCounter <= 1)
                arrSum = -1;
            posElementCounter = 0;
            newArr = addElementToArr(newArr, arrSum);
        }
        return newArr;
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void test() {
        Random rnd = new Random();
        int size = rnd.nextInt(20);
        int[][] newMatrix = getRandomMatrix(size, -100, 100);
        System.out.println("Your matrix:");
        printMatrix(newMatrix);
        int[] newArr = function(newMatrix);
        System.out.println("Your generated array:");
        printArr(newArr);
    }
}