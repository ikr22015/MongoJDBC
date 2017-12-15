package crud;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.Iterator;

public class RetrievingDoc {
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

            //Retrieving collection
            MongoCollection<Document> collection = database.getCollection("stdProfile");

            //Retrieving Document
                //Getting the iterable object
            FindIterable<Document> iterDoc = collection.find();

            int i = 1;

            Iterator it = iterDoc.iterator();

            while (it.hasNext()){
                System.out.println(it.next());
                i++;
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
