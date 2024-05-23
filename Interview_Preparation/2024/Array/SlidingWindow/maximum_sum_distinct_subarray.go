package main

func maximumSubarraySum(nums []int, k int) int64 {
	l := len(nums)
	mp := make(map[int]int)
	var sum int64
	var mxSum int64
	sum = 0
	mxSum = 0
	i := 0
	cnt := 0
	for i < k {
		sum += int64(nums[i])
		if _, ok := mp[nums[i]]; !ok {
			mp[nums[i]] = 1
		} else {
			mp[nums[i]] += 1
			//fl=true
		}
		i++
	}
	for _, val := range mp {
		if val > 1 {
			cnt++
		}
	}

	if cnt == 0 {
		mxSum = sum
	}
	//fmt.Println("sum: ",sum," maxSum: ", mxSum)
	i = 1
	for i <= l-k {
		mp[nums[i-1]]--
		if mp[nums[i-1]] == 0 {
			delete(mp, nums[i-1])
		} else if mp[nums[i-1]] == 1 {
			cnt--
		}
		sum += int64(nums[i+k-1] - nums[i-1])
		if _, ok := mp[nums[i+k-1]]; ok {
			if mp[nums[i+k-1]] == 1 {
				cnt++
			}
			mp[nums[i+k-1]]++
		} else {
			mp[nums[i+k-1]] = 1
		}

		if cnt == 0 && mxSum < sum {
			mxSum = sum
		}
		//fmt.Println("sum: ",sum," maxSum: ", mxSum)
		i++
	}
	return mxSum
}
