package com.guiiii.diplom.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.guiiii.diplom.koefandenums.FactorsHelper;
import com.guiiii.diplom.util.FactorsFrameListener;
import javax.swing.SwingConstants;

public class FactorsFrame extends JFrame {

	private JPanel contentPane;
	private JTextField d1;
	private JTextField z1;
	private JTextField d2;
	private JTextField z2;
	private JTextField d3;
	private JTextField z3;
	private JTextField d4;
	private JTextField z4;
	private JTextField d5;
	private JTextField z5;
	private JTextField d6;
	private JTextField textField_11;
	private JLabel lzo;
	private JTextField zo;
	private JLabel lfd;
	private JTextField fd;
	private JLabel lpv;
	private JTextField pv;
	private JLabel lsp;
	private JTextField sp;
	private JTextField mp;
	private JLabel lmp;
	private JTextField lab;
	private JTextField prk;
	private JTextField sem;
	private JLabel ltype1;
	private JTextField type1;
	private JLabel ltype2;
	private JTextField type2;
	private JSeparator separator_1;
	private JPanel panel_2;
	private JLabel lkr1;
	private JTextField kr1;
	private JSeparator separator;
	private JLabel lkr2;
	private JTextField kr2;
	private JPanel panel_3;
	private JLabel lkpr1;
	private JTextField kpr1;
	private JSeparator separator_2;
	private JLabel lkpr2;
	private JTextField kpr2;
	private JPanel panel_4;
	private JLabel lpruch;
	private JTextField pruch;
	private JSeparator separator_3;
	private JLabel lprpro;
	private JTextField prpro;
	private JLabel lprdip;
	private JTextField prdip;
	private JLabel lgos;
	private JTextField gos;
	private JPanel panel_5;
	private JLabel ldipruc;
	private JTextField dipruc;
	private JSeparator separator_4;
	private JLabel leccons;
	private JTextField eccons;
	private JLabel lohrtrud;
	private JTextField ohrtrud;


	public FactorsFrame(FactorsFrameListener ffl) {
		mFactorsFrameListener = ffl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(510, 680);
		contentPane = new JPanel();
		contentPane.setBorder(UIManager.getBorder("FileChooser.listViewBorder"));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u041A\u043E\u044D\u0444\u0444\u0438\u0446\u0438\u0435\u043D\u0442 Kn", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		
		lzo = new JLabel("\u0417\u041E");
		
		zo = new JTextField();
		zo.setColumns(10);
		
		lfd = new JLabel("\u0424\u0414");
		
		fd = new JTextField();
		fd.setColumns(6);
		
		lpv = new JLabel("\u041F\u0412");
		
		pv = new JTextField();
		pv.setColumns(6);
		
		lsp = new JLabel("\u0421\u041F");
		
		sp = new JTextField();
		sp.setColumns(6);
		
		mp = new JTextField();
		mp.setColumns(10);
		
		lmp = new JLabel("\u041C\u041F");
		
		JLabel llab = new JLabel("\u041B\u0430\u0431. ");
		
		lab = new JTextField();
		lab.setColumns(10);
		
		JLabel lprk = new JLabel("\u041F\u0440\u043A. ");
		
		prk = new JTextField();
		prk.setColumns(10);
		
		JLabel lsem = new JLabel("\u0421\u0435\u043C.");
		
		sem = new JTextField();
		sem.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u041A\u043B\u0430\u0441\u0441 \u0434\u0438\u0441\u0446\u0438\u043F\u043B\u0438\u043D", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u041A\u0443\u0440\u0441\u043E\u0432\u0430\u044F \u0440\u0430\u0431\u043E\u0442\u0430", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		
		lkr1 = new JLabel("1 вид");
		panel_2.add(lkr1);
		
		kr1 = new JTextField();
		kr1.setColumns(4);
		panel_2.add(kr1);
		
		separator = new JSeparator();
		panel_2.add(separator);
		
		lkr2 = new JLabel("  2 вид");
		panel_2.add(lkr2);
		
		kr2 = new JTextField();
		kr2.setColumns(4);
		panel_2.add(kr2);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "\u041A\u0443\u0440\u0441\u043E\u0432\u043E\u0439 \u043F\u0440\u043E\u0435\u043A\u0442", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		
		lkpr1 = new JLabel("1 вид");
		panel_3.add(lkpr1);
		
		kpr1 = new JTextField();
		kpr1.setColumns(4);
		panel_3.add(kpr1);
		
		separator_2 = new JSeparator();
		panel_3.add(separator_2);
		
		lkpr2 = new JLabel("  2 вид");
		panel_3.add(lkpr2);
		
		kpr2 = new JTextField();
		kpr2.setColumns(4);
		panel_3.add(kpr2);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u041F\u0440\u0430\u043A\u0442\u0438\u043A\u0430", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		
		lpruch = new JLabel("\u0423\u0447\u0435\u0431\u043D\u0430\u044F");
		panel_4.add(lpruch);
		
		pruch = new JTextField();
		pruch.setColumns(4);
		panel_4.add(pruch);
		
		separator_3 = new JSeparator();
		panel_4.add(separator_3);
		
		lprpro = new JLabel("  Произв.");
		panel_4.add(lprpro);
		
		prpro = new JTextField();
		prpro.setColumns(4);
		panel_4.add(prpro);
		
		panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "\u0414\u0438\u043F\u043B\u043E\u043C\u043D\u043E\u0435 \u043F\u0440\u043E\u0435\u043A\u0442\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u0435", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		
		ldipruc = new JLabel("\u0420\u0443\u043A\u043E\u0432\u043E\u0434\u0441\u0442\u0432\u043E");
		panel_5.add(ldipruc);
		
		dipruc = new JTextField();
		dipruc.setColumns(4);
		panel_5.add(dipruc);
		
		separator_4 = new JSeparator();
		panel_5.add(separator_4);
		
		leccons = new JLabel("  Ек. консультация");
		panel_5.add(leccons);
		
		eccons = new JTextField();
		eccons.setColumns(4);
		panel_5.add(eccons);
		
		lohrtrud = new JLabel("  Охр. труда");
		lohrtrud.setToolTipText("");
		panel_5.add(lohrtrud);
		
		ohrtrud = new JTextField();
		ohrtrud.setColumns(4);
		panel_5.add(ohrtrud);
		
		JButton button = new JButton("\u0421\u0442\u0430\u043D\u0434\u0430\u0440\u0442\u043D\u044B\u0435");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d1.setText("1.00");
				z1.setText("0.50");
				d2.setText("1.14");
				z2.setText("0.63");
				d3.setText("1.25");
				z3.setText("0.72");
				d4.setText("1.32");
				z4.setText("0.76");
				d5.setText("1.67");
				z5.setText("1.00");
				d6.setText("5.00");
				zo.setText("0.25");
				fd.setText("0.5");
				pv.setText("1.0");
				sp.setText("1.0");
				mp.setText("1.0");
				lab.setText("2.0");
				prk.setText("1.33");
				sem.setText("1.0");
				type1.setText("1.0");
				type2.setText("1.2");
				kr1.setText("2.0");
				kr2.setText("3.0");
				kpr1.setText("3.0");
				kpr2.setText("4.0");
				pruch.setText("2.70");
				prpro.setText("0.90");
				prdip.setText("2.0");
				gos.setText("1.4");
				dipruc.setText("3.3");
				eccons.setText("0.40");
				ohrtrud.setText("0.20");
				vstup.setText("10");
				asp.setText("100");
				doc.setText("50");
				stag.setText("50");
			}
		});
		
		JButton button_1 = new JButton("\u041F\u0440\u043E\u0448\u043B\u044B\u0435");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObjectInputStream in;
				try {
					in = new ObjectInputStream(
							new FileInputStream("lastFactors.srl"));
					in.readObject();
					FactorsHelper fh1 = (FactorsHelper) in.readObject();
					
					d1.setText("" + fh1.dayliFirst);
					z1.setText("" + fh1.zaochFirst);
					d2.setText("" + fh1.dayliSecond);
					z2.setText("" + fh1.zaochSecond);
					d3.setText("" + fh1.dayliThird);
					z3.setText("" + fh1.zaochThird);
					d4.setText("" + fh1.dayliFourth);
					z4.setText("" + fh1.zaochFourth);
					d5.setText("" + fh1.dayliSpecialist);
					z5.setText("" + fh1.zaochSpecialist);
					d6.setText("" + fh1.dayliMagistr);
					zo.setText("" + fh1.lectionZO);
					fd.setText("" + fh1.lectionPS);
					pv.setText("" + fh1.lectionPV);
					sp.setText("" + fh1.lectionSP);
					mp.setText("" + fh1.lectionMP);
					lab.setText("" + fh1.laboratories);
					prk.setText("" + fh1.practical);
					sem.setText("" + fh1.seminar);
					type1.setText("" + fh1.classTypeFirst);
					type2.setText("" + fh1.classTypeSecond);
					kr1.setText("" + fh1.kursWorkFirst);
					kr2.setText("" + fh1.kursWorkSecond);
					kpr1.setText("" + fh1.kursProjectFirst);
					kpr2.setText("" + fh1.kursProjectSecond);
					pruch.setText("" + fh1.studingPructic);
					prpro.setText("" + fh1.workingPructic);
					prdip.setText("" + fh1.underGruduptedPractic);
					gos.setText("" + fh1.stateExam);
					dipruc.setText("" + fh1.diplomaGuide);
					eccons.setText("" + fh1.diplomaEcomomicConsultation);
					ohrtrud.setText("" + fh1.diplomaHealthSafe);
					vstup.setText("" + fh1.vstup);
					asp.setText("" + fh1.asp);
					doc.setText("" + fh1.doc);
					stag.setText("" + fh1.stag);
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
			}
		});
		
		JButton button_2 = new JButton("\u041E\u043A");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isOk = true;
				for(JTextField jtf: content.keySet()) {
					content.get(jtf).setForeground(Color.BLACK);
				}
				for(JTextField jtf: content.keySet()) {
					try{
						Float.parseFloat(jtf.getText());
						//content.get(jtf).getF
					} catch (Exception e1) {
						isOk = false;
						content.get(jtf).setForeground(Color.RED);
					}
				}
				if(isOk == true) {
					
					fh.dayliFirst = Float.parseFloat(d1.getText());
					fh.dayliSecond = Float.parseFloat(d2.getText());
					fh.dayliThird  = Float.parseFloat(d3.getText());
					fh.dayliFourth = Float.parseFloat(d4.getText());
					fh.dayliSpecialist = Float.parseFloat(d5.getText());
					fh.dayliMagistr   = Float.parseFloat(d6.getText());
					fh.zaochFirst = Float.parseFloat(z1.getText());
					fh.zaochSecond = Float.parseFloat(z2.getText());
					fh.zaochThird = Float.parseFloat(z3.getText());
					fh.zaochFourth = Float.parseFloat(z4.getText());
					fh.zaochSpecialist = Float.parseFloat(z5.getText());
					fh.lectionZO = Float.parseFloat(zo.getText());
					fh.lectionPS = Float.parseFloat(fd.getText());
					fh.lectionPV = Float.parseFloat(pv.getText());
					fh.lectionSP = Float.parseFloat(sp.getText());
					fh.lectionMP = Float.parseFloat(mp.getText());
					fh.laboratories = Float.parseFloat(lab.getText());
					fh.practical = Float.parseFloat(prk.getText());
					fh.seminar = Float.parseFloat(sem.getText());
					fh.classTypeFirst = Float.parseFloat(type1.getText());
					fh.classTypeSecond = Float.parseFloat(type2.getText());
					fh.kursWorkFirst = Float.parseFloat(kr1.getText());
					fh.kursWorkSecond = Float.parseFloat(kr2.getText());
					fh.kursProjectFirst = Float.parseFloat(kpr1.getText());
					fh.kursProjectSecond = Float.parseFloat(kpr2.getText());
					fh.studingPructic = Float.parseFloat(pruch.getText());
					fh.workingPructic = Float.parseFloat(prpro.getText());
					fh.underGruduptedPractic = Float.parseFloat(prdip.getText());
					fh.stateExam = Float.parseFloat(gos.getText());
					fh.diplomaGuide = Float.parseFloat(dipruc.getText());
					fh.diplomaEcomomicConsultation = Float.parseFloat(eccons.getText());
					fh.diplomaHealthSafe = Float.parseFloat(ohrtrud.getText());
					fh.vstup = Float.parseFloat(vstup.getText());
					fh.asp   = Float.parseFloat(asp.getText());
					fh.doc   = Float.parseFloat(doc.getText());
					fh.stag  = Float.parseFloat(stag.getText());
					
					System.out.println(stag.getText());
					
					try {
						ObjectOutputStream out = new ObjectOutputStream(
								new FileOutputStream("lastFactors.srl"));
						out.writeObject("date");
						out.writeObject(fh);
						out.close();
					} catch (FileNotFoundException e1) {
						System.out.println("File not found");
					} catch (IOException e2) {
						System.out.println("IOException");
					}
			
					
					mFactorsFrameListener.okBtnClick(fh);
					
					dispose();
				}
			}
		});
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u0414\u0440\u0443\u0433\u043E\u0435", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(9)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(llab)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lab, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
											.addComponent(lprk, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(prk, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lzo)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(zo, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
											.addGap(18)
											.addComponent(lfd)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(fd, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
											.addGap(18)
											.addComponent(lpv)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(pv, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(24)
											.addComponent(lsp)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(sp, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
											.addGap(18)
											.addComponent(lmp)
											.addGap(2)
											.addComponent(mp, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lsem, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
											.addGap(4)
											.addComponent(sem, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)))
									.addGap(4))
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(button)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(button_1)
									.addPreferredGap(ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
									.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(mp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lmp))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(fd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lfd))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lzo)
							.addComponent(zo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(pv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lpv))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(sp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lsp)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lsem))
						.addComponent(sem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(prk, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lprk))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(llab)
							.addComponent(lab, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1)
						.addComponent(button_2))
					.addContainerGap())
		);
		
		JLabel lvstup = new JLabel("Вступ. экз.");
		panel_6.add(lvstup);
		
		vstup = new JTextField();
		vstup.setColumns(4);
		panel_6.add(vstup);
		
		JLabel lasp = new JLabel("  Асп.");
		panel_6.add(lasp);
		
		asp = new JTextField();
		asp.setColumns(4);
		panel_6.add(asp);
		
		JLabel ldoc = new JLabel("  Док.");
		panel_6.add(ldoc);
		
		doc = new JTextField();
		doc.setColumns(4);
		panel_6.add(doc);
		
		JLabel lstag = new JLabel("  Стаж.");
		panel_6.add(lstag);
		
		stag = new JTextField();
		stag.setColumns(4);
		panel_6.add(stag);
		
		lprdip = new JLabel("  Преддипл.");
		panel_4.add(lprdip);
		
		prdip = new JTextField();
		prdip.setColumns(4);
		panel_4.add(prdip);
		
		lgos = new JLabel("  Гос");
		panel_4.add(lgos);
		
		gos = new JTextField();
		gos.setColumns(4);
		panel_4.add(gos);
		
		ltype1 = new JLabel("1 вид  дисциплин");
		panel_1.add(ltype1);
		
		type1 = new JTextField();
		type1.setColumns(5);
		panel_1.add(type1);
		
		separator_1 = new JSeparator();
		panel_1.add(separator_1);
		
		ltype2 = new JLabel("  2 вид дисциплин");
		panel_1.add(ltype2);
		
		type2 = new JTextField();
		type2.setColumns(5);
		panel_1.add(type2);
		
		JLabel label = new JLabel("\u041A\u0443\u0440\u0441/\u0424\u043E\u0440\u043C\u0430");
		
		JLabel k1 = new JLabel("1 \u043A\u0443\u0440\u0441");
		
		JLabel k2 = new JLabel("2 \u043A\u0443\u0440\u0441");
		
		JLabel k3 = new JLabel("3 \u043A\u0443\u0440\u0441");
		
		JLabel k4 = new JLabel("4 \u043A\u0443\u0440\u0441");
		
		JLabel k5 = new JLabel("\u0421\u043F\u0435\u0446\u0438\u0430\u043B\u0438\u0441\u0442");
		
		JLabel label_6 = new JLabel("\u0417\u0430\u043E\u0447\u043D\u0430\u044F");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_7 = new JLabel("\u0414\u043D\u0435\u0432\u043D\u0430\u044F");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		
		d1 = new JTextField();
		d1.setColumns(10);
		
		z1 = new JTextField();
		z1.setColumns(10);
		
		d2 = new JTextField();
		d2.setColumns(10);
		
		z2 = new JTextField();
		z2.setColumns(10);
		
		d3 = new JTextField();
		d3.setColumns(10);
		
		z3 = new JTextField();
		z3.setColumns(10);
		
		d4 = new JTextField();
		d4.setColumns(10);
		
		z4 = new JTextField();
		z4.setColumns(10);
		
		d5 = new JTextField();
		d5.setColumns(10);
		
		z5 = new JTextField();
		z5.setColumns(10);
		
		JLabel k6 = new JLabel("\u041C\u0430\u0433\u0438\u0441\u0442\u0440");
		
		d6 = new JTextField();
		d6.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setEnabled(false);
		textField_11.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
						.addComponent(k5, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
						.addComponent(k4, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
						.addComponent(k3, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
						.addComponent(k2, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
						.addComponent(k1, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
						.addComponent(k6, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(d6, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
						.addComponent(label_7, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
						.addComponent(d5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
						.addComponent(d4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
						.addComponent(d1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
						.addComponent(d2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
						.addComponent(d3, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_11, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_6, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
							.addGap(2))
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(z4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
							.addComponent(z1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
							.addComponent(z3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
							.addComponent(z2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
							.addComponent(z5, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(d1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(k1))
							.addGap(6)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(d2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(k2))
							.addGap(6)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(d3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(k3))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(d4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(k4, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(d5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(k5))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(d6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(k6)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(z1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(z2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(z3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(z4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(z5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		content.put(d1, k1);
		content.put(z1, k1);
		content.put(d2, k2);
		content.put(z2, k2);
		content.put(d3, k3);
		content.put(z3, k3);
		content.put(d4, k4);
		content.put(z4, k4);
		content.put(d5, k5);
		content.put(z5, k5);
		content.put(d6, k6);
		content.put(zo, lzo);
		content.put(fd, lfd);
		content.put(pv, lpv);
		content.put(sp, lsp);
		content.put(mp, lmp);
		content.put(lab, llab);
		content.put(prk, lprk);
		content.put(sem, lsem);
		content.put(type1, ltype1);
		content.put(type2, ltype2);
		content.put(kr1, lkr1);
		content.put(kr2, lkr2);
		content.put(kpr1, lkpr1);
		content.put(kpr2, lkpr2);
		content.put(pruch, lpruch);
		content.put(prpro, lprpro);
		content.put(prdip, lprdip);
		content.put(gos, lgos);
		content.put(dipruc, ldipruc);
		content.put(eccons, leccons);
		content.put(ohrtrud, lohrtrud);
		content.put(vstup, lvstup);
		content.put(asp, lasp);
		content.put(doc, ldoc);
		content.put(stag, lstag);
		
	}
	
	private Map<JTextField,  JLabel> content = new HashMap<JTextField, JLabel>();
	FactorsFrameListener mFactorsFrameListener;
	private FactorsHelper fh = new FactorsHelper();
	private JTextField vstup;
	private JTextField asp;
	private JTextField doc;
	private JTextField stag;
}
