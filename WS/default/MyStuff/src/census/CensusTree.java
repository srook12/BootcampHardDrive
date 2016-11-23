package census;

import java.util.LinkedList;
import java.util.List;

public class CensusTree {
	private class CensusTreeNode {
		long value;
		boolean firstAccessed = true;
		
		CensusTreeNode parent;
		List<CensusTreeNode> children = new LinkedList<CensusTreeNode>();
		
		long getValue() { return value; }
		
		boolean getFirstAccessed() { return firstAccessed; }	
		void setFirstAccessed(boolean firstAccessed) { this.firstAccessed = firstAccessed; }
	}
	
	private CensusTreeNode root;
}
