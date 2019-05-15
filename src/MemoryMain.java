import java.util.Scanner;

public class MemoryMain {
	private static MemoryGame[][] cards = new MemoryGame[4][4];
	
	 public static void main(String[] args) {
		
		
	    cards[0][0]= new MemoryGame('E');
	    cards[0][1]= new MemoryGame('A');
	    cards[0][2]= new MemoryGame('B');
	    cards[0][3]= new MemoryGame('F');
	    cards[1][0]= new MemoryGame('G');
	    cards[1][1]= new MemoryGame('A');
	    cards[1][2]= new MemoryGame('D');
	    cards[1][3]= new MemoryGame('H');
	    cards[2][0]= new MemoryGame('F');
	    cards[2][1]= new MemoryGame('C');
	    cards[2][2]= new MemoryGame('D');
	    cards[2][3]= new MemoryGame('H');
	    cards[3][0]= new MemoryGame('E');
	    cards[3][1]= new MemoryGame('G');
	    cards[3][2]= new MemoryGame('B');
	    cards[3][3]= new MemoryGame('C');
	    
         while(TheGameIsOver()==false ) {
        	 GameBoard();
        	 Guess();
         }

	    
	}
	public static void Guess() {
		
		 Scanner scanner = new Scanner(System.in);
		 
		 System.out.println("Ilk tahminin satir ve sutun degerlerini giriniz (0-4 arasi)..");
		 int i1=scanner.nextInt();
		 int j1=scanner.nextInt();
		 
		 cards[i1][j1].setGuess(true);
		 GameBoard();
		 
		 System.out.println("Ikinci tahminin satir ve sutun degerlerini giriniz (0-4 arasi)..");
		 int i2=scanner.nextInt();
		 int j2=scanner.nextInt();
		 cards[i2][j2].setGuess(true);
		 GameBoard();
		 
		 if(cards[i1][j1].getValue()==cards[i2][j2].getValue()) {
			 
			 // cards[i2][j2].setGuess(true);
			 System.out.println("Tebrikler bildiniz.");
			 
		 }
		 else {
			 cards[i1][j1].setGuess(false);
			 cards[i2][j2].setGuess(false);
			 System.out.println("Tekrar deneyiniz.");
		 }
		 
		
	}
	 
	 
	public static boolean TheGameIsOver() {
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				if(cards[i][j].isGuess()==false)
					return false;
			}
			
		}
		
		return true;
	}
	 
	 
	 
	public static void GameBoard() {
		
		  for(int i=0; i<4; i++) {
			  System.out.println("...........................");
			  for(int j=0; j<4; j++) {
				  
				  if(cards[i][j].isGuess()) {
					  System.out.print("|"+ cards[i][j].getValue() + "|");
				  }
				  else {
					  System.out.print(" | | ");
				  }
			  }
			  System.out.println("");
		  }
		  System.out.println("...........................");
	}
	
	
}
