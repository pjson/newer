package com.newer.net.URL.data.Parse;

import com.newer.net.URL.data.DOM.Book1;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by json on 2017/3/11.
 */
public class AppParseXml {
    public static void main(String[] args) {
        //解析
        try {
            Document doc= DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .parse(new File("book-list.xml"));

            NodeList list=doc.getElementsByTagName("book");
            ArrayList<Book1>book1ArrayList=new ArrayList<>();

            for(int i=0;i<list.getLength();i++){
                Element element= (Element) list.item(i);//获得节点强转成元素
//                System.out.println(element.getTextContent());//打印节点值
//                System.out.println(element.getAttribute("id"));//书的编号

                Book1 b=new Book1();
                book1ArrayList.add(b);
                //获取id
                b.setId(Integer.parseInt(element.getAttribute("id")));

                //获得标题
                String title=element.getElementsByTagName("title").item(0).getTextContent();
                b.setTitle(title);
                //获取作者
                String author=element.getElementsByTagName("author").item(0).getTextContent();
                b.setAuthor(author);
            }
            for(Book1 book:book1ArrayList){
                System.out.println(book.toString());
            }


        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

    }
}
