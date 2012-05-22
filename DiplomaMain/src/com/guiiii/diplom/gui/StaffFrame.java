package com.guiiii.diplom.gui;

//import java.awt.Dialog.ModalExclusionType;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.guiiii.diplom.util.MainFrameListener;
import java.awt.Frame;

public class StaffFrame extends JFrame {

    /**
	 *
	 */
    private static final long serialVersionUID = -4524723272426657815L;
    private final JPanel contentPane;
    private final JTextField textField;

    public StaffFrame(final MainFrameListener mf) {
        setLocationByPlatform(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 317, 178);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        final JLabel label = new JLabel("Введите общую нагрузку университета");

        final JButton button = new JButton("ОК");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isOk = true;
                try {
                    if (Float.parseFloat(textField.getText()) <= 1) {
                        throw new Exception();
                    }
                } catch (Exception e3) {
                    isOk = false;
                    label.setForeground(Color.RED);
                }
                if(isOk == true) {
                    mf.setStuff(Float.parseFloat(textField.getText()));
                    dispose();
                }
            }
        });

        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setColumns(10);
        final GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(gl_contentPane
                .createParallelGroup(Alignment.LEADING)
                .addGroup(
                        gl_contentPane
                                .createSequentialGroup()
                                .addGap(95)
                                .addComponent(button,
                                        GroupLayout.PREFERRED_SIZE, 96,
                                        GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(100, Short.MAX_VALUE))
                .addGroup(
                        gl_contentPane
                                .createSequentialGroup()
                                .addGap(84)
                                .addComponent(textField,
                                        GroupLayout.PREFERRED_SIZE, 116,
                                        GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(91, Short.MAX_VALUE))
                .addGroup(
                        gl_contentPane
                                .createSequentialGroup()
                                .addGap(32)
                                .addComponent(label, GroupLayout.DEFAULT_SIZE,
                                        214, Short.MAX_VALUE).addGap(54)));
        gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
                Alignment.LEADING).addGroup(
                gl_contentPane
                        .createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label)
                        .addGap(18)
                        .addComponent(textField, GroupLayout.DEFAULT_SIZE, 24,
                                Short.MAX_VALUE)
                        .addGap(18)
                        .addComponent(button, GroupLayout.PREFERRED_SIZE, 34,
                                GroupLayout.PREFERRED_SIZE).addContainerGap()));
        contentPane.setLayout(gl_contentPane);
    }
}
