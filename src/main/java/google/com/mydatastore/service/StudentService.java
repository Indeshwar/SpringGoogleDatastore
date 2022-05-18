package google.com.mydatastore.service;
import com.google.cloud.datastore.*;
import google.com.mydatastore.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    //Create datastore client objet
    private Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    //Declare a static final String named kind
    private static final String ENTITY_KIND = "Student";

    //create a KeyFactory for students entities
    private final KeyFactory keyFactory = datastore.newKeyFactory().setKind(ENTITY_KIND);

    public Key createStudent(Student student){
        //Declare the entity key,
        //with a Datastore allocated id
        Key key = datastore.allocateId(keyFactory.newKey());

        //Declare the entity object, with the key and data
        // The entity's members are set using the Entity.Builder.
        // This has a set method for property names and values
        // Values are retrieved from the Domain object

        Entity entity = Entity.newBuilder(key)
                .set(Student.FIRST_NAME, student.getFirstName())
                .set(Student.LAST_NAME, student.getLastName())
                .set(Student.ADDRESS, student.getAddress())
                .set(Student.EMAIL, student.getEmail())
                .build();

        datastore.put(entity);

        return key;
    }

}
