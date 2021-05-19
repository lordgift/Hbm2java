# Hbm2java
Hbm2java is used generate source via hibernate.reveng.xml.

![](https://img.shields.io/badge/Java-8-orange.svg?logo=java)

**Beware java version** if you use Java 11 its removed XML Parser that will make error occur.

---

To generate Hibernate Entity...
1. check your database driver in `build.gradle`
2. configure path or body of `hibernate.cfg.xml` and `hibernate.reveng.xml`
2. run `Hbm2JavaDemo.java`

---

`hibernate.cfg.xml` is configure to database.

`hibernate.reveng.xml` is type mapping of your tables and classes.
