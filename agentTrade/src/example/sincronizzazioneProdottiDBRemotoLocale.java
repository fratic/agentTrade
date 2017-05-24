package example;

import java.io.IOException;

import org.orm.PersistentException;

import agent_trade.external_system.SystemDaemon;

public class sincronizzazioneProdottiDBRemotoLocale {

	public static void main(String[] args) throws PersistentException, IOException {

//		SystemDaemon.getInstance().sincronizzaListiniRemoti();
		
		SystemDaemon.getInstance().sincronizzaListino();
	}

}

