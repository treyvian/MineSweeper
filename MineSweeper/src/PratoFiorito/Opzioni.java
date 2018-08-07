package PratoFiorito;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Opzioni extends JFrame implements ActionListener {
	private final static int WIDTH = 500;
	private final static int HEIGHT = 300;
	
	private Menù m;
	private JButton easy,medium,hard,ok;
	private String difficulty;
	
	public Opzioni() {
		setSize(WIDTH, HEIGHT);
		setTitle("Opzioni");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		
		JPanel pP = new JPanel();
		pP.setLayout(new GridBagLayout());
		pP.setBackground(Color.GRAY);
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.BOTH;

        gbc.weightx = 2.0;
        gbc.weighty = 2.0;
		
		JLabel l = new JLabel("Scegli la difficoltà");
		l.setHorizontalAlignment(SwingConstants.CENTER);
		l.setVerticalAlignment(SwingConstants.BOTTOM);
		l.setFont(new Font("Times new Roman", Font.BOLD, 30));
		
		gbc.insets.top = 30;
        gbc.insets.bottom = 10;
        
		gbc.gridx = 1;
		gbc.gridy = 0;
		pP.add(l,gbc);
		
		gbc.insets.top = 30;
        gbc.insets.bottom = 10;
        gbc.insets.left = 10;
        gbc.insets.right = 10;
		
		easy = new JButton("Easy");
		easy.setFont(new Font("Times new Roman", Font.BOLD, 30));
		easy.setBackground(Color.LIGHT_GRAY);
		easy.addActionListener(this);
		gbc.gridx = 0;
		gbc.gridy = 1;
		pP.add(easy, gbc);
		
		medium = new JButton("Medium");
		medium.setFont(new Font("Times new Roman", Font.BOLD, 30));
		medium.setBackground(Color.LIGHT_GRAY);
		medium.addActionListener(this);
		gbc.gridx = 1;
		gbc.gridy = 1;
		pP.add(medium, gbc);
		
		hard = new JButton("Hard");
		hard.setFont(new Font("Times new Roman", Font.BOLD, 30));
		hard.setBackground(Color.LIGHT_GRAY);
		hard.addActionListener(this);
		gbc.gridx = 2;
		gbc.gridy = 1;
		pP.add(hard, gbc);
		

		ok = new JButton("OK");
		ok.setFont(new Font("Times new Roman", Font.BOLD, 20));
		ok.addActionListener(this);
		ok.setBackground(Color.LIGHT_GRAY);
		gbc.insets.top = 20;
        gbc.insets.bottom = 40;
		gbc.insets.left = 50;
        gbc.insets.right = 50;
		gbc.gridx = 1;
		gbc.gridy = 2;
		pP.add(ok, gbc);
		
		add(pP);
	}
	
	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Easy")) {
			easy.setEnabled(false);
			medium.setEnabled(true);
			hard.setEnabled(true);
			setDifficulty("easy");
		}
		else if(e.getActionCommand().equals("Medium")) {
			easy.setEnabled(true);
			medium.setEnabled(false);
			hard.setEnabled(true);
			setDifficulty("medium");
		}
		else if(e.getActionCommand().equals("Hard")) {
			easy.setEnabled(true);
			medium.setEnabled(true);
			hard.setEnabled(false);
			setDifficulty("hard");
		}
		else if(e.getActionCommand().equals("OK")) {
			m = new Menù(this.difficulty);
			m.setVisible(true);
			setVisible(false);
			ok.setEnabled(false);
		}
	}

}
