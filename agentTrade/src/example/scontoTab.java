package example;

import org.orm.PersistentException;

import agent_trade.model.M_Sconto;
import agent_trade.model.M_ScontoCliente;
import agent_trade.model.M_ScontoPercent;
import agent_trade.model.M_ScontoQuantita;

public class scontoTab {

	public static void main(String[] args) throws PersistentException {

		M_ScontoCliente scontoCliente = new M_ScontoCliente();
		scontoCliente.setPercent((float)0);
	
		M_ScontoCliente scontoCliente1 = new M_ScontoCliente();
		scontoCliente1.setPercent((float)0.1);

		M_ScontoCliente scontoCliente2 = new M_ScontoCliente();
		scontoCliente2.setPercent((float)0.15);

		
		M_ScontoPercent scontoPer = new M_ScontoPercent();
		scontoPer.setPercent((float)0);
		
		M_ScontoPercent scontoPer3 = new M_ScontoPercent();
		scontoPer3.setPercent((float)0.1);

		M_ScontoPercent scontoPer4 = new M_ScontoPercent();
		scontoPer4.setPercent((float)0.2);

		
		M_ScontoQuantita scontoQ = new M_ScontoQuantita();
		scontoQ.setQuantita(5);
		scontoQ.setScontoFisso(8);
		
		M_ScontoQuantita scontoQ1 = new M_ScontoQuantita();
		scontoQ1.setQuantita(10);
		scontoQ1.setScontoFisso(10);

		M_ScontoQuantita scontoQ2 = new M_ScontoQuantita();
		scontoQ2.setQuantita(100);
		scontoQ2.setScontoFisso(50);

		M_ScontoQuantita scontoQ3 = new M_ScontoQuantita();
		scontoQ3.setQuantita(50);
		scontoQ3.setScontoFisso(30);

		
		
		M_Sconto.salvaScontoRemoto(scontoCliente);
		M_Sconto.salvaScontoRemoto(scontoCliente1);
		M_Sconto.salvaScontoRemoto(scontoCliente2);

		M_Sconto.salvaScontoRemoto(scontoPer);
		M_Sconto.salvaScontoRemoto(scontoPer3);
		M_Sconto.salvaScontoRemoto(scontoPer4);

		
		M_Sconto.salvaScontoRemoto(scontoQ);
		M_Sconto.salvaScontoRemoto(scontoQ1);
		M_Sconto.salvaScontoRemoto(scontoQ2);
		M_Sconto.salvaScontoRemoto(scontoQ3);

		
	}

}
