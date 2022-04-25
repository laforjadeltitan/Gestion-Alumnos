package com.teideformacion.ejecutar;

import java.util.ArrayList;
import java.util.Scanner;
import com.teideformacion.alumnos.Alumnos;
import com.teideformacion.alumnos.Conexion;

public class Ejecutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Conexion con = new Conexion();
		boolean nopasar = true;
		
		do {
			System.out.println("Menú");
			System.out.println("1. Dar de alta un alumno");
			System.out.println("2. Dar de baja un alumno");
			System.out.println("3. Actualizar un alumno");
			System.out.println("4. Mostrar informacion de todos los alumnos");
			System.out.println("5. Mostrar informacion de los alumnos de una localidad concreta");
			System.out.println("6. Mostrar informacion de los alumnos mayores de edad");
			
			int opcion = sc.nextInt();
			
			switch (opcion) {
			case 1:
				System.out.println("Clave");
				String clavealta = sc.next();
				
				System.out.println("Nombre");
				String nombre = sc.next();
				
				System.out.println("Apellidos");
				String apellidos = sc.next();
				
				System.out.println("Edad");
				int edad = sc.nextInt();
				
				System.out.println("Calle");
				String calle = sc.next();
				
				System.out.println("Numero");
				int numero = sc.nextInt();
				
				System.out.println("Localidad");
				String localidad1 = sc.next();
				
				Alumnos alumno = new Alumnos(clavealta, nombre, apellidos, edad, calle, numero, localidad1);
				
				if (con.insertarAlumnos(alumno)==1) {
					System.out.println("Alumno añadido correctamente");
				}else {
					System.out.println("Error, no se ha añadido el alumno");
				}
				break;
			case 2:
				System.out.println("Clave");
				int clavebaja = sc.nextInt();
				
				if (con.eliminarAlumno(clavebaja)==1) {
					System.out.println("Alumno eliminado correctamente");
				} else {
					System.out.println("Error, no se ha eliminado el alumno");
				}
				break;
			case 3:
				// Al llamar la funcion retorna un valor, ese valor deberíamos guardarlo en una variable del mismo tipo de dato
				// Ejemplo (esto retorna un entero dependiendo de si se insertó la fila o no, entonces sería un 0): int result_insert = con.insertar(new Departamentos(n, nombre, localidad));
				System.out.println("Clave");
				String claveactualizar = sc.next();
				
				System.out.println("Nombre");
				String nombreactualizar = sc.next();
				
				System.out.println("Apellidos");
				String apellidosactualizar = sc.next();
				
				System.out.println("Edad");
				int edadactualizar = sc.nextInt();
				
				System.out.println("Calle");
				String calleactualizar = sc.next();
				
				System.out.println("Numero");
				int numeroactualizar = sc.nextInt();
				
				System.out.println("Localidad");
				String localidadactualizar = sc.next();
				
				Alumnos alumnoactualizar = new Alumnos(claveactualizar, nombreactualizar, apellidosactualizar, edadactualizar, calleactualizar, numeroactualizar, localidadactualizar);
				
				if (con.actualizarAlumno(alumnoactualizar)==1) {
					System.out.println("Alumno actualizado correctamente");
				} else {
					System.out.println("Error, no se ha actualizado el alumno");
				}
				break;
			case 4:
				ArrayList<Alumnos> listaalumnos = con.consultarAlumnos();
				
				for (Alumnos alumnos : listaalumnos) {
					System.out.println(listaalumnos);
				}
				break;
			case 5:
				System.out.println("Localidad");
				String localidad2 = sc.next();
				ArrayList<Alumnos> listaalumnoslocalidad = con.alumnosLocalidad(localidad2);
				
				for (Alumnos alumnos : listaalumnoslocalidad) {
					System.out.println(listaalumnoslocalidad);
				}
				break;
			case 6:
				ArrayList<Alumnos> listaalumnosmayoresedad = con.alumnosMayoresEdad();
				
				for (Alumnos alumnos : listaalumnosmayoresedad) {
					System.out.println(listaalumnosmayoresedad);
				}
				break;
			default:
				break;
			}
			
		} while (nopasar);
	}

}
