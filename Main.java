import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

class Main {

  private static ArrayList<Double> storage = new ArrayList<Double>();
    public static ArrayList<Double> getStorage() {
        return storage;
    }

  public static void question() {
    Scanner scanner = new Scanner(System.in);

    double inputDouble = scanner.nextDouble();
    storage.add(inputDouble);
    System.out.println("Was that the final piece of information? (Y/N)");
    String inputStringy = scanner.next();
    if (inputStringy.equals("Y")) {
      System.out.println("\nThe current dictionary contains " + storage);
    }
    else if (inputStringy.equals("N")) {
      System.out.println("Enter the probability of the next piece of information:");
      question();
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
      ArrayList<Double> storage = new ArrayList<Double>();

    System.out.println("\n\nWelcome to the Wiedner Coding Encoder!\n\nPlease enter the probability of the first piece of information:");
    
    question();

    ArrayList<Double> tempo = new ArrayList<Double>();
    tempo = getStorage();
    Collections.sort(tempo);
    Collections.reverse(tempo);

    System.out.println("\nThe sorted probabilities are: " + tempo + "\n\n");
    System.out.println("The codewords are as follows: \n");
    System.out.println("Probability " + tempo.get(0) + " has the codeword:\n0");
    for (int n = 1; n < tempo.size() - 1; n++) {
      System.out.println("Probability " + tempo.get(n) + " has the codeword:");
      for (int z = 0; z < n; z++) {
        System.out.print(1);
      }
      System.out.print("0\n");
    }
    System.out.println("Probability " + tempo.get(tempo.size() - 1) + " has the codeword:");
    for (int h = 1; h < tempo.size(); h++) {
      System.out.print(1);
    }

    System.out.println("\n\nThe information per bit is: ");
    double sum = 0;
    for (int q = 0; q < tempo.size() - 1; q++) {
      sum += (tempo.get(q) * (((Math.log(tempo.get(q)) / Math.log(2)) * -1) / (q + 1)));
    }
    sum += (tempo.get(tempo.size() - 1) * (((Math.log(tempo.get(tempo.size() - 1)) / Math.log(2)) * -1) / (tempo.size() - 1)));
    System.out.println(sum);

    System.out.println("\nThe average Bits Per Character is:");
    double bpc = 0;
    for (int o = 1; o < tempo.size(); o++) {
      bpc += o;
    }
    System.out.println((bpc + tempo.size() - 1) / tempo.size());
  }
}