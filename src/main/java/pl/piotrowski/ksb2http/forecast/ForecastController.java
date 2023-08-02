package pl.piotrowski.ksb2http.forecast;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/forecast")
public class ForecastController {
    @GetMapping
    public String getCity(Model model) {
        model.addAttribute("forecast", new Forecast());
        return "getCity";
    }

    @PostMapping("/result")
    public String getForecast(@ModelAttribute Forecast forecast, Model model) {
        String resourcesUrl = "https://goweather.herokuapp.com/weather/";
        RestTemplate restTemplate = new RestTemplate();
        Forecast forecastForSelectedCity = restTemplate.getForObject(resourcesUrl + forecast.getCity(), Forecast.class);
        assert forecastForSelectedCity != null;
        System.out.println(forecastForSelectedCity);
        forecastForSelectedCity.setCity(forecast.getCity());

        model.addAttribute("forecast", forecastForSelectedCity);
        return "result";
    }
}
