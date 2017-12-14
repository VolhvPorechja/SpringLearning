package org.volhvporechja.demo.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.volhvporechja.demo.aspects.SomeServiceContract;
import org.volhvporechja.demo.beans.Person;
import org.volhvporechja.demo.contracts.Offer;
import org.volhvporechja.demo.contracts.QuoteServiceResponse;
import org.volhvporechja.demo.services.OffersService;
import org.volhvporechja.demo.services.QuotesService;

@Component
public class ScheduledTasks {
	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	Person person;

	@Autowired
	QuotesService service;

	private OffersService offersService;

	@Autowired
	public void setOffersService(OffersService srv) {
		offersService = srv;

		Offer offer = new Offer();
		offer.setName("Ubercooker");
		offer.setEmail("ubercooker@fuck.you");
		offer.setText("fuck you fuck you fuck... you!!");

		offersService.createOffer(offer);
	}

	@Autowired
	public void setSomeService(SomeServiceContract service) {
		String s = service.SomeGeneration();
		s = service.SomeModification(s);
		log.info(s);
	}

	@Autowired
	@Qualifier("OtherPerson")
	public void setPerson(Person person) {
		this.person = person;
	}

	@Scheduled(fixedRate = 5000)
	public void report() {
		log.info(person.toString());
	}

	@Scheduled(fixedRate = 5000)
	public void reportQuote() {
		QuoteServiceResponse response = service.GetNextQuote();
		log.info(response.toString());

//        offersService.getOffers().forEach((el) -> log.info(el.toString()));

		offersService.getOfferByName("Bober").forEach((el) -> log.info(el.toString()));
	}
}
