package temp

type ExamTracker struct {
	scoreRecord [][]int
}

func Constructor() ExamTracker {
	tracker := ExamTracker{
		scoreRecord: make([][]int, 0),
	}
	return tracker
}

func (this *ExamTracker) Record(time int, score int) {
	oldScore := 0
	temp := []int{}
	if len(this.scoreRecord) > 0 {
		oldScore = this.scoreRecord[len(this.scoreRecord)-1][1]
	} else {
		temp = []int{time, score}
	}

	temp = []int{time, score + oldScore}
	this.scoreRecord = append(this.scoreRecord, temp)
}

func (this *ExamTracker) TotalScore(startTime int, endTime int) int64 {
	var sum int64
	n := len(this.scoreRecord)
	if n == 0 {
		return 0
	}

	l, r := 0, n-1
	endIdx := -1
	for l <= r {
		mid := (l + r) / 2
		if this.scoreRecord[mid][0] <= endTime {
			endIdx = mid
			l = mid + 1
		} else {
			r = mid - 1
		}
	}
	if endIdx == -1 {
		return 0
	}

	l, r = 0, n-1
	startPrevIdx := -1
	for l <= r {
		mid := (l + r) / 2
		if this.scoreRecord[mid][0] < startTime {
			startPrevIdx = mid
			l = mid + 1
		} else {
			r = mid - 1
		}
	}

	sum = int64(this.scoreRecord[endIdx][1])
	if startPrevIdx != -1 {
		sum -= int64(this.scoreRecord[startPrevIdx][1])
	}
	return sum
}

/**
 * Your ExamTracker object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Record(time,score);
 * param_2 := obj.TotalScore(startTime,endTime);
 */
