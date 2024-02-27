public class Display {

	public void render(Cube cube) {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		for (int i = 0; i < 3; ++i) {
			System.out.print("       ");
			for (int j = 0; j < 3; ++j) {
				System.out.print(" " + cube.face('W')[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				System.out.print(" " + cube.face('O')[i][j]);
			}
			System.out.print("|");

			for (int j = 0; j < 3; ++j) {
				System.out.print(" " + cube.face('G')[i][j]);
			}
			System.out.print("|");

			for (int j = 0; j < 3; ++j) {
				System.out.print(" " + cube.face('R')[i][j]);
			}
			System.out.print("|");

			for (int j = 0; j < 3; ++j) {
				System.out.print(" " + cube.face('B')[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		for (int i = 0; i < 3; ++i) {
			System.out.print("       ");
			for (int j = 0; j < 3; ++j) {
				System.out.print(" " + cube.face('Y')[i][j]);
			}
			System.out.println();
		}
		System.out.println("\n\n");
		
		
		
	}
}