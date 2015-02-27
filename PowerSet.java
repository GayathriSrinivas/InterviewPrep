import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PowerSet {	
	
	private ArrayList<String> getPowerSet(String str) {
		ArrayList<String> powerSet = new ArrayList<String>();
		int n = str.length();
		System.out.println(n);
		for (int i = 0; i < Math.pow(2, n); i++) {
			int temp = i;
			StringBuffer strBuf = new StringBuffer();
			for (int j = 0; j < n; j++) {
				if(getLeastSignificantBit(temp)) {
					strBuf.append(str.charAt(j));
				}
				temp = temp >>> 1;
			}
			powerSet.add(strBuf.toString());
		}
		return powerSet;
	}
	
	private boolean getLeastSignificantBit(int value) {
		return ((value & 1) == 1) ? true : false; 
	}
	
	/*
	 * Recursively Compute the power set
	 * Use Set to remove duplicates.
	 * */
	private void rPowerSet(String str,Set<String> powerSet) {
		powerSet.add(str);
		
		for (int i = 0; i < str.length(); i++) {
			rPowerSet(str.substring(0,i) + str.substring(i+1)  , powerSet);
		}
		
	}

	public static void main(String args[]) {
		String str = "abc";
		PowerSet ps = new PowerSet();
		//System.out.println("Hello World!!");
		//ArrayList<String> str1 = ps.getPowerSet(str);
		//System.out.println(str1.size());
		Set<String> powerSet = new HashSet();
		ps.rPowerSet(str, powerSet);
		System.out.println(powerSet);
		System.out.println(powerSet.size());
	}
}
