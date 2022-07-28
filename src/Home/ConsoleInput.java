package Home;

import java.util.Scanner;

public class ConsoleInput {
    private Scanner scanner = new Scanner(System.in);

    protected String dateInput(){
        Scanner scanner = new Scanner(System.in);
        String typedData = scanner.nextLine();
        return typedData;
    }
    static void print(String string){
        System.out.println(string);
    }


}