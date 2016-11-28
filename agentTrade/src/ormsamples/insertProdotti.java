package ormsamples;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import agent_trade.model.M_Carni;
import agent_trade.model.M_Dolci;
import agent_trade.model.M_Latticini;
import agent_trade.model.M_Vini;

public class insertProdotti {

	public static void main(String[] args) throws PersistentException
	{
		M_Dolci p =new M_Dolci(1, (float) 1.10 , "Caramelle", "Dolci", false, false);
		M_Dolci p1 =new M_Dolci(2, (float) 1.7, "Biscotti", "Dolci", false, false);
		M_Dolci p2 =new M_Dolci(3, (float) 3.5, "Pandoro", "Dolci", true, false);
		M_Dolci p3 =new M_Dolci(4, 5, "Panettone", "Dolci", true, false);

		M_Carni p4 =new M_Carni(5, 18, "Vitello", "Carne", "Italia", "girello","1");
		M_Carni p5 =new M_Carni(6, 9, "Maiale", "Carne", "Italia", "arista","2");
		M_Carni p6 =new M_Carni(7, 8, "Pollo", "Carne", "Italia", "petto","1");
		M_Carni p7 =new M_Carni(8, 4, "Pollo", "Carne", "Italia", "coscie","3");

		M_Vini p8 =new M_Vini(9, 12, "Montepulciano", "Vino", "rosso","Abruzzo", "cantina");
		M_Vini p9 =new M_Vini(10, 12, "Trebbiano", "Vino", "Bianco","Abruzzo", "cantina");
		M_Vini p10 =new M_Vini(11, 13, "Primitivo", "Vino", "Bianco","Puglia", "cantina");
		M_Vini p11 =new M_Vini(12, 15, "Falanghina", "Vino", "Bianco","Sicilia", "cantina");

		M_Latticini p12 =new M_Latticini(13, 9, "Grana", "Latticini", 16, "");
		M_Latticini p13 =new M_Latticini(14, (float) 6.7, "Emmental", "Latticini", 6, "");
		M_Latticini p14 =new M_Latticini(15, (float) 1.7, "Mozzarella", "Latticini", 0, "");
	
	
	PersistentTransaction t = persistent.AgentTradePersistentManager.instance().getSession().beginTransaction();
	try {
		
		persistent.AgentTradePersistentManager.instance().getSession().save(p);
		persistent.AgentTradePersistentManager.instance().getSession().save(p1);
		persistent.AgentTradePersistentManager.instance().getSession().save(p2);
		persistent.AgentTradePersistentManager.instance().getSession().save(p3);
		persistent.AgentTradePersistentManager.instance().getSession().save(p4);
		persistent.AgentTradePersistentManager.instance().getSession().save(p5);
		persistent.AgentTradePersistentManager.instance().getSession().save(p6);
		persistent.AgentTradePersistentManager.instance().getSession().save(p7);
		persistent.AgentTradePersistentManager.instance().getSession().save(p8);
		persistent.AgentTradePersistentManager.instance().getSession().save(p9);
		persistent.AgentTradePersistentManager.instance().getSession().save(p10);
		persistent.AgentTradePersistentManager.instance().getSession().save(p11);
		persistent.AgentTradePersistentManager.instance().getSession().save(p12);
		persistent.AgentTradePersistentManager.instance().getSession().save(p13);
		persistent.AgentTradePersistentManager.instance().getSession().save(p14);

		
		t.commit();
	}

	catch (Exception e) {
		t.rollback();
	}	
	finally {
		persistent.AgentTradePersistentManager.instance().disposePersistentManager();
	}
	
	}
}


