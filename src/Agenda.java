import java.util.Scanner;

public class Agenda {

    public static void main(String[] args) {

        // strucutra de date

        String[] agendaDeNume = new String[3];
        int pozitie = 0;


        //meniul si operatiile

        int optiune = -1;
        do {
            System.out.println("1> Afisare");
            System.out.println("2> Adaugare");
            System.out.println("3> Stergere");

            System.out.println("0> Exit");

            Scanner sc = new Scanner(System.in);

            optiune = sc.nextInt();

            switch (optiune) {
                case 1: {
                    // afisare

                    for (int i = 0; i < agendaDeNume.length; i++) {
                        if (agendaDeNume[i] != null) {
                            System.out.println(agendaDeNume[i]);
                        }

                    }
                    break;

                }


                case 2: {
                    // adaugare
                    if (pozitie < agendaDeNume.length) {
                        System.out.print("Numele:");
                        Scanner scan = new Scanner(System.in);
                        String nume = scan.nextLine();
                        agendaDeNume[pozitie] = nume;
                        pozitie++;
                    } else {
                        // totusi hai sa cautam in goluri , ugly code !!!!
                        for (int i = 0; i < agendaDeNume.length; i++) {
                            if (agendaDeNume[i] == null) {
                                System.out.print("Numele:");
                                Scanner scan = new Scanner(System.in);
                                String nume = scan.nextLine();
                                agendaDeNume[i] = nume;
                                break;
                            }
                        }


                        System.out.println("agenda plina, ia alta mai mare");
                    }

                    System.out.println();
                    break;

                }

                case 3: {
                    //cautare
                    //daca e gasit il rad
                    System.out.print("Numele de sters:");
                    Scanner scan = new Scanner(System.in);
                    String nume = scan.nextLine();

                    boolean found = false;

                    for (int i = 0; i < agendaDeNume.length; i++) {
                        if (nume.equalsIgnoreCase(agendaDeNume[i])) {
                            agendaDeNume[i] = null;
                            System.out.println("am ras-o pe:" + nume);
                            found = true;
                        }
                    }
                    if (!found)
                        System.out.println("nu o ai in agenda");

                    break;
                }
            }

        }
        while (optiune != 0);


    }
}