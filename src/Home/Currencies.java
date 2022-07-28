package Home;

public enum Currencies {
    USD(new String[] {"доллар", "доллара", "доларов"}),
    RUB(new String[] {"рубль", "рубля", "рублей"});
    private final String[] names;

    Currencies(String [] names){
        this.names = names;
    }
    public  String getNameCurrency(int value){
        return names[value];
    }


}