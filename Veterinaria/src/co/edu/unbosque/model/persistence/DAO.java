package co.edu.unbosque.model.persistence;

public interface DAO <E>{
	
	public void create(E newData);
	public boolean delete(int index);
	public boolean update(int index, E newData);
	public String showAll();
	public int count();
	public void  leerDesdeArchivoDeTexto(String url);
	public void escribirEnArchivoDeTexto();
	public void cargarDesdeArchivoSerializado();
	public void escribirEnArchivoSerializado();
}
