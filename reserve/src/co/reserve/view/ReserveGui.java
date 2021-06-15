package co.reserve.view;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import co.reserve.access.ReserveDAO;

public class ReserveGui extends JFrame {
	
	TextField txtId, txtPass;
	ReserveDAO dao = new ReserveDAO();
	
	public ReserveGui() {

		JPanel panel = new JPanel();
		JLabel label = new JLabel("ID : ");
		JLabel pswrd = new JLabel("PassWord : ");
		JTextField txtID = new JTextField(10);
		JPasswordField txtPass = new JPasswordField(10);
		JButton logBtn = new JButton("로그인");

		panel.add(label);
		panel.add(txtID);
		panel.add(pswrd);
		panel.add(txtPass);
		panel.add(logBtn);

		logBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String str = dao.login(txtID.getText(), txtPass.getText());
				
				if (str.equals("*로그인 성공*")) {
					JOptionPane.showMessageDialog(null, "*로그인 성공*");
				} else {
					JOptionPane.showMessageDialog(null, " 로그인에 실패하였습니다. ");
				}
			}
		});

		add(panel);
		setVisible(true);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		setTitle("전시 관람 예약");
//		setSize(450,450);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Container c = getContentPane();
//		c.setLayout(new FlowLayout());
//		
//		JLabel id = new JLabel("id");
//		txtId = new TextField(20);
//		JLabel pass = new JLabel("pass");
//		txtPass = new TextField(20);
//		JButton j1 = new JButton("로그인");
//		JButton j2 = new JButton("회원 가입");
//		JButton j3 = new JButton("회원 탈퇴");
//		
//		c.add(id);
//		c.add(txtId);
//		c.add(pass);
//		c.add(txtPass);
//		c.add(j1);
//		c.add(j2);
//		c.add(j3);
//		setVisible(true);
	}
	 public static void main(String[] args) {
		new ReserveGui();
	}
	
}
