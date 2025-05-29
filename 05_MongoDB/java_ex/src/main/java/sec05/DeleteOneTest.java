package sec05;

import app.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.internal.bulk.DeleteRequest;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;

public class DeleteOneTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection= Database.getCollection("users");

        String id="68355b216e5c9d3152b89038";
        Bson query=eq("_id", new ObjectId(id));

        DeleteResult result=collection.deleteOne(query);
        System.out.println("==>DeleteResult: "+result.getDeletedCount());
        Database.close();
    }
}
