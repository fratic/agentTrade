package coedil99.factory;

import coedil99.persistentmodel.EvasoState;
import coedil99.persistentmodel.Magazzino;
import coedil99.persistentmodel.MagazzinoDAO;
import coedil99.persistentmodel.NonEvasoState;
import coedil99.persistentmodel.RaccoglitoreRDA;
import coedil99.persistentmodel.RaccoglitoreRDADAO;
import coedil99.model.strategy.ITotaleStrategy;

public class MagazzinoFactory implements AbstractFactory {
	private static MagazzinoFactory instance;

	public static MagazzinoFactory getInstance() {
		if(instance == null)
			instance = new MagazzinoFactory();
				
		return instance;
	}
	
	public EvasoState creaEvastoState() {
		throw new UnsupportedOperationException();
	}

	public NonEvasoState creaNonEvasoState() {
		throw new UnsupportedOperationException();
	}


	public ITotaleStrategy getSogliaDiscountStrategy() {
		throw new UnsupportedOperationException();
	}

	public ITotaleStrategy getBullonePercentDiscountStrategy() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void creaMRaccoglitoreRDA(int id) {
		if(RaccoglitoreRDADAO.loadRaccoglitoreRDAByQuery("id = " + id, "ID") == null) 	
			RaccoglitoreRDADAO.save(new RaccoglitoreRDA());
	}
	@Override
	public void creaMMagazzino(int id) {
		if(MagazzinoDAO.loadMagazzinoByQuery("id = " + id, "ID") == null) 
			MagazzinoDAO.save(new Magazzino());
	}

}