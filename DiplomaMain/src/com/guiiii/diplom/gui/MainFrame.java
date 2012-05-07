package com.guiiii.diplom.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
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
        mMainFrameListener = mainframeListener;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 352);

        final JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        final JMenu mnNewMenu = new JMenu("New menu");
        menuBar.add(mnNewMenu);

        final JMenu mnNewMenu_1 = new JMenu("New menu");
        menuBar.add(mnNewMenu_1);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        final JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);

        final JButton btnSetFactors = new JButton("Set factors");
        btnSetFactors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mMainFrameListener.setFactors();
            }
        });

        final JButton btnNewButton_1 = new JButton("Set staff");
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

        final JButton btnSetStudingPlan = new JButton("Set studing plan");
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

        final JButton btnSetKafedras = new JButton("Set kafedras");
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

        btnNewButton = new JButton("Calculate");
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

        final JPanel panel_2 = new JPanel();
        contentPane.add(panel_2, BorderLayout.SOUTH);

        final JLabel lblStatus = new JLabel("Status");
        lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
        panel_2.add(lblStatus);

        final JPanel panel_3 = new JPanel();
        contentPane.add(panel_3, BorderLayout.WEST);

        checkBoxNagr = new JCheckBox("Общий штат");
        checkBoxNagr.setForeground(Color.BLACK);
        checkBoxNagr.setEnabled(false);

        chckbxUch = new JCheckBox(
                "\u0423\u0447\u0435\u0431\u043D\u044B\u0439 \u043F\u043B\u0430\u043D");
        chckbxUch.setForeground(Color.BLACK);
        chckbxUch.setEnabled(false);

        chckbxkoef = new JCheckBox("Коэффициенты");
        chckbxkoef.setForeground(Color.BLACK);
        chckbxkoef.setEnabled(false);

        checkBoxkaf = new JCheckBox("Данные кафедр");
        checkBoxkaf.setForeground(Color.BLACK);
        checkBoxkaf.setEnabled(false);
        final GroupLayout gl_panel_3 = new GroupLayout(panel_3);
        gl_panel_3
                .setHorizontalGroup(gl_panel_3
                        .createParallelGroup(Alignment.LEADING)
                        .addGroup(
                                gl_panel_3
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(
                                                gl_panel_3
                                                        .createParallelGroup(
                                                                Alignment.LEADING)
                                                        .addComponent(
                                                                checkBoxNagr)
                                                        .addComponent(
                                                                chckbxUch,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                127,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                checkBoxkaf)
                                                        .addComponent(
                                                                chckbxkoef))
                                        .addContainerGap(
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)));
        gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(
                Alignment.LEADING).addGroup(
                gl_panel_3
                        .createSequentialGroup()
                        .addGap(48)
                        .addComponent(checkBoxNagr)
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(chckbxUch, GroupLayout.PREFERRED_SIZE,
                                24, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(checkBoxkaf)
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(chckbxkoef)
                        .addContainerGap(64, Short.MAX_VALUE)));
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
}
