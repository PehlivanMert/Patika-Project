import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", columnDefinition = "serial")
    private int id;

    @Column(name = "product_name",nullable = false)
    private String name;

    @Column(name = "product_price",nullable = false)
    private double price;

    @Column(name = "product_stock")
    private int stock;

    @OneToOne(fetch = FetchType.LAZY)           //OneToOne İşlemi Joinleme bu taraftan yapılıyor mapleme diğer sınıftan
    @JoinColumn(name = "product_code_id",referencedColumnName = "code_id")
    private Code code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_supplier_id",referencedColumnName = "supplier_id")
    private Suppliers suppliers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id",referencedColumnName = "category_id")
    private Categories categories;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "pro2colors",
            joinColumns = {@JoinColumn(name = "pro2colors_product_id")},
            inverseJoinColumns = {@JoinColumn(name = "pro2colors_color_id")}
    )
    private List<Colors> colorsList;

    public Product() {
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public Suppliers getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Suppliers suppliers) {
        this.suppliers = suppliers;
    }

    public List<Colors> getColorsList() {
        return colorsList;
    }

    public void setColorsList(List<Colors> colorsList) {
        this.colorsList = colorsList;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", code=" + code +
                ", suppliers=" + suppliers +
                ", categories=" + categories +
                ", colorsList=" + colorsList +
                '}';
    }
}
