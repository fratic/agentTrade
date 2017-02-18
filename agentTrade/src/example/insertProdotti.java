package example;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import agent_trade.model.M_Carni;
import agent_trade.model.M_Dolci;
import agent_trade.model.M_Latticini;
import agent_trade.model.M_Prodotto;
import agent_trade.model.M_Vini;
import agent_trade.persistent.AgentTradePersistentManager;

public class insertProdotti {

	public static void main(String[] args) throws PersistentException {

		
		M_Vini p1 = new M_Vini();

		p1.setNome("vino 1");
		p1.setPrezzo(2);
		p1.setCategoria("VINI");
		p1.setIdDescrizioneProdotto("bla bla bla");
		
		p1.setIdDescrizioneProdotto("vino bla bla");
		p1.setCantina("tollo");
		p1.setColore("rosso");
		p1.setIndicazione_geografica("Abruzzo");
		
		
		M_Vini p2 = new M_Vini();
		
		p2.setNome("vino 2");
		p2.setPrezzo(2);
		p2.setCategoria("VINI");
		p2.setIdDescrizioneProdotto("bla bla bla");

		p2.setIdDescrizioneProdotto("vino fuluppone bla bla");
		p2.setCantina("furmella");
		p2.setColore("bianco");
		p2.setIndicazione_geografica("salerno");
		
		
		
		M_Vini p3 = new M_Vini();
		
		p3.setNome("vino 3");
		p3.setPrezzo(3);
		p3.setCategoria("VINI");
		p3.setIdDescrizioneProdotto("bla bla bla");

		
		p3.setIdDescrizioneProdotto("vino rossiccio bla");
		p3.setCantina("prim");
		p3.setColore("rosso");
		p3.setIndicazione_geografica("puglia");
		
		

		
		
		M_Carni p4 = new M_Carni();
		
		p4.setNome("carne di manzo");
		p4.setPrezzo(4);
		p4.setCategoria("CARNI");
		p4.setIdDescrizioneProdotto("bla bla bla");

		p4.setTaglio("cat2");
		p4.setTipo("tipo1");
		
		
		
		M_Carni p5 = new M_Carni();

		p5.setNome("carne di pollo");
		p5.setPrezzo(3);
		p5.setCategoria("CARNI");
		p5.setIdDescrizioneProdotto("bla bla bla");

		p5.setTaglio("cat1");
		p5.setTipo("tipo3");
		
		
		
		M_Latticini p6 = new M_Latticini();
		
		p6.setNome("mozzarella fresca");
		p6.setPrezzo(2);
		p6.setCategoria("LATTICINI");
		p6.setIdDescrizioneProdotto("bla bla bla");

		p6.setStagionatura(12);
		p6.setTipo("mozzarelle");
		
		
		
		M_Latticini p7 = new M_Latticini();
		
		p7.setNome("ricotta del giorno");
		p7.setPrezzo(1);
		p7.setCategoria("LATTICINI");
		p7.setIdDescrizioneProdotto("bla bla bla");
		
		p7.setStagionatura(0);
		p7.setTipo("ricotta");

		
		
		M_Dolci p8 = new M_Dolci();
		
		p8.setNome("Crostata");
		p8.setPrezzo(6);
		p8.setCategoria("DOLCI");
		p8.setIdDescrizioneProdotto("bla bla bla");
		
		p8.setArtigianale(true);
		p8.setFree_gluten(false);
		
		
		
		M_Dolci p9 = new M_Dolci();
		
		p9.setNome("Torta di mele");
		p9.setPrezzo(7);
		p9.setCategoria("DOLCI");
		p9.setIdDescrizioneProdotto("bla bla bla");
		
		p9.setArtigianale(true);
		p9.setFree_gluten(true);

		
		
		PersistentTransaction t = AgentTradePersistentManager.instance().getSession().beginTransaction();
		try {
			
			AgentTradePersistentManager.instance().getSession().save(p1);
			AgentTradePersistentManager.instance().getSession().save(p2);
			AgentTradePersistentManager.instance().getSession().save(p3);
			AgentTradePersistentManager.instance().getSession().save(p4);
			AgentTradePersistentManager.instance().getSession().save(p5);
			AgentTradePersistentManager.instance().getSession().save(p6);
			AgentTradePersistentManager.instance().getSession().save(p7);
			AgentTradePersistentManager.instance().getSession().save(p8);
			AgentTradePersistentManager.instance().getSession().save(p9);

			
			
			// commit per il salvataggio
			t.commit();

		}
		catch (Exception e) {
			System.out.println("Eccezione: "+e);
			t.rollback();
		}
		finally{
			System.out.println("commit a buon fine? "+t.wasCommitted());
		}
				
		
		
		
	}
}
