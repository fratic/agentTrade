package example;

import org.orm.PersistentException;

import agent_trade.model.M_ScontoPercent;
import agent_trade.model.M_Sconto;
import agent_trade.model.M_ScontoCliente;
import agent_trade.model.M_ScontoQuantita;

public class scontoTab {

	public static void main(String[] args) throws PersistentException {

		M_ScontoCliente scontoCliente = new M_ScontoCliente();
		scontoCliente.setPercent((float)0.2);
//		
//		SContoPercent scontoPer = new SContoPercent();
//		scontoPer.setPercent((float)0);
//		
//		ScontoQuantita scontoQ = new ScontoQuantita();
//		scontoQ.setQuantita(5);
//		scontoQ.setScontoFisso(8);
		
		M_Sconto.salvaSconto(scontoCliente);
//		Sconto.salvaSconto(scontoPer);
//		Sconto.salvaSconto(scontoQ);

		
	}

}
