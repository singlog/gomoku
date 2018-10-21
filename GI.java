package gomuku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GI {
	JFrame mainFrame;
	JPanel menuBar;
	JButton menu;
	Board board;
	JButton newGame;
	LayoutManager mainLayout;
	Main main;
	
	GI(Board b, Main main){
		board = b;
		this.main = main;
		init();
	}
	
	protected void init(){
		
		mainFrame = new JFrame();
		mainFrame.setSize(1500,1600);
		mainFrame.setLocation(900,100);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = mainFrame.getContentPane();		
		mainLayout = new GridLayout(5,8);
		container.setLayout(mainLayout);
		
		newGame = new JButton("New Game");
		newGame.addActionListener(main);
		
		container.add(newGame);
		container.add(board.getPanel());
		
		mainFrame.setVisible(true);
	}
	
	protected void start_session(){
		newGame.setVisible(false);
		newGame.setEnabled(false);
		
		Container container = mainFrame.getContentPane();
		container.remove(newGame);
		
		/*
		menuBar = new JPanel();
		menuBar.setBackground(new Color(240,172,240));
		menuBar.setPreferredSize(new Dimension(1500,100));
		
		menu = new JButton("Menu");
		menuBar.add(menu);
		
		container.add(menuBar, BorderLayout.PAGE_START);	
		container.add(board.getPanel(), BorderLayout.CENTER);
		*/
	}
}
