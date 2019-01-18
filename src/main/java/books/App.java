package books;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.util.Properties;
import java.util.logging.Logger;
import javax.xml.bind.JAXB;
import javax.xml.transform.stream.StreamSource;

public class App {

    private static final Logger LOG = Logger.getLogger(App.class.getName());
    private Properties properties = new Properties();

    public static void main(String[] args) throws Exception {
        new App().init();
    }

    private void init() throws Exception {
        properties.loadFromXML(App.class.getResourceAsStream("/properties.xml"));
        LOG.info(properties.toString());
        URI inputURI = new URI(properties.getProperty("html_input"));
        File htmlInputFile = new File(inputURI);

        FileInputStream fileInputStream = new FileInputStream(htmlInputFile);
        StreamSource streamSource = new StreamSource();
        streamSource.setInputStream(fileInputStream);
    //    Foo foo = JAXB.unmarshal(streamSource, Foo.class);
    }

}
