/*
 * ValidationUtil.java
 *
 * Tech Test Programming Exercise Zup
 * ValidationUtil implements the auxiliary methods providing validation in the data entering in the REST API
 * @version    0.1.0
 * @author     Guilherme Borges Bastos
*/
package me.challenge.GenericRestApplication.controllers;

// >> imports
import me.challenge.GenericRestApplication.utils.CollectionDatabaseUtil;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class ModelController {
    @Autowired
    private CollectionDatabaseUtil collectionDatabaseUtil;
    
    /**
     * Route to save a new `document`
     * @param document
     * @return Document
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Document modeloSave(@RequestBody Document document) {
        return collectionDatabaseUtil.use("/").save(document);
    }
    
    /**
     * Route to get a specific document searching for the ID
     * @param ID
     * @return Document
     */
    @RequestMapping(value = "/", method = RequestMethod.GET, params = "id")
    public Document modelo(@RequestParam("id") String ID) {
            return collectionDatabaseUtil.use("/").get(ID);
    }
    
    // TODO: finish the mapping of the remaning routes
    
}
