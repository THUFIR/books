package my.books;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.Properties;
import java.util.logging.Logger;
import javax.xml.bind.JAXB;
import javax.xml.transform.stream.StreamSource;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.ParsingException;
import nu.xom.ValidityException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class App {

    private static final Logger LOG = Logger.getLogger(App.class.getName());
    private Properties properties = new Properties();

    public static void main(String[] args) throws Exception {
        new App().driver();
    }

    private void driver() throws Exception {
        properties.loadFromXML(App.class.getResourceAsStream("/properties.xml"));
        LOG.info(properties.toString());
        URI inputURI = new URI(properties.getProperty("html_input"));
        File htmlInputFile = new File(inputURI);
        Document document = fileToDocument(htmlInputFile);
    }

    private Document fileToDocument(File file) throws Exception {
        XMLReader tagsoup = XMLReaderFactory.createXMLReader("org.ccil.cowan.tagsoup.Parser");
        Builder bob = new Builder(tagsoup);
        Document x;
        x = bob.build(file);
        return x;
    }


}
