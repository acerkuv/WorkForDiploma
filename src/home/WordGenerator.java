package home;

public class WordGenerator {
    private final KeywordDataMaker keywordDataMaker = new KeywordDataMaker();
    private String [] wordsCollected = new String[6];

    public String[] wordCollectionMaker(int[] amount, String typeOfCurrency){
        keywordDataMaker.fillAllMaps();

        int numPos = 0;
        int dozenThousands = 0;
        int dozenEnd = 0;
        for (int digClass: amount){
            boolean isDozenTrue = digClass % 10 == 0;
            if (numPos==0)   dozenThousands = digClass;
            if (numPos==3)   dozenEnd = digClass % 10;
            switch (numPos){
                case 0, 2 ->  wordsCollected[numPos] = keywordDataMaker.getHundredsThousandsMap().get(digClass);
                case 1 ->  wordsCollected[numPos] = (digClass == 0 && dozenThousands != 0)? "тысяч":
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
                 case 3 -> wordsCollected[numPos] = wordForSegmentation(digClass);
//                case 3 ->  wordsCollected[numPos] =(digClass < 20)? keywordDataMaker.getUnitsMap().get(digClass):
//                        (isDozenTrue)? keywordDataMaker.getDozenMap().get(digClass/10):
//                                keywordDataMaker.getDozenMap().get(digClass/10) + " " +
//                                        keywordDataMaker.getUnitsMap().get(digClass % 10);

            }
            numPos++;
        }
        //Выбор типв валюты
        if (typeOfCurrency.equals(Currencies.USD.name())) {
            wordsCollected[4]= Currencies.USD.getNameCurrency(dozenEnd);
        }
        if (typeOfCurrency.equals(Currencies.RUB.name())) {
            wordsCollected[4]= Currencies.RUB.getNameCurrency(dozenEnd);
        }
        return wordsCollected;
    }
    // if less 20 then
    protected String wordForSegmentation (int digClass){
        StringBuilder digToWord = new StringBuilder();
        boolean isNotZero = digClass % 10 != 0 && digClass/10 != 0;
        if(!isNotZero){
            return "";
        }
        else if(digClass < 20){
            digToWord.append(keywordDataMaker.getUnitsMap().get(digClass));
           return  String.valueOf(digToWord);
        } else if (digClass > 19 && digClass % 10 == 0) {
            digToWord.append(keywordDataMaker.getDozenMap().get(digClass / 10));
            return String.valueOf(digToWord);
        }else {
            digToWord.append(keywordDataMaker.getDozenMap().get(digClass / 10)).append(" ").append(keywordDataMaker.getUnitsMap().get(digClass % 10));
            return String.valueOf(digToWord);
        }

    }
}