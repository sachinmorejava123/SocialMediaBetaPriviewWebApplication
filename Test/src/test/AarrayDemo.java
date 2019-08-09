package test;

import java.util.Scanner;

public class AarrayDemo {
	int res=0;
	
	public int processArray(int[] array) {
		
		
		
		   int len=array.length;
		   
		   if(len < 7) {
				res=-1;
			}
			if(len > 100){
				res=-2;
			}
		   
		   
		   
		
		
		return res;
		
	}

	public static void main(String[] args) {
		
		AarrayDemo demo=new AarrayDemo();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter size of an array : ");
		
		int size = scanner.nextInt();
		
		int[] numbers = new int[size];
		
		for(int i=0;i<size;i++) {
			
			System.out.print("Enter element : ");
			numbers[i] = scanner.nextInt();
			
		}
		
	int res=demo.processArray(numbers);
	System.out.println(res);
		
		
		
	}
}