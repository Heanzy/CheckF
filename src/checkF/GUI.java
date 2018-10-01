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
import java.awt.TextField;

import javax.swing.JTextField;
import javax.security.auth.callback.ChoiceCallback;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class GUI extends JFrame {
	public Check check;
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
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u9009\u9879");
		menuBar.add(mnNewMenu);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\u03B1 = 0.01");
		chckbxNewCheckBox.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox.setFont(new Font("宋体", Font.PLAIN, 22));
		chckbxNewCheckBox.setBounds(161, 507, 128, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("\u03B1 = 0.05");
		chckbxNewCheckBox_1.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox_1.setFont(new Font("宋体", Font.PLAIN, 22));
		chckbxNewCheckBox_1.setBounds(383, 507, 133, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u6253\u5F00");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(chckbxNewCheckBox.isSelected()||chckbxNewCheckBox_1.isSelected()){
						check = new Check();
						if(chckbxNewCheckBox.isSelected()&&chckbxNewCheckBox_1.isSelected())
							JOptionPane.showMessageDialog(null, "不能同时选择两个α", "提示",JOptionPane.WARNING_MESSAGE);
						else if(chckbxNewCheckBox.isSelected())
							check.setDatabase("0.01");
						else {
							check.setDatabase("0.05");
						}
						
						check.CalculateFromFile();
						textField.setText((new Double(check.getAverageX())).toString());
						textField_1.setText((new Double(check.getS())).toString());
						textField_2.setText((new Double(check.getS1())).toString());
						textField_3.setText((new Double(check.getS2())).toString());
						textField_4.setText(String.valueOf(check.getF()));
						textField_5.setText(String.valueOf(check.getV1()));
						textField_6.setText(String.valueOf(check.getV2()));
						textField_7.setText(String.valueOf(check.getTableCheck(check.getV1(), check.getV2())));
						if(check.isPass())
							JOptionPane.showMessageDialog(null, "恭喜通过F检验", "提示",JOptionPane.WARNING_MESSAGE);
						else
							JOptionPane.showMessageDialog(null, "很遗憾没有通过F检验", "提示",JOptionPane.WARNING_MESSAGE);
					}
					else 
						JOptionPane.showMessageDialog(null, "请选择α", "提示",JOptionPane.WARNING_MESSAGE);
					
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "读取失败(可能是文件格式不对哦：）)", "提示",JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		
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
		table.setBounds(10, 21, 732, 480);
		contentPane.add(table);
		ExcelAdapter myAd = new ExcelAdapter(table);
		
		
		
		textField = new JTextField();
		textField.setBounds(840, 25, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(1038, 25, 66, 21);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(840, 135, 66, 21);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(840, 251, 66, 21);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(840, 374, 66, 21);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(1038, 135, 66, 21);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(1038, 251, 66, 21);
		contentPane.add(textField_6);
		
		JButton btnNewButton = new JButton("\u5F00\u59CB");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					if(chckbxNewCheckBox_1.isSelected()||chckbxNewCheckBox.isSelected()){
						check = new Check();
						if(chckbxNewCheckBox_1.isSelected()&&chckbxNewCheckBox.isSelected())
							JOptionPane.showMessageDialog(null, "α不能同时选两个", "提示",JOptionPane.WARNING_MESSAGE);
						else if(chckbxNewCheckBox_1.isSelected())
							check.setDatabase("0.05");
						else if(chckbxNewCheckBox.isSelected())
							check.setDatabase("0.01");
						//check.setDataFromFile();
						try {
							int [] start = check.FindTableDataStart(table);
							check.setM(check.setMFromTable(table,start));
				            System.out.println(check.getM());
				            check.setN(check.setNFromTable(table,start));
				            System.out.println(check.getN());
							check.setTableData(table,start);
						} catch (Exception e) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(null, "数据为空", "提示",JOptionPane.WARNING_MESSAGE);
						}
						
								
						check.setAverage();
			            for(Double e:check.getAverage())
			            	System.out.println(e);		           
			            check.setN1();
			            System.out.println(check.getN1());
			            check.setAverageX();
			            System.out.println(check.getAverageX());
			            check.setS();
			            System.out.println(check.getS());
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
						textField_1.setText((new Double(check.getS())).toString());
						textField_2.setText((new Double(check.getS1())).toString());
						textField_3.setText((new Double(check.getS2())).toString());
						textField_4.setText(String.valueOf(check.getF()));
						textField_5.setText(String.valueOf(check.getV1()));
						textField_6.setText(String.valueOf(check.getV2()));
						textField_7.setText(String.valueOf(check.getTableCheck(check.getV1(), check.getV2())));
						if(check.isPass())
							JOptionPane.showMessageDialog(null, "恭喜通过F检验", "提示",JOptionPane.WARNING_MESSAGE);
						else
							JOptionPane.showMessageDialog(null, "很遗憾没有通过F检验", "提示",JOptionPane.WARNING_MESSAGE);
					}
					else
						JOptionPane.showMessageDialog(null, "请选择α", "提示",JOptionPane.WARNING_MESSAGE);
					

				//check.CleanArray();
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setBounds(794, 537, 133, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u603B\u5E73\u5747\u503C");
		lblNewLabel.setBounds(762, 28, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u603B\u6807\u51C6\u504F\u5DEE");
		label.setBounds(960, 28, 68, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u7EC4\u95F4\u65B9\u5DEE");
		label_1.setBounds(762, 138, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u7EC4\u5185\u65B9\u5DEE");
		label_2.setBounds(762, 254, 54, 15);
		contentPane.add(label_2);
		
		JLabel lblF = new JLabel("F");
		lblF.setBounds(762, 377, 54, 15);
		contentPane.add(lblF);
		
		JLabel lblV = new JLabel("V1");
		lblV.setBounds(974, 138, 54, 15);
		contentPane.add(lblV);
		
		JLabel lblV_1 = new JLabel("V2");
		lblV_1.setBounds(974, 254, 54, 15);
		contentPane.add(lblV_1);
		
		JLabel lblF_1 = new JLabel("F\u03B1(v2,v1)");
		lblF_1.setBounds(960, 377, 68, 15);
		contentPane.add(lblF_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(1038, 374, 66, 21);
		contentPane.add(textField_7);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				   for (int i = 0; i < table.getRowCount(); i++)
					      for(int j = 0; j < table.getColumnCount(); j++) 
					          table.setValueAt("", i, j);	
				   textField.setText("");
				   textField_1.setText("");
				   textField_2.setText("");
				   textField_3.setText("");
				   textField_4.setText("");
				   textField_5.setText("");
				   textField_6.setText("");
				   textField_7.setText("");
			}			
		});
		btnNewButton_1.setBounds(794, 491, 133, 32);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("2\u4F4D");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(check.RetainedDecimal2AverageX());
			}
		});
		btnNewButton_2.setBounds(762, 54, 54, 23);
		contentPane.add(btnNewButton_2);
		
		JButton button = new JButton("3\u4F4D");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(check.RetainedDecimal3AverageX());
			}
		});
		button.setBounds(829, 54, 54, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("5\u4F4D");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(check.RetainedDecimal5AverageX());
			}
		});
		button_1.setBounds(762, 87, 54, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("7\u4F4D");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(check.RetainedDecimal7AverageX());
			}
		});
		button_2.setBounds(829, 87, 54, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("2\u4F4D");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText(check.RetainedDecimal2S());
			}
		});
		button_3.setBounds(970, 54, 54, 23);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("3\u4F4D");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText(check.RetainedDecimal3S());
			}
		});
		button_4.setBounds(1037, 54, 54, 23);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("5\u4F4D");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText(check.RetainedDecimal5S());
			}
		});
		button_5.setBounds(970, 87, 54, 23);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("7\u4F4D");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText(check.RetainedDecimal7S());
			}
		});
		button_6.setBounds(1037, 87, 54, 23);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("2\u4F4D");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setText(check.RetainedDecimal2S1());
			}
		});
		button_7.setBounds(762, 163, 54, 23);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("3\u4F4D");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setText(check.RetainedDecimal3S1());
			}
		});
		button_8.setBounds(829, 163, 54, 23);
		contentPane.add(button_8);
		
		JButton button_9 = new JButton("5\u4F4D");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setText(check.RetainedDecimal5S1());
			}
		});
		button_9.setBounds(762, 196, 54, 23);
		contentPane.add(button_9);
		
		JButton button_10 = new JButton("7\u4F4D");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setText(check.RetainedDecimal7S1());
			}
		});
		button_10.setBounds(829, 196, 54, 23);
		contentPane.add(button_10);
		
		JButton button_11 = new JButton("2\u4F4D");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_3.setText(check.RetainedDecimal2S2());
			}
		});
		button_11.setBounds(762, 279, 54, 23);
		contentPane.add(button_11);
		
		JButton button_12 = new JButton("3\u4F4D");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_3.setText(check.RetainedDecimal3S2());
			}
		});
		button_12.setBounds(829, 279, 54, 23);
		contentPane.add(button_12);
		
		JButton button_13 = new JButton("5\u4F4D");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_3.setText(check.RetainedDecimal5S2());
			}
		});
		button_13.setBounds(762, 312, 54, 23);
		contentPane.add(button_13);
		
		JButton button_14 = new JButton("7\u4F4D");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_3.setText(check.RetainedDecimal7S2());
			}
		});
		button_14.setBounds(829, 312, 54, 23);
		contentPane.add(button_14);
		
		JButton button_15 = new JButton("2\u4F4D");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_4.setText(check.RetainedDecimal2F());
			}
		});
		button_15.setBounds(762, 405, 54, 23);
		contentPane.add(button_15);
		
		JButton button_16 = new JButton("3\u4F4D");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_4.setText(check.RetainedDecimal3F());
			}
		});
		button_16.setBounds(829, 405, 54, 23);
		contentPane.add(button_16);
		
		JButton button_17 = new JButton("5\u4F4D");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_4.setText(check.RetainedDecimal5F());
			}
		});
		button_17.setBounds(762, 438, 54, 23);
		contentPane.add(button_17);
		
		JButton button_18 = new JButton("7\u4F4D");
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_4.setText(check.RetainedDecimal7F());
			}
		});
		button_18.setBounds(829, 438, 54, 23);
		contentPane.add(button_18);
	}
}
