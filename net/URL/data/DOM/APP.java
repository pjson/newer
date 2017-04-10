package com.newer.net.URL.data.DOM;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * Created by json on 2017/3/11.
 */
public class APP {
    public static void main(String[] args) {
        //ArrayList是实现了基于动态数组的数据结构，
        // LinkedList基于链表的数据结构。
        ArrayList<Book1>list=new ArrayList<>();

        list.add(new Book1(1, "123", "123"));
        list.add(new Book1(2, "12", "123"));
        list.add(new Book1(3, "1", "123"));

        //文档
        try {
            Document doc= DocumentBuilderFactory//文件建造工厂
                    .newInstance()
                    .newDocumentBuilder()
                    .newDocument();

            //root元素
            Element bookList=doc.createElement("book-list");
            for(Book1 b:list) {

                Element book = doc.createElement("book");

                //创建属性节点
                Attr id = doc.createAttribute("id");
                id.setValue(String.valueOf(b.getId()));

                //创建元素节点
                Element author = doc.createElement("author");
                author.setTextContent(b.getAuthor());
                //创建元素节点
                Element title = doc.createElement("title");
                //创建文本节点(被包含在元素节点中）
                Text titleContext = doc.createTextNode(b.getTitle());
                title.appendChild(titleContext);

                book.setAttributeNode(id);
                book.appendChild(author);
                book.appendChild(title);

                bookList.appendChild(book);
            }
                // 根元素追加到 doc 中
                doc.appendChild(bookList);
                //转换
                TransformerFactory.newInstance()
                        .newTransformer()
                        .transform(
                                new DOMSource(doc),
                                new StreamResult(new File("book-list.xml")));

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }catch (Error e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
