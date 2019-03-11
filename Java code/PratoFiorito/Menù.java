package PratoFiorito;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menù extends JFrame implements ActionListener{
	private final static int WIDTH = 500;
	private final static int HEIGHT = 500;

	private Finestra f;
	private Opzioni o;
	private JButton start,opzioni,exit;
	private String difficulty;
	
	public Menù(String difficulty) {
		this.difficulty = difficulty;
		
		setSize(WIDTH, HEIGHT);
		setTitle("Prato Fiorito");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		
		//Pannello Bottoni
		JPanel pB = new JPanel();
		
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		pB.setLayout(gridbag);
		pB.setBackground(Color.LIGHT_GRAY);
		
		gbc.fill = GridBagConstraints.BOTH;

        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        gbc.insets.top = 40;
        gbc.insets.bottom = 10;
        gbc.insets.left = 60;
        gbc.insets.right = 60;
		
        //Label gioco 
        JLabel l = new JLabel("PRATO FIORITO");
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setFont(new Font("Times new Roman", Font.BOLD, 40));
        //l.setFont(font);

        pB.add(l, gbc);
        
		//bottone start
		start = new JButton("New Game");
		start.setFont(new Font("Times new Roman", Font.BOLD, 30));
		start.addActionListener(this);
		gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets.top = 20;
        gbc.insets.bottom = 10;
        gbc.insets.left = 30;
        gbc.insets.right = 30;
		pB.add(start, gbc);
		
		//bottone opzioni
		opzioni = new JButton("Options");
		opzioni.setFont(new Font("Times new Roman", Font.BOLD, 30));
		opzioni.addActionListener(this);
		gbc.gridx = 0;
		gbc.gridy = 2;
		pB.add(opzioni, gbc);
		
		//bottone exit
		exit = new JButton("Exit");
		exit.setFont(new Font("Times new Roman", Font.BOLD, 30));
		exit.addActionListener(this);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets.bottom = 30;
		pB.add(exit, gbc);
		
		add(pB);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("New Game")) {
			if(this.difficulty.equals("easy"))
				f = new Finestra(10,10, this.difficulty);
			if(this.difficulty.equals("medium"))
				f = new Finestra(15,15, this.difficulty);
			if(this.difficulty.equals("hard"))
				f = new Finestra(20,20, this.difficulty);
			f.setVisible(true);
			setVisible(false);
		}
		else if(e.getActionCommand().equals("Options")) {
			o = new Opzioni();
			o.setVisible(true);
			setVisible(false);
		}
		else if(e.getActionCommand().equals("Exit")) {
			System.exit(0);
		}
		else System.out.println("Errore nel coodice");
	}
}
