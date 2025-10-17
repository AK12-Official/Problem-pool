package temp

func validateStackSequences(pushed []int, popped []int) bool {
	n := len(popped)
	stack := make([]int, 0, n)

	popIndex := 0
	for _, v := range pushed {
		for len(stack) > 0 && stack[len(stack)-1] == popped[popIndex] {
			stack = stack[:len(stack)-1]
			popIndex++
		}

		if v == popped[popIndex] {
			popIndex++
		} else {
			stack = append(stack, v)
		}
	}

	for len(stack) > 0 && stack[len(stack)-1] == popped[popIndex] {
		stack = stack[:len(stack)-1]
		popIndex++
	}

	return len(stack) == 0
}
