package list;

import java.util.Collections;
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
		int kurPiev, kurNon, kuruMain;
		Object[] atbilde = {"Jā", "Nē"};

	LinkedList<String> saraksts = new LinkedList<>();
	
		do {
			izvele = JOptionPane.showInputDialog(null,
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
					"0 - Apturēt programmu~~", "Izvēlne", JOptionPane.PLAIN_MESSAGE
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
			do {
				koAtr = JOptionPane.showInputDialog(null, "Kādu produktu meklēt sarakstā?", "Jautājums", JOptionPane.INFORMATION_MESSAGE);
				
			}while(!koAtr.matches("[\\p{L} ]+$"));
			
			JOptionPane.showMessageDialog(null, ((saraksts.indexOf(koAtr)) > -1)?
					"Produkts atrasts"+saraksts.indexOf(koAtr)+". pozīcijā~" : "Produkts netika atrasts~", "Informācija", JOptionPane.INFORMATION_MESSAGE);
			
		break;
		case "5":
			do {
				koPiev = JOptionPane.showInputDialog("Kādu produktu pievienot?");					
				kurPiev = Integer.parseInt(JOptionPane.showInputDialog("Kurā pozīcijā pievienot?"));
				
				if( kurPiev < 1 || kurPiev >= saraksts.size()) JOptionPane.showMessageDialog(null, "Nedrīkst pievienot produktu šājā pozīcijā~", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
			}while((jauEksiste(saraksts, koPiev) == true) ||
					!koPiev.matches("[\\p{L} ]+$") && kurPiev < 1 || kurPiev > saraksts.size());
			saraksts.add(kurPiev-1, koPiev);
		break;
		case "6":
			do {
				koNon = JOptionPane.showInputDialog("Kuru produktu noņemt?");					
				
			}while(!koNon.matches("[\\p{L} ]+$") || !jauEksiste(saraksts, koNon)) ;
			if(saraksts.remove(koNon.toLowerCase())) JOptionPane.showMessageDialog(null, "Produkts noņemts", "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
			else JOptionPane.showMessageDialog(null, "Produkts nav noņemts", "Paziņojums", JOptionPane.WARNING_MESSAGE);
		break;
		case "7":
			do {
			kurNon = Integer.parseInt(JOptionPane.showInputDialog("Kuras pozīcijas elementu noņemt?"));
			}while(kurNon < 1 || kurNon > saraksts.size());
			saraksts.remove(kurNon-1);
		break;
		case "8":
			saraksts.removeFirst();
		break;
		case "9":
			saraksts.removeLast();
		break;
		case "10":
			
		break;
		case "11":
			if(saraksts.size()>0) {
				String atb = (String) JOptionPane.showInputDialog(null, "Kārtot produktus pēc alfabēta augoši?", "Izvēle", JOptionPane.QUESTION_MESSAGE,
						null, atbilde, atbilde[0]);
				if(atb != null) {
					if(atb.equals("Jā")) {
						saraksts.sort(null);
						JOptionPane.showMessageDialog(null, "Produkti sakārtoti augoši", "Kārtošana", JOptionPane.INFORMATION_MESSAGE);
					} else {
						saraksts.sort(Collections.reverseOrder());
						JOptionPane.showMessageDialog(null, "Produkti sakārtoti dilstoši", "Kārtošana", JOptionPane.INFORMATION_MESSAGE);

					}
				}
				
				
			}else {
				JOptionPane.showMessageDialog(null, "Sarakstā nav neviens produkts!", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
				break;
			}
			break;
		case "12":
			if(saraksts.size()>0) {

			String ties = (String) JOptionPane.showInputDialog(null, "Vai tieši gribāt dzēst visu sarakstu?~", "Izvēle", JOptionPane.QUESTION_MESSAGE,
					null, atbilde, atbilde[0]);
			if(ties == null || ties == "Nē") break; 
			else{ saraksts.clear();
			JOptionPane.showMessageDialog(null, "Viss saraksts attīrīts!", "Ziņojums", JOptionPane.INFORMATION_MESSAGE); }
			}else {
				JOptionPane.showMessageDialog(null, "Sarakstā nav neviens produkts!", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
				break;
			}
		break;
		case "0":
			JOptionPane.showMessageDialog(null, "Programma apturēta!", "Paziņojums", JOptionPane.PLAIN_MESSAGE);
		break;
		default: JOptionPane.showMessageDialog(null, "Šāda darbība nepastāv", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
		}
	}

}
