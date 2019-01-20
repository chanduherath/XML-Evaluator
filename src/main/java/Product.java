import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * Created by Chandu Herath on 19/1/2019.
 */
@XmlRootElement(name = "product")
//@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
//    @XmlAttribute(name = "id")
    private String productId;
//    @XmlElement(name = "description")
    private String description;
//    @XmlElement(name = "imageUrl")
    private String imageUrl;
//    @XmlElement(name = "price")
    private double price;
//    @XmlElement(name = "createdBy")
    private User createdBy;
    public Product(){}
    public Product(String productId, String description, String imageUrl,
                   double price, User createdBy) {
        this.productId = productId;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.createdBy = createdBy;
    }
    @Override
    public String toString() {
        return "Product{" +
                "\n productId='" + this.productId + '\'' +
                ",\n description='" + this.description + '\'' +
                ",\n imageUrl='" + this.imageUrl + '\'' +
                ",\n price=" + this.price +
                ",\n createdBy=" + this.createdBy +"\n"+
                '}';
    }

    @XmlAttribute(name = "id")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @XmlElement(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement(name = "imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @XmlElement(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @XmlElement(name = "createdBy")
    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}