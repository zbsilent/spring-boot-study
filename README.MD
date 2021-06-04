

# Spring Boot 2.X

## DOC

### _Spring Boot Base_

#### _0_、[_crate empty maven project_](https://baidu.com)

#### _1_、[_Create HelloWorld program_](https://docs.spring.io/spring-boot/docs/2.4.6/reference/html/getting-started.html#getting-started)

#### _2_、[POM](#POM)

- Parent

  ```xml
  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-dependencies</artifactId>
    <version>2.4.6</version>
   </parent>
  
  <properties>
    <activemq.version>5.16.2</activemq.version>
    <antlr2.version>2.7.7</antlr2.version>
    <appengine-sdk.version>1.9.88</appengine-sdk.version>
  	....
  </properties>
  ```

  > Spring Boot 版本仲裁
  >
  > 没有在<dependencies>中管理的依赖需要自行管理

- <a id="F0001">Other Starters</a>[^1]

  > 场景启动器导入 spring-boot-starter

#### 3、MAIN CLASS

- @<a id="F0002">SpringBootApplication</a>[^2]
    - @**SpringBootConfiguration**:标注为SpringBoot的配置类
        - @**Configuration：**Spring定义的配置类
    - <a id="F2091">@**EnableAutoConfiguration：**</a>开启自动配置功能
        - **@AutoConfigurationPackage：**自动配置包[^3]
            - *@Import({[Registrar.class](#F0003)})*给容器中引入组件
        - **@Import({<a id="F0004">[AutoConfigurationImportSelector.class](#F9982)})</a>[^4]：**将需要导入的组件以完全限定类名的方式导入
            - <a id="F0005">META-INF/spring.factories[^划重点]</a>:基本都在org.springframework.boot.autoconfigure包下

#### 4、[_Spring Initalizr_](https://spring.io/quickstart)

- resources file catalog

    - static：static resources
    - templates ：user freemarker,thymeleaf
    - Application.properties: springboot application config files



- @RestController

    - @Controller
    - @ResponseBody



#### _5_、SpringBoot configuration files

> Modifying configuration files

- application.properties
- application.yml
    -  `YML A Markup Language:是一个标记语言`
    -  `YML isn not Markup Language:不是一个标记语言`
    -  以数据为中心

- <a id =“F0006">Getting value from configuration files</a>
    - <a id="F0007">add dependency</a>
    - **@ConfigurationProperties(prefix =“person")**: 默认从全局配置文件中获取值
    - **@PropertySouce(vlue="classpath:person.properites")**:配合@Value("${name}”) 加载指定配置文件属性
    - **@ImportResouce**:导入srping的配置文件，让配置文件里的内容生效
        - 自己写的spring.xml 文件无法自动进来
        - *@ImportResource(locations = {"classpath:beans.xml”})*
- <a id="#F0008">JSR303 Validate</a>
    - <a id="F0008">add dependency</a>
    - @Validated
- <a id="F0009">Add SpringConfig</a>
    - <a id="F0011">Create MyAppConfig</a>
- Profiles Config
    - after start ,spring scan appliaction.properties or application.yml from project ,  used to Config
    - `file:./config/ `> `File:./`>`Classpath:/config/`>`Classpath:/`
    - spring.config.location设置
    - Server.servlet.context-path = /boot02 访问路径
    - **spring.config.location = /user/prop.properties**[^运维阶段使用]

#### 6、Auto Configuration

- [Flow](#F2091)
    - 启动即加载大量自动配置类
    - 有没有springboot默认写好的spring自动配置类
    - 我们在来看这个自动配置类到底配置了哪些组件（只要我们用的组件有，就不需要配置了）
    - 给容器中自动配置类添加组件时候，会从properties类中获取某些属性，我们可以在配置文件中指定这些属性的值
        - xxxAutonConfiguration 自动配置类
        - 给容器中添加组件 利用@Bean
        - 有对应的xxxProperties类
- [Conditional & 自动配置报告](#F8872A)
    - 指定条件成立，才给容器中添加Bean
    - 几乎自动配置类都是在一定条件下生效，即加载并非生效
    - `application.yml` 中配置 `debug=true` 即可启动 `自动配置报`



#### 7、SpringBoot Log File

- ~~JCL (Jakarta Commons Logging)~~

- SLF4J(Simple Logging Facade for Java)

- ~~Jboss-logging~~

    - Log4j
    - JUL
    - Log4j2(阿帕奇框架 跟Log4j关系不大)
    - Logback

  > 日志门面：SLF4J
  >
  > 日志实现：~~Log4j~~ Logback

- Spring框架默认使用JCL

- [SpringBoot选用SLF4J和LOGBACK](#F2891)

    - 不用调用实现类 ，调用抽象层方法即可
    - [官方手册](http://www.slf4j.org/manual.html)
    - [看图](#img001)

- [统一日志记录](#T00001)

    - 统一使用slf4j和logback实现
    - 将系统中其他日志框架先排除出去
    - 用中间包替换原有的日志框架
    - 我们导入slf4j其他的实现
    - [一定要移除掉框架默认日志依赖](#REMOVE01)

- [SpringBoot里日志](#log011)



####  8、<a>Spring&Docker</a>[^Docker]

---

Docker host : docker服务

Docker client : 链接docker主机进行操作

Docker Registy : 用于保存打包好的软件镜像

Docker Images : 用于创建docker容器的模版

Docker Container : 独立的一个或者一组应用

---

1. 安装docker

2. 找到镜像

    1. [docker search mysql ](https://hub.docker.com)
    2. docker pull mysql
    3. docker images 查看安装了哪些镜像
    4. docker rmi <IMAGE ID>

3. 运行镜像，生成容器

    1. docker run —name container-name -d image-name

       Eg:docker run —name myredis —d redis

       eg:<a>sudo docker run -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=123456 -d mysql:5.7</a>

        - –name：容器名，此处命名为`mysql`
        - -e：配置信息，此处配置mysql的root用户的登陆密码
        - -p：端口映射，此处映射 主机3306端口 到 容器的3306端口
        - -d：后台运行容器，保证在退出终端后容器继续运行

    2. docker ps (查看运行中的容器)

    3. docker container ls 查看容器运行状态

       eg: <a>sudo docker exec -it mysql bash</a>

       ​		<a>mysql -uroot -p123456</a>

    4. docker stop container-name/container-id

    5. docker start container-name/container-id

    6. docker rm container-id

    7. -p 6379:6379

       eg:docker run -d -p  6379:6379 —name myredis docker.io/reids

    8. docker logs container-name/container-id

4. 软件的启停





#### 9、JDBC

---

- [yml配置](#Y0001)
- 自动生成创建脚本
    - 默认规则: schema.sql,schema-all.sql
    - [可用规则](#Y0001)
- 操作数据库
    - <a>JdbcTemplate jdbcTemplate</a> 操作数据库

---

##### 9.1 [整合druid数据源](https://github.com/alibaba/druid/tree/master/druid-spring-boot-starter)

>**强烈注意**：Spring Boot 2.X 版本不再支持配置继承，多数据源的话每个数据源的所有配置都需要单独配置，否则配置不会生效



> 2.x 默认不需要创建 直接配置文件即可

- 创建数据源需要采用[**1**](#C0009)
- Druid监控配置













## CODE

#### _1_、[SpringBootApplication Annotation](#F0002)

```Java
@SpringBootConfiguration
@EnableAutoConfiguration
public @interface SpringBootApplication
```

#### _2_、<a id="F0003">Registrar.class</a>

```java
static class Registrar implements ImportBeanDefinitionRegistrar, DeterminableImports {
        Registrar() {
        }

        public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
            AutoConfigurationPackages.register(registry, (String[])(new AutoConfigurationPackages.PackageImports(metadata)).getPackageNames().toArray(new String[0]));
        }

        public Set<Object> determineImports(AnnotationMetadata metadata) {
            return Collections.singleton(new AutoConfigurationPackages.PackageImports(metadata));
        }
    }
```

#### _3_、 <a id="F9982">AutoConfigurationImportSelector.class</a>

```java
List<String> configurations = getCandidateConfigurations(annotationMetadata, attributes);
protected List<String> getCandidateConfigurations(AnnotationMetadata metadata, AnnotationAttributes attributes) {
		List<String> configurations = SpringFactoriesLoader.loadFactoryNames(getSpringFactoriesLoaderFactoryClass(),
				getBeanClassLoader());
		Assert.notEmpty(configurations, "No auto configuration classes found in META-INF/spring.factories. If you "
				+ "are using a custom packaging, make sure that file is correct.");
		return configurations;
	}

/* spring 扫描 META-INF/spring.factories 里的配置文件
   将扫描到的jar包的类路径包装成Properties对象
   从properties中获取到EnableAtuonConfiguration.class（classsName）类的值，添加到容器中
   每一个自动配置类进行自动配置功能*/
```

> HTTP编码自动配置

```java
@Configuration(proxyBeanMethods = false)
//启动ServerProperties类
//将配置文件中的值和ServerProperties对应起来了
@EnableConfigurationProperties({ServerProperties.class}) 
//如果满足什么条件才生效 当前应用是否是web应用 是 当前配置类生效
@ConditionalOnWebApplication(type = Type.SERVLET)
//如果满足什么条件才生效 判断当前项目有没有这个类 乱码解决过滤器
@ConditionalOnClass({CharacterEncodingFilter.class})
//配置文件是否存在以下属性 即使配置文件中不配置 server.servlet.encoding.enabled=true,也是默认生效
@ConditionalOnProperty(
    prefix = "server.servlet.encoding",
    value = {"enabled"},
    matchIfMissing = true
)
public class HttpEncodingAutoConfiguration {
    private final Encoding properties;

  //只有一个有惨构造器的情况下 只去从容器中拿
  public HttpEncodingAutoConfiguration(ServerProperties properties) {
      this.properties = properties.getServlet().getEncoding();
  }

 	//给容器中添加组件
  @Bean
  @ConditionalOnMissingBean
  public CharacterEncodingFilter characterEncodingFilter() {
    CharacterEncodingFilter filter = new OrderedCharacterEncodingFilter();
   	//server.servlet.encoding.charset=utf-8
		filter.setEncoding(this.properties.getCharset().name());
    //我们能配置的属性都是来源于这个功能的properti类
	 	filter.setForceRequestEncoding(this.properties.shouldForce（Type.REQUEST));
    filter.setForceResponseEncoding(this.properties.shouldForce(Type.RESPONSE));
    return filter;
   }
  }
}
}

```

> 所有配置文件中能配置的属性都是在XXXXProperties文件中封装着

```java
@ConfigurationProperties(
    prefix = "server",
    ignoreUnknownFields = true
)
public class ServerProperties {
    private Integer port;
    private InetAddress address;
    @NestedConfigurationProperty
    private final ErrorProperties error = new ErrorProperties();
    private ServerProperties.ForwardHeadersStrategy forwardHeadersStrategy;
    private String serverHeader;
    private DataSize maxHttpHeaderSize = DataSize.ofKilobytes(8L);
    private Shutdown shutdown;
    @NestedConfigurationProperty
    private Ssl ssl;
    @NestedConfigurationProperty
    private final Compression compression;
    @NestedConfigurationProperty
    private final Http2 http2;
    private final ServerProperties.Servlet servlet;
    private final ServerProperties.Tomcat tomcat;
    private final ServerProperties.Jetty jetty;
    private final ServerProperties.Netty netty;
    private final ServerProperties.Undertow undertow;
```



#### _4_、 [Get Value from Configuration Files](#F0007)

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>
```

5、[JSR303 Validate](#F0008)

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

<dependency>
   <groupId>jakarta.validation</groupId>
   <artifactId>jakarta.validation-api</artifactId>
   <version>2.0.2</version>
</dependency>
```

6、[Add SpringConfig](#F0011)

```java
package com.srpingsut.quick;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MyAppConfig {
    /** 将方法返回值添加到容器中 id就是方法名*/
    @Bean
    public HelloService helloService(){
        return new HelloService();
    }
}

```

#### 7、<a id="log011">_日志_</a>

```java
Logger logger = LoggerFactory.getLogger(getClass());
logger.trace("跟踪信息");
logger.debug("调试信息");
logger.info("基础信息");
logger.warn("警告信息");
logger.error("错误信息");
```

```properties
#扫描com.springstudy包下
logging.level.com.springstudy=trace
logging.file.name=spring.log
logging.file.path=/user/logger
```



9、<a id="Y0001">JDBC相关代码配置</a>

```yml
server:
  port: 8084
spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/mysql
    username: root
    password: 123456
    driver-class-name: com.mysql.cj.jdbc.Driver
    # 自动建表配置
    initialization-mode: always
    # schema: schema-all.sql
    schema: classpath:schema-all.sql
```

#### 10、<a id='C0009'>crate</a>

```java
@Bean
@ConfigurationProperties("spring.datasource.druid.two")
public DataSource dataSourceTwo(){
    return DruidDataSourceBuilder.create().build();
}
```

- 开启监控的内容

```xml
# WebStatFilter配置，说明请参考Druid Wiki，配置_配置WebStatFilter
spring.datasource.druid.web-stat-filter.enabled= #是否启用StatFilter默认值false
spring.datasource.druid.web-stat-filter.url-pattern=
spring.datasource.druid.web-stat-filter.exclusions=
spring.datasource.druid.web-stat-filter.session-stat-enable=
spring.datasource.druid.web-stat-filter.session-stat-max-count=
spring.datasource.druid.web-stat-filter.principal-session-name=
spring.datasource.druid.web-stat-filter.principal-cookie-name=
spring.datasource.druid.web-stat-filter.profile-enable=

# StatViewServlet配置，说明请参考Druid Wiki，配置_StatViewServlet配置
spring.datasource.druid.stat-view-servlet.enabled= #是否启用StatViewServlet（监控页面）默认值为false（考虑到安全问题默认并未启动，如需启用建议设置密码或白名单以保障安全）
spring.datasource.druid.stat-view-servlet.url-pattern=
spring.datasource.druid.stat-view-servlet.reset-enable=
spring.datasource.druid.stat-view-servlet.login-username=
spring.datasource.druid.stat-view-servlet.login-password=
spring.datasource.druid.stat-view-servlet.allow=
spring.datasource.druid.stat-view-servlet.deny=

# Spring监控配置，说明请参考Druid Github Wiki，配置_Druid和Spring关联监控配置
spring.datasource.druid.aop-patterns= # Spring监控AOP切入点，如x.y.z.service.*,配置多个英文逗号分隔

```



#### ce



---



## IMAGE

<a id="img001">日志实现</a>

![click to enlarge](http://www.slf4j.org/images/concrete-bindings.png)

<a id="T00001">同一日志</a>

![click to enlarge](http://www.slf4j.org/images/legacy.png)

## Reference

[^1]: `spring-boot-starter`为开头且包下的其他组件  例如： `spring-boot-starter` `spring-boot-starter-activemq `,`spring-boot-starter-amqp`,` spring-boot-starter-aop`
[^2]: 该注解标注的类，SpringBoot则运行该类的main()启动springboot应用
[^3]: 将主配置类标注类所在包及以下所有包扫描到spring容器中
[^4]: `org.springframework.boot.autoconfigure`.??.`??AutoConfiguration`包下的自动配置类
[^划重点]: 重要的配置文件路径，spring boot 在启动的时候从类路径下的META-INF/spring.factories中获取EnableAutoConfiguration指定的值，并将这些值作为自动配置类导入到容器中，自动配置类生效，帮我们进行自动配置工作
[^运维阶段使用]: 项目打包后可以使用命令行参数的形式，在启动项目的时候指定配置文件的新位置 ，_` java -jar  xxxx.jar --spring.config.loaction=/user/prop.properties` 运行文件_

[^Docker]: 开运的应用容器引擎，启动非常快，基于GO语言，Apache2.0开源协议



























---

​																																														_study by zbsilent@gmail.com_

 