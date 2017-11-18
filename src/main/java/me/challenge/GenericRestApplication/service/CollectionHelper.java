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
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import me.challenge.GenericRestApplication.utils.ISearch;

public class CollectionHelper {
    	private final ISearch search;
	private final MongoCollection<Document> collection;

	public CollectionHelper(MongoCollection<Document> collection, ISearch search, Document modelo) {
		this.collection = collection;
		this.search = search;
	}

	// TODO: Create the validation Class
        // TODO: Create the CRUD methods

}
