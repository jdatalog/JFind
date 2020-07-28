package jfind;

import java.io.File;
import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

public class DoublonNode extends DefaultMutableTreeNode {
    String           name  = null;
	FileInfos           fi = null;
	int              index = 1;
    boolean    haveSameSize = false;
    boolean    alreadyExist = false;
      
	public DoublonNode() {
	}

	public DoublonNode( FileInfos f, ResultNode rn) {
		this.fi     = f;
		   
	    if (rn == null) {
	      index = 1;
	    } else {
	      Enumeration e = rn.children();
	      int    i = 1;
	     
	     while (e.hasMoreElements()) {
	       DoublonNode dn = (DoublonNode)e.nextElement();
	       if ( dn.fi.getSize() == this.fi.getSize()) {
	         haveSameSize = true;
	    	 break;
	       } else {
		     i++;
	       }
	      }
	    
	     this.index = i;
	     
      }
	    

	}

	public void  updateExistInfo() {
      File file = new File(this.getTreeFilePath());
	  alreadyExist = file.exists();
	}
	
	   public String getNewName() {
		     String baseName = fi.getNewName();
		     String name;
		     int    i = 1;
		     int    countHaveNotSameSize = 0;
		     
		     ResultNode rn = (ResultNode)this.getParent();
		     Enumeration e = rn.children();
		     while (e.hasMoreElements()) {
		       DoublonNode dn = (DoublonNode)e.nextElement();
		       if (! dn.haveSameSize) countHaveNotSameSize++;
			 }
		     
		     name = (index < 10) ? baseName + "_0" + this.index: baseName + "_" + this.index;
		     return countHaveNotSameSize == 1 ? baseName : name;
		   }

	   public String getNewNameWithExtension() {
			 return this.getNewName() + ".jpg";
	   }
	   
	   public String getNewName(ResultNode parent) {
		     String baseName = fi.getNewName();
		     String name;
		     int    i = 1;
		     int    countHaveNotSameSize = 0;
		     
		     Enumeration e = parent.children();
		     while (e.hasMoreElements()) {
		       DoublonNode dn = (DoublonNode)e.nextElement();
		       if (! dn.haveSameSize) countHaveNotSameSize++;
			 }
		       if (! this.haveSameSize) countHaveNotSameSize++;
		     
		     name = (index < 10) ? baseName + "_0" + this.index: baseName + "_" + this.index;
		     return countHaveNotSameSize == 1 ? baseName : name;
		   }

	   public String getNewNameWithExtension(ResultNode parent) {
			 return this.getNewName(parent) + ".jpg";
	   }
	   
	   public String toString() {
			 return this.getNewNameWithExtension()+" ("+this.fi.getSize()+"bytes)";
	  }

	   public boolean haveSameSize() {
			 return haveSameSize;
	  }
	   
	   public FileInfos getFileInfos() {
			  return fi;
		  }

	   public String getTreeFilePath() {
		    TreeNode tn[] = this.getPath();
		    String fp = ((ResultNode)tn[0]).toString();
		    
		    for( int i = 1; i < tn.length - 2; i++) {
			   fp = fp + File.separator+ ((ResultNode)tn[i]).toString();
		    }
			fp = fp + File.separator+ ((DoublonNode)tn[tn.length-1]).getNewNameWithExtension();
		    
		    return fp;
		}

	   public String getTreeFilePath( ResultNode parent) {
		    TreeNode tn[] = parent.getPath();
		    String fp = ((ResultNode)tn[0]).toString();
		    
		    for( int i = 1; i < tn.length - 1; i++) {
			   fp = fp + File.separator+ ((ResultNode)tn[i]).toString();
		    }
			fp = fp + File.separator+ this.getNewNameWithExtension(parent);
		    
		    return fp;
		}

	   public boolean exist() {
			  return alreadyExist;
		  }

}
