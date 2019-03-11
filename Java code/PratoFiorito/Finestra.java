package PratoFiorito;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import PratoFiorito.PannelloVittoria;

@SuppressWarnings("serial")
public class Finestra extends JFrame implements ActionListener{
	public static final int LARGHEZZA = 500;
	public static final int ALTEZZA = 500;
	
	private PannelloVittoria p;
	private PannelloSconfitta s;
	private JButton[][] button;
	private char[][] numeri;
	private String difficulty;
	
	public Finestra(int n,int m, String difficulty) {
		this.difficulty = difficulty;
		button = new JButton[n][m];
		numeri = new char[n][m];
		
		//set Frame Size
		if(n*m == 100)
			setSize(LARGHEZZA,ALTEZZA);
		else if(n*m == 225)
			setSize(LARGHEZZA+290,ALTEZZA+200);
		else if(n*m == 400)
			setSize(LARGHEZZA+500,ALTEZZA+220);
		else System.out.println("Errore nel codice");
		
		setTitle("Prato Fiorito");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		//gestione numeri
		Metodi.Bombe(numeri);
		Metodi.numero(numeri);
		
		// gestione bottoni
		
		JPanel pB = new JPanel();
		pB.setBackground(Color.WHITE);
		
//		set gridLayout
		if(n*m == 100)
			pB.setLayout(new GridLayout(10,10,2,2));
		else if(n*m == 225)
			pB.setLayout(new GridLayout(15,15,2,2));
		else if(n*m == 400)
			pB.setLayout(new GridLayout(20,20,2,2));
		else System.out.println("Errore nel codice");
		
		
		for(int i=0; i<button.length; i++) {
			for(int j=0; j<button.length; j++) {
				button[i][j] = new JButton();
				pB.add(button[i][j]);
				button[i][j].addActionListener(this);
			}
		}
		add(pB);	
	}
	
	public boolean vittoria(JButton[][] b) {
		for(int i=0; i<b.length; i++) {
			for(int j=0; j<b.length; j++){
				if(b[i][j].getText() == "" && numeri[i][j] != 'X')
			          return false;
			}
		}
		return true;
	}
	
	public boolean sconfitta(JButton b) {
		if(b.getIcon() != null)
			return true;
		return false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		for(int i=0; i<button.length; i++) {
			for(int j=0; j<button.length; j++) {
				if(source == button[i][j]) {
					if(numeri[i][j] != 'X')
						button[i][j].setText(Character.toString(numeri[i][j]));
					else { 
					  try {
					    ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/immagine/Minesweeper1.png"));
					    Image image = imageIcon.getImage(); // transform it
					    Image newimg = null;
//					    scale it the smooth way
					    if(button.length == 10) 
					    	newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);   
					    else if(button.length == 15)
					    	newimg = image.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH);
					    else if(button.length == 20)
					    	newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);
					    imageIcon = new ImageIcon(newimg);  // transform it back
					    button[i][j].setIcon(imageIcon);
					  } catch (Exception ex) {
					    System.out.println(ex);
					  }
					} 
					  
//					set the size of the text button
					Metodi.font(button, i, j);
					
					if(button[i][j].getIcon() == null)
						button[i][j].setEnabled(false);
					zeri(button,i,j);
					if(sconfitta(button[i][j])) {
						s = new PannelloSconfitta(this.difficulty, this);
						s.setVisible(true);
						setEnabled(false);
					}	
					else if(vittoria(button)) {
						p = new PannelloVittoria(this.difficulty, this);
						p.setVisible(true);
						setEnabled(false);
					}
				}	
			}
		}
		
	}
	
	public void zeri(JButton[][] b, int m, int n) {
		 if(numeri[m][n] == ' '){
		     //riga 0
		     if(m==0){
		       //punto 00
		       if(n==0){
		         for(int e=0; e<2; e++){
		           if(b[m+1][n+e].getText() == ""){
		             b[m+1][n+e].setText(Character.toString(numeri[m+1][n+e]));
		             Metodi.font(button, m+1, n+e);
		             b[m+1][n+e].setEnabled(false);
		             if(numeri[m+1][n+e] == ' ')
		               zeri(b,m+1,n+e);
		           }
		         }
		         if(b[m][n+1].getText() == ""){
		            b[m][n+1].setText(Character.toString(numeri[m][n+1]));
		            Metodi.font(button, m, n+1);
		            b[m][n+1].setEnabled(false);
		            if(numeri[m][n+1] == ' ')
		             zeri(b,m,n+1);
		         }
		       }
		       //punto 02
		       else if(n == b[1].length-1){
		         for(int e=-1; e<1; e++){
		           if(b[m+1][n+e].getText() == ""){
		              b[m+1][n+e].setText(Character.toString(numeri[m+1][n+e]));
		              Metodi.font(button, m+1, n+e);
			          b[m+1][n+e].setEnabled(false);
		              if(numeri[m+1][n+e]==' ')
		                zeri(b,m+1,n+e);
		           }
		         }
		         if(b[m][n-1].getText() == ""){
		            b[m][n-1].setText(Character.toString(numeri[m][n-1]));
		            Metodi.font(button, m, n-1);
			        b[m][n-1].setEnabled(false);
		            if(numeri[m][n-1]==' ')
		              zeri(b,m,n-1);
		         }
		       }
		       //riga 0
		       else{
		         for(int e=-1; e<2; e++){
		           if(b[m+1][n+e].getText() == ""){
		              b[m+1][n+e].setText(Character.toString(numeri[m+1][n+e]));
		              Metodi.font(button, m+1, n+e);
				      b[m+1][n+e].setEnabled(false);
		              if(numeri[m+1][n+e]==' ')
		                zeri(b,m+1,n+e);
		           }
		         }
		         if(b[m][n+1].getText() == ""){
		            b[m][n+1].setText(Character.toString(numeri[m][n+1]));
		            Metodi.font(button, m, n+1);
				    b[m][n+1].setEnabled(false);
		            if(numeri[m][n+1]==' ')
		              zeri(b,m,n+1);
		         }
		         if(b[m][n-1].getText() == ""){
		        	b[m][n-1].setText(Character.toString(numeri[m][n-1]));
		        	Metodi.font(button, m, n-1);
					b[m][n-1].setEnabled(false);
		            if(numeri[m][n-1]==' ')
		              zeri(b,m,n-1);
		         }
		       }
		     }
		     //colonna 0
		     else if(n==0){
		       // punto 20
		       if(m==(b.length-1)){
		         for(int e=0; e<2; e++){
		           if(b[m-1][n+e].getText() == ""){
		              b[m-1][n+e].setText(Character.toString(numeri[m-1][n+e]));
		              Metodi.font(button, m-1, n+e);
		              b[m-1][n+e].setEnabled(false);
		              if(numeri[m-1][n+e]==' ')
		                zeri(b,m-1,n+e);
		           }
		         }
		         if(b[m][n+1].getText() == ""){
		        	b[m][n+1].setText(Character.toString(numeri[m][n+1]));
		        	Metodi.font(button, m, n+1);
		            b[m][n+1].setEnabled(false);
		            if(numeri[m][n+1]==' ')
		              zeri(b,m,n+1);
		         }
		       }
		       //colonna 0
		       else{
		         for(int e=0; e<2; e++){
		           if(b[m-1][n+e].getText() == ""){
		              b[m-1][n+e].setText(Character.toString(numeri[m-1][n+e]));
		              Metodi.font(button, m-1, n+e);
			          b[m-1][n+e].setEnabled(false);
		              if(numeri[m-1][n+e]==' ')
		                zeri(b,m-1,n+e);
		           }
		         }
		         if(b[m][n+1].getText() == ""){
		        	b[m][n+1].setText(Character.toString(numeri[m][n+1]));
		        	Metodi.font(button, m, n+1);
			        b[m][n+1].setEnabled(false);
		            if(numeri[m][n+1]==' ')
		              zeri(b,m,n+1);
		         }
		         for(int e=0; e<2; e++){
		           if(b[m+1][n+e].getText() == ""){
		              b[m+1][n+e].setText(Character.toString(numeri[m+1][n+e]));
		              Metodi.font(button, m+1, n+e);
				      b[m+1][n+e].setEnabled(false);
		              if(numeri[m+1][n+e]==' ')
		                zeri(b,m+1,n+e);
		           }
		         }
		       }
		     }
		     //riga 2
		     else if(m==b.length-1){
		       //punto 22
		       if(n==b[1].length-1){
		          for(int e=-1; e<1; e++){
		            if(b[m-1][n+e].getText() == ""){
		               b[m-1][n+e].setText(Character.toString(numeri[m-1][n+e]));
		               Metodi.font(button, m-1, n+e);
					   b[m-1][n+e].setEnabled(false);
		               if(numeri[m-1][n+e]==' ')
		                 zeri(b,m-1,n+e);
		            }
		          }
		          if(b[m][n-1].getText() == ""){
		        	 b[m][n-1].setText(Character.toString(numeri[m][n-1]));
		        	 Metodi.font(button, m, n-1);
					 b[m][n-1].setEnabled(false);
		             if(numeri[m][n-1]==' ')
		              zeri(b,m,n-1);
		          }
		       }
		       //riga 2
		       else{
		         for(int e=-1; e<2; e++){
		           if(b[m-1][n+e].getText() == ""){
		              b[m-1][n+e].setText(Character.toString(numeri[m-1][n+e]));
		              Metodi.font(button, m-1, n+e);
					  b[m-1][n+e].setEnabled(false);
		              if(numeri[m-1][n+e]==' ')
		                zeri(b,m-1,n+e);
		           }
		         }
		         if(b[m][n-1].getText() == ""){
		        	b[m][n-1].setText(Character.toString(numeri[m][n-1]));
		        	Metodi.font(button, m, n-1);
					b[m][n-1].setEnabled(false);
		            if(numeri[m][n-1]==' ')
		              zeri(b,m,n-1);
		         }
		         if(b[m][n+1].getText() == ""){
		        	b[m][n+1].setText(Character.toString(numeri[m][n+1]));
		        	Metodi.font(button, m, n+1);
					b[m][n+1].setEnabled(false);
		            if(numeri[m][n+1]==' ')
		              zeri(b,m,n+1);
		         }
		       }
		     }
		     //colonna 2
		     else if(n==b[1].length-1){
		       for(int e=-1; e<1; e++){
		         if(b[m+1][n+e].getText() == ""){
		        	b[m+1][n+e].setText(Character.toString(numeri[m+1][n+e]));
		        	Metodi.font(button, m+1, n+e);
					b[m+1][n+e].setEnabled(false);
		            if(numeri[m+1][n+e]==' ')
		              zeri(b,m+1,n+e);
		         }
		       }
		       for(int e=-1; e<1; e++){
		         if(b[m-1][n+e].getText() == ""){
		        	b[m-1][n+e].setText(Character.toString(numeri[m-1][n+e]));
		        	Metodi.font(button, m-1, n+e);
					b[m-1][n+e].setEnabled(false);
		            if(numeri[m-1][n+e]==' ')
		              zeri(b,m-1,n+e);
		         }
		       }
		       if(b[m][n-1].getText() == ""){
		          b[m][n-1].setText(Character.toString(numeri[m][n-1]));
		          Metodi.font(button, m, n-1);
		          Metodi.font(button, m, n-1);
				  b[m][n-1].setEnabled(false);
		          if(numeri[m][n-1]==' ')
		            zeri(b,m,n-1);
		       }
		     }
		     else{
		       for(int e=-1; e<2; e++){
		         if(b[m+1][n+e].getText() == ""){
		        	b[m+1][n+e].setText(Character.toString(numeri[m+1][n+e]));
		        	Metodi.font(button, m+1, n+e);
					b[m+1][n+e].setEnabled(false);
		            if(numeri[m+1][n+e]==' ')
		              zeri(b,m+1,n+e);
		         }
		       }
		       for(int e=-1; e<2; e++){
		         if(b[m-1][n+e].getText() == ""){
		        	b[m-1][n+e].setText(Character.toString(numeri[m-1][n+e]));
		        	Metodi.font(button, m-1, n+e);
					b[m-1][n+e].setEnabled(false);
		            if(numeri[m-1][n+e]==' ')
		              zeri(b,m-1,n+e);
		         }
		       }
		       if(b[m][n-1].getText() == ""){
		          b[m][n-1].setText(Character.toString(numeri[m][n-1]));
		          Metodi.font(button, m, n-1);
				  b[m][n-1].setEnabled(false);
		          if(numeri[m][n-1]==' ')
		            zeri(b,m,n-1);
		       }
		       if(b[m][n+1].getText() == ""){
		          b[m][n+1].setText(Character.toString(numeri[m][n+1]));
		          Metodi.font(button, m, n+1);
				  b[m][n+1].setEnabled(false);
		          if(numeri[m][n+1]==' ')
		            zeri(b,m,n+1);
		       }
		     }
		   }
		 } 
}
