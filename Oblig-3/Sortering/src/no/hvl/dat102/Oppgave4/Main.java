package no.hvl.dat102.Oppgave4;

public class Main {
    public static void main(String[] args) {

        for(int i =0; i<5; i++){
            BS_Tre a = new BS_Tre(Math.random());
            for(int j =0; j<1023;j++){
                a.leggTil(Math.random());
            }
            System.out.println(a.Hoyde());
        }

        // Oppgave 4b
        int totalHoyde = 0;
        int antNoder = 0;
        int minHoyde = 0;
        int maksHoyde = 0;
        BS_Tre tre1 = new BS_Tre<>();

        for(int i = 0; i < 100; i++) {
        	 tre1 = new BS_Tre<>(Math.random());

        	for(int j = 0; j < 1023; j++) {
        		tre1.leggTil(Math.random());
        		antNoder++;
        	}
        	totalHoyde += tre1.Hoyde();
        	if(maksHoyde == 0 && minHoyde == 0) {
        		maksHoyde = tre1.Hoyde();
        		minHoyde = tre1.Hoyde();
        	} else if(maksHoyde < tre1.Hoyde()) {
        		maksHoyde = tre1.Hoyde();
      	} else if(minHoyde > tre1.Hoyde()) {
      		minHoyde = tre1.Hoyde();
        	}
       }

        int gjennomsnitt = totalHoyde / 100;

        
        System.out.println("Totalt antall noder: " + antNoder);
        System.out.println("Minimal teoretisk høyde for n noder er: " + tre1.heightComplete(1023));
       System.out.println("Maksimal teoretisk høyde er n, som er lik 1023");
        System.out.println("Største målte høyde: " + maksHoyde);
       System.out.println("Minste målte høyde: " + minHoyde);






    }
}
