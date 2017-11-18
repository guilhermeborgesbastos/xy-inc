/*
 * ISearch.java
 *
 * Tech Test Programming Exercise Zup
 * This interface represents the behavior of the Search Class where can be expanded as much as needed
 * @version    0.1.0
 * @author     Guilherme Borges Bastos
*/

package me.challenge.GenericRestApplication.utils;

// >> imports
import org.bson.conversions.Bson;

public interface ISearch {
    // Method to search a model using a name as a parameter
    Bson searchModel(String modelName);
    // Method to search a model using an ID as a parameter
    Bson searchByID(String ID);
    // TODO: continue improving the interface adding more methods
}