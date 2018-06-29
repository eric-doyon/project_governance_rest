package hello;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RelationshipRepository extends MongoRepository<Relationship, String> {

    public Relationship findByFirstName(String firstName);
    public List<Relationship> findByLastName(String lastName);

}
