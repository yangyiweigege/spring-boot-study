package com.weige.iterator.test;

public class BubbleSort {
	public static void main(String[] args) {
		int a[] = {6,4,5,3,2,1};
		int temp=0;
		for(int i = 0 ;i<a.length-1;i++)
		for(int j=0;j<a.length-1;j++)
		{
			if(a[j+1]>a[j]) {
				temp=a[j];
				a[j]=a[j+1];
				a[j+1]=temp;
			}
		}
		for(int b :a){
			System.out.println(b);
		}
	}
}
