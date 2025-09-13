package co.edu.unbosque.controller;

import java.time.LocalDate;
import java.util.InputMismatchException;

import co.edu.unbosque.model.*;
import co.edu.unbosque.util.exception.InvalidSizeException;
import co.edu.unbosque.util.exception.InvalidAnswerException;
import co.edu.unbosque.util.exception.InvalidDateException;
import co.edu.unbosque.util.exception.InvalidDateNullException;
import co.edu.unbosque.util.exception.InvalidSexException;
import co.edu.unbosque.util.exception.LanzadorDeExcepcion;
import co.edu.unbosque.util.exception.NegativeNumberException;
import co.edu.unbosque.util.exception.NotValidWordException;
import co.edu.unbosque.view.Consola;

public class Controlador {
	private Consola con;
	private ModelFacade mf;
	private int opcion;

	public Controlador() {
		con = new Consola();
		mf = new ModelFacade();
		opcion = 0;
	}

	public void run() {
		mainloop: while (true) {
			con.mostrarMenuPrincipal();
			opcion = con.leerEntero();
			try {
				LanzadorDeExcepcion.verificarNumeroNegativo(opcion);
			} catch (NegativeNumberException e) {
				con.escribirLineaConSalto(e.getMessage());
			}
			con.quemarLinea();

			switch (opcion) {
			case 1: {
				con.mostrarMenuAnadir();
				opcion = con.leerEntero();
				try {
					LanzadorDeExcepcion.verificarNumeroNegativo(opcion);
				} catch (NegativeNumberException e) {
					con.escribirLineaConSalto(e.getMessage());
				}
				con.quemarLinea();

				switch (opcion) {
				case 1: {
					try {
						con.escribirLineaConSalto("Inserte el nombre del perro");
						String nombre = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(nombre);
						con.escribirLineaConSalto("Inserte el especie del perro");
						String especie = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(especie);
						con.escribirLineaConSalto("Inserte el edad del perro");
						int edad = con.leerEntero();
						LanzadorDeExcepcion.verificarNumeroNegativo(edad);
						con.escribirLineaConSalto("Inserte el peso del perro");
						float peso = con.leerFlotante();
						con.quemarLinea();
						LanzadorDeExcepcion.verificarNumeroNegativo(peso);
						con.escribirLineaConSalto("Inserte si el perro es macho o hembra (M/H)");
						char sexo = con.leerCaracter();
						con.quemarLinea();
						LanzadorDeExcepcion.verificarSexo(sexo);
						con.escribirLineaConSalto("Inserte el habitat del perro");
						String habitat = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(habitat);
						con.escribirLineaConSalto("Ingrese la forma de desplazamiento del animal: ");
						String formaDesplazamiento = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(formaDesplazamiento);
						con.escribirLineaConSalto("Ingrese la fecha en la que fue ingresado el perro (yyyy-mm-dd):");
						LocalDate fechaIngreso = con.leerFecha();
						LanzadorDeExcepcion.verificarFecha(fechaIngreso);
						LanzadorDeExcepcion.verificarFechaVacia(fechaIngreso);
						con.escribirLineaConSalto("Inserte el color del pelaje del perro");
						String colorPelaje = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(colorPelaje);
						con.escribirLineaConSalto("Ingrese el tamaño de la oreja del perro: ");
						String tamanoOreja = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarTamanio(tamanoOreja);



						Perro newData = new Perro(nombre, especie, peso, edad, sexo, habitat, formaDesplazamiento, fechaIngreso, colorPelaje, tamanoOreja);
						mf.getPerroDao().create(newData);
						con.escribirLineaConSalto("Creado exitosamente");
					}catch (NotValidWordException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidDateException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidDateNullException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (NegativeNumberException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidSizeException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidSexException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch(InputMismatchException e) {
						con.escribirLineaConSalto("El valor ingresado no tiene un formato adecuado\n");
						con.quemarLinea();
					}


					break;
				}
				case 2: {
					try {
						con.escribirLineaConSalto("Ingrese el nombre del gato");
						String nombre = con.leerLineaCompleta();	
						LanzadorDeExcepcion.verificarPalabra(nombre);	
						con.escribirLineaConSalto("Ingrese especie del gato");
						String especie = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(especie);
						con.escribirLineaConSalto("Ingrese el peso del gato");
						float peso = con.leerFlotante();			
						LanzadorDeExcepcion.verificarNumeroNegativo(peso);		
						con.escribirLineaConSalto("Ingrese edad del gato");
						int edad = con.leerEntero();		
						LanzadorDeExcepcion.verificarNumeroNegativo(edad);	
						con.quemarLinea();
						con.escribirLineaConSalto("Inserte si el gato es macho o hembra (M/H)");
						char sexo = con.leerCaracter();
						LanzadorDeExcepcion.verificarSexo(sexo);			
						con.quemarLinea();
						con.escribirLineaConSalto("Inserte el habitat del gato");
						String habitat = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(habitat);
						con.escribirLineaConSalto("Ingrese la forma de desplazamiento del animal: ");
						String formaDesplazamiento = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(formaDesplazamiento);
						con.escribirLineaConSalto("Ingrese la fecha en la que fue ingresado el gato (yyyy-mm-dd):");
						LocalDate fechaIngreso = con.leerFecha();
						LanzadorDeExcepcion.verificarFecha(fechaIngreso);
						LanzadorDeExcepcion.verificarFechaVacia(fechaIngreso);
						con.escribirLineaConSalto("Inserte el color del pelaje del gato");
						String colorPelaje = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(colorPelaje);
						con.escribirLineaConSalto("Inserte el tamaño de la oreja del gato (Grande o mediano o pequeño)");
						String tamanoOreja = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarTamanio(tamanoOreja);
						Gato gato = new Gato(nombre, especie, peso, edad, sexo, habitat, formaDesplazamiento, fechaIngreso, colorPelaje,
								tamanoOreja);

						mf.getGatoDao().create(gato);
						con.escribirLineaConSalto("Creado exitosamente");
					} catch (NotValidWordException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidDateException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidDateNullException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (NegativeNumberException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidSizeException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidSexException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch(InputMismatchException e) {
						con.escribirLineaConSalto("El valor ingresado no tiene un formato adecuado\n");
						con.quemarLinea();
					}


					break;
				}
				case 3: {
					try {
						con.escribirLineaConSalto("Ingrese el nombre del pez");
						String nombre = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(nombre);
						con.escribirLineaConSalto("Ingrese la especie del pez");
						String especie = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(especie);
						con.escribirLineaConSalto("Ingrese el peso del pez");
						float peso = con.leerFlotante();
						LanzadorDeExcepcion.verificarNumeroNegativo(peso);		
						con.escribirLineaConSalto("Ingrese la edad del pez");
						int edad = con.leerEntero();				
						LanzadorDeExcepcion.verificarNumeroNegativo(edad);				
						con.quemarLinea();
						con.escribirLineaConSalto("Inserte si el pez es macho o hembra o ninguno (M/H/N)");
						char sexo = con.leerCaracter();		
						LanzadorDeExcepcion.verificarSexo(sexo);		
						con.quemarLinea();
						con.escribirLineaConSalto("Inserte el habitat del pez");
						String habitat = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(habitat);
						con.escribirLineaConSalto("Ingrese la forma de desplazamiento del animal: ");
						String formaDesplazamiento = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(formaDesplazamiento);
						con.escribirLineaConSalto("Ingrese la fecha en la que fue ingresado el pez (yyyy-mm-dd):");
						LocalDate fechaIngreso = con.leerFecha();
						LanzadorDeExcepcion.verificarFecha(fechaIngreso);
						LanzadorDeExcepcion.verificarFechaVacia(fechaIngreso);
						con.escribirLineaConSalto("¿El pez es tiene escamas?");
						boolean tieneEscama = con.leerBooleano();
						LanzadorDeExcepcion.verificarRespuesta(tieneEscama);
						con.escribirLineaConSalto("Ingrese el tamaño de la aleta (grande o mediano o pequeño)");
						String tamanoAleta = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarTamanio(tamanoAleta);
						Pez pez = new Pez(nombre, especie, peso, edad, sexo, habitat, formaDesplazamiento, fechaIngreso, tieneEscama,
								tamanoAleta);
						mf.getPezDao().create(pez);
						con.escribirLineaConSalto("Creado exitosamente");
					}catch (NotValidWordException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidDateException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidDateNullException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (NegativeNumberException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidSizeException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidSexException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidAnswerException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch(InputMismatchException e) {
						con.escribirLineaConSalto("El valor ingresado no tiene un formato adecuado\n");
						con.quemarLinea();
					}


					break;
				}
				case 4: {
					try {
						con.escribirLineaConSalto("Ingrese el nombre del reptil");
						String nombre = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(nombre);
						con.escribirLineaConSalto("Ingrese la especie del reptil");
						String especie = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(especie);
						con.escribirLineaConSalto("Ingrese el peso del reptil");
						float peso = con.leerFlotante();
						LanzadorDeExcepcion.verificarNumeroNegativo(peso);
						con.escribirLineaConSalto("Ingrese la edad del reptil");
						int edad = con.leerEntero();
						LanzadorDeExcepcion.verificarNumeroNegativo(edad);
						con.quemarLinea();
						con.escribirLineaConSalto("Inserte si el reptil es macho o hembra (M/H)");
						char sexo = con.leerCaracter();
						LanzadorDeExcepcion.verificarSexo(sexo);
						con.quemarLinea();
						con.escribirLineaConSalto("Inserte el habitat del reptil");
						String habitat = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(habitat);
						con.escribirLineaConSalto("Ingrese la forma de desplazamiento del animal: ");
						String formaDesplazamiento = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(formaDesplazamiento);
						con.escribirLineaConSalto("Ingrese la fecha en la que fue ingresado el reptil (yyyy-mm-dd):");
						LocalDate fechaIngreso = con.leerFecha();
						LanzadorDeExcepcion.verificarFecha(fechaIngreso);
						LanzadorDeExcepcion.verificarFechaVacia(fechaIngreso);
						con.escribirLineaConSalto("¿El reptil es venenoso?");
						boolean esVenenoso = con.leerBooleano();
						LanzadorDeExcepcion.verificarRespuesta(esVenenoso);
						con.escribirLineaConSalto("¿El reptil es tiene escamas?");
						boolean tieneEscama = con.leerBooleano();
						LanzadorDeExcepcion.verificarRespuesta(tieneEscama);

						Reptil reptil = new Reptil(nombre, especie, peso, edad, sexo, habitat, formaDesplazamiento, fechaIngreso, 
								esVenenoso, tieneEscama);
						mf.getReptilDao().create(reptil);
						con.escribirLineaConSalto("Creado exitosamente");

					}catch (NotValidWordException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidDateException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidDateNullException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (NegativeNumberException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidSexException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidAnswerException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch(InputMismatchException e) {
						con.escribirLineaConSalto("El valor ingresado no tiene un formato adecuado\n");
						con.quemarLinea();
					}


					break;
				}
				case 5: {
					try {
						con.escribirLineaConSalto("Ingrese el nombre del ave");
						String nombre = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(nombre);
						con.escribirLineaConSalto("Ingrese la especie del ave");
						String especie = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(especie);
						con.escribirLineaConSalto("Ingrese el peso del ave");
						float peso = con.leerFlotante();
						LanzadorDeExcepcion.verificarNumeroNegativo(peso);
						con.escribirLineaConSalto("Ingrese la edad del ave");
						int edad = con.leerEntero();
						LanzadorDeExcepcion.verificarNumeroNegativo(edad);
						con.quemarLinea();
						con.escribirLineaConSalto("Inserte si el ave es macho o hembra (M/H)");
						char sexo = con.leerCaracter();
						LanzadorDeExcepcion.verificarSexo(sexo);
						con.quemarLinea();
						con.escribirLineaConSalto("Inserte el habitat del ave");
						String habitat = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(habitat);
						con.escribirLineaConSalto("Ingrese la forma de desplazamiento del animal: ");
						String formaDesplazamiento = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(formaDesplazamiento);
						con.escribirLineaConSalto("Ingrese la fecha en la que fue ingresado el ave (yyyy-mm-dd):");
						LocalDate fechaIngreso = con.leerFecha();
						LanzadorDeExcepcion.verificarFecha(fechaIngreso);
						LanzadorDeExcepcion.verificarFechaVacia(fechaIngreso);
						con.escribirLineaConSalto("Ingrese el tipo de plumas que tiene el ave");
						String tipoDePluma = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(tipoDePluma);
						con.escribirLineaConSalto("Ingrese el tipo de pico");
						String tipoDePico = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(tipoDePico);

						Ave ave = new Ave(nombre, especie, peso, edad, sexo, habitat, formaDesplazamiento, fechaIngreso, tipoDePluma,
								tipoDePico);
						mf.getAveDao().create(ave);
						con.escribirLineaConSalto("Creado exitosamente");
					}catch (NotValidWordException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidDateException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidDateNullException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (NegativeNumberException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidSexException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch(InputMismatchException e) {
						con.escribirLineaConSalto("El valor ingresado no tiene un formato adecuado\n");
						con.quemarLinea();
					}


					break;
				}
				default:
					con.escribirLineaConSalto("La opcion ingresada no es valida, intente de nuevo por favor.");
				}
				break;
			}

			case 2: {
				con.mostrarMenuEliminar();
				try {
					opcion = con.leerEntero();
					LanzadorDeExcepcion.verificarNumeroNegativo(opcion);
				} catch (NegativeNumberException e) {
					con.escribirLineaConSalto(e.getMessage());
				}

				con.quemarLinea();

				switch (opcion) {
				case 1: {
					con.escribirLineaConSalto("Ingrese el indice del perro a eliminar: ");
					try {
						int index = con.leerEntero();
						LanzadorDeExcepcion.verificarNumeroNegativo(index);
						con.quemarLinea();
						mf.getPerroDao().delete(index);
						con.escribirLineaConSalto("Eliminado exitosamente ");
					} catch (NegativeNumberException e) {
						con.escribirLineaConSalto(e.getMessage());
					}

					break;

				}

				case 2: {
					con.escribirLineaConSalto("Ingrese el indice del gato a eliminar: ");
					try {
						int index = con.leerEntero();
						LanzadorDeExcepcion.verificarNumeroNegativo(index);
						con.quemarLinea();
						mf.getGatoDao().delete(index);
						con.escribirLineaConSalto("Eliminado exitosamente ");
					} catch (NegativeNumberException e) {
						con.escribirLineaConSalto(e.getMessage());
					}

					break;

				}

				case 3: {
					con.escribirLineaConSalto("Ingrese el indice del pez a eliminar: ");
					try {
						int index = con.leerEntero();
						LanzadorDeExcepcion.verificarNumeroNegativo(index);
						con.quemarLinea();
						mf.getPezDao().delete(index);
						con.escribirLineaConSalto("Eliminado exitosamente ");
					} catch (NegativeNumberException e) {
						con.escribirLineaConSalto(e.getMessage());
					}


					break;

				}

				case 4: {
					con.escribirLineaConSalto("Ingrese el indice del reptil a eliminar: ");
					try {
						int index = con.leerEntero();
						LanzadorDeExcepcion.verificarNumeroNegativo(index);
						con.quemarLinea();
						mf.getReptilDao().delete(index);
						con.escribirLineaConSalto("Eliminado exitosamente ");
					} catch (NegativeNumberException e) {
						con.escribirLineaConSalto(e.getMessage());
					}


					break;

				}

				case 5: {
					con.escribirLineaConSalto("Ingrese el indice del ave a eliminar: ");
					try {
						int index = con.leerEntero();
						LanzadorDeExcepcion.verificarNumeroNegativo(index);
						con.quemarLinea();
						mf.getAveDao().delete(index);
						con.escribirLineaConSalto("Eliminado exitosamente ");
					} catch (NegativeNumberException e) {
						con.escribirLineaConSalto(e.getMessage());
					}


					break;

				}

				default:
					con.escribirLineaConSalto("La opcion ingresada no es valida, intente de nuevo por favor.");

				}

				break;
			}

			case 3: {
				con.mostrarMenuActualizar();
				try {
					opcion = con.leerEntero();
					LanzadorDeExcepcion.verificarNumeroNegativo(opcion);
				} catch (NegativeNumberException e) {
					con.escribirLineaConSalto(e.getMessage());
				}
				con.quemarLinea();

				switch (opcion) {
				case 1: {
					con.escribirLineaConSalto("Ingrese el indice del perro a actualizar: ");
					try {
					int index = con.leerEntero();
						LanzadorDeExcepcion.verificarNumeroNegativo(index);
					} catch (NegativeNumberException e) {
						con.escribirLineaConSalto(e.getMessage());
					}
					con.quemarLinea();

					try {
						con.escribirLineaConSalto("Inserte el nombre del perro");
						String nombre = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(nombre);
						con.escribirLineaConSalto("Inserte el especie del perro");
						String especie = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(especie);
						con.escribirLineaConSalto("Inserte el edad del perro");
						int edad = con.leerEntero();
						LanzadorDeExcepcion.verificarNumeroNegativo(edad);
						con.escribirLineaConSalto("Inserte el peso del perro");
						float peso = con.leerFlotante();
						con.quemarLinea();
						LanzadorDeExcepcion.verificarNumeroNegativo(peso);
						con.escribirLineaConSalto("Inserte si el perro es macho o hembra (M/H)");
						char sexo = con.leerCaracter();
						con.quemarLinea();
						LanzadorDeExcepcion.verificarSexo(sexo);
						con.escribirLineaConSalto("Inserte el habitat del perro");
						String habitat = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(habitat);
						con.escribirLineaConSalto("Ingrese la forma de desplazamiento del animal: ");
						String formaDesplazamiento = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(formaDesplazamiento);
						con.escribirLineaConSalto("Ingrese la fecha en la que fue ingresado el perro (yyyy-mm-dd):");
						LocalDate fechaIngreso = con.leerFecha();
						LanzadorDeExcepcion.verificarFecha(fechaIngreso);
						LanzadorDeExcepcion.verificarFechaVacia(fechaIngreso);
						con.escribirLineaConSalto("Inserte el color del pelaje del perro");
						String colorPelaje = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(colorPelaje);
						con.escribirLineaConSalto("Ingrese el tamaño de la oreja del perro: ");
						String tamanoOreja = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarTamanio(tamanoOreja);



						Perro newData = new Perro(nombre, especie, peso, edad, sexo, habitat, formaDesplazamiento, fechaIngreso, colorPelaje, tamanoOreja);
						mf.getPerroDao().create(newData);
						con.escribirLineaConSalto("Creado exitosamente");
					}catch (NotValidWordException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidDateException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidDateNullException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (NegativeNumberException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidSizeException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidSexException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch(InputMismatchException e) {
						con.escribirLineaConSalto("El valor ingresado no tiene un formato adecuado\n");
						con.quemarLinea();
					}


					break;
				}
				case 2: {
					con.escribirLineaConSalto("Ingrese el indice del gato a actualizar: ");
					try {
						int index = con.leerEntero();
						LanzadorDeExcepcion.verificarNumeroNegativo(index);
					} catch (NegativeNumberException e) {
						con.escribirLineaConSalto(e.getMessage());
					}
					con.quemarLinea();

					try {
						con.escribirLineaConSalto("Ingrese el nombre del gato");
						String nombre = con.leerLineaCompleta();	
						LanzadorDeExcepcion.verificarPalabra(nombre);	
						con.escribirLineaConSalto("Ingrese especie del gato");
						String especie = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(especie);
						con.escribirLineaConSalto("Ingrese el peso del gato");
						float peso = con.leerFlotante();			
						LanzadorDeExcepcion.verificarNumeroNegativo(peso);		
						con.escribirLineaConSalto("Ingrese edad del gato");
						int edad = con.leerEntero();		
						LanzadorDeExcepcion.verificarNumeroNegativo(edad);	
						con.quemarLinea();
						con.escribirLineaConSalto("Inserte si el gato es macho o hembra (M/H)");
						char sexo = con.leerCaracter();
						LanzadorDeExcepcion.verificarSexo(sexo);			
						con.quemarLinea();
						con.escribirLineaConSalto("Inserte el habitat del gato");
						String habitat = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(habitat);
						con.escribirLineaConSalto("Ingrese la forma de desplazamiento del animal: ");
						String formaDesplazamiento = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(formaDesplazamiento);
						con.escribirLineaConSalto("Ingrese la fecha en la que fue ingresado el gato (yyyy-mm-dd):");
						LocalDate fechaIngreso = con.leerFecha();
						LanzadorDeExcepcion.verificarFecha(fechaIngreso);
						LanzadorDeExcepcion.verificarFechaVacia(fechaIngreso);
						con.escribirLineaConSalto("Inserte el color del pelaje del gato");
						String colorPelaje = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(colorPelaje);
						con.escribirLineaConSalto("Inserte el tamaño de la oreja del gato (Grande o mediano o pequeño)");
						String tamanoOreja = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarTamanio(tamanoOreja);
						Gato gato = new Gato(nombre, especie, peso, edad, sexo, habitat, formaDesplazamiento, fechaIngreso, colorPelaje,
								tamanoOreja);

						mf.getGatoDao().create(gato);
						con.escribirLineaConSalto("Creado exitosamente");
					} catch (NotValidWordException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidDateException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidDateNullException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (NegativeNumberException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidSizeException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidSexException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch(InputMismatchException e) {
						con.escribirLineaConSalto("El valor ingresado no tiene un formato adecuado\n");
						con.quemarLinea();
					}


					break;
				}

				case 3: {
					con.escribirLineaConSalto("Ingrese el indice del pez a actualizar: ");
					try {
						int index = con.leerEntero();
						LanzadorDeExcepcion.verificarNumeroNegativo(index);
					} catch (NegativeNumberException e) {
						con.escribirLineaConSalto(e.getMessage());
					}
					con.quemarLinea();
					try {
						con.escribirLineaConSalto("Ingrese el nombre del pez");
						String nombre = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(nombre);
						con.escribirLineaConSalto("Ingrese la especie del pez");
						String especie = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(especie);
						con.escribirLineaConSalto("Ingrese el peso del pez");
						float peso = con.leerFlotante();
						LanzadorDeExcepcion.verificarNumeroNegativo(peso);		
						con.escribirLineaConSalto("Ingrese la edad del pez");
						int edad = con.leerEntero();				
						LanzadorDeExcepcion.verificarNumeroNegativo(edad);				
						con.quemarLinea();
						con.escribirLineaConSalto("Inserte si el pez es macho o hembra o ninguno (M/H/N)");
						char sexo = con.leerCaracter();		
						LanzadorDeExcepcion.verificarSexo(sexo);		
						con.quemarLinea();
						con.escribirLineaConSalto("Inserte el habitat del pez");
						String habitat = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(habitat);
						con.escribirLineaConSalto("Ingrese la forma de desplazamiento del animal: ");
						String formaDesplazamiento = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(formaDesplazamiento);
						con.escribirLineaConSalto("Ingrese la fecha en la que fue ingresado el pez (yyyy-mm-dd):");
						LocalDate fechaIngreso = con.leerFecha();
						LanzadorDeExcepcion.verificarFecha(fechaIngreso);
						LanzadorDeExcepcion.verificarFechaVacia(fechaIngreso);
						con.escribirLineaConSalto("¿El pez es tiene escamas?");
						boolean tieneEscama = con.leerBooleano();
						LanzadorDeExcepcion.verificarRespuesta(tieneEscama);
						con.escribirLineaConSalto("Ingrese el tamaño de la aleta (grande o mediano o pequeño)");
						String tamanoAleta = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarTamanio(tamanoAleta);
						Pez pez = new Pez(nombre, especie, peso, edad, sexo, habitat, formaDesplazamiento, fechaIngreso, tieneEscama,
								tamanoAleta);
						mf.getPezDao().create(pez);
						con.escribirLineaConSalto("Creado exitosamente");
					}catch (NotValidWordException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidDateException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidDateNullException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (NegativeNumberException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidSizeException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidSexException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidAnswerException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch(InputMismatchException e) {
						con.escribirLineaConSalto("El valor ingresado no tiene un formato adecuado\n");
						con.quemarLinea();
					}


					break;
				}

				case 4: {
					con.escribirLineaConSalto("Ingrese el indice del reptil a actualizar: ");
					try {
						int index = con.leerEntero();
						LanzadorDeExcepcion.verificarNumeroNegativo(index);
					} catch (NegativeNumberException e) {
						con.escribirLineaConSalto(e.getMessage());
					}
					con.quemarLinea();
					try {
						con.escribirLineaConSalto("Ingrese el nombre del reptil");
						String nombre = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(nombre);
						con.escribirLineaConSalto("Ingrese la especie del reptil");
						String especie = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(especie);
						con.escribirLineaConSalto("Ingrese el peso del reptil");
						float peso = con.leerFlotante();
						LanzadorDeExcepcion.verificarNumeroNegativo(peso);
						con.escribirLineaConSalto("Ingrese la edad del reptil");
						int edad = con.leerEntero();
						LanzadorDeExcepcion.verificarNumeroNegativo(edad);
						con.quemarLinea();
						con.escribirLineaConSalto("Inserte si el reptil es macho o hembra (M/H)");
						char sexo = con.leerCaracter();
						LanzadorDeExcepcion.verificarSexo(sexo);
						con.quemarLinea();
						con.escribirLineaConSalto("Inserte el habitat del reptil");
						String habitat = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(habitat);
						con.escribirLineaConSalto("Ingrese la forma de desplazamiento del animal: ");
						String formaDesplazamiento = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(formaDesplazamiento);
						con.escribirLineaConSalto("Ingrese la fecha en la que fue ingresado el reptil (yyyy-mm-dd):");
						LocalDate fechaIngreso = con.leerFecha();
						LanzadorDeExcepcion.verificarFecha(fechaIngreso);
						LanzadorDeExcepcion.verificarFechaVacia(fechaIngreso);
						con.escribirLineaConSalto("¿El reptil es venenoso?");
						boolean esVenenoso = con.leerBooleano();
						LanzadorDeExcepcion.verificarRespuesta(esVenenoso);
						con.escribirLineaConSalto("¿El reptil es tiene escamas?");
						boolean tieneEscama = con.leerBooleano();
						LanzadorDeExcepcion.verificarRespuesta(tieneEscama);

						Reptil reptil = new Reptil(nombre, especie, peso, edad, sexo, habitat, formaDesplazamiento, fechaIngreso, 
								esVenenoso, tieneEscama);
						mf.getReptilDao().create(reptil);
						con.escribirLineaConSalto("Creado exitosamente");

					}catch (NotValidWordException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidDateException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidDateNullException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (NegativeNumberException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidSexException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidAnswerException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch(InputMismatchException e) {
						con.escribirLineaConSalto("El valor ingresado no tiene un formato adecuado\n");
						con.quemarLinea();
					}


					break;
				}

				case 5: {
					con.escribirLineaConSalto("Ingrese el indice del ave a actualizar: ");
					try {
						int index = con.leerEntero();
						LanzadorDeExcepcion.verificarNumeroNegativo(index);
					} catch (NegativeNumberException e) {
						con.escribirLineaConSalto(e.getMessage());
					}
					con.quemarLinea();
					try {
						con.escribirLineaConSalto("Ingrese el nombre del ave");
						String nombre = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(nombre);
						con.escribirLineaConSalto("Ingrese la especie del ave");
						String especie = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(especie);
						con.escribirLineaConSalto("Ingrese el peso del ave");
						float peso = con.leerFlotante();
						LanzadorDeExcepcion.verificarNumeroNegativo(peso);
						con.escribirLineaConSalto("Ingrese la edad del ave");
						int edad = con.leerEntero();
						LanzadorDeExcepcion.verificarNumeroNegativo(edad);
						con.quemarLinea();
						con.escribirLineaConSalto("Inserte si el ave es macho o hembra (M/H)");
						char sexo = con.leerCaracter();
						LanzadorDeExcepcion.verificarSexo(sexo);
						con.quemarLinea();
						con.escribirLineaConSalto("Inserte el habitat del ave");
						String habitat = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(habitat);
						con.escribirLineaConSalto("Ingrese la forma de desplazamiento del animal: ");
						String formaDesplazamiento = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(formaDesplazamiento);
						con.escribirLineaConSalto("Ingrese la fecha en la que fue ingresado el ave (yyyy-mm-dd):");
						LocalDate fechaIngreso = con.leerFecha();
						LanzadorDeExcepcion.verificarFecha(fechaIngreso);
						LanzadorDeExcepcion.verificarFechaVacia(fechaIngreso);
						con.escribirLineaConSalto("Ingrese el tipo de plumas que tiene el ave");
						String tipoDePluma = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(tipoDePluma);
						con.escribirLineaConSalto("Ingrese el tipo de pico");
						String tipoDePico = con.leerLineaCompleta();
						LanzadorDeExcepcion.verificarPalabra(tipoDePico);

						Ave ave = new Ave(nombre, especie, peso, edad, sexo, habitat, formaDesplazamiento, fechaIngreso, tipoDePluma,
								tipoDePico);
						mf.getAveDao().create(ave);
						con.escribirLineaConSalto("Creado exitosamente");
					}catch (NotValidWordException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidDateException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidDateNullException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (NegativeNumberException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch (InvalidSexException e) {
						con.escribirLineaConSalto(e.getMessage());
					}catch(InputMismatchException e) {
						con.escribirLineaConSalto("El valor ingresado no tiene un formato adecuado\n");
						con.quemarLinea();
					}


					break;
				}

				default:
					con.escribirLineaConSalto("La opcion ingresada no es valida, intente de nuevo por favor.");

				}

				break;
			}

			case 4: {
				con.mostrarMenuMostrar();
				try {
					opcion = con.leerEntero();
					LanzadorDeExcepcion.verificarNumeroNegativo(opcion);
				} catch (NegativeNumberException e) {
					con.escribirLineaConSalto(e.getMessage());
				}
				con.quemarLinea();

				switch (opcion) {
				case 1: {
					con.escribirLineaConSalto(mf.getPerroDao().showAll());
					break;

				}

				case 2: {
					con.escribirLineaConSalto(mf.getGatoDao().showAll());
					break;

				}

				case 3: {
					con.escribirLineaConSalto(mf.getPezDao().showAll());
					break;

				}

				case 4: {
					con.escribirLineaConSalto(mf.getReptilDao().showAll());
					break;

				}

				case 5: {
					con.escribirLineaConSalto(mf.getAveDao().showAll());
					break;

				}

				default:
					con.escribirLineaConSalto("La opcion ingresada no es valida, intente de nuevo por favor.");
				}

				break;
			}
			case 5:{
				con.mostrarMenuReporte();
				try {
					opcion = con.leerEntero();
					LanzadorDeExcepcion.verificarNumeroNegativo(opcion);
				} catch (NegativeNumberException e) {
					con.escribirLineaConSalto(e.getMessage());
				}
				switch(opcion) {
					case 1:{
						con.escribirLineaConSalto(mf.getPerroDao().generarReporteDiaActual());
						break;
					}
					case 2:{
						con.escribirLineaConSalto(mf.getGatoDao().generarReporteDiaActual());
						break;
					}
					case 3:{
						con.escribirLineaConSalto(mf.getPezDao().generarReporteDiaActual());
						break;
					}
					case 4:{
						con.escribirLineaConSalto(mf.getReptilDao().generarReporteDiaActual());
						break;
					}
					case 5:{
						con.escribirLineaConSalto(mf.getAveDao().generarReporteDiaActual());
						break;
					}
				}
				break;
			}
			case 99: {
				con.escribirLineaConSalto("Gracias, hasta luego");
				break mainloop;
			}
			default:
				con.escribirLineaConSalto("La opcion ingresada no es valida, intente de nuevo por favor.");
			}
		}

	}
}
