package 과제;

/*
 * 주어진 긴 문자열 text에서 패턴 문자열 pattern이 등장하는 모든 시작 인덱스를 찾으세요.
 *
 * 입력: text = "abxabcabcabyabcaby", pattern = "abcaby"
 * 출력: [6,12]
 * 
 * 패턴이 나타나는 인덱스를 반환
 */
public class train_실습1장_과제3부분문자열검색 {
	
	    public static void main(String[] args) {
	        String text = "ababcabcabababd";
	        String pattern = "ababd";
	        
	        System.out.println(text+"의 substring: "+pattern+"의 index 출력");
	        searchSubstring(text, pattern);
	        
	        
	        text = "abxabcabcabyabcaby";
	        pattern = "abcaby";
	        System.out.println(text+"의 substring: "+pattern+"의 index 출력");
	        searchSubstring(text, pattern);

	    }
	    
	    public static void searchSubstring(String text, String pattern) {
	    	int indexStart = 0;
	    	int count = 0;
	    	int tl = text.length();
	    	int pl = pattern.length();
	    	
	    	for (int i=0; i <= (text.length() - pattern.length()); i+=count) {
	    		for (int j=0; j < pattern.length(); j++) {
	    			if (text.charAt(i+j)!=pattern.charAt(j)) {
	    				count = j+1;
	    				continue;
	    			}//if 
	    			else {
	    				indexStart = i;
	    				count = j+1;
	    			}//else
	    			if (count==pattern.length() & text.charAt(i+j)==pattern.charAt(j)) {
    					System.out.println("["+ indexStart+", "+(indexStart+count) + "]");
    				}// if-j
	    		}//for j
	    	}//for i
	    }
	
}//class


