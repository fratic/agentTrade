package example;

import java.io.IOException;

import org.orm.PersistentException;

import agent_trade.external_system.SystemDaemon;

public class testSincAziende {

	public static void main(String[] args) throws PersistentException, IOException {

		/***aggiustare gli id*/
		SystemDaemon.getInstance().sincronizzaAziende();

	}

}

