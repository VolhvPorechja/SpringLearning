package org.volhvporechja.demo.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.volhvporechja.demo.contracts.Quote;
import org.volhvporechja.demo.contracts.QuoteServiceResponse;

@Service
public class QuotesService {

    @Autowired
    @Qualifier("FailedMessages")
    ResourceBundleMessageSource messagesSource;

    @Value("${services.quotes.connectionString}")
    String quotesServiceCS;

    private final RestTemplate template;

    public QuotesService(RestTemplate template) {
        this.template = template;
    }

    @HystrixCommand(fallbackMethod = "NextQuoteFallback")
    public QuoteServiceResponse GetNextQuote() {

        Quote quote = template.getForObject(quotesServiceCS, Quote.class);
        return QuoteServiceResponse.Success(quote);
    }

    public QuoteServiceResponse NextQuoteFallback() {
        return QuoteServiceResponse.Failed(messagesSource.getMessage("common.fail", null, "Default", null));
    }
}
