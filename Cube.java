

public class Cube {
	char [][] red = new char[3][3];
	char [][] yellow = new char[3][3];
	char [][] blue = new char[3][3];
	char [][] green = new char[3][3];
	char [][] white = new char[3][3];
	char [][] orange = new char[3][3];
	
	public Cube() {
		assign(red, 'R');
		assign(blue, 'B');
		assign(green, 'G');
		assign(yellow, 'Y');
		assign(orange, 'O');
		assign(white, 'W');
	}

	public int assign(char[][] face, char color) {
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j){
				face[i][j] = color;
			}
		}
		return 0;
	}

	public char[][] face(char a) {
		if(a == 'R')
			return red;
		if(a == 'B')
			return blue;
		if(a == 'G')
			return green;
		if(a == 'Y')
			return yellow;
		if(a == 'O')
			return orange;
		if(a == 'W')
			return white;
		return white;
	}
	
	public void shuffle() {
		int shuffles = (int)(Math.random()*10)+50;
		int axis;
		int row_col;
		
		for (int i = 0; i < shuffles; ++i) {
			axis = (int)(Math.random()*2)+1;
			row_col = (int)(Math.random()*3)+1;
			if(axis == 1)
				rotate(1, row_col, 1);
			else
				rotate(2, row_col, 1);
		}
	}
	
	public char[][] clockwise(char[][] face, int rotations) {
		char[] tempA = new char[2]; 
		
		for (int i = 0; i < rotations; ++i) 
		{
			tempA[0]   = face[0][0];
			tempA[1]   = face[0][1];
			face[0][0] = face[2][0];
			face[0][1] = face[1][0];
			face[2][0] = face[2][2];
			face[1][0] = face[2][1];
			face[2][2] = face[0][2];
			face[2][1] = face[1][2];
			face[0][2] = tempA[0];
			face[1][2] = tempA[1];
		}
		return face;
	}
	
	public void turn(int hor_ver, int rotations) 
	{
			rotate(hor_ver, 1, rotations);
			rotate(hor_ver, 2, rotations);
			rotate(hor_ver, 3, rotations);
	}
	
	public void rotate(int ver_hor, int row_col, int rotations) {
		for (int i = 0; i < rotations; ++i) {
				if(ver_hor == 1) {
					//horizontal rotation algorythm
					char []tempA;
					tempA = blue[row_col -1];
					blue[row_col -1] = red[row_col -1];
					red[row_col -1] = green[row_col -1];
					green[row_col -1] = orange[row_col -1];
					orange[row_col -1] = tempA;
					
					if(row_col == 1)
						white = clockwise(white, 3);
					if(row_col == 3) 
						yellow = clockwise(yellow, 1);
	
				}
				else {
					char []tempA = {yellow[0][row_col -1], yellow[1][row_col -1], yellow[2][row_col -1]};
					yellow[0][row_col -1] = green[0][row_col -1];
					yellow[1][row_col -1] = green[1][row_col -1];
					yellow[2][row_col -1] = green[2][row_col -1];
					
					green[0][row_col -1] = white[0][row_col -1];
					green[1][row_col -1] = white[1][row_col -1];
					green[2][row_col -1] = white[2][row_col -1];
					
					white[0][row_col -1] = blue[0][row_col -1];
					white[1][row_col -1] = blue[1][row_col -1];
					white[2][row_col -1] = blue[2][row_col -1];
					
					blue[0][row_col-1] = tempA[0];
					blue[1][row_col-1] = tempA[1];
					blue[2][row_col-1] = tempA[2];
					
					if(row_col == 1)
						orange = clockwise(orange, 1);
					if(row_col == 3) 
						blue = clockwise(blue, 3);
				}
		}	
	}
}