import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.Writer;

class Form2 extends JFrame implements ActionListener {
    JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8;
    JTextField roll_no, name, batch, section;
    JRadioButton jb1, jb2;
    JButton b1, b2;
    JCheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    JTextArea address;
    JComboBox country;

    public Form2() {
        setSize(620, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.YELLOW);

        jl1 = new JLabel("Name ");
        jl2 = new JLabel("Roll No ");
        jl3 = new JLabel("Batch ");
        jl4 = new JLabel("Section ");
        jl5 = new JLabel("Gender ");
        jl6 = new JLabel("Qualification ");
        jl7 = new JLabel("Address ");
        jl8 = new JLabel("Country");
        jl1.setBounds(50, 50, 75, 25);
        jl2.setBounds(50, 100, 75, 25);
        jl3.setBounds(50, 150, 75, 25);
        jl4.setBounds(50, 200, 75, 25);
        jl5.setBounds(50, 250, 75, 25);
        jl6.setBounds(50, 300, 75, 25);
        jl7.setBounds(50, 400, 75, 25);
        jl8.setBounds(50, 450, 75, 25);

        roll_no = new JTextField(20);
        name = new JTextField(20);
        batch = new JTextField(20);
        section = new JTextField(20);
        name.setBounds(125, 50, 200, 25);
        roll_no.setBounds(125, 100, 200, 25);
        batch.setBounds(125, 150, 200, 25);
        section.setBounds(125, 200, 200, 25);

        jb1 = new JRadioButton("Male");
        jb2 = new JRadioButton("Female");
        jb1.setBackground(Color.yellow);
        jb2.setBackground(Color.yellow);

        ButtonGroup bg = new ButtonGroup();
        bg.add(jb1);
        bg.add(jb2);
        jb1.setBounds(150, 250, 80, 25);
        jb2.setBounds(250, 250, 80, 25);

        checkBox1 = new JCheckBox("Matric");
        checkBox2 = new JCheckBox("Intermediate");
        checkBox3 = new JCheckBox("Graduate");
        checkBox4 = new JCheckBox("Post Graduate");
        checkBox1.setBackground(Color.yellow);
        checkBox2.setBackground(Color.yellow);
        checkBox3.setBackground(Color.yellow);
        checkBox4.setBackground(Color.yellow);

        checkBox1.setBounds(150, 300, 80, 25);
        checkBox2.setBounds(250, 300, 120, 25);
        checkBox3.setBounds(150, 350, 100, 25);
        checkBox4.setBounds(250, 350, 130, 25);

        address = new JTextArea();
        address.setLineWrap(true);
        address.setWrapStyleWord(true);
        address.setBounds(150, 400, 220, 40);

        String[] countries = {"Pakistan", "India", "China"};
        country = new JComboBox(countries);
        country.setBounds(150, 450, 160, 25);

        b1 = new JButton("Save");
        b2 = new JButton("Print");
        b1.setFocusable(false);
        b2.setFocusable(false);
        b1.setBounds(50, 500, 75, 25);
        b2.setBounds(150, 500, 75, 25);

        add(jl1);
        add(name);
        add(jl2);
        add(roll_no);
        add(jl3);
        add(batch);
        add(jl4);
        add(section);
        add(jl5);
        add(jb1);
        add(jb2);
        add(jl6);
        add(checkBox1);
        add(checkBox2);
        add(checkBox3);
        add(checkBox4);
        add(jl7);
        add(address);
        add(jl8);
        add(country);
        add(b1);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Writer writer;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Name", name.getText());
        jsonObject.put("Roll Number: ", roll_no.getText());
        jsonObject.put("Batch: ", batch.getText());
        jsonObject.put("Section: ", section.getText());
        if (jb1.isSelected()) {
            jsonObject.put("Gender: ", jb1.getText());
        } else {
            jsonObject.put("Gender: ", jb2.getText());
        }
        if (checkBox1.isSelected() && checkBox2.isSelected() && checkBox3.isSelected() && checkBox4.isSelected()) {
            jsonObject.put("Qualification: ", checkBox1.getText() + ", " + checkBox2.getText() + ", " + checkBox3.getText() + " and " + checkBox4.getText());
        } else if (checkBox1.isSelected() && checkBox2.isSelected() && checkBox3.isSelected()) {
            jsonObject.put("Qualification: ", checkBox1.getText() + ", " + checkBox2.getText() + ", " + checkBox3.getText());
        } else if (checkBox1.isSelected() && checkBox2.isSelected()) {
            jsonObject.put("Qualification: ", checkBox1.getText() + ", " + checkBox2.getText());
        } else if (checkBox1.isSelected()) {
            jsonObject.put("Qualification: ", checkBox1.getText());
        } else if (checkBox2.isSelected()) {
            jsonObject.put("Qualification: ", checkBox2.getText());
        } else if (checkBox3.isSelected()) {
            jsonObject.put("Qualification: ", checkBox3.getText());
        } else if (checkBox4.isSelected()) {
            jsonObject.put("Qualification: ", checkBox4.getText());
        }
        jsonObject.put("Country: ", country.getSelectedItem());
        jsonObject.put("Address: ", address.getText());

        if (e.getSource() == b1) {
            try {
                writer = new FileWriter("E:/Form.json");
                writer.write(jsonObject.toJSONString());
                try {
                    if (jb1.isSelected()) {
                        jsonObject.put("Gender: ", jb1.getText());
                    } else {
                        jsonObject.put("Gender: ", jb2.getText());
                    }
                    if (checkBox1.isSelected() && checkBox2.isSelected() && checkBox3.isSelected() && checkBox4.isSelected()) {
                        jsonObject.put("Qualification: ", checkBox1.getText() + ", " + checkBox2.getText() + ", " + checkBox3.getText() + " and " + checkBox4.getText());
                    } else if (checkBox1.isSelected() && checkBox2.isSelected() && checkBox3.isSelected()) {
                        jsonObject.put("Qualification: ", checkBox1.getText() + ", " + checkBox2.getText() + ", " + checkBox3.getText());
                    } else if (checkBox1.isSelected() && checkBox2.isSelected()) {
                        jsonObject.put("Qualification: ", checkBox1.getText() + ", " + checkBox2.getText());
                    } else if (checkBox1.isSelected()) {
                        jsonObject.put("Qualification: ", checkBox1.getText());
                    } else if (checkBox2.isSelected()) {
                        jsonObject.put("Qualification: ", checkBox2.getText());
                    } else if (checkBox3.isSelected()) {
                        jsonObject.put("Qualification: ", checkBox3.getText());
                    } else if (checkBox4.isSelected()) {
                        jsonObject.put("Qualification: ", checkBox4.getText());
                    }   // end of try block
                } catch (Exception ie) {
                    ie.printStackTrace();
                }
                writer.close();
            } catch (Exception ie) {
                ie.printStackTrace();
            }
        }
        else if (e.getSource() == b2) {
            System.out.println(name.getText());
            System.out.println(roll_no.getText());
            System.out.println(batch.getText());
            System.out.println(section.getText());
            if (jb1.isSelected())
                System.out.println("Male");
            else
                System.out.println("Female");
            if (checkBox1.isSelected() && checkBox2.isSelected() && checkBox3.isSelected() && checkBox4.isSelected()) {
                System.out.println(checkBox1.getText() + ", " + checkBox2.getText() + ", " + checkBox3.getText() + " and " + checkBox4.getText());
            } else if (checkBox1.isSelected() && checkBox2.isSelected() && checkBox3.isSelected()) {
                System.out.println(checkBox1.getText() + ", " + checkBox2.getText() + ", " + checkBox3.getText());
            } else if (checkBox1.isSelected() && checkBox2.isSelected()) {
                System.out.println(checkBox1.getText() + ", " + checkBox2.getText());
            } else if (checkBox1.isSelected()) {
                System.out.println(checkBox1.getText());
            } else if (checkBox2.isSelected()) {
                System.out.println(checkBox2.getText());
            } else if (checkBox3.isSelected()) {
                System.out.println(checkBox3.getText());
            } else if (checkBox4.isSelected()) {
                System.out.println(checkBox4.getText());
            }   // end of if else conditional
            System.out.println(address.getText());
            System.out.println(country.getSelectedItem());
        }      //  end of if-else ladder
    }         //  end of actionPerformed() method
}            //   end of class Form

public class form1 {
    public static void main(String[] args) {

        Form2 form = new Form2();

    }
}
