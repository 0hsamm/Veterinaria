package co.edu.unbosque.model.persistence;

import java.time.LocalDate;
import java.util.ArrayList;

import co.edu.unbosque.model.*;

public class TestFileMain {

	public static void main(String[] args) {
		PerroDAO pd = new PerroDAO();
		pd.cargarDesdeArchivoSerializado();
	}
}