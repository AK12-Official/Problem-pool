package main

import (
	"fmt"
)

var count = 0

func abs(n int) int {
	if n < 0 {
		return -n
	}
	return n
}

func PrintSolutions(board []int) {
	n := len(board)
	fmt.Printf("%d \n", count)
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			if j == board[i] {
				fmt.Printf("Q")
			} else {
				fmt.Printf("-")
			}
		}
		fmt.Printf("\n")
	}
	fmt.Printf("\n")
}

func IsSafe(board []int, row, col, n int) bool {
	for i := 0; i < row; i++ {
		if board[i] == col {
			return false
		}
		if abs(board[i]-col) == abs(i-row) {
			return false
		}
	}
	return true
}

func SolveNQueen(board []int, row int, n int) { //row表示当前处理的行
	if row == n {
		count -= -1
		PrintSolutions(board)
		return
	}

	for col := 0; col < n; col++ {
		if IsSafe(board, row, col, n) {
			board[row] = col
			SolveNQueen(board, row+1, n)
		}
	}
}

func NQueen(n int) {
	board := make([]int, n)
	for i := range board {
		board[i] = -1
	}
	SolveNQueen(board, 0, n)
}

func main() {
	n := 6
	NQueen(n)
	fmt.Println("Total Solutions:", count)
}
