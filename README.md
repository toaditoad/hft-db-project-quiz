## hft-db-project-quiz

### environment

- Eclipse Mars.2 Release (4.5.2)
- Wildfly 9.0.2 Final
- MySQL 5.7.9
- MySQL Connector 5.1.38 (JDBC Driver)

### toDos

- "play game" shows all categories where one has to be selected
- "statistics" that shows a list of all categories (# of qns, # of correctly answered qns) (with triggers!)
- documentation

### database related

```
CREATE OR REPLACE VIEW vhighscore
AS (SELECT s.id, s.categoryId, c.categoryName, s.name, s.score, s.scoreDate,
		(SELECT 1 + COUNT(*)
			FROM score s2
			WHERE s2.score > s.score
			) AS ranking
	FROM SCORE s, CATEGORY c
	WHERE s.categoryId = c.id
	ORDER BY ranking ASC, s.scoreDate DESC
	LIMIT 10);
```

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