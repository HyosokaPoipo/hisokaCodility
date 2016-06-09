package hisoka.poipo;

public class MainCodility {

	public static void main(String[] args) {
		
		
		System.out.println(Integer.MAX_VALUE);
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
	
	
	//ArrayInversionCount
	//https://codility.com/programmers/task/array_inversion_count/
	
	

}
