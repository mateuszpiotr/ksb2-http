package pl.piotrowski.ksb2CurrencyExchangeGame;

import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class CurrencyExchangeGame {
    private final Scanner scanner = new Scanner(System.in);

    private HashMap<String, Double> getLatestExchangeRates() {
        RestTemplate restTemplate = new RestTemplate();
        String resourcesUrl = "https://api.exchangerate.host/latest?base=PLN";

        return (HashMap<String, Double>) restTemplate.getForObject(resourcesUrl, HashMap.class).get("rates");
    }

    private String getRandomCurrency(HashMap<String, Double> exchangeRates) {
        Random random = new Random();
        List<String> keys = new ArrayList<String>(exchangeRates.keySet());
        return keys.get(random.nextInt(keys.size()));
    }

    public void play() {
        boolean wasRateGuessed = false;
        short numberOfTries = 0;

        HashMap<String, Double> exchangeRates = getLatestExchangeRates();
        String randomCurrency = getRandomCurrency(exchangeRates);
        double currencyRate = BigDecimal.valueOf(exchangeRates.get(randomCurrency))
                .setScale(2, RoundingMode.DOWN)
                .doubleValue();

        System.out.println("Enter the current " + randomCurrency + " -> PLN exchange rate with two decimal places");

        while(!wasRateGuessed) {
            numberOfTries += 1;
            double userRate = scanner.nextDouble();

            if (currencyRate == userRate) {
                wasRateGuessed = true;
                System.out.println("Correct, you guessed it after " + numberOfTries + " tries");
                return;
            } else if (currencyRate > userRate) {
                System.out.println("Too small, try again");
            } else {
                System.out.println("Too big, try again");
            }
        }
    }
}
