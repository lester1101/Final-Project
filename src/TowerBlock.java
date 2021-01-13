/**
 * @author Lester
 * getter and setter
 */
public class TowerBlock {

	private int length;
	private TowerBlock next;
	
	public TowerBlock(int length) {
		super();
		this.length = length;
		this.next = null;
		
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public TowerBlock getNext() {
		return next;
	}
	public void setNext(TowerBlock next) {
		this.next = next;
	}
}
