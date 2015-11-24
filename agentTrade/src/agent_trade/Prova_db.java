package agent_trade;

import agent_trade.model.M_Cliente;
import agent_trade.persistentTemp.Dao_System;

public class Prova_db {
		
	public static void main(String[] args) {
		M_Cliente c= Dao_System.getInstance().cercaCliente("beato");
		System.out.print(c.getCognome()+"  "+c.getCodice_fiscale()+" ");
		
		Dao_System.getInstance().cancellaCliente(c);
			
		c= Dao_System.getInstance().cercaCliente("inzaghi");
		if (c!=null)
			System.out.print(c.getCognome()+"  "+c.getCodice_fiscale()+" ");
		else 
			System.out.println("cancellato");
		
			
	}

}


