package jfind;

import java.io.File;
import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

public class ResultNode extends DefaultMutableTreeNode {
  String name;
  boolean isDirectory  = true;
  boolean alreadyExist = false;
  ArrayList fis = new ArrayList();
//  FileInfos fi = null;  // TODO ArrayList si la source existe plusieurs fois
  
  public ResultNode(String n, boolean isDir, FileInfos f, ResultNode parentNode ) {
	  this.name = n;
	  this.isDirectory = isDir;
	  this.fis.add(f);
	  File file = new File( this.getTreeFilePath(parentNode));
	  alreadyExist = file.exists();
  }
  
  public ResultNode(String n, ResultNode parentNode) {
	  this.name = n;
	  this.isDirectory = true;
	  
	  File file = new File( this.getTreeFilePath(parentNode));
	  alreadyExist = file.exists();
  }

  public ResultNode(String n) {
	  this.name = n;
	  this.isDirectory = true;
	  
	  File file = new File( this.getTreeFilePath());
	  alreadyExist = file.exists();
  }

  public void setNode( String n, boolean isDir, FileInfos f ) {
	  this.name = n;
	  this.isDirectory = isDir;
	  this.fis.add(f);
  }
  
  public void setNode( String n) {
	  this.name = n;
	  this.isDirectory = true;
	  File file = new File( this.getTreeFilePath());
	  alreadyExist = file.exists();
  }
  
  public String toString() {
	  return name;
  }
  
  public FileInfos getFileInfos() {
	  return (FileInfos)fis.get(0);
  }
  
  public ArrayList getFileInfosList() {
	  return fis;
  }

  
  public FileInfos getFileInfos(int index) {
	  return (FileInfos)fis.get(index);
  }
  
  public void addFileInfos(FileInfos fi) {
	  this.fis.add(fi);
  }

  public String getTreeFilePath( ResultNode parentNode) {
	  
	    TreeNode tn[] = parentNode.getPath();
	    String fp = ((ResultNode)tn[0]).toString();
	    
	    for( int i = 1; i < tn.length; i++) {
		   fp = fp + File.separator+ ((ResultNode)tn[i]).toString();
	    }
	    fp = fp + File.separator+ this.toString();
	    
	    return fp;
  }
  
  public String getTreeFilePath( ) {
	    TreeNode tn[] = this.getPath();
	    String fp = ((ResultNode)tn[0]).toString();
	    
	    for( int i = 1; i < tn.length; i++) {
		   fp = fp + File.separator+ ((ResultNode)tn[i]).toString();
	    }
	    
	    return fp;
	  }

  
  public boolean isDir() {
	  return isDirectory;
  }
  
  public boolean exist() {
	  return alreadyExist;
  }

}
