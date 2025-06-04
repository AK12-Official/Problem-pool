package main

import (
	"fmt"
	"math"
)

const INF = math.MaxInt32

func dijkstra(graph [][]int, start int) {
	n := len(graph)
	dist := make([]int, n)
	visited := make([]bool, n)

	for i := range dist {
		dist[i] = INF
	}
	dist[start] = 0

	for i := 0; i < n-1; i++ {
		u := minDistance(dist, visited)
		visited[u] = true

		for v := 0; v < n; v++ {
			if !visited[v] && graph[u][v] != 0 && dist[u] != INF && dist[u]+graph[u][v] < dist[v] {
				dist[v] = dist[u] + graph[u][v]
			}
		}
	}
	printsolutions(dist, n)
}

func minDistance(dist []int, visited []bool) int {
	min := INF
	minIndex := -1

	for v := 0; v < len(dist); v++ {
		if !visited[v] && dist[v] <= min {
			min = dist[v]
			minIndex = v
		}
	}

	return minIndex
}

func printsolutions(dist []int, n int) {
	fmt.Println("Vertex Distance from Source")
	for i := 0; i < n; i++ {
		if dist[i] == INF {
			fmt.Printf("%d \t\t %s\n", i, "INF")
		} else {
			fmt.Printf("%d \t\t %d\n", i, dist[i])
		}
	}
}

func main() {
	graph := [][]int{
		{0, 4, 0, 0, 0, 0, 0, 8, 0},
		{4, 0, 8, 0, 0, 0, 0, 11, 0},
		{0, 8, 0, 7, 0, 4, 0, 0, 2},
		{0, 0, 7, 0, 9, 14, 0, 0, 0},
		{0, 0, 0, 9, 0, 10, 0, 0, 0},
		{0, 0, 4, 14, 10, 0, 2, 0, 0},
		{0, 0, 0, 0, 0, 2, 0, 1, 6},
		{8, 11, 0, 0, 0, 0, 1, 0, 7},
		{0, 0, 2, 0, 0, 0, 6, 7, 0},
	}

	dijkstra(graph, 0)
}
