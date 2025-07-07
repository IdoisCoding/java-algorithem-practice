
/**
 * Write a description of class MatrixList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MatrixList
{
    private final int NUM_ZERO = 0;
    private final int NUM_ONE = 1;
    private final int NUM_TWO = 2;
    IntNodeMat _m00;

    public MatrixList()
    {
        _m00 = null;
    }

  /**
* Constructor that builds a linked matrix from a 2D array.
* Creates a structure where each node has links to adjacent nodes.
* For empty/null input, sets head (_m00) to null.
* For 1xN arrays, links nodes horizontally.
* For Nx1 arrays, links nodes vertically. 
* For NxM arrays, creates full grid with row/column links.
* 
* @param mat Input 2D array to convert to linked structure
*/
public MatrixList(int[][] mat) {   
   // Check for null/empty matrix cases
   // Returns early with null head if invalid input
   if(mat == null || mat.length == NUM_ZERO || mat[NUM_ZERO].length == NUM_ZERO) {
       _m00 = null;
       return;
   }

   // Initialize first node with top-left value
   _m00 = new IntNodeMat(mat[NUM_ZERO][NUM_ZERO]);
   
   // Special case: Handle single row matrix (1xN)
   // Creates chain of nodes linked horizontally
   if(mat.length == NUM_ONE && mat[NUM_ZERO].length > NUM_ONE) {
       IntNodeMat current = _m00;
       for(int j = NUM_ONE; j < mat[NUM_ZERO].length; j++) {
           IntNodeMat next = new IntNodeMat(mat[NUM_ZERO][j]);
           current.setNextCol(next);  // Link forward
           next.setPrevCol(current);  // Link backward
           current = next;  // Move to next position
       }
       return;
   }
   
   // Special case: Handle single column matrix (Nx1) 
   // Creates chain of nodes linked vertically
   if(mat[NUM_ZERO].length == NUM_ONE && mat.length > NUM_ONE) {
       IntNodeMat current = _m00;
       for(int i = NUM_ONE; i < mat.length; i++) {
           IntNodeMat next = new IntNodeMat(mat[i][NUM_ZERO]);
           current.setNextRow(next);  // Link downward
           next.setPrevRow(current);  // Link upward
           current = next;  // Move down
       }
       return;
   }

   // General case: Build first row's horizontal links
   // Links all nodes in top row from left to right
   IntNodeMat current = _m00;
   for(int j = NUM_ONE; j < mat[NUM_ZERO].length; j++) {
       IntNodeMat next = new IntNodeMat(mat[NUM_ZERO][j]);
       current.setNextCol(next);  // Link forward
       next.setPrevCol(current);  // Link backward
       current = next;  // Move right
   }

   // Build remaining rows with both horizontal and vertical links
   IntNodeMat rowStart = _m00;  // Track start of current row
   for(int i = NUM_ONE; i < mat.length; i++) {
       // Create first node of new row
       current = new IntNodeMat(mat[i][NUM_ZERO]);
       rowStart.setNextRow(current);  // Link down to new row
       current.setPrevRow(rowStart);  // Link back up
       
       // Track node above in previous row for vertical links
       IntNodeMat prevRowNode = rowStart.getNextCol();
       
       // Create and link remaining nodes in current row
       for(int j = NUM_ONE; j < mat[i].length; j++) {
           IntNodeMat next = new IntNodeMat(mat[i][j]);
           
           // Horizontal links in current row
           current.setNextCol(next);  // Link right
           next.setPrevCol(current);  // Link left
           
           // Vertical links with previous row
           prevRowNode.setNextRow(next);  // Link down
           next.setPrevRow(prevRowNode);  // Link up
           
           // Move to next position
           current = next;
           prevRowNode = prevRowNode.getNextCol();
       }
       rowStart = rowStart.getNextRow();  // Move to next row
   }
}

    /**
* Retrieves the data value at position (i,j) in the matrix.
* Traverses down i rows and right j columns from the starting node.
* 
* @param i Row index to retrieve from
* @param j Column index to retrieve from
* @return The data at position (i,j), or Integer.MIN_VALUE if position is invalid
*/
public int getData_i_j (int i, int j) {
    // Start from first node
    IntNodeMat node = _m00;
    
    // Move down i rows
    while(i != NUM_ZERO && node != null) {
        node = node.getNextRow();
        i--;
    }
    
    // Move right j columns
    while(j != NUM_ZERO && node != null) {
        node = node.getNextCol();
        j--;
    }
    
    // Return MIN_VALUE if position invalid, otherwise return data
    if(node == null) {
        return Integer.MIN_VALUE;
    }
    return node.getData();
 }

    /**
* Sets the data value at position (i,j) in the matrix.
* 
* @param data The new value to set
* @param i Row index to set at
* @param j Column index to set at
* @return Void if position is invalid
*/
public void setData_i_j (int data, int i, int j) {
   // Start from first node
   IntNodeMat node = _m00;
   
   // Move down i rows
   while(i != NUM_ZERO && node != null) {
       node = node.getNextRow();
       i--;
   }
   
   // Move right j columns 
   while(j != NUM_ZERO && node != null) {
       node = node.getNextCol();
       j--;
   }
   
   // Return if position invalid, otherwise set data
   if(node == null) {
       return;
   }
   node.setData(data);
}


    /**
* Creates a string representation of the matrix.
* Values are tab-separated within rows and rows end with newlines.
* Empty or null matrix returns empty string.
* 
* @return String containing matrix values in tabular format, with tabs between values
*         and newlines between rows
*/
public String toString() {
   // Initialize empty result string
   String str = "";
   
   // Start from first node of first row
   IntNodeMat start = _m00;
   
   // Iterate through each row of matrix
   while(start != null) {
       IntNodeMat current = start;
       
       // Process each element in current row
       while(current != null) {
           if(current.getNextCol() != null) {
               // Add tab after value if not at end of row
               str += current.getData() + "\t"; 
           } else {
               // Add newline if at end of row
               str += current.getData() + "\n";
           }
           // Move to next column
           current = current.getNextCol();
       }
       // Move to next row
       start = start.getNextRow();
   }
   return str;
}

    /**
* Finds the maximum value in the matrix using recursive traversal.
* 
* @return Maximum value in matrix, or Integer.MIN_VALUE if matrix is empty
*/
public int findMax() {
   return findMaxHelper1(_m00);
}

/**
* Helper method that recursively traverses rows to find maximum value.
* 
* @param node Current node being processed
* @return Maximum value found in current node's row and all rows below
*/
private int findMaxHelper1(IntNodeMat node) {
   if(node == null) {
       return Integer.MIN_VALUE;
   }
   // Compare max of current row with max of remaining rows
   return Math.max(findMaxHelper2(node), findMaxHelper1(node.getNextRow()));
}

/**
* Helper method that recursively traverses columns to find maximum value in row.
* 
* @param node Current node being processed 
* @return Maximum value found in current row from node onwards
*/
private int findMaxHelper2(IntNodeMat node) {
   if(node == null) {
       return Integer.MIN_VALUE;
   }
   // Compare current value with max of remaining values in row
   return Math.max(node.getData(), findMaxHelper2(node.getNextCol()));
}

    /**
* Counts occurrences of value x in a sorted matrix using optimized diagonal traversal.
* Matrix must be sorted in strictly ascending order both row-wise and column-wise.
* 
* Time Complexity: O(n+m) where n is number of rows, m is number of columns
* The algorithm moves either right, down, or diagonally in each step.
* In worst case, it traverses at most n rows and m columns once, hence O(n+m).
* This is more efficient than checking every cell which would be O(n*m).
* 
* Space Complexity: O(1) as only constant extra space is used
* Only a single pointer node and counter are needed regardless of matrix size.
* 
* @param x Value to search for
* @return Number of occurrences of x in matrix, 0 if matrix is empty
*/
    public int howManyX(int x) {   
   // Handle empty matrix case
   if(_m00 == null) {
       return NUM_ZERO;
   }

   int count = NUM_ZERO;
   IntNodeMat node = _m00;
   
   while(true) {
       // Found target value x - increment count and try moving diagonally
       if(node.getData() == x) {
           count++;
           // Check if we can move diagonally (up-right)
           if(node.getNextCol() == null || node.getPrevRow() == null) {
               break; // Can't move diagonally, end search
           }
           node = node.getPrevRow().getNextCol(); // Move diagonally for efficiency
       }
       else {
           // Check if we've reached bottom-right corner
           if(node.getNextCol() == null && node.getNextRow() == null) {
               break;
           } 
           else {
               // Try moving down if possible and value below is <= x
               if(node.getNextRow() != null && x >= node.getNextRow().getData()) {
                   node = node.getNextRow();
               }
               // Try moving right if moving down isn't possible/beneficial
               else if(node.getNextCol() != null && x >= node.getNextCol().getData()) {
                   node = node.getNextCol();
               }
               else {
                   break; // No valid moves left, remaining values will be too large
               }
           }
       }
   }
   return count;
}

}
