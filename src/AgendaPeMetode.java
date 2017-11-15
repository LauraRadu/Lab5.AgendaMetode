import java.util.Scanner;

public class AgendaPeMetode {

    static String[] agendaDeNume = new String[5];
    static int pozitie = 0;

    public static void afisareMeniu() {
        System.out.println("1> Afisare");
        System.out.println("2> Adaugare");
        System.out.println("3> Stergere");
        System.out.println("4> Cautare simpla");
        System.out.println("5> Modificare");
        System.out.println("0> Exit");

    }

    public static String citireNume(String label) {
        System.out.print(label);
        Scanner scan = new Scanner(System.in);
        String nume = scan.nextLine();
        return nume;
    }

    public static void main(String[] args) {
        int optiune = -1;
        do {
            afisareMeniu();
            Scanner sc = new Scanner(System.in);
            optiune = sc.nextInt();
            switch (optiune) {
                case 1: {
                    afisareAgenda();
                    break;
                }

                case 2: {
                    adaugareAgenda();
                    break;
                }

                case 3: {
                    stergere();
                    break;
                }

                case 4: {
                    cautareSimpla();
                    break;
                }

                case 5: {
                    modificare();
                    break;
                }
            }
        }
        while (optiune != 0);
    }


    public static void afisareAgenda() {
        for (int i = 0; i < agendaDeNume.length; i++) {
            if (agendaDeNume[i] != null) {
                System.out.println(agendaDeNume[i]);
            }

        }
    }

    public static void adaugareAgenda() {
        if (pozitie < agendaDeNume.length) {
            String nume = citireNume("Introduceti numele de adaugat:");
            agendaDeNume[pozitie] = nume;
            pozitie++;
        } else {
            // totusi hai sa cautam in goluri , ugly code !!!!
//            for (int i = 0; i < agendaDeNume.length; i++) {
//                if (agendaDeNume[i] == null) {
//                    String nume = citireNume("Introduceti numele de adaugat:");
//                    agendaDeNume[i] = nume;
//                    break;
//                }
//            }

            System.out.println("agenda plina, ia alta mai mare");
        }

        System.out.println();
    }

//    //aici putem introduce metoda de cautareSimpla pentru a sterge toate persoanele cu acelasi nume din agenda
//    public static int cautare(String nume) { //se opreste la primul gasit
//        int found = -1;
//        for (int i = 0; i < agendaDeNume.length; i++) {
//            if (nume.equalsIgnoreCase(agendaDeNume[i])) {
//                agendaDeNume[i] = null;
//                System.out.println("am ras-o pe:" + nume);
//                found = i;
//                break;
//            }
//        }
//        return found;
//    }

    //cautare dupa nume. Cauta toate numele din agenda care contin numele introdus.
    public static boolean cautareSimpla() {
        String nume = citireNume("Introduceti numele cautat: ");
        boolean found = false;
        for (int i = 0; i < agendaDeNume.length; i++) {
            if (agendaDeNume[i] != null) {      //eroare fara acest if
                if (agendaDeNume[i].toLowerCase().contains(nume.toLowerCase())) {            //nume.equalsIgnoreCase(agendaDeNume[i])) {
                    found = true;
                    System.out.println(agendaDeNume[i]);
                }
            }
        }
        if (found == false) {
            System.out.println("Nu aveti acest nume in agenda.");
        }

        return found;
    }

    public static void stergere() {
        boolean found = cautareSimpla();
        boolean foundTwo = false;

        //se poate alege din mai multe persoane cu acelasi nume pentru a sterge una anume
        if (found) {
            String numeDeSters = citireNume("Introduceti numele exact ca in Agenda pentru stergere:");
            for (int i = 0; i < agendaDeNume.length; i++) {
                if (numeDeSters.equals(agendaDeNume[i])) {
                    System.out.println(agendaDeNume[i] + " a fost eliminata din agenda.");
                    agendaDeNume[i] = null;
                    foundTwo = true;

                    //mutarea contactelor cu o pozitie mai sus la fiecare stergere, pentru a face loc in agenda pentru alte contacte
                    if (i < agendaDeNume.length - 1) {
                        for (int j = i; j < agendaDeNume.length - 1; j++) {
                            agendaDeNume[j] = agendaDeNume[j + 1];
                            agendaDeNume[j + 1] = null;
                        }
                    }
                    pozitie--;

                    break;
                }
            }

            if (foundTwo == false) {
                System.out.println("Nu aveti acesta persoana in agenda.");
            }

        }
    }

    public static void modificare() {
        boolean found = cautareSimpla();
        boolean foundTwo = false;

        //se poate alege din mai multe persoane cu acelasi nume pentru a modifica una anume
        if (found) {
            String numeDeModificat = citireNume("Introduceti numele exact ca in Agenda pentru modificare:");
            for (int i = 0; i < agendaDeNume.length; i++) {
                if (numeDeModificat.equals(agendaDeNume[i])) {
                    String numeNou = citireNume("Introduceti numele nou: ");
                    agendaDeNume[i] = numeNou;
                    foundTwo = true;

                    break;
                }
            }

            if (foundTwo == false) {
                System.out.println("Nu aveti acesta persoana in agenda.");
            }
        }
    }
}