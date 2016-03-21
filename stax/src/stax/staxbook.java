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

import com.sun.jmx.mbeanserver.MXBeanLookup;

public class staxbook {
	public static void main(String args[]){
		  boolean flag=false;
		  boolean writes=false;
		  XMLInputFactory factory = XMLInputFactory.newInstance();
		    try {
				XMLStreamReader xmlReader = factory.createXMLStreamReader(new FileReader("C:\\Users\\everything\\Desktop\\lap trinh huong dich vu\\stax\\src\\stax\\book.xml"));
				while(xmlReader.hasNext()){
					 xmlReader.next();
					    if(xmlReader.getEventType() == XMLStreamReader.START_ELEMENT){
			                  // System.out.println("start element: "+xmlReader.getLocalName());
			                   if(xmlReader.getLocalName().equals("price")){
			                	   flag=true;
			                	  
			                   }
					    
					    }
					    if(xmlReader.getEventType()==XMLStreamReader.CHARACTERS){
					    	if(flag){
					    		System.out.println(xmlReader.getText().trim());
					    		flag=false;
					    	}
					    }
					    if(xmlReader.getEventType()==XMLStreamReader.END_ELEMENT){
					    	//.out.println("end element: "+xmlReader.getLocalName());
					    }
					   
					    }
				
		    }
			 catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (XMLStreamException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
	}
	}
