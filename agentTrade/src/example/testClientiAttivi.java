package example;

import org.orm.PersistentException;

import agent_trade.model.M_Cliente;
import agent_trade.persistent.ClienteCriteria;

public class testClientiAttivi {

	public static void main(String[] args) throws PersistentException {


	ClienteCriteria crit = new ClienteCriteria();
	crit.attivo.eq(1);
	
	M_Cliente [] clienti = crit.listCliente();

	System.out.println("lunghezza "+clienti.length);
	
	for (M_Cliente m_Cliente : clienti) {
		System.out.println("cliente: "+m_Cliente);
	}
	
	
	}
}
