import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Connect4 implements ActionListener{
	
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[42];
	boolean player1_turn;
	
	Connect4(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(840,840);
		frame.getContentPane().setBackground(new Color(100,100,100));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,150,100));
		textfield.setFont(new Font("Ink Free", Font.BOLD,80));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,840,120);
		
		button_panel.setLayout(new GridLayout(6,7));
		button_panel.setBackground(new Color(150,150,150));
		
		for (int i = 0; i < 42; i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD, 40));
			buttons[i].setFocusable(false);
			buttons[i].setEnabled(false);
			buttons[i].addActionListener(this);
		}
		
		for (int x = 35; x < 42; x++) {
			buttons[x].setEnabled(true);
		}
		
		title_panel.add(textfield);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstTurn();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		for (int i = 0; i < 42; i++) {
			if (e.getSource()==buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText()=="") {
							buttons[i].setForeground(new Color(255,0,0));
							buttons[i].setText("0");
							player1_turn=false;
							textfield.setText("Player 2's turn");
							check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						player1_turn=true;
						textfield.setText("Player 1's turn");
						check();
					}
				}
				enabler();
			}
		}
	}
	
	public void firstTurn() {
		
		if(random.nextInt(2)==0) {
			player1_turn = true;
			textfield.setText("Player 1's turn");
		}
		else {
			player1_turn = false;
			textfield.setText("Player 2's turn");
		}
	}
	
	public void enabler() {
		int col1 = 35;
		int col2 = 36;
		int col3 = 37;
		int col4 = 38;
		int col5 = 39;
		int col6 = 40;
		int col7 = 41;
		
		
		while(buttons[col1].getText()=="O" || buttons[col1].getText()=="0") {
			col1 -= 7;
			if (col1 < 0) {
				break;
			}
			else {
				buttons[col1].setEnabled(true);
			}
		}
		
		while(buttons[col2].getText()=="O" || buttons[col2].getText()=="0") {
			col2 -= 7;
			if (col2 < 0) {
				break;
			}
			else {
				buttons[col2].setEnabled(true);
			}
		}
		
		while(buttons[col3].getText()=="O" || buttons[col3].getText()=="0") {
			col3 -= 7;
			if (col3 < 0) {
				break;
			}
			else {
				buttons[col3].setEnabled(true);
			}
		}
		
		while(buttons[col4].getText()=="O" || buttons[col4].getText()=="0") {
			col4 -= 7;
			if (col4 < 0) {
				break;
			}
			else {
				buttons[col4].setEnabled(true);
			}
		}
		
		while(buttons[col5].getText()=="O" || buttons[col5].getText()=="0") {
			col5 -= 7;
			if (col5 < 0) {
				break;
			}
			else {
				buttons[col5].setEnabled(true);
			}
		}
		
		while(buttons[col6].getText()=="O" || buttons[col6].getText()=="0") {
			col6 -= 7;
			if (col6 < 0) {
				break;
			}
			else {
				buttons[col6].setEnabled(true);
			}
		}
		
		while(buttons[col7].getText()=="O" || buttons[col7].getText()=="0") {
			col7 -= 7;
			if (col7 < 0) {
				break;
			}
			else {
				buttons[col7].setEnabled(true);
			}
		}
	}
	
	public void check() {
		
		if ((buttons[35].getText()=="0") &&
				(buttons[28].getText()=="0") &&
				(buttons[21].getText()=="0") &&
				(buttons[14].getText()=="0")) {
			player1Wins(35,28,21,14);
		}
		
		if ((buttons[28].getText()=="0") &&
				(buttons[21].getText()=="0") &&
				(buttons[14].getText()=="0") &&
				(buttons[7].getText()=="0")) {
			player1Wins(28,21,14,7);
		}
		
		if ((buttons[21].getText()=="0") &&
				(buttons[14].getText()=="0") &&
				(buttons[7].getText()=="0") &&
				(buttons[0].getText()=="0")) {
			player1Wins(21,14,7,0);
		}
		
		if ((buttons[36].getText()=="0") &&
				(buttons[29].getText()=="0") &&
				(buttons[22].getText()=="0") &&
				(buttons[15].getText()=="0")) {
			player1Wins(36,29,22,15);
		}
		
		if ((buttons[29].getText()=="0") &&
				(buttons[22].getText()=="0") &&
				(buttons[15].getText()=="0") &&
				(buttons[8].getText()=="0")) {
			player1Wins(29,22,15,8);
		}
		
		if ((buttons[22].getText()=="0") &&
				(buttons[15].getText()=="0") &&
				(buttons[8].getText()=="0") &&
				(buttons[1].getText()=="0")) {
			player1Wins(22,15,8,1);
		}
		
		if ((buttons[37].getText()=="0") &&
				(buttons[30].getText()=="0") &&
				(buttons[23].getText()=="0") &&
				(buttons[16].getText()=="0")) {
			player1Wins(37,30,23,16);
		}
		
		if ((buttons[30].getText()=="0") &&
				(buttons[23].getText()=="0") &&
				(buttons[16].getText()=="0") &&
				(buttons[9].getText()=="0")) {
			player1Wins(30,23,16,9);
		}
		
		if ((buttons[23].getText()=="0") &&
				(buttons[16].getText()=="0") &&
				(buttons[9].getText()=="0") &&
				(buttons[2].getText()=="0")) {
			player1Wins(23,16,9,2);
		}
		
		if ((buttons[38].getText()=="0") &&
				(buttons[31].getText()=="0") &&
				(buttons[24].getText()=="0") &&
				(buttons[17].getText()=="0")) {
			player1Wins(38,31,24,17);
		}
		
		if ((buttons[31].getText()=="0") &&
				(buttons[24].getText()=="0") &&
				(buttons[17].getText()=="0") &&
				(buttons[10].getText()=="0")) {
			player1Wins(31,24,17,10);
		}
		
		if ((buttons[24].getText()=="0") &&
				(buttons[17].getText()=="0") &&
				(buttons[10].getText()=="0") &&
				(buttons[3].getText()=="0")) {
			player1Wins(24,17,10,3);
		}
		
		if ((buttons[39].getText()=="0") &&
				(buttons[32].getText()=="0") &&
				(buttons[25].getText()=="0") &&
				(buttons[18].getText()=="0")) {
			player1Wins(39,32,25,18);
		}
		
		if ((buttons[32].getText()=="0") &&
				(buttons[25].getText()=="0") &&
				(buttons[18].getText()=="0") &&
				(buttons[11].getText()=="0")) {
			player1Wins(32,25,18,11);
		}
		
		if ((buttons[25].getText()=="0") &&
				(buttons[18].getText()=="0") &&
				(buttons[11].getText()=="0") &&
				(buttons[4].getText()=="0")) {
			player1Wins(25,18,11,4);
		}
		
		if ((buttons[40].getText()=="0") &&
				(buttons[33].getText()=="0") &&
				(buttons[26].getText()=="0") &&
				(buttons[19].getText()=="0")) {
			player1Wins(40,33,26,19);
		}
		
		if ((buttons[33].getText()=="0") &&
				(buttons[26].getText()=="0") &&
				(buttons[19].getText()=="0") &&
				(buttons[12].getText()=="0")) {
			player1Wins(33,26,19,12);
		}
		
		if ((buttons[26].getText()=="0") &&
				(buttons[19].getText()=="0") &&
				(buttons[12].getText()=="0") &&
				(buttons[5].getText()=="0")) {
			player1Wins(26,19,12,5);
		}
		
		if ((buttons[41].getText()=="0") &&
				(buttons[34].getText()=="0") &&
				(buttons[27].getText()=="0") &&
				(buttons[20].getText()=="0")) {
			player1Wins(41,34,27,20);
		}
		
		if ((buttons[34].getText()=="0") &&
				(buttons[27].getText()=="0") &&
				(buttons[20].getText()=="0") &&
				(buttons[13].getText()=="0")) {
			player1Wins(34,27,20,13);
		}
		
		if ((buttons[27].getText()=="0") &&
				(buttons[20].getText()=="0") &&
				(buttons[13].getText()=="0") &&
				(buttons[6].getText()=="0")) {
			player1Wins(27,20,13,6);
		}
		
		// Player 1 Vertical checks done
		
		if ((buttons[35].getText()=="0") &&
				(buttons[36].getText()=="0") &&
				(buttons[37].getText()=="0") &&
				(buttons[38].getText()=="0")) {
			player1Wins(35,36,37,38);
		}
		
		if ((buttons[36].getText()=="0") &&
				(buttons[37].getText()=="0") &&
				(buttons[38].getText()=="0") &&
				(buttons[39].getText()=="0")) {
			player1Wins(36,37,38,39);
		}
		
		if ((buttons[37].getText()=="0") &&
				(buttons[38].getText()=="0") &&
				(buttons[39].getText()=="0") &&
				(buttons[40].getText()=="0")) {
			player1Wins(37,38,39,40);
		}
		
		if ((buttons[38].getText()=="0") &&
				(buttons[39].getText()=="0") &&
				(buttons[40].getText()=="0") &&
				(buttons[41].getText()=="0")) {
			player1Wins(38,39,40,41);
		}
		
		if ((buttons[28].getText()=="0") &&
				(buttons[29].getText()=="0") &&
				(buttons[30].getText()=="0") &&
				(buttons[31].getText()=="0")) {
			player1Wins(28,29,30,31);
		}
		
		if ((buttons[29].getText()=="0") &&
				(buttons[30].getText()=="0") &&
				(buttons[31].getText()=="0") &&
				(buttons[32].getText()=="0")) {
			player1Wins(29,30,31,32);
		}
		
		if ((buttons[30].getText()=="0") &&
				(buttons[31].getText()=="0") &&
				(buttons[32].getText()=="0") &&
				(buttons[33].getText()=="0")) {
			player1Wins(30,31,32,33);
		}
		
		if ((buttons[31].getText()=="0") &&
				(buttons[32].getText()=="0") &&
				(buttons[33].getText()=="0") &&
				(buttons[34].getText()=="0")) {
			player1Wins(31,32,33,34);
		}
		
		if ((buttons[21].getText()=="0") &&
				(buttons[22].getText()=="0") &&
				(buttons[23].getText()=="0") &&
				(buttons[24].getText()=="0")) {
			player1Wins(21,22,23,24);
		}
		
		if ((buttons[22].getText()=="0") &&
				(buttons[23].getText()=="0") &&
				(buttons[24].getText()=="0") &&
				(buttons[25].getText()=="0")) {
			player1Wins(22,23,24,25);
		}
		
		if ((buttons[23].getText()=="0") &&
				(buttons[24].getText()=="0") &&
				(buttons[25].getText()=="0") &&
				(buttons[26].getText()=="0")) {
			player1Wins(23,24,25,26);
		}
		
		if ((buttons[24].getText()=="0") &&
				(buttons[25].getText()=="0") &&
				(buttons[26].getText()=="0") &&
				(buttons[27].getText()=="0")) {
			player1Wins(24,25,26,27);
		}
		
		if ((buttons[14].getText()=="0") &&
				(buttons[15].getText()=="0") &&
				(buttons[16].getText()=="0") &&
				(buttons[17].getText()=="0")) {
			player1Wins(14,15,16,17);
		}
		
		if ((buttons[15].getText()=="0") &&
				(buttons[16].getText()=="0") &&
				(buttons[17].getText()=="0") &&
				(buttons[18].getText()=="0")) {
			player1Wins(15,16,17,18);
		}
		
		if ((buttons[16].getText()=="0") &&
				(buttons[17].getText()=="0") &&
				(buttons[18].getText()=="0") &&
				(buttons[19].getText()=="0")) {
			player1Wins(16,17,18,19);
		}
		
		if ((buttons[17].getText()=="0") &&
				(buttons[18].getText()=="0") &&
				(buttons[19].getText()=="0") &&
				(buttons[20].getText()=="0")) {
			player1Wins(17,18,19,20);
		}
		
		if ((buttons[7].getText()=="0") &&
				(buttons[8].getText()=="0") &&
				(buttons[9].getText()=="0") &&
				(buttons[10].getText()=="0")) {
			player1Wins(7,8,9,10);
		}
		
		if ((buttons[8].getText()=="0") &&
				(buttons[9].getText()=="0") &&
				(buttons[10].getText()=="0") &&
				(buttons[11].getText()=="0")) {
			player1Wins(8,9,10,11);
		}
		
		if ((buttons[9].getText()=="0") &&
				(buttons[10].getText()=="0") &&
				(buttons[11].getText()=="0") &&
				(buttons[12].getText()=="0")) {
			player1Wins(9,10,11,12);
		}
		
		if ((buttons[10].getText()=="0") &&
				(buttons[11].getText()=="0") &&
				(buttons[12].getText()=="0") &&
				(buttons[13].getText()=="0")) {
			player1Wins(10,11,12,13);
		}
		
		if ((buttons[0].getText()=="0") &&
				(buttons[1].getText()=="0") &&
				(buttons[2].getText()=="0") &&
				(buttons[3].getText()=="0")) {
			player1Wins(0,1,2,3);
		}
		
		if ((buttons[1].getText()=="0") &&
				(buttons[2].getText()=="0") &&
				(buttons[3].getText()=="0") &&
				(buttons[4].getText()=="0")) {
			player1Wins(1,2,3,4);
		}
		
		if ((buttons[2].getText()=="0") &&
				(buttons[3].getText()=="0") &&
				(buttons[4].getText()=="0") &&
				(buttons[5].getText()=="0")) {
			player1Wins(2,3,4,5);
		}
		
		if ((buttons[3].getText()=="0") &&
				(buttons[4].getText()=="0") &&
				(buttons[5].getText()=="0") &&
				(buttons[6].getText()=="0")) {
			player1Wins(3,4,5,6);
		}
		
		// Player 1 Horizontal checks done
		
		if ((buttons[35].getText()=="0") &&
				(buttons[29].getText()=="0") &&
				(buttons[23].getText()=="0") &&
				(buttons[17].getText()=="0")) {
			player1Wins(35,29,23,17);
		}
		
		if ((buttons[28].getText()=="0") &&
				(buttons[22].getText()=="0") &&
				(buttons[16].getText()=="0") &&
				(buttons[10].getText()=="0")) {
			player1Wins(28,22,16,10);
		}
		
		if ((buttons[21].getText()=="0") &&
				(buttons[15].getText()=="0") &&
				(buttons[9].getText()=="0") &&
				(buttons[3].getText()=="0")) {
			player1Wins(21,15,9,3);
		}
		
		if ((buttons[36].getText()=="0") &&
				(buttons[30].getText()=="0") &&
				(buttons[24].getText()=="0") &&
				(buttons[18].getText()=="0")) {
			player1Wins(36,30,24,18);
		}
		
		if ((buttons[29].getText()=="0") &&
				(buttons[23].getText()=="0") &&
				(buttons[17].getText()=="0") &&
				(buttons[11].getText()=="0")) {
			player1Wins(29,23,17,11);
		}
		
		if ((buttons[22].getText()=="0") &&
				(buttons[16].getText()=="0") &&
				(buttons[10].getText()=="0") &&
				(buttons[4].getText()=="0")) {
			player1Wins(22,16,10,4);
		}
		
		if ((buttons[37].getText()=="0") &&
				(buttons[31].getText()=="0") &&
				(buttons[25].getText()=="0") &&
				(buttons[19].getText()=="0")) {
			player1Wins(37,31,25,19);
		}
		
		if ((buttons[30].getText()=="0") &&
				(buttons[24].getText()=="0") &&
				(buttons[18].getText()=="0") &&
				(buttons[12].getText()=="0")) {
			player1Wins(30,24,18,12);
		}
		
		if ((buttons[23].getText()=="0") &&
				(buttons[17].getText()=="0") &&
				(buttons[11].getText()=="0") &&
				(buttons[5].getText()=="0")) {
			player1Wins(23,17,11,5);
		}
		
		if ((buttons[38].getText()=="0") &&
				(buttons[32].getText()=="0") &&
				(buttons[26].getText()=="0") &&
				(buttons[20].getText()=="0")) {
			player1Wins(38,32,26,20);
		}
		
		if ((buttons[31].getText()=="0") &&
				(buttons[25].getText()=="0") &&
				(buttons[19].getText()=="0") &&
				(buttons[13].getText()=="0")) {
			player1Wins(31,25,19,13);
		}
		
		if ((buttons[24].getText()=="0") &&
				(buttons[18].getText()=="0") &&
				(buttons[12].getText()=="0") &&
				(buttons[6].getText()=="0")) {
			player1Wins(24,18,12,6);
		}
		
		if ((buttons[41].getText()=="0") &&
				(buttons[33].getText()=="0") &&
				(buttons[25].getText()=="0") &&
				(buttons[17].getText()=="0")) {
			player1Wins(41,33,25,17);
		}
		
		if ((buttons[34].getText()=="0") &&
				(buttons[26].getText()=="0") &&
				(buttons[18].getText()=="0") &&
				(buttons[10].getText()=="0")) {
			player1Wins(34,26,18,10);
		}
		
		if ((buttons[27].getText()=="0") &&
				(buttons[19].getText()=="0") &&
				(buttons[11].getText()=="0") &&
				(buttons[3].getText()=="0")) {
			player1Wins(27,19,11,3);
		}
		
		if ((buttons[40].getText()=="0") &&
				(buttons[32].getText()=="0") &&
				(buttons[24].getText()=="0") &&
				(buttons[16].getText()=="0")) {
			player1Wins(40,32,24,16);
		}
		
		if ((buttons[33].getText()=="0") &&
				(buttons[25].getText()=="0") &&
				(buttons[17].getText()=="0") &&
				(buttons[9].getText()=="0")) {
			player1Wins(33,25,17,9);
		}
		
		if ((buttons[26].getText()=="0") &&
				(buttons[18].getText()=="0") &&
				(buttons[10].getText()=="0") &&
				(buttons[2].getText()=="0")) {
			player1Wins(26,18,10,2);
		}
		
		if ((buttons[39].getText()=="0") &&
				(buttons[31].getText()=="0") &&
				(buttons[23].getText()=="0") &&
				(buttons[15].getText()=="0")) {
			player1Wins(39,31,23,15);
		}
		
		if ((buttons[32].getText()=="0") &&
				(buttons[24].getText()=="0") &&
				(buttons[16].getText()=="0") &&
				(buttons[8].getText()=="0")) {
			player1Wins(32,24,16,8);
		}
		
		if ((buttons[25].getText()=="0") &&
				(buttons[17].getText()=="0") &&
				(buttons[9].getText()=="0") &&
				(buttons[1].getText()=="0")) {
			player1Wins(25,17,9,1);
		}
		
		if ((buttons[38].getText()=="0") &&
				(buttons[30].getText()=="0") &&
				(buttons[22].getText()=="0") &&
				(buttons[14].getText()=="0")) {
			player1Wins(38,30,22,14);
		}
		
		if ((buttons[31].getText()=="0") &&
				(buttons[23].getText()=="0") &&
				(buttons[15].getText()=="0") &&
				(buttons[7].getText()=="0")) {
			player1Wins(31,23,15,7);
		}
		
		if ((buttons[24].getText()=="0") &&
				(buttons[16].getText()=="0") &&
				(buttons[8].getText()=="0") &&
				(buttons[0].getText()=="0")) {
			player1Wins(24,16,8,0);
		}
		
		// Player 1 Diagonal checks done
		
		//--------------------------------------------------------------------------------------------------------------------------
		
		if ((buttons[35].getText()=="O") &&
				(buttons[28].getText()=="O") &&
				(buttons[21].getText()=="O") &&
				(buttons[14].getText()=="O")) {
			player2Wins(35,28,21,14);
		}
		
		if ((buttons[28].getText()=="O") &&
				(buttons[21].getText()=="O") &&
				(buttons[14].getText()=="O") &&
				(buttons[7].getText()=="O")) {
			player2Wins(28,21,14,7);
		}
		
		if ((buttons[21].getText()=="O") &&
				(buttons[14].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[0].getText()=="O")) {
			player2Wins(21,14,7,0);
		}
		
		if ((buttons[36].getText()=="O") &&
				(buttons[29].getText()=="O") &&
				(buttons[22].getText()=="O") &&
				(buttons[15].getText()=="O")) {
			player2Wins(36,29,22,15);
		}
		
		if ((buttons[29].getText()=="O") &&
				(buttons[22].getText()=="O") &&
				(buttons[15].getText()=="O") &&
				(buttons[8].getText()=="O")) {
			player2Wins(29,22,15,8);
		}
		
		if ((buttons[22].getText()=="O") &&
				(buttons[15].getText()=="O") &&
				(buttons[8].getText()=="O") &&
				(buttons[1].getText()=="O")) {
			player2Wins(22,15,8,1);
		}
		
		if ((buttons[37].getText()=="O") &&
				(buttons[30].getText()=="O") &&
				(buttons[23].getText()=="O") &&
				(buttons[16].getText()=="O")) {
			player2Wins(37,30,23,16);
		}
		
		if ((buttons[30].getText()=="O") &&
				(buttons[23].getText()=="O") &&
				(buttons[16].getText()=="O") &&
				(buttons[9].getText()=="O")) {
			player2Wins(30,23,16,9);
		}
		
		if ((buttons[23].getText()=="O") &&
				(buttons[16].getText()=="O") &&
				(buttons[9].getText()=="O") &&
				(buttons[2].getText()=="O")) {
			player2Wins(23,16,9,2);
		}
		
		if ((buttons[38].getText()=="O") &&
				(buttons[31].getText()=="O") &&
				(buttons[24].getText()=="O") &&
				(buttons[17].getText()=="O")) {
			player2Wins(38,31,24,17);
		}
		
		if ((buttons[31].getText()=="O") &&
				(buttons[24].getText()=="O") &&
				(buttons[17].getText()=="O") &&
				(buttons[10].getText()=="O")) {
			player2Wins(31,24,17,10);
		}
		
		if ((buttons[24].getText()=="O") &&
				(buttons[17].getText()=="O") &&
				(buttons[10].getText()=="O") &&
				(buttons[3].getText()=="O")) {
			player2Wins(24,17,10,3);
		}
		
		if ((buttons[39].getText()=="O") &&
				(buttons[32].getText()=="O") &&
				(buttons[25].getText()=="O") &&
				(buttons[18].getText()=="O")) {
			player2Wins(39,32,25,18);
		}
		
		if ((buttons[32].getText()=="O") &&
				(buttons[25].getText()=="O") &&
				(buttons[18].getText()=="O") &&
				(buttons[11].getText()=="O")) {
			player2Wins(32,25,18,11);
		}
		
		if ((buttons[25].getText()=="O") &&
				(buttons[18].getText()=="O") &&
				(buttons[11].getText()=="O") &&
				(buttons[4].getText()=="O")) {
			player2Wins(25,18,11,4);
		}
		
		if ((buttons[40].getText()=="O") &&
				(buttons[33].getText()=="O") &&
				(buttons[26].getText()=="O") &&
				(buttons[19].getText()=="O")) {
			player2Wins(40,33,26,19);
		}
		
		if ((buttons[33].getText()=="O") &&
				(buttons[26].getText()=="O") &&
				(buttons[19].getText()=="O") &&
				(buttons[12].getText()=="O")) {
			player2Wins(33,26,19,12);
		}
		
		if ((buttons[26].getText()=="O") &&
				(buttons[19].getText()=="O") &&
				(buttons[12].getText()=="O") &&
				(buttons[5].getText()=="O")) {
			player2Wins(26,19,12,5);
		}
		
		if ((buttons[41].getText()=="O") &&
				(buttons[34].getText()=="O") &&
				(buttons[27].getText()=="O") &&
				(buttons[20].getText()=="O")) {
			player2Wins(41,34,27,20);
		}
		
		if ((buttons[34].getText()=="O") &&
				(buttons[27].getText()=="O") &&
				(buttons[20].getText()=="O") &&
				(buttons[13].getText()=="O")) {
			player2Wins(34,27,20,13);
		}
		
		if ((buttons[27].getText()=="O") &&
				(buttons[20].getText()=="O") &&
				(buttons[13].getText()=="O") &&
				(buttons[6].getText()=="O")) {
			player2Wins(27,20,13,6);
		}
		
		// Player 2 Vertical checks done
		
		if ((buttons[35].getText()=="O") &&
				(buttons[36].getText()=="O") &&
				(buttons[37].getText()=="O") &&
				(buttons[38].getText()=="O")) {
			player2Wins(35,36,37,38);
		}
		
		if ((buttons[36].getText()=="O") &&
				(buttons[37].getText()=="O") &&
				(buttons[38].getText()=="O") &&
				(buttons[39].getText()=="O")) {
			player2Wins(36,37,38,39);
		}
		
		if ((buttons[37].getText()=="O") &&
				(buttons[38].getText()=="O") &&
				(buttons[39].getText()=="O") &&
				(buttons[40].getText()=="O")) {
			player2Wins(37,38,39,40);
		}
		
		if ((buttons[38].getText()=="O") &&
				(buttons[39].getText()=="O") &&
				(buttons[40].getText()=="O") &&
				(buttons[41].getText()=="O")) {
			player2Wins(38,39,40,41);
		}
		
		if ((buttons[28].getText()=="O") &&
				(buttons[29].getText()=="O") &&
				(buttons[30].getText()=="O") &&
				(buttons[31].getText()=="O")) {
			player2Wins(28,29,30,31);
		}
		
		if ((buttons[29].getText()=="O") &&
				(buttons[30].getText()=="O") &&
				(buttons[31].getText()=="O") &&
				(buttons[32].getText()=="O")) {
			player2Wins(29,30,31,32);
		}
		
		if ((buttons[30].getText()=="O") &&
				(buttons[31].getText()=="O") &&
				(buttons[32].getText()=="O") &&
				(buttons[33].getText()=="O")) {
			player2Wins(30,31,32,33);
		}
		
		if ((buttons[31].getText()=="O") &&
				(buttons[32].getText()=="O") &&
				(buttons[33].getText()=="O") &&
				(buttons[34].getText()=="O")) {
			player2Wins(31,32,33,34);
		}
		
		if ((buttons[21].getText()=="O") &&
				(buttons[22].getText()=="O") &&
				(buttons[23].getText()=="O") &&
				(buttons[24].getText()=="O")) {
			player2Wins(21,22,23,24);
		}
		
		if ((buttons[22].getText()=="O") &&
				(buttons[23].getText()=="O") &&
				(buttons[24].getText()=="O") &&
				(buttons[25].getText()=="O")) {
			player2Wins(22,23,24,25);
		}
		
		if ((buttons[23].getText()=="O") &&
				(buttons[24].getText()=="O") &&
				(buttons[25].getText()=="O") &&
				(buttons[26].getText()=="O")) {
			player2Wins(23,24,25,26);
		}
		
		if ((buttons[24].getText()=="O") &&
				(buttons[25].getText()=="O") &&
				(buttons[26].getText()=="O") &&
				(buttons[27].getText()=="O")) {
			player2Wins(24,25,26,27);
		}
		
		if ((buttons[14].getText()=="O") &&
				(buttons[15].getText()=="O") &&
				(buttons[16].getText()=="O") &&
				(buttons[17].getText()=="O")) {
			player2Wins(14,15,16,17);
		}
		
		if ((buttons[15].getText()=="O") &&
				(buttons[16].getText()=="O") &&
				(buttons[17].getText()=="O") &&
				(buttons[18].getText()=="O")) {
			player2Wins(15,16,17,18);
		}
		
		if ((buttons[16].getText()=="O") &&
				(buttons[17].getText()=="O") &&
				(buttons[18].getText()=="O") &&
				(buttons[19].getText()=="O")) {
			player2Wins(16,17,18,19);
		}
		
		if ((buttons[17].getText()=="O") &&
				(buttons[18].getText()=="O") &&
				(buttons[19].getText()=="O") &&
				(buttons[20].getText()=="O")) {
			player2Wins(17,18,19,20);
		}
		
		if ((buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O") &&
				(buttons[9].getText()=="O") &&
				(buttons[10].getText()=="O")) {
			player2Wins(7,8,9,10);
		}
		
		if ((buttons[8].getText()=="O") &&
				(buttons[9].getText()=="O") &&
				(buttons[10].getText()=="O") &&
				(buttons[11].getText()=="O")) {
			player2Wins(8,9,10,11);
		}
		
		if ((buttons[9].getText()=="O") &&
				(buttons[10].getText()=="O") &&
				(buttons[11].getText()=="O") &&
				(buttons[12].getText()=="O")) {
			player2Wins(9,10,11,12);
		}
		
		if ((buttons[10].getText()=="O") &&
				(buttons[11].getText()=="O") &&
				(buttons[12].getText()=="O") &&
				(buttons[13].getText()=="O")) {
			player2Wins(10,11,12,13);
		}
		
		if ((buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O") &&
				(buttons[3].getText()=="O")) {
			player2Wins(0,1,2,3);
		}
		
		if ((buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O")) {
			player2Wins(1,2,3,4);
		}
		
		if ((buttons[2].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")) {
			player2Wins(2,3,4,5);
		}
		
		if ((buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[6].getText()=="O")) {
			player2Wins(3,4,5,6);
		}
		
		// Player 2 Horizontal checks done
		
		if ((buttons[35].getText()=="O") &&
				(buttons[29].getText()=="O") &&
				(buttons[23].getText()=="O") &&
				(buttons[17].getText()=="O")) {
			player2Wins(35,29,23,17);
		}
		
		if ((buttons[28].getText()=="O") &&
				(buttons[22].getText()=="O") &&
				(buttons[16].getText()=="O") &&
				(buttons[10].getText()=="O")) {
			player2Wins(28,22,16,10);
		}
		
		if ((buttons[21].getText()=="O") &&
				(buttons[15].getText()=="O") &&
				(buttons[9].getText()=="O") &&
				(buttons[3].getText()=="O")) {
			player2Wins(21,15,9,3);
		}
		
		if ((buttons[36].getText()=="O") &&
				(buttons[30].getText()=="O") &&
				(buttons[24].getText()=="O") &&
				(buttons[18].getText()=="O")) {
			player2Wins(36,30,24,18);
		}
		
		if ((buttons[29].getText()=="O") &&
				(buttons[23].getText()=="O") &&
				(buttons[17].getText()=="O") &&
				(buttons[11].getText()=="O")) {
			player2Wins(29,23,17,11);
		}
		
		if ((buttons[22].getText()=="O") &&
				(buttons[16].getText()=="O") &&
				(buttons[10].getText()=="O") &&
				(buttons[4].getText()=="O")) {
			player2Wins(22,16,10,4);
		}
		
		if ((buttons[37].getText()=="O") &&
				(buttons[31].getText()=="O") &&
				(buttons[25].getText()=="O") &&
				(buttons[19].getText()=="O")) {
			player2Wins(37,31,25,19);
		}
		
		if ((buttons[30].getText()=="O") &&
				(buttons[24].getText()=="O") &&
				(buttons[18].getText()=="O") &&
				(buttons[12].getText()=="O")) {
			player2Wins(30,24,18,12);
		}
		
		if ((buttons[23].getText()=="O") &&
				(buttons[17].getText()=="O") &&
				(buttons[11].getText()=="O") &&
				(buttons[5].getText()=="O")) {
			player2Wins(23,17,11,5);
		}
		
		if ((buttons[38].getText()=="O") &&
				(buttons[32].getText()=="O") &&
				(buttons[26].getText()=="O") &&
				(buttons[20].getText()=="O")) {
			player2Wins(38,32,26,20);
		}
		
		if ((buttons[31].getText()=="O") &&
				(buttons[25].getText()=="O") &&
				(buttons[19].getText()=="O") &&
				(buttons[13].getText()=="O")) {
			player2Wins(31,25,19,13);
		}
		
		if ((buttons[24].getText()=="O") &&
				(buttons[18].getText()=="O") &&
				(buttons[12].getText()=="O") &&
				(buttons[6].getText()=="O")) {
			player2Wins(24,18,12,6);
		}
		
		if ((buttons[41].getText()=="O") &&
				(buttons[33].getText()=="O") &&
				(buttons[25].getText()=="O") &&
				(buttons[17].getText()=="O")) {
			player2Wins(41,33,25,17);
		}
		
		if ((buttons[34].getText()=="O") &&
				(buttons[26].getText()=="O") &&
				(buttons[18].getText()=="O") &&
				(buttons[10].getText()=="O")) {
			player2Wins(34,26,18,10);
		}
		
		if ((buttons[27].getText()=="O") &&
				(buttons[19].getText()=="O") &&
				(buttons[11].getText()=="O") &&
				(buttons[3].getText()=="O")) {
			player2Wins(27,19,11,3);
		}
		
		if ((buttons[40].getText()=="O") &&
				(buttons[32].getText()=="O") &&
				(buttons[24].getText()=="O") &&
				(buttons[16].getText()=="O")) {
			player2Wins(40,32,24,16);
		}
		
		if ((buttons[33].getText()=="O") &&
				(buttons[25].getText()=="O") &&
				(buttons[17].getText()=="O") &&
				(buttons[9].getText()=="O")) {
			player2Wins(33,25,17,9);
		}
		
		if ((buttons[26].getText()=="O") &&
				(buttons[18].getText()=="O") &&
				(buttons[10].getText()=="O") &&
				(buttons[2].getText()=="O")) {
			player2Wins(26,18,10,2);
		}
		
		if ((buttons[39].getText()=="O") &&
				(buttons[31].getText()=="O") &&
				(buttons[23].getText()=="O") &&
				(buttons[15].getText()=="O")) {
			player2Wins(39,31,23,15);
		}
		
		if ((buttons[32].getText()=="O") &&
				(buttons[24].getText()=="O") &&
				(buttons[16].getText()=="O") &&
				(buttons[8].getText()=="O")) {
			player2Wins(32,24,16,8);
		}
		
		if ((buttons[25].getText()=="O") &&
				(buttons[17].getText()=="O") &&
				(buttons[9].getText()=="O") &&
				(buttons[1].getText()=="O")) {
			player2Wins(25,17,9,1);
		}
		
		if ((buttons[38].getText()=="O") &&
				(buttons[30].getText()=="O") &&
				(buttons[22].getText()=="O") &&
				(buttons[14].getText()=="O")) {
			player2Wins(38,30,22,14);
		}
		
		if ((buttons[31].getText()=="O") &&
				(buttons[23].getText()=="O") &&
				(buttons[15].getText()=="O") &&
				(buttons[7].getText()=="O")) {
			player2Wins(31,23,15,7);
		}
		
		if ((buttons[24].getText()=="O") &&
				(buttons[16].getText()=="O") &&
				(buttons[8].getText()=="O") &&
				(buttons[0].getText()=="O")) {
			player2Wins(24,16,8,0);
		}
		
		//All checks done
	}
	
	public void player1Wins(int a, int b, int c, int d) {
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		buttons[d].setBackground(Color.green);
		
		for (int i = 0; i < 42; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("Player 1 Wins");
	}
	
	public void player2Wins(int a, int b, int c, int d) {
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		buttons[d].setBackground(Color.green);
		
		for (int i = 0; i < 42; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("Player 2 Wins");
	}
}