package home;
import Test.*;

public class Main {

    public static void main(String[] args) {

        TransFormer transformer = new TransFormer();
        WordGenerator wordGenerator = new WordGenerator();
        ConsoleInput consoleInput = new ConsoleInput();
        TestMashine testMashine = new TestMashine();
        WordGen2 wordGen2 = new WordGen2();

        ConsoleInput.print("Введите целое число до миллиона и тип варюты USD или RUB");
        String inputValue = consoleInput.dateInput();
        String[] InputedStrings = transformer.AmountSegmentation(inputValue);
        int[] digAmount = transformer.SharedAmountOnClass(InputedStrings[0]);
        String typeOfCurrency = InputedStrings[1];

//        String [] Words = wo.wordCollectionMaker(digAmount, typeOfCurrency);
        String [] Words = wordGen2.WordMaker(digAmount, typeOfCurrency);

        String phrase = testMashine.clueFinalPhrase(Words);

        ConsoleInput.print(phrase);

    }
}