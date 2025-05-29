package sec03;

import app.Database;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import javax.xml.crypto.Data;
import java.util.Iterator;

import static com.mongodb.client.model.Filters.eq;

public class FindOneTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection= Database.getCollection("todo");

        String id="68350c87efd04a7bccfa3061";
        Bson query=eq("_id",new ObjectId(id));

        Document doc=collection.find(query).first();
        System.out.println("==> findByIdResult: "+doc);

        Database.close();

    }
}
