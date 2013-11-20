package boardGUI;

public class WordCompile {

	int theKeeper=-1;
	int theMainScore;
	/**
	 * @param args
	 */
	public int daScore(String[][] arrayToCheck){
		int score = 0;
		for(int i = 0; i<=12; i++){
			for (int j=0; j<=12; j++){
				if(arrayToCheck[i][j]!=null){
					int a=i;
					int b=j;
					if (a==12 || b==12){
						if (a==12){
							if (b==0){
								vertStringMaker(a,b,arrayToCheck);
							}
							if (b!=0){
								if (arrayToCheck[a][b-1]==null){
									if(b!=12){
										if(arrayToCheck[a][b+1]!=null){
											vertStringMaker(a,b,arrayToCheck);
										}
									}
								}
							}
						}
						if (b==12){
							if (a==0){
								horizStringMaker(a,b,arrayToCheck);
							}
							if (a!=0){
								if (arrayToCheck[a-1][b]==null){
									if(a!=12){
										if(arrayToCheck[a+1][b]!=null){
											horizStringMaker(a,b,arrayToCheck);
										}
									}
								}
							}
						}
					}
					else{
					if (b==0){
						if(arrayToCheck[a][b+1]!=null){
							vertStringMaker(a,b,arrayToCheck);
						}
					}
					if (b>0){
						if (arrayToCheck[a][b-1]==null){
							if(arrayToCheck[a][b+1]!=null){
								vertStringMaker(a,b,arrayToCheck);
							}
						}
					}
					if (a==0){
						if(arrayToCheck[a+1][b]!=null){
							horizStringMaker(a,b,arrayToCheck);
						}
					}
					if (a>0){
						if (arrayToCheck[a-1][b]==null){
							if(arrayToCheck[a+1][b]!=null){
								horizStringMaker(a,b,arrayToCheck);
							}
						}
					}
				}
				}
			}	
		}
		
		System.out.println(theMainScore);
		
		return theMainScore;
	}
	
	public String vertStringMaker (int a, int b, String[][] theStringArray){
		String string = "";
		if (b<12){
			if (theStringArray[a][b+1]!=null){
				string = theStringArray[a][b] + vertStringMaker(a, b+1, theStringArray);
			}
			else{
				if (theStringArray[a][b]!=null){
					string = string + theStringArray[a][b];
				}
			}
		}
		else {
			string = theStringArray[a][b];
		}
		if ((a!=0 && theStringArray[a-1][b] != null) || (a!=12 && theStringArray[a+1][b] != null)){
			theKeeper++;
		}
		if (b==0){
			CheckScores check = new CheckScores();
			theMainScore += check.theCheck(a, theKeeper, string);
			theKeeper = 0;
		}
		else{
			if (theStringArray[a][b-1]==null){
				CheckScores check = new CheckScores();
				theMainScore += check.theCheck(a, theKeeper, string);
				theKeeper = 0;
			}
		}
		return string;
	}

	public String horizStringMaker (int a, int b, String[][] theStringArray){
		String string = "";
		if (a<12){
			if (theStringArray[a+1][b]!=null){
				string = theStringArray[a][b] + horizStringMaker(a+1, b, theStringArray);
			}
			else{
				if (theStringArray[a][b]!=null){
					string = string + theStringArray[a][b];
				}
			}
		}
		else {
			string = theStringArray[a][b];
		}
		if ((b!=0 && theStringArray[a][b-1] != null) || (b!=12 && theStringArray[a][b+1] != null)){
			theKeeper++;
		}
		if (a==0){
			CheckScores check = new CheckScores();
			theMainScore += check.theCheck(b, theKeeper, string);
			theKeeper = 0;
		}
		else{
			if (theStringArray[a-1][b]==null){
				CheckScores check = new CheckScores();
				theMainScore += check.theCheck(b, theKeeper, string);
				theKeeper = 0;
			}
		}
		return string;
	}
}