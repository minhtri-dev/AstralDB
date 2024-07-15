// package com.example.warptracker.config;

// import javax.sql.DataSource;
// import org.flywaydb.core.Flyway;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Primary;

// @Configuration
// public class FlywayConfig {

//     @Primary
//     @Bean(name = "primaryFlyway")
//     @FlywayDataSource
//     public Flyway primaryFlyway(@Qualifier("primaryDataSource") DataSource primaryDataSource) {
//         Flyway flyway = Flyway.configure()
//                 .dataSource(primaryDataSource)
//                 .locations("classpath:db/migration/primary")
//                 .load();
//         flyway.migrate(); // Explicitly call migrate
//         return flyway;
//     }

//     @Bean(name = "secondaryFlyway")
//     @FlywayDataSource
//     public Flyway secondaryFlyway(@Qualifier("secondaryDataSource") DataSource secondaryDataSource) {
//         Flyway flyway = Flyway.configure()
//                 .dataSource(secondaryDataSource)
//                 .locations("classpath:db/migration/secondary")
//                 .load();
//         flyway.migrate(); // Explicitly call migrate
//         return flyway;
//     }
// }
