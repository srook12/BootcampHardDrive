package magicsquare;

public class MagicSquareTest {

	public static void main(String[] args) {
		for(int dim = 3; dim <= 5; dim +=2 ) {	
			MagicSquare magicSquare = new MagicSquare(dim);
			System.out.println(magicSquare);
			magicSquare.checkSquare();			
		}
	}
}
