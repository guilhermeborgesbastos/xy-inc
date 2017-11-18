/*
 * ValidationUtil.java
 *
 * Tech Test Programming Exercise Zup
 * ValidationUtil implements the auxiliary methods providing validation in the data entering in the REST API
 * @version    0.1.0
 * @author     Guilherme Borges Bastos
*/
package me.challenge.GenericRestApplication.utils;

// >> imports
import org.bson.Document;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;

public class ValidationUtil {
    
	private final Document model;

	public ValidationUtil(Document model) {
		this.model = model;
	}
        
        /**
         * Method used to verify if the field _id it was provided and check if the requested field really exists in the Model's Document
         * @param document 
         */
	public void verify(Document document) {
            if(document.containsKey("_id")){
                throw new ValidationException("Sorry, the field '_id' can not be used!");
            }		
            List<Document> fields = model.get("fields", List.class);
            List<String> existentFieldsName = new ArrayList<>();
            for (Document field : fields) {
                String fieldStr = verifyField(document, field);
                existentFieldsName.add(fieldStr);
            }		
            for (String field : document.keySet()) {
                if (!existentFieldsName.contains(field)) {
                    throw new ValidationException(String.format("The field '%s' does not exits!", field));
                }
            }		
	}
        
        /**
         * Method used to verify if the fields respect the rules
         * @param document
         * @param field
         * @return String
         */
        private String verifyField(Document document, Document field) {
            String fieldName = field.getString("name");
            String fieldType = field.getString("type");
            Boolean isRequired = field.getBoolean("required");
            if (document.containsKey(fieldName)) {
                Object valorCampo = document.get(fieldName);
                if (!fieldType.equals(valorCampo.getClass().getSimpleName()) && !("Double".equals(fieldType) && "Integer".equals(valorCampo.getClass().getSimpleName()))) {
                    throw new ValidationException(String.format("The field '%s' should be %s", fieldName, fieldType));
                }
            } else if (isRequired) {
                throw new ValidationException(String.format("The field '%s' is mandatory!", fieldName));
            }
            return fieldName;
	}

}
