package my.books;

import java.io.File;
import java.net.URI;
import java.util.Properties;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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

        File input = new File(inputURI);
        Document doc = Jsoup.parse(input, "UTF-8");
        Element masthead = doc.select("div.side_categories").first();
        LOG.info(masthead.outerHtml());
    }

}
