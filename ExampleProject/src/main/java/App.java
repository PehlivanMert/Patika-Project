import jakarta.persistence.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("market");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();//Önce Factory sonra Manager oluştur.


        //ManyToMany İlişkisi
        /*transaction.begin();

        Colors blue = new Colors("blue");
        Colors red = new Colors("red");
        Colors green = new Colors("green");

        entityManager.persist(blue);
        entityManager.persist(red);
        entityManager.persist(green);


        Categories categories = new Categories();
        categories.setName("Telefonlar");
        entityManager.persist(categories);

        Suppliers suppliers = new Suppliers();
        suppliers.setAddress("Merzifon");
        suppliers.setCompany("Happy");
        suppliers.setContact("56565656");
        suppliers.setMail("@gmail.com");
        suppliers.setPerson("Mert P");

        entityManager.persist(suppliers);


        Code code = new Code();
        code.setGroup("55122441");
        code.setSerial("548796");

        entityManager.persist(code);

        Product product = new Product();

        product.setName("14 Pro Max");
        product.setPrice(85000);
        product.setStock(100);
        product.setCode(code);
        product.setSuppliers(suppliers);
        product.setCategories(categories);
        entityManager.persist(product);
        System.out.println(product.toString());

        Code code1 = new Code();
        code1.setGroup("55231");
        code1.setSerial("52326");
        entityManager.persist(code1);

        Product product1 = new Product();
        product1.setName("Samsung S24");
        product1.setPrice(75000);
        product1.setStock(100);
        product1.setCode(code1);
        product1.setSuppliers(suppliers);
        product1.setCategories(categories);

        List<Colors> colorsList = new ArrayList<>();
        colorsList.add(blue);
        colorsList.add(red);
        colorsList.add(green);

        product1.setColorsList(colorsList);
        product.setColorsList(colorsList);

        entityManager.persist(product1);

        Product product = entityManager.find(Product.class,1);
        System.out.println(product.getColorsList().toString());

        Colors colors = entityManager.find(Colors.class,1);
        System.out.println(colors.getProductList().toString());

        transaction.commit();*/

        //ManyToOne - OneToMany ilişkisi
        /*   transaction.begin();
        //Category
        Categories categories = new Categories();
        categories.setName("Telefonlar");
        entityManager.persist(categories);

        Suppliers suppliers = new Suppliers();
        suppliers.setAddress("Merzifon");
        suppliers.setCompany("Happy");
        suppliers.setContact("56565656");
        suppliers.setMail("@gmail.com");
        suppliers.setPerson("Mert P");

        entityManager.persist(suppliers);


        Code code = new Code();
        code.setGroup("55122441");
        code.setSerial("548796");

        entityManager.persist(code);

        Product product = new Product();

        product.setName("14 Pro Max");
        product.setPrice(85000);
        product.setStock(100);
        product.setCode(code);
        product.setSuppliers(suppliers);
        product.setCategories(categories);
        entityManager.persist(product);
        System.out.println(product.toString());

        Code code1 = new Code();
        code1.setGroup("55231");
        code1.setSerial("52326");
        entityManager.persist(code1);

        // Suppliers suppliers = entityManager.find(Suppliers.class,1);

        Product product1 = new Product();
        product1.setName("Samsung S24");
        product1.setPrice(75000);
        product1.setStock(100);
        product1.setCode(code1);
        product1.setSuppliers(suppliers);
        product1.setCategories(categories);
        entityManager.persist(product1);
        System.out.println(product1.toString());

        Suppliers suppliers = entityManager.find(Suppliers.class, 1);
        for (Product product : suppliers.getProductList()) {    // Suppliers a ait ürünleri yazdırdık
            System.out.println(product1.toString());
        }


        transaction.commit();*/

        //One To One İlişki Örneği
        /*transaction.begin();
        Code code = new Code();
        code.setGroup("55122441");
        code.setSerial("548796");

        entityManager.persist(code);

        Product product = new Product();

        product.setName("14 Pro Max");
        product.setPrice(85000);
        product.setStock(100);
        product.setCode(code);

        entityManager.persist(product);

        System.out.println(product.toString());

        Product product = entityManager.find(Product.class,1);
        System.out.println(product.toString());


        Code code = entityManager.find(Code.class,1);
        System.out.println(code.getProduct().toString());


        transaction.commit();  */

        //İlk Eğitim
        /*entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();                         İstersen böyle de transaction oluşturabilirsin.*/

        //CRUD - Insert (Create) - Read - Update - Delete

        /*Customer c1 = new Customer();
        c1.setName("Rabia");
        c1.setMail("pehlivan@cagli.com");
        c1.setGender(Customer.GENDER.FEMALE);                            Veri Tabanına Ekleme - Create
        c1.setOnDate(LocalDate.now());

        transaction.begin();
        entityManager.persist(c1);
        transaction.commit();*/

        /*Customer customer = entityManager.find(Customer.class,1);      En basit veri çekme yöntemi  - Read
        System.out.println(customer.toString());*/

        /*transaction.begin();
        Customer customer = entityManager.find(Customer.class, 1);
        customer.setName("Mert Pehlivan");
                                                                         Update İşlemi  - Update
        entityManager.persist(customer);
        transaction.commit();*/

        /*transaction.begin();
        Customer customer = entityManager.find(Customer.class,2);
        entityManager.remove(customer);                                  Silme İşlemi  - Delete
        transaction.commit();*/

        /*Fetch İşlemleri

        İhtiyaç oldukça join yapması için Fetch Lazy seçiyoruz.
        Her zaman kullanacaksak eager kalması daha iyi olur.

        Performansı etkiliyor çünkü.

        */

        /*Cascade Türleri

        * PERSIST  --> Nesne  persist edilirse alt nesne de persist edilir --> Örnek : @OneToOne(cascade = CascadeType.PERSIST)
        * MERGE    --> Nesne Merge edilirse alt nesne de merge edilir.
        * REMOVE   --> Nesne silinirse alt nesne de silinir.
        * REFRESH  --> Nesne yenilenirse alt nesne de yenilenir.
        * ALL      --> Tüm işlemler birlikte yapılır.

        */

    }
}
