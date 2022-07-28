package Home;

public class WordGenerator {
    private final KeywordDataMaker keywordDataMaker = new KeywordDataMaker();

    public String [] wordCollectionMaker(int[] amount, String typeOfCurrency){
        keywordDataMaker.fillAllMaps();
        String [] WordsCollected = new String[6];
        int numPos = 0;
        int dozen_thousands = 0;
        int dozenEnd = 0;
        for (int digClass: amount){
            boolean isDozenTrue = digClass % 10 == 0;
            if (numPos==0)   dozen_thousands = digClass;
            if (numPos==3)   dozenEnd = digClass % 10;
            switch (numPos){
                case 0, 2 ->  WordsCollected[numPos] = keywordDataMaker.getHundredsThousandsMap().get(digClass);
                case 1 ->  WordsCollected[numPos] = (digClass == 0 & dozen_thousands != 0)? "тысяч":
                        (digClass < 20 )? keywordDataMaker.getThousandMap().get(digClass):
                                (isDozenTrue)? keywordDataMaker.getDozenMap().get(digClass/10) + " тысяч":
                                        (digClass% 10 == 1)?
                                                keywordDataMaker.getDozenMap().get(digClass/10) + " " +
                                                        keywordDataMaker.getThousandMap().get(digClass % 10) + " тысяча":
                                                (digClass% 10 == 2)?
                                                        keywordDataMaker.getDozenMap().get(digClass/10) + " " +
                                                                keywordDataMaker.getUnitsMap().get(digClass % 10) + " тысячи":
                                                        keywordDataMaker.getDozenMap().get(digClass/10) + " " +
                                                                keywordDataMaker.getUnitsMap().get(digClass % 10) + " тысяч";
                case 3 ->  WordsCollected[numPos] =(digClass < 20)? keywordDataMaker.getUnitsMap().get(digClass):
                        (isDozenTrue)? keywordDataMaker.getDozenMap().get(digClass/10):
                                keywordDataMaker.getDozenMap().get(digClass/10) + " " +
                                        keywordDataMaker.getUnitsMap().get(digClass % 10);
            }
            numPos++;
        }
        //Выбор типв валюты
        if (typeOfCurrency.equals(Currencies.USD.name())) {
            if (dozenEnd == 0 | dozenEnd > 4) WordsCollected[4] = Currencies.USD.getNameCurrency(2);
            if (dozenEnd == 1) WordsCollected[4]=Currencies.USD.getNameCurrency(0);
            if (dozenEnd > 1 & dozenEnd < 5) WordsCollected[4] =Currencies.USD.getNameCurrency(1);
        }
        if (typeOfCurrency.equals(Currencies.RUB.name())) {
            if (dozenEnd == 0 | dozenEnd > 4) WordsCollected[4] =Currencies.RUB.getNameCurrency(2);
            if (dozenEnd == 1) WordsCollected[4]=Currencies.RUB.getNameCurrency(0);
            if (dozenEnd > 1 & dozenEnd < 5) WordsCollected[4] =Currencies.RUB.getNameCurrency(1);
        }
        return WordsCollected;
    }
}