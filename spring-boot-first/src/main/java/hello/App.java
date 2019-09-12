package hello;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class App {

    public static void main(String[] args) {

//        String filePath = "D:/1001.docx";
        String filePath = "D:/demo.doc";
        String content = readWord(filePath);
        System.out.println(content);
    }

    public static String readWord(String path) {
        String buffer = "";
        try {
            // 解析 word 2003
            if (path.endsWith(".doc")) {
                System.out.println("开始解析word 2003");
                InputStream is = new FileInputStream(new File(path));
                WordExtractor ex = new WordExtractor(is);
                buffer = ex.getText();
                ex.close();

            } else if (path.endsWith("docx")) { //解析word 2007
                System.out.println("开始解析word 2007");
                OPCPackage opcPackage = POIXMLDocument.openPackage(path);
                POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
                buffer = extractor.getText();
                extractor.close();
            } else {
                System.out.println("此文件不是word文件！");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return buffer;
    }
}
