package parsexml;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParseXML {
    public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException {
        
        // Obtain and configure a SAX based parser
        SAXParserFactory factory = SAXParserFactory.newInstance();
        
        // Obtain object for SAX parser
        SAXParser saxParser = factory.newSAXParser();
        
        /**
        * default handler for SAX handler class
        * all three methods are written in handler body
        */
        DefaultHandler handler = new DefaultHandler(){
            boolean bname, bprice, bdescription, bcalories;
            // This method is called everytime a parser get an '<' open tag
            // Identigies which tag is being open at time by assigning an open flag
            @Override
            public void startElement(String uri, String localName, String qName,
                    Attributes attributes){
                if(qName.equalsIgnoreCase("name"))
                    bname=true;
                if(qName.equalsIgnoreCase("price"))
                    bprice=true;
                if(qName.equalsIgnoreCase("description"))
                    bdescription=true;
                if(qName.equalsIgnoreCase("calories"))
                    bcalories=true;
                
            }
            
            @Override
            public void endElement(String uri, String localName, String qName){
                
            }
            @Override
            public void characters(char ch[], int start, int length){
                if(bname){
                    System.out.println("name : "+new String(ch, start, length));
                    bname=false;
                }
                if(bprice){
                    System.out.println("price : "+new String(ch, start, length));
                    bprice=false;
                }
                if(bdescription){
                    System.out.println("description : "+new String(ch, start, length));
                    bdescription=false;
                }
                if(bcalories){
                    System.out.println("calories : "+new String(ch, start, length));
                    bcalories=false;
                }
            }
        };
        
        saxParser.parse("test/sample.xml", handler);
    }
}
