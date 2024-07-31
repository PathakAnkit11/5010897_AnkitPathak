public class test {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice(450.75);
        stockMarket.setStockPrice(135.30);

        stockMarket.deregisterObserver(mobileApp);
        stockMarket.setStockPrice(560.00);
    }
}
