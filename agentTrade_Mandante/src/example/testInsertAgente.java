package example;

import org.orm.PersistentException;

import controller.Ctrl_gestisciAgente;

public class testInsertAgente {

	public static void main(String[] args) throws PersistentException {

		Ctrl_gestisciAgente.getInstance().nuovoAgente("mario", "Fraticelli", "antofrat", "asd", "sgr", "71013", "via foggia 217", "fratic@asd.it", "3204578987", 3);
		
	}

}
