package games.examples.ticTacToe;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import games.basic.gameObjects.CircularGameObject;
import games.basic.gameObjects.CrossGameObject;
import games.basic.gameObjects.interfaces.GameObject;
import games.basic.position.Position;

public class TicPanel extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	
	ArrayList<GameObject> liste;	//Verweis auf die liste mit GameObjects
	JFrame frame;					//Verweis auf JFrame
	boolean kreis;					//boolean um sich zu merken wer gerade am Zug ist, Kreuz oder Kreis
	
	Map<String, String> cells;		//Internes Map um Spielstand zu merken und damit zu arbeiten

	public TicPanel(ArrayList<GameObject> liste2) {
		this.liste = liste2;
		this.addMouseListener(this);
		this.kreis = false;
		this.cells = new HashMap<String, String>();
		
	}

	public TicPanel(ArrayList<GameObject> liste, JFrame frame) {
		this.liste = liste;
		this.frame = frame;
		this.addMouseListener(this);
		this.kreis = false;
		this.cells = new HashMap<String, String>();

	}

	public void mouseClicked(MouseEvent event) {
		int x = (int) event.getPoint().getX() / (this.getWidth()/3);
		int y = (int) event.getPoint().getY() / (this.getHeight()/3);
		String key = String.format("%d,%d", x, y);
		System.out.println(String.format("Click on cell(%s)", key));
		//JOptionPane.showMessageDialog(null, str);
		
		if (!cells.containsKey(key)) { //key existiert nicht 
			if (kreis) {
				liste.add(new CircularGameObject(new Position((this.getX()+this.getWidth()*x/3)+10, (this.getY()+this.getHeight()*y/3)+10), (this.getWidth()/3)-20));
				cells.put(key, "kreis");
				kreis = false;
			} else {
				liste.add(new CrossGameObject(new Position((this.getX()+this.getWidth()*x/3)+10, (this.getY()+this.getHeight()*y/3)+10), (this.getWidth()/3)-20, (this.getHeight()/3)-20));
				cells.put(key, "kreuz");
				kreis = true;
			}
		}
		
		frame.repaint();
		
		if (win(x,y)) {
			String message = "Glückwunsh! Kreis hat gewonnen!";
			if (kreis) {
				message = "Glückwunsh! Kreuz hat gewonnen!";
			} 
			
			JOptionPane.showMessageDialog(null, message);
			liste.clear();
			cells.clear();
			frame.repaint();
			
		}
		
		if (liste.size()==9) {
			JOptionPane.showMessageDialog(null, "Niemand hat gewonnen");
			liste.clear();
			cells.clear();
			frame.repaint();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) { 
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(2.5f));
		g.setColor(Color.black);
		g.drawLine(this.getX()+this.getWidth()/3, this.getY(), this.getX()+this.getWidth()/3, this.getY()+this.getHeight());
		g.drawLine(this.getX()+this.getWidth()*2/3, this.getY(), this.getX()+this.getWidth()*2/3, this.getY()+this.getHeight());
		g.drawLine(this.getX(), this.getY()+this.getHeight()/3, this.getX()+this.getWidth(), this.getY()+this.getHeight()/3);
		g.drawLine(this.getX(), this.getY()+this.getHeight()*2/3, this.getX()+this.getWidth(), this.getY()+this.getHeight()*2/3);

		//also hier gehe ich durch die liste und rufe jeweils die paint components methode mit diesem g von hier als Übergabeparameter

		for (GameObject elem : liste) {
			elem.paintComponent(g);
		}
		
		//Um die Buttons genrisch zu zeichnen
		
	}
	
	/**
     *  Check to see if all three values are the same (and not null) indicating a win.
     * @param a1 The first cell.
     * @param a2 The second cell.
     * @param a3 The third cell.
     * @return true if the three cells are same, otherwise false.
     */
    private boolean checkRowCol (String a1, String a2, String a3) {
    	System.out.println(String.format("Checking of cell(%s), cell(%s) and cell(%s)", a1, a2, a3));
		return ((a1 != null) && (a1 == a2) && (a2 == a3));
	}
	
	/**
     *  Loop through rows and see if any are winners.
     * @param Zeile The current row that is setting.
     * @return true if the two next cells line on the row are the same as this cell, otherwise false.
     */
    private boolean checkRowForWin (int Zeile) {
		for(int i=0; i<3-2; i++) {
			if (checkRowCol(cells.get(String.format("%d,%d", Zeile, i)), cells.get(String.format("%d,%d", Zeile, i+1)), cells.get(String.format("%d,%d", Zeile, i+2)))) {
				return true;
			}
		}
		return false;
	}
	
	/**
     *  Loop through columns and see if any are winners.
     * @param Spalte The current column that is setting.
     * @return true if the two next cells line on the column are the same as this cell, otherwise false.
     */
    private boolean checkColForWin (int Spalte) {
		for(int i=0; i<3-2; i++) {
			if (checkRowCol(cells.get(String.format("%d,%d", i, Spalte)), cells.get(String.format("%d,%d", i+1, Spalte)), cells.get(String.format("%d,%d", i+2, Spalte)))) {
				return true;
			}
		}
		return false;
	}

    /**
     *  Check the two diagonals to see if either is a win. Return true if either wins.
     * @param currentRow The current row that is setting.
     * @param currentCol The current column that is setting.
     * @return true if on one of this two diagonals there are directly cells line that are same.
     */
    private boolean checkDiagonalsForWin(int currentRow, int currentCol) {
    	int bLength = cells.size();
    	boolean checked = false;
    	int beginOffsetRow = 0;
    	int beginOffsetCol = 0;
    	int endOffsetRow = 0;
    	int endOffsetCol = 0;
    	// Diagonal back slash
    	beginOffsetRow = currentRow - 2;
    	beginOffsetCol = currentCol - 2;
    	endOffsetRow = currentRow + 2;
    	endOffsetCol = currentCol + 2;
    	for(int offset = 2; offset > 0; offset--)
	    	if((currentRow - offset < 0) || (currentCol - offset < 0)){
	    		beginOffsetRow++;
	    		beginOffsetCol++;
    		}
    	
    	for(int offset = 2; offset > 0; offset--)
	    	if((currentRow + offset >= bLength) || (currentCol + offset >= bLength)){
	    		endOffsetRow--;
	    		endOffsetCol--;
	    	}
    	
    	if(endOffsetRow - beginOffsetRow > 1){
	    	for (int i = 0; i < endOffsetCol - beginOffsetRow; i++) {
	            if ((beginOffsetRow + i + 2) < bLength &&
	            		(beginOffsetCol + i + 2) < bLength &&
            			checkRowCol(cells.get(String.format("%d,%d", beginOffsetRow + i, beginOffsetCol + i)), 
            					cells.get(String.format("%d,%d", beginOffsetRow + i + 1, beginOffsetCol + i + 1)), 
            					cells.get(String.format("%d,%d", beginOffsetRow + i + 2, beginOffsetCol + i + 2)))) {
	            	checked = true;
	            }
	        }
    	}
    	
    	// Diagonal slash
    	beginOffsetRow = currentRow + 2;
    	beginOffsetCol = currentCol - 2;
    	endOffsetRow = currentRow - 2;
    	endOffsetCol = currentCol + 2;
    	for(int offset = 2; offset > 0; offset--)
	    	if((currentCol - offset < 0) || (currentRow + offset >= bLength)){
	    		beginOffsetRow--;
	    		beginOffsetCol++;
    		}
    	
    	for(int offset = 2; offset > 0; offset--)
	    	if((currentCol + offset >= bLength) || (currentRow - offset < 0)){
	    		endOffsetRow++;
	    		endOffsetCol--;
	    	}
    	
    	if(beginOffsetRow - endOffsetRow > 1){
	    	for (int i = 0; i < endOffsetCol - beginOffsetCol -1; i++) {
	            if ((beginOffsetRow - i - 2) >= endOffsetRow &&
	            		(beginOffsetCol + i + 2) <= endOffsetCol &&
	            		checkRowCol(cells.get(String.format("%d,%d", beginOffsetRow - i, beginOffsetCol + i)), 
	            				cells.get(String.format("%d,%d", beginOffsetRow - i - 1, beginOffsetCol + i + 1)), 
	            				cells.get(String.format("%d,%d", beginOffsetRow - i - 2, beginOffsetCol + i + 2)))) {
	            	checked = true;
	            }
	        }
    	}    	
    	
    	return checked;
    }
    
    /**
     * Checks for game win.
     * @param currentRow The current row that is setting.
     * @param currentCol The current column that is setting.
     * @return true if there is a winner, otherwise false.
     */
    public boolean win(int currentRow, int currentCol) {
		return checkRowForWin(currentRow) || checkColForWin(currentCol) || checkDiagonalsForWin(currentRow, currentCol);
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}