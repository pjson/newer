package com.newer.net.URL.data.SAX;

import com.newer.net.URL.data.DOM.Book1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by json on 2017/3/14.
 */
public class BookHandler extends org.xml.sax.helpers.DefaultHandler{
    public BookHandler() {
        super();
    }

    private List<Book1> list=new ArrayList<Book1>();
    Book1 book1;
    String text;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws org.xml.sax.SAXException {
        super.startElement(uri, localName, qName, attributes);
        System.out.println("startElement"+qName);

        if(qName.equals(book1)){
            book1=new Book1();
            String id=attributes.getValue("id");
//            System.out.println("id="+id);
            book1.setId(Integer.parseInt(id));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws org.xml.sax.SAXException {
        super.endElement(uri, localName, qName);
        System.out.println("endElement"+qName);

        if(qName.equals("book") ){
            //发现</book>
            list.add(book1);
        }
        if(qName.equals("title")){
            //发现</title>
            book1.setTitle(text);
        }
        if(qName.equals("author")){

            book1.setAuthor(text);
        }


    }

    @Override
    public void characters(char[] ch, int start, int length) throws org.xml.sax.SAXException {
        super.characters(ch, start, length);

        System.out.println("characters"+new String(ch,start,length));
        //成员变量
        text=new String(ch,start,length);

    }

    public List<Book1> getList(){
        return list;
    }
}
