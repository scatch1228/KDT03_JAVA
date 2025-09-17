package chap1_기본알고리즘;

import java.util.Arrays;
import java.util.StringTokenizer;

public class train_실습1_6_스트링토큰_과제 {
/*
 * StringTokenizer(input), countTokens(), hasMoreTokens(), nextToken()
 * parseDouble(stringArray[i])
 */
  

  
    public static void main(String[] args) {
        String msg = "3.24 3.34156 1141.56 214.0 0.0314156 54.12f";
        
        // 실수를 문자열로 추출하고 정렬 후 출력
        String[] sortedStringArray = extractSortStrings(msg);
        System.out.println("정렬 스트링 배열:");
        printStringArray(sortedStringArray);
        
        // 문자열 배열을 실수 배열로 변환하고 정렬 후 출력
       double[] sortedDoubleArray = convertSortToDouble(sortedStringArray);
        System.out.println("정렬 실수 배열:");
        printDoubleArray(sortedDoubleArray);
    }



	private static String[] extractSortStrings(String msg) {
		StringTokenizer x = new StringTokenizer(msg);
		String[] extractSortStrings = new String[x.countTokens()];
		
		for (int i=0; i < extractSortStrings.length; i++) {
			extractSortStrings[i] = x.nextToken();
		}
		Arrays.sort(extractSortStrings);
		
		return extractSortStrings;
	}
	
	private static void printStringArray(String[] sortedStringArray) {
		for (String string : sortedStringArray) {
			System.out.println(string);
		}
		
	}
	
	private static double[] convertSortToDouble(String[] sortedStringArray) {
		double[] sortedDoubleArray = new double[sortedStringArray.length];
		int count =0;
		for (String string : sortedStringArray) {
			sortedDoubleArray[count++] = Double.parseDouble(string);
		}
		Arrays.sort(sortedDoubleArray);
		
		return sortedDoubleArray;
	}



	private static void printDoubleArray(double[] sortedDoubleArray) {
		for (double n : sortedDoubleArray) {
			System.out.println(n);
		}
}
	
}
