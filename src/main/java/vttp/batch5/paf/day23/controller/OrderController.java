package vttp.batch5.paf.day23.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vttp.batch5.paf.day23.service.OrderService;


@RestController
@RequestMapping("/api/purchaseorder")
public class OrderController {

    @Autowired
    private OrderService service;
    
    @PutMapping("")
    public ResponseEntity<String> postOrder(@RequestBody String entity) throws ParseException {
        boolean b = service.checkout(entity);
        if (!b) {
            return ResponseEntity.badRequest().body("Error saving order.");
        }
        return ResponseEntity.ok().build();
        
    }
    
}
