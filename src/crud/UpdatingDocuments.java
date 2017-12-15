package crud;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;

public class UpdatingDocuments {
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

            //Updating Document
            collection.updateOne(Filters.eq("id", 3), Updates.set("age", 30));
            System.out.println("Document update successfully...");

            //Now check on your terminal

        }catch (Exception e){
            System.out.println(e);
        }
    }
}

