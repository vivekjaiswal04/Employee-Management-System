package hibernateUtil;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.app.model.Employee;


/**
 * HibernateUtil class provides a centralized configuration for creating and
 * accessing a Hibernate SessionFactory.
 *
 * This class uses programmatic configuration (no hibernate.cfg.xml)
 * and registers entity classes dynamically.
 */
public class HibernateUtil {

    // --- Static instance variables ---
    private static SessionFactory sf;
    private static StandardServiceRegistry registry;

    /**
     * Returns a singleton SessionFactory instance.
     * If the factory is not yet created, it will initialize it with
     * database connection and Hibernate configuration properties.
     *
     * @return SessionFactory instance
     */
    public static SessionFactory getSessionFactory() {

        try {
            if (sf == null) {

                // ---------------------------------
                // Step 1: Define connection properties
                // ---------------------------------
                Map<String, Object> map = new HashMap<>();

                // --- JDBC connection properties ---
                map.put(Environment.JAKARTA_JDBC_DRIVER, "com.mysql.cj.jdbc.Driver");
                map.put(Environment.JAKARTA_JDBC_URL, "jdbc:mysql://localhost:3306/stu");
                map.put(Environment.JAKARTA_JDBC_USER, "root");
                map.put(Environment.JAKARTA_JDBC_PASSWORD, "Asus@123");

                // ---------------------------------
                // Step 2: Hibernate core properties
                // ---------------------------------
                map.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect"); // MySQL dialect
                map.put(Environment.HBM2DDL_AUTO, "update"); // auto update DB schema
                map.put(Environment.SHOW_SQL, "true"); // show SQL queries in console

                // ---------------------------------
                // Step 3: Enable Second-Level Cache
                // ---------------------------------
                map.put(Environment.USE_SECOND_LEVEL_CACHE, "true");
                map.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.jcache.JCacheRegionFactory");
                map.put("hibernate.javax.cache.provider", "org.ehcache.jsr107.EhcacheCachingProvider");

                // ---------------------------------
                // Step 4: Build Service Registry
                // ---------------------------------
                registry = new StandardServiceRegistryBuilder()
                        .applySettings(map)
                        .build();

                // ---------------------------------
                // Step 5: Add annotated entity classes
                // ---------------------------------
                MetadataSources mds = new MetadataSources(registry);
               
                mds.addAnnotatedClass(Employee.class);

                // ---------------------------------
                // Step 6: Build Metadata and SessionFactory
                // ---------------------------------
                Metadata md = mds.getMetadataBuilder().build();
                sf = md.getSessionFactoryBuilder().build();

                System.out.println("✅ Hibernate SessionFactory created successfully!");
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ Error while creating Hibernate SessionFactory!");
        }

        return sf;
    }
}
