package Home;

import Test.*;
public class Main {

    public static void main(String[] args) {

        TransFormer transformer = new TransFormer();
        WordGenerator wordGenerator = new WordGenerator();
        ConsoleInput consoleInput = new ConsoleInput();
        TestMashine testMashine = new TestMashine();

        ConsoleInput.print("Введите целое число до миллиона и тип варюты USD или RUB");
        String inputValue = consoleInput.dateInput();
        String[] InputedStrings = transformer.AmountSegmentation(inputValue);
        int[] digAmount = transformer.SharedAmountOnClass(InputedStrings[0]);
        String typeOfCurrency = InputedStrings[1];

        String [] Words = wordGenerator.wordCollectionMaker(digAmount, typeOfCurrency);
        String phrase = testMashine.clueFinalPhrase(Words);

        ConsoleInput.print(phrase);

    }
}