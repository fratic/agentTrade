package example;

import java.io.IOException;

import org.orm.PersistentException;

import agent_trade.external_system.SystemDaemon;

public class sincronizzazioneProdottiDBRemotoLocale {

	public static void main(String[] args) throws PersistentException, IOException, CloneNotSupportedException {

//		SystemDaemon.getInstance().sincronizzaListiniRemoti();
		
//		SystemDaemon.getInstance().sincronizzaListinoRemoto("Lem");

//		SystemDaemon.getInstance().sincronizzaListino();

		System.out.println("SINCRONIZZA SCONTI");
		SystemDaemon.getInstance().sincronizzaSconti();
		
		System.out.println("SINCRONIZZA AZIENDE");
		SystemDaemon.getInstance().sincronizzaAziende();

		System.out.println("SINCRONIZZA LISTINO");
		SystemDaemon.getInstance().sincronizzaListino();

	}

}

