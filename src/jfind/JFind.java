package jfind;

import com.drew.imaging.ImageMetadataReader;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;

import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifDirectoryBase;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.exif.GpsDirectory;
import datalog.coord.PointSimple;
import java.util.Comparator;

public class JFind extends JFrame implements Runnable {

    private File fSearchIn;
    private File fCopyIn;
    private JPanel jContentPane = null;
    private JPanel jPanel = null;
    private JPanel fPatternPanel = null;
    private JLabel fPatternLabel = null;
    private JTextField fPatternField = null;
    private JPanel searchInPanel = null;
    private JLabel searchInLabel = null;
    private JTextField searchInField = null;
    private JButton searchInButton = null;
    private JPanel copyInPanel = null;
    private JLabel copyInLabel = null;
    private JTextField copyInField = null;
    private JButton copyInButton = null;
    private JFileChooser fc = new JFileChooser();
    private JPanel searchPanel = null;
    private JButton searchButton = null;
    private boolean searching = false;
    private JList goodList = null;
    private DefaultListModel goodDList = new DefaultListModel();
    private int nbGoodList = 0;
    private long sizeGoodList = 0;
    private JList badList = null;
    private DefaultListModel badDList = new DefaultListModel();
    private int nbBadList = 0;
    private JScrollPane goodScrollPane = null;
    private JScrollPane badScrollPane = null;
    private JPanel goodListPanel = null;
    private JPanel badListPanel = null;
    private JLabel nbGoodLabel = null;
    private JLabel googListNumber = null;
    private JLabel jLabel = null;
    private JLabel badListNumber = null;
    private JPanel gsPanel = null;
    private JPanel jpgPanel = null;
    private JPanel imgPanel = null;
    private Image jpgImg;
    private JTextArea exifInfos = null;
    private JScrollPane exifInfosPane = null;
    private JPanel listsPanel = null;
    private JPanel resultPanel = null;
    private JTree resultTree = null;
    private DefaultTreeModel resultTreeModel = null;
    private JScrollPane resultScrollPane = null;
    private boolean yearsDirectory = true;
    private boolean monthDirectory = true;
    private boolean dayDirectory = false;
    private JPanel moveCopyPanel = null;
    private JLabel jLabel1 = null;
    private JComboBox optDirComboBox = null;
    private JLabel optDirLabel = null;
    private JLabel copyInFreeSpaceLabel = null;
    private JLabel cpiMbLabel = null;
    private JLabel showSearchLabel = null;
    private JButton goButton = null;
    private JPanel moveCopySubPanel = null;
    private ButtonGroup moveCopyButtonGroup = null;
    private JRadioButton copyRadioButton = null;
    private JRadioButton moveRadioButton = null;
    private boolean copy = true;
    private JButton moveCopyOptButton = null;
    private JButton wptExport = null;

    /**
     * This method initializes jPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel() {
        if (jPanel == null) {
            showSearchLabel = new JLabel();
            showSearchLabel.setText("");
            showSearchLabel.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
            showSearchLabel.setName("showSearchLabel");
            showSearchLabel.setPreferredSize(new java.awt.Dimension(680, 16));
            FlowLayout flowLayout5 = new FlowLayout();
            flowLayout5.setAlignment(java.awt.FlowLayout.LEFT);
            jPanel = new JPanel();
            jPanel.setLayout(flowLayout5);
            jPanel.add(getGsPanel(), null);
            jPanel.add(getJpgPanel(), null);
            jPanel.add(getListsPanel(), null);
            jPanel.add(getResultPanel(), null);
            jPanel.add(showSearchLabel, null);
        }
        return jPanel;
    }

    /**
     * This method initializes jPanel1
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel1() {
        if (fPatternPanel == null) {
            FlowLayout flowLayout = new FlowLayout();
            flowLayout.setAlignment(java.awt.FlowLayout.LEFT);
            fPatternLabel = new JLabel();
            fPatternLabel.setText("File pattern :");
            fPatternLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            fPatternPanel = new JPanel();
            fPatternPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            fPatternPanel.setLayout(flowLayout);
            fPatternPanel.setPreferredSize(new java.awt.Dimension(340, 35));
            fPatternPanel.add(fPatternLabel, null);
            fPatternPanel.add(getJTextField(), null);
        }
        return fPatternPanel;
    }

    /**
     * This method initializes jTextField
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJTextField() {
        if (fPatternField == null) {
            fPatternField = new JTextField();
            fPatternField.setPreferredSize(new java.awt.Dimension(150, 20));
            fPatternField.setText("*.jpg");
        }
        return fPatternField;
    }

    /**
     * This method initializes searchInPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel2() {
        if (searchInPanel == null) {
            FlowLayout flowLayout1 = new FlowLayout();
            flowLayout1.setAlignment(java.awt.FlowLayout.LEFT);
            searchInLabel = new JLabel();
            searchInLabel.setText("Search in :");
            searchInLabel.setPreferredSize(new java.awt.Dimension(69, 16));
            searchInPanel = new JPanel();
            searchInPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            searchInPanel.setLayout(flowLayout1);
            searchInPanel.setPreferredSize(new java.awt.Dimension(340, 35));
            searchInPanel.add(searchInLabel, null);
            searchInPanel.add(getJTextField1(), null);
            searchInPanel.add(getJButton1(), null);
        }
        return searchInPanel;
    }

    /**
     * This method initializes jTextField1
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJTextField1() {
        if (searchInField == null) {
            searchInField = new JTextField();
            searchInField.setPreferredSize(new java.awt.Dimension(150, 20));
            searchInField.setText("E:\\Tophe\\CO\\CO-Kirbon\\Photos\\20080929");
            fSearchIn = new File(searchInField.getText());
        }
        return searchInField;
    }

    /**
     * This method initializes jButton1
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton1() {
        if (searchInButton == null) {
            searchInButton = new JButton();
            searchInButton.setText("select ...");
            searchInButton.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {
                    int ret = fc.showOpenDialog(JFind.this);
                    if (ret == JFileChooser.APPROVE_OPTION) {
                        searchInField.setText(fc.getSelectedFile().getPath());
                        fSearchIn = new File(searchInField.getText());
                    }
                    System.out.println("actionPerformed()"); // TODO
                    // Auto-generated
                    // Event
                    // stub
                    // actionPerformed()

                }
            });
        }
        return searchInButton;
    }

    /**
     * This method initializes copyInPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel3() {
        if (copyInPanel == null) {
            cpiMbLabel = new JLabel();
            cpiMbLabel.setText("Mb disponible");
            copyInFreeSpaceLabel = new JLabel();
            copyInFreeSpaceLabel.setText("-");
            copyInFreeSpaceLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
            copyInFreeSpaceLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            copyInFreeSpaceLabel.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
            copyInFreeSpaceLabel.setPreferredSize(new java.awt.Dimension(69, 16));
            FlowLayout flowLayout2 = new FlowLayout();
            flowLayout2.setAlignment(java.awt.FlowLayout.LEFT);
            copyInLabel = new JLabel();
            copyInLabel.setText("Copy in :");
            copyInLabel.setPreferredSize(new java.awt.Dimension(69, 16));
            copyInPanel = new JPanel();
            copyInPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            copyInPanel.setLayout(flowLayout2);
            copyInPanel.setPreferredSize(new java.awt.Dimension(340, 85));
            copyInPanel.add(copyInLabel, null);
            copyInPanel.add(getJTextField2(), null);
            copyInPanel.add(getJButton(), null);
            copyInPanel.add(copyInFreeSpaceLabel, null);
            copyInPanel.add(cpiMbLabel, null);
        }
        return copyInPanel;
    }

    /**
     * This method initializes jTextField2
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJTextField2() {
        if (copyInField == null) {
            copyInField = new JTextField();
            copyInField.setPreferredSize(new java.awt.Dimension(150, 20));
            copyInField.setText("C:\\Temp");
            DefaultMutableTreeNode racine = (DefaultMutableTreeNode) resultTreeModel.getRoot();
            ((ResultNode) racine).setNode(copyInField.getText());

            fCopyIn = new File(copyInField.getText());
            try {
                File f = new File(copyInField.getText());
                if (!f.exists()) {
                    copyInField.setText(new File("").getAbsolutePath());
                }
                long freeSpace = FileSystemUtils.freeSpaceKb(copyInField.getText());
                freeSpace = freeSpace / 1024;
                copyInFreeSpaceLabel.setText(String.valueOf(freeSpace));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return copyInField;
    }

    /**
     * This method initializes jButton
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton() {
        if (copyInButton == null) {
            copyInButton = new JButton();
            copyInButton.setText("select ...");
            copyInButton.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    int ret = fc.showOpenDialog(JFind.this);
                    if (ret == JFileChooser.APPROVE_OPTION) {
                        copyInField.setText(fc.getSelectedFile().getPath());
                        fCopyIn = new File(copyInField.getText());
                        try {
                            long freeSpace = FileSystemUtils.freeSpaceKb(copyInField.getText());
                            freeSpace = freeSpace / 1024;
                            copyInFreeSpaceLabel.setText(String.valueOf(freeSpace));
                            ResultNode racine = (ResultNode) resultTreeModel.getRoot();
                            racine.setNode(copyInField.getText());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        return copyInButton;
    }

    /**
     * This method initializes searchPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getSearchPanel() {
        if (searchPanel == null) {
            searchPanel = new JPanel();
            searchPanel.setPreferredSize(new java.awt.Dimension(340, 35));
            searchPanel.add(getSearchButton(), null);
            searchPanel.add(getGoButton(), null);
            searchPanel.add(getWptExport(), null);
        }
        return searchPanel;
    }

    /**
     * This method initializes searchButton
     *
     * @return javax.swing.JButton
     */
    private JButton getSearchButton() {
        if (searchButton == null) {
            searchButton = new JButton();
            searchButton.setText("Search");
            searchButton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            searchButton.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {
                    System.out.println("Start"); // TODO
                    // Auto-generated
                    // Event stub
                    // actionPerformed()

                    searching = true;
                    go();
                    System.out.println("End"); // TODO

                }
            });
        }
        return searchButton;
    }

    /**
     * This method initializes goodList
     *
     * @return javax.swing.JList
     */
    private JList getGoodList() {
        if (goodList == null) {
            goodList = new JList();
            goodList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            goodList.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
            goodList.setModel(goodDList);
            goodList.setFixedCellHeight(20);
            goodList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {

                public void valueChanged(javax.swing.event.ListSelectionEvent e) {
                    boolean isAdjusting = e.getValueIsAdjusting();
                    if (!isAdjusting) {
                        updateJpgPanel(((FileInfos) goodList.getSelectedValue()).getAbsolutePath());
                        FileInfos fileInfo = (FileInfos) goodList.getSelectedValue();
                        System.out.println(fileInfo.toString()); // TODO Auto-generated Event stub valueChanged()

                    }
                }
            });
        }
        return goodList;
    }

    /**
     * This method initializes badList
     *
     * @return javax.swing.JList
     */
    private JList getBadList() {
        if (badList == null) {
            badList = new JList();
            badList.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
            goodList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            badList.setModel(badDList);
            badList.setFixedCellHeight(20);

        }
        return badList;
    }

    /**
     * This method initializes goodScrollPane
     *
     * @return javax.swing.JScrollPane
     */
    private JScrollPane getGoodScrollPane() {
        if (goodScrollPane == null) {
            goodScrollPane = new JScrollPane();
            goodScrollPane.setPreferredSize(new java.awt.Dimension(350, 165));
            goodScrollPane.setViewportView(getGoodList());
        }
        return goodScrollPane;
    }

    /**
     * This method initializes badScrollPane
     *
     * @return javax.swing.JScrollPane
     */
    private JScrollPane getBadScrollPane() {
        if (badScrollPane == null) {
            badScrollPane = new JScrollPane();
            badScrollPane.setPreferredSize(new java.awt.Dimension(350, 85));
            badScrollPane.setViewportView(getBadList());
        }
        return badScrollPane;
    }

    /**
     * This method initializes goodListPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getGoodListPanel() {
        if (goodListPanel == null) {
            googListNumber = new JLabel();
            googListNumber.setText("0");
            googListNumber.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
            FlowLayout flowLayout3 = new FlowLayout();
            flowLayout3.setAlignment(java.awt.FlowLayout.LEFT);
            nbGoodLabel = new JLabel();
            nbGoodLabel.setText("Good files found :");
            goodListPanel = new JPanel();
            goodListPanel.setLayout(flowLayout3);
            goodListPanel.setPreferredSize(new java.awt.Dimension(356, 200));
            goodListPanel.add(nbGoodLabel, null);
            goodListPanel.add(googListNumber, null);
            goodListPanel.add(getGoodScrollPane(), null);
        }
        return goodListPanel;
    }

    /**
     * This method initializes badListPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getBadListPanel() {
        if (badListPanel == null) {
            badListNumber = new JLabel();
            badListNumber.setText("0");
            badListNumber.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
            FlowLayout flowLayout4 = new FlowLayout();
            flowLayout4.setAlignment(java.awt.FlowLayout.LEFT);
            jLabel = new JLabel();
            jLabel.setText("Files matching but not (or bad, or without exif infos) jpeg :");
            badListPanel = new JPanel();
            badListPanel.setLayout(flowLayout4);
            badListPanel.setPreferredSize(new java.awt.Dimension(356, 120));
            badListPanel.add(jLabel, null);
            badListPanel.add(badListNumber, null);
            badListPanel.add(getBadScrollPane(), null);
        }
        return badListPanel;
    }

    /**
     * This method initializes gsPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getGsPanel() {
        if (gsPanel == null) {
            gsPanel = new JPanel();
            gsPanel.setPreferredSize(new java.awt.Dimension(360, 320));
            gsPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            gsPanel.add(getJPanel1(), null);
            gsPanel.add(getJPanel2(), null);
            gsPanel.add(getJPanel3(), null);
            gsPanel.add(getMoveCopyPanel(), null);
            gsPanel.add(getSearchPanel(), null);
        }
        return gsPanel;
    }

    /**
     * This method initializes imgPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJpgPanel() {
        if (jpgPanel == null) {
            jpgPanel = new JPanel();
            jpgPanel.setPreferredSize(new java.awt.Dimension(320, 320));
            jpgPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            jpgPanel.add(getImgPanel(), null);
            jpgPanel.add(getExifInfosPane(), null);
        }
        return jpgPanel;
    }

    private void updateJpgPanel(String fileName) {
        File f = new File(fileName);

        try {
            Metadata metadata = ImageMetadataReader.readMetadata(f);
            Directory d = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
            exifInfos.setText(f.length() + " bytes\n");
            for (Tag tag : d.getTags()) {
                exifInfos.setText(exifInfos.getText() + "\n" + tag.toString());
            }
            d = metadata.getFirstDirectoryOfType(GpsDirectory.class);
            for (Tag tag : d.getTags()) {
                exifInfos.setText(exifInfos.getText() + "\n" + tag.toString());
            }

            exifInfos.moveCaretPosition(0);
            jpgImg = ImageIO.read(f);
            Graphics g = imgPanel.getGraphics();
            g.drawImage(jpgImg, 2, 2, imgPanel.getWidth() - 4, imgPanel.getHeight() - 4, imgPanel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method initializes imgPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getImgPanel() {
        if (imgPanel == null) {
            imgPanel = new JPanel();
            imgPanel.setPreferredSize(new java.awt.Dimension(300, 200));
            imgPanel.setBackground(java.awt.Color.white);

            imgPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        }
        return imgPanel;
    }

    /**
     * This method initializes exifInfos
     *
     * @return javax.swing.JTextArea
     */
    private JTextArea getExifInfos() {
        if (exifInfos == null) {
            exifInfos = new JTextArea();
            exifInfos.setName("exifInfos");
            exifInfos.setEditable(false);
        }
        return exifInfos;
    }

    /**
     * This method initializes exifInfosPane
     *
     * @return javax.swing.JScrollPane
     */
    private JScrollPane getExifInfosPane() {
        if (exifInfosPane == null) {
            exifInfosPane = new JScrollPane();
            exifInfosPane.setPreferredSize(new java.awt.Dimension(300, 100));
            exifInfosPane.setViewportView(getExifInfos());
        }
        return exifInfosPane;
    }

    /**
     * This method initializes listsPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getListsPanel() {
        if (listsPanel == null) {
            listsPanel = new JPanel();
            listsPanel.setPreferredSize(new java.awt.Dimension(360, 340));
            listsPanel.add(getGoodListPanel(), null);
            listsPanel.add(getBadListPanel(), null);
        }
        return listsPanel;
    }

    /**
     * This method initializes resultPanel1
     *
     * @return javax.swing.JPanel
     */
    private JPanel getResultPanel() {
        if (resultPanel == null) {
            resultPanel = new JPanel();
            resultPanel.setPreferredSize(new java.awt.Dimension(320, 340));
            resultPanel.add(getResultScrollPane(), null);
        }
        return resultPanel;
    }

    /**
     * This method initializes resultTree
     *
     * @return javax.swing.JTree
     */
    private JTree getResultTree() {
        if (resultTree == null) {
            resultTree = new JTree();
            resultTree.setModel(resultTreeModel);
            resultTree.setCellRenderer(new ResultNodeRenderer());
            resultTree.setRowHeight(20);
            resultTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {

                public void valueChanged(javax.swing.event.TreeSelectionEvent event) {
                    Object o = event.getNewLeadSelectionPath().getLastPathComponent();
                    FileInfos fi = null;

                    if (o instanceof ResultNode) {
                        fi = ((ResultNode) o).getFileInfos();
                    } else {
                        fi = ((DoublonNode) o).getFileInfos();
                    }

                    goodList.setSelectedValue(fi, true);
                    updateJpgPanel(fi.getAbsolutePath());

                }
            });
        }
        return resultTree;
    }

    /**
     * This method initializes resultScrollPane
     *
     * @return javax.swing.JScrollPane
     */
    private JScrollPane getResultScrollPane() {
        if (resultScrollPane == null) {
            resultScrollPane = new JScrollPane();
            resultScrollPane.setPreferredSize(new java.awt.Dimension(310, 330));
            resultScrollPane.setViewportView(getResultTree());
        }
        return resultScrollPane;
    }

    /**
     * This method initializes moveCopyPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getMoveCopyPanel() {
        if (moveCopyPanel == null) {
            optDirLabel = new JLabel();
            optDirLabel.setText("Cr�ation de sous r�pertoires :");
            FlowLayout flowLayout6 = new FlowLayout();
            flowLayout6.setAlignment(java.awt.FlowLayout.LEFT);
            jLabel1 = new JLabel();
            jLabel1.setText("Option de creation des  repertoires : ");
            moveCopyPanel = new JPanel();
            moveCopyPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            moveCopyPanel.setLayout(flowLayout6);
            moveCopyPanel.setPreferredSize(new java.awt.Dimension(340, 100));
//			moveCopyPanel.add(jLabel1, null);
            moveCopyPanel.add(optDirLabel, null);
            moveCopyPanel.add(getOptDirComboBox(), null);
            moveCopyPanel.add(getMoveCopySubPanel(), null);
            moveCopyPanel.add(getMoveCopyOptButton(), null);
        }
        return moveCopyPanel;
    }

    /**
     * This method initializes optDirComboBox
     *
     * @return javax.swing.JComboBox
     */
    private JComboBox getOptDirComboBox() {
        if (optDirComboBox == null) {
            optDirComboBox = new JComboBox(new String[]{"Ann�e/Mois/Jour", "Ann�e/Mois", "Ann�e", "none"});
            optDirComboBox.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
            optDirComboBox.setSelectedIndex(1);
            optDirComboBox.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {
                    JComboBox cb = (JComboBox) e.getSource();
                    int i = cb.getSelectedIndex();
                    switch (i) {
                        case 0:
                            yearsDirectory = true;
                            monthDirectory = true;
                            dayDirectory = true;
                            break;
                        case 1:
                            yearsDirectory = true;
                            monthDirectory = true;
                            dayDirectory = false;
                            break;
                        case 2:
                            yearsDirectory = true;
                            monthDirectory = false;
                            dayDirectory = false;
                            break;
                        case 3:
                            yearsDirectory = false;
                            monthDirectory = false;
                            dayDirectory = false;
                            break;
                    }
                    updateResultTree();
                }
            });
        }
        return optDirComboBox;
    }

    /**
     * This method initializes goButton
     *
     * @return javax.swing.JButton
     */
    private JButton getGoButton() {
        if (goButton == null) {
            goButton = new JButton();
            goButton.setText("Copier");
            goButton.setPreferredSize(new java.awt.Dimension(100, 26));
            goButton.setEnabled(false);
            goButton.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {
                    if (copy) {
                        copyJpegFiles();
                    } else {
                        moveJpegFiles();
                    }
                }
            });
        }
        return goButton;
    }

    /**
     * This method initializes moveCopySubPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getMoveCopySubPanel() {
        if (moveCopySubPanel == null) {
            FlowLayout flowLayout7 = new FlowLayout();
            flowLayout7.setAlignment(java.awt.FlowLayout.LEFT);
            moveCopySubPanel = new JPanel();
            moveCopyButtonGroup = new ButtonGroup();
            moveCopySubPanel.setLayout(flowLayout7);
            moveCopySubPanel.setPreferredSize(new java.awt.Dimension(230, 60));
            moveCopyButtonGroup.add(getCopyRadioButton());
            moveCopyButtonGroup.add(getMoveRadioButton());
            moveCopySubPanel.add(getCopyRadioButton(), null);
            moveCopySubPanel.add(getMoveRadioButton(), null);

        }
        return moveCopySubPanel;
    }

    /**
     * This method initializes copyRadioButton
     *
     * @return javax.swing.JRadioButton
     */
    private JRadioButton getCopyRadioButton() {
        if (copyRadioButton == null) {
            copyRadioButton = new JRadioButton();
            copyRadioButton.setText("copie des fichiers sources");
            copyRadioButton.setSelected(true);
            copyRadioButton.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {
                    goButton.setText("Copier");
                    copy = true;
                }
            });
        }
        return copyRadioButton;
    }

    /**
     * This method initializes moveRadioButton
     *
     * @return javax.swing.JRadioButton
     */
    private JRadioButton getMoveRadioButton() {
        if (moveRadioButton == null) {
            moveRadioButton = new JRadioButton();
            moveRadioButton.setName("");
            moveRadioButton.setText("d�placement des fichiers sources");
            moveRadioButton.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {
                    goButton.setText("D�placer");
                    copy = false;
                }
            });
        }
        return moveRadioButton;
    }

    /**
     * This method initializes moveCopyOptButton
     *
     * @return javax.swing.JButton
     */
    private JButton getMoveCopyOptButton() {
        if (moveCopyOptButton == null) {
            moveCopyOptButton = new JButton();
            moveCopyOptButton.setText("Options ...");
        }
        return moveCopyOptButton;
    }

    /**
     * This method initializes wptExport
     *
     * @return javax.swing.JButton
     */
    private JButton getWptExport() {
        if (wptExport == null) {
            wptExport = new JButton();
            wptExport.setText("Wpt Export");
            wptExport.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {
                    exportWptFiles(); // TODO Auto-generated Event stub actionPerformed()

                }
            });
        }
        return wptExport;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFind jf = new JFind();
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    /**
     * This is the default constructor
     */
    public JFind() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     *
     * @return void
     */
    private void initialize() {
        /*		try {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception e){
        e.printStackTrace();
        }
         */
        this.setSize(705, 743);
        resultTreeModel = new DefaultTreeModel(new ResultNode("root"));
        this.setMinimumSize(new java.awt.Dimension(500, 109));
        this.setPreferredSize(new java.awt.Dimension(350, 210));
        this.setContentPane(getJContentPane());
        this.setTitle("JFrame");
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

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
            jContentPane.add(getJPanel(), java.awt.BorderLayout.CENTER);
        }
        return jContentPane;
    }

    private void go() {
//		go(new File( searchInField.getText()), convert(fPatternField.getText()));

        new Thread(this).start();
    }

    private void go(File root, String pattern) {
        String[] fileList = root.list();
        DefaultMutableTreeNode racine = (DefaultMutableTreeNode) resultTreeModel.getRoot();

        racine.removeAllChildren();
        goodDList.removeAllElements();
        nbGoodList = 0;
        sizeGoodList = 0;
        badDList.removeAllElements();
        nbBadList = 0;
        resultTreeModel.reload();

        if (fileList != null) {
            Pattern p;
            p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
            checkForFile(root.getAbsolutePath(), p, fileList);
        }
    }

    public void run() {
        searchButton.setEnabled(false);
        go(new File(searchInField.getText()), convert(fPatternField.getText()));
        searchButton.setEnabled(true);
    }

    private void updateResultTree() {
        DefaultMutableTreeNode racine = (DefaultMutableTreeNode) resultTreeModel.getRoot();
        racine.removeAllChildren();
        resultTreeModel.reload();
        Enumeration e = goodDList.elements();

        while (e.hasMoreElements()) {
            FileInfos fi = (FileInfos) e.nextElement();
            updateResultTree(fi);
        }

    }

    private void updateResultTree(FileInfos fi) {
        DefaultMutableTreeNode racine = (DefaultMutableTreeNode) resultTreeModel.getRoot();
        ResultNode rn = null, tmpNode = null, parentNode = null,
                yearNode = null, monthNode = null, dayNode = null;
        boolean found = false;

        parentNode = (ResultNode) racine;

        if (yearsDirectory) {
            String y = String.valueOf(fi.getYear());
            Enumeration e = racine.children();
            while (e.hasMoreElements()) {
                rn = (ResultNode) e.nextElement();
                if (y.equals(rn.toString())) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                tmpNode = new ResultNode(y, parentNode);
                racine.add(tmpNode);
                rn = tmpNode;
            }

            yearNode = rn;
            parentNode = yearNode;

            if (monthDirectory) {
                found = false;
                String m = fi.getMonth() < 10 ? "0" + String.valueOf(fi.getMonth()) : String.valueOf(fi.getMonth());
                e = yearNode.children();
                while (e.hasMoreElements()) {
                    rn = (ResultNode) e.nextElement();
                    if (m.equals(rn.toString())) {
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    tmpNode = new ResultNode(m, yearNode);
                    yearNode.add(tmpNode);
                    rn = tmpNode;
                }

                monthNode = rn;
                parentNode = monthNode;

                if (dayDirectory) {
                    found = false;
                    String d = (fi.getDay() < 10) ? "0" + String.valueOf(fi.getDay()) : String.valueOf(fi.getDay());
                    e = monthNode.children();
                    while (e.hasMoreElements()) {
                        rn = (ResultNode) e.nextElement();
                        if (d.equals(rn.toString())) {
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        tmpNode = new ResultNode(d, monthNode);
                        monthNode.add(tmpNode);
                        dayNode = tmpNode;
                    } else {
                        dayNode = rn;
                    }

                    parentNode = dayNode;
                }
            }
        }

        found = false;
        rn = null;
        Enumeration e = parentNode.children();
        while (e.hasMoreElements()) {
            rn = (ResultNode) e.nextElement();
            if (fi.getNewNameWithExtension().equals(rn.toString())) {
                found = true;
                break;
            }
        }

        if ((!found) || (rn == null)) {
            parentNode.add(new ResultNode(fi.getNewNameWithExtension(), false, fi, parentNode));
        } else {
            DoublonNode dn1 = null, dn2 = null;

            if (rn.isLeaf()) {
                dn1 = new DoublonNode((FileInfos) rn.getFileInfosList().get(0), rn); //+" ("+rn.getFileInfos().getSize()+")")

                rn.add(dn1);
            }
            dn2 = new DoublonNode(fi, rn);
            rn.add(dn2); //+" ("+fi.getSize()+")"));

            rn.addFileInfos(fi);
            if (dn1 != null) {
                dn1.updateExistInfo();
            }
            dn2.updateExistInfo();
        }
        resultTreeModel.reload();

        // Expand row if node
        e = ((DefaultMutableTreeNode) resultTree.getModel().getRoot()).preorderEnumeration();
        while (e.hasMoreElements()) {
            Object o = e.nextElement();
            if (o instanceof ResultNode) {
                rn = (ResultNode) o;
                if (!rn.isLeaf()) {
                    resultTree.expandPath(new TreePath(rn.getPath()));
                }
            }
        }
    }

    private void checkForFile(String rootDir, Pattern p, String[] fileList) {
        if (null != fileList) {
            for (int i = 0; i < fileList.length; i++) {
                File f = new File(rootDir, fileList[i]);

                if (f.isDirectory()) {
                    String ap = f.getAbsolutePath();
                    String path = f.getPath();

                    showSearchLabel.setText(ap);
                    checkForFile(path, p, f.list());
                } else {
                    Matcher m = p.matcher(f.getName());
                    if (m.matches()) {
                        FileInfos fi = null;
                        String ap = f.getAbsolutePath();
                        try {
                            showSearchLabel.setText(ap);

                            System.out.format("[[%s]]\n", f.getName());

                            Metadata metadata = ImageMetadataReader.readMetadata(f);

                            for (Directory directory : metadata.getDirectories()) {
                                for (Tag tag : directory.getTags()) {
                                    if (tag.getTagName().contentEquals("Date/Time Digitized")&&(! (directory instanceof  ExifSubIFDDirectory))) {
                                        System.out.format(" - %s \n", directory.getClass().toString());
                                        System.out.format("  [%s] - %s = %s\n",
                                                directory.getName(), tag.getTagName(), tag.getDescription());
                                    }
                                }
                                if (directory.hasErrors()) {
                                    for (String error : directory.getErrors()) {
                                        System.err.format("ERROR: %s", error);
                                    }
                                }
                            }

                            if (metadata != null) {
                                Directory d = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
                                if (d != null) {
                                    String dt = d.getDescription(ExifSubIFDDirectory.TAG_DATETIME_DIGITIZED);
                                    if (dt != null) {
                                        fi = new FileInfos(f.getAbsolutePath(), f.length(), true, true, dt);
                                        goodDList.addElement(fi);
                                        nbGoodList++;
                                        sizeGoodList += f.length();
                                        googListNumber.setText(String.valueOf(nbGoodList) + " (" + String.valueOf(sizeGoodList / 1048576) + " Mb)");
                                        updateResultTree(fi);
                                    } else {
                                        fi = new FileInfos(f.getAbsolutePath(), f.length(), true, false, dt);
                                        badDList.addElement(fi);
                                        nbBadList++;
                                        badListNumber.setText(String.valueOf(nbBadList));
                                    }
                                } else {
                                    fi = new FileInfos(f.getAbsolutePath());
                                    badDList.addElement(fi);
                                    nbBadList++;
                                    badListNumber.setText(String.valueOf(nbBadList));
                                }
                            } else {
                                fi = new FileInfos(f.getAbsolutePath());
                                badDList.addElement(fi);
                                nbBadList++;
                                badListNumber.setText(String.valueOf(nbBadList));
                            }

                        } catch (Exception e) {
                            if (e.getMessage().compareTo("not a jpeg file") == 0) {
                                fi = new FileInfos(f.getAbsolutePath());
                                badDList.addElement(fi);
                                nbBadList++;
                                googListNumber.setText(String.valueOf(nbGoodList));
                            } else {
                                e.printStackTrace();
                            }

                        }
                    }
                }
            }

            showSearchLabel.setText("");

            StringBuffer copyInSizeString = new StringBuffer(copyInFreeSpaceLabel.getText());
            if (!"-".contentEquals(copyInSizeString)) {
                long copyInSize = Long.parseLong(copyInSizeString.toString());
                if (goodDList.size() > 0 && ((sizeGoodList / 1048576) < copyInSize)) {
                    goButton.setEnabled(true);
                }
            }
        }
    }

    private void copyJpegFiles() {
        String CopyInDir = copyInField.getText();
        File rootDir = new File(CopyInDir);

        Object o = null;
        ResultNode rn = null;
        Enumeration e = ((DefaultMutableTreeNode) resultTree.getModel().getRoot()).preorderEnumeration();

        while (e.hasMoreElements()) {
            o = e.nextElement();

            if (o instanceof ResultNode) {
                rn = (ResultNode) o;
                if ((!rn.isLeaf()) && (rn.isDir())) {
                    TreeNode tn[] = rn.getPath();
                    String fp = ((ResultNode) tn[0]).toString();

                    for (int i = 1; i < tn.length; i++) {
                        fp = fp + File.separator + ((ResultNode) tn[i]).toString();
                    }

                    File dir = new File(fp);
                    if (dir.exists()) {
                        if (!dir.isDirectory()) {
                            // Lancer une exception
                        }
                    } else {
                        dir.mkdir();
                    }
                } else {

                    // 
                    if (rn.isLeaf() && (rn.getFileInfosList().size() == 1)) {
                        if (!rn.exist()) {
                            File sf = new File(rn.getFileInfos().getAbsolutePath());
                            File df = new File(rn.getTreeFilePath());

                            try {
                                FileUtils.copyFile(sf, df);
                            } catch (Exception exp) {
                                exp.printStackTrace();
                            }
                        }
                    }
                }
            } else {
                DoublonNode dn = (DoublonNode) o;
                // It's not a ResultNode 
                if (dn.haveSameSize) {
                    // Suivant les options suppprimer le fichier source
                } else {
                    if (!dn.exist()) {
                        File sf = new File(dn.getFileInfos().getAbsolutePath());
                        File df = new File(dn.getTreeFilePath());
                        try {
                            FileUtils.copyFile(sf, df);
                        } catch (Exception exp) {
                            exp.printStackTrace();
                        }
                    }
                }
            }

        }
    }

    private void moveJpegFiles() {
        String CopyInDir = copyInField.getText();
        File rootDir = new File(CopyInDir);

        Object o = null;
        ResultNode rn = null;
        Enumeration e = ((DefaultMutableTreeNode) resultTree.getModel().getRoot()).preorderEnumeration();

        while (e.hasMoreElements()) {
            o = e.nextElement();

            if (o instanceof ResultNode) {
                rn = (ResultNode) o;
                if ((!rn.isLeaf()) && (rn.isDir())) {
                    String fp = rn.getTreeFilePath();
                    File dir = new File(fp);
                    if (dir.exists()) {
                        if (!dir.isDirectory()) {
                            // Lancer une exception
                        }
                    } else {
                        dir.mkdir();
                    }
                } else {

                    // 
                    if (rn.isLeaf() && (rn.getFileInfosList().size() == 1)) {
                        if (!rn.exist()) {
                            File sf = new File(rn.getFileInfos().getAbsolutePath());
                            File df = new File(rn.getTreeFilePath());

                            try {
                                if (!sf.renameTo(df)) {
                                    int toto = 0;
                                }
                            } catch (Exception exp) {
                                exp.printStackTrace();
                            }
                        }
                    }
                }
            } else {
                DoublonNode dn = (DoublonNode) o;
                // It's not a ResultNode 
                if (dn.haveSameSize) {
                    // Suivant les options suppprimer le fichier source
                } else {
                    if (!dn.exist()) {
                        File sf = new File(dn.getFileInfos().getAbsolutePath());
                        File df = new File(dn.getTreeFilePath());
                        if (!sf.renameTo(df)) {
                            int toto = 0;
                        }
                    }
                }
            }

        }
    }

    private String convert(String fileName) {
        String convertedFileName = "";

        for (int i = 0; i < fileName.length(); i++) {
            char ch = fileName.charAt(i);
            switch (ch) {
                case '*':
                    convertedFileName += "(.*)";
                    break;
                case '?':
                    convertedFileName += "(.)";
                    break;
                case '.':
                    convertedFileName += "\\.";
                    break;
                default:
                    convertedFileName += ch;
            }
        }

        /*
         * The caret matches the beginning of a string.
         * The dollar sign matches the end of a string.
         */
        return "^" + convertedFileName + "$";
    }

    private void exportWptFiles() {
        JFindGpsLog l = new JFindGpsLog(null, null);
        String CopyInDir = copyInField.getText();
        File rootDir = new File(CopyInDir);

        Object o = null;
        ResultNode rn = null;
        Enumeration e = ((DefaultMutableTreeNode) resultTree.getModel().getRoot()).preorderEnumeration();

        while (e.hasMoreElements()) {
            o = e.nextElement();

            if (o instanceof ResultNode) {
                rn = (ResultNode) o;
                if ((!rn.isLeaf()) && (rn.isDir())) {
                } else {

                    // 
                    if (rn.isLeaf() && (rn.getFileInfosList().size() == 1)) {
                        if (!rn.exist()) {
                            File sf = new File(rn.getFileInfos().getAbsolutePath());
                            try {
                                System.out.format("[[%s]]\n", sf.getName());

                                Metadata metadata = ImageMetadataReader.readMetadata(sf);;

                                for (Directory directory : metadata.getDirectories()) {
                                    for (Tag tag : directory.getTags()) {
                                        if (tag.getTagName().contentEquals("Date/Time Digitized")) {
                                            System.out.format(" - %s \n", directory.getClass().toString());
                                            System.out.format("  [%s] - %s = %s\n",
                                                    directory.getName(), tag.getTagName(), tag.getDescription());
                                        }
                                    }
                                    if (directory.hasErrors()) {
                                        for (String error : directory.getErrors()) {
                                            System.err.format("ERROR: %s", error);
                                        }
                                    }
                                }

                                Directory d = metadata.getFirstDirectoryOfType(GpsDirectory.class);
                                //Iterator tags = d.getTagIterator();
//                                System.out.println(sf.getName());
//
//                                HashMap map = ((GpsDirectory) d).getTagNameMap();
//                                while (tags.hasNext()) {
//                                    Tag tag = (Tag) tags.next();
//                                    System.out.println(tag.toString());
//                                }
                                JFindPointGps pt = JFindGpsDescriptor.getPointGps((GpsDirectory) d);
                                l.addPoint(pt);
                                System.out.println(pt.toString() + "\n----");
                            } catch (Exception exp) {
                                exp.printStackTrace();
                            }

                        }
                    }
                }
            } else {
                DoublonNode dn = (DoublonNode) o;
                // It's not a ResultNode 
                if (dn.haveSameSize) {
                    // Suivant les options suppprimer le fichier source
                } else {
                    if (!dn.exist()) {
                    }
                }
            }

        }

        //     Collections.sort( l.getList(), ((Comparator)new ComparePointGPSByDate()));
        try {
            JFindDxfExport jfDxf = new JFindDxfExport("test.dxf", l);
            jfDxf.writeDxf();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    private class ComparePointGPSByDate implements Comparator {

        public int compare(Object p1, Object p2) {
            return ((PointSimple) p2).getGCDate().after(((PointSimple) p1).getGCDate()) ? 0 : 1;
        }
    }
} // @jve:decl-index=0:visual-constraint="10,10"
