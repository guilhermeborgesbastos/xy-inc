/*
 * SearchUtil.java
 *
 * Tech Test Programming Exercise Zup
 * SearchUtil is the concrete implementation of the ISearch interface
 * @version    0.1.0
 * @author     Guilherme Borges Bastos
*/
package me.challenge.GenericRestApplication.utils;

// >> imports
import org.bson.conversions.Bson;
import org.springframework.stereotype.Component;
import org.bson.types.ObjectId;

import com.mongodb.client.model.Filters;

@Component
public class SearchUtil implements ISearch {
    
    @Override
    public Bson searchModel(String modelName) {
        return Filters.eq("model", modelName);
    }

    @Override
    public Bson searchByID(String ID) {
        ObjectId objID = new ObjectId(ID);
        return Filters.eq("_id", objID);
    }
    
}
