package reactive.com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;


@Service
public class CustomerService {
	
	  @Autowired
	    private CustomerDao dao;
	  
	  public Flux<Customer> loadAllCustomersStream() {
	        long start = System.currentTimeMillis();
	        Flux<Customer> customers = dao.getCustomersStream();
	        long end = System.currentTimeMillis();
	        System.out.println("Total execution time : " + (end - start));
	        return customers;
	    }
	  
	  
	  

}
