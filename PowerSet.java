import java.util.ArrayList;

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

	public static void main(String args[]) {
		String str = "abcdef";
		PowerSet ps = new PowerSet();
		System.out.println("Hello World!!");
		ArrayList<String> str1 = ps.getPowerSet(str);
		System.out.println(str1.size());
	}
}
