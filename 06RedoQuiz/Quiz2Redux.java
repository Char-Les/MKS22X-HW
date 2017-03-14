import java.util.*;
public class Quiz2Redux{  
    /*Returns an ArrayList<String> that contains all subsets of the
     *characters of String s. Assume s has no duplicate characters.
     *the characters should appear in the same order that they occur 
     *in the original string.
     */
    public static ArrayList<String> combinations(String s){
	ArrayList<String> words = new ArrayList<String>();
	help( words, s, "", 0);
	Collections.sort(words);
	return words;
    }
    
    private static void help( ArrayList<String> words, String s, String passAlong, int index){ 
	if(index == s.length()){
	    words.add(passAlong);
	    return;
	}
	String passAlong2 = passAlong + s.charAt(index);
	help(words, s, passAlong, index + 1);
	help(words, s, passAlong2, index + 1);
    }


    private static String p(ArrayList<String> x){
	String ans = "{";
	for(String a : x){
	    ans += "\"" + a + "\" ";
	}
	return ans + "}";
    }

    public static void main(String[] args){
	System.out.println(p(combinations("abcd")));
	System.out.println(p(combinations("kji")));
	System.out.println(p(combinations("1234")));
	System.out.println(p(combinations("")));
    }
}

