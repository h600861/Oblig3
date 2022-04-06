package no.hvl.dat102.Oppgave4;
import java.util.Iterator;
import java.util.*;

public class BS_Tre<T extends Comparable<? super T>> implements Soektreinterface<T> {
    private BinaerTreNode<T> rot;

    public BS_Tre() {
        rot = null;
    }

    public BS_Tre(T element) {
        rot = new BinaerTreNode<T>(element);
    }

    /**
     * S¯ker etter et gitt element i treet.
     *
     * @param element elementet vi s¯ker etter.
     * @return true om elementet finst, false elles.
     */
    public boolean inneholder(T element) {
        return false;
    }

    /**
     * Henter et element i treet.
     *
     * @param element elementet vi leiter etter.
     * @return Elementet dersom det finst, elles null.
     */
    public T finn(T element) {
        return finn(element, rot);
    }

    private T finn(T element, BinaerTreNode<T> p) {
        T svar = null;

        // p == null  -> tomt tre som er basistille og svar blir null
        if (p != null) {
            int sml = element.compareTo(p.getElement());
            if (sml == 0) {
                svar = p.getElement();
            } else if (sml < 0) {
                svar = finn(element, p.getVenstre());
            } else {
                svar = finn(element, p.getHogre());
            }
        }
        return svar;
    }
    /**
     * Legg eit element til treet dersom det ikkje finst frÂ f¯r. Elles etstattar
     * blir det gamle elementet erstatta med det nye.
     *
     * @param nyElement elementet som skal leggast til
     * @return null om elementet ikkje finst frÂ f¯r. Elles det element som var i
     *         treet frÂ f¯r.
     */
    public T leggTil(T nyElement) {

        return leggTil(rot,nyElement).getElement();

    }

    private BinaerTreNode<T> leggTil(BinaerTreNode<T> p, T element){
        if (p == null) {
            return new BinaerTreNode<T>(element);
        } else {
            if (element.compareTo(p.getElement()) < 0) {
                p.setVenstre(leggTil(p.getVenstre(), element));
            } else {
                BinaerTreNode<T> q = leggTil(p.getHogre(), element);
                p.setHogre(q);
            }
        }
        return p;
    }
    /**
     * Fjernar eit element frÂ treet.
     *
     * @param element elementet som skal fjernast.
     * @return elementet som vart fjerna eller null om det ikkje finst.
     */
    public T fjern(T element) {
        return null;
    }

    /**
     * Lagar ein iterator som gÂr gjennom alle element i treet i inorden.
     *
     * @return ein iterator som elementa i sortert rekkef¯lge.
     */
    public Iterator<T> getInordenIterator() {
        return null;
    }

    public int Hoyde(){
        return Hoyde(rot)-1;
    }

    private int Hoyde(BinaerTreNode<T> a){

        int hoydeV=0, hoydeH=0,hoydeMax=0;
        if(a == null){
            return -1;
        }else
        {
            if(a.getVenstre() != null) {
                hoydeV=Hoyde(a.getVenstre());
            }

            if(a.getHogre() != null) {
                hoydeH=Hoyde(a.getHogre());
            }
        }

        if(hoydeV>hoydeH){
            hoydeMax=hoydeV;
        }else
            hoydeMax=hoydeH;

        return hoydeMax+1;
    }

    public T rotToString(){
        return rot.getElement();
    }
    public static int heightComplete (int N){
        return (int)Math.ceil(Math.log(N+1)/ Math.log(2)) - 1;
    }
}
