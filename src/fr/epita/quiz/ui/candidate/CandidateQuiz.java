package fr.epita.quiz.ui.candidate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import fr.epita.quiz.ui.Main;

/**
 * 
 * @author Swati Khandare
 *
 */
public class CandidateQuiz extends JFrame {

	// Variable initialisation
	private static final long serialVersionUID = -4760051121978266140L;

	private static final String RETQUES_QUERY = "SELECT QID, CONTENT, CHOICEA, CHOICEB, CHOICEC, CHOICED, ANSWER FROM QUESTION  WHERE TOPICS=? and DIFFICULTY=?";
	protected static final Object RCRD_BTN_MSG = "Your Question has been recorded,  Please proceed to next Question";
	protected static final Object NXT_BTN_MSG = "You reached to End of the Quiz, Please End your Quiz";

	private JPanel mainPane;

	public int[] qid= new int[50];
	public String[] ques= new String[50];
	public String[] chcA= new String[50];
	public String[] chcB= new String[50];
	public String[] chcC= new String[50];
	public String[] chcD= new String[50];
	public String[] crctAns= new String[50];
	public int i=0,c=0;
	
	public CandidateQuiz(String topic, int diff,String uname) {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 623);
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(null);
		
		JLabel titleLbl = new JLabel("Hello " +uname+ ", Welcome to Quiz Exam.");
		titleLbl.setBounds(121, 11, 206, 14);
		mainPane.add(titleLbl);
		try {
			Connection conn = getConnection();
			 
			PreparedStatement pstmt = conn.prepareStatement(RETQUES_QUERY);
			pstmt.setString(1, topic);
			pstmt.setInt(2, diff);
			 ResultSet rs = pstmt.executeQuery();
			 while(rs.next())
				{
				 
				    qid[i] = rs.getInt("QID");
					ques[i] = rs.getString("CONTENT");
				    chcA[i] = rs.getString("CHOICEA");
				    chcB[i] = rs.getString("CHOICEB");
				    chcC[i] = rs.getString("CHOICEC");
				    chcD[i] = rs.getString("CHOICED");
				    crctAns[i] = rs.getString("ANSWER");
				    i++;
				}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		i=0;
			
			JLabel quesLbl = new JLabel(ques[i]);
			quesLbl.setBounds(86, 61, 325, 14);
			mainPane.add(quesLbl);
			
			JRadioButton rdBtnA = new JRadioButton(chcA[i]);
			rdBtnA.setBounds(100, 102, 364, 23);
			mainPane.add(rdBtnA);
			
			JRadioButton rdBtnB = new JRadioButton(chcB[i]);
			rdBtnB.setBounds(100, 155, 345, 23);
			mainPane.add(rdBtnB);
			
			JRadioButton rdBtnC = new JRadioButton(chcC[i]);
			rdBtnC.setBounds(100, 212, 333, 23);
			mainPane.add(rdBtnC);
			
			JRadioButton rdBtnD = new JRadioButton(chcD[i]);
			rdBtnD.setBounds(100, 274, 325, 23);
			mainPane.add(rdBtnD);
			
			ButtonGroup rdBnGrp = new ButtonGroup();
			rdBnGrp.add(rdBtnA);
			rdBnGrp.add(rdBtnB);
			rdBnGrp.add(rdBtnC);
			rdBnGrp.add(rdBtnD);


			getContentPane().add(rdBtnA);
			getContentPane().add(rdBtnB);
			getContentPane().add(rdBtnC);
			getContentPane().add(rdBtnD);
			
			JButton rcdBtn = new JButton("Record");
			rcdBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					System.out.println("Answer:" + crctAns[i]);

					if(rdBtnA.isSelected()) {
						if(crctAns[i].equals(rdBtnA.getText())) {
							c=c+1;
						}
					}
					else if(rdBtnB.isSelected()) {
					if(crctAns[i].equals(rdBtnB.getText()))
						{
							c=c+1;
						}

					}
					else if(rdBtnC.isSelected()) {
						if(crctAns[i].equals(rdBtnC.getText())) {
							c=c+1;
						}
					}
					else if(rdBtnD.isSelected()) {
						if(crctAns[i].equals(rdBtnD.getText())) {
							c=c+1;
						}
					}
					i++;
				}
			});
			rcdBtn.setBounds(180, 372, 89, 23); // Records the Answer and proceed
			rcdBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, RCRD_BTN_MSG);
				}
			});
			mainPane.add(rcdBtn);
			
			JButton nxtBtn = new JButton("Next"); // Proceeds to next question
			nxtBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(ques[i]!=null)
					{
					quesLbl.setText(ques[i]);
					rdBtnA.setText(chcA[i]);
					rdBtnB.setText(chcB[i]);
					rdBtnC.setText(chcC[i]);
					rdBtnD.setText(chcD[i]);
					ButtonGroup rdBnGrp = new ButtonGroup();
					rdBnGrp.add(rdBtnA);
					rdBnGrp.add(rdBtnB);
					rdBnGrp.add(rdBtnC);
					rdBnGrp.add(rdBtnD);


					getContentPane().add(rdBtnA);
					getContentPane().add(rdBtnB);
					getContentPane().add(rdBtnC);
					getContentPane().add(rdBtnD);
					}
					else {
						
						nxtBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								JOptionPane.showMessageDialog(null, NXT_BTN_MSG);
							}
						});
						
					}
				}
			});
			nxtBtn.setBounds(180, 435, 89, 23);
			mainPane.add(nxtBtn);
			JButton endBtn = new JButton("End"); // Ends the Quiz and generates marks.
			endBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "The Quiz is Completed Successfully \n Your Score is : "+c);
					System.out.println("C =" + c);
					new Main();
					setVisible(false);
				}
			});
			endBtn.setBounds(180, 495, 89, 23);
			mainPane.add(endBtn);
			
			
		}
				
	

	
	/**
	 * @Get connection
	 * @return
	 * @throws SQLException
	 */
	private Connection getConnection() throws SQLException {
			String url = "jdbc:postgresql://localhost:5432/postgresql";
			String username = "postgres";
			String password = "postgres";
			
			return DriverManager.getConnection(url, username, password);
		}
}
