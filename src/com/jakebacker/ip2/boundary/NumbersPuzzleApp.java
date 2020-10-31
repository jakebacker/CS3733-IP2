package com.jakebacker.ip2.boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class NumbersPuzzleApp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumbersPuzzleApp frame = new NumbersPuzzleApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public NumbersPuzzleApp() {
		setTitle("Numbers Puzzle Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 841, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel board = new JPanel();
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnUp = new JButton("^");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnDown = new JButton("v");
		
		JButton btnLeft = new JButton("<");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton buttonRight = new JButton(">");
		buttonRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblWinloseMessage = new JLabel("");
		lblWinloseMessage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(board, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(155)
									.addComponent(btnLeft, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addGap(38)
									.addComponent(buttonRight, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(195)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnDown, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnUp)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(136, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblWinloseMessage)
							.addGap(125))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(board, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(79)
							.addComponent(btnUp)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnLeft)
								.addComponent(buttonRight))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDown)
							.addGap(84)
							.addComponent(lblWinloseMessage)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		board.setLayout(new GridLayout(3, 3, 0, 0));
		
		JLabel tile11 = new JLabel("1");
		tile11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tile11.setBorder(new LineBorder(new Color(0, 0, 0)));
		tile11.setOpaque(true);
		tile11.setBackground(UIManager.getColor("Button.light"));
		tile11.setHorizontalAlignment(SwingConstants.CENTER);
		board.add(tile11);
		
		JLabel tile12 = new JLabel("4");
		tile12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tile12.setBorder(new LineBorder(new Color(0, 0, 0)));
		tile12.setOpaque(true);
		tile12.setBackground(UIManager.getColor("Button.light"));
		tile12.setHorizontalAlignment(SwingConstants.CENTER);
		board.add(tile12);
		
		JLabel tile13 = new JLabel("7");
		tile13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tile13.setBorder(new LineBorder(new Color(0, 0, 0)));
		tile13.setOpaque(true);
		tile13.setBackground(UIManager.getColor("Button.light"));
		tile13.setHorizontalAlignment(SwingConstants.CENTER);
		board.add(tile13);
		
		JLabel tile21 = new JLabel("5");
		tile21.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tile21.setBorder(new LineBorder(new Color(0, 0, 0)));
		tile21.setOpaque(true);
		tile21.setBackground(UIManager.getColor("Button.light"));
		tile21.setHorizontalAlignment(SwingConstants.CENTER);
		board.add(tile21);
		
		JLabel tile22 = new JLabel("3");
		tile22.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tile22.setBorder(new LineBorder(new Color(0, 0, 0)));
		tile22.setOpaque(true);
		tile22.setBackground(UIManager.getColor("Button.light"));
		tile22.setHorizontalAlignment(SwingConstants.CENTER);
		board.add(tile22);
		
		JLabel tile23 = new JLabel("2");
		tile23.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tile23.setBorder(new LineBorder(new Color(0, 0, 0)));
		tile23.setOpaque(true);
		tile23.setBackground(UIManager.getColor("Button.light"));
		tile23.setHorizontalAlignment(SwingConstants.CENTER);
		board.add(tile23);
		
		JLabel tile31 = new JLabel("6");
		tile31.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tile31.setBorder(new LineBorder(new Color(0, 0, 0)));
		tile31.setOpaque(true);
		tile31.setBackground(UIManager.getColor("Button.light"));
		tile31.setHorizontalAlignment(SwingConstants.CENTER);
		board.add(tile31);
		
		JLabel tile32 = new JLabel("8");
		tile32.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tile32.setBorder(new LineBorder(new Color(0, 0, 0)));
		tile32.setOpaque(true);
		tile32.setBackground(UIManager.getColor("Button.light"));
		tile32.setHorizontalAlignment(SwingConstants.CENTER);
		board.add(tile32);
		
		JLabel tile33 = new JLabel("9");
		tile33.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tile33.setBorder(new LineBorder(new Color(0, 0, 0)));
		tile33.setOpaque(true);
		tile33.setHorizontalAlignment(SwingConstants.CENTER);
		tile33.setBackground(UIManager.getColor("Button.light"));
		board.add(tile33);
		contentPane.setLayout(gl_contentPane);
	}
}
