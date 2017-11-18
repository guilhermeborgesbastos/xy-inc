/*
 * CollectionDatabaseUtil.java
 *
 * Tech Test Programming Exercise Zup
 * CollectionDatabaseUtil is the manager of the NoSQL Database ( MongoDB )
 * @version    0.1.0
 * @author     Guilherme Borges Bastos
*/

package me.challenge.GenericRestApplication.utils;

// >> imports
import org.springframework.beans.factory.annotation.Autowired;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import me.challenge.GenericRestApplication.service.CollectionHelper;
import org.springframework.stereotype.Service;

@Service
public class CollectionDatabaseUtil {

    @Autowired
    private ISearch search;
    
    @Autowired
    private MongoDatabase mongoDB;
    
    // Data BSON Model
    private static final Document DATA_MODEL = Document.parse("{\"model\":\"/\",\"fields\":[{\"name\":\"model\",\"type\":\"String\",\"required\":true},{\"name\":\"fields\",\"type\":\"ArrayList\"}]}");
    
    /**
     * CollectionHelper instance
     * @param collectionName
     * @return CollectionHelper
    */
    public CollectionHelper use(String collectionName) {
        Document model = getModel(collectionName);
        MongoCollection<Document> collection = mongoDB.getCollection(collectionName);
        return new CollectionHelper(collection, search, model);
    }
    
    /**
     * // method to get a document searching into mongoDB's collections
     * @param collectionName
     * @return Document
    */
    private Document getModel(String collectionName) {
        if ("/".equals(collectionName)) { return DATA_MODEL; }
        // find the model into mongoDB
        Document model = mongoDB.getCollection("/").find(search.searchByID(collectionName)).first();
        if (model == null) { throw new IllegalArgumentException("Model's collection not found!"); }
        return model;
    }
}
