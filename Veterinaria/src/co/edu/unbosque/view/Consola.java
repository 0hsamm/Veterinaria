package co.edu.unbosque.view;

import java.time.LocalDate;
import java.util.Scanner;

public class Consola {
	
	private Scanner sc;
	
	public Consola() {
		sc = new Scanner(System.in);
		
	}
	public int leerEntero() {
		return sc.nextInt();
		
	}
	public float leerFlotante() {
		return sc.nextFloat();
	}
	public double leerDoble() {
		return sc.nextDouble();
	}
	public long leerLong() {
		return sc.nextLong();
	}
	public String leerLineaCompleta() {
		return sc.nextLine();
	}
	public char leerCaracter() {
		return sc.next().charAt(0);
	}
	
	public void escribirLineaConSalto(String texto) {
		System.out.println(texto);
	}
	public void quemarLinea() {
		sc.nextLine();
	}
	public boolean leerBooleano() {
		String entrada = leerLineaCompleta();
		if (entrada.toLowerCase().contains("si")) {
			return true;
		}else {
			
			return false;
		}		
	}
	
	public LocalDate leerFecha() {
		String fechaTexto = sc.nextLine();
		LocalDate fecha = LocalDate.parse(fechaTexto);
		return fecha;
	}
	
	public void mostrarMenuPrincipal() {
		System.out.println("Ingrese la opcion que desea ejecutar:" 
				+ "\n 1. Añadir animal" 
				+ "\n 2. Eliminar animal"
				+ "\n 3. Actualizar animal"
				+ "\n 4. Mostrar animal"
				+ "\n 99. Salir ");
	}
	public void mostrarMenuAnadir() {
		System.out.println("Ingrese la opcion que desea ejecutar:" 
				+ "\n 1. Añadir perros" 
				+ "\n 2. Añadir gatos" 
				+ "\n 3. Añadir peces" 
				+ "\n 4. Añadir reptiles" 
				+ "\n 5. Añadir aves"
				+ "\n 6. Salir");
	}
	
	public void mostrarMenuEliminar() {
		System.out.println("Ingrese la opcion que desea ejecutar:" 
				+ "\n 1. Eliminar perros"
				+ "\n 2. Eliminar gatos"
				+ "\n 3. Eliminar peces"
				+ "\n 4. Eliminar reptiles"
				+ "\n 5. Eliminar aves");
	}
	
	public void mostrarMenuActualizar() {
		System.out.println("Ingrese la opcion que desea ejecutar:"
				+ "\n 1. Actualizar perros"
				+ "\n 2. Actualizar gatos"
				+ "\n 3. Actualizar peces"
				+ "\n 4. Actualizar reptiles"
				+ "\n 5. Actualizar aves");
	}
	public void mostrarMenuMostrar() {
		System.out.println("Ingrese la opcion que desea ejecutar:"
				+ "\n 1. Mostrar perros"
				+ "\n 2. Mostrar gatos"
				+ "\n 3. Mostrar peces"
				+ "\n 4. Mostrar reptiles"
				+ "\n 5. Mostrar aves");
		
		
	}
}
