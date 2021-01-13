import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BlockPop {

	@Test
	public void blockpop() {
		TowerStack ts = new TowerStack();
		assertEquals(null, ts.pop());
	}

	@Test
	public void peekpop() {
		TowerStack ts = new TowerStack();
		assertEquals(null, ts.peek());
	}
}
