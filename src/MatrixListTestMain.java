// import java.util.concurrent.Callable;

 public class MatrixListTestMain {
//     static void assertEquals(Object a, Object b) throws Exception {
//         if (!a.equals(b)) {
//             throw new Exception("Expected " + a.toString() + ", got " + b.toString());
//         }
//     }

//     static void assertMatrixListEquals(int[][] arr, MatrixList mat) throws Exception {
//         for (int i = 0; i < arr.length; i++) {
//             for (int j = 0; j < arr[i].length; j++) {
//                 assertEquals(arr[i][j], mat.getData_i_j(i, j));
//             }
//         }

//     }

//     static Void testConstructorAndData() throws Exception {
//         System.out.println("Test case 1...");
//         int[][] arr = new int[][]{
//                 {1, 2, 3, 4},
//                 {5, 6, 7, 8},
//                 {9, 10, 11, 12}
//         };
//         MatrixList mat = new MatrixList(arr);
//         assertMatrixListEquals(arr, mat);
//         assertEquals(Integer.MIN_VALUE, mat.getData_i_j(-1, 0));
//         assertEquals(Integer.MIN_VALUE, mat.getData_i_j(0, -1));
//         assertEquals(Integer.MIN_VALUE, mat.getData_i_j(4, 0));
//         assertEquals(Integer.MIN_VALUE, mat.getData_i_j(0, 4));
//         assertEquals(Integer.MIN_VALUE, mat.getData_i_j(4, 4));

//         System.out.println("Test case 2...");
//         arr = new int[][]{
//                 {1}
//         };
//         assertMatrixListEquals(arr, new MatrixList(arr));

//         System.out.println("Test case 3...");
//         arr = new int[][]{
//                 {1, 2, 3, 4}
//         };
//         assertMatrixListEquals(arr, new MatrixList(arr));

//         System.out.println("Test case 4...");
//         arr = new int[][]{
//                 {1},
//                 {2},
//                 {3},
//                 {4},
//         };
//         assertMatrixListEquals(arr, new MatrixList(arr));

//         System.out.println("Test case 5...");
//         arr = new int[][]{
//         };
//         assertMatrixListEquals(arr, new MatrixList(arr));

//         return null;
//     }

//     static Void testToString() throws Exception {
//         System.out.println("Test case 1...");
//         int[][] arr = new int[][]{
//                 {1, 2, 3, 4},
//                 {5, 6, 7, 8},
//                 {9, 10, 11, 12}
//         };
//         assertEquals("1\t2\t3\t4\n5\t6\t7\t8\n9\t10\t11\t12\n", new MatrixList(arr).toString());

//         System.out.println("Test case 2...");
//         arr = new int[][]{
//                 {1}
//         };
//         assertEquals("1\n", new MatrixList(arr).toString());

//         System.out.println("Test case 3...");
//         arr = new int[][]{
//                 {1, 2, 3, 4}
//         };
//         assertEquals("1\t2\t3\t4\n", new MatrixList(arr).toString());

//         System.out.println("Test case 4...");
//         arr = new int[][]{
//                 {1},
//                 {2},
//                 {3},
//                 {4},
//         };
//         assertEquals("1\n2\n3\n4\n", new MatrixList(arr).toString());

//         System.out.println("Test case 5...");
//         arr = new int[][]{
//         };
//         assertEquals("", new MatrixList(arr).toString());

//         return null;
//     }

//     static Void testSetData() throws Exception {
//         int[][] arr = new int[][]{
//                 {1, 2, 3, 4},
//                 {5, 6, 7, 8},
//                 {9, 10, 11, 12}
//         };
//         MatrixList mat = new MatrixList(arr);

//         System.out.println("Test case 1...");
//         mat.setData_i_j(19, 2, 2);
//         assertMatrixListEquals(new int[][]{
//                 {1, 2, 3, 4},
//                 {5, 6, 7, 8},
//                 {9, 10, 19, 12}
//         }, mat);

//         System.out.println("Test case 2...");
//         mat.setData_i_j(22, -1, -1);
//         assertMatrixListEquals(new int[][]{
//                 {1, 2, 3, 4},
//                 {5, 6, 7, 8},
//                 {9, 10, 19, 12}
//         }, mat);

//         System.out.println("Test case 3...");
//         mat.setData_i_j(123, 0, 0);
//         assertMatrixListEquals(new int[][]{
//                 {123, 2, 3, 4},
//                 {5, 6, 7, 8},
//                 {9, 10, 19, 12}
//         }, mat);

//         System.out.println("Test case 4...");
//         mat.setData_i_j(22, 4, 2);
//         assertMatrixListEquals(new int[][]{
//                 {123, 2, 3, 4},
//                 {5, 6, 7, 8},
//                 {9, 10, 19, 12}
//         }, mat);

//         return null;
//     }

//     static Void testFindMax() throws Exception {
//         System.out.println("Test case 1...");
//         int[][] arr = new int[][]{
//                 {1, 2, 3, 4},
//                 {5, 6, 7, 8},
//                 {9, 10, 11, 12}
//         };
//         assertEquals(12, new MatrixList(arr).findMax());

//         System.out.println("Test case 2...");
//         arr = new int[][]{
//                 {1},
//                 {5},
//                 {9},
//         };
//         assertEquals(9, new MatrixList(arr).findMax());

//         return null;
//     }

//     static Void testHowManyX() throws Exception {
//         System.out.println("Test case 1...");
//         int[][] arr = new int[][]{
//                 {1, 2, 3, 4},
//                 {5, 6, 7, 8},
//                 {9, 10, 11, 12}
//         };
//         assertEquals(1, new MatrixList(arr).howManyX(7));

//         System.out.println("Test case 2...");
//         arr = new int[][]{
//                 {1, 2, 3, 4},
//                 {5, 6, 7, 8},
//                 {9, 10, 11, 12}
//         };
//         assertEquals(0, new MatrixList(arr).howManyX(13));

//         System.out.println("Test case 3...");
//         arr = new int[][]{
//                 {1, 4, 5, 6},
//                 {4, 6, 7, 8},
//                 {9, 10, 11, 12}
//         };
//         assertEquals(2, new MatrixList(arr).howManyX(4));

//         System.out.println("Test case 4...");
//         arr = new int[][]{
//                 {1, 4, 5, 7},
//                 {4, 6, 7, 8},
//                 {6, 7, 11, 12},
//                 {7, 8, 12, 13}
//         };
//         assertEquals(4, new MatrixList(arr).howManyX(7));

//         return null;
//     }

//     static void runTest(String title, Callable<Void> func) {
//         System.out.println(title);
//         try {
//             func.call();
//             System.out.println(" ✓  Success!");
//         } catch (Exception e) {
//             System.out.println("!!! FAILED: " + e.getMessage());
//         }
//         System.out.println();
//     }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7, 9},
            {2, 4, 6, 8, 10},
            {3, 5, 7, 9, 11},
            {4, 6, 8, 10, 12},
            {5, 7, 9, 11, 13},
            {6, 8, 10, 12, 14},
            {7, 9, 11, 13, 15},
            {8, 10, 12, 14, 16},
            {9, 11, 13, 15, 17},
            {10, 12, 14, 16, 18}
        };

            MatrixList matrixList = new MatrixList(matrix);
            System.out.println(matrixList.howManyX(10));
        // runTest("(Question 1 & 2) Constructor and getData", MatrixListTestMain::testConstructorAndData);
        // runTest("(Question 2) toString", MatrixListTestMain::testToString);
        // runTest("(Question 2) setData", MatrixListTestMain::testSetData);
        // runTest("(Question 3) findMax", MatrixListTestMain::testFindMax);
        // runTest("(Question 4) howManyX", MatrixListTestMain::testHowManyX);
    }
}
