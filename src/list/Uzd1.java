package list;

import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Uzd1 {

	static boolean jauEksiste(LinkedList<String> saraksts, String koPiev) {
		
		boolean atrasts = false;
		for(int i = 0; i<saraksts.size(); i++) {
			
			if(saraksts.get(i).equalsIgnoreCase(koPiev)) {
				JOptionPane.showInputDialog(null, "Šāds produkts jau ir pievienots sarakstam!", "Kļūda", JOptionPane.WARNING_MESSAGE);
				atrasts = true;
			}
			
		}
		
			
			return atrasts;
	}
	
		
	
	public static void main(String[]args)  {

		String izvele, koPiev, koAtr, koNon, arKoAizst;
		int kurPiev, kurNonm, kuruMain;
	LinkedList<String> saraksts = new LinkedList<>();
	
		do {
			izvele = JOptionPane.showInputDialog(
					"1 - Pievienot produktu\n"+
					"2 - Produktu skaits\n"+
					"3 - Izvadīt produktu\n"+
					"4 - Atrast produktu\n"+
					"5 - Pievienot konkrētā pozīcijā\n"+
					"6 - Noņemt produktu\n"+
					"7 - Noņemt pēc indeksa\n"+
					"8 - Noņemt pirmo\n"+
					"9 - Noņemt pēdējo\n"+
					"10 - Mainīt produktu\n"+
					"11 - Sakārtot alfabētiski\n"+
					"12 - Nodzēst sarakstu\n"+
					"0 - Apturēt programmu~~"
					);
			if(izvele == null) izvele = "0";
			
		}while(!izvele.matches("\\d+"));
	
		switch(izvele) {
		
		case "1": 
				do {
					koPiev = JOptionPane.showInputDialog("Kādu produktu pievienot?");					
				}while((jauEksiste(saraksts, koPiev) == true) ||
						!koPiev.matches("[\\p{L} ]+$"));
				saraksts.add(koPiev.toLowerCase());
		break;
		case "2":
			JOptionPane.showMessageDialog(null, "Produktu skaits: "+saraksts.size()+"~~", "Informācija", JOptionPane.INFORMATION_MESSAGE);
		break;
		case "3":
			
			if(saraksts.size() == 0) JOptionPane.showMessageDialog(null, "Nav sarakstā produktu", "Bridīnājums", JOptionPane.WARNING_MESSAGE);
			else { Iterator<String> izvade = saraksts.iterator(); 
			String str = "";
			while(izvade.hasNext()) {
				str +=izvade.next() + "\n";
			}
			JOptionPane.showMessageDialog(null, str, "Saraksts", JOptionPane.INFORMATION_MESSAGE);
			}
		break;	
		case "4":
			
			
			
		break;
		}
	
	
	
	}

}
