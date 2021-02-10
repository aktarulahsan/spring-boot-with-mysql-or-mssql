# spring-boot-with-mysql-or-mssql
spring boot with jwt, oauth2, with mysql or mssql  restfull api



when you want to use mysql use application.yml with in pom.xml
<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.9</version>
		</dependency>





and when you want to use MSSql  use application.properties  with   in pom.xml
<dependency>
			<groupId>com.microsoft.sqlserver</groupId>
			<artifactId>mssql-jdbc</artifactId>
			<scope>runtime</scope>
		</dependency>
