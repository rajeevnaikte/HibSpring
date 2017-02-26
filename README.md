# HibSpring
Provider of dependencies needed to develop java application using maven profiles

This project has common code needed to start with any Java project using Hibernate and Spring. This can be used for both standalone as well web-applications.

In your project pom simply include this. (Note: this is not available in maven central. you will need to download this project and do mvn install)<br/>
&lt;parent&gt;<br/>
&nbsp;&nbsp;&lt;groupId&gt;com.naik&lt;/groupId&gt;<br/>
&nbsp;&nbsp;&lt;artifactId&gt;hibspring&lt;/artifactId&gt;<br/>
&nbsp;&nbsp;&lt;version&gt;5.5&lt;/version&gt;<br/>
&lt;/parent&gt;<br/>

Once you inlcude this pom as parent for your project, you will get many profiles to choose.
<br/>Profiles available:
<ul>
  <li>HibSpring-core</li>
  <li>json-tools</li>
  <li>mysql-db</li>
  <li>oracle-db</li>
  <li>spring-webmvc</li>
  <li>envers</li>
  <li>spring-boot-web</li>
  <li>spring-boot-soap-ws</li>
</ul>

HibSpring-core module has the class CustomHibernateDaoSupport.class which can be used to perform entity save, update, delete with database.
Simply create a class variable of this and put @AutoWired and you will get all the APIs needed to interact with database.

Give your packages (comma separated) to scan by spring with VM-argument/System-variable - key is scan.packages

To give DB connection details and Entity classes for Hibernate, simply create config.properties and put in classpath. This file can have below properties.
<br/>
jdbc.driverClassName=oracle.jdbc.OracleDriver<br/>
jdbc.url=jdbc:oracle:thin:naik_hibspring/root@localhost:1521:xe<br/>
jdbc.username=naik_hibspring<br/>
jdbc.password=root<br/>
<br/>
\#Hibernate configs<br/>
hibernate.dialect=org.hibernate.dialect.Oracle10gDialect<br/>
hibernate.show_sql=true<br/>
hibernate.hbm2ddl.auto=create<br/>
<br/>
\#Comma separated fully qualified class names which are annotated with @Entity<br/>
annotated.classes=<br/>
<br/>
#Supported versions
This project has support for
<ul>
  <li>Hibernate4+Spring4 in v4.4 (branch Hib4Spring4-4.4)</li>
  <li>Hibernate5+Spring5 in v5.5 (branch master)</li>
</ul>
