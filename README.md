## hft-db-project-quiz

### environment

- Eclipse Mars.2 Release (4.5.2)
- Wildfly 9.0.2 Final
- MySQL 5.7.9
- MySQL Connector 5.1.38 (JDBC Driver)

### setting up JDBC connection with JDNI name in application server

##### .../wildfly-9.0.2.Final/standalone/configuration/standalone.xml

in `<datasources>` of `<subsystem xmlns="urn:jboss:domain:datasources:3.0">`
```
<datasource jndi-name="java:jboss/datasources/HftDbProjectQuiz" pool-name="HftDbProjectQuiz" enabled="true" use-java-context="true">
    <connection-url>jdbc:mysql://localhost:3306/hft_db_project_quiz</connection-url>
    <driver>mysql</driver>
    <security>
        <user-name>root</user-name>
        <password>root</password>
    </security>
</datasource>
```

in `<drivers>` of `<subsystem xmlns="urn:jboss:domain:datasources:3.0">`
```
<driver name="mysql" module="com.mysql.driver">
    <xa-datasource-class>com.mysql.jdbc.Driver</xa-datasource-class>
</driver>
```
##### .../wildfly-9.0.2.Final/modules/system/layers/base/com/mysql/driver/main

create `module.xml` file with following content:
```
<?xml version="1.0" encoding="UTF-8"?>
<module xmlns="urn:jboss:module:1.3" name="com.mysql.driver">
 <resources>
  <resource-root path="mysql-connector-java-5.1.38-bin.jar" />
 </resources>
 <dependencies>
  <module name="javax.api"/>
  <module name="javax.transaction.api"/>
 </dependencies>
</module>
```
copy `mysql-connector-java-5.1.38-bin.jar` connection library to this location