package crud;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Date;

public class InsertDoc {
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
            MongoCollection<Document> collection = database.getCollection("stdProfile");

            //Inserting document
            Document document = new Document("id", 2)
                    .append("name", "Amy Blackwood")
                    .append("age",  33)
                    .append("dob", new Date());
            collection.insertOne(document);
            System.out.println("Document inserted successfully.");



        }catch (Exception e){
            System.out.println(e);
        }
    }
}
