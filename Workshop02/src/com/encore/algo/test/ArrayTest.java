package com.encore.algo.test;

import java.util.Arrays;

public class ArrayTest {
	public static int[] list = { 34, 23, 64, 25, 12, 75, 22, 88, 53, 37 };

	public static void print() {
		for(int i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void total() {
		int sum = 0;
		for(int i : list) {
			sum+= i;
		}
		System.out.println("배열의 합 : "+sum);

	}

	public static void average() {
		int sum = 0;
		for(int i : list) {
			sum+= i;
		}
		System.out.println("배열의 평균 : "+(sum/list.length));
	}

	public static void minimun() {
		int min = list[0];
		for (int i : list) {
			if(min>i) {
				min = i;
			}
		}
		System.out.println("배열의 최소값 : " + min);
	}

	public static void selectSort() {
		Arrays.sort(list);
	}

	public static void main(String[] args) {
		print();
		total();
		average();
		minimun();
		System.out.println("=== selection sort (Ascending Order) ===");
		selectSort();
		print();
		
				
	}

}
