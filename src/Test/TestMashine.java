package Test;
import Home.*;


public class TestMashine {
    private final TransFormer transformer = new TransFormer();
    private final WordGenerator wordGenerator = new WordGenerator();
    private final ConsoleInput consoleInput = new ConsoleInput();

    protected void check(String test, String answer){
        String[] SharedInput = transformer.AmountSegmentation(test);
        int[] digAmount = transformer.SharedAmountOnClass(SharedInput[0]);
        String [] TestWordAnswer = wordGenerator.wordCollectionMaker(digAmount, SharedInput[1]);
        String finalAnswer = clueFinalPhrase(TestWordAnswer);

        System.out.println("Ввод: " + answer);
        System.out.println("Вывод: " + finalAnswer );
        if (finalAnswer.equals(answer)) System.out.println("Да");
        else System.out.println("Нет");
    }
    public   String clueFinalPhrase( String [] Words){
        StringBuilder phrase = new StringBuilder();
        for (String word: Words){
            if (word != null) phrase.append(word).append(" ");
        }
        return phrase.toString();
    }


}