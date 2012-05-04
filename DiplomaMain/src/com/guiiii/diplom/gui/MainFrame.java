package com.guiiii.diplom.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.guiiii.diplom.parcers.DisciplineParser;
import com.guiiii.diplom.util.MainFrameListener;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;

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
		setBounds(100, 100, 450, 300);
		
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
				mMainFrameListener.setStuff();
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
					
					int parserResult = parser.open(file, mMainFrameListener);
					if ( parserResult == 1)
					{
						JOptionPane.showMessageDialog(MainFrame.this , "Неверный формат файла!", "Ошибка", JOptionPane.ERROR_MESSAGE);
						
					}
					else if ( parserResult == 2) {
						JOptionPane.showMessageDialog(MainFrame.this , "Неверный формат таблицы Excel", "Ошибка", JOptionPane.ERROR_MESSAGE);
					}
					else {
						
					}
				}
			}
		});
		panel.add(btnSetFactors);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.setEnabled(false);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		lblNapr = new JLabel(" ");
		
		lblKaf = new JLabel(" ");
		
		lblDis = new JLabel("");
		
		lblWorks = new JLabel("");
		
		lblCon = new JLabel("");
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNapr)
						.addComponent(lblKaf)
						.addComponent(lblDis)
						.addComponent(lblWorks)
						.addComponent(lblCon))
					.addContainerGap(209, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(34)
					.addComponent(lblNapr)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblKaf)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDis)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblWorks)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCon)
					.addContainerGap(46, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblStatus);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.WEST);
		
		JCheckBox checkBoxNagr = new JCheckBox("\u0428\u0442\u0430\u0442 \u0443\u043D\u0438\u0432\u0435\u0440\u0441\u0438\u0442\u0435\u0442\u0430");
		checkBoxNagr.setForeground(Color.BLACK);
		checkBoxNagr.setEnabled(false);
		
		JCheckBox chckbxUch = new JCheckBox("\u0423\u0447\u0435\u0431\u043D\u044B\u0439 \u043F\u043B\u0430\u043D");
		chckbxUch.setForeground(Color.BLACK);
		chckbxUch.setEnabled(false);
		
		chckbxNewCheckBox = new JCheckBox("\u041A\u043E\u044D\u0444\u0444\u0438\u0446\u0438\u0435\u043D\u0442\u044B \u0440\u0430\u0441\u0447\u0435\u0442\u0430");
		chckbxNewCheckBox.setForeground(Color.BLACK);
		chckbxNewCheckBox.setEnabled(false);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addContainerGap()
							.addComponent(checkBoxNagr))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addContainerGap()
							.addComponent(chckbxUch, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addContainerGap()
							.addComponent(chckbxNewCheckBox)))
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
					.addComponent(chckbxNewCheckBox)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		chooser = new JFileChooser();
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Таблица Microsoft Excel 97 - 2003 (*.xls)", "xls", "XLS");
		chooser.setFileFilter(filter);
	}
	
	public void checkFactors(boolean ch) {
		chckbxNewCheckBox.setSelected(true);
	}
	
	public void checkPlan(boolean ch) {
		chckbxNewCheckBox.setSelected(true);
	}
	
	public void checkNapr(int napr) {
		lblNapr.setText("Кол-во направлений - " + napr);
	}
	
	public void checkKaf(int kaf) {
		lblKaf.setText("Кол-во кафедр - " + kaf);
	}
	
	public void checkDis(int dis) {
		lblDis.setText("Кол-во дисциплин - " + dis);
	}
	
	public void checkWorks(int w) {
		lblWorks.setText("Кол-во других работ - " + w);
	}
	
	public void checkKon(int k) {
		lblCon.setText("Общий контингент - " + k);
	}
	
	MainFrameListener mMainFrameListener;
	private JFileChooser chooser;
	private DisciplineParser parser = new DisciplineParser();
	private JCheckBox chckbxNewCheckBox;
	private JLabel lblNapr;
	private JLabel lblKaf;
	private JLabel lblDis;
	private JLabel lblWorks;
	private JLabel lblCon;
}
