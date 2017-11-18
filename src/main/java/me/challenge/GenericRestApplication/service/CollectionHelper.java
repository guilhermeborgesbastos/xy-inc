/*
 * CollectionHelper.java
 *
 * Tech Test Programming Exercise Zup
 * CollectionHelper implements the auxiliary functions to manage the database
 * @version    0.1.0
 * @author     Guilherme Borges Bastos
*/
package me.challenge.GenericRestApplication.service;

// >> imports
import com.mongodb.Block;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.List;
import me.challenge.GenericRestApplication.utils.ISearch;
import me.challenge.GenericRestApplication.utils.ValidationUtil;
import org.bson.conversions.Bson;

public class CollectionHelper {
    private final MongoCollection<Document> collection;
    private final ISearch search;
    private final ValidationUtil validation;
    
    // contructor
    public CollectionHelper(MongoCollection<Document> collection, ISearch search, Document model){
        this.collection = collection;
        this.search = search;
        this.validation = new ValidationUtil(model);
    }

    // public method(s)
    /**
     * Save a new document
     * @param doc
     * @return Document
    */
    public Document save(Document document){
        validation.verify(document);
        collection.insertOne(document);
        return document;
    }

    /**
     * 
     * @param ID
     * @return Document
    */
    public Document get(String ID){
        return collection.find(searchByID(ID)).first();
    }

    /**
     * Method that returns a list of all documents into Database
     * @return List<Document>
    */
    public List<Document> getAll(){
        List<Document> documents = new ArrayList<>();
        collection.find().forEach((Block<Document>) document -> documents.add(document));
        return documents;
    }

    /**
     * Update a document looking for the ID field
     * @param ID
     * @param document
     * @return boolean
    */
    public boolean update(String ID, Document document){
        validation.verify(document);
        return collection.replaceOne(searchByID(ID), document).wasAcknowledged();
    }

    /**
     * Delete a document looking for the ID field
     * @param ID
     * @return 
    */
    public boolean delete(String ID){
        return collection.deleteOne(searchByID(ID)).wasAcknowledged();
    }
       
    // private method(s)
    /**
     * Search a document by ID
     * @param ID
     * @return Bson
    */
    private Bson searchByID(String ID){
        return search.searchByID(ID);
    }    
}
