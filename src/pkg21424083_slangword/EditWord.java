/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg21424083_slangword;

/**
 *
 * @author LeQuy
 */
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class EditWord extends JFrame implements ActionListener {

    SlangWord slangWord;
    JButton btnBack, btnEdit;
    JTextField textFieldMeaning, textFieldSlang;

    EditWord(String slag, String Meaning) {
        // Get container & slang word
        slangWord = SlangWord.getInstance();
        Container con = this.getContentPane();
        JLabel titleLabel = new JLabel();
        titleLabel.setText("Edit Slang Word");
        titleLabel.setForeground(Color.green);
        titleLabel.setFont(new Font("Gill Sans MT", Font.PLAIN, 35));
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        titleLabel.setPreferredSize(new Dimension(300, 100));

        // Form
        JPanel form = new JPanel();

        JPanel slagPanel = new JPanel();
        form.setBackground(Color.CYAN);
        SpringLayout layout = new SpringLayout();
        slagPanel.setLayout(layout);
        JLabel labelForSlang = new JLabel("Slang word: ");
        textFieldSlang = new JTextField("", 20);
        labelForSlang.setPreferredSize(new Dimension(100, 20));
        slagPanel.add(labelForSlang);
        slagPanel.add(textFieldSlang);
        layout.putConstraint(SpringLayout.WEST, labelForSlang, 6, SpringLayout.WEST, slagPanel);
        layout.putConstraint(SpringLayout.NORTH, labelForSlang, 6, SpringLayout.NORTH, slagPanel);
        layout.putConstraint(SpringLayout.WEST, textFieldSlang, 6, SpringLayout.EAST, labelForSlang);
        layout.putConstraint(SpringLayout.NORTH, textFieldSlang, 6, SpringLayout.NORTH, slagPanel);
        layout.putConstraint(SpringLayout.EAST, slagPanel, 6, SpringLayout.EAST, textFieldSlang);
        layout.putConstraint(SpringLayout.SOUTH, slagPanel, 6, SpringLayout.SOUTH, textFieldSlang);

        JPanel meaningPanel = new JPanel();
        SpringLayout layout1 = new SpringLayout();
        meaningPanel.setLayout(layout1);
        JLabel labelForMeaning = new JLabel("Meaning: ");
        labelForMeaning.setPreferredSize(new Dimension(100, 20));
        textFieldMeaning = new JTextField("", 20);
        meaningPanel.add(labelForMeaning);
        meaningPanel.add(textFieldMeaning);
        layout1.putConstraint(SpringLayout.WEST, labelForMeaning, 6, SpringLayout.WEST, meaningPanel);
        layout1.putConstraint(SpringLayout.NORTH, labelForMeaning, 6, SpringLayout.NORTH, meaningPanel);
        layout1.putConstraint(SpringLayout.WEST, textFieldMeaning, 6, SpringLayout.EAST, labelForMeaning);
        layout1.putConstraint(SpringLayout.NORTH, textFieldMeaning, 6, SpringLayout.NORTH, meaningPanel);
        layout1.putConstraint(SpringLayout.EAST, meaningPanel, 6, SpringLayout.EAST, textFieldMeaning);
        layout1.putConstraint(SpringLayout.SOUTH, meaningPanel, 6, SpringLayout.SOUTH, textFieldMeaning);

        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        con.add(Box.createRigidArea(new Dimension(0, 10)));
        form.add(slagPanel);
        con.add(Box.createRigidArea(new Dimension(0, 10)));
        form.add(meaningPanel);
        // Button Back and button Add
        JPanel bottomPanel = new JPanel();
        btnBack = new JButton("Back ");
        // btnBack.addActionListener(this);
        btnBack.setFocusable(false);
        btnBack.addActionListener(this);
        btnBack.setAlignmentX(CENTER_ALIGNMENT);
        btnEdit = new JButton("Edit");
        // btnBack.addActionListener(this);
        btnEdit.setFocusable(false);
        btnEdit.addActionListener(this);
        btnEdit.setAlignmentX(CENTER_ALIGNMENT);
        bottomPanel.add(btnBack);
        bottomPanel.add(btnEdit);

        // Setting content
        con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
        con.add(Box.createRigidArea(new Dimension(0, 10)));
        con.add(titleLabel);
        con.add(Box.createRigidArea(new Dimension(0, 10)));
        con.add(form);
        con.add(Box.createRigidArea(new Dimension(0, 10)));
        con.add(bottomPanel);
        // Setting Frame

        textFieldMeaning.setText(Meaning);
        textFieldSlang.setText(slag);

        this.setTitle("Add Slang word");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == btnBack) {
            this.dispose();
            try {
                new FindSWFrame();
            } catch (Exception ex) {
                Logger.getLogger(EditWord.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == btnEdit) {
            String slagEdit = textFieldSlang.getText();
            String meanEdit = textFieldMeaning.getText();
            slangWord.addOverwrite(slagEdit, meanEdit);
            JOptionPane.showMessageDialog(this, "Chinh sua thanh cong "  );
        
        }
    }

}
