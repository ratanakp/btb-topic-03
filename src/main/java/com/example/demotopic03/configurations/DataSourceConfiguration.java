package com.example.demotopic03.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    @Bean("dataSource")
    @Profile("pgsql")
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/btb_class");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("root");

        return driverManagerDataSource;
    }


    @Bean("dataSource")
    @Profile("h2")
    public DataSource inMemoryDB() {

        EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder();

        databaseBuilder.addScript("db/schema.sql");
        databaseBuilder.addScript("db/data.sql");

        databaseBuilder.setType(EmbeddedDatabaseType.H2);

        return databaseBuilder.build();

    }



}
