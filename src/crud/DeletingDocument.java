package crud;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class DeletingDocument {
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

            //Deleting document
            collection.deleteOne(Filters.eq("id", 1));
            System.out.println("Document deleted successfully...");

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
