package hello;

import java.util.List;

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
}