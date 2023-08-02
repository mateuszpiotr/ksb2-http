package pl.piotrowski.ksb2http.quotes;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "q",
        "a",
        "c",
        "h"
})
@Generated("jsonschema2pojo")
public class Quote {

    @JsonProperty("q")
    private String quote;
    @JsonProperty("a")
    private String author;
    @JsonProperty("c")
    private String characterCount;
    @JsonProperty("h")
    private String html;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Quote() {
    }

    /**
     * @param q
     * @param a
     * @param c
     * @param h
     */
    public Quote(String q, String a, String c, String h) {
        super();
        this.quote = q;
        this.author = a;
        this.characterCount = c;
        this.html = h;
    }

    @JsonProperty("q")
    public String getQuote() {
        return quote;
    }

    @JsonProperty("q")
    public void setQuote(String quote) {
        this.quote = quote;
    }

    @JsonProperty("a")
    public String getAuthor() {
        return author;
    }

    @JsonProperty("a")
    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonProperty("c")
    public String getCharacterCount() {
        return characterCount;
    }

    @JsonProperty("c")
    public void setCharacterCount(String characterCount) {
        this.characterCount = characterCount;
    }

    @JsonProperty("h")
    public String getHtml() {
        return html;
    }

    @JsonProperty("h")
    public void setHtml(String html) {
        this.html = html;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}