package com.product_hibernate;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.*;

import org.junit.jupiter.api.*;

import com.product.Product;
import com.product.ProductDao;

public class ProductDaoTest {

    static EntityManagerFactory emf;
    static EntityManager em;

    @BeforeAll
    static void initEmf() {
        emf = Persistence.createEntityManagerFactory("postgres");
    }

    @BeforeEach
    void initEm() {
        em = emf.createEntityManager();
    }

    @Test
    void insertProductTest() {
        ProductDao dao = new ProductDao();

        Product product = new Product();
        product.setId(11);
        product.setName("Redmi");
        product.setQuantity(5);
        product.setPrice(1000);

        String result = dao.insertProduct(product);
        assertEquals("Data Inserted", result);
    }

    @Test
    void insertProductTestNull() {
        ProductDao dao = new ProductDao();
        assertEquals("Illegal Argument",
                dao.insertProduct(null));
    }

    @Test
    void findByIdTest() {
        ProductDao dao = new ProductDao();

        Product p = new Product();
        p.setId(20);
        p.setName("Test");
        p.setQuantity(2);
        p.setPrice(500);

        dao.insertProduct(p);

        Product found = dao.findById(20);
        assertNotNull(found);
    }

    @Test
    void findByIdExceptionTest() {
        ProductDao dao = new ProductDao();

        assertThrows(IllegalArgumentException.class,
                () -> dao.findById(999));
    }

    @AfterAll
    static void close() {
        emf.close();
    }
}
