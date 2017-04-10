package com.newer.net.URL.data.SAX;

import com.newer.net.URL.data.DOM.Book1;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by json on 2017/3/14.
 */
public class App {
    public static void main(String[] args) {
        try {
            //解析器：读取XML文件
            SAXParser parser= SAXParserFactory
                                .newInstance()
                                .newSAXParser();
            BookHandler bookHandler=new BookHandler();
            parser.parse(
                    new File("book-list.xml"),
                    bookHandler);
            List<Book1>list=bookHandler.getList();

            for (Book1 book1 : list) {
                System.out.println(book1);
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
