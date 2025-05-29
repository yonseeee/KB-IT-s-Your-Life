package app;

import app.domain.Todo;
import com.mongodb.client.MongoCollection;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class App {
    public static void main(String[] args) {
        MongoCollection<Todo> collection=Database.getCollection("todo", Todo.class);

        Todo newtodo=new Todo(null,"POJO","POJO 테스트 확인", false);
        collection.insertOne(newtodo);

        List<Todo> todos=new ArrayList<>();
        collection.find().into(todos);
        for(Todo todo:todos){
            System.out.println(todo);
        }

        String id = "";
        Bson query=eq("_id", new ObjectId(id));

        Todo todo=collection.find(query).first();

    }
}
