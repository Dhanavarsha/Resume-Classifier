package documentReader;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class DocxReader implements DocumentReader {
    private File file = null;
    private String text = "";

    public DocxReader(File file) {
        this.file = file;
    }

    public String getDocumentText() {
        try {
            FileInputStream fis = new FileInputStream(file);
            XWPFDocument document = new XWPFDocument(fis);
            List<XWPFParagraph> paragraphs = document.getParagraphs();
            for (XWPFParagraph paragraph : paragraphs) {
                text = text + paragraph.getText();
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }
}
