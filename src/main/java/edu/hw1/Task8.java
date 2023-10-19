package edu.hw1;

public class Task8 {

    private Task8() {
    }

    static final int FIELD_SIZE = 8;
    static final int BIG_FIELD_SIZE = 12;
    static final int LONG_STEP = 2;
    static final int SHORT_STEP = 1;

    static boolean oneKnightCheck(int[][] field, int xCrd, int yCrd) {
        return !(field[xCrd + LONG_STEP][yCrd + SHORT_STEP] == 0
            && field[xCrd + SHORT_STEP][yCrd + LONG_STEP] == 0
            && field[xCrd - LONG_STEP][yCrd - SHORT_STEP] == 0
            && field[xCrd - SHORT_STEP][yCrd - LONG_STEP] == 0
            && field[xCrd + LONG_STEP][yCrd - SHORT_STEP] == 0
            && field[xCrd + SHORT_STEP][yCrd - LONG_STEP] == 0
            && field[xCrd - LONG_STEP][yCrd + SHORT_STEP] == 0
            && field[xCrd - SHORT_STEP][yCrd + LONG_STEP] == 0);
    }   //можно, пожалуйста, какой-нибудь совет по этой задаче?
    //Это выглядит плохо, и я не могу придумать вариантов лучше

    static boolean knightBoardCapture(int[][] field) {  //task_8
        if (field.length != FIELD_SIZE || field[0].length != FIELD_SIZE) {
            return false;
        }
        int[][] fieldSimpleChk = new int[BIG_FIELD_SIZE][BIG_FIELD_SIZE];
        for (int i = 0; i < FIELD_SIZE; ++i) {
            System.arraycopy(field[i], 0, fieldSimpleChk[i + LONG_STEP], 2, FIELD_SIZE);
        }
        for (int i = LONG_STEP; i < BIG_FIELD_SIZE - LONG_STEP; ++i) {
            for (int j = LONG_STEP; j < BIG_FIELD_SIZE - LONG_STEP; ++j) {
                if (fieldSimpleChk[i][j] == 1) {
                    if (oneKnightCheck(fieldSimpleChk, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
