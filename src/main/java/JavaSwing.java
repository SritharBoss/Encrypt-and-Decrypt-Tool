package main.java;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class JavaSwing implements ActionListener, MouseListener {

	JFrame frame;
	ButtonGroup group;
	JRadioButton button1, button2;
	JTextArea area, area1;
	JTextField field;
	JButton button;

	private void build() {
		frame = new JFrame("Encryption & Decryption");

		group = new ButtonGroup();
		button1 = new JRadioButton("Decrypt");
		button1.setBounds(20, 20, 100, 20);

		button2 = new JRadioButton("Encrypt");
		button2.setBounds(140, 20, 100, 20);

		group.add(button1);
		group.add(button2);
		button1.setSelected(true);
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("Enter Your Text to Decrypt");
			}
		});
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				area.setText("Enter Your Text to Encrypt");

			}
		});

		area = new JTextArea("Enter Your Text to Decrypt");
		area.setBounds(20, 60, 150, 30);
		area.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
		area.setEditable(false);
		area.setBackground(null);

		area1 = new JTextArea();
		area1.setBounds(20, 100, 360, 40);
		area1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
		area1.setEditable(false);

		field = new JTextField();
		field.setBounds(180, 60, 180, 25);

		button = new JButton("Submit");
		button.setBounds(150, 150, 80, 30);
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.addActionListener(this);

		area1.addMouseListener(this);

		
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JLabel label = new JLabel(new ImageIcon(getClass().getResource("/main/java/p.jpg")));
				label.setBounds(80, 200, 200, 87);
				frame.add(label);
			}
		});
		
		JTextArea area2 = new JTextArea("Tip : Right Click on the Text Area to Copy the Output");
		area2.setBounds(40, 320, 340, 20);
		area2.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 12));
		area2.setEditable(false);
		area2.setBackground(null);

		frame.add(button1);
		frame.add(button2);
		frame.add(field);
		frame.add(area);
		frame.add(area1);
		frame.add(area2);
		frame.add(button);
		frame.setLayout(null);
		frame.setSize(410, 410);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new JavaSwing().build();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (button1.isSelected()) {
			area1.setText("Decrypted -->" + field.getText());
		}

		if (button2.isSelected()) {
			area1.setText("Encrypted -->" + field.getText());
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3) {
			Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
			clip.setContents(new StringSelection(area1.getText()), null);
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
