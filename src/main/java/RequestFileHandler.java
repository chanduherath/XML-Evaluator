import java.io.File;
import java.util.List;

/**
 * Created by Chandu Herath on 20/1/2019.
 */
public class RequestFileHandler {


    public static void main(String[] args) {

        XMLReader reader =  new XMLReader();
        List<File> fileList = reader.readFiles();
        List<Product> objectList = reader.getUnmarshelledList(fileList);

        XLXFileWriter fileWriter = new XLXFileWriter();
        fileWriter.createXLXFile(objectList);

    }

}