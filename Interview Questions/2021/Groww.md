# Groww 

## Round 1

**Q1. Data structure which help implements**


sp1- 1 2 3

1 2 3 4

set(1,5)
set(4,4)

Sp2 - 5 2 3 4

1,{1,2,3} {0,{1,1},{2,2},{3,3}}
2,{5,2,3,4} {1,{1,5}{4,4}
3,{1,2,3,4}
4,{5,2,3,4}

``` java
Class Snapshots{

Map<Integer,Integer> snaps;

Int snapshotCount=1;

Map<Integer,Map<Integer,Integer>> snapshots;

public Snapshots(){
snaps = new HashMap();
takeSnapshot=true;
Snapshots = new HashMap();
}

Int get(index,Integer spNo){
Map<Integer,Integer> snapshot = snapshots.get(spNo);
if(spNo==-1||index<0)
	Return -1;
	if(snapshot.containsKey(index))
		Return snapshot.get(index);
	Else
		Return get(index,spNo-1);
}


Public set(int index,int val){
	snaps.put(index,val);
}

snapshot(){
	snapshots.put(snapshotCount,snaps);
	snaps = new HashMap();
	snapshotCount++;
}

}

Space Complexity : O(n)
Time Complexity : O(k)

```



**Q2. Search in a matrix**

[[1 ,4 ,7 ,11,15],
[ 2 ,5 ,8 ,12,19],
[ 3 ,6 ,9 ,16,22],
[ 10,13,14,17,24]]

16 < 24 n*m (4*5)
	leftR - 0    	rightR = n
	leftC - 0	   	rightC = m



``` java
Arr[] getIndex(int value, int [][] A){
	
	Int i=0;
Int j ;
	for(int j=A[0].length;j>=0;j--){
		if(A[i][j]<value)
		Break;
		if(A[i][j]==value)
		Return true;
}
for(i=0;i<A.length;i++){
	if(A[i][j]<value)
	Break;
if(A[i][j]==value)
		Return true;

}
while(A[i][j]!=value && j>=0)
J--;

if(j>=0)
Return true;

}

```

## Round 2 (Machine Coding)

**Q.Design a system like SQL with insert delete update of table.**

