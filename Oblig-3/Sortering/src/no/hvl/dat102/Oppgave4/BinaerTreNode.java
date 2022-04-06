package no.hvl.dat102.Oppgave4;


public class BinaerTreNode<T> {
    private T element;
    private BinaerTreNode<T> venstre;
    private BinaerTreNode<T> hogre;

    BinaerTreNode(T el) {
        element = el;
        venstre = null;
        hogre = null;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public BinaerTreNode<T> getVenstre() {
        return venstre;
    }

    public void setVenstre(BinaerTreNode<T> venstre) {
        this.venstre = venstre;
    }

    public BinaerTreNode<T> getHogre() {
        return hogre;
    }

    public void setHogre(BinaerTreNode<T> hogre) {
        this.hogre = hogre;
    }

    @Override
    public String toString() {
        return "BinaerTreNode{" +
                "element=" + element +
                ", venstre=" + venstre +
                ", hogre=" + hogre +
                '}';
    }
}
