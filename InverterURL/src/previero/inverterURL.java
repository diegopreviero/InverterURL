package previero;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;

public class inverterURL {

	public static void main(String[] args) {
		try {

			String urlOrigem = JOptionPane.showInputDialog("Entre com a URL invertida");
			String urlDestino="";
			char tmp;

			for (int x=(urlOrigem.length()-1); x!=-1;x--){
				tmp=urlOrigem.charAt(x);
				urlDestino=urlDestino+tmp;
			}

			int resposta;		
			resposta = JOptionPane.showConfirmDialog(null, "Abrir a URL de destino: " + urlDestino + "?");
			if (resposta == JOptionPane.YES_OPTION) {

				if (Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
					if (desktop.isSupported(Desktop.Action.BROWSE)) {
						try {
							desktop.browse(new URI("http://"+urlDestino));
						}
						catch(IOException ioe) {
							ioe.printStackTrace();
						}
						catch(URISyntaxException use) {
							use.printStackTrace();
						}
					}
				}

			} 
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e);
		}
	}
}