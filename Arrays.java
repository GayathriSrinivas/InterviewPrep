public class Arrays {
	
	private final int MAX_ASCII_COUNT = 256;

	public String reverse(String str) {
		StringBuffer s = new StringBuffer(str);
		int strLen = str.length();
		
		if( strLen <= 0) {
			return null;
		} 

		int start = 0;
		int end = strLen - 1;

		while( start < end) {	
			char temp = s.charAt(start);
			s.setCharAt(start,s.charAt(end));
			s.setCharAt(end,temp);
			System.out.println(s.toString());
			start = start + 1;
			end = end - 1;
		}

		return s.toString();
	}

	/*
		Possible solutions :
		1) Sort the Array using Merge Sort -  O(nlogn) and then 
			compare adjacent elements for uniqueness in O(n), Total : O(nlogn)
		2) Brute Force Method - O(n2)
		3) Use Boolean Array to check 
	*/
	public boolean isUnique(String str) {

		int strLen = str.length();

		if(strLen > 256) {
			return false;
		}
		
		boolean[] bool_array = new boolean[MAX_ASCII_COUNT];

		for(int i = 0 ; i < strLen ; i++ ) {
			int val = str.charAt(i);
			System.out.println("Value:::" + val);	

			if(bool_array[val] == true) {
				return false;
			}
			bool_array[val] = true;
		}

		return true;

	}

	public static void main(String args[]) {
		String str = "abcsdgjdfsglksdfgj";
		Arrays obj = new Arrays();
		//obj.reverse(str);
		if(obj.isUnique(str)) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
		
	}
}