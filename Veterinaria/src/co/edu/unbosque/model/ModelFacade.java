package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.AveDAO;
import co.edu.unbosque.model.persistence.GatoDAO;
import co.edu.unbosque.model.persistence.PerroDAO;
import co.edu.unbosque.model.persistence.PezDAO;
import co.edu.unbosque.model.persistence.ReptilDAO;

public class ModelFacade {
	private AveDAO aveDao;
	private GatoDAO gatoDao;
	private PerroDAO perroDao;
	private PezDAO pezDao;
	private ReptilDAO reptilDao;
	
	public ModelFacade() {
		aveDao = new AveDAO();
		gatoDao = new GatoDAO();
		perroDao = new PerroDAO();
		pezDao = new PezDAO();
		reptilDao = new ReptilDAO();
	}

	public AveDAO getAveDao() {
		return aveDao;
	}

	public void setAveDao(AveDAO aveDao) {
		this.aveDao = aveDao;
	}

	public GatoDAO getGatoDao() {
		return gatoDao;
	}

	public void setGatoDao(GatoDAO gatoDao) {
		this.gatoDao = gatoDao;
	}

	public PerroDAO getPerroDao() {
		return perroDao;
	}

	public void setPerroDao(PerroDAO perroDao) {
		this.perroDao = perroDao;
	}

	public PezDAO getPezDao() {
		return pezDao;
	}

	public void setPezDao(PezDAO pezDao) {
		this.pezDao = pezDao;
	}

	public ReptilDAO getReptilDao() {
		return reptilDao;
	}

	public void setReptilDao(ReptilDAO reptilDao) {
		this.reptilDao = reptilDao;
	}
	
}
