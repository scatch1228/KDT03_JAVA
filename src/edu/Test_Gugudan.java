package edu;

public class Test_Gugudan {

	public static void printVertical() {
		for (int i=2; i<10; i++) {
			System.out.println(i+"단");
			for (int j=1; j<10; j++) {
				System.out.println(i + "*" + j + "=" + i*j);
			}
			System.out.println("----------");
		}
	}
	
	public static void printHorizontal() {
		for (int j=1; j<10; j++) {
			System.out.println("");
			for (int i=2; i<10; i++) {
				System.out.print(i + "*" + j + "=" + i*j +"		");
			}
		}
	}
	
	public static void printColumn(int col) {
//		for (int k=1; k<= 9/col+1 ; k++) {
//			for (int j=0; j<10; j++) {
//				System.out.println("");
//				for (int i=2; i <= col+1; i++) {
//					if (j==0) {System.out.print(i+"단		");}
//					else if (i<= col+1) {
//						System.out.print(i + "*" + j + "=" + i*j +"		");
//						}
//					else if (col+1 < i & i <= 2*col) {
//						System.out.println("\n");
//						System.out.print(i + "*" + j + "=" + i*j +"		");
//						};
//					};
//				}
//			}
	
	
	for (int k=1; k < 10; k+=col) {
		System.out.println("\n");
		
		for (int j=0; j<10; j++) {
			System.out.println();
			
			for (int i=k+1; i<= k+col & i<10; i++) {
				if (j==0) {System.out.print(" " + i +"단		");}
				else System.out.print(i + "*" + j + "=" + i*j +"		");
			} //i close
		} //j close
	} //k close
		
	
	
	}//printColumn close
		
	
	
	public static void main(String[] args) {
//		printVertical();
//		printHorizontal();
		printColumn(3);
		printColumn(4);

	}

}
