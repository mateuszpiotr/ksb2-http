package pl.piotrowski.ksb2http.quotes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class QuoteController {
    private Quote[] getQuotes() {
        String resourcesUrl = "https://zenquotes.io/api/quotes";
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(resourcesUrl, Quote[].class);
    }

    @GetMapping("/quotes")
    public String showQuotes(Model model) {
        Quote[] quotes = getQuotes();

        model.addAttribute("quotes", quotes);
        return "quotes";
    }
}
