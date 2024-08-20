package reactive.com.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
    private CustomerService service;
	
	 @Autowired
	    private CustomerDao dao;

	  @GetMapping(value = "/stream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	    public Flux<Customer> getAllCustomersStream() {
	        return service.loadAllCustomersStream();
	    }
	  
	  @GetMapping
	  public List<Customer> loadAllCustomers() {
	        long start = System.currentTimeMillis();
	        List<Customer> customers = dao.getCustomers();
	        long end = System.currentTimeMillis();
	        System.out.println("Total execution time : " + (end - start));
	        return customers;
	    }

}
