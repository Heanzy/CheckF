package checkF;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {
	//public Check check;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1151, 639);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
				{"", "", "", "", "", "", "", "", ""},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(0, 0, 732, 480);
		contentPane.add(table);
		ExcelAdapter myAd = new ExcelAdapter(table);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\u03B1 = 0.01");
		chckbxNewCheckBox.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox.setFont(new Font("ËÎÌו", Font.PLAIN, 22));
		chckbxNewCheckBox.setBounds(161, 507, 128, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("\u03B1 = 0.05");
		chckbxNewCheckBox_1.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox_1.setFont(new Font("ËÎÌו", Font.PLAIN, 22));
		chckbxNewCheckBox_1.setBounds(383, 507, 133, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
		textField = new JTextField();
		textField.setBounds(840, 25, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(840, 92, 66, 21);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(840, 161, 66, 21);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(840, 230, 66, 21);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(840, 296, 66, 21);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(840, 364, 66, 21);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(840, 436, 66, 21);
		contentPane.add(textField_6);
		
		JButton btnNewButton = new JButton("\u5F00\u59CB");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					Check check = new Check();
					check.setDatabase();
					//check.setDataFromFile();
					int [] start = check.FindTableDataStart(table);
					check.setM(check.setMFromTable(table,start));
		            System.out.println(check.getM());
		            check.setN(check.setNFromTable(table,start));
		            System.out.println(check.getN());
					check.setTableData(table,start);		
					check.setAverage();
		            for(Double e:check.getAverage())
		            	System.out.println(e);		           
		            check.setN1();
		            System.out.println(check.getN1());
		            check.setAverageX();
		            System.out.println(check.getAverageX());
		            check.setQ1();
		            System.out.println(check.getQ1());
		            check.setQ2();
		            System.out.println(check.getQ2());
		            check.setV1();
		            System.out.println(check.getV1());
		            check.setV2();
		            System.out.println(check.getV2());
		            check.setS1();
		            System.out.println(check.getS1());
		            check.setS2();
		            System.out.println(check.getS2());
		            check.setF();
		            System.out.println(check.getF());
				textField.setText((new Double(check.getAverageX())).toString());
				textField_2.setText((new Double(check.getS1())).toString());
				textField_3.setText((new Double(check.getS2())).toString());
				textField_4.setText(String.valueOf(check.getF()));
				textField_5.setText(String.valueOf(check.getV1()));
				textField_6.setText(String.valueOf(check.getV2()));
				textField_7.setText(String.valueOf(check.getTableCheck(check.getV1(), check.getV2())));
				//check.CleanArray();
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(794, 537, 133, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u603B\u5E73\u5747\u503C");
		lblNewLabel.setBounds(762, 28, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u603B\u6807\u51C6\u504F\u5DEE");
		label.setBounds(762, 92, 68, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u7EC4\u95F4\u65B9\u5DEE");
		label_1.setBounds(762, 164, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u7EC4\u5185\u65B9\u5DEE");
		label_2.setBounds(762, 233, 54, 15);
		contentPane.add(label_2);
		
		JLabel lblF = new JLabel("F");
		lblF.setBounds(762, 299, 54, 15);
		contentPane.add(lblF);
		
		JLabel lblV = new JLabel("V1");
		lblV.setBounds(762, 367, 54, 15);
		contentPane.add(lblV);
		
		JLabel lblV_1 = new JLabel("V2");
		lblV_1.setBounds(762, 439, 54, 15);
		contentPane.add(lblV_1);
		
		JLabel label_3 = new JLabel("\u8868\u503C");
		label_3.setBounds(960, 28, 54, 15);
		contentPane.add(label_3);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(1038, 25, 66, 21);
		contentPane.add(textField_7);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				   for (int i = 0; i < table.getRowCount(); i++)
					      for(int j = 0; j < table.getColumnCount(); j++) 
					          table.setValueAt("", i, j);					 
			}
		});
		btnNewButton_1.setBounds(794, 491, 133, 32);
		contentPane.add(btnNewButton_1);
	}
}
