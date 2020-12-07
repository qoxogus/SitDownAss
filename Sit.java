package JavaProject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.SwingConstants;



public class Sit extends JFrame {

	private JPanel contentPane;
	private JTextField nametext;
	private JTextField passwordField;
	private JTextField signupnametest;
	private JTextField pwd;
	private JTextField pwdcheck;
	private JTextField textField;

	/**
	 * Launch the application.
	 * @return 
	 */
	
	public static void main(String[] args) {
		
     		jdbcCon();
     		//����Ŭ ���� �޼���
     		
     		EventQueue.invokeLater(new Runnable() {
    			public void run() {
    				try {
    					Sit frame = new Sit();
    					frame.setVisible(true);
    					frame.setLocationRelativeTo(null);
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    			}
    		});
	}
	
	
	


	private static void jdbcCon() {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
 		Connection con=null;
 		Statement st=null;
 		ResultSet rs=null;
 		String sql="select * from meminfo";
 		PreparedStatement ps=null;
		String insertsql = "insert into student values(st_seq.nextval,?,?,?)";
		
 		//JDBC����̹��� �޸𸮿� �ø���
 		try {
 			Class.forName("oracle.jdbc.driver.OracleDriver");
 			System.out.println("JDBC ����̹��� �޸𸮿� �ø��� ��...");
 			
 			//DB�� �����ؼ� Connection��ü �����ϱ�
 			con=DriverManager.getConnection(url, "BAE", "12345");
 			System.out.println("DB���� ����");
 			
 			st=con.createStatement();//sql�� ����;
 			rs=st.executeQuery(sql); //sql�� ���� ����� ����
 			
// 			while(rs.next()) {
//				String name=rs.getString("name");
//	            String phone=rs.getString("phone");
//	            String email=rs.getString("email");
//	            System.out.println(name+", "+phone+", "+email);
//			}
 			
 			
 		} catch (ClassNotFoundException e) {
 			System.out.println("JDBC ����̹��� ã�� ���߽��ϴ�.");
 		} catch (SQLException e) {
 			System.out.println("DB���� ����");
 		}
	}


	public Sit() {
		setTitle("�ڸ�����System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 959, 780);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		class ImagePanel extends JPanel {
		    private Image img;

		    public ImagePanel(Image img) {
		        this.img = img;
		        setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		        setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		        setLayout(null);
		    }

		    public int getWidth() {
		        return img.getWidth(null);
		    }
		    public int getHeight() {
		        return img.getHeight(null);
		    }
		    public void paintComponent(Graphics g) {
		        g.drawImage(img, 0, 0, null);
		    }
		}
		
//		ImagePanel panel=new ImagePanel (new ImageIcon("./image/javasitp.jpeg").getImage());
//		contentPane.add(panel);
		
		//�̹��� �гη� ��׶��� �гο� �̹��� ����
		
		ImagePanel startpage = new ImagePanel(new ImageIcon("./image/javasitp.jpeg").getImage());
		startpage.setBounds(0, 0, 943, 741);
		contentPane.add(startpage);
		startpage.setLayout(null);
		
		ImagePanel sitchairpage = new ImagePanel(new ImageIcon("./image/javasitp.jpeg").getImage());
		sitchairpage.setBounds(0, 0, 943, 741);
		contentPane.add(sitchairpage);
		sitchairpage.setLayout(null);
		
		ImagePanel signuppage = new ImagePanel(new ImageIcon("./image/javasitp.jpeg").getImage());
		signuppage.setBounds(0, 0, 943, 741);
		contentPane.add(signuppage);
		
		ImagePanel mainpage = new ImagePanel(new ImageIcon("./image/javasitp.jpeg").getImage());
		mainpage.setBounds(0, 0, 943, 741);
		contentPane.add(mainpage);
		mainpage.setLayout(null);
		
		//���������� �� �ٸ��г��� �Ⱥ��̰�
		
		signuppage.setVisible(false);
		sitchairpage.setVisible(false);
		mainpage.setVisible(false);
		setResizable(false);
		
		//signup text field
		
		signupnametest = new JTextField();
		signupnametest.setBounds(390, 320, 235, 55);
		signupnametest.setColumns(10);
		signuppage.add(signupnametest);
		
		pwd = new JTextField();
		pwd.setBounds(390, 404, 235, 55);
		signuppage.add(pwd);
		
		pwdcheck = new JTextField();
		pwdcheck.setBounds(390, 484, 235, 55);
		signuppage.add(pwdcheck);
		
		//----------------------
		
		//login text field
		
		nametext = new JTextField();
		nametext.setBounds(349, 342, 235, 55);
		startpage.add(nametext);
		nametext.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(349, 430, 235, 55);
		startpage.add(passwordField);
		
		//--------------------------
		
		JButton btnNewButton_5 = new JButton("Go to reserve a seat");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainpage.setVisible(false);
				sitchairpage.setVisible(true);
			}
		});
		btnNewButton_5.setFont(new Font("����", Font.PLAIN, 30));
		btnNewButton_5.setBounds(268, 288, 369, 258);
		mainpage.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Log out");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "�α׾ƿ� �մϴ�.");
				mainpage.setVisible(false);
				startpage.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(381, 642, 140, 39);
		mainpage.add(btnNewButton_6);
		
		JLabel label_3 = new JLabel("Sit Down Ass");
		label_3.setForeground(Color.MAGENTA);
		label_3.setFont(new Font("����", Font.PLAIN, 90));
		label_3.setBounds(190, 10, 565, 257);
		mainpage.add(label_3);
		
		JButton btnNewButton_3 = new JButton("A1");
		btnNewButton_3.setBackground(Color.green);
		btnNewButton_3.addActionListener(new ActionListener() {
			int Clickcount = 0;
			//��ư�� �������� ������ ��ư���� �ٲ�� �ѹ� �� ���� �� �ʷϻ� ��ư���� �ٲ�� �ϴ� �ڵ�
			public void actionPerformed(ActionEvent e) {
				if(Clickcount == 0 || Clickcount%2==0) {
					btnNewButton_3.setBackground(Color.red);
					Clickcount++;
				}
				else if(Clickcount == 1 || Clickcount%2!=0) {
					btnNewButton_3.setBackground(Color.green);
					Clickcount++;
				}
			}
		});
		btnNewButton_3.setBounds(82, 80, 117, 108);
		sitchairpage.add(btnNewButton_3);
		
		JButton btnA = new JButton("A2");
		btnA.setBackground(Color.green);
		btnA.addActionListener(new ActionListener() {
			int Clickcount = 0;
			//��ư�� �������� ������ ��ư���� �ٲ�� �ѹ� �� ���� �� �ʷϻ� ��ư���� �ٲ�� �ϴ� �ڵ�
			public void actionPerformed(ActionEvent e) {
				if(Clickcount == 0 || Clickcount%2==0) {
					btnA.setBackground(Color.red);
					Clickcount++;
				}
				else if(Clickcount == 1 || Clickcount%2!=0) {
					btnA.setBackground(Color.green);
					Clickcount++;
				}
			}
		});
		btnA.setBounds(235, 80, 117, 108);
		sitchairpage.add(btnA);
		
		JButton btnA_1 = new JButton("A3");
		btnA_1.setBackground(Color.green);
		btnA_1.addActionListener(new ActionListener() {
			int Clickcount = 0;
			//��ư�� �������� ������ ��ư���� �ٲ�� �ѹ� �� ���� �� �ʷϻ� ��ư���� �ٲ�� �ϴ� �ڵ�
			public void actionPerformed(ActionEvent e) {
				if(Clickcount == 0 || Clickcount%2==0) {
					btnA_1.setBackground(Color.red);
					Clickcount++;
				}
				else if(Clickcount == 1 || Clickcount%2!=0) {
					btnA_1.setBackground(Color.green);
					Clickcount++;
				}
			}
		});
		btnA_1.setBounds(397, 80, 117, 108);
		sitchairpage.add(btnA_1);
		
		JButton btnA_2 = new JButton("A4");
		btnA_2.setBackground(Color.green);
		btnA_2.addActionListener(new ActionListener() {
			int Clickcount = 0;
			//��ư�� �������� ������ ��ư���� �ٲ�� �ѹ� �� ���� �� �ʷϻ� ��ư���� �ٲ�� �ϴ� �ڵ�
			public void actionPerformed(ActionEvent e) {
				if(Clickcount == 0 || Clickcount%2==0) {
					btnA_2.setBackground(Color.red);
					Clickcount++;
				}
				else if(Clickcount == 1 || Clickcount%2!=0) {
					btnA_2.setBackground(Color.green);
					Clickcount++;
				}
			}
		});
		btnA_2.setBounds(566, 80, 117, 108);
		sitchairpage.add(btnA_2);
		
		JButton btnA_3 = new JButton("A5");
		btnA_3.setBackground(Color.green);
		btnA_3.addActionListener(new ActionListener() {
			int Clickcount = 0;
			//��ư�� �������� ������ ��ư���� �ٲ�� �ѹ� �� ���� �� �ʷϻ� ��ư���� �ٲ�� �ϴ� �ڵ�
			public void actionPerformed(ActionEvent e) {
				if(Clickcount == 0 || Clickcount%2==0) {
					btnA_3.setBackground(Color.red);
					Clickcount++;
				}
				else if(Clickcount == 1 || Clickcount%2!=0) {
					btnA_3.setBackground(Color.green);
					Clickcount++;
				}
			}
		});
		btnA_3.setBounds(721, 80, 117, 108);
		sitchairpage.add(btnA_3);
		
		JButton btnB = new JButton("B1");
		btnB.setBackground(Color.green);
		btnB.addActionListener(new ActionListener() {
			int Clickcount = 0;
			//��ư�� �������� ������ ��ư���� �ٲ�� �ѹ� �� ���� �� �ʷϻ� ��ư���� �ٲ�� �ϴ� �ڵ�
			public void actionPerformed(ActionEvent e) {
				if(Clickcount == 0 || Clickcount%2==0) {
					btnB.setBackground(Color.red);
					Clickcount++;
				}
				else if(Clickcount == 1 || Clickcount%2!=0) {
					btnB.setBackground(Color.green);
					Clickcount++;
				}
			}
		});
		btnB.setBounds(82, 241, 117, 108);
		sitchairpage.add(btnB);
		
		JButton btnB_1 = new JButton("B2");
		btnB_1.setBackground(Color.green);
		btnB_1.addActionListener(new ActionListener() {
			int Clickcount = 0;
			//��ư�� �������� ������ ��ư���� �ٲ�� �ѹ� �� ���� �� �ʷϻ� ��ư���� �ٲ�� �ϴ� �ڵ�
			public void actionPerformed(ActionEvent e) {
				if(Clickcount == 0 || Clickcount%2==0) {
					btnB_1.setBackground(Color.red);
					Clickcount++;
				}
				else if(Clickcount == 1 || Clickcount%2!=0) {
					btnB_1.setBackground(Color.green);
					Clickcount++;
				}
			}
		});
		btnB_1.setBounds(235, 241, 117, 108);
		sitchairpage.add(btnB_1);
		
		JButton btnB_2 = new JButton("B3");
		btnB_2.setBackground(Color.green);
		btnB_2.addActionListener(new ActionListener() {
			int Clickcount = 0;
			//��ư�� �������� ������ ��ư���� �ٲ�� �ѹ� �� ���� �� �ʷϻ� ��ư���� �ٲ�� �ϴ� �ڵ�
			public void actionPerformed(ActionEvent e) {
				if(Clickcount == 0 || Clickcount%2==0) {
					btnB_2.setBackground(Color.red);
					Clickcount++;
				}
				else if(Clickcount == 1 || Clickcount%2!=0) {
					btnB_2.setBackground(Color.green);
					Clickcount++;
				}
			}
		});
		btnB_2.setBounds(397, 241, 117, 108);
		sitchairpage.add(btnB_2);
		
		JButton btnB_3 = new JButton("B4");
		btnB_3.setBackground(Color.green);
		btnB_3.addActionListener(new ActionListener() {
			int Clickcount = 0;
			//��ư�� �������� ������ ��ư���� �ٲ�� �ѹ� �� ���� �� �ʷϻ� ��ư���� �ٲ�� �ϴ� �ڵ� 
			public void actionPerformed(ActionEvent e) {
				if(Clickcount == 0 || Clickcount%2==0) {
					btnB_3.setBackground(Color.red);
					Clickcount++;
				}
				else if(Clickcount == 1 || Clickcount%2!=0) {
					btnB_3.setBackground(Color.green);
					Clickcount++;
				}
			}
		});
		btnB_3.setBounds(566, 241, 117, 108);
		sitchairpage.add(btnB_3);
		
		JButton btnB_4 = new JButton("B5");
		btnB_4.setBackground(Color.green);
		btnB_4.addActionListener(new ActionListener() {
			int Clickcount = 0;
			//��ư�� ��������
			public void actionPerformed(ActionEvent e) {
				if(Clickcount == 0 || Clickcount%2==0) {
					btnB_4.setBackground(Color.red);
					Clickcount++;
				}
				else if(Clickcount == 1 || Clickcount%2!=0) {
					btnB_4.setBackground(Color.green);
					Clickcount++;
				}
			}
		});
		btnB_4.setBounds(721, 241, 117, 108);
		sitchairpage.add(btnB_4);
		JButton btnC = new JButton("C1");
		btnC.setBackground(Color.green);
		btnC.addActionListener(new ActionListener() {
			int Clickcount = 0;
			//��ư�� ��������
			public void actionPerformed(ActionEvent e) {
				if(Clickcount == 0 || Clickcount%2==0) {
					btnC.setBackground(Color.red);
					Clickcount++;
				}
				else if(Clickcount == 1 || Clickcount%2!=0) {
					btnC.setBackground(Color.green);
					Clickcount++;
				}
			}
		});
		btnC.setBounds(82, 395, 117, 108);
		sitchairpage.add(btnC);
		
		JButton btnC_1 = new JButton("C2");
		btnC_1.setBackground(Color.green);
		btnC_1.addActionListener(new ActionListener() {
			int Clickcount = 0;
			//��ư�� ��������
			public void actionPerformed(ActionEvent e) {
				if(Clickcount == 0 || Clickcount%2==0) {
					btnC_1.setBackground(Color.red);
					Clickcount++;
				}
				else if(Clickcount == 1 || Clickcount%2!=0) {
					btnC_1.setBackground(Color.green);
					Clickcount++;
				}
			}
		});
		btnC_1.setBounds(235, 395, 117, 108);
		sitchairpage.add(btnC_1);
		
		JButton btnC_2 = new JButton("C3");
		btnC_2.setBackground(Color.green);
		btnC_2.addActionListener(new ActionListener() {
			int Clickcount = 0;
			//��ư�� ��������
			public void actionPerformed(ActionEvent e) {
				if(Clickcount == 0 || Clickcount%2==0) {
					btnC_2.setBackground(Color.red);
					Clickcount++;
				}
				else if(Clickcount == 1 || Clickcount%2!=0) {
					btnC_2.setBackground(Color.green);
					Clickcount++;
				}
			}
		});
		btnC_2.setBounds(397, 395, 117, 108);
		sitchairpage.add(btnC_2);
		
		JButton btnC_3 = new JButton("C4");
		btnC_3.setBackground(Color.green);
		btnC_3.addActionListener(new ActionListener() {
			int Clickcount = 0;
			//��ư�� ��������
			public void actionPerformed(ActionEvent e) {
				if(Clickcount == 0 || Clickcount%2==0) {
					btnC_3.setBackground(Color.red);
					Clickcount++;
				}
				else if(Clickcount == 1 || Clickcount%2!=0) {
					btnC_3.setBackground(Color.green);
					Clickcount++;
				}
			}
		});
		btnC_3.setBounds(566, 395, 117, 108);
		sitchairpage.add(btnC_3);
		
		JButton btnC_4 = new JButton("C5");
		btnC_4.setBackground(Color.green);
		btnC_4.addActionListener(new ActionListener() {
			int Clickcount = 0;
			//��ư�� ��������
			public void actionPerformed(ActionEvent e) {
				if(Clickcount == 0 || Clickcount%2==0) {
					btnC_4.setBackground(Color.red);
					Clickcount++;
				}
				else if(Clickcount == 1 || Clickcount%2!=0) {
					btnC_4.setBackground(Color.green);
					Clickcount++;
				}
			}
		});
		btnC_4.setBounds(721, 395, 117, 108);
		sitchairpage.add(btnC_4);
		
		JButton btnD = new JButton("D1");
		btnD.setBackground(Color.green);
		btnD.addActionListener(new ActionListener() {
			int Clickcount = 0;
			//��ư�� ��������
			public void actionPerformed(ActionEvent e) {
				if(Clickcount == 0 || Clickcount%2==0) {
					btnD.setBackground(Color.red);
					Clickcount++;
				}
				else if(Clickcount == 1 || Clickcount%2!=0) {
					btnD.setBackground(Color.green);
					Clickcount++;
				}
			}
		});
		btnD.setBounds(82, 549, 117, 108);
		sitchairpage.add(btnD);
		
		JButton btnD_1 = new JButton("D2");
		btnD_1.setBackground(Color.green);
		btnD_1.addActionListener(new ActionListener() {
			int Clickcount = 0;
			//��ư�� ��������
			public void actionPerformed(ActionEvent e) {
				if(Clickcount == 0 || Clickcount%2==0) {
					btnD_1.setBackground(Color.red);
					Clickcount++;
				}
				else if(Clickcount == 1 || Clickcount%2!=0) {
					btnD_1.setBackground(Color.green);
					Clickcount++;
				}
			}
		});
		btnD_1.setBounds(235, 549, 117, 108);
		sitchairpage.add(btnD_1);
		
		JButton btnD_2 = new JButton("D3");
		btnD_2.setBackground(Color.green);
		btnD_2.addActionListener(new ActionListener() {
			int Clickcount = 0;
			//��ư�� ��������
			public void actionPerformed(ActionEvent e) {
				if(Clickcount == 0 || Clickcount%2==0) {
					btnD_2.setBackground(Color.red);
					Clickcount++;
				}
				else if(Clickcount == 1 || Clickcount%2!=0) {
					btnD_2.setBackground(Color.green);
					Clickcount++;
				}
			}
		});
		btnD_2.setBounds(397, 549, 117, 108);
		sitchairpage.add(btnD_2);
		
		JButton btnD_3 = new JButton("D4");
		btnD_3.setBackground(Color.green);
		btnD_3.addActionListener(new ActionListener() {
			int Clickcount = 0;
			//��ư�� ��������
			public void actionPerformed(ActionEvent e) {
				if(Clickcount == 0 || Clickcount%2==0) {
					btnD_3.setBackground(Color.red);
					Clickcount++;
				}
				else if(Clickcount == 1 || Clickcount%2!=0) {
					btnD_3.setBackground(Color.green);
					Clickcount++;
				}
			}
		});
		btnD_3.setBounds(566, 549, 117, 108);
		sitchairpage.add(btnD_3);
		
		JButton btnD_4 = new JButton("D5");
		btnD_4.setBackground(Color.green);
		btnD_4.addActionListener(new ActionListener() {
			int Clickcount = 0;
			//��ư�� ��������
			public void actionPerformed(ActionEvent e) {
				if(Clickcount == 0 || Clickcount%2==0) {
					btnD_4.setBackground(Color.red);
					Clickcount++;
				}
				else if(Clickcount == 1 || Clickcount%2!=0) {
					btnD_4.setBackground(Color.green);
					Clickcount++;
				}
			}
		});
		btnD_4.setBounds(721, 549, 117, 108);
		sitchairpage.add(btnD_4);
		
		JLabel lblNewLabel_3 = new JLabel("Sit Down Ass");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.MAGENTA);
		lblNewLabel_3.setFont(new Font("����", Font.BOLD, 20));
		lblNewLabel_3.setBounds(380, 21, 147, 48);
		sitchairpage.add(lblNewLabel_3);
		
		JButton btnNewButton_4 = new JButton("Reservation");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "�ڸ��� ����Ǿ����ϴ�.");
				sitchairpage.setVisible(false);
				mainpage.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(397, 694, 117, 37);
		sitchairpage.add(btnNewButton_4);
		
		JButton btnNewButton_7 = new JButton("Initialization");
		btnNewButton_7.addActionListener(new ActionListener() {
			//Initialization ��ư�� ������
			public void actionPerformed(ActionEvent e) {
				//A���� ��ư �ʷϻ����� �ʱ�ȭ
				btnNewButton_3.setBackground(Color.green);
				btnA.setBackground(Color.green);
				btnA_1.setBackground(Color.green);
				btnA_2.setBackground(Color.green);
				btnA_3.setBackground(Color.green);
				//B���� ��ư �ʷϻ����� �ʱ�ȭ
				btnB.setBackground(Color.green);
				btnB_1.setBackground(Color.green);
				btnB_2.setBackground(Color.green);
				btnB_3.setBackground(Color.green);
				btnB_4.setBackground(Color.green);
				//C���� ��ư �ʷϻ����� �ʱ�ȭ
				btnC.setBackground(Color.green);
				btnC_1.setBackground(Color.green);
				btnC_2.setBackground(Color.green);
				btnC_3.setBackground(Color.green);
				btnC_4.setBackground(Color.green);
				//D���� ��ư �ʷϻ����� �ʱ�ȭ
				btnD.setBackground(Color.green);
				btnD_1.setBackground(Color.green);
				btnD_2.setBackground(Color.green);
				btnD_3.setBackground(Color.green);
				btnD_4.setBackground(Color.green);
				JOptionPane.showMessageDialog(null, "��� �ڸ��� �ʱ�ȭ �Ǿ����ϴ�.");
			}
		});
		btnNewButton_7.setBounds(721, 697, 117, 34);
		sitchairpage.add(btnNewButton_7);
		
		JButton btnNewButton_2 = new JButton("Cancle");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sitchairpage.setVisible(false);
				mainpage.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(85, 701, 114, 30);
		sitchairpage.add(btnNewButton_2);
		
		
		
		JLabel lblNewLabel = new JLabel("Sit Down Ass");
		lblNewLabel.setForeground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 90));
		lblNewLabel.setBounds(192, 10, 565, 257);
		startpage.add(lblNewLabel);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 30));
		lblNewLabel_1.setBounds(212, 342, 137, 55);
		startpage.add(lblNewLabel_1);
		
		JLabel lblPnum = new JLabel(" Pwd  :");
		lblPnum.setForeground(Color.RED);
		lblPnum.setFont(new Font("����", Font.BOLD, 30));
		lblPnum.setBounds(212, 430, 137, 55);
		startpage.add(lblPnum);
		
		
		
		JButton btnNewButton = new JButton("Login >");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String loginname = nametext.getText();
				String loginpwd = passwordField.getText();
				int a = login(loginname, loginpwd); //�α��� �޼���
				if(a == 1) { //ture��� �α���
					startpage.setVisible(false);
					mainpage.setVisible(true);
					//�ؽ�Ʈ�ʵ� �ʱ�ȭ
					nametext.setText("");
					passwordField.setText("");
				} 
				else { //false��� �α��� ����
					JOptionPane.showMessageDialog(null, "�α��� ����");
					//�ؽ�Ʈ�ʵ� �ʱ�ȭ
					nametext.setText("");
					passwordField.setText("");
				}
			}

			private int login(String loginname, String loginpwd) {
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				Connection con=null;
				Statement st=null;
				ResultSet rs=null;
				String selectsql="select * from meminfo";
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection(url, "BAE", "12345");
					System.out.println("DB���� ����");
					
					st=con.createStatement();
					rs=st.executeQuery(selectsql);
					
					String name, pwd;
					
					while(rs.next()) {
						name=rs.getString(1);
						pwd=rs.getString(2);
						
						if(loginname.equals(name) && loginpwd.equals(pwd)) {
							//�ؽ�Ʈ �ʵ忡 �Է��� �α����̸��� meminfo���� �ҷ��� ȸ�������Ҷ� insert�ߴ� ������ ���Ͽ� true/false �Ǵ�
							JOptionPane.showMessageDialog(null, "�α��� ����");
							return 1; 
							//�α��� ������ true��ȯ
						}
						else { 
							//continue�� ����ϰ� ����� 1������ DB�� �ִ� ���� ���� �ٸ� ������ �о ���� �� �ְ� ������ش�.
							continue;
						}
					}
					
				} catch (SQLException e) {
					System.out.println("JDBC ����̹��� ã�� ���߽��ϴ�.");
					e.printStackTrace();
					
				} catch (ClassNotFoundException e) {
					System.out.println("DB���� ����");
					e.printStackTrace();
				}
				return 0;
				//�α��� ���н� false��ȯ
			}
		});
		btnNewButton.setBounds(487, 558, 97, 23);
		startpage.add(btnNewButton);
		
		
		
		JButton btnNewButton_1 = new JButton("Signup >");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�ؽ�Ʈ�ʵ� ����
				nametext.setText("");
				passwordField.setText("");
				//������(�г�) �ٲٱ�
				startpage.setVisible(false);
				signuppage.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(349, 558, 97, 23);
		startpage.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Login");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("����", Font.BOLD, 25));
		lblNewLabel_4.setBounds(419, 250, 97, 69);
		startpage.add(lblNewLabel_4);
		
		JButton btnNewButton_9 = new JButton("Exit >");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "�����մϴ�.");
				//����
				System.exit(0);
			}
		});
		btnNewButton_9.setBounds(419, 624, 97, 23);
		startpage.add(btnNewButton_9);
		signuppage.setLayout(null);
		
		
		JLabel label = new JLabel("Sit Down Ass");
		label.setForeground(Color.MAGENTA);
		label.setBounds(181, 10, 565, 257);
		label.setFont(new Font("����", Font.PLAIN, 90));
		signuppage.add(label);
		
		JLabel label_1 = new JLabel("Name :");
		label_1.setForeground(Color.RED);
		label_1.setBounds(255, 320, 136, 55);
		label_1.setFont(new Font("����", Font.BOLD, 30));
		signuppage.add(label_1);
		
		JLabel label_2 = new JLabel(" Pwd  :");
		label_2.setForeground(Color.RED);
		label_2.setBounds(255, 404, 136, 55);
		label_2.setFont(new Font("����", Font.BOLD, 30));
		signuppage.add(label_2);
		
		JLabel lblPwdck = new JLabel(" PwdCk  :");
		lblPwdck.setForeground(Color.RED);
		lblPwdck.setBounds(216, 482, 175, 55);
		lblPwdck.setFont(new Font("����", Font.BOLD, 30));
		signuppage.add(lblPwdck);
		
		
		
		JButton button = new JButton("Signup >");
		button.setBounds(434, 612, 97, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//���� ������ �ؽ�Ʈ �ʵ忡 �Է��� ������ �����Ѵ�
				String name = signupnametest.getText();
				String pwdpwd = pwd.getText();  
				String pwdck = pwdcheck.getText();
				
//				System.out.println(name+" | "+pwdpwd+" | "+pwdck);
//				JOptionPane.showMessageDialog(null, "ȸ�������� �����մϴ�.");
				
				if(pwdpwd.equals(pwdck)==true) {
					//ȸ�������� �� ��й�ȣ�� ��й�ȣ Ȯ���� ������ insert
					insert(name,pwdpwd,pwdck); //insert �޼���
					//�г� �ٲٱ�
					signuppage.setVisible(false);
					startpage.setVisible(true);
					//�ؽ�Ʈ �ʵ� ����
					signupnametest.setText("");
					pwd.setText("");
					pwdcheck.setText("");
				}
				else {
					//��й�ȣ�� ��й�ȣȮ���� ���������� �ߴ� �޼���
					JOptionPane.showMessageDialog(null, "��й�ȣ�� �ٽ� Ȯ�����ּ���.");
				}
				
			}
		});
		
		signuppage.add(button);
		
		JButton btnNewButton_8 = new JButton("Cancle");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signuppage.setVisible(false);
				startpage.setVisible(true);
			}
		});
		btnNewButton_8.setBounds(255, 612, 97, 23);
		signuppage.add(btnNewButton_8);
		
		JLabel lblNewLabel_5 = new JLabel("Sign up");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("����", Font.BOLD, 25));
		lblNewLabel_5.setBounds(421, 242, 110, 55);
		signuppage.add(lblNewLabel_5);
	
	}
	
	private static void insert(String name, String pwdpwd, String pwdck) {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
 		Connection con=null;
 		Statement st=null;
 		ResultSet rs=null;
 		PreparedStatement ps=null;
		String insertsql = "insert into meminfo values(?,?,?)";
		
 		//JDBC����̹��� �޸𸮿� �ø���
 		try {
 			Class.forName("oracle.jdbc.driver.OracleDriver");
 			System.out.println("JDBC ����̹��� �޸𸮿� �ø��� ��...");
 			
 			//DB�� �����ؼ� Connection��ü �����ϱ�
 			con=DriverManager.getConnection(url, "BAE", "12345");
 			System.out.println("DB���� ����");
 			
 			st=con.createStatement(); //sql�� ����;
 			
 			try {
 				ps=con.prepareStatement(insertsql);
 				ps.setString(1, name);
 				ps.setString(2, pwdpwd);
 				ps.setString(3, pwdck);
 				
 				
 				if(ps.executeUpdate()>=1) {
 					System.out.println("insert ����");
 					JOptionPane.showMessageDialog(null, "ȸ�������� �����մϴ�.");
 				}
 				
 			} catch (SQLException e) {
 				System.out.println("insert ����");
 				JOptionPane.showMessageDialog(null, "ȸ�������� �����ϼ̽��ϴ�. ������ �̸����� ���Ե� ȸ���� �ֽ��ϴ�.");
 			}
 			
 		} catch (ClassNotFoundException e) {
 			System.out.println("JDBC ����̹��� ã�� ���߽��ϴ�.");
 		} catch (SQLException e) {
 			System.out.println("DB���� ����");
 		}
	}
}
