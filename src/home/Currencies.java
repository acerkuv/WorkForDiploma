package home;

public enum Currencies {
    USD(new String[] {"доллар", "доллара", "долларов"}),
    RUB(new String[] {"рубль", "рубля", "рублей"});
    private final String[] names;

    Currencies(String [] names){
        this.names = names;
    }
    public  String getNameCurrency(int value){
        if (value == 0 | value > 4) return names[2];
        else if (value == 1) return names[0];
//        else  (value > 1 & value < 5) return names[1];
        else return names[1];
    }


}