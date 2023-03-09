package vista;

import java.awt.EventQueue;
import clases.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import java.awt.event.ActionEvent;

public class principal extends JFrame {

	private JPanel contentPane;
	private JTextField dni;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField direccion;
	private JTextField localidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal frame = new principal();
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
	public principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Agencia Viajes: Registrar Cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(43, 25, 370, 35);
		contentPane.add(lblNewLabel);
		
		dni = new JTextField();
		dni.setBounds(141, 103, 86, 20);
		contentPane.add(dni);
		dni.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("DNI");
		lblNewLabel_1.setBounds(43, 106, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("NOMBRE");
		lblNewLabel_1_1.setBounds(43, 139, 46, 10);
		contentPane.add(lblNewLabel_1_1);
		
		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(141, 134, 86, 20);
		contentPane.add(nombre);
		
		JLabel lblNewLabel_1_2 = new JLabel("APELLIDO");
		lblNewLabel_1_2.setBounds(43, 168, 57, 14);
		contentPane.add(lblNewLabel_1_2);
		
		apellido = new JTextField();
		apellido.setColumns(10);
		apellido.setBounds(141, 165, 86, 20);
		contentPane.add(apellido);
		
		JLabel lblNewLabel_1_3 = new JLabel("DIRECCION");
		lblNewLabel_1_3.setBounds(43, 203, 57, 14);
		contentPane.add(lblNewLabel_1_3);
		
		direccion = new JTextField();
		direccion.setColumns(10);
		direccion.setBounds(141, 200, 86, 20);
		contentPane.add(direccion);
		
		JLabel lblNewLabel_1_4 = new JLabel("LOCALIDAD");
		lblNewLabel_1_4.setBounds(43, 238, 57, 14);
		contentPane.add(lblNewLabel_1_4);
		
		localidad = new JTextField();
		localidad.setColumns(10);
		localidad.setBounds(141, 235, 86, 20);
		contentPane.add(localidad);
		
		JButton btnNewButton = new JButton("GUARDAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientes nCliente = new clientes();
				GestorBBDD gesto = new GestorBBDD();
				
				nCliente.setDni(dni.getText());
				nCliente.setNombre(nombre.getText());
				nCliente.setApellidos(apellido.getText());
				nCliente.setDireccion(direccion.getText());
				nCliente.setLocalidad(localidad.getText());
				

				try {
					gesto.Conectar();
					gesto.insertarCliente(nCliente);
					gesto.cerrar();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
			}
		});
		btnNewButton.setBounds(65, 308, 101, 48);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CAMBIAR VENTANA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (int i = 0; i < 50; i++) {
					
					ventana nVentana = new ventana();
					nVentana.setVisible(true);
					nVentana.setLocation((int)(Math.random() * (2000 - 10 + 1) + 10 ), (int)(Math.random() * (1000 - 10 + 1) + 10 ));
					
				}
			}
		});
		btnNewButton_1.setBounds(389, 321, 127, 23);
		contentPane.add(btnNewButton_1);
	}
}
