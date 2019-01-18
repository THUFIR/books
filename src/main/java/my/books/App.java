package my.books;

import java.io.File;
import java.net.URI;
import java.nio.file.Files;
import java.util.Properties;
import java.util.logging.Logger;
import nu.xom.Builder;
import nu.xom.Document;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.nio.file.Paths;

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
        URI outputURI = new URI(properties.getProperty("output"));
        File htmlInputFile = new File(inputURI);
        Document document = fileToDocument(htmlInputFile);
        Files.write(Paths.get(outputURI), document.toXML().getBytes());
    }


    private Document fileToDocument(File file) throws Exception {
        XMLReader tagsoup = XMLReaderFactory.createXMLReader("org.ccil.cowan.tagsoup.Parser");
        Builder bob = new Builder(tagsoup);
        Document x;
        x = bob.build(file);
        return x;
    }

}
