package main

import "fmt"

func intToRoman(num int) string {
	if num >= 1000 {
		return "M" + intToRoman(num-1000)
	} else if num >= 900 {
		return "CM" + intToRoman(num-900)
	} else if num >= 500 {
		return "D" + intToRoman(num-500)
	} else if num >= 400 {
		return "CD" + intToRoman(num-400)
	} else if num >= 100 {
		return "C" + intToRoman(num-100)
	} else if num >= 90 {
		return "XC" + intToRoman(num-90)
	} else if num >= 50 {
		return "L" + intToRoman(num-50)
	} else if num >= 40 {
		return "XL" + intToRoman(num-40)
	} else if num >= 10 {
		return "X" + intToRoman(num-10)
	} else if num >= 9 {
		return "IX" + intToRoman(num-9)
	} else if num >= 5 {
		return "V" + intToRoman(num-5)
	} else if num >= 4 {
		return "IV" + intToRoman(num-4)
	} else if num >= 1 {
		return "I" + intToRoman(num-1)
	}
	return ""
}

func intToRomanOp(num int) string {

	return getRomanRec(num, "")
}

func getRomanRec(num int, str string) string {
	if num == 0 {
		return str
	}
	if num-1000 >= 0 {
		return getRomanRec(num-1000, str+"M")
	}
	if num-900 >= 0 {
		return getRomanRec(num-900, str+"CM")
	}
	if num-500 >= 0 {
		return getRomanRec(num-500, str+"D")
	}
	if num-400 >= 0 {
		return getRomanRec(num-400, str+"CD")
	}
	if num-100 >= 0 {
		return getRomanRec(num-100, str+"C")
	}
	if num-90 >= 0 {
		return getRomanRec(num-90, str+"XC")
	}
	if num-50 >= 0 {
		return getRomanRec(num-50, str+"L")
	}
	if num-40 >= 0 {
		return getRomanRec(num-40, str+"XL")
	}
	if num-10 >= 0 {
		return getRomanRec(num-10, str+"X")
	}
	if num-9 >= 0 {
		return getRomanRec(num-9, str+"IX")
	}
	if num-5 >= 0 {
		return getRomanRec(num-5, str+"V")
	}
	if num-4 >= 0 {
		return getRomanRec(num-4, str+"IV")
	}
	if num-1 >= 0 {
		return getRomanRec(num-1, str+"I")
	}
	return str
}

func main() {
	fmt.Println(intToRomanOp(45))
}
