package no.hvl.dat102.oving6;

import java.util.*;

public class Oppgave1 {

    // Tid: 6.8 + 12.7 + 6.6 + 6.6 + 6.5 + 9 + 6.6 + 6.6 + 6.6 + 9 / 10 = 7
    //sorterer ett tall av gangen.
    public static void Sorter(int[] tab) {
        int j, k;
        for (int i = 1; i < tab.length; i++) {
            j = i - 1;
            k = tab[i];

            while (j >= 0 && tab[j] > k) {
                tab[j + 1] = tab[j];
                j--;
            }
            tab[j + 1] = k;
        }
    }

    public static <T extends Comparable<? super T>> void sorteringVedInssetting(T[] a) {
        sorteringVedInssetting(a, 0, a.length-1);
    }
    // Sorterer ein del av tabellen, start ... slutt (begge grensene er med)

    //oppgave 1A.
    public static <T extends Comparable<? super T>> void sorteringVedInssetting(T[] tab, int start, int slutt) {
        int p = 0;

        for (int i = 1; i < tab.length; i++) {

            if (tab[p].compareTo(tab[i]) > 0) {
                p = i;
            }
        }
        T pos = tab[0];
        tab[0] = tab[p];
        tab[p] = pos;

        for (int i = start + 1; i <= slutt; i++) {

            T temp = tab[i];
            int j = i - 1;
            boolean ferdig = false;
            while (!ferdig) {
                if (temp.compareTo(tab[j]) < 0) {
                    tab[j + 1] = tab[j];
                    j--;
                } else {
                    ferdig = true;
                }
            }
            tab[j + 1] = temp;
        }
    }

    public static <T extends Comparable<? super T>> void sorteringVedInssetting2(T[] a) {
        sorteringVedInssetting(a, 0, a.length-1);
    }

    // oppgave 1 b.
    public static <T extends Comparable<? super T>> void sorteringVedInssetting2(T[] tab, int start, int slutt) {


        for (int i = start + 1; i <= slutt - 1; i += 2) {
            T temp = tab[i];
            T temp2 = tab[i + 1];
            int j = i - 1;
            boolean ferdig = false;
            boolean ferdig2 = false;

            if (temp.compareTo(temp2) > 0) {
                temp = tab[i + 1];
                temp2 = tab[i];
            }

            while (!ferdig) {
                if (temp2.compareTo(tab[j]) < 0) {
                    tab[j + 2] = tab[j];
                    j--;
                } else {
                    ferdig = true;
                }
            }
            tab[j + 2] = temp2;

            while (!ferdig2) {
                if (temp.compareTo(tab[j]) < 0) {
                    tab[j + 1] = tab[j];
                    j--;
                } else {
                    ferdig2 = true;
                }
            }
            tab[j + 1] = temp;
        }
    }

    // setter inn random tall i en tabell.
    public static void RandomTab(Integer[] tab) {
        Random tilfeldig = new Random();

        for (int i = 0; i < tab.length; i++) {
            tab[i] = tilfeldig.nextInt(100);
        }
    }


}
