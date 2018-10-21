package gomuku;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Board{
	private JPanel panel;
	private BoardPoint selected;
	private JButton[] points;
	
	Board(){
		panel = new JPanel();
		panel.setLayout(new GridLayout(15,15));
		points = new JButton[255];
		
		selected = new BoardPoint(-1,-1);
		for(int i = 0; i < 15; i++){
			for(int j = 0; j < 15; j++){
				int index = (i+1) * (j+1) - 1;
				points[index] = new JButton();
				points[index].addActionListener(new PointListener(i,j));
				
				panel.add(points[index]);
			}
			
		}
	}
	
	public void enable(){
		panel.setEnabled(true);
	}
	
	public void disable(){
		panel.setEnabled(false);
	}
	
	public void displayMove(BoardPoint p, int color){
		int index = (p.row + 1) * (p.col + 1) - 1;
		Color c = color == 0 ? Color.BLACK : Color.WHITE;  
		points[index].setBackground(c);
	}
	
	public BoardPoint getMyMove(){
		synchronized(selected){
			try {
				selected.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			BoardPoint mymove = new BoardPoint(selected);
			return mymove;
		}
	}
	
	public JPanel getPanel(){
		return panel;
	}
	
	
	class PointListener implements ActionListener{
		int row;
		int col;
		
		PointListener(int r, int c){
			row = r;
			col = c;
		}
		
		public void actionPerformed(ActionEvent e) {
			synchronized(selected){
				selected.setPoint(row, col);
				System.out.println(selected.row);
				selected.notify();
			}
		}
	}

	
	
}
