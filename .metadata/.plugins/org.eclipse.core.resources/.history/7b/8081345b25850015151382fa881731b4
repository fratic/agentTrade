package coedil99;

import javax.swing.SwingUtilities;
import coedil99.factory.MagazzinoFactory;
import coedil99.factory.CostantFactory;
import coedil99.ui.Coedil99View;
import coedil99.ui.SplashScreen;

public class Main {
	
	public static void main(String[] args) {

		final SplashScreen  splash = new SplashScreen();
		splash.setVisible(true); 
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				
				Coedil99View.getInstance().setVisible(true);
				splash.setVisible(false);
			}
		});
		MagazzinoFactory.getInstance().creaMRaccoglitoreRDA(CostantFactory.RACCOGLITORE_1);
		MagazzinoFactory.getInstance().creaMMagazzino(CostantFactory.MAGAZZINO_1);
	}
}
