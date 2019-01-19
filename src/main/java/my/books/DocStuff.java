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

public class DocStuff {

    private static final Logger LOG = Logger.getLogger(DocStuff.class.getName());
    private Properties properties = new Properties();

    private DocStuff() {
    }

    public DocStuff(Properties properties) {
        this.properties = properties;
    }

    private void driver() throws Exception {
        LOG.info(properties.toString());
        URI inputURI = new URI(properties.getProperty("html_input"));
        URI outputURI = new URI(properties.getProperty("output"));
        Document document = fileToDocument(new File(inputURI));
        Files.write(Paths.get(outputURI), document.toXML().getBytes());
        Document d = fileToDocumentStrict(new File(outputURI));
        LOG.info(d.toXML());
    }

    private Document fileToDocumentStrict(File file) throws Exception {
        Builder bob;
        bob = new Builder();
        Document document = bob.build(file);
        return document;
    }

    private Document fileToDocument(File file) throws Exception {
        XMLReader tagsoup = XMLReaderFactory.createXMLReader("org.ccil.cowan.tagsoup.Parser");
        Builder bob = new Builder(tagsoup);
        Document document = bob.build(file);
        return document;
    }

}
