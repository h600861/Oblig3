package no.hvl.dat102.oving6;

import static no.hvl.dat102.oving6.Oppgave1.RandomTab;
import static no.hvl.dat102.oving6.Oppgave1.*;

public class mainOppg1 {
    public static void main(String[] args) {
        Integer tab[] = new Integer[100_000];
        RandomTab(tab);

        double startTid = System.nanoTime();
        sorteringVedInssetting2(tab);
        //sorteringVedInssetting2(tab,0, tab.length-1);

        double sluttTid = System.nanoTime();

        double totalTid = sluttTid - startTid;

        double totalTidISek = totalTid / 1_000_000_000;

        System.out.println(String.format("%.2f", totalTidISek) + " Sekunder");

        /*for(int i =0; i<tab.length;i++) {
            System.out.print(tab[i] + " ");
        }*/
    }
}
