package com.newer.net.URL;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by 何子洋 on 2017/3/11.
 */
public class DOMApp {
    public static void main(String[] args) {

        try {

            //定义一个文档
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            //为文件创建一个根元素组件（树型结构）可以不断的添加子叶（Element)
            Element book = doc.createElement("book");
            book.setAttribute("id", "1234");

            //设置作者（叶元素)
            Element author = doc.createElement("author");
            author.setTextContent("zyoung");
//            book.setAttribute("author", "zyoung");
//            book.setTextContent("时光列车");

            //设置标题(叶元素）
            Element title = doc.createElement("title");
            title.setTextContent("时光列车");
            //添加组件（作者，标题）
            book.appendChild(author);
            book.appendChild(title);
            doc.appendChild(book);

            // 写入文件
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(new DOMSource(doc), new StreamResult(new FileOutputStream("book.xml")));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
