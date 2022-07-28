package Test;


public class Test {
    public static void main(String[] args) {
        TestMashine testMashine = new TestMashine();
        testMashine.check("1RUB", "один рубль ");
        testMashine.check("101 USD", "сто один доллар ");
        testMashine.check("100027 RUB", "сто тысяч двадцать семь рублей ");
        testMashine.check("77709 USD", "семьдесят семь тысяч семьсот девять долларов ");
        testMashine.check("889759USD", "восемьсот восемьдесят девять тысяч семьсот пятьдесят девять долларов");
        testMashine.check("100001RUB", "сто тысяч один рубль ");
        testMashine.check("127988 RUB","сто двадцать семь тысяч девятьсот восемьдесят восемь рублей ");





    }
}
