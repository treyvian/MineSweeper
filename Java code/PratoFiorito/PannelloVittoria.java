package PratoFiorito;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

public class PannelloVittoria extends JFrame implements ActionListener{
	public final static int LARGHEZZA = 300;
	public final static int ALTEZZA = 200;
	
	private Menù m;
	private Finestra f;
	private String difficulty;
	
	public PannelloVittoria(String difficulty, Finestra f) {
		this.difficulty = difficulty;
		this.f = f;
		
		//pannello vittoria
		setSize(LARGHEZZA,ALTEZZA);
		setTitle("Vittoria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setLayout(new BorderLayout());
		
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
	
		JLabel bomba = new JLabel("Hai Vinto, Complimenti");
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
