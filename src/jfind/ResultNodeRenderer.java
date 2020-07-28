package jfind;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultTreeCellRenderer;

public class ResultNodeRenderer extends DefaultTreeCellRenderer {
	
  public Component getTreeCellRendererComponent(JTree tree, Object value,
                            boolean selected, boolean expanded, boolean leaf, int row,
		                    boolean hasFocus) {


    boolean changeIcon = false;
    
    this.setTextNonSelectionColor(Color.BLACK);
    
	if ( value instanceof ResultNode) {
		ResultNode rn = (ResultNode)value;
		if (rn.getFileInfosList().size()>1)  {
			this.setTextNonSelectionColor(Color.RED);
			changeIcon = true;
		} else {
		  if( rn.exist() ) {
	        this.setTextNonSelectionColor(Color.BLUE);
		  }
		}
	} else {
		if ( value instanceof DoublonNode) {
			DoublonNode dn = (DoublonNode)value;
			if (dn.exist()) {
			    this.setTextNonSelectionColor(Color.BLUE);
			} else {
			  if (dn.haveSameSize()) {
			    this.setTextNonSelectionColor(Color.LIGHT_GRAY);
			  }
			}
		}
	}
	
    super.getTreeCellRendererComponent(tree,value, selected, expanded, leaf, row,hasFocus);

    if (changeIcon) {
      this.setIcon(UIManager.getIcon("Tree.leafIcon"));
    }
    
	return this;
  }
}
