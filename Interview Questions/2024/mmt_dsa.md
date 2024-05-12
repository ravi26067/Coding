# Problem Statement: Store Opening Hours

You are given two arrays representing the opening and closing hours of a store for each day of the week. You need to process this data and generate the store's opening hours for each day in a human-readable format, considering the following conditions:

1. If the opening hours are greater than the closing hours, the store is assumed closed on that day.
2. If the opening or closing hours are greater than 2400 hours or for any other error condition, the store is assumed closed that day.
3. If the opening hours are equal to the closing hours, the store is open for 24 hours.

Write a function `generate_opening_hours(open_hours: List[int], close_hours: List[int]) -> Dict[str, str]` that takes in two lists of integers representing the opening and closing hours respectively, and returns a dictionary where the keys represent the days of the week (abbreviated as Mon, Tue, Wed, Thu, Fri, Sat, Sun), and the values represent the opening hours for that day in a human-readable format.

**Input:**
- `open_hours`: A list of integers representing the opening hours for each day of the week.
- `close_hours`: A list of integers representing the closing hours for each day of the week.

**Output:**
- A dictionary where each key-value pair represents the day of the week and the corresponding opening hours.

**Sample Input:**
```python
open_hours = [900,1000,1000,1000,2700,1200,800]
close_hours = [1700,1600,1600,1600,1600,1200,800]
```

**Sample Output:**
```python
{
    "Mon": "900-1700",
    "Tue-Thu": "1000-1600",
    "Fri": "Closed",
    "Sat-Sun": "Open 24 Hours"
}
```

**Special Conditions:**
1. If the opening hours are greater than the closing hours, the store is assumed closed on that day.
2. If the opening/closing hours are greater than 2400 hours or for any other error condition, the store is assumed closed that day.
3. If the opening hours are equal to the closing hours, the store is open for 24 hours.

**Note:**
- Assume that the opening and closing hours are represented in a 24-hour format (e.g., 900 for 9:00 AM, 1700 for 5:00 PM).

## Solution:
```go
package main

import (
	"fmt"
)

func main() {
	open := []int{900, 1000, 1000, 1000, 2700, 1200, 800}
	close := []int{1700, 1600, 1600, 1600, 1600, 1200, 800}

	days := []string{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"}

	l:=len(open)

	res:= make([]string,0)

	
	for i:=range (l){
		if open[i]==close[i]{
			res=append(res,"Open 24 Hours")
		}else if open[i]>close[i]{
			res=append(res,"Closed")
		}else{
			res=append(res,fmt.Sprintf("%d-%d",open[i],close[i]))
		}
	}

	key:=""
	for i:=range (l){
		
		if i==0{
			if res[i]==res[i+1]{
				key+=days[i] + "-"
			}else{
				fmt.Printf("%s:%s\n",days[i],res[i])
			}
		}else if i==l-1{
			if res[i] == res[i-1]{
				key+= days[i]
				fmt.Printf("%s:%s\n",key,res[i])
			}else{

			}
		}else{
			if res[i] == res[i-1]&&res[i]==res[i+1]{
				
			}else if res[i] == res[i-1]{
				key+= days[i]
				fmt.Printf("%s:%s\n",key,res[i])
			}else if res[i]==res[i+1]{
				key+=days[i] + "-"
			}else{
				key=""
				fmt.Printf("%s:%s\n",days[i],res[i])
			}
		}
	}

}
```
