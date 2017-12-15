package crud;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;

public class CreatingCollection {
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

            //Creating collection
            database.createCollection("stdProfile");
            System.out.println("Collection created successfully.");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
