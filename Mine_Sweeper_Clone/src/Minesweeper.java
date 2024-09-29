import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Minesweeper implements ActionListener{
	JFrame frame;
	JPanel textPanel;
	JPanel buttonPanel;
	JButton[][] buttons;
	JLabel textfield;
	Random random;
	int size , bombs; 
	ArrayList<Integer> xPositions;
	ArrayList<Integer> yPositions;
	public Minesweeper() {
		xPositions = new ArrayList<Integer>();
		yPositions = new ArrayList<Integer>();
		size = 9;
		bombs = 10;
		
		random = new Random();
		for(int i = 0; i < bombs; i++) {
			xPositions.add(random.nextInt(size));
			yPositions.add(random.nextInt(size));
		}
		
		for(int i = 0; i < bombs; i++) {
			for(int j = i + 1; j < bombs; j++) {
				if(xPositions.get(i) == xPositions.get(j) && yPositions.get(i) == yPositions.get(j)) {
					xPositions.set(j, random.nextInt(size));
					yPositions.set(j, random.nextInt(size));
					i = 0;
					j = 0;
				}
			}
		}
		
		for(int i = 0; i < bombs; i++) {
			System.out.println("xPosition of "+i+" is "+xPositions.get(i));
			System.out.println("yPosition of "+i+" is "+yPositions.get(i));
		}
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		
		textPanel = new JPanel();
		textPanel.setVisible(true);
		textPanel.setBackground(Color.BLACK);
		
		buttonPanel = new JPanel();
		buttonPanel.setVisible(true);
		buttonPanel.setLayout(new GridLayout());
		
		textfield = new JLabel();
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setFont(new Font("MV Boli", Font.BOLD, 12));
		textfield.setForeground(Color.BLUE);
		textfield.setText(bombs+"Bombs");
		
		buttons = new JButton[size][size];
		for(int i = 0; i < buttons.length; i++) {
			for(int j = 0; j < buttons[0].length; j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].setFocusable(false);
				buttons[i][j].setFont(new Font("MV Boli", Font.BOLD, 12));
				buttons[i][j].addActionListener(this);
				buttons[i][j].setText("");
				buttonPanel.add(buttons[i][j]);
			}
		}
		
		textPanel.add(textfield);
		frame.add(textPanel, BorderLayout.NORTH);
		frame.add(buttonPanel);
		frame.setSize(570, 570);
		frame.revalidate();
		frame.setLocationRelativeTo(null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0; i < buttons.length; i++) {
			for(int j = 0; j < buttons[0].length; j++) {
				if(e.getSource() == buttons[i][j]) {
					System.out.println("Clicked!");
				}
			}
		}
	}
}
