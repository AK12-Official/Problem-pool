package temp

func maxProfit(prices []int, strategy []int, k int) (ans int64) {
	n := len(prices)

	profitPresum := make([]int, n)
	profit := make([]int, n)
	profitPresum[0] = 0
	profit[0] = prices[0] * profit[0]
	for i := 1; i < n; i++ {
		profitPresum[i] = profitPresum[i-1] + prices[i-1]*strategy[i-1]
		profit[i] = prices[i] * strategy[i]
	}
	ans = int64(profitPresum[n-1] + profit[n-1])

	m := k / 2
	left := 0
	windowValue := 0
	for right := 0; right < n; right++ {
		for right-left+1 <= m {
			right++
			continue
		}

		windowValue += prices[right]

		for right-left+1 > k {
			windowValue -= prices[right-m]
			left++
		}

		ans = max(ans, int64(profitPresum[left]+windowValue+profitPresum[n-1]-profitPresum[right]+profit[n-1]-profit[right]))
	}
	return
}
