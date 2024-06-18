package api_Udemy_Learning;

	import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

	public class combinations {

	    public static void main(String[] args) {
	    	String s = "software";
	    	 Set<String> permutations = new HashSet<>();
	         generatePermutations(s, "", permutations);
	         
	         // Printing all the permutations
	         for (String permutation : permutations) {
	             System.out.println(permutation);
	         }
	     }

	     public static void generatePermutations(String str, String current, Set<String> permutations) {
	         if (current.length() == str.length()) {
	             permutations.add(current);
	             return;
	         }

	         for (int i = 0; i < str.length(); i++) {
	             if (current.indexOf(str.charAt(i)) == -1) { // Ensure each character is used only once
	                 generatePermutations(str, current + str.charAt(i), permutations);
	             }
	         }
	     }
	}
