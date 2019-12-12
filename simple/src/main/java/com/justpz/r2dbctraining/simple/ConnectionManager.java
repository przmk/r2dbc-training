package com.justpz.r2dbctraining.simple;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import java.util.HashMap;
import java.util.Map;

public class ConnectionManager {

  private static PostgresqlConnectionFactory postgresqlConnectionFactory;

  static {
    Map<String, String> options = new HashMap<>();
    options.put("lock_timeout", "10s");

    postgresqlConnectionFactory = new PostgresqlConnectionFactory(
        PostgresqlConnectionConfiguration.builder()
            .host("localhost")
            .port(5432)  // optional, defaults to 5432
            .username("admin")
            .password("admin")

            .database("r2dbc")  // optional
            .options(options) // optional
            .build());
  }

  public static PostgresqlConnectionFactory getPostgresqlConnectionFactory() {
    return postgresqlConnectionFactory;
  }
}
