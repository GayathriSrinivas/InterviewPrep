import java.util.ArrayList;


public class Permutation {

	public static void main(String args[]) {
		ArrayList<String> array = new ArrayList<String>();
		Permutation p = new Permutation();
		p.getAllPermutations("", "abcd",array);
		System.out.println(array.size());
	}
	
	private void getAllPermutations(String buf, String str, ArrayList<String> array) {
		if(str.isEmpty()) {
			array.add(buf);
		}
		
		for (int i = 0; i < str.length(); i++) {
			getAllPermutations(buf + str.charAt(i),str.substring(0, i) + str.substring(i+1),array);
		}
		
	}
}
