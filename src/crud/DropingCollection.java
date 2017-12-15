package crud;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DropingCollection {
    public static void main(String[] args) throws Exception{
        try {
            // Create mongo client
            MongoClient mongo = new MongoClient("localhost", 27017);

            // Create credentials.
            MongoCredential credential;
            credential = MongoCredential.createCredential("username",
                    "newBD", "abc123".toCharArray());

            //Accessing the database
            MongoDatabase database = mongo.getDatabase("newBD");
            System.out.println("Connected to the database successfully.");
            System.out.println("Credentials::" + credential);

            //Retrieving collection
            MongoCollection<Document> collection = database.getCollection("student");

            // Dropping a Collection
            collection.drop();
            System.out.println("Collection dropped successfully");

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
