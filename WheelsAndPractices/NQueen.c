#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int count = 0;

void PrintSolution(int *board, int n){
    printf("One Possible Solution %d:\n", count);
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(board[i] == j) printf("Q ");
            else printf("- ");
        }
        printf("\n");
    }
    printf("\n");
}

int IsSafe(int *board, int row, int col, int n){        //col即假设放置的列
    // 检查列冲突
    for (int i = 0; i < row; i++) {
        if (board[i] == col) return 0;
        
        // 检查对角线
        if (abs(board[i] - col) == abs(i - row)) return 0;
    }
    
    return 1;
}

void SolveNQueensUtil(int *board, int row, int n){      //row 表示当前处理的行
    if(row == n){
        count++;
        PrintSolution(board, n);
        return;
    }

    for(int col = 0; col < n; col++){
        if(IsSafe(board, row, col, n)){
            board[row] = col;
            SolveNQueensUtil(board, row+1, n);
        }
    }
}

void SolveQueens(int n){
    int *board = (int*)malloc(n * sizeof(int));
    memset(board, -1, n * sizeof(int));
    SolveNQueensUtil(board, 0, n);
    free(board);
}

int main(){
    int n;
    n = 15;
    SolveQueens(n);
    printf("Total Solutions:%d\n", count);
    return 0;
}