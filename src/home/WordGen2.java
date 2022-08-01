package home;

import java.util.Arrays;

public class WordGen2 {
    private final KeywordDataMaker keywordDataMaker = new KeywordDataMaker();
    private String [] WordsCollected = new String[6];

    public String [] WordMaker(int[] amount, String typeOfCurrency){
        keywordDataMaker.fillAllMaps();
        int segmentPosition = 0;
        int dozenEnd = 0;
        for (int digAmount: amount){
            if (segmentPosition == 3)   dozenEnd = digAmount % 10;
            switch (segmentPosition){
                case 0 -> WordsCollected[segmentPosition] = selectRightWord(digAmount, 0);
                case 1 -> WordsCollected[segmentPosition] = selectRightWord(digAmount, 1);
                case 2 -> WordsCollected[segmentPosition] = selectRightWord(digAmount, 2);
                case 3 -> WordsCollected[segmentPosition] = selectRightWord(digAmount, 3);
            }
            segmentPosition += 1;
        }
        //Выбор типв валюты

        if (typeOfCurrency.equals(Currencies.USD.name())) {
            WordsCollected[4]= Currencies.USD.getNameCurrency(dozenEnd);
        }
        if (typeOfCurrency.equals(Currencies.RUB.name())) {
            WordsCollected[4]= Currencies.RUB.getNameCurrency(dozenEnd);
        }
        System.out.println(Arrays.toString(WordsCollected));
        return WordsCollected;
    }
    private String selectRightWord(int dig, int digSegment){
        StringBuilder resultWords = new StringBuilder();
        if (digSegment == 0 || digSegment == 2) return keywordDataMaker.getHundredsThousandsMap().get(dig);
        else if (digSegment == 1) {
            if (dig == 0) {
                return "тысяч";
            } else if (dig==1) {
                resultWords.append(keywordDataMaker.getFirstThousandsTranslator().get(dig)).append(" ");
                resultWords.append(keywordDataMaker.getEndOfThousandsMap().get(dig));
                return String.valueOf(resultWords);
            }
            else if (dig == 2) {
                resultWords.append(keywordDataMaker.getFirstThousandsTranslator().get(dig)).append(" ");
                resultWords.append(keywordDataMaker.getEndOfThousandsMap().get(dig));
                return String.valueOf(resultWords);
            }

              else  if (dig > 2 || dig < 5 ) {
                resultWords.append(dozenDecoder(dig)).append(" ");
                resultWords.append(keywordDataMaker.getEndOfThousandsMap().get(2));
                return String.valueOf(resultWords);
            }

            else {
                String dozenRez = dozenDecoder(dig) + " тысяч";
                return dozenRez;
            }
        }
        else{
            return dozenDecoder(dig);
            }
        }

    private String dozenDecoder(int dozen){
        StringBuilder stringBuilder = new StringBuilder();
        int endOfDozen = dozen % 10;
        int beginOfDozen = dozen / 10;
        if (endOfDozen == 0 & beginOfDozen == 0) return "";
        else if (dozen < 20) return keywordDataMaker.getUnitsMap().get(dozen);
        else if (endOfDozen == 0 && dozen > 19)  return keywordDataMaker.getDozenMap().get(dozen / 10);
        else {
            stringBuilder.append(keywordDataMaker.getDozenMap().get(dozen / 10));
            stringBuilder.append(" ");
            stringBuilder.append(keywordDataMaker.getUnitsMap().get(dozen % 10));
            return  String.valueOf(stringBuilder);
        }
    }


}
