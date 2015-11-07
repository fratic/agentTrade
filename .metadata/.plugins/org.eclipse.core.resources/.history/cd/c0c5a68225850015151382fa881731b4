package coedil99.factory;

import coedil99.model.strategy.BullonePercentDiscountStrategy;
import coedil99.model.strategy.ITotaleStrategy;
import coedil99.model.strategy.SogliaDiscountStrategy;
import coedil99.persistentmodel.EvasoState;
import coedil99.persistentmodel.NonEvasoState;

public class PricingStrategyFactory implements AbstractFactory {
	private static PricingStrategyFactory instance;

	public static PricingStrategyFactory getInstance() {
		if(instance == null)
			instance = new PricingStrategyFactory();
				
		return instance;
	}

	public ITotaleStrategy getBullonePercentDiscountStrategy() {
		return new BullonePercentDiscountStrategy();
	}

	public ITotaleStrategy getSogliaDiscountStrategy() {
		return new SogliaDiscountStrategy();
	}

	public EvasoState creaEvastoState() {
		throw new UnsupportedOperationException();
	}

	public NonEvasoState creaNonEvasoState() {
		throw new UnsupportedOperationException();
	}


	@Override
	public void creaMMagazzino(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void creaMRaccoglitoreRDA(int id) {
		// TODO Auto-generated method stub
		
	}
}