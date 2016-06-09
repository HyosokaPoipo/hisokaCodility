package hisoka.poipo;

public class MainCodility {

	public static void main(String[] args) {
		
		int a = 2147483647;
		System.out.println(Integer.MAX_VALUE);
		System.out.println(a);
		
	}
	
	//ArrayInversionCount
	//https://codility.com/programmers/task/array_inversion_count/
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
	
	
	
	
	

}
