package no.hvl.dat102.oving6;

import java.util.Arrays;
import java.util.Random;



public class Oppgave2 {

    // Utvalgssortering
    public static <T extends Comparable<T>> void utvalgsSort(T[] data) {
        int minstePos;
        for (int i = 0; i < data.length - 1; i++) {
            minstePos = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j].compareTo(data[minstePos]) < 0) {
                    minstePos = j;
                }
            }
            T tmp = data[i];
            data[i] = data[minstePos];
            data[minstePos] = tmp;
        }
    }

    // Sortering ved innsetting
    public static <T extends Comparable<T>> void sortVedInnsetting(T[] data) {
        for (int i = 1; i < data.length; i++) {
            T nokkel = data[i];
            int p = i;

            while (p > 0 && nokkel.compareTo(data[p - 1]) < 0) {
                data[p] = data[p - 1];
                p--;
            }
            data[p] = nokkel;
        }
    }

    private static <T> void bytt(T[] tab, int i, int j) {
        T tmp = tab[i];
        tab[i] = tab[j];
        tab[j] = tmp;
    }

    private static <T extends Comparable<T>> int finnPartisjon(T[] data, int min, int maks) {
        T temp, p;
        int midten = (min + maks) / 2;
        p = data[midten];
        bytt(data, midten, min);

        int venstre = min + 1;
        int hoyre = maks;
        while (venstre < hoyre) {

            while (venstre < hoyre && data[venstre].compareTo(p) <= 0) {
                venstre++;
            }
            while (data[hoyre].compareTo(p) > 0) {
                hoyre--;
            }
            if (venstre < hoyre) {
                bytt(data, venstre, hoyre);
            }
        }
        bytt(data, min, hoyre);
        return hoyre;
    }

    // Kvikksortering
    public static <T extends Comparable<T>> void kvikkSort(T [] data, int min, int maks) {
        if (min < maks) {
            int posPivot = finnPartisjon(data, min, maks);
            kvikkSort(data, min, posPivot - 1);
            kvikkSort(data, posPivot + 1, maks);
        }
    }

    private static <T extends Comparable<T>> void flette(T[] tab, int forste, int midten, int siste) {

        int strl = siste - forste + 1;
        T[] hjelpeTab = (T[]) (new Comparable[strl]);

        int forsteV = forste;
        int sisteV = midten;
        int forsteH = midten + 1;
        int sisteH = siste;

        int h = 0;

        while (forsteV <= sisteV && forsteH <= sisteH) {
            if (tab[forsteV].compareTo(tab[forsteH]) <= 0) {
                hjelpeTab[h] = tab[forsteV];
                forsteV++;
            } else {
                hjelpeTab[h] = tab[forsteH];
                forsteH++;
            }
            h++;
        }

        while (forsteV <= sisteV) {
            hjelpeTab[h] = tab[forsteV];
            forsteV++;
            h++;
        }

        while (forsteH <= sisteH) {
            hjelpeTab[h] = tab[forsteH];
            forsteH++;
            h++;
        }

        h = 0;
        for (int indeks = forste; indeks <= siste; indeks++) {
            tab[indeks] = hjelpeTab[h];
            h++;
        }
    }

    // Flettesortering
    public static <T extends Comparable<T>> void fletteSort(T[] tab, int forste, int siste) {
        if (forste < siste) {
            int midten = (forste + siste) / 2;
            fletteSort(tab, forste, midten);
            fletteSort(tab, midten + 1, siste);
            flette(tab, forste, midten, siste);
        }
    }


    public static void main(String[] args) {
       //a)
        Random tilfeldig = new Random();
        int n = 32000;
        int antal = 10;


        Integer[][] a = new Integer[antal][n];
        Integer [] b = new Integer [n];

        for (int i = 0; i < antal; i++){
            for (int j = 0; j < n; j++){
                a[i][j] = tilfeldig.nextInt();
                //System.out.println(a[j][i]);
            }
        }
        double startTid = System.nanoTime();

        for (int i = 0; i < antal; i++){
             kvikkSort(a[i], 0, a[i].length - 1);
            //utvalgsSort(a[i]);
            //sortVedInnsetting(a[i]);
            //fletteSort(a[i], 0, a[i].length - 1);
        }
        double sluttTid = System.nanoTime();

        double totalTid = sluttTid - startTid;

        double totalTidISek = totalTid / 1_000_000_000;

        // Skriver ut antall sekunder det tar for å kjøre programmet
        System.out.println(String.format("%.2f", totalTidISek) + " Sekunder");



        }
    }
