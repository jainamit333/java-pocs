import com.amit.metric.MetricRegisteryInstance;
import com.codahale.metrics.MetricRegistry;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;
import org.hibernate.ejb.HibernatePersistence;
import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.cypher.Filters;
import org.neo4j.ogm.cypher.query.Pagination;
import org.neo4j.ogm.cypher.query.SortOrder;
import org.neo4j.ogm.model.Result;
import org.neo4j.ogm.session.GraphCallback;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

/**
 * Created by amit on 14/4/16.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.amit")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@EnableJpaRepositories("com.amit.repositories")
@EnableNeo4jRepositories("com.amit.neo.repositories")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableMetrics
@EnableKafka
public class ApplicationConfiguration extends MetricsConfigurerAdapter {

    private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
    private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";

    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
    private static final String PROPERTY_NAME_HIBERNATE_DDL = "hibernate.hbm2ddl.auto";

    private static final String TEST_TOPIC = "kafka-topic";
    private static final String OUTBOUND_ID = "outbound";


    @Resource
    private Environment environment;


    @Autowired
    MetricRegisteryInstance metricRegisteryInstance;


    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
        dataSource.setUrl(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
        dataSource.setUsername(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
        dataSource.setPassword(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
        entityManagerFactoryBean.setPackagesToScan(environment.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));

        entityManagerFactoryBean.setJpaProperties(hibProperties());

        return entityManagerFactoryBean;
    }

    private Properties hibProperties() {
        Properties properties = new Properties();
        properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
        properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
        properties.put(PROPERTY_NAME_HIBERNATE_DDL, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DDL));
        return properties;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }


    @Override
    public MetricRegistry getMetricRegistry() {
        return metricRegisteryInstance.getMetricRegistry();

    }




    @Override
    public void configureReporters(MetricRegistry metricRegistry) {

//        Graphite graphite = new Graphite(new InetSocketAddress("127.0.0.1", 2003));
//
//        GraphiteReporter reporter = GraphiteReporter.forRegistry(metricRegistry)
//                .prefixedWith("server1")
//                .convertRatesTo(TimeUnit.SECONDS)
//                .convertDurationsTo(TimeUnit.MILLISECONDS)
//                .filter(MetricFilter.ALL)
//                .build(graphite);
//        registerReporter(reporter).start(1, TimeUnit.SECONDS);

//
//        ConsoleReporter reporter =  ConsoleReporter
//                .forRegistry(metricRegistry)
//                .build();
//
//        registerReporter(reporter).start(5,TimeUnit.SECONDS);
//        LibratoReporter.enable(
//                LibratoReporter.builder(
//                        metricRegistry,
//                        "jainamit333@gmail.com",
//                        "66be71a4d1c8d65e8e2ce193caf387c2f29ba2d04d5740817f4ea38e802c8a2c",
//                        "localhost"), 10, TimeUnit.SECONDS);
//
    }
//
//    @Bean
//    SimpleKafkaListenerContainerFactory<Integer, String>
//    kafkaListenerContainerFactory() {
//        SimpleKafkaListenerContainerFactory<Integer, String> factory =
//                new SimpleKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }
//
//    @Bean
//    public ConsumerFactory<Integer, String> consumerFactory() {
//        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
//    }
//
//    @Bean
//    public Map<String, Object> consumerConfigs() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, "GROUP");
//        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
//        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
//        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
//                "org.apache.kafka.common.serialization.IntegerDeserializer");
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
//                "org.apache.kafka.common.serialization.StringDeserializer");
//
//        return props;
//    }
//
//
//
//    @Bean
//    public ProducerFactory<Integer, String> producerFactory() {
//        return new DefaultKafkaProducerFactory<>(producerConfigs());
//    }
//
//    @Bean
//    public Map<String, Object> producerConfigs() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        props.put(ProducerConfig.RETRIES_CONFIG, 0);
//        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
//        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
//        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
//                "org.apache.kafka.common.serialization.IntegerSerializer");
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
//                "org.apache.kafka.common.serialization.StringSerializer");
//
//        return props;
//    }
//
//    @Bean
//    public KafkaTemplate<Integer, String> kafkaTemplate() {
//        return new KafkaTemplate<Integer, String>(producerFactory());
//    }
//


    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Session getSession() throws Exception {
        return new Session() {
            @Override
            public <T> void delete(T t) {

            }

            @Override
            public <T> void deleteAll(Class<T> aClass) {

            }

            @Override
            public void purgeDatabase() {

            }

            @Override
            public void clear() {

            }

            @Override
            public <T> T queryForObject(Class<T> aClass, String s, Map<String, ?> map) {
                return null;
            }

            @Override
            public <T> Iterable<T> query(Class<T> aClass, String s, Map<String, ?> map) {
                return null;
            }

            @Override
            public Result query(String s, Map<String, ?> map) {
                return null;
            }

            @Override
            public Result query(String s, Map<String, ?> map, boolean b) {
                return null;
            }

            @Override
            public long countEntitiesOfType(Class<?> aClass) {
                return 0;
            }

            @Override
            public Long resolveGraphIdFor(Object o) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, Collection<Long> collection) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, Collection<Long> collection, int i) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, Collection<Long> collection, SortOrder sortOrder) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, Collection<Long> collection, SortOrder sortOrder, int i) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, Collection<Long> collection, Pagination pagination) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, Collection<Long> collection, Pagination pagination, int i) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, Collection<Long> collection, SortOrder sortOrder, Pagination pagination) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, Collection<Long> collection, SortOrder sortOrder, Pagination pagination, int i) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Collection<T> collection) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Collection<T> collection, int i) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Collection<T> collection, SortOrder sortOrder) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Collection<T> collection, SortOrder sortOrder, int i) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Collection<T> collection, Pagination pagination) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Collection<T> collection, Pagination pagination, int i) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Collection<T> collection, SortOrder sortOrder, Pagination pagination) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Collection<T> collection, SortOrder sortOrder, Pagination pagination, int i) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, int i) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, SortOrder sortOrder) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, SortOrder sortOrder, int i) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, Pagination pagination) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, Pagination pagination, int i) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, SortOrder sortOrder, Pagination pagination) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, SortOrder sortOrder, Pagination pagination, int i) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, Filter filter) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, Filter filter, int i) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, Filter filter, SortOrder sortOrder) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, Filter filter, SortOrder sortOrder, int i) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, Filter filter, Pagination pagination) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, Filter filter, Pagination pagination, int i) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, Filter filter, SortOrder sortOrder, Pagination pagination) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, Filter filter, SortOrder sortOrder, Pagination pagination, int i) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, Filters filters) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, Filters filters, int i) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, Filters filters, SortOrder sortOrder) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, Filters filters, SortOrder sortOrder, int i) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, Filters filters, Pagination pagination) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, Filters filters, Pagination pagination, int i) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, Filters filters, SortOrder sortOrder, Pagination pagination) {
                return null;
            }

            @Override
            public <T> Collection<T> loadAll(Class<T> aClass, Filters filters, SortOrder sortOrder, Pagination pagination, int i) {
                return null;
            }

            @Override
            public <T> T load(Class<T> aClass, Long aLong) {
                return null;
            }

            @Override
            public <T> T load(Class<T> aClass, Long aLong, int i) {
                return null;
            }

            @Override
            public <T> void save(T t) {

            }

            @Override
            public <T> void save(T t, int i) {

            }

            @Override
            public Transaction getTransaction() {
                return null;
            }

            @Override
            public Transaction beginTransaction() {
                return null;
            }

            @Override
            public <T> T doInTransaction(GraphCallback<T> graphCallback) {
                return null;
            }
        };
    }
}

