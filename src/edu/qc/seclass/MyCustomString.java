package edu.qc.seclass;

public class MyCustomString implements MyCustomStringInterface{
	private String str;             
	private String[] arr;
	
	public MyCustomString() {
		str = null;          //if the later input string is empty, we just return null from here
		arr = new String[10];
		setArray();
	}
	
	public MyCustomString(String string) {
		str = string;
		arr = new String[10];
		setArray();
	}
	
	public void setArray() {
		arr[0] = "Zero";
		arr[1] = "One";
		arr[2] = "Two";
		arr[3] = "Three";
		arr[4] = "Four";
		arr[5] = "Five";
		arr[6] = "Six";
		arr[7] = "Seven";
		arr[8] = "Eight";
		arr[9] = "Nine";
	}
	
	public String getString() {
		return str;
	}
	
	public void setString(String string) {
		str = string;
	}
	
	public int countNumbers() throws NullPointerException{
		if(str == null) throw new NullPointerException("Null pointer exception");     //if the string is null, we throw an new NullPointerException
		int res = 0;                    //here is the result we want to return 
		boolean digts = false;
		for(char c : str.toCharArray()) {
			boolean isDigts = Character.isDigit(c);
			if(digts == false && isDigts == true) {
				digts = true;
				res++;
			}
			if(digts == true && isDigts == false) {
				digts = false;
			}
		}
		return res;
	}
	
	public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd) throws IllegalArgumentException, NullPointerException {
		if(n <= 0) throw new IllegalArgumentException("The input n is not valid");            // input n should not less than or equal to 0
		if(str == null) throw new NullPointerException("Null pointer exception");         //current string is null
		if(str.length() < n) return "";                           // if the current string's length is less than n or empty,return empty string
		
		StringBuilder sb = new StringBuilder();                 //here we use StringBuilder to set up the result string
		if(startFromEnd == true) {
			for(int i=str.length()-n; i>=0; i-=n) {
				sb.append(str.charAt(i));
			}
		}
		else {
			for(int i=n-1; i<str.length(); i+=n) {
				sb.append(str.charAt(i));
			}
		}
		
		return startFromEnd == true ? sb.reverse().toString() : sb.toString();          //if we are putting the charcater from the end, we need to reverse it first
	}
	
	public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) throws IllegalArgumentException, MyIndexOutOfBoundsException, NullPointerException{
		if(startPosition > endPosition) throw new IllegalArgumentException("Illegal Arguments");
		if(startPosition <= 0 || endPosition > str.length()) throw new MyIndexOutOfBoundsException("Index out of bound");
		if(str == null) throw new NullPointerException("Null pointer exception");
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(str.substring(0, startPosition-1));                  //append the part of the string before the input range
		
		for(int i=startPosition-1; i<endPosition ;i++) {
			char c = str.charAt(i);
			if(Character.isDigit(c) == true) {
				int temp = c - '0';
				sb.append(arr[temp]);
			}
			else sb.append(c);
		}
		
		sb.append(str.substring(endPosition, str.length()));
		
		str = sb.toString();
	}
}
