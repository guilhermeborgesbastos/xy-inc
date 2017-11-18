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
import me.challenge.GenericRestApplication.utils.ValidationUtil;

public class CollectionHelper {
    	private final ISearch search;
	private final MongoCollection<Document> collection;
	private final ValidationUtil validation;

	public CollectionHelper(MongoCollection<Document> collection, ISearch search, Document model) {
		this.collection = collection;
		this.search = search;
		this.validation = new ValidationUtil(model);
	}

	// TODO: Create the validation Class
        // TODO: Create the CRUD methods

}
