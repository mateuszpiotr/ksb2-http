package pl.piotrowski.ksb2CurrencyExchangeGame;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ksb2CurrencyExchangeGame implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Ksb2CurrencyExchangeGame.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CurrencyExchangeGame currencyExchangeGame = new CurrencyExchangeGame();
		currencyExchangeGame.play();
	}

}
