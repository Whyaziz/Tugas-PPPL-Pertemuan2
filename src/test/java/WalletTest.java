import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WalletTest {

    private Wallet wallet;

    @BeforeEach
    void setUp() {
        wallet = new Wallet("John Doe");
    }

    @Test
    void testAddMoney() {

        for (int moneyType : wallet.moneyTypes){
            wallet.addMoney(moneyType);
            Assertions.assertEquals(1, wallet.getMoneys().get(moneyType));
        }

    }

    @Test
    void testAddCoin() {

        for (int coinType : wallet.coinsTypes) {
            wallet.addCoin(coinType);
            Assertions.assertEquals(1, wallet.getCoins().get(coinType));
        }
    }

    @Test
    void testAddCard() {
        String card = "LineBank Debit Card";
        wallet.addCard(card);
        Assertions.assertTrue(wallet.getCards().contains(card));
    }

    @Test
    void testTakeCard() {
        String card = "LineBank Debit Card";
        wallet.addCard(card);
        wallet.takeCard(card);
        Assertions.assertFalse(wallet.getCards().contains("Credit Card"));
    }

    @Test
    void testTakeCoins() {
        for(int coinType : wallet.coinsTypes) {
            wallet.addCoin(coinType);
            Assertions.assertEquals(1, wallet.getCoins().get(coinType));
            wallet.takeCoins(coinType);
            Assertions.assertEquals(0, wallet.getCoins().get(coinType));
        }
    }

    @Test
    void testTakeMoneys() {
        for(int moneyType : wallet.moneyTypes) {
            wallet.addMoney(moneyType);
            Assertions.assertEquals(1, wallet.getMoneys().get(moneyType));
            wallet.takeMoneys(moneyType);
            Assertions.assertEquals(0, wallet.getMoneys().get(moneyType));
        }
    }

    @Test
    void testCalculateCoins(){
        int currentCoins = 0;

        for(int coinType : wallet.coinsTypes) {
            wallet.addCoin(coinType);
            currentCoins += coinType;
            Assertions.assertEquals(currentCoins, wallet.calculateCoins());
        }
    }

    @Test
    void testCalculateMoneys(){
        int currentMoneys = 0;

        for(int moneyType : wallet.moneyTypes) {
            wallet.addMoney(moneyType);
            currentMoneys += moneyType;
            Assertions.assertEquals(currentMoneys, wallet.calculateMoneys());
        }
    }

    @Test
    void testGetMoneyAvailable() {
        wallet.addMoney(10000);
        wallet.addCoin(500);
        Assertions.assertEquals(10500, wallet.getMoneyAvailable());
    }

}
