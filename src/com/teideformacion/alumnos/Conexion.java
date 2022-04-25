package com.teideformacion.alumnos;

import java.sql.*;
import java.util.ArrayList;

public class Conexion {
	private Connection con;
	private PreparedStatement state;
	private ResultSet result;
	
	public Conexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gestion", "root", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No se encuentra la clase");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int insertarAlumnos(Alumnos a) {
		int x = 0;
		
		String sql = "INSERT INTO ALUMNOS VALUES(?,?,?,?,?,?,?);";
		try {
			state = con.prepareStatement(sql);
			
			state.setString(1, a.getClave());
			state.setString(2, a.getNombre());
			state.setString(3, a.getApellidos());
			state.setInt(4, a.getEdad());
			state.setString(5, a.getCalle());
			state.setInt(6, a.getNumero());
			state.setString(7, a.getLocalidad());
			
			x = state.executeUpdate(); //Devuelve el numero de filas insertadas
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error con la sentencia SQL");
		}
		
		return x;
	}
	
	public ArrayList<Alumnos> consultarAlumnos(){
		ArrayList<Alumnos> listaalumnos = new ArrayList<>();
		
		String sql = "SELECT * FROM ALUMNOS;";
		try {
			state = con.prepareStatement(sql);
			result = state.executeQuery();
			
			while (result.next()) {
				String clave = result.getString("CLAVE");
				String nombre = result.getString("NOMBRE");
				String apellidos = result.getString("APELLIDOS");
				int edad = result.getInt("EDAD");
				String calle = result.getString("CALLE");
				int numero = result.getInt("NUMERO");
				String localidad = result.getString("LOCALIDAD");
				
				listaalumnos.add(new Alumnos(clave, nombre, apellidos, edad, calle, numero, localidad));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaalumnos;
	}
	
	public int eliminarAlumno(int clave){
		int x = 0;
		
		String sql = "DELETE FROM ALUMNOS WHERE CLAVE=?;";
		try {
			state = con.prepareStatement(sql);
			state.setInt(1, clave);
			x = state.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
	
	public ArrayList<Alumnos> alumnosMayoresEdad(){
		ArrayList<Alumnos> listaalumnosmayoresedad = new ArrayList<Alumnos>();
		
		String sql = "SELECT * FROM ALUMNOS WHERE EDAD>=18;";
		
		try {
			state = con.prepareStatement(sql);
			result = state.executeQuery();
			
			while (result.next()) {
				String clave = result.getString("CLAVE");
				String nombre = result.getString("NOMBRE");
				String apellidos = result.getString("APELLIDOS");
				int edad = result.getInt("EDAD");
				String calle = result.getString("CALLE");
				int numero = result.getInt("NUMERO");
				String localidad = result.getString("LOCALIDAD");
				listaalumnosmayoresedad.add(new Alumnos(clave, nombre, apellidos, edad, calle, numero, localidad));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaalumnosmayoresedad;
	}
	
	public ArrayList<Alumnos> alumnosLocalidad(String loc){
		ArrayList<Alumnos> listaalumnoslocalidad = new ArrayList<Alumnos>();
		
		String sql = "SELECT * FROM ALUMNOS WHERE LOCALIDAD=?;";
		
		try {
			state = con.prepareStatement(sql);
			state.setString(1, loc);
			result = state.executeQuery();
			
			while (result.next()) {
				String clave = result.getString("CLAVE");
				String nombre = result.getString("NOMBRE");
				String apellidos = result.getString("APELLIDOS");
				int edad = result.getInt("EDAD");
				String calle = result.getString("CALLE");
				int numero = result.getInt("NUMERO");
				String localidad = result.getString("LOCALIDAD");
				listaalumnoslocalidad.add(new Alumnos(clave, nombre, apellidos, edad, calle, numero, localidad));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaalumnoslocalidad;
	}
	
	public int actualizarAlumno(Alumnos a) {
		int x = 0;
		
		String sql = "UPDATE ALUMNOS SET CLAVE=?, NOMBRE=?, APELLIDOS=?, EDAD=?, CALLE=?, NUMERO=?, LOCALIDAD=? WHERE CLAVE=?;";
		
		try {
			state = con.prepareStatement(sql);
			state.setString(1, a.getClave());
			state.setString(2, a.getNombre());
			state.setString(3, a.getApellidos());
			state.setInt(4, a.getEdad());
			state.setString(5, a.getCalle());
			state.setInt(6, a.getNumero());
			state.setString(7, a.getLocalidad());
			state.setString(8, a.getClave());
			
			x = state.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
	
}
