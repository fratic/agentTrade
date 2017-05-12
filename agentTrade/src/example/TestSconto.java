package example;

import java.util.Date;

import org.orm.PersistentException;

import agent_trade.model.M_Agente;
import agent_trade.model.M_Cliente;
import agent_trade.model.M_Preventivo;
import agent_trade.model.M_Prodotto;
import agent_trade.persistent.ClienteCriteria;

public class TestSconto {
/*
 * 
 * nel db locale mettere a 0 gli sconti del prodotto 78 e 80
 * in M_Preventivo sono state aggiunte delle funzioni
 * in M_Prev_Item commentare in setQuantità(int quantita) NotifyObservers()
 * in M_Prev_Item modificare calcolaParziale()
 * 
 */
	
	
	public static void main(String[] args) throws PersistentException {

		
		M_Agente agente = M_Agente.caricaAgente("mircdan");
		ClienteCriteria ClienteCriteria = new ClienteCriteria();
		ClienteCriteria.idCliente.eq(6); //cliente con sconto
//		ClienteCriteria.idCliente.eq(7); //cliente senza sconto
		M_Cliente cliente = ClienteCriteria.listCliente()[0];
		
		M_Preventivo p = M_Preventivo.getInstance();
		p.setRif_Agente(agente);
		p.setRif_Cliente(cliente);
		p.setData(new Date(2017, 05, 12));

		
		
		M_Prodotto p1 = M_Prodotto.caricaProdotto(78);
//		System.out.println("prodotto: "+p1.getIdProdotto());
//		System.out.println("prezzo: "+p1.getPrezzo());
		
		M_Prodotto p2 = M_Prodotto.caricaProdotto(79); //PRODOTTO SCONTATO IN PERCENTUALE del 15%
//		System.out.println("prodotto: "+p2.getIdProdotto());
//		System.out.println("prezzo: "+p2.getPrezzo());

		M_Prodotto p3 = M_Prodotto.caricaProdotto(80);
//		System.out.println("prodotto: "+p3.getIdProdotto());
//		System.out.println("prezzo: "+p3.getPrezzo());

		
		p.addItem(p1);
		p.addItem(p2);
		p.addItem(p3);
	
		p.addQuant(p1.getIdProdotto(), 5);
/*
 * 
 * in teoria per ogni prodotto non dovremmo fare il calcolo dello sconto due volte come 
 * è fatto qui p.calcolaSconto("percentProd1") e p.calcolaSconto("assolutoProd1") ma 
 * secondo me bisogna leggere in un campo del prodotto che tipo di sconto è "percentProd1"
 * o "assolutoProd1" e poi chiamare calcolaSconto cmq è da rivedere meglio perchè nel 
 * primo caso chiamo calcola sconto in setPrezzo nel secondo in setParziale (ma credo 
 * che basti rivedere l'algoritmo)
 * cmq ogni volta che si deve calcolare il parziale di una riga andrebbero calcolati 
 * gli sconti sul prodotto e lo sconto cliente ogni volta che si deve calcolare il 
 * parziale totale
 * 
*/
		p.calcolaParziale(p1.getIdProdotto());
		System.out.println("parziale riga1 non scontato: "+ p.getParziale());
		
		p1.setPrezzo(p.calcolaSconto("percentProd1"));
		p.calcolaParziale(p1.getIdProdotto());
		System.out.println("parziale riga1 sconto %: "+p.getParziale());
		
		p.setParziale(p.calcolaSconto("assolutoProd1"));
		System.out.println("parziale riga1 sconto assoluto: "+p.getParziale());
		
		p.setTotale(p.getTotale() + p.getParziale());
		System.out.println("totale parziale: "+p.getTotale());
//		lo sconto sul cliente viene solo visualizzato non modifica il totale parziale 
		System.out.println("totale parziale con sconto cliente: "+ p.calcolaSconto("cliente"));
		System.out.println("");
		
		p.addQuant(p2.getIdProdotto(), 8);
		p.calcolaParziale(p2.getIdProdotto());
		System.out.println("parziale riga2 non scontato: "+ p.getParziale());
		
	
		p2.setPrezzo(p.calcolaSconto("percentProd2"));
		p.calcolaParziale(p2.getIdProdotto());
		System.out.println("parziale riga2 sconto %: "+p.getParziale());
		
		p.setParziale(p.calcolaSconto("assolutoProd2"));
		System.out.println("parziale riga2 sconto assoluto: "+p.getParziale());
		
		p.setTotale(p.getTotale() + p.getParziale());
		System.out.println("totale parziale: "+p.getTotale());
		System.out.println("totale parziale con sconto cliente: "+ p.calcolaSconto("cliente"));
		System.out.println("");
		
		p.addQuant(p3.getIdProdotto(), 12); //prodotto che ha uno sconto con una quantità >10
		p.calcolaParziale(p3.getIdProdotto());
		System.out.println("parziale riga3 non scontato: "+ p.getParziale());
		
		p3.setPrezzo(p.calcolaSconto("percentProd3"));
		p.calcolaParziale(p3.getIdProdotto());
		System.out.println("parziale riga3 sconto %: "+p.getParziale());
		
		p.setParziale(p.calcolaSconto("assolutoProd3"));
		System.out.println("parziale riga3 sconto assoluto: "+p.getParziale());
		
		p.setTotale(p.getTotale() + p.getParziale());
		System.out.println("totale parziale:  "+p.getTotale());
		System.out.println("totale parziale con sconto cliente: "+ p.calcolaSconto("cliente"));
		System.out.println("");

		System.out.println("totale scontato senza sconto cliente: "+ p.getTotale());
		System.out.println("totale scontato per il cliente "+p.calcolaSconto("cliente"));
		
	}

}
