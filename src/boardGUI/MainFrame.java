package boardGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	public JPanel gamePanel;
	JPanel charPanel = new JPanel();
	WordCheck checker = new WordCheck();
	int playerOneScore;
	int playerTwoScore;
	JPanel scorePanel = new JPanel();
	JLabel playerLabel = new JLabel();
	JPanel curLetter = new JPanel();
	JPanel playingPanel = new JPanel();
	JLabel curLetterLabel = new JLabel();
	JLabel curLetterLabelString = new JLabel();
	String curLetterString;
	String[][] theFinalArray = new String[13][13];
	String[][] nullers = new String[20][20];
	JButton [] buttons = new JButton[200];
	JPanel charSave = new JPanel();
	int curPlayer = 1;
	int finalListSize;
	String playerOneFinalScore = "";
	String playerTwoFinalScore = "";
	int playerOneFinalScoreInt;
	int playerTwoFinalScoreInt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
					frame.MainFrameStart();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void MainFrameStart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(25, 25, 1100, 700);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		contentPane.setBounds(0,0,700,700);
		
		ArrayList<String> lister = new ArrayList<String>();
		ArrayList<String> finalList = new ArrayList<String>();
		charPanel.setBounds(700,0,400,500);
		charPanel.setBackground(Color.BLUE);
		lister=checker.getWords();
		int count = 0;
		for(int e=0; e<lister.size(); e++){
			String stringWord = lister.get(e);
			String[] stringz = new String[stringWord.length()];
			String delims = "";
			stringz = stringWord.split(delims);
			for (int w=0; w<stringWord.length(); w++){
				count++;
				finalList.add(stringz[w]);
			}
		}
		
		final String [] intArray = new String[finalList.size()];
		String [] anotherArray = new String [intArray.length];
		for(int e=0; e<finalList.size(); e++){
			intArray[e]=finalList.get(e);
			anotherArray[e]=intArray[e];
		}
		
		
		
		for(int e=0; e<finalList.size(); e++){
			Random generator = new Random();
			int r = generator.nextInt(finalList.size());
			intArray[e]=anotherArray[r];
		}
		
		finalListSize = finalList.size();
		charPanel.setLayout(null);
		final String[] buttonSave = new String[finalListSize];
		int j=0;
		for(int e=0; e<finalList.size(); e++){
			if (!intArray[e].equals("")){
				buttons[e] = charButtons(j, intArray[e]);
				charPanel.add(buttons[e]);
				buttonSave[e] = buttons[e].getText();
				j++;
			}
			else{
				
			}
		}
		contentPane.add(charPanel);
		
		setPlayingPanel(playingPanel);
		
		
		scorePanel.setBounds(700,550,400,100);
		scorePanel.setBackground(Color.yellow);
		scorePanel.setLayout(null);
		playerLabel.setBounds(35,0,400,40);
		playerLabel.setText("PLAYER ONE'S TURN");
		playerLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		scorePanel.add(playerLabel);
		contentPane.add(scorePanel);
		
		curLetter.setBounds(700,475,400,100);
		curLetter.setLayout(null);
		curLetterLabel.setBounds(10,10,250,60);
		curLetterLabel.setText("CURRENT LETTER = ");
		curLetterLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		curLetterLabelString.setBounds(260,10,100,60);
		curLetterLabelString.setFont(new Font("Tahoma", Font.BOLD, 30));
		curLetterLabelString.setText("");
		curLetter.add(curLetterLabelString);
		curLetter.add(curLetterLabel);
		curLetterString="";
		contentPane.add(curLetter);
		
		
		JButton finish = new JButton();
		finish.setBounds(95,60,200,30);
		finish.setFont(new Font("Tahoma", Font.BOLD, 30));
		finish.setText("END TURN");
		finish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WordCompile compile = new WordCompile();
				int scoreInt = (compile.daScore(theFinalArray));
				theFinalArray = new String[13][13];
				playingPanel.removeAll();
				for (int i = 0; i<169; i++){
					contentPane.add(mainButtons(i));
				}
				contentPane.add(playingPanel);
				charPanel.removeAll();
				int j=0;
				for(int e=0; e<finalListSize; e++){
					if (!intArray[e].equals("")){
						buttons[e] = charButtonsNew(j, intArray[e]);
						charPanel.add(buttons[e]);
						buttonSave[e] = buttons[e].getText();
						j++;
					}
				}
			    charPanel.validate();
			    charPanel.repaint();
			    
			    
				contentPane.repaint();
				if (curPlayer == 1){
					playerOneFinalScoreInt = scoreInt;
					curPlayer = 2;
					playerLabel.setBounds(35,0,400,40);
					playerLabel.setText("PLAYER TWO'S TURN");
				}
				else {
					playerTwoFinalScoreInt = scoreInt;
					contentPane.removeAll();
					
					playerOneFinalScore = "Player One Score = " + Integer.toString(playerOneFinalScoreInt);
					playerTwoFinalScore = "Player Two Score = " + Integer.toString(playerTwoFinalScoreInt);
					
					JLabel playerOneFinal = new JLabel();
					JLabel playerTwoFinal = new JLabel();
					playerOneFinal.setText(playerOneFinalScore);
					playerTwoFinal.setText(playerTwoFinalScore);
					playerOneFinal.setBounds(100, 0, 1000, 100);
					playerTwoFinal.setBounds(100, 100, 1000, 100);
					playerOneFinal.setFont(new Font("Tahoma", Font.BOLD, 45));
					playerTwoFinal.setFont(new Font("Tahoma", Font.BOLD, 45));
					
					JLabel finalLabel = new JLabel();
					finalLabel.setFont(new Font("Tahoma", Font.BOLD, 60));
					finalLabel.setBounds(200, 400, 800, 200);
					if (playerOneFinalScoreInt>playerTwoFinalScoreInt){
						finalLabel.setText("PLAYER ONE WINS");
					}
					else {
						if (playerOneFinalScoreInt<playerTwoFinalScoreInt){
							finalLabel.setText("PLAYER TWO WINS");
						}
						else{
							finalLabel.setText("IT'S A TIE");
						}
					}
					
					contentPane.add(playerOneFinal);
					contentPane.add(playerTwoFinal);
					contentPane.add(finalLabel);
				}
			}
		});
		scorePanel.add(finish);
		
	}
	
	public JButton charButtons(int e, String string) {
		final JButton theButton = new JButton();
		int f=0;
		int g=0;
		
		f=e%7;
		g=e/7;
		theButton.setLayout(null);
		theButton.setBounds(f*50,g*50,50,50);
		theButton.setText(string);
		theButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (curLetterString==""){
				int otherBoundsX = theButton.getX()/50;
				int otherBoundsY = theButton.getY()/50;
				curLetterString=arg0.getActionCommand();
				curLetterLabelString.setText(curLetterString);
				theButton.setText("");
				nullers[otherBoundsX][otherBoundsY]="Good";
				contentPane.repaint();
				}
				else {
					if (theButton.getText()==""){
						theButton.setText(curLetterString);
						curLetterLabelString.setText("");
						curLetterString="";
					}
				}
			}
		});
		
		return theButton;
		
		
	}
	
	
	public JButton charButtonsNew(int e, String stringy) {
		final JButton theButton = new JButton();
		int f=0;
		int g=0;
		
		f=e%7;
		g=e/7;
		theButton.setLayout(null);
		theButton.setBounds(f*50,g*50,50,50);
		theButton.setText(stringy);
		theButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (curLetterString==""){
					int otherBoundsX = theButton.getX()/50;
					int otherBoundsY = theButton.getY()/50;
					curLetterString=arg0.getActionCommand();
					curLetterLabelString.setText(curLetterString);
					theButton.setText("");
					nullers[otherBoundsX][otherBoundsY]="Good";
					contentPane.repaint();
				}
				else {
					if (theButton.getText()==""){
						theButton.setText(curLetterString);
						curLetterLabelString.setText("");
						curLetterString="";
					}
				}
			}
		});
		
		return theButton;
		
		
	}

	public JButton mainButtons (int j){
		final JButton theButton = new JButton();
		int f=0;
		int g=0;
		
		f=j%13;
		g=j/13;
		theButton.setLayout(null);
		theButton.setBounds(f*50,g*50,50,50);
		theButton.setText("");
		theButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int boundsX = theButton.getX();
				int boundsY = theButton.getY();
				if (theButton.getText().equals("")){
					theButton.setText(curLetterString);
					theFinalArray[boundsX/50][boundsY/50]=curLetterString;
					curLetterString="";
					curLetterLabelString.setText("");
				}
				else{
						theFinalArray[boundsX/50][boundsY/50]=null;
						theButton.setText("");
						for (int a=0; a<20; a++){
							for (int b=0; b<20; b++){
								if (nullers[a][b]!=null){
									Component newComp = charPanel.getComponentAt(a*50, b*50);
									((AbstractButton) newComp).setText(arg0.getActionCommand());
									nullers[a][b]=null;
									a=20;
									b=20;
								}
							}
						}
				}
				contentPane.repaint();
			}
		});
		
		return theButton;
	}

	void setPlayingPanel (JPanel panul){
		panul.setLayout(null);
		panul.setBounds(0,0,700,700);
		for (int i = 0; i<169; i++){
			panul.add(mainButtons(i));
		}
		
		contentPane.add(panul);
	}
}
