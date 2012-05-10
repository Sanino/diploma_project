package com.guiiii.diplom.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.guiiii.diplom.parcers.DisciplineParser;
import com.guiiii.diplom.parcers.KafedrasParser;
import com.guiiii.diplom.parcers.ReportSaver;
import com.guiiii.diplom.uchchast.Employment;
import com.guiiii.diplom.util.MainFrameListener;

public class MainFrame extends JFrame {

    /**
	 *
	 */
    private static final long serialVersionUID = 5670635704597921251L;
    private final JPanel contentPane;

    MainFrameListener mMainFrameListener;

    private final JFileChooser chooser;

    private final DisciplineParser disParser = new DisciplineParser();

    private final KafedrasParser kafParser = new KafedrasParser();

    private final JCheckBox chckbxkoef;

    private final JButton btnNewButton;

    private final JCheckBox chckbxUch;

    private final JCheckBox checkBoxNagr;
    private final JCheckBox checkBoxkaf;
    private final JTextArea textArea;

    /**
     * Create the frame.
     */
    public MainFrame(MainFrameListener mainframeListener) {
        setResizable(false);
        mMainFrameListener = mainframeListener;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 787, 450);

        final JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        final JMenu mnNewMenu = new JMenu("Файл");
        menuBar.add(mnNewMenu);
        
        JMenuItem menuItem = new JMenuItem("Открыть");
        mnNewMenu.add(menuItem);
        
        JMenuItem menuItem_1 = new JMenuItem("Сохранить");
        mnNewMenu.add(menuItem_1);
        
        JSeparator separator = new JSeparator();
        mnNewMenu.add(separator);
        
        JMenuItem menuItem_2 = new JMenuItem("Выход");
        menuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        mnNewMenu.add(menuItem_2);

        mnNewMenu_1 = new JMenu("Отчет");
        mnNewMenu_1.setEnabled(false);
        menuBar.add(mnNewMenu_1);
        
        menu = new JMenu("Отчет по кафедрам");
        mnNewMenu_1.add(menu);
        

        
        menu_1 = new JMenu("Отчет по направлениям");
        mnNewMenu_1.add(menu_1);
        
        
        
        
        
        JMenu mnNewMenu_2 = new JMenu("Помощь");
        menuBar.add(mnNewMenu_2);
        
        JMenuItem menuItem_4 = new JMenuItem("Помощь");
        mnNewMenu_2.add(menuItem_4);
        
        JMenuItem menuItem_5 = new JMenuItem("О программе");
        mnNewMenu_2.add(menuItem_5);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        final JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);

        final JButton btnSetFactors = new JButton("Установить коэффициенты");
        btnSetFactors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mMainFrameListener.setFactors();
            }
        });

        final JButton btnNewButton_1 = new JButton("Задать штат");
        panel.add(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // mMainFrameListener.setStuff();
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            final StaffFrame frame = new StaffFrame(
                                    mMainFrameListener);
                            frame.setVisible(true);
                        } catch (final Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        final JButton btnSetStudingPlan = new JButton("Задать уч. план");
        panel.add(btnSetStudingPlan);
        btnSetStudingPlan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooser.setCurrentDirectory(new File("."));
                final int result = chooser.showOpenDialog(MainFrame.this);

                if (result == JFileChooser.APPROVE_OPTION) {
                    final File file = chooser.getSelectedFile();

                    final int parserResult = disParser.open(file,
                            mMainFrameListener);
                    if (parserResult == 1) {
                        JOptionPane.showMessageDialog(MainFrame.this,
                                "�������� ������ �����!", "������",
                                JOptionPane.ERROR_MESSAGE);

                    } else if (parserResult == 2) {
                        JOptionPane.showMessageDialog(MainFrame.this,
                                "�������� ������ ������� Excel", "������",
                                JOptionPane.ERROR_MESSAGE);
                    } else {

                    }
                }
            }
        });

        final JButton btnSetKafedras = new JButton("Задать доп. работы");
        btnSetKafedras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooser.setCurrentDirectory(new File("."));
                final int result = chooser.showOpenDialog(MainFrame.this);

                if (result == JFileChooser.APPROVE_OPTION) {
                    final File file = chooser.getSelectedFile();

                    final int parserResult = kafParser.open(file,
                            mMainFrameListener);
                    if (parserResult == 1) {
                        JOptionPane.showMessageDialog(MainFrame.this,
                                "�������� ������ �����!", "������",
                                JOptionPane.ERROR_MESSAGE);

                    } else if (parserResult == 2) {
                        JOptionPane.showMessageDialog(MainFrame.this,
                                "�������� ������ ������� Excel", "������",
                                JOptionPane.ERROR_MESSAGE);
                    } else {

                    }
                }
            }
        });
        panel.add(btnSetKafedras);
        panel.add(btnSetFactors);

        btnNewButton = new JButton("Расчитать");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mMainFrameListener.calculate();
            }
        });
        btnNewButton.setEnabled(false);
        panel.add(btnNewButton);

        final JButton button = new JButton("");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        button.setIcon(new ImageIcon(MainFrame.class
                .getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
        panel.add(button);

        final JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new BorderLayout(0, 0));

        final JScrollPane scrollPane = new JScrollPane();
        panel_1.add(scrollPane, BorderLayout.CENTER);

        textArea = new JTextArea();
        textArea.setWrapStyleWord(true);
        textArea.setMargin(new Insets(2, 4, 2, 2));
        textArea.setLineWrap(true);
        textArea.setTabSize(4);
        textArea.setEditable(false);
        textArea.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
        scrollPane.setViewportView(textArea);

        final JPanel panel_3 = new JPanel();
        contentPane.add(panel_3, BorderLayout.WEST);

        checkBoxNagr = new JCheckBox("Общий штат");
        checkBoxNagr.setEnabled(false);
        checkBoxNagr.setFocusable(false);
        checkBoxNagr.setDoubleBuffered(true);
        checkBoxNagr.setForeground(Color.BLACK);

        chckbxUch = new JCheckBox(
                "\u0423\u0447\u0435\u0431\u043D\u044B\u0439 \u043F\u043B\u0430\u043D");
        chckbxUch.setEnabled(false);
        chckbxUch.setDoubleBuffered(true);
        chckbxUch.setForeground(Color.BLACK);

        chckbxkoef = new JCheckBox("Коэффициенты");
        chckbxkoef.setEnabled(false);
        chckbxkoef.setDoubleBuffered(true);
        chckbxkoef.setForeground(Color.BLACK);

        checkBoxkaf = new JCheckBox("Данные кафедр");
        checkBoxkaf.setEnabled(false);
        checkBoxkaf.setDoubleBuffered(true);
        checkBoxkaf.setForeground(Color.BLACK);
        final GroupLayout gl_panel_3 = new GroupLayout(panel_3);
        gl_panel_3.setHorizontalGroup(
            gl_panel_3.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel_3.createSequentialGroup()
                    .addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
                        .addComponent(checkBoxNagr)
                        .addComponent(chckbxUch, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkBoxkaf)
                        .addComponent(chckbxkoef))
                    .addContainerGap(12, Short.MAX_VALUE))
        );
        gl_panel_3.setVerticalGroup(
            gl_panel_3.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel_3.createSequentialGroup()
                    .addGap(117)
                    .addComponent(checkBoxNagr)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(chckbxUch, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(checkBoxkaf)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(chckbxkoef, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(137))
        );
        panel_3.setLayout(gl_panel_3);

        chooser = new JFileChooser();

        final FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Документ Microsoft Excel 97 - 2003 (*.xls)", "xls", "XLS");
        chooser.setFileFilter(filter);
    }

    public void addToLog(String str) {
        textArea.append(str + '\n');
    }

    public void checkFactors(boolean ch) {
        chckbxkoef.setSelected(true);
    }

    public void checkKaf(boolean ch) {
        checkBoxkaf.setSelected(true);
    }

    public void checkPlan(boolean ch) {
        chckbxUch.setSelected(true);
    }

    public void checkStaff(boolean ch) {
        checkBoxNagr.setSelected(true);
    }

    public void setCanStarted() {
        btnNewButton.setEnabled(true);
    }
    
    public void canReport(final List<Employment> emplo) {
           mEmplo = emplo;
           Set <String> kaf = new HashSet<String>();
           Set <String> napr = new HashSet<String>();
           for (Employment e: emplo) {
               kaf.add(e.getKafedra());
               napr.add(e.getNapr());
           }
           
           for(String s: kaf) {
               final JMenuItem mntmTest = new JMenuItem(s);
               menu.add(mntmTest);
               mntmTest.addActionListener(new ActionListener() {
                   public void actionPerformed(ActionEvent e) {
                       mntmTest.getText();
                   }
               });
           }
           
           for(String s: napr) {
               final JMenuItem mntmTest = new JMenuItem(s);
               menu_1.add(mntmTest);
               mntmTest.addActionListener(new ActionListener() {
                   public void actionPerformed(ActionEvent e) {
                       mntmTest.getText();
                   }
               });
           }
           
           JMenuItem menuItem_3 = new JMenuItem("Общий отчет");
           menuItem_3.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   JFileChooser c = new JFileChooser();
                   c.setSelectedFile(new File("Общие.xls"));
                   //c.setfi
                   // Demonstrate "Save" dialog:
                   int rVal = c.showSaveDialog(MainFrame.this);//(MainFrame.this, "");
                   if (rVal == JFileChooser.APPROVE_OPTION) {
                     System.out.println(c.getSelectedFile().getPath());

                   }

                  //ReportSaver.save("Общий отчет", emplo);
               }
           });
           mnNewMenu_1.add(menuItem_3);
           
           mnNewMenu_1.setEnabled(true);
    }
    
    private List<Employment> mEmplo;
    private JMenu mnNewMenu_1;
    private JMenu menu;
    private JMenu menu_1;
}
