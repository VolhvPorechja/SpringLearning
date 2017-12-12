package org.volhvporechja.demo.contracts;

public class QuoteServiceResponse {
    private Quote Quote;
    private String Message;
    private boolean Success;

    public QuoteServiceResponse(org.volhvporechja.demo.contracts.Quote quote, String message, boolean success) {
        Quote = quote;
        Message = message;
        Success = success;
    }

    public static QuoteServiceResponse Success(Quote quote) {
        return new QuoteServiceResponse(quote, null, true);
    }

    public static QuoteServiceResponse Failed(String message) {
        return new QuoteServiceResponse(null, message, false);
    }

    @Override
    public String toString() {
        return "QuoteServiceResponse{" +
                "Quote=" + Quote +
                ", Message='" + Message + '\'' +
                ", Success=" + Success +
                '}';
    }
}
