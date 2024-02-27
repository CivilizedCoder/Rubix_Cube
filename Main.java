import java.util.Scanner;
public class Main {
	public static void main(String [] args) {
		Main m = new Main();
		m.go();
	}
	
	public void go() {
		Cube cube = new Cube();
		Display screen = new Display();
		play(cube, screen);
	}
	
	public void play(Cube cube, Display screen) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Gamemode options:\n1 = freeplay\n2 = solve");
		int gameMode = scan.nextInt();
		boolean unsolved = false;
		
		if(gameMode == 2){
			cube.shuffle();
			unsolved = true;
		}
		
		int rot;
		int row_col;
		
		
		
		while(unsolved || gameMode != 2) {
			screen.render(cube);
			System.out.println("Horizontal = 1 \nVertical = 2\nRotating across axis: ");
			rot = scan.nextInt();
			if (rot == 1)
				System.out.print("(Enter 0 to turn the entire cube)\nAcross row 1-3: ");
			else
				System.out.println("(Enter 0 to turn the entire cube) \nAcross column 1-3");
			row_col = scan.nextInt();
			if(row_col != 0)
				cube.rotate(rot, row_col, 1);
			else {
				cube.rotate(rot, 1, 1);
				cube.rotate(rot, 2, 1);
				cube.rotate(rot, 3, 1);
			}
	
		}
		
	}
		
		
}