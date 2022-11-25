package com.bridgelabz.day13;

public class Max {


	public static Integer findmax(Integer[] arr)
	{
		Integer maxnum = arr[0];

		for(int i=1;i<arr.length;i++)
		{
			if(arr[i].compareTo(maxnum) > 0)
				maxnum = arr[i];
		}

		return maxnum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Integer arr1[] = {3,2,1};
		Integer arr2[] = {3,12,6};
		Integer arr3[] = {2,5,8};

		System.out.println(Max.findmax(arr1));
		System.out.println(Max.findmax(arr2));
		System.out.println(Max.findmax(arr3));
		
	}

}
