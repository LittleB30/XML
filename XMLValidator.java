

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XMLValidator {

	public static void main(String[] args) {
		/*
		 * Change this according to the file names.
		 */
		System.out.println("validating XML against XSD ? " + validateXMLSchema("ClassSchema.xsd", "Class.xml"));
	}

	public static boolean validateXMLSchema(String xsdFile, String xmlFile){
		//String src = "Submission attachment(s)\\";
		String src = "";
	         
	        try {
	            SchemaFactory factory = 
	                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	            /* Adjust the file path to your package/src  structure or where your XSD/XML files are*/
	            /* if they are in a package say "edu.it226.xml
	             * File xsdFilePath = new File("src/edu/it226/xml/"+xsdFile);
	             * File xsdFilePath = new File("src/"+xsdFile);
	             * */
	            // This assumes that your XML and XSD files in src folder.
	            File xsdFilePath = new File(src + xsdFile);
	            File xmlFilePath = new File(src + xmlFile);
	            Schema schema = factory.newSchema(xsdFilePath.getAbsoluteFile());
	            Validator validator = schema.newValidator();
	            validator.validate(new StreamSource(xmlFilePath.getAbsoluteFile()));
	        } catch (IOException | SAXException e) {
	            System.out.println("Exception: "+e.getMessage());
	            return false;
	        }
	        return true;
	    }
}
