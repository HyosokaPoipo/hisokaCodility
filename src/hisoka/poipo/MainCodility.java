package hisoka.poipo;

import java.util.Arrays;

public class MainCodility {

	public static void main(String[] args) {
		
		//int a = 2147483647;
		//System.out.println(Integer.MAX_VALUE);
		//System.out.println(a);		
		
		//test_Num_solitaire();
		
		
		testmin_abs_sum();
	}
/*****************************************************************************************************/	
	//min_abs_sum
	//https://codility.com/programmers/task/min_abs_sum/
	public static void testmin_abs_sum()
	{
		int[] A = {1,5,2,-1};
		
		
		System.out.println("Hasil " + min_abs_sum(A));
	}
	
	
	public static int min_abs_sum(int[] A)
	{		
		int odd = 0, even = 0;
		for(int i=0; i<A.length; i++)
		{
			if(i%2 == 0)even = even + (A[i]*-1);
			else odd = odd+(A[i]*1);
		}
		
		return even+odd;
	}
	
	
	
	
	
/*****************************************************************************************************/	
	//ArrayInversionCount
	//https://codility.com/programmers/task/array_inversion_count/
	
	int merge(int[] arr, int[] left, int[] right) {
	    int i = 0, j = 0, count = 0;
	    while (i < left.length || j < right.length) {
	        if (i == left.length) {
	            arr[i+j] = right[j];
	            j++;
	        } else if (j == right.length) {
	            arr[i+j] = left[i];
	            i++;
	        } else if (left[i] <= right[j]) {
	            arr[i+j] = left[i];
	            i++;                
	        } else {
	            arr[i+j] = right[j];
	            count += left.length-i;
	            j++;
	        }
	    }
	    return count;
	}

	int invCount(int[] arr) {
	    if (arr.length < 2)
	        return 0;

	    int m = (arr.length + 1) / 2;
	    int left[] = Arrays.copyOfRange(arr, 0, m);
	    int right[] = Arrays.copyOfRange(arr, m, arr.length);

	    return invCount(left) + invCount(right) + merge(arr, left, right);
	}
	
	//Cara 1
	public static int arrInvCount(int[] A)
	{
		int count = 0;
		for(int p=0; p<A.length; p++)
		{
			for(int q=p+1; q<A.length; q++)
			{
				if(A[p]>A[q]) count++;
			}
		}
		if(count > 1000000000) return -1;
		return count;
	}
	
/*****************************************************************************************************/	
	
	//str symetry point
	//https://codility.com/programmers/task/str_symmetry_point/
	public static int strSymPoint(String S)
	{
		if(S.length() == 0 || S.length()%2 == 0) return -1;
		int toStart = (S.length()/2)-1;
		int toEnd = (S.length()/2)+1;
		
		while(toStart >= 0)
		{
			if(S.charAt(toStart) != S.charAt(toEnd)) return -1;
			toStart -= 1;
			toEnd += 1;
		}
		return S.length()/2;
	}
	
	
	
/*****************************************************************************************************/	
	//Number Solitaire
	//https://codility.com/programmers/task/number_solitaire/
	public static void test_Num_solitaire()
	{
		int[] A = {1,-2,0,9,-1,-2};
		int[] B = {1,3};
		System.out.println("Hasil number_solitaire : "+number_solitaire(A));
		System.out.println("Hasil number_solitaire1 : "+number_solitaire1(B));
		System.out.println("Hasil number_solitaire1 : "+number_solitaire1(A));
		System.out.println("Hasil number_solitaire3 : "+number_solitaire3(A));
		System.out.println("Hasil number_solitaire3 : "+number_solitaire3(B));
	}
	
	   public static int number_solitaire3(int[] A) {
	        int[] store = new int[A.length];
	        store[0] = A[0];
	        for (int i = 1; i < A.length; i++) {
	            store[i] = store[i-1];
	            for (int minus = 2; minus <= 6; minus++) {
	                if (i >= minus) {
	                    store[i] = Math.max(store[i], store[i - minus]);
	                } else {
	                    break;
	                }
	            }
	            store[i] += A[i];
	        }
	        return store[A.length - 1];
	    }
	
	public static int number_solitaire2(int[] A)
	{
		int result = A[0];
		int temp = 0;
		for(int i = 0; i<A.length-1; i++)
		{
			
		}
		
		return result;
	}
	
	public static int number_solitaire1(int[] A)
	{
		int result = 0;
		for(int i=0; i<A.length-1; i++)
		{
			if(A[i]<=0) continue;
			result += A[i];
		}
		
		return result+A[A.length-1];
	}
	
	
	public static int number_solitaire(int[] A)
	{
		int currentIndex = 0;		
		int lastIndex = 0;
		int[] temp ;
		int result = 0;		
		int tempInt = 0;
		int tempInt2 = 0;
		if(A.length > 6)
		{
			lastIndex = 6;
			temp = new int[6];
		}else
		{
			lastIndex = A.length;
			temp = new int[lastIndex];
		}
		while(currentIndex < A.length )
		{			 
			 temp = Arrays.copyOfRange(A, currentIndex, lastIndex);
			 displayArray(temp);
			 tempInt = findMaxArrayContents(temp);
			 result += tempInt;
			 tempInt2 = Arrays.binarySearch(A, currentIndex, lastIndex-1, tempInt);
			 if(tempInt2 == 0)
			 {
				 currentIndex += 1; 
			 }else
			 {
				 currentIndex = currentIndex + tempInt2+1;
			 }
			 
			 if(lastIndex + 6 > A.length)
				 {
				 	lastIndex = currentIndex + (A.length - currentIndex);
				 	temp = new int[lastIndex];
				 }
			 else lastIndex =  currentIndex + 6;
		}
		
		
		return result;
	}
	
	public static int findMaxArrayContents(int[] input)
	{
		Arrays.sort(input);
		return input[input.length-1];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//UTILITY METHOD
	 public static void displayArray(int[] A)
		{
			for (int a: A)
			{
				System.out.print(a+" ");
			}
			System.out.print("\n");
		}

	    public static void printMessage(String mess)
		{
			System.out.println(mess);
		}

}
