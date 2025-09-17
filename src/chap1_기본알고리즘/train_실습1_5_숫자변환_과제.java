package chap1_기본알고리즘;

import java.util.Arrays;

public class train_실습1_5_숫자변환_과제 {
/*
 * split(" ")
 * parseInt(stringArray[i])
 */

    public static void main(String[] args) {
        String input = "12 111 911 921 94 23 214 222";
        
        // 문자열 배열 정렬 및 출력
        String[] sortedStringArray = splitSortString(input);
        System.out.println("Sorted String Array:");
        printStringArray(sortedStringArray);
        
        // 문자열 배열을 정수 배열로 변환 및 정렬 후 출력
        int[] sortedIntArray = convertSortToIntArray(sortedStringArray);
        System.out.println("Sorted Integer Array:");
        printIntArray(sortedIntArray);
    }






	private static String[] splitSortString(String input) {
		String[] sortedStringArray = input.split(" ");
		Arrays.sort(sortedStringArray);
		return sortedStringArray;
	}
	
	private static void printStringArray(String[] sortedStringArray) {
		for (String string : sortedStringArray) {
			System.out.println(string);
		}
		
	}
	
	private static int[] convertSortToIntArray(String[] sortedStringArray) {
		int[] sortedIntArray = new int[sortedStringArray.length];
		int count = 0;
		for (String string : sortedStringArray) {
			sortedIntArray[count++] = Integer.parseInt(string);
		}
		Arrays.sort(sortedIntArray);
			
		return sortedIntArray;
	}
	
	private static void printIntArray(int[] sortedIntArray) {
		for (int n : sortedIntArray) {
			System.out.println(n);
		}
		
	}

}
