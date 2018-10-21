package gomuku;

public class BoardPoint {
	protected int row;
	protected int col;
	
	BoardPoint(int r, int c){
		setPoint(r,c);
	}
	
	BoardPoint(BoardPoint bp){
		this.row = bp.row;
		this.col = bp.col;
	}
	
	public void setNullPoint(){
		setPoint(-1,-1);
	}
	
	public void setPoint(int r, int c){
		row = r;
		col = c;
	}
	
	public boolean isNullPoint(){
		return row == -1;
	}
	
}
