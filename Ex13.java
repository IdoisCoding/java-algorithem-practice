public class Ex13 {

    /**
     * * Time Complexity: O(n)
    * - The method iterates over the input array once (O(n)) to rearrange the elements.
    * - A second loop, which places the median values, also takes O(n) in the worst case.
    * - Therefore, the overall time complexity is O(n).
    * Space Complexity: O(n)
    * - A new array of the same size as the input array is created to store the rearranged elements.

     * @param arr the array to be rearranged
     * @param med the median value used for rearranging
     * @return a new array with elements rearranged based on the median
     */
    public static int[] specialArr(int[] arr, int med) {
        final int NUM_ZERO = 0; 
        final int NUM_ONE = 1;
        final int NUM_TWO = 2;
        if (arr == null || arr.length == NUM_ZERO) {
            return null;
        }
        int[] newArr = new int[arr.length];
        int k = NUM_ONE;
        int m = NUM_ZERO;
        for(int i = NUM_ZERO; i < arr.length; i++){
            if(arr[i] < med){
                newArr[k] = arr[i];
                k += NUM_TWO;
            } else{
                if(arr[i] > med){
                    newArr[m] = arr[i];
                    m += NUM_TWO;
                } 
            }
        }
        if(k < arr.length){
            newArr[k] = med;
        }
            else{
                newArr[m] = med;
            }
            return newArr;
        }
      
    /**
     * Finds the first missing positive integer in the given array.
     * Time Complexity: O(n) - Each element is moved at most once.
    * Space Complexity: O(1) - The algorithm operates in-place without using additional data structures.
     * @param arr the array to be checked
     * @return the first missing positive integer
     */
    public static int first(int[] arr) {
        final int NUM_ZERO = 0; 
        final int NUM_ONE = 1;
        if (arr == null || arr.length == NUM_ZERO) {
            return NUM_ONE; // If the array is null or empty, return 1 as the first missing positive integer
        }
        int i = 0;
        while (i < arr.length) {
            // If arr[i] is a positive integer within the range and not in its correct position, swap it
            if (arr[i] > NUM_ZERO && arr[i] <= arr.length && arr[i] != arr[arr[i] - NUM_ONE]) {
                int temp = arr[i]; // Store the current element
                arr[i] = arr[temp - NUM_ONE]; // Place the element at its correct position
                arr[temp - NUM_ONE] = temp; // Complete the swap
            } else {
                i++; // Move to the next element if no swap is needed
            }
        }
        for (i = NUM_ZERO; i < arr.length; i++) {
            // Check if the current index i contains the integer i + 1
            if (arr[i] != i + NUM_ONE) {
                return i + NUM_ONE; // Return the first missing positive integer
            }
        }
        return arr.length + NUM_ONE; // If all positions are correct, return the next positive integer
    }

    /**
 * Finds the length of the longest nearly palindromic subsequence in the given array.
 * A nearly palindromic subsequence is allowed to have at most one mismatch.
 * @param arr the input array to find the longest nearly palindromic subsequence
 * @return the length of the longest nearly palindromic subsequence
 */
    public static int longestNearlyPal(int[] arr) {
        if (arr.length == 0) 
            return 0;
         final int NUM_ZERO = 0; 
        final int NUM_ONE = 1;
    // Start the recursive helper function with initial parameters
    return longestNearlyPalHelper(arr, NUM_ZERO, arr.length - NUM_ONE, NUM_ZERO, false);
}

/**
 * Helper method for longestNearlyPal that recursively finds the length of the longest nearly palindromic subsequence.
 *
 * @param arr the input array
 * @param start the starting index of the current subsequence
 * @param end the ending index of the current subsequence
 * @param iterations the number of iterations (recursive calls) made so far
 * @param omitted whether a mismatch has been omitted in the current path
 * @return the length of the longest nearly palindromic subsequence found in the current path
 */
private static int longestNearlyPalHelper(int[] arr, int start, int end, int iterations, boolean omitted) {
    final int NUM_ZERO = 0; 
    final int NUM_ONE = 1;
    final int NUM_TWO = 2;
    int len = NUM_ZERO;
    if(start == end) {
        return NUM_ONE + (omitted == true ? NUM_ONE : NUM_ZERO);
    }
    if(start > end) {
        return NUM_ZERO + (omitted == true ? NUM_ONE : NUM_ZERO);
    }
    // Check if the current subsequence is nearly palindromic
    if(arr[start] == arr[end]) {
        len = longestNearlyPalHelper(arr, start + 1, end - 1, iterations + 1, omitted);
        if(len == -NUM_ONE && iterations >= 1){
            return len;
        }
        len += NUM_TWO;
        if(iterations >= 1) 
            return len;
    } 
    else{
        if(iterations >= 1 && omitted == false){
            omitted = true;
            len = Math.max(longestNearlyPalHelper(arr, start + 1, end, iterations + 1, true), longestNearlyPalHelper(arr, start, end - 1, iterations + 1, true));
            if(iterations >= 1)
                return len;
        }
        else{
            if(iterations >= NUM_ONE)
                return -NUM_ONE;
        }
    }
    return Math.max(len,Math.max(longestNearlyPalHelper(arr, start + 1, end, NUM_ZERO, false),longestNearlyPalHelper(arr, start, end - 1, NUM_ZERO, false)));
}

    /**
 * Finds the maximum value along the path with the minimum maximum value in a 2D matrix.
 * The path starts from the top-left corner and ends at the bottom-right corner,
 * moving only right, down, left, or up at each step.
 * @param m the 2D matrix to traverse
 * @return the maximum value along the path with the minimum maximum value
 */
public static int extreme(int[][] m) {
    final int NUM_ZERO = 0;
    // Create a boolean matrix to keep track of visited cells
    boolean[][] route = new boolean[m.length][m[NUM_ZERO].length];
    // Start the recursive helper function from the top-left corner (0,0)
    return extremeHelper(NUM_ZERO, NUM_ZERO, m, route);
}

/**
 * Helper method for extreme that recursively finds the path with the minimum maximum value.
 *
 * @param row current row in the matrix
 * @param col current column in the matrix
 * @param m the 2D matrix
 * @param route boolean matrix to keep track of visited cells
 * @return the maximum value along the current path
 */
private static int extremeHelper(int row, int col, int[][] m, boolean[][] route) {
    final int NUM_ZERO = 0;
    final int NUM_ONE = 1;

    // Base case: reached the bottom-right corner
    if (row == m.length - NUM_ONE && col == m[NUM_ZERO].length - NUM_ONE) {
        return m[row][col];
    }

    // Mark current cell as visited
    route[row][col] = true;

    // Try moving in all four directions (right, down, left, up)
    int max1 = isValidCell(row, col + NUM_ONE, m, route) ? extremeHelper(row, col + NUM_ONE, m, route) : Integer.MAX_VALUE;
    int max2 = isValidCell(row + NUM_ONE, col, m, route) ? extremeHelper(row + NUM_ONE, col, m, route) : Integer.MAX_VALUE;
    int max3 = isValidCell(row, col - NUM_ONE, m, route) ? extremeHelper(row, col - NUM_ONE, m, route) : Integer.MAX_VALUE;
    int max4 = isValidCell(row - NUM_ONE, col, m, route) ? extremeHelper(row - NUM_ONE, col, m, route) : Integer.MAX_VALUE;

    // Mark current cell as unvisited
    route[row][col] = false;

    // Find the minimum of the maximum values from all valid directions
    int min = Math.min(Math.min(max1, max2), Math.min(max3, max4));

    // Return the maximum of the current cell's value and the last cell value and the minimum of the maximum values from valid paths
    return Math.max(m[row][col], Math.max(m[m.length - 1][m[0].length - 1], min));
}

/**
 * Checks if a given cell is valid and unvisited in the matrix.
 *
 * @param row row index to check
 * @param col column index to check
 * @param m the 2D matrix
 * @param route boolean matrix of visited cells
 * @return true if the cell is valid and unvisited, false otherwise
 */
private static boolean isValidCell(int row, int col, int[][] m, boolean[][] route) {
    final int NUM_ZERO = 0;
    // Check if the cell is within matrix bounds and not visited
    return row >= NUM_ZERO && row < m.length && col >= NUM_ZERO && col < m[NUM_ZERO].length && !route[row][col];
}


    /**
     * The main method that serves as the entry point of the program.
     *
     */
    public static void main(String[] args) {
         // Test case for specialArr function
        int[] arr1 = {5, 2, 8, 4, 3, 1, 6, 7};
        int median1 = 4;
        System.out.println("Testing specialArr function:");
        System.out.println("Original array: " + java.util.Arrays.toString(arr1));
        System.out.println("Median: " + median1);
        int[] result1 = specialArr(arr1, median1);
        System.out.println("Rearranged array: " + java.util.Arrays.toString(result1));
    
        System.out.println(); // Add a blank line for readability
    
        // Test case for first function
        int[] arr2 = {3, 4, -1, 1, 2 , 3, 5, 6, 7,-3, 8};
        System.out.println("Testing first function:");
        System.out.println("Input array: " + java.util.Arrays.toString(arr2));
        int result2 = first(arr2);
        System.out.println("First missing positive integer: " + result2);

        int[] arr3 = {1,1,4,10,10,4,3,10,10};
        System.out.println("Testing longestNearlyPal function:" + longestNearlyPal(arr3));

        // Define matrix C
        int[][] C = {
            {4, 1, 9, 3, 25},
            {24, 23, 22, 21, 5},
            {13, 12, 15, 16, 14},
            {17, 11, 18, 19, 20},
            {10, 2, 8, 6, 6}
        };

        int[][] D = {
            {4, 1, 9, 3, 25},
            {24, 23, 2, 21, 5},
            {13, 12, 15, 16, 22},
            {17, 11, 18, 19, 20},
            {10, 14, 8, 7, 6}
        };
        System.out.println("Testing extreme function C: " + extreme(C));
        System.out.println("Testing extreme function D: " + extreme(D));
    }
}