package main

import (
	"fmt"
	"math"
)

const INF = math.MaxInt32

func Prim(graph [][]int) {
	n := len(graph)
	parent := make([]int, n)
	key := make([]int, n)
	mstSet := make([]bool, n)

	for i := range key {
		key[i] = INF
		mstSet[i] = false
		parent[i] = -1
	}

	// 选中第一个做顶点
	key[0] = 0
	parent[0] = -1

	for count := 0; count < n-1; count++ {
		u := minKey(key, mstSet)

		// 如果找不到下一个最小边，退出循环
		if u == -1 {
			break
		}

		mstSet[u] = true

		for v := 0; v < n; v++ {
			if graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v] {
				parent[v] = u
				key[v] = graph[u][v]
			}
		}
	}
	printMST(parent, graph, n)
}

func minKey(key []int, mstSet []bool) int {
	min := INF
	minIndex := -1

	for v := 0; v < len(key); v++ {
		if !mstSet[v] && key[v] < min {
			min = key[v]
			minIndex = v
		}
	}

	return minIndex
}

func printMST(parent []int, graph [][]int, n int) {
	fmt.Println("Edge \tWeight")
	for i := 1; i < n; i++ {
		fmt.Printf("%d - %d \t%d\n", parent[i], i, graph[i][parent[i]])
	}
}

func main() {
	graph := [][]int{
		{0, 2, 0, 6, 0},
		{2, 0, 3, 8, 5},
		{0, 3, 0, 0, 7},
		{6, 8, 0, 0, 9},
		{0, 5, 7, 9, 0},
	}

	Prim(graph)
}
