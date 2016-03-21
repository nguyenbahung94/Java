package stax;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;


public class staxdemo {
  public static void main(String args[]){
	  boolean flag=false;
	  boolean writes=false;
	  XMLInputFactory factory = XMLInputFactory.newInstance();
	    try {
			XMLStreamReader xmlReader = factory.createXMLStreamReader(new FileReader("src\\stax\\onenew.xml"));
			while(xmlReader.hasNext()){
				 xmlReader.next();
				    if(xmlReader.getEventType() == XMLStreamReader.START_ELEMENT){
		                   
				    	//System.out.println(xmlReader.getName().getLocalPart());//lấy ra tất cả các tên thẻ và tag ,không lấy ra tẻ đóng
				        if(xmlReader.getLocalName().equals("studentkind")){
				        	flag=true;
				        	 System.out.println();
				        	 if(xmlReader.getAttributeValue(0).equals("s02")){
				        		/* try {
				        			 System.out.println(xmlReader.getAttributeLocalName(0));//lấy ra tên thuộc tính
								} catch (Exception e) {
									// TODO: handle exception
								}*/
				        		
				        		// flag=true;
				        	//System.out.println(xmlReader.getAttributeValue(0));//lấy ra gia tri các thuộc tính
				        }
				      
				    }
				    }
				    if(xmlReader.getEventType()==XMLStreamReader.CHARACTERS){
				    	if(flag){
				    	 //  System.out.println(xmlReader.getText().trim());
				    	}
				       }
				    if(xmlReader.getEventType()==XMLStreamReader.END_ELEMENT){
				    	if(xmlReader.getLocalName().equals("student")){
				    		flag=false;
				    	}
				    	}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    StringWriter stringWriter = new StringWriter();

        XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();	
        try {
			XMLStreamWriter xMLStreamWriter = xMLOutputFactory.createXMLStreamWriter(stringWriter);
			if(flag=true){
				 xMLStreamWriter.writeStartElement("country");			
		         xMLStreamWriter.writeAttribute("type", "formula one");
		         xMLStreamWriter.writeCharacters("Ferrari 101");
		         xMLStreamWriter.writeEndElement();

		         String xmlString = stringWriter.getBuffer().toString();

		         stringWriter.close();

		         System.out.println(xmlString);

			}
			
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
}
