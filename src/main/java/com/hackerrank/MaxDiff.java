package com.hackerrank;

public class MaxDiff {

	static int maximalDifference(int[] a) {
		int diff=0;
		int m=0,n=0;
/*		for(int i=0;i<a.length;i++) {
			for(int j=i;j<a.length;j++) {
				if(a[i]<a[j]&& diff<(a[j]-a[i])) {
					diff=a[j]-a[i];
					m=i;
					n=j;
				}
			}
		}*/
        for(int i=0,j=a.length-1;i<a.length ||i<j;i++,j--){
        if(a[i]<a[j] && diff<(a[j]-a[i])) {
					diff=a[j]-a[i];
				}
        }
		if(diff==0)
			return -1;
		else return diff;
	}


	public static void main(String[] args) {
		int arr[]= {7,2,3,10,2,4,8,1};
		//int arr[]= {5,4,3,2,1};
		System.out.println(maximalDifference(arr));
	}
}
