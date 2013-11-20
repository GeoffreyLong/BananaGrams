package boardGUI;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CheckScores {
	
	int theCount = 0;
	int theMainScore = 0;
	
	public boolean checkValidity(String theString){
		boolean theBoolean = false;
		ArrayList<String> list = new ArrayList<String>();
		String fileName = "C:\\Users\\geoff\\Desktop\\eclipse\\ScrabbleWordsOne.txt";
		list = readWordsFromFile(fileName);
		if (list.contains(theString)){
			theBoolean=true;
		}
		return theBoolean;
	}
	
	public static ArrayList<String> readWordsFromFile(String filename)
	{
		ArrayList<String> words = new ArrayList<String>();
		try
		{
			File file = new File(filename);
			Scanner scanner = new Scanner(file);
			// Strip non-alphanumeric \\W
			scanner.useDelimiter("\\W+"); 
			while (scanner.hasNext())
			{
				words.add(scanner.next());
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}
		return words;
	}
	
	public int theCheck(int a, int b, String string){
		int score = 10;
		boolean valid = checkValidity(string);
		
		if (valid){
		char[] theArray = string.toCharArray();
		
		for (int i = 0; i<theArray.length; i++){
			score*=1.5;
		}
		
		if (b>1){
			theCount = theCount+1;
		}
		else {
			theCount=0;
		}
		
		for (int j=0; j<theCount; j++){
			score*=2;
		}
		}
		else {
			score = 0;
		}
		return score;
	}
	
}
