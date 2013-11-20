package boardGUI;


	import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


	public class WordCheck {	
				
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
		
		public int thePoints (String theString, int player){
			int score = 0;
			String delims = "";
			String[] charArray = theString.split(delims);
			for (int i = 1; i<=theString.length(); i++){
				
			}
			return score;
		}
		
		public ArrayList<String> getWords (){
			ArrayList<String> newWords = new ArrayList<String>();
			ArrayList<String> list = new ArrayList<String>();
			String fileName = "C:\\Users\\geoff\\Desktop\\eclipse\\ScrabbleWordsOne.txt";
			list = readWordsFromFile(fileName);
			
			for (int z=0; z<10; z++){
				Random generator = new Random();
				int r = generator.nextInt(172869);
				newWords.add(list.get(r));
			}
			
			return newWords;
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

}
