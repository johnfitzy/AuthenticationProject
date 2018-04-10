package ws.repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.sql.DataSource;
import org.jdbi.v3.core.Jdbi;


@Named
@ApplicationScoped
public class JDBIProducer {


    @Resource(mappedName = "java:/MariaDB")
    private DataSource dataSource;
    private Jdbi jdbi;

    @PostConstruct
    public void init() {
        jdbi = Jdbi.create(dataSource);
    }

    public Jdbi getJdbi() {
        return jdbi;
    }
}
