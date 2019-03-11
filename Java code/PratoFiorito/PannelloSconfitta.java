package PratoFiorito;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

public class PannelloSconfitta extends JFrame implements ActionListener{
	public final static int LARGHEZZA = 300;
	public final static int ALTEZZA = 200;
	
	private Finestra f;
	private Menù m;
	private String difficulty;
	
	public PannelloSconfitta(String difficulty, Finestra f) {
		this.difficulty = difficulty;
		this.f = f;
		
		//pannello vittoria
		setSize(LARGHEZZA,ALTEZZA);
		setTitle("Sconfitta");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JPanel p = new JPanel();
		p.setLayout(new GridBagLayout());
		p.setBackground(Color.LIGHT_GRAY);
		
		gbc.fill = GridBagConstraints.BOTH;

        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
		
        gbc.insets.top = 20;  
   	 	gbc.insets.bottom = 20;
	    gbc.insets.left = 30;
	    gbc.insets.right = 30;
	    
		JButton ok = new JButton("OK");
		ok.addActionListener(this);
		gbc.gridx = 1;
		gbc.gridy = 1;
		p.add(ok,gbc);
	
		JLabel bomba = new JLabel("Hai Perso, hai trovato una bomba");
		bomba.setHorizontalAlignment(SwingConstants.CENTER);
		bomba.setForeground(Color.BLACK);
		bomba.setFont(new Font("Times new Roman", Font.BOLD, 20));
		
		gbc.insets.left = 0;
	    gbc.insets.right = 0;
		gbc.gridx = 1;
		gbc.gridy = 0;
		
		p.add(bomba, gbc);
		
		add(p);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("OK")) {
			m = new Menù(this.difficulty);
			m.setVisible(true);
			setVisible(false);
			f.setVisible(false);
		}
	}
}
