import java.util.Random;
import java.util.Scanner;

/**
 * Created by Sergiu on 5/9/2017.
 */
public class Main {
    public static void main(String argv[]){
        Scanner in = new Scanner(System.in);
        System.out.print("Numarul de linii:");
        Integer nLines = new Integer(in.nextInt());
        System.out.print("Numarul de coloane:");
        Integer nColumns = new Integer(in.nextInt());
        Game game = GameGenerator.generate(nLines,nColumns,new Random());
        Boolean mutat;
        System.out.println("Configuratia initiala este: ");
        game.printTable();

        if(game.getCurrentXORValue().equals(0)){
            System.out.println("Negrul are strategie sigura de castig");
        }
        else{
            System.out.println("Negrul nu are strategie sigura de castig");
        }

        while(!game.isFinal()){
            MoveSpecification moveSpecification = NimSolver.nextStep(game.getSpaces(),game.getCurrentXORValue());
            Integer line = moveSpecification.getLine();
            Integer column = moveSpecification.getSteps() + game.getBlackPositions().get(line);
            System.out.println("Negrul a mutat. Noua configuratie este: ");
            try {
                game.moveBlack(line,column).printTable();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(game.isFinal()){
                System.out.println("Negrul a castigat");
                return;
            }
            mutat = false;
            while(!mutat){
                System.out.print("Introdu linia: ");
                line = new Integer(in.nextInt());
                System.out.print("Introdu coloana: ");
                column =new Integer(in.nextInt());
                try {
                    game.moveWhite(line,column);
                    System.out.println("Albul a mutat. Noua configuratie este:");
                    game.printTable();
                    mutat = true;
                } catch (Exception e) {
                    System.out.println("Nu ai mutat o pozitie valida");
                }
            }
            if(game.isFinal()){
                System.out.println("Albul a castigat");
                return;
            }
        }
    }
}
