package hisoka.poipo;

import java.util.Arrays;

public class MainCodility {

	public static void main(String[] args) {
		
		int a = 2147483647;
		System.out.println(Integer.MAX_VALUE);
		System.out.println(a);
		
	}
	
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

}
