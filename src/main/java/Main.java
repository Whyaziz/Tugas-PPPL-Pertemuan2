public class Main {

    public static void main(String[] args) {
        Wallet wallet = new Wallet("John Doe");
        System.out.println(wallet.getMoneys());
        wallet.addMoney(10000);
        wallet.addCoin(500);
        wallet.addCard("LineBank Debit Card");

        System.out.println(wallet.getMoneys());
        wallet.moneys.clear();
        wallet.cards.clear();
        System.out.println(wallet.getMoneys());

    }

}
