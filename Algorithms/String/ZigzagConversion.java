class Solution {
    public String convert(String s, int numRows) {
        // Initialize string builder array with number of rows
        // Iterate the string such that it will traverse in that array
        // It will have pointer of current row which will go up and down
        // the new character will be appended to the current row

        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        // array initialization
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean isGoingDown = false;

        // iterating the string character and setting it in the rows
        for (char c : s.toCharArray()) {
            // appending the char to current row
            rows[currentRow].append(c);

            if (currentRow == 0 || currentRow == numRows - 1) {
                isGoingDown = !isGoingDown;
            }

            currentRow += isGoingDown ? 1 : -1;
        }

        // Now concatenate the rows and return
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }
}