package LeetCode.Medium;

public class PN74 {

    public static void main(String[] args) {
        PN74 solution = new PN74();
        int[][] matrix = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        };
        // int target = 3;
        // System.out.println(solution.searchMatrix(matrix, target));

        // target = 13;
        // System.out.println(solution.searchMatrix(matrix, target));

        System.out.println("Search result for target 3: " +
                solution.searchMatrix(matrix, 3) + " Expected: true");
        System.out.println("Search result for target 13: " +
                solution.searchMatrix(matrix, 13) + " Expected: false");
        System.out.println("Search result for target 60: " +
                solution.searchMatrix(matrix, 60) + " Expected: true");
        System.out.println("Search result for target 1: " +
                solution.searchMatrix(matrix, 1) + " Expected: true");
        System.out.println("Search result for target 7: " +
                solution.searchMatrix(matrix, 7) + " Expected: true");
        System.out.println("Search result for target 11: " +
                solution.searchMatrix(matrix, 11) + " Expected: true");
        System.out.println("Search result for target 5: " +
                solution.searchMatrix(matrix, 5) + " Expected: true");
        System.out.println("Search result for target 20: " +
                solution.searchMatrix(matrix, 20) + " Expected: true");
        System.out.println("Search result for target 0: " +
                solution.searchMatrix(matrix, 0) + " Expected: false");
        System.out.println("Search result for target 61: " +
                solution.searchMatrix(matrix, 61) + " Expected: false");
        System.out.println("Search result for target 89: " +
                solution.searchMatrix(matrix, 89) + " Expected: false");
        System.out.println("Search result for target -12: " +
                solution.searchMatrix(matrix, -12) + " Expected: false");
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length - 1;
        int selectedRow = -1;
        int mid = 0;

        // find the row that could contain the target
        while (l <= r) {

            mid = (int) (l + ((r - l) / 2));

            if (matrix[mid][0] <= target) {
                selectedRow = mid;
                l = mid + 1;
            } else
                r = mid - 1;
        }

        l = 0;
        r = matrix[0].length - 1;

        if (selectedRow == -1)
            return false;

        // perform binary search on the selected row
        while (l <= r) {
            mid = (int) (l + ((r - l) / 2));

            if (matrix[selectedRow][mid] == target)
                return true;
            else if (matrix[selectedRow][mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }

        return false;
    }

    public boolean searchMatrixNotClean(int[][] matrix, int target) {

        int l = 0;
        int r = matrix.length - 1;

        // System.out.println("Rows: " + matrix.length + " --- Columns: " +
        // matrix[0].length);

        int selectedRow = -1;

        while (l <= r) {

            int mid = (int) (l + ((r - l) / 2));

            // System.out.printf("l: %d --- r: %d --- mid: %d\n", l, r, mid);

            if (matrix[mid][0] <= target) {
                selectedRow = mid;
                l = mid + 1;
            } else
                r = mid - 1;
        }

        // System.out.println("Selected Row: " + selectedRow);

        l = 0;
        r = matrix[0].length - 1;

        // System.out.printf("l: %d --- r: %d\n", l, r);

        if (selectedRow == -1)
            return false;

        while (l <= r) {
            int mid = (int) (l + ((r - l) / 2));

            if (matrix[selectedRow][mid] == target)
                return true;
            else if (matrix[selectedRow][mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }

        return false;
    }

}
