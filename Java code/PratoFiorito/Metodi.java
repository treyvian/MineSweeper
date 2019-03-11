package PratoFiorito;

import java.awt.Font;
import javax.swing.JButton;

public class Metodi {
	public static void Bombe(char[][] a){
	    int b= 0, n= (a.length)*(a[1].length);
	    //calcolo bombe
	    if(n==100)
	      b= 15;
	    else if(n == 225)
	      b= 30;
	    else
	      b= 50;
	    //inserire bombe
	    for(int i=0; i<b; i++){
	      int l,p;
	      do{
	        l = (int)(Math.random()*a.length);
	        p = (int)(Math.random()*a[1].length);
	      }while(a[l][p]=='X');
	      a[l][p]='X';
	    }
	  }
	public static char Car(int l){
	    if(l==0)
	    	return ' ';
		char p = (char)('0'+l);
	    return p;
	}
	public static void numero(char[][] a){
	    for(int i=0; i<a.length; i++){
	      for(int j=0; j<a[1].length; j++){
	        int l=0;
	        if(a[i][j]!='X'){
	          //riga 0
	          if(i==0){
	            //punto 00
	            if(j==0){
	              for(int e=0; e<2; e++)
	                if(a[i+1][j+e]=='X')
	                  l++;
	              if(a[i][j+1]=='X')
	                l++;
	              a[i][j]=Car(l);
	            }
	            //punto 02
	            else if(j==a[1].length-1){
	              for(int e=-1; e<1; e++)
	                if(a[i+1][j+e]=='X')
	                  l++;
	              if(a[i][j-1]=='X')
	                l++;
	              a[i][j]=Car(l);
	            }
	            //riga 0
	            else{
	              for(int e=-1; e<2; e++)
	                if(a[i+1][j+e]=='X')
	                  l++;
	              if(a[i][j+1]=='X')
	                l++;
	              if(a[i][j-1]=='X')
	                l++;
	              a[i][j]=Car(l);
	            }
	          }
	          //colonna 0
	          else if(j==0){
	            // punto 20
	            if(i==(a.length-1)){
	              for(int e=0; e<2; e++)
	                if(a[i-1][j+e]=='X')
	                  l++;
	              if(a[i][j+1]=='X')
	                l++;
	              a[i][j]=Car(l);
	            }
	            //colonna 0
	            else{
	              for(int e=0; e<2; e++)
	                if(a[i-1][j+e]=='X')
	                  l++;
	              if(a[i][j+1]=='X')
	                l++;
	              for(int e=0; e<2; e++)
	                if(a[i+1][j+e]=='X')
	                  l++;

	              a[i][j]=Car(l);
	            }
	          }
	          //riga 2
	          else if(i==a.length-1){
	            //punto 22
	            if(j==a[1].length-1){
	              for(int e=-1; e<1; e++)
	                if(a[i-1][j+e]=='X')
	                  l++;
	              if(a[i][j-1]=='X')
	                l++;
	              a[i][j]=Car(l);
	            }
	            //riga 2
	            else{
	              for(int e=-1; e<2; e++)
	                if(a[i-1][j+e]=='X')
	                  l++;
	              if(a[i][j-1]=='X')
	                l++;
	              if(a[i][j+1]=='X')
	                l++;
	              a[i][j]=Car(l);
	            }
	          }
	          //colonna 2
	          else if(j==a[1].length-1){
	            for(int e=-1; e<1; e++)
	              if(a[i+1][j+e]=='X')
	                l++;
	            for(int e=-1; e<1; e++)
	              if(a[i-1][j+e]=='X')
	                l++;
	            if(a[i][j-1]=='X')
	              l++;
	            a[i][j]=Car(l);
	          }
	          else{
	            for(int e=-1; e<2; e++)
	              if(a[i+1][j+e]=='X')
	                l++;
	            for(int e=-1; e<2; e++)
	              if(a[i-1][j+e]=='X')
	                l++;
	            if(a[i][j-1]=='X')
	              l++;
	            if(a[i][j+1]=='X')
	              l++;
	            a[i][j]=Car(l);
	          }
	        }
	      }
	    }
	}
	
	public static int Vittoria(char[][]a, char[][] b){
	    for(int i=0; i<a.length; i++)
	      for(int j=0; j<a[1].length; j++)
	        if(b[i][j]=='*'&&a[i][j]!='X')
	          return 0;
	    return 1;
	}

	public static void font(JButton[][] button, int i, int j) {
		if(button.length*button.length == 100)
			button[i][j].setFont(new Font("Times new Roman", Font.BOLD, 20));
		else if(button.length*button.length == 225)
			button[i][j].setFont(new Font("Times new Roman", Font.BOLD, 20));
		else if(button.length*button.length == 400)
			button[i][j].setFont(new Font("Times new Roman", Font.BOLD, 17));
		else System.out.println("Errore nel codice");
	}
}	
