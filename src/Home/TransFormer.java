package Home;

public class TransFormer {

    public String[] AmountSegmentation(String amount){
        char[] AllAmount = amount.toCharArray();
        String [] AmountAndCurrency = new String[2];
        StringBuilder digitalAmount = new StringBuilder();
        String currency = "";
        for (char spell: AllAmount){
            if(isNum(spell)) {
                digitalAmount.append(spell);
            }
            if (!isNum(spell) & spell != ' ') {
                currency += spell;
            }
        }
        AmountAndCurrency[0]= digitalAmount.toString();
        AmountAndCurrency[1] = currency;
        return AmountAndCurrency;
    }
    public int[] SharedAmountOnClass(String amount){
        int amountNum = Integer.parseInt(amount);
        int quantityOfSegments = 4;
        int[] SegmentedAmount = new int[quantityOfSegments];
        int hundredsThousands = amountNum/100000;
        int thousands = (amountNum - hundredsThousands * 100000) / 1000;
        int hundreds =( amountNum - hundredsThousands * 100000 - thousands * 1000) / 100;
        int dozens = amountNum - hundredsThousands * 100000 - thousands * 1000 - hundreds * 100;

        SegmentedAmount[0] = hundredsThousands;
        SegmentedAmount[1] = thousands;
        SegmentedAmount[2] = hundreds;
        SegmentedAmount[3] = dozens;

        return SegmentedAmount;
    }

    private boolean isNum(char spell){
        try{
            Integer.parseInt(Character.toString(spell));
        }catch (Exception e){
            return  false;
        }
        return true;
    }


}