package hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import hello.forms.RelationshipForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RelationshipController {

    @Autowired
    private RelationshipRepository repository;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/relationships")
    public List<Relationship> listRelationships(@RequestParam(required=false) String name) {
        return repository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/relationships/add")
    public Relationship addRelationship(@RequestBody RelationshipForm relationshipForm) {
        Relationship relationship = new Relationship(relationshipForm.getFirstName(), relationshipForm.getLastName());
        repository.save(relationship);
        return relationship;
    }
//    repository.deleteAll();
//
//    // save a couple of customers
//        repository.save(new Relationship("Alice", "Smith"));
//        repository.save(new Relationship("Bob", "Smith"));
//
//    // fetch all customers
//        System.out.println("Relationship found with findAll():");
//        System.out.println("-------------------------------");
//        for (Relationship relationship : repository.findAll()) {
//        System.out.println(relationship);
//    }
//        System.out.println();
//
//    // fetch an individual relationship
//        System.out.println("Relationship found with findByFirstName('Alice'):");
//        System.out.println("--------------------------------");
//        System.out.println(repository.findByFirstName("Alice"));
//
//        System.out.println("Relationship found with findByLastName('Smith'):");
//        System.out.println("--------------------------------");
//        for (Relationship relationship : repository.findByLastName("Smith")) {
//        System.out.println(relationship);
//    }
}