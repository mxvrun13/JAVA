package co.reserve.view;

import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import co.reserve.access.ReserveDAO;
import co.reserve.model.Reserve;

public class ReserveGui extends JFrame {
	
	private JList list;
	private DefaultListModel model;
	private JScrollPane scrolled;
	JPanel panel;
	TextField txtId, txtPass;
	JTextArea txtList;
	JTextField idSearchField;
	JTextField dateSearchField;
	ReserveDAO dao = new ReserveDAO();
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String TIME_FORMAT = "HH:mm";
	
	public ReserveGui() {
		setTitle("전시 관람 예약");
		init();
	}
	
	public void init() {
		//model = new DefaultListModel();
		//list = new JList(model);
		panel = new JPanel();
		JLabel label = new JLabel("ID : ");
		JLabel pswrd = new JLabel("PassWord : ");
		JTextField txtID = new JTextField(10);
		JPasswordField txtPass = new JPasswordField(10);
		JButton logBtn = new JButton("로그인");
		txtList = new JTextArea(16, 50);
		//list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		panel.add(label);
		panel.add(txtID);
		panel.add(pswrd);
		panel.add(txtPass);
		panel.add(logBtn);
		//scrolled = new JScrollPane(list);
		//panel.add(scrolled, "Center");
		panel.add(txtList);

		logBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String str = dao.login(txtID.getText(), txtPass.getText());
				
				if (str.equals("*로그인 성공*")) {
					JOptionPane.showMessageDialog(null, "*로그인 성공*");
				} else {
					JOptionPane.showMessageDialog(null, " 로그인에 실패하였습니다. ");
				}
				
				if (txtID.getText().equals("admin")) {
					JButton ListBtn = new JButton("전제 예약 조회");
					JButton dateListBtn = new JButton("날짜별 예약 조회");
					JButton deleteBtn = new JButton("예약 취소");
					JLabel idLabel = new JLabel("user id > ");
					idSearchField = new JTextField(8);
					JLabel dateLabel = new JLabel("날짜(yyyy-mm-dd) > ");
					dateSearchField = new JTextField(8);
					
					panel.add(ListBtn);
					panel.add(dateListBtn);
					panel.add(deleteBtn);
					panel.add(idLabel);
					panel.add(idSearchField);
					panel.add(dateLabel);
					panel.add(dateSearchField);
					
					add(panel);
					setVisible(true);
					
					ListBtn.addActionListener (e1 -> adminSelectAll());
					dateListBtn.addActionListener(e2 -> adminSelectDate());
					deleteBtn.addActionListener(e3 -> adminDelete());
				} else {
					JButton ListBtn = new JButton("예약 조회");
					JButton dateListBtn = new JButton("관람 예약");
					JButton deleteBtn = new JButton("예약 취소");
				}
			}
		});

		add(panel);
		setVisible(true);
		setSize(600, 400);
		setLocationRelativeTo(null);
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
	
	private void adminSelectAll() {
		List<Reserve> list = dao.adminSelectAll();
		StringBuffer sb = new StringBuffer();
		for (Reserve r : list) {
			sb.append(r);
			sb.append("\n");
		}
		txtList.setText(sb.toString());
	}
	
	private void adminSelectDate() {
		String date = dateSearchField.getText();
		ArrayList<Reserve> list = dao.adminSelectDate(date);
		StringBuffer sb = new StringBuffer();
		for (Reserve r : list) {
			sb.append(r);
			sb.append("\n");
		}
		txtList.setText(sb.toString());
	}
	
	private void adminDelete() {
		String userId = idSearchField.getText();
		String date = dateSearchField.getText();
		dao.delete(userId, date);
	}
	
	
	
	
	 public static void main(String[] args) {
		new ReserveGui();
	}
	
}
