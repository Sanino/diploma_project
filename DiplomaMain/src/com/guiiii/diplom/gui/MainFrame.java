package com.guiiii.diplom.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.guiiii.diplom.parcers.DisciplineParser;
import com.guiiii.diplom.parcers.KafedrasParser;
import com.guiiii.diplom.util.MainFrameListener;
import java.awt.Insets;
import javax.swing.ImageIcon;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5670635704597921251L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public MainFrame(MainFrameListener mainframeListener) {
		mMainFrameListener = mainframeListener;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 352);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		menuBar.add(mnNewMenu_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JButton btnSetFactors = new JButton("Set factors");
		btnSetFactors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mMainFrameListener.setFactors();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Set staff");
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//mMainFrameListener.setStuff();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							StaffFrame frame = new StaffFrame(mMainFrameListener);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		JButton btnSetStudingPlan = new JButton("Set studing plan");
		panel.add(btnSetStudingPlan);
		btnSetStudingPlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooser.setCurrentDirectory(new File ("."));
				int result = chooser.showOpenDialog(MainFrame.this);
				
				if ( result == JFileChooser.APPROVE_OPTION)
				{	
					File file = chooser.getSelectedFile();
					
					int parserResult = disParser.open(file, mMainFrameListener);
					if ( parserResult == 1)
					{
						JOptionPane.showMessageDialog(MainFrame.this , "�������� ������ �����!", "������", JOptionPane.ERROR_MESSAGE);
						
					}
					else if ( parserResult == 2) {
						JOptionPane.showMessageDialog(MainFrame.this , "�������� ������ ������� Excel", "������", JOptionPane.ERROR_MESSAGE);
					}
					else {
						
					}
				}
			}
		});
		
		JButton btnSetKafedras = new JButton("Set kafedras");
		btnSetKafedras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooser.setCurrentDirectory(new File ("."));
				int result = chooser.showOpenDialog(MainFrame.this);
				
				if ( result == JFileChooser.APPROVE_OPTION)
				{	
					File file = chooser.getSelectedFile();
					
					int parserResult = kafParser.open(file, mMainFrameListener);
					if ( parserResult == 1)
					{
						JOptionPane.showMessageDialog(MainFrame.this , "�������� ������ �����!", "������", JOptionPane.ERROR_MESSAGE);
						
					}
					else if ( parserResult == 2) {
						JOptionPane.showMessageDialog(MainFrame.this , "�������� ������ ������� Excel", "������", JOptionPane.ERROR_MESSAGE);
					}
					else {
						
					}
				}
			}
		});
		panel.add(btnSetKafedras);
		panel.add(btnSetFactors);
		
		btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							mMainFrameListener.calculate();
			}
		});
		btnNewButton.setEnabled(false);
		panel.add(btnNewButton);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		button.setIcon(new ImageIcon(MainFrame.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setMargin(new Insets(2, 4, 2, 2));
		textArea.setLineWrap(true);
		textArea.setTabSize(4);
		textArea.setEditable(false);
		textArea.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		scrollPane.setViewportView(textArea);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblStatus);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.WEST);
		
		checkBoxNagr = new JCheckBox("Общий штат");
		checkBoxNagr.setForeground(Color.BLACK);
		checkBoxNagr.setEnabled(false);
		
		chckbxUch = new JCheckBox("\u0423\u0447\u0435\u0431\u043D\u044B\u0439 \u043F\u043B\u0430\u043D");
		chckbxUch.setForeground(Color.BLACK);
		chckbxUch.setEnabled(false);
		
		chckbxkoef = new JCheckBox("Коэффициенты");
		chckbxkoef.setForeground(Color.BLACK);
		chckbxkoef.setEnabled(false);
		
		checkBoxkaf = new JCheckBox("Данные кафедр");
		checkBoxkaf.setForeground(Color.BLACK);
		checkBoxkaf.setEnabled(false);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(checkBoxNagr)
						.addComponent(chckbxUch, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkBoxkaf)
						.addComponent(chckbxkoef))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(48)
					.addComponent(checkBoxNagr)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxUch, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(checkBoxkaf)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxkoef)
					.addContainerGap(64, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		chooser = new JFileChooser();
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Документ Microsoft Excel 97 - 2003 (*.xls)", "xls", "XLS");
		chooser.setFileFilter(filter);
	}
	
	public void checkFactors(boolean ch) {
		chckbxkoef.setSelected(true);
	}
	
	public void checkPlan(boolean ch) {
		chckbxUch.setSelected(true);
	}
	
	public void checkStaff(boolean ch) {
		checkBoxNagr.setSelected(true);
	}
	
	public void checkKaf(boolean ch) {
		checkBoxkaf.setSelected(true);
	}
	
	
	public void setCanStarted() {
		btnNewButton.setEnabled(true);
	}
	
	public void addToLog(String str) {
		textArea.append(str + '\n');
	}
	
	MainFrameListener mMainFrameListener;
	private JFileChooser chooser;
	private DisciplineParser disParser = new DisciplineParser();
	private KafedrasParser kafParser = new KafedrasParser ();
	private JCheckBox chckbxkoef;
	
	private JButton btnNewButton;
	private JCheckBox chckbxUch;
	private JCheckBox checkBoxNagr;
	private JCheckBox checkBoxkaf;
	
	private JTextArea textArea;
}
