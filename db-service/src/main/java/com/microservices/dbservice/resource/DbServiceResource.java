package com.microservices.dbservice.resource;
//com.microservices.dbservice
import com.microservices.dbservice.model.Quote;
import com.microservices.dbservice.model.Quotes;
import com.microservices.dbservice.repository.QuoteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource{

    private QuotesRepository quotesRepository;

    @GetMapping("/{username}")
    //return list of string
    public List<String> getQuotes(@PathVariable("username")
                                  final String username){
        //Querying repository, collecting only quotes and sending to REST endpoints
        return quotesRepository.findByUserName(username)
                .stream()
                .map(Quote::getQuote)
                .collect(Collectors.toList());

     @PostMapping("/add")
     public List<String> add(@RequestBody final Quotes quotes) {
         //iterate list of quotes (i.e in quotes.java) and add username
         quotes.getQuotes()
                .stream()
                .forEach(quote -> {
                    //save on creation of new quote everytime
                    quotes.getQuotes()
                            .stream()
                            .map(quote -> new Quote(quotes.getUserName(), quote))
                            .forEach(quote -> QuotesRepository.save(quote));

                    return getQuotesByUserName(quotes.getUserName());
                });
      private List<String> getQuotesByUserName(@PathVariable("username") String username) {
          return quotesRepository.findByUserName(username)
                  .stream()
                  .map(Quote::getQuote)
                  .collect(Collectors.toList());
      }
     }
    }
}