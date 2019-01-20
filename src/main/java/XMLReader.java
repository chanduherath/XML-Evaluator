import sun.plugin.perf.PluginRollup;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Chandu Herath on 20/1/2019.
 */
public class XMLReader {

    public static final String fileReadPath = "D:\\ResponceFiles";
    public static final String REQUEST_FILE_NAME = "wideSearch.xml";

    public ArrayList<File> readFiles()
    {
        File file = new File(fileReadPath);
        File[] arr = file.listFiles();
        ArrayList<File> folderList = new ArrayList<File>(Arrays.asList(arr)) ;
        return folderList;
    }

    public List<Product> getUnmarshelledList(List<File> folderList) {

        List<Product> unmarshelledList = new ArrayList<Product>();
        for(File folder : folderList)
        {
            if(folder.isDirectory())
            {
                System.out.println(folder.getAbsolutePath());
                unmarshelledList.add((Product) readRequestFile(folder));
            }
        }
        return unmarshelledList;
    }

    private Object readRequestFile(File folder) {
        Product product;
        File request = new File(folder.getAbsolutePath() + "\\" + REQUEST_FILE_NAME);

        JAXBContext jaxbContext = null;
        try {

            jaxbContext = JAXBContext.newInstance(Product.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            product = (Product) unmarshaller.unmarshal(request);
            System.out.println(product);
            return product;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        XMLReader reader =  new XMLReader();
        List<File> fileList = reader.readFiles();
        List<Product> objectList = reader.getUnmarshelledList(fileList);
        System.out.println(objectList.size());

        for(Object obj : objectList)
        {
            System.out.println(obj);
        }
    }
}
