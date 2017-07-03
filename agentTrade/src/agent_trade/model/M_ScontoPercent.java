/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package agent_trade.model;

import org.orm.PersistentException;

import agent_trade.persistent.Rem_ScontoPercentCriteria;

public class M_ScontoPercent extends agent_trade.model.M_Sconto {
	public M_ScontoPercent() {
	}
	
	private float percent;
	
	public static M_ScontoPercent caricaScontoBase() throws PersistentException{
		
		Rem_ScontoPercentCriteria criteria= new Rem_ScontoPercentCriteria();
		criteria.percent.eq(0);
		return criteria.uniqueScontoPercent();
	}
	
	public void setPercent(float value) {
		this.percent = value;
	}
	
	public float getPercent() {
		return percent;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
