import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * @author Lester
 * GUI for blocks and polls
 */

public class TowerPlay extends JPanel {
	//create towers
	TowerStack tower1 = new TowerStack();
	TowerStack tower2 = new TowerStack();
	TowerStack tower3 = new TowerStack();
			
	boolean isSelectedTower1 = true;
	boolean isSelectedTower2 = false;
	boolean isSelectedTower3 = false;
 	
	TowerBlock carriedBlock = null;
	
	/**
	 * Attributes for blocks
	 */
	public TowerPlay() {
		addKeyListener(new ControlAdapter());
		setFocusable(true);
		
		tower1.push(new TowerBlock(90));
		tower1.push(new TowerBlock(70));
		tower1.push(new TowerBlock(50));
		tower1.push(new TowerBlock(30));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		//tower 1
		g.fillRect(70, 40, 20, 160);
		//tower 2
		g.fillRect(230, 40, 20, 160);
		//tower 3
		g.fillRect(390, 40, 20, 160);
		
		//blocks
		tower1.drawBlocks(g, 30);
		tower2.drawBlocks(g, 190);
		tower3.drawBlocks(g, 350);
		
		//carried block
		if(carriedBlock != null) {
			int xPos = 0;
			if(isSelectedTower1)
				xPos = 30 + (100-carriedBlock.getLength())/2;
			else if (isSelectedTower2)
				xPos = 190 + (100-carriedBlock.getLength())/2;
			else if (isSelectedTower3)
				xPos = 350 + (100-carriedBlock.getLength())/2;
			g.fillRect(xPos, 20, carriedBlock.getLength(), 19);
		}
		
		//selector
		g.setColor(Color.red);
		if(isSelectedTower1)
			g.drawRect(1, 20, 158, 190);
		else if (isSelectedTower2)
			g.drawRect(161, 20, 158, 190);
		else if (isSelectedTower3)
			g.drawRect(321, 20, 158, 190);
	}
	
	private void checkMove() {
		if (tower3.count() == 4) {
			JOptionPane.showMessageDialog(TowerPlay.this, "Congratulations! You win the game.");
		}
	}	
	
	//control for arrow keys
	public class ControlAdapter extends KeyAdapter{
		
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			
			if (key == KeyEvent.VK_RIGHT) {
				if (isSelectedTower1) {
					isSelectedTower2 = true;
					isSelectedTower1 = false;
				}
				else if (isSelectedTower2) {
					isSelectedTower3 = true;
					isSelectedTower2 = false;
				}
			}
			
			if (key == KeyEvent.VK_LEFT) {
				if (isSelectedTower2) {
					isSelectedTower1 = true;
					isSelectedTower2 = false;
				}
				else if (isSelectedTower3) {
					isSelectedTower2 = true;
					isSelectedTower3 = false;
				}
			}
			
			if (key == KeyEvent.VK_UP){
				if (carriedBlock == null) {
					if (isSelectedTower1)
						carriedBlock = tower1.pop();
					else if (isSelectedTower2)
						carriedBlock = tower2.pop();
					else if (isSelectedTower3)
						carriedBlock = tower3.pop();
				}
			}
			
			if (key == KeyEvent.VK_DOWN) {
				if (carriedBlock != null) {		
					if (isSelectedTower1) {
						if (tower1.peek() == null || tower1.peek().getLength()>carriedBlock.getLength()) {
							tower1.push(carriedBlock);
							carriedBlock = null;
						}
					}
					else if (isSelectedTower2) {
						if (tower2.peek() == null || tower2.peek().getLength()>carriedBlock.getLength()) {
							tower2.push(carriedBlock);
							carriedBlock = null;
						}
					}
					else if (isSelectedTower3) {
						if (tower3.peek() == null || tower3.peek().getLength()>carriedBlock.getLength()) {
							tower3.push(carriedBlock);
							carriedBlock = null;
						}
					}
				}
			}
			repaint();
			checkMove();
		}
	}
}
