import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtTowerOfHanoi;

	/**GUI for the program
	 * @param args main
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartWindow frame = new StartWindow();
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
	public StartWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTowerOfHanoi = new JTextField();
		txtTowerOfHanoi.setBorder(null);
		txtTowerOfHanoi.setHorizontalAlignment(SwingConstants.CENTER);
		txtTowerOfHanoi.setFont(new Font("Intro ", Font.ITALIC, 35));
		txtTowerOfHanoi.setBackground(new Color(135, 206, 235));
		txtTowerOfHanoi.setForeground(new Color(0, 139, 139));
		txtTowerOfHanoi.setEditable(false);
		txtTowerOfHanoi.setEnabled(true);
		txtTowerOfHanoi.setText("TOWER OF HANOI");
		txtTowerOfHanoi.setBounds(42, 62, 345, 74);
		contentPane.add(txtTowerOfHanoi);
		txtTowerOfHanoi.setColumns(10);
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TowerGame tower = new TowerGame();
				tower.setVisible(true);
				
				
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 13));
		btnNewButton.setBounds(138, 141, 147, 25);
		contentPane.add(btnNewButton);
		setLocationRelativeTo(null);
	}
}
