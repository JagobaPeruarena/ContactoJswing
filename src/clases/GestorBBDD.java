package clases;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;






public class GestorBBDD extends Conector {
	public ArrayList<clientes> getClientes(){

		ArrayList<clientes> clientes = new ArrayList<clientes>();
 
		try {
			PreparedStatement st = con.prepareStatement("select * from clientes");
			ResultSet rs = st.executeQuery();

			
			while (rs.next()) {
				clientes cliente = new clientes();
				cliente.setDni(rs.getString(1));
				cliente.setNombre(rs.getString(2));
				cliente.setApellidos(rs.getString(3));
				cliente.setDireccion(rs.getString(4));	
				cliente.setLocalidad(rs.getString(5));
				
				
				clientes.add(cliente);
			}
			return clientes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insertarCliente(clientes cliente) throws SQLException {
		String sent ="INSERT INTO clientes (dni,nombre,apellidos,direccion,localidad) VALUES (?,?,?,?,?)";
		PreparedStatement pt = con.prepareStatement(sent);
		pt.setString(1, cliente.getDni());
		pt.setString(2, cliente.getNombre());
		pt.setString(3, cliente.getApellidos());
		pt.setString(4, cliente.getDireccion());
		pt.setString(5, cliente.getLocalidad());
		pt.execute();
	}
	
	public void eliminarCliente(int id) throws SQLException {
		
		String sent="DELETE FROM clientes WHERE dni=?";
		PreparedStatement pt = con.prepareStatement(sent);
		
		pt.setInt(1, id);
		pt.execute();
	}
	
	public clientes getCliente(int id) throws SQLException {
		clientes newCliente= new clientes();
		PreparedStatement pt = con.prepareStatement("SELECT * FROM clientes where DNI = ?");
		pt.setInt(1, id);
		ResultSet resultado=pt.executeQuery();
			
		newCliente.setDni(resultado.getString(1));
		newCliente.setNombre(resultado.getString(2));
		newCliente.setApellidos(resultado.getString(3));
		newCliente.setDireccion(resultado.getString(4));
		newCliente.setLocalidad(resultado.getString(5));
	
		return newCliente;
		
	}
//	
//	public void insertarHotel(hoteles hotel, Scanner scan) throws SQLException {
//		String sent ="INSERT INTO hoteles (cif,nombre,gerente,estrellas,compania) VALUES (?,?,?,?,?)";
//		PreparedStatement pt = con.prepareStatement(sent);
//		pt.setString(1, hotel.getCif());
//		pt.setString(2, hotel.getNombre());
//		pt.setString(3, hotel.getGerente());
//		pt.setInt(4, hotel.getEstrellas());
//		pt.setString(5, hotel.getCompania());
//		pt.execute();
//		String ans="Y";
//		do {
//			habitaciones nhabitacion = new habitaciones();
//			nhabitacion= Datos.pedirDatosHabitaciones(scan);
//			String sentwo ="INSERT INTO habitaciones (id,id_hotel,numero,descripcion,precio) VALUES (?,?,?,?,?)";
//			pt = con.prepareStatement(sentwo);
//			pt.setInt(1, nhabitacion.getId());
//			pt.setInt(2, nhabitacion.getId_hotel());
//			pt.setString(3, nhabitacion.getNumero());
//			pt.setString(4, nhabitacion.getDescripcion());
//			pt.setDouble(5, nhabitacion.getPrecio());
//			pt.execute();
//			ans=Datos.seguir(scan);
//		} while (ans.equals("Y"));
//	}
	
	public ArrayList<hoteles> getHoteles(){

		ArrayList<hoteles> hoteles = new ArrayList<hoteles>();
 
		try {
			PreparedStatement st = con.prepareStatement("select * from hoteles");
			ResultSet rs = st.executeQuery();

			
			while (rs.next()) {
				hoteles hotel = new hoteles();
				hotel.setId(rs.getInt(1));
				hotel.setCif(rs.getString(2));
				hotel.setNombre(rs.getString(3));
				hotel.setGerente(rs.getString(4));
				hotel.setEstrellas(rs.getInt(5));	
				hotel.setCompania(rs.getString(6));
				
				
				hoteles.add(hotel);
			}
			return hoteles;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void eliminarHotel(int id) throws SQLException {
		
		String sent="DELETE FROM hoteles WHERE id=?";
		PreparedStatement pt = con.prepareStatement(sent);
		
		pt.setInt(1, id);
		pt.execute();
	}
	
	public void realizarReserva(reservas reserva) throws SQLException {
		String sent ="INSERT INTO reservas (id_habitacion,dni,desde,hasta) VALUES (?,?,?,?)";
		PreparedStatement pt = con.prepareStatement(sent);
		
		pt.setInt(1, reserva.getId_habitacion());
		pt.setString(2, reserva.getDni());
		pt.setDate(3, new Date(reserva.getDesde().getTime()) );
		pt.setDate(4, new Date(reserva.getHasta().getTime()));
		
		pt.execute();		
	}
	
	public ArrayList<reservas> getReservas(){

		ArrayList<reservas> reservas = new ArrayList<reservas>();
 
		try {
			PreparedStatement st = con.prepareStatement("select * from reservas");
			ResultSet rs = st.executeQuery();

			
			while (rs.next()) {
				reservas reserva = new reservas();
				reserva.setId(rs.getInt(1));
				reserva.setId_habitacion(rs.getInt(2));
				reserva.setDni(rs.getString(3));
				reserva.setDesde(rs.getDate(4));	
				reserva.setHasta(rs.getDate(5));
				
				
				reservas.add(reserva);
			}
			return reservas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
public void eliminarReserva(int id) throws SQLException {
		
		String sent="DELETE FROM reservas WHERE id=?";
		PreparedStatement pt = con.prepareStatement(sent);
		
		pt.setInt(1, id);
		pt.execute();
	}
public ArrayList<habitaciones> getHabitaciones(int id) throws SQLException {
	ArrayList<habitaciones> habitaciones = new ArrayList<habitaciones>();
	
	PreparedStatement pt = con.prepareStatement("SELECT * FROM habitaciones where id_hotel = ?");
	pt.setInt(1, id);
	ResultSet resultado=pt.executeQuery();
		while (resultado.next()) {
			habitaciones newHabitacion= new habitaciones();
			newHabitacion.setId(resultado.getInt(1));
			newHabitacion.setId_hotel(resultado.getInt(2));
			newHabitacion.setNumero(resultado.getString(3));
			newHabitacion.setDescripcion(resultado.getString(4));
			newHabitacion.setPrecio(resultado.getDouble(5));
		}
	
	return habitaciones;
}


}
