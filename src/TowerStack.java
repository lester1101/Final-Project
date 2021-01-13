import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Lester
 * TowerStack get and set for the head block
 * Restrictions for every block to be on top
 */
public class TowerStack {
	private TowerBlock headBlock;
	
	public TowerBlock getHeadBlock() {
		return headBlock;
	}
	public void setHeadBlock(TowerBlock headBlock) {
		this.headBlock = headBlock;
	}
	
	//add block
	public void push(TowerBlock block) {
		if(headBlock == null)
			headBlock = block;
		else {
			TowerBlock currentBlock = headBlock;
			while (currentBlock.getNext() != null) 
				currentBlock = currentBlock.getNext();
				
			currentBlock.setNext(block);
		}
	}
		
	//remove block
	public TowerBlock pop() {
		TowerBlock popBlock = null;
		if (count() == 1) {
			popBlock = headBlock;
			headBlock = null;
		}
		else if (count() > 1) {
			TowerBlock currentBlock = headBlock;
			for(int i = 1; i < count()-1; i++)
				currentBlock = currentBlock.getNext();
			
			
			popBlock = currentBlock.getNext();
			currentBlock.setNext(null);
		}
		
		return popBlock;
	}
	
	//peek block
	public TowerBlock peek() {
		if(count() > 0) {
			TowerBlock currentBlock = headBlock;
			while(currentBlock.getNext() != null) 
				currentBlock = currentBlock.getNext();
			
			return currentBlock;	
		}
		else
			return null;
	}
	
	//count of block in a stack
	public int count() {
		int ctr = 0;
		TowerBlock currentBlock = headBlock;
		while(currentBlock != null) {
			ctr++;
			currentBlock = currentBlock.getNext();
		}
		return ctr;
	}
	public void drawBlocks(Graphics g, int x) {
		TowerBlock currentBlock = headBlock;
		for(int i = 0; i < count(); i++) {
			int xPos = x + (100-currentBlock.getLength())/2;
			int yPos = 180 - (i*20);
			
			g.setColor(Color.lightGray);
			g.fillRect(xPos, yPos, currentBlock.getLength(), 19);
			currentBlock = currentBlock.getNext();
		}
	}
}
