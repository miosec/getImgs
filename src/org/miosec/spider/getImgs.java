package org.miosec.spider;

import java.awt.EventQueue;

import javax.sound.midi.MidiDevice.Info;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;
import java.awt.TextArea;

public class getImgs {

	private JFrame frame;
	private JTextField urlText;
	private TextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getImgs window = new getImgs();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public getImgs() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u6DD8\u5B9D\u5546\u54C1\u56FE\u7247\u83B7\u53D6");
		frame.setBounds(100, 100, 770, 512);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		urlText = new JTextField();
		urlText.setBounds(20, 10, 621, 21);
		frame.getContentPane().add(urlText);
		urlText.setColumns(10);
		JButton btnNewButton = new JButton("\u83B7\u53D6");
		btnNewButton.setBounds(651, 9, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		textArea = new TextArea();
		textArea.setBounds(20, 37, 724, 427);
		frame.getContentPane().add(textArea);
		
		btnNewButton.addActionListener(new ActionListener() {
			private List<String> imgs;

			public void actionPerformed(ActionEvent e) {
				String url = urlText.getText();
				try {
					imgs = SpiderMan.getImgs(url);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (int i = 0; i < imgs.size(); i++) {
					textArea.append(imgs.get(i)+"\n");
				}
			}
		});
		
	}
}
