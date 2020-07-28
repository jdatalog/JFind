package jfind;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;

public class OptsJFind extends JDialog {

	private JPanel jContentPane = null;
	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JLabel copyOptLabel = null;
	private JCheckBox ecraserDestBox = null;

	/**
	 * This is the default constructor
	 */
	public OptsJFind() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanel1(), java.awt.BorderLayout.NORTH);
			jContentPane.add(getJPanel(), java.awt.BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setPreferredSize(new java.awt.Dimension(50,50));
		}
		return jPanel;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			FlowLayout flowLayout = new FlowLayout();
			flowLayout.setAlignment(java.awt.FlowLayout.LEFT);
			copyOptLabel = new JLabel();
			copyOptLabel.setText("Options lors de la copie de fichier :");
			jPanel1 = new JPanel();
			jPanel1.setLayout(flowLayout);
			jPanel1.setPreferredSize(new java.awt.Dimension(10,70));
			jPanel1.add(copyOptLabel, null);
			jPanel1.add(getEcraserDestBox(), null);
		}
		return jPanel1;
	}

	/**
	 * This method initializes ecraserDestBox	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getEcraserDestBox() {
		if (ecraserDestBox == null) {
			ecraserDestBox = new JCheckBox();
			ecraserDestBox.setText("Ecraser le fichier destination si il existe");
			ecraserDestBox.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
		}
		return ecraserDestBox;
	}

}  //  @jve:decl-index=0:visual-constraint="211,33"
