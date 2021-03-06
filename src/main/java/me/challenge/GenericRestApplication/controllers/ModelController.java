/*
 * ModelController.java
 *
 * Tech Test Programming Exercise Zup
 * ModelController implements the Routs for the REST API
 * @version    0.1.0
 * @author     Guilherme Borges Bastos
*/
package me.challenge.GenericRestApplication.controllers;

// >> imports
import java.util.List;
import me.challenge.GenericRestApplication.utils.CollectionDatabaseUtil;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
    public Document modelSave(@RequestBody Document document) {
        return collectionDatabaseUtil.use("/").save(document);
    }
    
    /**
     * Route to get a specific document searching for the ID
     * @param ID
     * @return Document
     */
    @RequestMapping(value = "/", method = RequestMethod.GET, params = "id")
    public Document model(@RequestParam("id") String ID) {
        return collectionDatabaseUtil.use("/").get(ID);
    }
    
    /**
     * Route to list all saved `documents`
     * @return List of Documents
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Document> models() {
        return collectionDatabaseUtil.use("/").getAll();
    }
    
    /**
     * Route to list all saved `documents` into specific model
     * @param model
     * @return List of Documents
     */
    @RequestMapping(value = "/{model}", method = RequestMethod.GET)
    public List<Document> getAll(@PathVariable("model") String model) {
        return collectionDatabaseUtil.use(model).getAll();
    }
    
    /**
     * Route to get an specific saved `document` into an specific model
     * @param modelo
     * @param ID
     * @return Document
     */
    @RequestMapping(value = "/{model}/{id}", method = RequestMethod.GET)
    public Document get(@PathVariable("model") String modelo, @PathVariable("id") String ID) {
        return collectionDatabaseUtil.use(modelo).get(ID);
    }
    
    /**
     * Route to save a new model
     * @param model
     * @param document
     * @return Document
     */
    @RequestMapping(value = "/{model}", method = RequestMethod.POST)
    public Document save(@PathVariable("model") String model, @RequestBody Document document) {
        return collectionDatabaseUtil.use(model).save(document);
    }
        
    /**
     * Route to delete a model
     * @param model
     * @param document
     * @return Document
     */
    @RequestMapping(value = "/{model}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteModel(@PathVariable("model") String model, @RequestBody Document document) {
        // call the method to delete a collection or model
        boolean deleteModel = collectionDatabaseUtil.use(model).delete(model);
        // verify the if the delete got success and return a feedback
        return deleteModel ? ResponseEntity.ok(true) : ResponseEntity.badRequest().body(false);
    }
    
    /**
     * Route to update a specific saved `document` into an specific model
     * @param model
     * @param ID
     * @param document
     * @return
     */
    @RequestMapping(value = "/{model}/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Boolean> update(@PathVariable("model") String model, @PathVariable("id") String ID, @RequestBody Document document) {
        // call the method to update the `document`
        boolean update = collectionDatabaseUtil.use(model).update(ID, document);
        // verify the if the update got success and return a feedback
        return update ? ResponseEntity.ok(true) : ResponseEntity.badRequest().body(false);
    }
    
    /**
     * Route to delete a specific saved `document` into an specific model
     * @param model
     * @param documentID
     * @return 
     */
    @RequestMapping(value = "/{model}/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("model") String model, @PathVariable("id") String ID) {
        // call the method to delete the `document`
        boolean delete = collectionDatabaseUtil.use(model).delete(ID);
        // verify the if the delete got success and return a feedback
        return delete ? ResponseEntity.ok(true) : ResponseEntity.badRequest().body(false);
    }
    
}
