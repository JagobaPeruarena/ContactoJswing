package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.GestorBBDD;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class ventana extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField dni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ventana dialog = new ventana();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ventana() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Buscar Cliente");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
			lblNewLabel.setBounds(16, 11, 146, 22);
			contentPanel.add(lblNewLabel);
		}
		{
			JButton btnNewButton = new JButton("Buscar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GestorBBDD gesto = new GestorBBDD();
					try {
						gesto.getCliente(dni.getText());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton.setBounds(121, 43, 89, 23);
			contentPanel.add(btnNewButton);
		}
		
		JList list = new JList();
		list.setBounds(143, 122, 269, 128);
		contentPanel.add(list);
		
		JButton btnNewButton_1 = new JButton("Monstrar Clientes");
		btnNewButton_1.setToolTipText("");
		btnNewButton_1.setBounds(16, 122, 117, 31);
		contentPanel.add(btnNewButton_1);
		
		dni = new JTextField();
		dni.setToolTipText("Escribe la id");
		dni.setBounds(16, 44, 86, 20);
		contentPanel.add(dni);
		dni.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(16, 75, 46, 14);
		contentPanel.add(lblNewLabel_1);
	}
}
