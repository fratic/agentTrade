package example;
import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import agent_trade.model.M_Agente;
import agent_trade.model.M_Cliente;
import agent_trade.model.M_Preventivo;
import agent_trade.model.M_Preventivo_Item;
import agent_trade.model.M_Prodotto;
import persistent.AgentTradePersistentManager;
import persistent.AgenteCriteria;
import persistent.ClienteCriteria;
import persistent.ProdottoCriteria;

public class testPreventivo {

	public static void main(String[] args) throws PersistentException {

		AgenteCriteria AgenteCriteria = new AgenteCriteria();
		AgenteCriteria.IdAgente.eq(1);	
		M_Agente agente= AgenteCriteria.listAgente()[0];
		System.out.println("AGENTE "+agente.getCognome()+agente.getNome());
				
		
		
		ClienteCriteria ClienteCriteria = new ClienteCriteria();
		ClienteCriteria.idCliente.eq(1);	
		M_Cliente cliente = ClienteCriteria.listCliente()[0];
		System.out.println("Cliente "+cliente.getCognome()+cliente.getNome());
		
		M_Preventivo p = M_Preventivo.getInstance();
		p.setRif_Agente(agente);
		p.setRif_Cliente(cliente);
		p.setData(new Date(2017, 05, 12));
		System.out.println("Cliente associato al prev "+p.getRif_Cliente().getCognome()+p.getRif_Cliente().getNome());
		System.out.println("---------------------ID PREV dopo set: "+p.getIdPreventivo());

		ProdottoCriteria pc = new ProdottoCriteria();
		pc.IdProdotto.eq(1);
		M_Prodotto prod = pc.listProdotto()[0];
		System.out.println("prodotto: "+prod.getIdProdotto());
		System.out.println("prezzo: "+prod.getPrezzo());
		
		
		
		ProdottoCriteria pc2 = new ProdottoCriteria();
		pc2.IdProdotto.eq(3);
		M_Prodotto p2 = pc2.listProdotto()[0];
		System.out.println("prodotto: "+p2.getIdProdotto());
		System.out.println("prodotto: "+p2.getPrezzo());

		ProdottoCriteria pc3 = new ProdottoCriteria();
		pc3.IdProdotto.eq(5);
		M_Prodotto p3 = pc3.listProdotto()[0];
		System.out.println("prodotto: "+p3.getIdProdotto());
		System.out.println("prodotto: "+p3.getPrezzo());

		
		p.addItem(prod);
		p.addItem(p2);
		p.addItem(p3);
	
		p.addQuant(prod.getIdProdotto(), 5);
		p.addQuant(p2.getIdProdotto(), 8);
		p.addQuant(p3.getIdProdotto(), 12);

		

//		ArrayList <M_Preventivo_Item> elenco = (ArrayList<M_Preventivo_Item>) p.getItem();
		java.util.List<M_Preventivo_Item> elenco = new ArrayList<>();
		elenco= p.getItem();
		
		for (M_Preventivo_Item item : elenco) {
//			System.out.println("Size : "+item.getObb().size());
		}
		
//		System.out.println("agente : "+p.getRif_Agente().getCognome()+"CLIENTE"+p.getRif_Cliente().getCodice_fiscale()+"SiZE:"+p.getItem().size());
		
		PersistentTransaction t = AgentTradePersistentManager.instance().getSession().beginTransaction();
		try {
			

			AgentTradePersistentManager.instance().getSession().save(p);


			// commit per il salvataggio
			t.commit();
			System.out.println("commmit andato a buon fine? "+t.wasCommitted());

		}
		catch (Exception e) {
			System.out.println("commmit andato a buon fine? "+t.wasCommitted());

			System.out.println("Eccezione: "+e);
			t.rollback();
		}
		
		
		
		
		
		
		
	}

}
