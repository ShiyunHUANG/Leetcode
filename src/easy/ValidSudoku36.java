package easy;

public class ValidSudoku36 {
    public boolean isValidSudoku(char[][] board) {
        char[][] num = new char[27][9];//former one is the index, latter one is the char.
        System.out.println(num[0][8]);
        int blockIdx = 0;
        /*0-8 rows, 9-17 columns, 18-26 blocks*/
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (board [i][j]== '.') {
                    continue;
                }
                blockIdx = getBlockIdx(i,j);
                int intVal = board[i][j] - '1';//1 base counting.
                // System.out.println(i + " " + j);
                //check if there is same char in a row.
                //here i is the same. j == value. 
                if (num[i][intVal] == 'm' || num[j+9][intVal] == 'm' || num[blockIdx + 18][intVal] == 'm') {
                    return false;
                } else {
                    num[i][intVal] = 'm';//has value, marked it.
                    num[j+9][intVal] = 'm';
                    num[blockIdx + 18][intVal] = 'm';
                    
                }
            }
        }
        return true;
    }
    private int getBlockIdx(int i, int j) {
        if (i <=2 && j <= 2) {
           return 0; 
        } else if (i <= 5 && j <= 2) {
            return 1;
        } else if (i <= 2 && j <= 5) {
            return 3;
        } else if (i <= 5 && j <= 5) {
            return 4;
        } else if (i > 5 && j <= 2) {
            return 2;
        } else if (i > 5 && j <= 5) {
            return 5;
        } else if (i <= 2 && j > 5) {
            return 6;
        } else if (i <= 5 && j > 5) {
            return 7;
        } else {
            return 8;
        }
    }
    public static void main(String[] args) {
        char arr[] = {0,1,2,'M',4,5};
//        arr[0] = 'M';
        char test = (char) (arr[0] + '0');
        int test2 = arr[0] + '0';
        int test3 = arr[0];
        int test4 = arr[3];
        System.out.println(test3);
//        System.out.println(arr[1]);
        System.out.println(test4);
    }

}
