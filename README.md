# springcloud
springcloud使用示例、springcloud源码阅读

[TOC]

# Spring Cloud入门

## 分布式技术图谱
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210606093233166.png)
## Spring Cloud简介
### 官网介绍
* 打开 Spring 官网 http://spring.io 首页的中部，可以看到 Spring Cloud 的简介。
* 【原文】Building distributed systems doesn't need to be complex and error-prone(易错). Spring Cloud offers a simple and accessible(易接受的) programming model to the most common distributed system patterns(模式), helping developers build resilient(有弹性的), reliable(可靠的), and coordinated(协调的) applications. Spring Cloud is built on top of Spring Boot, making it easy for developers to get started and become productive quickly.
* 【翻译】构建分布式系统不需要复杂和容易出错。Spring Cloud 为最常见的分布式系统模式提供了一种简单且易于接受的编程模型，帮助开发人员构建有弹性的、可靠的、协调的应用程序。Spring Cloud 构建于 Spring Boot 之上，使得开发者很容易入手并快速应用于生产中。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210606094020917.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
### 百度百科
- Spring Cloud 是一系列框架的有序集合。它利用 Spring Boot 的开发便利性巧妙地简化了分布式系统基础设施的开发，如**服务发现注册、配置中心、消息总线、负载均衡、断路器、数据监控**等，都可以用 Spring Boot 的开发风格做到一键启动和部署。Spring Cloud 并没有重复制造轮子，它只是将目前各家公司开发的比较成熟、经得起实际考验的服务框架组合起来，通过 Spring Boot 风格进行再封装屏蔽掉了复杂的配置和实现原理，最终给开发者提供了一套简单易懂、易部署和易维护的分布式系统开发工具包。
### 总结
> Spring Cloud 是什么?
* 阿里高级框架师、Dubbo 项目的负责人刘军说，Spring Cloud 是微服务系统架构的一站式解决方案。
> Spring Cloud 与 Spring Boot 是什么关系呢?
* Spring Boot 为 Spring Cloud 提供了代码实现环境，使用 Spring Boot 将其它组件有机融合到了 Spring Cloud 的体系架构中了。所以说，Spring Cloud 是基于 Spring Boot 的、微服务系统架构的一站式解决方案。
## Spring Cloud的国内使用情况
- 在 Spring Cloud 中国社区博客中可以看到 Spring Cloud 在国内的使用情况。
- [http://blog.springcloud.cn/about/](http://blog.springcloud.cn/about/)
## Spring Cloud在线资源
* Spring Cloud官网：[https://projects.spring.io/spring-cloud/](https://projects.spring.io/spring-cloud/)
* Spring Cloud中文网：[https://springcloud.cc/](https://springcloud.cc/)
* Spring Cloud中国社区：[http://springcloud.cn/](http://springcloud.cn/)

## Spring Cloud版本

### 版本号来源
- Spring Cloud 的版本号并不是我们通常见的数字版本号，而是一些很奇怪的单词。这些单词均为**英国伦敦地铁站的站名**。同时根据字母表的顺序来对应版本时间顺序，比如：最早的 Release 版本 Angel(天使)，第二个 Release 版本 Brixton(英国地名)，然后是 Camden、Dalston、Edgware，目前使用较多的是 Finchley(英国地名)版本，而最新版本为 Hoxton(英国地名)，而我们这里要使用的是 Greenwich(格林威治)。国内为了沟通的简单，我们一般称 Finchley 版本为 F 版本，Greenwich 版本为 G 版等。
- Spring Cloud 的一个大版本在不同的阶段会发布不同类型的小版本号。按照发行的顺序，一般会存在这些版本，但并不一定每个大版本都存在这些小版本。当然，这些小版本后一般还会添加上数字作为其内部的版本。
  - **SNAPSHOT**：快照版，可以使用，但其仍处于连续不断的开发改进中，不建议使用。
  - **M版**：Milestone，里程碑版，其会标注上 **PRE**——preview，预览版，内测版，不建议使用。
  - **RC版**：Release Candidate，发行候选版本，主要用于修复Bug，一般该版本中不会再添加大的功能修改了。是正式发行前的版本。
  - **SR版**：Service Release，服务发布版，正式发行版。一般还会被标注上**GA**——General Availability，则表示这是当前广泛使用的版本。
  - **CURRENT**：表示官方当前推荐版本。
### Spring Cloud与Spring Boot版本
- 某一版本的 Spring Cloud 要求必须要运行在某一特定 Spring Boot 版本下。它们的对应关系在 Spring Cloud 官网首页最下面可以看到版本对应说明。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210606095129625.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
## Spring Cloud与Dubbo技术选型
Spring Cloud 与 Dubbo 均为微服务框架，开发团队在进行技术选型时，总会将它们进行对比，考虑应该选择哪一个。可以从以下几方面考虑：
* 架构完整度：Dubbo仅提供了服务注册与服务治理两个模块，需要其他功能，需求进行整合；Spring Cloud更加完整
* 社区活跃度：Spring Cloud全世界都在用，资料很多是英语；Dubbo主要是国内在用，且资料都是中文。
* 通讯协议：Dubbo是RPC框架，底层使用Netty，RPC 对业务接口具有强依赖性；Spring Cloud——HTTP REST，Spring Cloud gRPC。Spring Cloud Dubbo方向。
* 技术改造与微服务开发：Dubbo适合做技术改造，新的微服务开发一般选 Spring Cloud。

## SpringCloud演示项目框架搭建
- 源码github地址：[https://github.com/shouwangyw/springcloud](https://github.com/shouwangyw/springcloud)
- 项目工程名：springcloud-example-parent
- 使用的 Spring Cloud 版本为 Hoxton.SR1，主要依赖：
```xml
<modelVersion>4.0.0</modelVersion>
<parent>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-parent</artifactId>
  <version>2.2.2.RELEASE</version>
  <relativePath/>
</parent>

<groupId>com.yw.springcloud.example</groupId>
<artifactId>springcloud-example-parent</artifactId>
<version>1.0</version>
<packaging>pom</packaging>

<properties>
  <java.version>1.8</java.version>
  <spring-cloud.version>Hoxton.SR1</spring-cloud.version>
</properties>

<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-dependencies</artifactId>
      <version>${spring-cloud.version}</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
    <!-- MySQL驱动版本 -->
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>5.1.47</version>
    </dependency>
    <!-- 数据源 -->
    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>druid</artifactId>
      <version>1.1.10</version>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
  </dependency>
</dependencies>
```
### 创建公共模块 00-common
- 依赖：使用 Spring Data JPA 作为持久层技术
```java
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```
- 分别创建实体类、repository接口和service接口：
```java
@Data
@Accessors(chain = true)
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "fieldHandler"})
// JPA的默认实现是hibernate，而 hibernate 默认对于对象的查询是基于延迟加载的
// 例如 Depart depart = service.findById(5); 这里的depart实际是一个javasist冬天代理对象
// 只有当真正使用到depart里面的属性时，才会真正的执行查询
public class Depart {
    /**
     * @Id 表示当前属性映射到表中为主键
     * @GeneratedValue 主键是自动递增的
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}
/**
 * JpaRepository<Depart, Integer>
 *     第一个泛型：当前Repository的操作对象类型
 *     第二个泛型：当前Repository的操作对象的id类型
 */
public interface DepartRepository extends JpaRepository<Depart, Integer> {
}
public interface DepartService {
    boolean saveOne(Depart depart);
    boolean deleteById(int id);
    boolean updateOne(Depart depart);
    Depart getDepartById(int id);
    List<Depart> listDeparts();
}
```
### 创建提供者工程 01-provider-8090
- 该工程是一个单纯的 Spring Boot 工程，还并未使用到 Spring Cloud，但其为后续 Spring Cloud 的运行测试环境。
- 依赖：00-common公共模块、MySQL驱动和druid连接池
```xml
<dependency>
  <groupId>com.yw.springcloud.example</groupId>
  <artifactId>00-common</artifactId>
  <version>1.0</version>
</dependency>
<!-- MySQL驱动版本 -->
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <scope>runtime</scope>
</dependency>
<!-- 数据源 -->
<dependency>
  <groupId>com.alibaba</groupId>
  <artifactId>druid</artifactId>
</dependency>
```
- application.yml 配置：
```yaml
server:
  port: 8090

# 设置Spring-Data-JPA
spring:
  jpa:
    # 指定在Spring容器启动时是否自动建表，默认为false
    generate-ddl: true
    # 指定是否在控制台显示其执行的SQL语句，默认false
    show-sql: true
    # 指定应用重启时是否重新创建更新表
    hibernate:
      ddl-auto: none
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://192.168.254.128:3306/test?useUnicode=true&amp;characterEncoding=utf8
    username: root
    password: 123456

logging:
  # 设置日志输出格式
  pattern:
    console: level-%level %msg%n
  level:
    # 控制Spring Boot启动时的日志级别
    root: info
    # 控制hibernate运行时的日志级别
    org.hibernate: info
    # 在show-sql为true时，显示SQL中的动态参数值
    org.hibernate.type.descriptor.sql.BasicBinder: trace
    # 在show-sql为true时，显示SQL查询结果
    org.hibernate.type.descriptor.sql.BasicExtractor: trace
    com.yw.provider: debug
```
- 创建业务接口实现类和 Controller 层的接口实现：
```java
@Service
public class DepartServiceImpl implements DepartService {
    @Autowired
    private DepartRepository repository;

    @Override
    public boolean saveOne(Depart depart) {
        // repository.save()可以完成插入和修改
        // 若操作对象的id==null，则执行插入；若id!=null，则执行修改；
        // 若操作对象的id!=null但不存在，则执行插入，但插入后该对象id并非是指定的id，而是由DB自动生成
        return repository.save(depart) != null;
    }

    @Override
    public boolean deleteById(int id) {
        // repository.existsById()中指定的id若不存在，则会抛出异常，因此这里要先判断是否存在
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateOne(Depart depart) {
        return repository.save(depart) != null;
    }

    @Override
    public Depart getDepartById(int id) {
        // repository.getOne()中指定的id若不存在，则会抛出异常，因此这里要先判断是否存在
        if (repository.existsById(id)) {
            return repository.getOne(id);
        }
        return new Depart().setName("No this depart");
    }

    @Override
    public List<Depart> listDeparts() {
        return repository.findAll();
    }
}
```
```java
@RestController
@RequestMapping("/provider/depart")
public class DepartController {
    @Autowired
    private DepartService departService;
    
    @PostMapping("/save")
    public boolean saveHandle(@RequestBody Depart depart) {
        return departService.saveOne(depart);
    }
    
    @DeleteMapping("/del/{id}")
    public boolean deleteHandle(@PathVariable("id") int id) {
        return departService.deleteById(id);
    }
    
    @PutMapping("/update")
    public boolean updateHandle(@RequestBody Depart depart) {
        return departService.updateOne(depart);
    }
    
    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") int id) {
        return departService.getDepartById(id);
    }
    
    @GetMapping("/list")
    public List<Depart> listHandle() {
        return departService.listDeparts();
    }
}
```
- 启动项目，通过Postman进行接口测试，或者谷歌浏览器的 Restlet Client 插件进行测试。使用JPA，在项目启动时会自动创建数据库。由于还没有接入注册中心这些，启动时会有一些报错信息，但是不影响。
- 能正常进行CURD接口操作，说明项目跑通啦！！下面就开始搭建消费者工程。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210606161632303.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
### 创建消费者工程 01-consumer-8080
- 复制 01-provider-8090 工程，并重命名为 01-consumer-8080，删掉数据库驱动和连接池的依赖，yml配置文件也删掉，使用默认8080端口，修改启动类和 Controller 层接口：
```java
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
```
```java
@RestController
@RequestMapping("/consumer/depart")
public class DepartController {
    private final static String API_URL = "http://localhost:8090/provider/depart/";
    
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/save")
    public boolean saveHandle(@RequestBody Depart depart) {
        return restTemplate.postForObject(API_URL + "save", depart, Boolean.class);
    }

    @DeleteMapping("/del/{id}")
    public void deleteHandle(@PathVariable("id") int id) {
        restTemplate.delete(API_URL + "del/" + id);
    }

    @PutMapping("/update")
    public void updateHandle(@RequestBody Depart depart) {
        restTemplate.put(API_URL + "update", depart);
    }

    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") int id) {
        return restTemplate.getForObject(API_URL + "get/" + id, Depart.class);
    }

    @GetMapping("/list")
    public List<Depart> listHandle() {
        return restTemplate.getForObject(API_URL + "list", List.class);
    }
}
```
- 启动消费者工程，然后，通过Postman进行测试，或者谷歌浏览器的 Restlet Client 插件进行测试。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210606163352638.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
- 至此，我们就搭建完成了最简单的 服务提供者与服务消费者 的框架模型，主要使用 RestTemplate 进行远程调用。

# 微服务注册中心Eureka

## Eureka概述
### Eureka简介
* Eureka，古希腊词语，英文读音[juə'ri:kə]，意思是“我找到了!我发现了!”
* Eureka 是 Netflix 开发的服务发现框架，本身是一个基于 REST 的服务，主要用于定位运行在 AWS 域中的中间层服务，以达到负载均衡和中间层服务故障转移的目的。SpringCloud 将它集成在其子项目 spring-cloud-netflix 中，实现 SpringCloud 的服务发现功能。
* 其实，Eureka 就是一个专门用于服务发现的服务器，一些服务注册到该服务器，而另一些服务通过该服务器查找其所要调用执行的服务。可以充当服务发现服务器的组件很多，例如 Zookeeper、Consul、Eureka 等。
### Eureka体系架构
* **High level architecture**：https://github.com/Netflix/eureka/wiki/Eureka-at-a-glance

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210606165648301.png)
### CAP定理
#### 概念
CAP 定理指的是在一个分布式系统中，Consistency（一致性）、 Availability（可用性）、Partition tolerance（分区容错性），三者不可兼得。
- 一致性（C）：分布式系统中多个主机之间是否能够保持数据一致的特性。即，当系统数据发生更新操作后，各个主机中的数据仍然处于一致的状态。
- 可用性（A）：系统提供的服务必须一直处于可用的状态，即对于用户的每一个请求，系统总是可以在有限的时间内对用户做出响应。
- 分区容错性（P）：分布式系统在遇到任何网络分区故障时，仍能够保证对外提供满足一致性和可用性的服务。
#### 定理
- CAP 定理的内容是：对于分布式系统，网络环境相对是不可控的，出现网络分区是不可避免的，因此系统必须具备分区容错性。但系统不能同时保证一致性与可用性。即要么 CP，要么 AP。

### Eureka与Zookeeper对比

- Eureka 与 Zookeeper 都可以充当服务中心，那么它们有什么区别呢?它们的区别主要体现在对于 CAP 原则的支持的不同。
  - Eureka：AP原则
  - Zookeeper：CP原则
### Eureka的闭源谣言
- [Eureka 官网的 wiki](https://github.com/Netflix/eureka/wiki) 中公布了如下内容：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190601185647281.png)
* 【**原文**】The existing open source work on eureka 2.0 is discontinued(终止). The code base(代码库) and artifacts(工程) that were released as part of the existing repository of work on the 2.x branch is considered use at your own risk(被认为在自己的风险中使用). 
Eureka 1.x is a core part of Netflix's service discovery system and is still an active project. Additionally(另外), extension work(扩展工作) on eureka 1.x has moved(推进) internally 内部) within Netflix.
* 【**翻译**】现在的关于 eureka 2.0 的开源工作已经终止。已经发布的现存库中的关于 2.x 分支部分的代码库与工程，你的使用将自负风险。

- Erueka 1.x 是 Netflix 服务发现系统的核心部分，其仍是一个活跃项目。另外，在 Eureka 1.x 上的扩展工作已经在 Netflix 内部推进。

## 搭建Eureka服务中心

### 创建eureka工程 00-eureka-server-8000

- 依赖：这里创建一个普通的 Spring Boot 工程，命名为 00-eureka-server-8000，仅导入 Eureka Server 依赖即可。
```xml
<!-- eureka server的依赖 -->
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```
* application.yml 配置文件：
```yaml
server:
  port: 8000
eureka:
  instance:
    # 指定Eureka主机
    hostname: localhost
  client:
    # 指定当前主机是否需要向注册中心注册？
    # 不用，因为当前主机是Server，不是Client
    register-with-eureka: false
    # 指定当前主机是否需要获取注册信息？不用。。。
    fetch-registry: false
    # 暴露服务中心地址
    service-url:
      #      defaultZone: http://localhost:8000/eureka
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka
```
* 启动类开启Eureka服务：
```java
@SpringBootApplication
@EnableEurekaServer     // 开启Eureka服务
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
```
- 用浏览器访问 `http://localhost:8000/` 出来了Eureka 的管理界面。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210606173009193.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)

### 步骤小结

- 添加 Eureka Server 依赖 `spring-cloud-starter-netflix-eureka-server`
- 在配置文件中配置 Eureka Server
- 在启动类上添加 @EnableEurekaServer 注解，启动 Eureka Server 功能

## 搭建Eureka的客户端服务

### 创建提供者工程 02-provider-8090
* 复制 01-provider-8090 工程，并重命名为 02-provider-8090，添加 eureka 客户端依赖
```xml
<!--eureka客户端依赖-->
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```
* 修改yml配置文件：

![在这里插入图片描述](https://img-blog.csdnimg.cn/2021060617523572.png)
- 微服务健康检查：在提供者工程的 pom 中添加 actuator 监控依赖。
```xml
<!--actuator依赖-->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
* yml配置文件添加如下内容：
```yaml
info:
  company.name: www.yw.com
  company.addr: China Shenzhen
  company.tel: 12345678
  app.name: yw-msc
  app.desc: mic-server-cloud
  author: yw
```
* 启动项目，并访问 eureka 注册中心 `http://localhost:8000/`，和健康检查地址`http://localhost:8090/actuator/info`

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210606175610326.png)

### 创建消费者工程 02-consumer-8080

* 复制 012-consumer-8080 工程，并重命名为 02-consumer-8080，与 02-provider-8090 工程一样需要添加 eureka 客户端依赖和 actuator 健康检查依赖。
* 修改 application.yml 配置文件：
```yaml
spring:
  # 指定当前微服务对外暴露的名称
  application:
    name: msc-consumer-depart

eureka:
  # 指定eureka服务中心
  client:
    service-url:
      defaultZone: http://localhost:8000/eureka
```
* 修改 Controller 接口处理：消费者将使用提供者暴露的服务名称(spring.application.name)来消费服务

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210606180420780.png)
* 修改启动类：不需要显示开启服务发现（若是纯SpringBoot工程则需要开启），开启消费者客户端的负载均衡功能

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210606182757715.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)

- 启动消费者工程，进行接口测试，结果显示可以通过提供者暴露的服务名称进行正常的消费。这样我们就利用eureka注册中心实现了通过提供者微服务名进行服务的调用功能。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210606180736620.png)

### 步骤小结

- 添加 Eureka Client 依赖 `spring-cloud-starter-netflix-eureka-client`
- 在配置文件中指定要注册的 Eureka Server 地址，指定自己的微服务名称
- 针对于 Consumer 而言：
  - 配置 JavaConfig：RestTemplate 添加 @LoadBalance 注解，实现负载均衡
  - 对 Provider 服务的调用不再是“主机名:端口”，而是通过“提供者的微服务名称”进行远程调用

## Eureka进阶

### 服务发现Discovery

- 在 02-provider-8090 中新增一个接口方法：
```java
// 声明服务发现客户端
@Autowired
private DiscoveryClient client;
@GetMapping("/discovery")
public Object discoveryHandle() {
    // 获取Eureka中所有的微服务名称
    List<String> serviceNames = client.getServices();
    // 遍历
    for (String name : serviceNames) {
        // 根据微服务名称获取所有提供该服务的主机信息
        List<ServiceInstance> instances = client.getInstances(name);
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost() + " : " + instance.getPort());
        }
    }
    return serviceNames;
}
```
- 测试访问地址：`http://localhost:8090/provider/depart/discovery`

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210606184139463.png)

### 自我保护机制
- 刷新 Eureka 服务页面，可以看到如下红色字体内容，表示当前 EurekaServer 启动了自我保护机制，进入了自我保护模式。

![在这里插入图片描述](https://img-blog.csdnimg.cn/2021060617364793.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)

* 【**原文**】Emergency (紧急情况) ! Eureka may be incorrectly claiming(判断) instances(指微服务主机) are up when they're not. Renewals(续约，指收到的微服务主机的心跳) are lesser than threshold(阈值) and hence(从此) the instances are not being expired(失效) just to be(只是为了) safe.
* 【**翻译**】紧急情况!当微服务主机联系不上时，Eureka 不能够正确判断它们是否处于 up 状态。当更新(指收到的微服务主机的心跳)小于阈值时，为了安全，微服务主机将不再失效。
* 默认情况下，EurekaServer 在 90 秒内没有检测到服务列表中的某微服务，则会自动将该微服务从服务列表中删除。但很多情况下并不是该微服务节点(主机)出了问题，而是由于**网络抖动**等原因使该微服务无法被EurekaServer发现，即无法检测到该微服务主机的心跳。若在短暂时间内网络恢复正常，但由于 EurekaServer 的服务列表中已经没有该微服务，所以该微服务已经无法提供服务了。
* 在短时间内若 EurekaServer 丢失较多微服务(EurekaServer 收到的心跳数量小于阈值)，那么其会自动进入自我保护模式:服务列表只可读取、写入，不可执行删除操作。当 EurekaServer 收到的心跳数量恢复到阈值以上时，其会自动退出 Self Preservation 模式(翻译自官网)。
- 默认值修改
  - 启动自我保护的阈值因子默认为 0.85，即 85%。即 EurekaServer 收到的心跳数量若小于应该收到数量的 85%时，会启动自我保护机制。
  - 自我保护机制默认是开启的，可以通过修改 EurekaServer 中配置文件来关闭。但不建议关闭。

- **Renews threshold**：Eureka Server 期望每分钟收到客户端的续约总数
- **Renews (last min)**：Eureka Server 实际在最后一分钟收到客户端的续约数量
  - 若 Renews (last min) 小于 Renews threshold，就会启动自我保护

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210606201742651.png)

### EurekaServer集群

- 这里在本地启动三个Eureka Server节点，端口号分别为 8100、8200 与 8300，IDEA允许并行运行，通过修改配置开启三个Eureka Server。

![在这里插入图片描述](https://img-blog.csdnimg.cn/2021060618505517.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
- 任意访问其中一台Eureka：http://localhost:8100/

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210606185202460.png)
- Eureka Client 端需要修改注册中心地址：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210606185520379.png)

### 服务下架
- Eureka Client 需要添加 actuator 健康检查依赖。
#### 关闭服务
- 在 application.yml 配置文件中添加：
```yaml
management:
  # 开启所有监控终端
  endpoints:
    web:
      exposure:
        include: "*"
  # 开启shutdown监控终端
  endpoint:
    shutdown:
      enabled: true
```
- 在 postman 提交如下请求即可关闭该应用

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210606191115494.png)
#### 服务平滑上下线
- 前面的“关闭服务”方式存在一个不足是，若还需要再启用该服务，则必须再次启动该应用。我们也可以通过修改服务的状态为 UP 或 DOWN 来设置提供者是否可用，而无需重启应用。这种方式通常称为服务的平滑上下线。
- 在 application.yml 配置文件中修改：
```yaml
management:
  # 开启所有监控终端
  endpoints:
    web:
      exposure:
        include: "*"
```
- 在 postman 提交如下请求即可下线该应用

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210606191728983.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
- 如果想再次上线服务，就可以提交如下请求

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210606191904778.png)

### Eureka 的异地多活
#### Region 与 Zone
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210606165648301.png)

- Eureka 中具有 Region 与 Availability Zone（简称AZ）概念，是云计算中的概念。
- **为了方便不同地理区域中用户的使用**，大型云服务提供商一般会根据用户需求量再不同城市、省份、国家或洲创建不同的大型云计算机房。这些不同区域机房间一般是不能“内网连通”的，这些区域就称为一个Region。
- 这里存在一个问题：同一个 Region 机房是如何实现**同域容灾**的？为了增强容灾能力，在一个 Region 中又设置了不同的 Availability Zone。这些 **AZ 间实现了内网连通**，且用户可以根据自己所在的具体位置选择同域中的不同 AZ。当用户所要访问的 AZ 出现问题后，系统会自动切换到其它可用的 AZ。
- 例如， AWS 将全球划分为了很多的 Region，例如：美国东部区、美国西部区、欧洲区、非洲开普敦区、亚太区等。像 Eureka 系统架构图中的 us-east-1c、us-east-1d、us-east-1e 就是 us-east-1 这个 Region 中的 c、d、e 三个 AZ。
- 再比如，阿里云在我国境内的 Region 有杭州、北京、深圳、青岛、香港等，境外 Region 有亚太东南 1 区(新加坡)、亚太东南 2 区(悉尼)、亚太东北 1 区(东京)。
- **region 与 zone 的关系是 1:n；zone与Eureka的关系是 1:n。**
```yaml
eureka:
  client:
    region: xxx
    availability-zones: 
      xxx: k1, k2
    service-url:
      k1: http://xxxxxxx:8000/eureka
      k2: http://yyyyyyy:8000/eureka
```
#### Eureka 中的Region与Zone配置
![在这里插入图片描述](https://img-blog.csdnimg.cn/2021060619341026.png)
- 需求：假设某公司的服务器有 Beijing、Shanghai 等多个 Region。Beijing 这个 Region 中存在两个 AZ，分别是 bj-1 与 bj-2，每个 AZ 中有三台 Eureka Server。h-1 与 h-2 两台主机提供的都是相同的 Servivce 服务，根据地理位置的不同，这两台主机分别注册到了距离自己最近的不同 AZ 的 Eureka Server。
- Server AZ bj-1、 Server AZ bj-2 配置，以及 Service AZ bj-1、 Service AZ bj-2 ：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210606194611966.png)
- Zuul AZ bj-1 和 Zuul AZ bj-2 配置：

![在这里插入图片描述](https://img-blog.csdnimg.cn/2021060619484232.png)

# OpenFeign与Ribbon
## 概述
### OpenFeign简介
* 官方介绍：[spring-cloud-openfeign](https://spring.io/projects/spring-cloud-openfeign)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210606211249941.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
* 【**原文**】Declarative REST Client: Feign creates a dynamic implementation of an interface decorated(装饰) with JAX-RS or Spring MVC annotations.
* 【**翻译**】声明式 REST 客户端：Feign 通过使用 JAX-RS 或 SpringMVC 注解的装饰方式，生成接口的动态实现。
- **综合说明**：Feign，假装、伪装。OpenFeign 可以使消费者将提供者提供的服务名伪装为接口进行消费，消费者只需使用“Feign 接口 + 注解”的方式即可直接调用 Service 接口方法，而无需再使用 RestTemplate 了。

- 需要注意：
  - 该伪装的 Feign 接口是由消费者调用，与提供者没有任何关系。
  - Feign 仅是一个为客户端，其不会对请求做任何处理。
  - Feign 是通过注解的方式实现 RESTful 请求的。

### OpenFeign与Feign

* Spring Cloud D版及之前的版本使用的是 Feign，而该项目现已更新为了 OpenFeign，所以后续使用的依赖也发生了变化。
```xml
<!-- openfeign 依赖 -->
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```
### Ribbon与OpenFeign
* 说到 OpenFeign，不得不提的就是 Ribbon。 Ribbon 是 Netflix 公司的一个开源的负载均衡项目，是一个客户端负载均衡器,运行在消费者端。
* OpenFeign 中使用 Ribbon 进行负载均衡，所以 OpenFeign 直接内置了 Ribbon。即在导入OpenFeign 依赖后，无需再专门导入 Ribbon 依赖了。
## 声明式Rest客户端OpenFeign
### 创建消费者工程 03-consumer-feign-8080
- 复制 02-consumer-8080 工程，并重命名为 03-consumer-feign-8080，添加 openfeign 依赖即可。
- 定义 Feign Service 接口，并修改 Controller 层接口实现：
```java
@FeignClient("msc-provider-depart") // 指定Service绑定的微服务名称
@RequestMapping("/provider/depart")
public interface DepartService {
    @PostMapping("/save")
    boolean saveOne(Depart depart);
    @DeleteMapping("/del/{id}")
    boolean deleteById(@PathVariable("id") int id);
    @PutMapping("/update")
    boolean updateOne(Depart depart);
    @GetMapping("/get/{id}")
    Depart getDepartById(@PathVariable("id") int id);
    @GetMapping("/list")
    List<Depart> listDeparts();
}
```
- 关于 Feign 的说明：
  - Feign 接口名一般是与业务接口名相同的，但不是必须的；
  - Feign 接口中的方法名一般也与业务接口方法名相同，但也不是必须的；
  - Feign 接口中的方法返回值类型、方法参数要求与业务接口中的相同；
  - 接口上与方法上的 Mapping 的参数 URI 要与提供者处理器相应方法上的 Mapping 的 URI 相同。
```java
@RestController
@RequestMapping("/consumer/depart")
public class DepartController {
    /**
     * 这里的DepartService是FeignClient，并不是真正的业务接口
     */
    @Autowired
    private DepartService departService;

    @PostMapping("/save")
    public boolean saveHandle(@RequestBody Depart depart) {
        return departService.saveOne(depart);
    }

    @DeleteMapping("/del/{id}")
    public boolean deleteHandle(@PathVariable("id") int id) {
        return departService.deleteById(id);
    }

    @PutMapping("/update")
    public boolean updateHandle(@RequestBody Depart depart) {
        return departService.updateOne(depart);
    }

    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") int id) {
        return departService.getDepartById(id);
    }

    @GetMapping("/list")
    public List<Depart> listHandle() {
        return departService.listDeparts();
    }
}
```
* 启动类开启Feign客户端：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210606220213923.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)

### 超时与压缩

- 在 application.yml 中添加如下配置

```yaml
feign:
  client:
    config:
      default:
        # 指定Feign连接提供者的超时时限，决定于网络状况
        connectTimeout: 5000
        # 指定Feign从请求到获取提供者响应的超时时限，决定于提供者的处理时间
        readTimeout: 5000
  compression:
    request:
      # 开启对请求的压缩
      enabled: true
      # 指定对哪些MIME类型的文件进行压缩
      mime-types: ['text/xml', 'application/xml', 'application/json']
      min-request-size: 2048
    response:
      # 开启对客户端响应的压缩
      enabled: true
```

### 步骤小结

- 添加 OpenFeign 依赖 `spring-cloud-starter-openfeign`
- 定义 Feign 接口，指定要访问的微服务
- 将 JavaConfig 中的 RestTemplate 的创建方法删除，修改处理器，使用 Feign 接口来消费微服务
- 在启动类上添加 @EnableFeignClients 注解，开启 Feign Client 的功能

## Ribbon负载均衡

### 系统结构
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190606073314327.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)

### 创建提供者 03-provider-8090
- 复制 02-provider-8090 工程，并重命名为 03-provider-8090，利用该工程在本地启动三个提供者，端口号分别是 8090、8091、8092，IDEA允许并行运行。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210606223212851.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)- 修改Service实现类：
```java
@Service
public class DepartServiceImpl implements DepartService{
    @Autowired
    private DepartRepository repository;
    // 读取配置文件中的属性值
    @Value("${server.port}")
    private int port;
    // 略...
    @Override
    public Depart getDepartById(int id) {
        // repository.getOne()中指定的id若不存在，则会抛出异常，因此这里要先判断是否存在
        if (repository.existsById(id)) {
            Depart depart = repository.getOne(id);
            depart.setName(rename(depart.getName()));
            return depart;
        }
        return new Depart().setName(port + " No this depart");
    }

    @Override
    public List<Depart> listDeparts() {
        List<Depart> departs = repository.findAll();
        departs.forEach(v -> v.setName(rename(v.getName())));
        return departs;
    }

    private String rename(String name) {
        return name + " : " + port;
    }
}
```
- 启动三个提供者：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210606224053606.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)

- 访问地址：http://localhost:8080/consumer/depart/get/1，测试负载均衡效果，可以看到采用的是轮询方式。

## 负载均衡策略
### 内置负载均衡策略

- **RoundRobinRule**：轮询策略。Ribbon 默认采用的策略。若经过一轮轮询没有找到可用的 provider，其最多轮询 10 轮。若最终还没有找到，则返回 null。
- **RandomRule**：随机策略，从所有可用的 provider 中随机选择一个。
- **RetryRule**：重试策略。先按照 RoundRobinRule 策略获取 provider，若获取失败，则在指定的时限内重试。默认的时限为 500 毫秒。
- **BestAvailableRule**：最可用策略。选择并发量最小的 provider，即连接的消费者数量最少的 provider。
- **AvailabilityFilteringRule**：可用过滤算法。该算法规则是，先采用轮询方式选择一个 Server，然后判断其是否处于熔断状态，是否已经超过连接极限。若没有，则直接选择。否则再重新按照相同的方式进行再选择。最多重试 10 次。若 10 次后仍没有找到，则重新将所有 Server 进行判断，挑选出所有未熔断，未超过连接极限的 Server，然后再采用轮询方式选择一个。若还没有符合条件的，则返回 null。
- **ZoneAvoidanceRule**：zone 回避策略。根据 provider 所在 zone 及 provider 的可用性，对 provider 进行选择。
- **WeightedResponseTimeRule**：“权重响应时间”策略。根据每个 provider 的平均响应时间计算其权重，响应时间越快权重越大，被选中的机率就越高。在刚启动时采用轮询策略。后面就会根据权重进行选择了。
### 更换内置策略 03-consumer-lb-8080
- Ribbon 默认采用的是 RoundRobinRule，即轮询策略。但通过修改消费者工程的配置文件，或修改消费者的启动类或 JavaConfig 类可以实现更换负载均衡策略的目的。
- 复制 03-consumer-feign-8080 工程，并重命名为 03-consumer-lb-8080。
* **方式一 修改 application.yml 配置文件**：在其中添加如下内容
```yaml
# 修改负载均衡策略
msc-provider-depart: # 要负载均衡的提供者微服务名称
  ribbon:
    # 指定要使用的负载均衡策略
    NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule
```
* **方式二 修改 JavaConfig 类**：在 JavaConfig 类中添加负载负载 Bean 方法
```java
@Configuration
public class ConsumerConfig {
    // 指定Ribbon使用随即算法策略
    @Bean
    public IRule loadBalanceRule() {
        return new RandomRule();
    }
}
```
### 自定义负载均衡策略
- Ribbon 支持自定义负载均衡策略，自定义实现的负载均衡算法类需要实现 IRule 接口。
- 自定义 CustomRule 类：从所有可用的 provider 中排除掉指定端口号的 provider，剩余 provider 进行随机选择。
```java
public class CustomRule implements IRule {
    private ILoadBalancer lb;
    // 要排除的提供者的服务端口号
    private List<Integer> excludePorts;

    public CustomRule() {
    }
    public CustomRule(List<Integer> excludePorts) {
        this.excludePorts = excludePorts;
    }

    @Override
    public void setLoadBalancer(ILoadBalancer lb) {
        this.lb = lb;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return lb;
    }

    @Override
    public Server choose(Object key) {
        // 获取所有可用的提供者主机
        List<Server> servers = lb.getReachableServers();
        // 获取所有排除了指定端口号的提供者
        List<Server> availableServers = this.getAvailableServers(servers);
        // 从剩余的提供者中随机获取可用的提供者
        return this.getAvailableRandomServers(availableServers);
    }

    // 获取所有排除了指定端口号的提供者
    private List<Server> getAvailableServers(List<Server> servers) {
        // 若没有要排除的主机，则返回所有
        if(excludePorts == null || excludePorts.size() == 0) {
            return servers;
        }
        return servers.stream()
                .filter(server -> excludePorts.stream().noneMatch(port -> server.getPort() == port))
                .collect(Collectors.toList());
    }
    // 从剩余的提供者中随机获取可用的提供者
    private Server getAvailableRandomServers(List<Server> availableServers) {
        // 获取一个[0，availableServers.size())的随机数
        int index = new Random().nextInt(availableServers.size());
        return availableServers.get(index);
    }
}
```
* 修改 JavaConfig 类：将原来的负载均衡 Bean 方法注释掉，添加新的负载均衡策略方法。
```java
@Configuration
public class ConsumerConfig {
    // ...
//    // 指定Ribbon使用随即算法策略
//    @Bean
//    public IRule loadBalanceRule(){
//        return new RandomRule();
//    }
    // 指定Ribbon使用自定义负载均衡策略
    @Bean
    public IRule loadBalanceRule(){
        List<Integer> ports = new ArrayList<>();
        ports.add(8083);
        return new CustomRule(ports);
    }
}
```

# Hystrix熔断机制与服务降级
## 前置概念

### 服务熔断简介
#### 雪崩效应
- 如果说服务流控是为了在高并发场景下不至于将系统压垮，那么服务熔断则是为了在外部环境不通畅场景下，不至于将系统拖垮，也就是为了防止服务雪崩的发生。

![在这里插入图片描述](https://img-blog.csdnimg.cn/2020122618331214.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
- 在复杂的系统中，经常会出现 A 依赖于 B、B 依赖于 C、C 依赖于 D、......这种依赖将会产生很长的调用链路，这种复杂的调用链路称为 1到 N 的扇出。
- 如果在 A 的调用链路上某一个或几个被调用的子服务不可用或延迟较高，则会导致调用 A 服务的请求被堵住。堵住的 A 请求会消耗占用系统的线程、IO 等资源，当对 A 服务的请求越来越多，占用的计算机资源越来越多的时候，会导致系统瓶颈出现，造成其他的请求同样不可用，最终导致业务系统崩溃，这种现象称为雪崩效应。
#### 服务雪崩
- 以下图片都来自于 Hystrix 官网的 wiki 中 [https://github.com/netflix/hystrix](https://github.com/netflix/hystrix)。
- 下图是用户请求的多个服务(A, H, I, P)均能正常访问并返回的情况。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190608163023279.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
- 下图为请求服务 I 出现问题时，一个用户请求被阻塞的情况。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190608163051287.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
- 下图为大量用户请求服务 I 出现异常全部陷入阻塞的的情况，即服务发生雪崩的情况。

![在这里插入图片描述](https://img-blog.csdnimg.cn/2019060816311445.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
#### 熔断机制
- 为了防止服务雪崩的发生，在发现了对某些资源请求的响应**缓慢或调用异常**较多时，直接将对这些资源的请求掐断一段时间。而在这段时间内的请求将不再等待超时，而是直接返回事先设定好的降级结果。这些请求将不占用系统资源，从而避免了服务雪崩的发生。这就是服务熔断。
- 熔断机制是服务雪崩的一种有效解决方案。当指定时间窗内的请求失败率达到设定阈值时，系统将通过断路器直接将此请求链路断开。常见的熔断有两种：
  * **预熔断**：也叫提前熔断，提前设定阈值，例如：主动断电。
  * **即时熔断**：不可预知的，例如：使用大功率用电器时，保险丝自己烧断了。

### 服务降级简介

* 服务降级是请求发生问题时的一种**增强用户体验**的方式。
* 现代系统中，发生服务熔断，一定会发生服务降级；但发生服务降级，并不一定会发生服务熔断。

## Hystrix简介

- Spring Cloud 是通过 Hystrix 来实现服务熔断与降级的。
### 官网wiki
* 地址：[https://github.com/netflix/hystrix/wiki](https://github.com/netflix/hystrix/wiki)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190608163436314.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
* 【**原文**】In a distributed environment, inevitably(不可避免地) some of the many service dependencies will fail. Hystrix is a library that helps you control the interactions(交互) between these distributed services by adding **latency tolerance(延迟容忍)** and **fault tolerance logic(容错逻辑)**. Hystrix does this by isolating points of access between the services, stopping **cascading failures(级联错误)** **across them(跨服务)**, and providing **fallback options(回退选项)**, all of which improve your system’s overall resiliency(弹性).
* 【**翻译**】在分布式环境中，许多服务依赖中的一些服务发生失败是不可避免的。Hystrix 是一个库，通过添加延迟容忍和容错逻辑，帮助你控制这些分布式服务之间的交互。Hystrix 通过**隔离服务之间的访问点**、**停止跨服务的级联故障**以及提供**回退选项**来实现这一点，所有这些都可以提高系统的整体弹性。
### 综合说明
- 当 Hystrix 监控到某个服务发生故障后，其不会让该服务的消费者阻塞，或向消费者抛出异常，而是向消费者返回一个符合预期的、可处理的备选响应(FallBack)，这样就避免了服务雪崩的发生。

## Hystrix 服务降级方式
- Hystrix 对于服务降级的实现方式有两种：**fallbackMethod 服务降级**，与 **fallbackFactory 服务降级**。
### 创建消费者工程 04-consumer-hystrix-8080
- 复制 02-consumer-8080 工程，并重命名为 04-consumer-hystrix-8080。
- 添加hystrix依赖：
```xml
<!-- hystrix依赖 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>
```

### fallbackMethod服务降级
- 修改 Controller 层接口：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210607000410238.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
- 启动类修改：开启熔断器

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210607000848204.png)
- 把所有提供者都停掉，启动该消费者工作，访问：http://localhost:8080/consumer/depart/get/1。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210607002640184.png)

### fallbackFactory服务降级

- fallbackMethod 服务降级存在的问题：接口方法与降级方法写在一起了，这样会很乱，不利于后期维护。
- fallbackMethod 服务降级和Feign是没有关系的，但fallbackFactory服务降级是是有关系的，需要引入 openfeign 依赖，使用 feign.hystrix.FallbackFactory。
- 定义降级处理类或降级工厂处理类：**该实现方案会直接将 fallbackMethod 的服务降级给屏蔽掉**
```java
@Component
@RequestMapping("/fallback/consumer/depart")
public class DepartFallback implements DepartService {
    @Override
    public boolean saveOne(Depart depart) {
        System.out.println("执行 saveOne(Depart depart) 的服务降级处理方法");
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        System.out.println("执行 deleteById(int id) 的服务降级处理方法");
        return false;
    }

    @Override
    public boolean updateOne(Depart depart) {
        System.out.println("执行 updateOne(Depart depart) 的服务降级处理方法");
        return false;
    }

    @Override
    public Depart getDepartById(int id) {
        System.out.println("执行 getDepartById(int id) 的服务降级处理方法");
        return new Depart().setId(id).setName("【Hystrix】No this depart -- 类级别");
    }

    @Override
    public List<Depart> listDeparts() {
        System.out.println("执行 listDeparts() 的服务降级处理方法");
        return null;
    }
}
```
```java
@Component
public class DepartFallbackFactory implements FallbackFactory<DepartService> {

    @Autowired
    private DepartFallback departFallback;

    @Override
    public DepartService create(Throwable throwable) {
        return departFallback;
    }
}
```

- Feign接口设置降级工厂或降级类：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210607005256505.png)
* 修改 application.yml 配置文件：
```yaml
feign:
  hystrix:
    # 开启Feign对Hystrix的支持
    enabled: true
```
- 再次访问：http://localhost:8080/consumer/depart/get/1。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210607003355968.png)

### 步骤小结

- 添加 Hystrix 依赖`spring-cloud-starter-netflix-hystrix`
- 对于 FallbackMethod 降级方式：
  - 修改处理器方法，在处理器方法上添加 @HystrixCommand 注解，并定义服务降级方法
- 对于 FallbackFactory 降级方式：
  - 在 Feign 接口中指定服务降级类
  - 修改配置文件，开启 Feign 对 Hystrix 的支持
- 在启动类上添加 @EnableCircuitBreaker 注解，或将 @SpringBootApplication 注解替换为 @SpringCloudApplication 注解

## Hystrix高级属性配置

**官网资料**：[https://github.com/Netflix/Hystrix/wiki/Configuration](https://github.com/Netflix/Hystrix/wiki/Configuration)
### 执行隔离策略
- 对依赖的请求数量进行限制的这种机制，称为执行隔离。
- 执行隔离策略有两大作用：防止服务熔断，防止服务雪崩。
#### 类型
> 隔离请求的方式有两种类型：
* **线程隔离thread**：Hystrix 的默认隔离策略。系统会创建一个依赖线程池，为每个依赖请求分配一个独立的线程，而每个依赖所拥有的线程数量是有上限的。当对该依赖的调用请求数量达到上限后再有请求，则该请求阻塞。所以对某依赖的并发量取决于为该依赖所分配的**线程数量**。
* **信号量隔离**：对依赖的调用所使用的线程仍为请求线程，即不会为依赖请求再创建新的线程。但系统会为每种依赖分配一定数量的信号量，而每个依赖请求分配一个信号。当对该依赖的调用请求数量达到上限后再有请求，则该请求阻塞。所以对某依赖的并发量取决于为该依赖所分配的**信号数量**。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190608213024297.png)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190608213358229.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190608213511916.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
- 线程隔离与信号量隔离对比：
  - 线程是进程的一个**执行体**，其具有独立运行的特性，而信号量却不是，其仅仅是线程执行的条件。
  - 线程隔离中请求线程与提供者调用线程不是同一个线程，而信号量隔离中请求线程与调用线程是同一个线程。
  - 线程隔离的执行效率要高于信号量隔离的，因为线程隔离的执行体数量是信号量的 2 倍。
  - 线程隔离使每台主机处理请求的数量是有限制的，因为主机线程数量是有上限的；而信号量隔离不同，其没有上限，因为所谓信号量就是一个计数器，是一个数值，不存在上限。
  - 在服务器少而请求并发量大的情况下，不建议使用线程隔离，否则可能会使系统队请求的并发能力下降。
  - 线程隔离便于控制反馈给客户端的降级时间。

#### 修改策略
* 若是在配置文件中，则可以通过以下设置修改：
```properties
hystrix.command.default.execution.isolation.strategy=thread
hystrix.command.default.execution.isolation.strategy=semaphore
```
* 若是在代码中，则可通过以下语句修改：只能在方法级别的注解中
```java
HystrixCommandProperties.Setter().withExecutionIsolationStrategy(ExecutionIsolationStrategy.THREAD);
HystrixCommandProperties.Setter().withExecutionIsolationStrategy(ExecutionIsolationStrategy.SEMAPHORE);
```
```java
@HystrixCommand(fallbackMethod = "getHystrixHandle",
            commandProperties = {@HystrixProperty(name = "hystrix.command.default.execution.isolation.strategy", value = "semaphore")})
@GetMapping("/get/{id}")
public Depart getHandle(@PathVariable("id") int id) {
    return departService.getDepartById(id);
}
```
#### 默认值
- 在 HystrixCommandProperties 类的构造器中设置有这些高级属性的默认值。
```java
this.executionIsolationStrategy = getProperty(propertyPrefix, key, "execution.isolation.strategy", builder.getExecutionIsolationStrategy(), default_executionIsolationStrategy);
        
private static final ExecutionIsolationStrategy default_executionIsolationStrategy = ExecutionIsolationStrategy.THREAD;
```
### 执行隔离的其它属性

#### 线程执行超时时限
- 在默认的线程执行隔离策略中，关于线程的执行时间，可以为其设置超时时限。当然，首先通过下面的属性开启该超时时限，该属性默认是开启的，即默认值为 true。若要关闭，则可以在配置文件中设置该属性的值为 false。
```properties
hystrix.command.default.execution.timeout.enabled
```
```java
this.executionTimeoutEnabled = getProperty(propertyPrefix, key, "execution.timeout.enabled", builder.getExecutionTimeoutEnabled(), default_executionTimeoutEnabled);
        
private static final Boolean default_executionTimeoutEnabled = true;
```
- 在开启了执行线程超时时限后，可以通过以下属性设置时限长度，其默认值为 1000 毫秒。
```properties
hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds
```
```java
this.executionTimeoutInMilliseconds = getProperty(propertyPrefix, key, "execution.isolation.thread.timeoutInMilliseconds", builder.getExecutionIsolationThreadTimeoutInMilliseconds(), default_executionTimeoutInMilliseconds);
        
private static final Integer default_executionTimeoutInMilliseconds = 1000;
```
#### 超时中断
- 当线程执行超时时是否中断线程的执行，默认为 true，即超时即中断。通过以下属性进行设置：
```properties
hystrix.command.default.execution.isolation.thread.interruptOnTimeout
```
#### 取消中断
* 在线程执行过程中，若请求取消了，当前执行线程是否结束呢？由下面属性进行设置，默认为 false，即取消后不中断。
```properties
hystrix.command.default.execution.isolation.thread.interruptOnCancel
```
#### 信号量数量
- 若采用信号量执行隔离策略，则可通过以下属性修改信号量的数量，即对某一依赖所允许的请求的最高并发量。默认值 10。
```properties
hystrix.command.default.execution.isolation.semaphore.maxConcurrentRequests
```
### 服务降级属性
#### 降级请求最大数量
- 该属性仅限于信号量隔离。当信号量已用完后再有请求到达，并不是所有请求都会进行降级处理，而是在该属性设置值范围内的请求才会发生降级，其它请求将直接拒绝。默认值 10。
```properties
hystrix.command.default.fallback.isolation.semaphore.maxConcurrentRequests
```
#### 服务降级开关
- 无论是线程隔离还是信号量隔离，当请求数量到达其设置的上限后再有请求到达是否会对请求进行降级处理，取决于该属性值的设置。若该属性值设置为false，则不进行降级，而是直接拒绝请求。默认值 true。
```properties
hystrix.command.default.fallback.enabled
```

#### 小结一下

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210607161939526.png)

### 服务熔断属性
#### 熔断功能开关
- 设置当前应用是否开启熔断器功能，默认值为 true。
```properties
hystrix.command.default.circuitBreaker.enabled
```
#### 熔断器开启阈值
- 当在时间窗内（10 秒）收到的请求数量超过该设置的数量后，将开启熔断器。默认值为 20。注意，开启熔断器是指将拒绝所有请求；关闭熔断器是指将使所有请求通过。
```properties
hystrix.command.default.circuitBreaker.requestVolumeThreshold
```
#### 熔断时间窗
- 当熔断器开启该属性设置的时长后，会尝试关闭熔断器，以恢复被熔断的服务。默认值为 5000 毫秒。
```properties
hystrix.command.default.circuitBreaker.sleepWindowInMilliseconds
```
#### 熔断开启错误率
- 当请求的错误率高于该百分比时，开启熔断器。默认值为 50，即 50%。
```properties
hystrix.command.default.circuitBreaker.errorThresholdPercentage
```
#### 强制开启熔断器
- 设置熔断器无需条件开启，拒绝所有请求。默认值为 false。
```properties
hystrix.command.default.circuitBreaker.forceOpen
```
#### 强制关闭熔断器
- 设置熔断器无需条件的关闭，通过所有请求。默认值为 false。
```properties
hystrix.command.default.circuitBreaker.forceClosed
```

### 其它属性设置

- 参考：[https://github.com/Netflix/Hystrix/wiki/Configuration](https://github.com/Netflix/Hystrix/wiki/Configuration)

- 也可以看 **HystrixCommandProperties** 这个类的源码

- 线程池相关属性：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190608220210992.png)

## Dashboard监控仪表盘

- Hystrix Dashboard 仪表盘用于以 GUI 的形式展示消费者的执行情况，包括其处理器方法与 Service 方法的调用执行情况，及熔断器 CircuitBreaker 的状态等。当然，这些显示出的数据都是在指定时间窗内的执行情况及状态信息。
- Hystrix-dashboard 用于监控 Hystrix 服务降级情况，所以应添加在消费者工程中。
### 创建消费者工程 04-consumer-dashboard-8080
- 复制 04-consumer-hystrix-8080 工程 并重命名为 04-consumer-dashboard-8080。
- 依赖：
```xml
<!-- hystrix-dashboard依赖 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
</dependency>
<!-- actuator依赖 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
* 修改 application.yml 配置：在配置文件中添加如下内容，用于开启 actuator 的所有 web 终端，并调整 Hystrix 隔离线程执行的超时时限。
```yaml
# 开启actuator的所有web终端
management:
  endpoints:
    web:
      exposure:
        include: "*"
        
# 设置服务熔断时限
hystrix:
  command:
    default:
      execution:
        isolation:
          thread:
            timeoutInMilliseconds: 3000
```
* 修改启动类：使用 @EnableHystrixDashboard 注解开启 Hystrix 仪表盘功能。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210607162953857.png)
* 启动工程，并访问测试：http://localhost:8080/hystrix

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210607163259123.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
### 创建提供者工程 04-provider-8090
- 复制 03-provider-8090 工程，并重命名为 04-provider-8090，修改实现类中的 getDepartById()方法，增加 sleep() 休眠功能用来模拟耗时操作。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210607173915619.png)
- 为了演示效果，这里测试时 id 的取值为 2、4。当取 2 时，不会超时，但当取 4 时，隔离线程执行会超时。

### 仪表盘

- 分别访问  `http://localhost:8080/consumer/depart/get/2`，`http://localhost:8080/consumer/depart/get/4`，并查看 dashboard 界面

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210607181901452.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
* 使用postman批量访问100次：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210607182314859.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
- 观察dashboard变化：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210607184238393.png)
#### GUI介绍
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190608223927268.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)

#### 关于Turbine
- 前面的方式是对单个消费者进行监控，我们也可以对集群进行整体监控。此时就需要使用 Turbine 技术了。Turbine 能够汇集监控信息，并将聚合后的信息提供给 Hystrix Dashboard 来集中展示和监控。使用 Turbine 对集群进行监控的实现步骤很简单，只需三步：
  - **导入Turbine 依赖**；
  - **在配置文件中配置 turbine**；
  - **在启动类上添加 @EnableTurbine 注解**。

### 步骤小结

- 添加 hystrix-dashboard 与 actuator 依赖 `spring-cloud-starter-netflix-hystrix-dashboard`、`spring-boot-starter-actuator`
- 配置文件中开启 actuator 的 hystrix.stream 监控终端
- 在启动类上添加 @EnableHytrixDashboard 注解

## Turbine聚合监控——监控默认组集群

### 整体架构
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210613200702402.png)
### 创建消费者工程 04-consumer-turbine-8080
- 复制 04-consumer-dashboard-8080 工程，并重命名为 04-consumer-turbine-8080，在此基础上修改。去掉 hystrix-dashboard 依赖。
- 利用该工程在本地启动三个消费者，端口号分别是 8080、8081、8082，IDEA允许并行运行。
### 创建Turbine工程 00-hystrix-turbine-8888
- 复制 00-eureka-server-8000 工程，重命名为 00-hystrix-turbine-8888，在此基础上修改，引入 Turbine Server 所需要的依赖。
- application.yml 配置文件：
```yaml
server:
  port: 8888

spring:
  application:
    name: hystrix-turbine
# eureka client配置
eureka:
  client:
    service-url:
      defaultZone: http://eureka8100.com:8100/eureka,http://eureka8200.com:8200/eureka,http://eureka8300.com:8300/eureka
# 配置turbine
turbine:
  # 指定要监控的微服务名称
  app-config: msc-consumer-depart
  aggregator:
    # 指定要监控的微服务组，default指定要监控默认组
    cluster-config: default
  # 指定要监控抽微服务组名称，默认组名称为'default'
  cluster-name-expression: "'default'"
```
- 启动类开启 Turbine 和 HystrixDashboard：
```java
@EnableTurbine
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixTurbineApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineApplication.class, args);
    }
}
```
- 启动项目，并访问：http://localhost:8888/hystrix

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210613204726596.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
- 查看集群监控情况：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210613205301702.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)

- turbine 监控多个集群：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210613210159567.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)

### 步骤小结

#### Turbine Client

- 至少要有 actuator 与 netflix-hystrix 依赖
- 在配置文件中必须开启 acturator 的 hystrix.stream 监控终端

#### Turbine Server

- 至少需要如下依赖：
  - netflix-turbine
  - netflix-hystrix-dashboard
  - netflix-bystrix
  - actuator
  - eureka client
- 在配置文件中配置 turbine：指定要监控的 group 及相应的微服务名称

## Turbine 聚合监控——监控多个组集群

- 为了更加方便对集群的运行状态的监控，Turbine 将集群进行了分组。前面我们监控了两个集群，这两个集群默认被分为了一个组，是默认组。我们也可以将集群划分到多个组中使用同一个 Turbine 进行分别监控。
### 整体架构
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210613210247809.png)

### 分组监控原理

- Turbine 对于集群分组进行监控的原理是，在集群之上再添加一种分类：组。为每个集群中的 Server 都添加一个 groupId，而 Turbine 是基于 groupId 进行监控的。
- 这个 groupId 是基于自定义的 Eureka 元数据实现的。
- Eureka 元数据是指，Eureka Client 向 Eureka Server 注册时的描述信息，注册数据。其有两种类型：
  - 标准元数据：Eureka 中已经定义好的客户端描述信息。
  - 自定义元数据：在客户端配置文件中自己指定的 Key-Value 数据
### 演示
- 基于 04-consumer-turbine-8080 工程，启动4个Consumer：msc-consumer-depart8080、msc-consumer-depart8081、msc-consumer-depart8082、msc-consumer-depart8083；其中8080、8081为group1，8082、8083为group2，

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210613211252897.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
- 修改 00-hystrix-turbine-8888 工程中的 配置文件：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210613213259419.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
- 启动 Turbine Server，并访问 http://localhost:8888/hystrix，监控 `http://localhost:8888/turbine.stream?cluster=group1`

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210613213152277.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
- 访问各个消费者工程，查看监控情况：

![在这里插入图片描述](https://img-blog.csdnimg.cn/2021061321355012.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)

## 服务降级报警机制

* 无论是由于个别原因导致某个或某些消费者出现问题，还是由于高并发出现消费问题而引发服务熔断，他们都将启用服务降级机制。无论哪种原因启用了服务降级，系统都应该向管理员发出警报通知管理员，例如向管理员发送短信。这种发生服务降级后向管理员发出警报的机制称为**服务熔断报警机制**。
* 在短信发送之前，需要先查看服务降级标识。**该标识可以存放在：作为发生问题主机的全局变量、数据库、Redis等。**
### 创建消费者工程 04-consumer-fallbackalarm-8080
* 复制 04-consumer-hystrix-8080 工程，并重命名为 04-consumer-fallbackalarm-8080。添加 Spring Boot 与 Redis 整合依赖
```xml
<!-- Spring Boot与Redis整合依赖 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```
- application.yml 配置文件中添加redis配置：
```yaml
spring:
	# ...
	# 连接Redis服务器
	redis:
	  host: 192.168.254.128
	  post: 6379
	#  password:
```
- 修改处理器，首先创建一个线程池，包含 5 个线程，然后再修改服务降级方法。
```java
@RestController
@RequestMapping("/consumer/depart")
public class DepartController {
    @Autowired
    private DepartService departService;

    @HystrixCommand(fallbackMethod = "getHystrixHandle")
    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") int id, HttpServletRequest request) {
        return departService.getDepartById(id);
    }

    private Depart getHystrixHandle(@PathVariable("id") int id, HttpServletRequest request) {
        // 指定存放到Redis中的key为"ip + 发生降级的方法名"
        String ip = request.getLocalAddr();
        String key = ip + "_getDepartById";
        // 异常发生后的报警
        queryCache(key);

        return new Depart()
                .setId(id)
                .setName("【Hystrix】No this depart -- 方法级别");
    }

    @Autowired
    private StringRedisTemplate redisTemplate;

    // 创建一个线程池，包含5个线程
    private ForkJoinPool pool = new ForkJoinPool(5);

    /**
     * 异常发生后的报警
     */
    private void queryCache(String key) {
        // 获取Redis操作对象
        BoundValueOperations<String, String> ops = redisTemplate.boundValueOps(key);
        String value = ops.get();
        if(value == null) {
            synchronized (this) {
                value = ops.get();
                if(value == null) {
                    // 使用线程池实现异步短信发送
                    sendFallbackMsg(key);
//                    value = "短信已发送";
//                    ops.set(value, 10, TimeUnit.SECONDS);
                    ops.set("短信已发送", 10, TimeUnit.SECONDS);
                }
            }
        }
    }

    /**
     * 使用线程池实现异步短信发送
     */
    private void sendFallbackMsg(String key) {
        pool.submit(() -> System.out.println("发送服务异常报警短信：" + key));
    }
}
```
- 测试访问 http://localhost:8080/consumer/depart/get/1，查看控制台输出

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210607191649446.png)

# 微服务网关Zuul

## 简介

### 网关简介
- 网关是系统唯一对外的入口，介于客户端与服务器端之间，用于对请求进行鉴权、限流、路由、监控等功能。
### 官网wiki
* **地址**：https://github.com/Netflix/zuul/wiki

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190614220326310.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
* 【**原文**】Zuul is the front door for all requests from devices and web sites(设备和 web 站点) to the backend of the Netflix streaming application(Netflix 流应用后端). As an edge service application(边界服务应用), Zuul is built to enable dynamic routing, monitoring, resiliency and security. It also has the ability to route requests to multiple Amazon Auto Scaling Groups(亚马逊自动缩放组，亚马逊的一种云计算方式)as appropriate(视情况而定， 酌情).
* 【**翻译**】ZUUL 是从设备和 web 站点到 Netflix 流应用后端的所有请求的前门。作为边界服务应用，ZUUL 是为了实现动态路由、监视、弹性和安全性而构建的。它还具有根据情况将请求路由到多个 Amazon Auto Scaling Groups(亚马逊自动缩放组，亚马逊的一种云计算方式)的能力。

### 综合说明

- Zuul 主要提供了对请求的**路由与过滤**功能。
  - **路由**：将外部请求转发到具体的微服务主机，是外部访问微服务系统的统一入口。
  - **过滤**：对外部请求进行干预等。
- 将 Zuul 放到整个系统架构中，其作用是这样的：服务提供者是消费者通过 EurekaServer 进行访问的，即相当于 EurekaServer 是服务提供者的统一入口。那么服务消费者很多，用户怎样访问这些消费者工程呢？当然可以像之前那样直接访问这些工程。但这种方式没有统一的消费者工程调用入口，不便于访问与管理，而 Zuul 就是这样的一个对于消费者的统一入口。这点，从 Spring 官网 http://spring.io 最下面的图中可以体现出来。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190614220818529.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
- 将官方的架构图再进一步抽象，就变为了下图：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190614220853774.png)

## 基本环境搭建

### 创建消费者工程 05-consumer-zuul-8080
- 复制 03-consumer-feign-8080 工程，重命名为 05-consumer-zuul-8080，并在此基础上修改。利用该工程启动三个消费者工程，端口号分别是 8080、8081、8082，接口稍微修改一下：
```java
@RestController
@RequestMapping("/consumer/depart")
public class DepartController {
    @Autowired
    private DepartService departService;
    @Value("${server.port}")
    private int port;
	// ...略
    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") int id) {
        Depart depart = departService.getDepartById(id);
        depart.setName(depart.getName() + " " + port);
        return depart;
    }
}
```
- 依次启动三个消费者工程，和任意一个提供者工程。
### 创建服务网关 00-zuul-server-9000
- 复制 00-hystrix-turbine-8888 工程，重命名为 00-zuul-server-9000，并在此基础上修改。
- 依赖：
```xml
<!-- zuul的依赖 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
</dependency>
```
- 修改启动类，开启 zuul 代理模式：
```java
@EnableZuulProxy
@SpringBootApplication
public class ZuulServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class, args);
    }
}
```
- application.yml 配置文件：
```yaml
server:
  port: 9000

spring:
  application:
    name: msc-zuul-server
# eureka client配置
eureka:
  client:
    service-url:
      defaultZone: http://eureka8100.com:8100/eureka,http://eureka8200.com:8200/eureka,http://eureka8300.com:8300/eureka
```
- 启动 zuul 网关服务，并访问地址 `http://localhost:9000/msc-consumer-depart/consumer/depart/get/1`，查看效果，这样就实现了最基本的 zuul 网关访问。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210613231215409.png)

## 配置Zuul
### 路由策略配置
- 前面的访问方式，需要将微服务名称暴露给用户，会存在安全性问题。所以，可以自定义路径来替代微服务名称，即自定义路由策略，可以在配置文件中添加如下配置：
```yaml
# zuul相关配置
zuul:
  routes:
    # 指定微服务的路由规则
    # /** : 匹配任意多级路径；/* : 匹配一级路径；/?：匹配一级路径，但该路径仅能包含一个字符
    msc-consumer-depart: /depart/**
```
- 这样就可以通过地址：http://localhost:9000/depart/consumer/depart/get/1 访问消费者服务了。
### 路由前缀
* 在配置路由策略时，可以为路由路径配置一个统一的前辍，以便为请求归类。在前面的配置文件中增加如下配置：

![在这里插入图片描述](https://img-blog.csdnimg.cn/2021061323302137.png)
- 这样接口地址就是这样的：http://localhost:9000/api/depart/consumer/depart/get/1
### 服务名屏蔽
* 前面的设置方式可以使用指定的路由路径访问到相应微服务，但使用微服务名称也可以访问到，为了防止服务侵入，可以将服务名称屏蔽。配置修改如下：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210613233409380.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
- 这样一来，就只能通过指定的路由规则进行访问了 http://localhost:9000/api/depart/consumer/depart/get/1 可以， 但是 http://localhost:9000/api/msc-consumer-depart/consumer/depart/get/1 就不可以了。
### 路径屏蔽
- 可以指定屏蔽掉的路径 URI，即只要用户请求中包含指定的 URI 路径，那么该请求将无法访问到指定的服务。通过该方式可以限制用户的权限。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210613233641386.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
- 这样一来，接口：http://localhost:9000/api/depart/consumer/depart/list 就无法正常访问了，但其他接口还可以继续访问。 
### 敏感请求头屏蔽
- 默认情况下，像 Cookie、Set-Cookie、Authorization 等敏感请求头信息会被 zuul 屏蔽掉

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210613234004918.png)
- 我们可以将这些默认屏蔽去掉，当然，也可以添加要屏蔽的请求头。
- 修改 00-zuul-server-9000 的配置文件：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210613234146882.png)
- 修改 05-consumer-zuul-8080 工程的接口：

![在这里插入图片描述](https://img-blog.csdnimg.cn/202106132344494.png)
- 重启 Consumer 和 Zuul 服务，并用 postman 进行接口测试：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210613234837962.png)

## 负载均衡
- 用户提交的请求被路由到一个指定的微服务中，若该微服务名称的主机有多个，则默认采用负载均衡策略是轮询。

![在这里插入图片描述](https://img-blog.csdnimg.cn/2021061400333169.png)

- zuul 里面已经添加了 ribbon，所以使用的负载均衡策略是 ribbon 提供的。同时添加了 hystrix，具有降级功能。

- 前面开启三个消费者工程，已经演示了负载均衡的效果，如果想修改负载均衡策略，可以在 00-zuul-server-9000 工程中做如下修改：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210613235304107.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)

- 测试接口：http://localhost:9000/api/depart/consumer/depart/get/1

## 服务降级

- 当消费者调用提供者时由于各种原因出现无法调用的情况时，消费者可以进行服务降级。那么，若客户端通过网关调用消费者无法调用时，是否可以进行服务降级呢？当然可以，zuul 具有服务降级功能。
- 继续在 00-zuul-server-9000 工程中修改，定义一个降级处理类：
```java
@Component
public class ConsumerFallback implements FallbackProvider {
    @Override
    public String getRoute() {
        // 指定要降级的微服务名称
//        return "*"; // 所有微服务降级
        return "msc-consumer-depart";   // 对指定的进行降级
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                // 返回状态常量
                return HttpStatus.SERVICE_UNAVAILABLE;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                // 返回状态码，这里是503
                return HttpStatus.SERVICE_UNAVAILABLE.value();
            }

            @Override
            public String getStatusText() throws IOException {
                // 返回状态码对应的状态短语，这里为"Service Unavailable"
                return HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                // 设置降级信息
                String msg = "fallback:" + ConsumerFallback.this.getRoute();
                return new ByteArrayInputStream(msg.getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}
```
- 关闭所有的 Consumer 工程，然后访问 http://localhost:9000/api/depart/consumer/depart/get/1：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210614000316136.png)

## 请求过滤

- 在服务路由之前、中、后，可以对请求进行过滤，使其只能访问它应该访问到的资源，增强安全性。此时需要通过 **ZuulFilter 过滤器**来实现对外服务的安全控制。
### 路由过滤架构
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190615134713129.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
### 路由过滤功能演示
- 继续在 00-zuul-server-9000 工程中修改，定义一个路由过滤器类：
```java
@Slf4j
@Component
public class RouteFilter extends ZuulFilter {
    @Override
    public String filterType() {
        // 指定路由之前执行过滤
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        // 在系统最小值-5的前面执行
        return -5;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String user = request.getParameter("user");
        String uri = request.getRequestURI();
        // 只有当请求访问的是 /depart 且 user 为空时是不能通过过滤的
        if (uri.contains("/depart") && StringUtils.isEmpty(user)) {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 对请求通过过滤之后的处理逻辑
        log.info("通过过滤");
        return null;
    }
}
```
- 测试地址：http://localhost:9000/api/depart/consumer/depart/get/1【访问401】、http://localhost:9000/api/depart/consumer/depart/get/1?user=sz【可以访问】

## 令牌桶限流

- 通过对请求限流的方式避免系统遭受“雪崩之灾”。
- 可以使用 Guava(Google 的一种基于 Java 的开源库)的 RateLimit 完成限流的，而其底层使用的是令牌桶算法实现的限流，所以我们先来学习一下令牌桶限流算法。
### 原理
- 令牌桶算法可以应对突发流量的情况

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210614093140425.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)

- 对比 漏斗限流算法

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210614093234775.png)

### 功能演示
- 继续在 00-zuul-server-9000 工程中修改，主要修改 RouteFilter 这个类，RateLimiter 导入的是 Google 的类。为了测试的方便，使令牌桶每秒仅生成 2 个令牌。
```java
@Component
@Slf4j     
public class RouterFilter extends ZuulFilter {
    // 创建一个令牌桶，每秒产生2个令牌
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(2);

    // ...

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();

//        // 1. 若可以立即获取到一个令牌，则返回true，否则返回false，不阻塞
//        RATE_LIMITER.tryAcquire();
//        // 2. 若可以在3秒内获取到5个令牌，则返回true，否则返回false，不阻塞
//        RATE_LIMITER.tryAcquire(5, 3, TimeUnit.SECONDS);
//        // 3. 获取1个令牌，若获取不到，则阻塞
//        RATE_LIMITER.acquire();
//        // 4. 获取5个令牌，若获取不到，则阻塞
//        RATE_LIMITER.acquire(5);
        if (!RATE_LIMITER.tryAcquire()) {
            log.warn("访问量超载");
            // 指定当前请求未通过zuul过滤，默认值为true
            context.setSendZuulResponse(false);
            // 向客户端响应状态码429，请求数量过多
            context.setResponseStatusCode(429);
        }
        return true;
    }
}
```
- 测试接口地址：http://localhost:9000/api/depart/consumer/depart/get/1，正常访问是OK的，当访问比较频繁时就会出现下面的情况

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210614094319125.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)

## 多维请求限流

### 原理
- 使用 Guava 的 RateLimit 令牌桶算法可以实现对请求的限流，但其限流粒度有些大。于是有人就针对 Zuul 编写了一个限流库(spring-cloud-zuul-ratelimit)，提供多种细粒度限流策略，在导入该依赖后我们就可以直接使用了。其限流策略查验对象类型有：
  - **user**：针对用户的限流，即对单位时间窗内经过该网关的用户数量的限制
  - **origin**：针对客户端IP的限流，即对单位时间窗内经过该网关的IP数量的限制
  - **url**：针对请求URL的限流，即对单位时间窗内经过该网关进行请求的URL数量的限制
### 功能演示
- 继续在 00-zuul-server-9000 工程中修改，可以注释掉 RouteFilter 类， 导入 spring-cloud-zuul-ratelimit 依赖，再在配置文件中对其进行相关配置。
```xml
<!-- spring-cloud-zuul-ratelimit依赖 -->
    <dependency>
      <groupId>com.marcosbarbero.cloud</groupId>
      <artifactId>spring-cloud-zuul-ratelimit</artifactId>
      <version>2.2.1.RELEASE</version>
    </dependency>
```
- 修改配置文件，在配置文件中添加如下配置：
```yaml
spring:
  application:
    name: msc-zuul-server
  # 连接Redis服务器
  redis:
    host: 192.168.254.128
    post: 6379
zuul:
  # ...
  # 对限流策略进行配置
  ratelimit:
    enabled: true            # 开启限流
    repository: redis
    default-policy-list:     # 设置限流策略
      - limit: 3             # 在指定的单位时间窗口内启动限流的限定值
        quota: 1             # 指定限流的时间窗口数量
        refresh-interval: 3  # 限流单位时间窗口
        type:                # 指定限流查验对象类型
          - user
          - origin
          - url
```
- 测试接口地址：http://localhost:9000/api/depart/consumer/depart/get/1，正常访问是OK的，当访问比较频繁时就会出现429错误页面。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210614103449931.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)

## 灰度发布

### 原理
> 什么是灰度发布？
- 灰度发布，又名金丝雀发布(当然，也存在这是两种不同发布方式的说法)，是系统**迭代更新、平滑过渡**的一种上线发布方式。
> Zuul灰度发布原理是什么？
- 生产环境中，可以实现灰度发布的技术很多，我们这里要讲的是 zuul 对于灰度发布的实现。而其实现是**基于 Eureka 元数据（自定义元数据）**的。
### 创建工程 00-zuul-gray-9000
- 复制 00-zuul-server-9000 工程，重命名为 00-zuul-gray-9000，并在此基础上进行修改。
- 添加依赖：
```xml
<dependency>
  <groupId>io.jmnarloch</groupId>
  <artifactId>ribbon-discovery-filter-spring-cloud-starter</artifactId>
  <version>2.1.0</version>
</dependency>
```
- 启动类：去掉负载均衡的配置
```java
@EnableZuulProxy
@SpringBootApplication
public class ZuulGrayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGrayApplication.class, args);
    }
}
```
- 使用原子布尔值实现灰度发布的方式：
```java
@Component
public class SimpleGrayFilter extends ZuulFilter {
    private AtomicBoolean flag = new AtomicBoolean(true);

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -5;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 根据布尔值不同，路由到不同的主机，并将布尔值修改为相反值
        if (flag.get()) {
            RibbonFilterContextHolder.getCurrentContext().add("host-mark", "running-host");
            flag.set(false);
        } else {
            RibbonFilterContextHolder.getCurrentContext().add("host-mark", "gray-host");
            flag.set(true);
        }
        return null;
    }
}
```
- 定义过滤器：使用 RibbonFilter 实现灰度发布
```java
@Component
public class RibbonFilterGrayFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -5;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        // 获取指定的头信息，该头信息在浏览器提交请求时携带
        String mark = request.getHeader("gray-mark");
        // 默认将请求路由到running-host上
        // "host-mark"与"running-host"是在消费者工程中添加的元数据key-value
        RibbonFilterContextHolder.getCurrentContext().add("host-mark", "running-host");
        // 若mark的值不空，且为"enable"，则将请求路由到gray-host上
        if (!StringUtils.isEmpty(mark) && "enable".equals(mark)) {
            RibbonFilterContextHolder.getCurrentContext().add("host-mark", "gray-host");
        }
        return null;
    }
}
```
- 利用 05-consumer-zuul-8080 工程，启动三个消费者服务，端口号分别是 8080、8081、8082，其中 8080 是灰度。
- 利用 postman 进行接口测试：http://localhost:9000/api/depart/consumer/depart/get/1

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210614112524431.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
## Zuul的高可用
* Zuul 的高可用非常关键，因为外部请求到后端微服务的流量都会经过 Zuul。故而在生产环境中，我们一般都需要部署高可用的 Zuul 以避免单点故障。
* 作为整个系统入口路由的高可用，需要借助额外的负载均衡器来实现，例如 Nginx、HAProxy、F5 等。在 Zuul 集群的前端部分部署负载均衡服务器。Zuul 客户端将请求发送到负载均衡器，负载均衡器将请求转发到其代理的其中一个 Zuul 节点。这样，就可以实现 Zuul 的高可用。

# 分布式配置管理Spring Cloud Config

- 集群中每一台主机的配置文件都是相同的，对配置文件的更新维护就成为了一个棘手的问题，Spring Cloud Config 是负责 Spring Cloud 中配置文件维护管理的配置中心。
## 概述
### 官网介绍
- 地址：[https://spring.io/projects/spring-cloud-config](https://spring.io/projects/spring-cloud-config)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190615214318540.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
* 【**原文**】Spring Cloud Config provides server and client-side support for externalized configuration in a distributed system. With the Config Server you have a central place to manage external properties for applications across all environments.
* 【**翻译**】Spring Cloud Config 为分布式系统中的外部化配置提供服务器和客户端支持。使用 Config 服务器，可以在中心位置管理所有环境中应用程序的外部属性。
### 综合说明
- Spring Cloud Config 就是对微服务的配置文件进行统一管理的。其工作原理是，我们首先需要将各个微服务公共的配置信息推送到 GitHub 远程版本库。然后我们再定义一个 Spring Cloud Config Server，其会连接上这个 GitHub 远程库。这样我们就可以定义 Config 版的 Eureka Server、提供者与消费者了，它们都将作为 Spring Cloud Config Client 出现，它们都会通过连接 Spring Cloud Config Server 连接上 GitHub 上的远程库，以读取到指定配置文件中的内容。
### 原理
Config Server 可以组装的最终配置文件格式有三种：**yml、properties、json**。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190615214831991.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)

## github远程库设置

### 在github上创建远程库
- 在 github 中创建一个 Spring Cloud Config 的远程版本库，git 库命名为 msc-config-center。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210614122735645.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
### clone远程库到本地
- 设置免密登录：在将远程库克隆到本地库之前需要先配置免密登录，否则会 Clone 会失败。
- **本地生成密钥**：由于生成的密钥默认是存放在本地版本库主机的当前用户主目录下的隐藏目录 `.ssh` 下的两个隐藏文件中，这两个文件分别是 **id_sra** 与 **id_rsa.pub**。其中 **id_sra 中存放的是私钥**，**id_sra.pub 中存放的是公钥**。所以在生成密钥前首先要看本地版本库主机的当前用户主目录， 确认是否存在公钥与私钥。若存在，则可直接使用。若没有，则需要生成。
- 生成秘钥对命令：
```bash
ssh-keygen
```
* 查看本地版本库主机的当前用户主目录，发现已经生成了.ssh 目录，查看该目录，其下也生成了 id_rsa 与 id_rsa.pub 文件，说明 SSH 密钥生成成功。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190615221003576.png)

- 远程设置公钥：打开公钥文件 id_rsa.pub 后复制里面内容。再打开 github 的 setting 设置页面，在相应位置（SSH and GPG keys）将复制的公钥粘贴进去。
- 接下来就可以 clone 到本地了：
```bash
git clone git@github.com:shouwangyw/msc-config-center.git
```
### 将本地配置文件推送到远程库

- 将 msc-config-center 仓库下载到本地后，在其根目录下编辑一个 application.yml 配置文件，该文件将用于后续的测试。为了方便，可以先在 Idea 中编写完毕，然后再复制到本地库。需要注意，该文件字符编码格式必须为 UTF-8，否则 push 到远程库后会出乱码问题。若不确定文件字符编码，可对文件进行另存为，然后选择字符编码。文件内容如下：
```yaml
spring:
  profiles:
    active: dev

---
# 开发环境
spring:
  application:
    name: msc-config-dev
  profiles: dev

---
# 测试环境
spring:
  application:
    name: msc-config-test
  profiles: test
```
- 将配置推送到远程git仓库：
```bash
$ git add *
$ git commit -m "init application.yml"
$ git push
```
- 推送完毕后，刷新远程库页面，就可以看到该文件了。

- 再分别创建三个配置文件：application-eureka-config.yml、application-provider-config.yml、application-consumer-config.yml，分别是 Eureka、Provider、Consumer 的配置文件。
- **application-eureka-config.yml**：
```yaml
# 配置dev环境
spring:
  profiles: dev
  application:
    name: msc-eureka-server-config
server:
  port: 8400
eureka:
  instance:
    # 指定eureka主机
    hostname: eureka8400.com
  client:
    # 指定是否向注册中心注册自己
    register-with-eureka: false
    # 指定此客户端是否能够获取eureka注册信息
    fetch-registry: false
    # 暴露服务中心地址
    service-url:
      defaultZone: http://eureka8400.com:8400/eureka

---
# 配置test环境
spring:
  profiles: test
  application:
    name: msc-eureka-server-config
server:
  port: 8500
eureka:
  instance:
    # 指定eureka主机
    hostname: eureka8500.com
  client:
    # 指定是否向注册中心注册自己
    register-with-eureka: false
    # 指定此客户端是否能够获取eureka注册信息
    fetch-registry: false
    # 暴露服务中心地址
    service-url:
      defaultZone: http://eureka8500.com:8500/eureka
```
- **application-provider-config.yml**：
```yaml
# 配置dev环境
server:
  port: 8190
spring:
  profiles: dev
  application:
    name: msc-provider-depart
  # 配置spring-data-jpa
  jpa:
    # 指定在Spring容器启动时是否自动建表，默认为false
    generate-ddl: true
    # 指定是否在控制台显示其执行的SQL语句，默认false
    show-sql: true
    # 指定应用重启时是否重新创建更新表
    hibernate:
      ddl-auto: none
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://192.168.254.128:3306/test?useUnicode=true&amp;characterEncoding=utf8
    username: root
    password: 123456
eureka:
  client:
    service-url:
      defaultZone: http://eureka8400.com:8400/eureka
   
---
# 配置test环境
server:
  port: 8290
spring:
  profiles: test
  application:
    name: msc-provider-depart
  # 配置spring-data-jpa
  jpa:
    # 指定在Spring容器启动时是否自动建表，默认为false
    generate-ddl: true
    # 指定是否在控制台显示其执行的SQL语句，默认false
    show-sql: true
    # 指定应用重启时是否重新创建更新表
    hibernate:
      ddl-auto: none
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://192.168.254.128:3306/test?useUnicode=true&amp;characterEncoding=utf8
    username: root
    password: 123456
eureka:
  client:
    service-url:
      defaultZone: http://eureka8500.com:8500/eureka
```
- **application-consumer-config.yml**：
```yaml
# 配置dev环境
server:
  port: 8180
spring:
  profiles: dev
  application:
    name: msc-consumer-depart
eureka:
  client:
    service-url:
      defaultZone: http://eureka8400.com:8400/eureka
# 开启Feign对Hystrix的支持
feign:
  hystrix:
    enabled: true

---
# 配置test环境
server:
  port: 8280
spring:
  profiles: test
  application:
    name: msc-consumer-depart
eureka:
  client:
    service-url:
      defaultZone: http://eureka8500.com:8500/eureka
# 开启Feign对Hystrix的支持
feign:
  hystrix:
    enabled: true
```
- 将以上三个创建好的配置文件推送到远端，并在 hosts文件添加配置：
```bash
127.0.0.1		eureka8400.com
127.0.0.1		eureka8500.com
```
## 搭建演示环境

### 创建配置文件工程 00-config-server-9999
- 复制 00-eureka-server-8000 工程，重命名为 00-config-server-9999，并在此基础上进行修改。
- 添加依赖：
```xml
<!-- config的依赖 -->
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-config-server</artifactId>
</dependency>
```
- 启动类：使用 @EnableConfigServer 注解开启 ConfigServer 服务功能
```java
@EnableConfigServer // 开启ConfigServer服务功能
@SpringBootApplication
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
```
- 修改配置文件 application.yml：
```yaml
server:
  port: 9999
# 指定当前工程所关联的 git 远程库地址
spring:
  cloud:
    config:
      server:
        git:
#          uri: git@github.com:shouwangyw/ywmsc-config-center.git
          # macbook上配置为https方式
          uri: https://github.com/shouwangyw/ywmsc-config-center.git
          timeout: 5	# 获取到远程git库连接的超时时限，默认为5秒
          default-label: master	# 指定要操作的远程git库的分支，默认master
          # 指定拉取下来的git库位置
          basedir: /Volumes/D/git/ywmsc-config-center
```
- 启动 ConfigServer 服务，并测试一下：http://configserver.com:9999/application-dev.json

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210614133846171.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
### 创建config版的EurekaServer工程 00-eureka-config-server
- 复制 00-eureka-server-8000 工程，并重命名为 06-config-eurekaserver。
- 添加config客户端依赖：
```xml
<!-- spring cloud config 客户端依赖 -->
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```
- 配置文件修改：将原来的 application.yml 重命名为 bootstrap.yml，配置修改成下面的
```yaml
spring:
  cloud:
    config:
      # 指定ConfigServer的地址
      uri: http://configserver.com:9999
      # config集群地址
      # uri: http://configserver.com:9999,http://configserver.com:8888
      # 指定要拉取配置的分库
      label: main
      # 指定要从远程读取的配置文件名称【无需扩展名】
      name: application-eureka-config
      # 环境选择
      profile: dev
```
- 启动 EurekaServer 服务，能正常启动，端口为远程配置文件设置的8400端口，访问地址`http://eureka8400.com:8400/`测试一下也是OK的。

### 创建config版的提供者工程 06-provider-config

- 复制 04-provider-8090 工程，重命名为 06-provider-config，在此基础上修改。
- 添加依赖：与前面 Eureka 的一样，spring cloud config 客户端依赖。
- 配置文件修改：将原来的 application.yml 重命名为 bootstrap.yml，配置也和 Eureka 的差不多

![在这里插入图片描述](https://img-blog.csdnimg.cn/2021061414020139.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
- 启动工程没有报错，测试接口：http://localhost:8190/provider/depart/get/1，也能正常。
### 创建config版的消费者工程 06-consumer-config
- 复制 04-consumer-hystrix-8080 工程，重命名为 06-consumer-config，在此基础上进行修改。和 06-provider-config 工程一样，添加 spring cloud config 的客户端依赖，并修改配置文件。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210614141552342.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
- 启动工程没有报错，测试接口：http://localhost:8180/consumer/depart/get/1，也能正常。

### 步骤小结

- 对于 Config Server：
  - 导入依赖 `spring-cloud-config-server`
  - 在启动类上添加 @EnableConfigServer，开启 Spring Cloud Config 服务
  - 在配置文件中指定要连接的 git 远程库地址等信息
- 对于 Config Client：
  - 导入依赖 `spring-cloud-starter-config`
  - 删除之前的 application.yml 文件，新建 bootstrap.yml 配置文件，并在其中指定要连接的 Config Server 地址

## 配置自动更新

### Webhooks
- GitHub 中提供了 Webhooks 功能来确保远程库中的配置文件更新后，客户端中的配置信息也可以实时更新。具体实现方式可参考如下一篇博文：[https://blog.csdn.net/qq_32423845/article/details/79579341](https://blog.csdn.net/qq_32423845/article/details/79579341)。
- 这种方式存在很大的弊端，并不适合生产环境下的使用，而 Spring Cloud Bus 消息总线系统解决了这些问题。所以，生产环境下一般使用的是 Spring Cloud Bus 完成配置文件的自动更新。
> webhooks 存在的弊端?
- 每个 config client 都需要在 git 远程库中注册，若 config client 数量发生变化，则需要修改 git 远程库。
- 每个 config client 若要在不重启的情况下更新配置，则都需要提交一个 actuator 的 post 请求。这样的话，若存在多个 config client 需要更新，则需要提交多个这样的 post 请求。

### Spring Cloud Bus概述

#### 官方简介
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190616194418971.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
* 【**翻译**】用于将服务和服务实例与分布式消息系统链接在一起的事件总线。在集群中传播状态更改很有用（例如配置更改事件）。
#### 工作原理
![在这里插入图片描述](https://img-blog.csdnimg.cn/202106141422363.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
#### 配置自动更新原理
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210614142306394.png)

* 向任意一个 Config Client 提交一个 **POST:bus-refresh** 请求，则该 Client 就会把 Config Server 上的更新信息加载下来，同时该 Client 还会把该更新信息通过消息总线系统通知到其它的 Config Client 上，这样这些接收到通知的  Config Client 就会去 Config Server 上把更新信息加载下来。

### 功能演示

#### 修改配置文件
- 分别在 application-consumer-config.yml、application-provider-config.yml 两个配置文件中增加自定义属性：
```yaml
# application-consumer-config.yml 自定义属性
prefix: begin++
```
```yaml
# application-provider-config.yml 自定义属性
suffix: ++end
```
#### 修改消费者和提供者工程
- Consumer 工程：
```java
public class DepartController {
    @Autowired
    private DepartService departService;

    @Value("${prefix}")
    private String prefix;
	
	@GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") int id) {
        Depart depart = departService.getDepartById(id);
        return depart.setName(prefix + depart.getName());
    }
}
```
- Provider 工程：
```java
@Service
public class DepartServiceImpl implements DepartService {
    @Autowired
    private DepartRepository repository;
    @Value("${server.port}")
    private int port;
    @Value("${suffix}")
    private String suffix;
    // ...略

    @Override
    public Depart getDepartById(int id) {
        try {
            TimeUnit.SECONDS.sleep(id);
        } catch (Exception ignore){ }
        // repository.getOne()中指定的id若不存在，则会抛出异常，因此这里要先判断是否存在
        if (repository.existsById(id)) {
            Depart depart = repository.getOne(id);
            depart.setName(rename(depart.getName()));
            return depart;
        }
        return new Depart().setName(port + " No this depart");
    }
    private String rename(String name) {
        return name + suffix;
    }
}
```
- 然后分别启动消费者和提供者工程，并进行接口 `http://localhost:8180/consumer/depart/get/1` 测试。

![在这里插入图片描述](https://img-blog.csdnimg.cn/2021061416543721.png)
- 返回结果分别拼接上了提供者和消费者的自定义属性值，但是这种方式没办法进行动态的更新。

#### Bus实现配置动态更新

- 添加依赖：在 Provider 和 Consumer 中都添加 bus 的依赖
```xml
<!-- bus-kafka依赖 -->
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-bus-kafka</artifactId>
</dependency>
```
- 修改配置文件：配置kafka集群地址，开启 bus-refresh 监控终端
```yaml
spring:
  cloud:
    config:
      # 指定ConfigServer的地址
      uri: http://configserver.com:9999
      # 指定要拉取配置的分库
      label: main
      # 指定要从远程读取的配置文件名称【无需扩展名】
      name: application-consumer-config
      # 环境选择
      profile: dev
  # 配置kafka集群地址
  kafka:
    bootstrap-servers: 192.168.254.128:9092,192.168.254.130:9092,192.168.254.132:9092
# 开启 bus-refresh 监控终端
management:
  endpoints:
    web:
      exposure:
        include: bus-refresh
```
- 接口实现类上加注解 @RefreshScope

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210614170205289.png)
- 重启 Provider 和 Consumer 工程，测试接口：http://localhost:8180/consumer/depart/get/1。修改 Provider 和 Consumer 工程的远程库中的配置文件，此时刷新接口，修改的配置还不会生效，要使得修改的配置生效，还需要提交一个 **POST:bus-refresh** 请求：
```bash
# 任意一个 Config Client 提交这个POST请求都可以
http://localhost:8180/actuator/bus-refresh
```
#### 查看Zookeeper中的信息

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210614171610531.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)

- 查看 Zookeeper 中的信息，Bus 的实现利用了 kafka，主题为 springCloudBus

### 步骤小结

- 导入 actuator 和 bus-kafka 依赖 `spring-cloud-starter-bus-kafka`
- 在配置文件中指定要连接的 kafka 集群地址，并开启 actuator 的 bus-refresh 监控终端
- 在需要自动更新的类上添加 @RefreshScope 注解

# 调用链跟踪Spring Cloud Sleuth+zipkin

- 业界的调用链跟踪产品：
  - Google—Dapper
  - 淘宝-鹰眼-Eagleeye
  - 京东-Hydra
  - 大众点评-cat
  - 新浪-watchman
  - 唯品会-microscope
  - Twitter-Zipkin
## Sleuth简介
- 打开官网就可以看到对 Sleuth 的一个简单功能介绍。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190616221353313.png)
* 【**翻译**】(Spring Cloud Sleuth 可以实现)针对 Spring Cloud 应用程序的分布式跟踪，兼容 Zipkin、HTrace 和基于日志的(如：Elk)跟踪。

## Sleuth基本理论

- Spring Cloud Sleuth 的官方文档中可以查看到服务跟踪的基本理论。
### 三大概念
- 服务跟踪理论中存在有跟踪单元的概念，而跟踪单元中涉及三个重要概念：**trace**、**span**、与 **annotation**。

 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20210614172718625.png)
#### trace与span
* **trace**：跟踪单元是从客户端所发起的请求抵达被跟踪系统的边界开始，到被跟踪系统向客户返回响应为止的过程，这个过程称为一个 trace。
* **span**：每个 trace 中会调用若干个服务，为了记录调用了哪些服务，以及每次调用所消耗的时间等信息，在每次调用服务时，埋入一个调用记录，这样一个调用记录称为一个span。
* **关系**：一个 trace 由若干个有序的 span 组成。
* Spring Cloud Sleuth 为服务之间调用提供链路追踪功能。为了唯一的标识 trace 与 span，系统为每个 trace 与 span 都指定了一个 64 位长度的数字作为 ID，即 traceID 与 spanID。
#### annotation
- 用于及时记录事件的实体，表示一个事件发生的时间点。这些实体本身仅仅是为了原理叙述的方便，对于 Spring Cloud Sleuth 本身并没有什么必要性。这样的实体有多个，常用的有四个：
  - **cs**：Client Send，客户端发送请求的时间点
  - **sr**：Server Receive，服务端接收到请求的时间点
  - **ss**：Server Send，服务端发送响应的时间点
  - **cr**：Client Receive，客户端接收响应的时间点

### Sleuth的日志采样

#### 日志生成
只要在工程中添加了 Spring Cloud Sleuth 依赖， 那么工程在启动与运行过程中就会自动生成很多的日志。Sleuth 会为日志信息打上收集标记，需要收集的设置为 true，不需要的设置为 false。这个标记可以通过在代码中添加自己的日志信息看到。
#### 日志采样率
- Sleuth 对于这些日志支持抽样收集，即并不是所有日志都会上传到日志收集服务器，日志收集标记就起这个作用。默认的采样比例为：0.1，即 10%。在配置文件中可以修改该值。若设置为 1 则表示全部采集，即 100%。
- Sleuth 默认采用的是水塘抽样算法。
## “跟踪日志”的生产者Sleuth
### 创建提供者工程 07-provider-sleuth-8090
- 复制 03-provider-8090 工程，并重命名为 07-provider-sleuth-8090，在此基础上修改。
- 添加 sleuth 依赖
```xml
<!-- sleuth依赖 -->
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-sleuth</artifactId>
</dependency>
```
- 在控制器层接口和业务层添加一些日志，并将配置文件中的日志配置注释掉，修改完后启动提供者工程。

![在这里插入图片描述](https://img-blog.csdnimg.cn/2021061417511047.png)
### 创建消费者工程 07-consumer-sleuth-8080
- 复制 03-consumer-feign-8080 工程，并重命名为 07-consumer-sleuth-8080，在此基础上修改。添加 sleuth 依赖，在控制器层接口和业务层添加一些日志，并将配置文件中的日志配置注释掉，修改完后启动消费者工程。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210614175141192.png)
- 测试接口：http://localhost:8080/consumer/depart/get/1

## zipkin工作过程

### zipkin简介
- zipkin 是 Twitter 开发的一个分布式系统 APM(Application Performance Management，应用性能管理)工具，其是基于 Google Dapper 实现的，用于完成日志的聚合。其与 Sleuth 联用，可以为用户提供调用链路监控可视化 UI 界面。
### zipkin系统结构
#### 服务器组成
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190615204505384.png)
> zipkin 服务器主要由 4 个核心组件构成：
- **Collector**：**收集组件**，它主要用于处理从外部系统发送过来的跟踪信息，将这些信息转换为 Zipkin 内部处理的 Span 格式，以支持后续的存储、分析、展示等功能。
- **Storage**：**存储组件**，它主要用于处理收集器接收到的跟踪信息，默认会将这些信息存储在内存中，也可以修改存储策略，例如，将跟踪信息存储到数据库中。
- **API**：**外部访问接口组件**，外部系统通过这里的API可以实现对系统的监控。
- **UI**：**用于操作界面组件**，基于 API 组件实现的上层应用。通过 UI 组件用户可以方便而有直观地查询和分析跟踪信息。
#### 日志发送方式
- 在 Spring Cloud Sleuth + zipkin 系统中，客户端中一旦发生服务间的调用，就会被配置在微服务中的 Sleuth 的监听器监听，然后生成相应的 Trace 和 Span 信息，并发送给 zipkin 服务端。发送的方式主要有两种：**一种是通过 via HTTP 报文的方式**，**也可以通过 Kafka、RabbitMQ 发送**。

## zipkin服务端搭建

### 启动zipkin服务器
```bash
# 下载
curl -sSL https://zipkin.io/quickstart.sh | bash -s
# 启动
java -jar zipkin.jar
```
### 访问zipkin服务器
- 地址：http://localhost:9411/zipkin

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190618091720462.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)

## sleuth整合zipkin——via HTTP方式
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019061821021759.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
### 修改提供者、消费者工程
- 添加依赖：删除原来的 sleuth 依赖，导入 zipkin 依赖，因为 spring-cloud-starter-zipkin 中已经包含了 sleuth 的依赖。
```xml
<!-- zipkin客户端依赖，其包含了sleuth依赖 -->
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-zipkin</artifactId>
</dependency>
```
- 修改配置文件：在 spring 属性下注册 zipkin 服务器地址，并设置采样比例。
```yaml
spring:
  # 指定zipkin服务地址
  zipkin:
    base-url: http://localhost:9411/
  # 设置采样比例为1.0，即全部都需要，默认为0.1
  sleuth:
    sampler:
      probability: 1.0
```
### 重启运行
- 重启提供者和消费者工程，并在浏览器多次访问接口：http://localhost:8080/consumer/depart/get/1，再打开 zipkin 的UI界面查看

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210614182637323.png)

### 步骤小结

- 添加 zipkin 客户端依赖 `spring-cloud-starter-zipkin`，里面已经包含 sleuth 依赖
- 在配置文件中指定 zipkin 服务器地址，并设置 sleuth 采样率

## sleuth+kafka+zipkin整合

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190618213151849.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70) 
### 修改提供者、消费者工程
- 在前面的工程基础上再添加 kafka 依赖
```xml
<!-- kafka依赖 -->
<dependency>
  <groupId>org.springframework.kafka</groupId>
  <artifactId>spring-kafka</artifactId>
</dependency>
```
- 修改配置文件：
```yaml
spring:
  zipkin:
#    base-url: http://localhost:9411/
    sender:
      type: kafka
  kafka:
    bootstrap-servers: 192.168.254.128:9092,192.168.254.130:9092,192.168.254.132:9092
  # 设置采样比例为1.0，即全部都需要，默认为0.1
  sleuth:
    sampler:
      probability: 1.0
```
### 重启运行
- zipkin的启动方式需要修改：
```bash
java -DKAFKA_BOOTSTRAP_SERVERS=192.168.254.128:9092 -jar zipkin.jar
```
- 重启提供者和消费者工程，并在浏览器多次访问接口：http://localhost:8080/consumer/depart/get/1，再打开 zipkin 的UI界面查看。发现同样可以实现前面的功能。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210614183632622.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
- 查看Zookeeper：zipkin 使用的 kafka 主题是 zipkin

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210614183723492.png)

### 步骤小结

- 添加 zipkin 客户端依赖 `spring-cloud-starter-zipkin`，里面已经包含 sleuth 依赖
- 添加 kafka 依赖 `spring-kafka`
- 在配置文件中指定 要连接的 kafka 集群地址，指定 zipkin 服务器的发送者是 kafka，并设置 sleuth 采样率
- zipkin 启动参数通过 KAFKA_BOOTSTRAP_SERVERS 指定 kafka 集群地址

# 消息系统整合框架Spring Cloud Stream

## 简介
### 官网
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190619091112952.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
* 【**原文**】A lightweight event-driven microservices framework to quickly build applications that can connect to external systems. Simple declarative(声名式的) model to send and receive messages using Apache Kafka or RabbitMQ between Spring Boot apps.
* 【**翻译**】一个轻量级的事件驱动微服务框架，用于快速构建可连接到外部系统的应用程序。在 Spring Boot 应用程序之间使用 Kafka 或 RabbitMQ 发送和接收消息的简单声明式模型。
### 综合
- Spring Cloud Stream 是一个用来为微服务应用构建消息驱动能力的框架。通过使用 Spring Cloud Stream，可以有效简化开发人员对消息中间件的使用复杂度，让系统开发人员可以有更多的精力关注于核心业务逻辑的处理。但是目前 Spring Cloud Stream 只支持 RabbitMQ 和 Kafka 的自动化配置。
- 官方文档：[https://docs.spring.io/spring-cloud-stream/docs/3.1.3/reference/html/](https://docs.spring.io/spring-cloud-stream/docs/3.1.3/reference/html/)
### 程序模型
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019061909154634.png)
- 应用程序的核心部分(Application Core)通过 inputs 与 outputs 管道，与中间件连接，而管道是通过绑定器 Binder 与中间件相绑定的。

## stream kafka微服务

### 创建生产者工程 08-provider-stream-kafka
- 新建一个 spring boot 工程，命名为 08-provider-stream-kafka，添加一个 Spring Cloud Stream Kafka 依赖：
```xml
<!-- stream-binder-kafka依赖 -->
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-stream-binder-kafka</artifactId>
</dependency>
<!--    &lt;!&ndash; 或者使用这个 &ndash;&gt;-->
<!--    <dependency>-->
<!--      <groupId>org.springframework.cloud</groupId>-->
<!--      <artifactId>spring-cloud-starter-stream-kafka</artifactId>-->
<!--    </dependency>-->
```
#### 消息发送给一个主题
- 创建消息生产者类：
```java
// Spring Cloud 中的 Source 类，将MQ与生产者类通过消息管道想绑定
@EnableBinding(Source.class)
@Component
public class SomeProducer {
    // 必须使用byName方式注入消息管道，系统中还定义了名称为 nullChannel、errorChannel 的两个同类型的管道
    @Autowired
    @Qualifier(Source.OUTPUT)
    private MessageChannel channel;

    public void sendMsg(String message) {
        // 通过消息管道发送消息，即消息写入到消息管道，再通过管道写入到 MQ
        channel.send(MessageBuilder.withPayload(message).build());
    }
}
```
- 创建处理器类：
```java
@RestController
public class SomeController {
    @Autowired
    private SomeProducer producer;
    
    @PostMapping("/msg/send")
    public String sendMsg(@RequestParam("message") String message) {
        producer.sendMsg(message);
        return "send success";
    }
}
```
- 创建配置文件application.yml：
```yaml
server:
  port: 8090

spring:
  application:
    name: msc-provider-stream-kafka
  cloud:
    stream:
      kafka:
        binder:
          brokers: 192.168.254.128:9092,192.168.254.130:9092,192.168.254.132:9092
          # 指定是否自动创建主题
          auto-create-topics: true
      bindings:
        output: # 指定要输出的消息主题及类型
          destination: persons
          content-type: text/plain
```
#### 消息发送给多个主题
- 自定义 Source 接口：
```java
public interface CustomSource {
    String CHANNEL_NAME = "xxx";
    @Output(CustomSource.CHANNEL_NAME)
    MessageChannel output();
}
```
- 修改消息发送者类：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210614221408974.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
- 修改配置文件：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210614223612918.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
#### 测试
- 启动项目进行测试，通过 postman 调用接口发送消息，并用命令行启动一个kafka消费者客户端监听消息，命令如下
```bash
[root@centos-host kafka]# bin/kafka-console-consumer.sh --bootstrap-server 192.168.254.128:9092 --topic persons --from-beginning
[root@centos-host kafka]# bin/kafka-console-consumer.sh --bootstrap-server 192.168.254.130:9092 --topic countries --from-beginning
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210614222206539.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
- 消息查看：两个主题都能接收到消息

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210614222222282.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
### 创建消费者工程 08-consumer-stream-kafka
- 复制 08-provider-stream-kafka 工程，重命名为 08-consumer-stream-kafka，在此基础上修改。
- Spring Cloud Stream 提供了三种创建消费者的方式，这三种方式的都是在消费者类的“消费”方法上添加注解。只要有新的消息写入到了管道，该“消费”方法就会执行。只不过三种注解，其底层的实现方式不同。即当新消息到来后，触发“消费”方法去执行的实现方式不同。
  - **@PostConstruct**：以发布/订阅方式实现
  - **@ServiceActivator**：新的消息激活服务方式实现
  - **@StreamListener**：以监听方式实现
#### @PostConstruct方式
- 创建消费者类：
```java
@Component
@EnableBinding(Sink.class)
public class PostConstructConsumer {
    @Autowired
    @Qualifier(Sink.INPUT)
    private SubscribableChannel channel;

    @PostConstruct
    public void receiveMsg() {
        channel.subscribe(new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                System.out.println("@PostConstruct --- " + message.getHeaders() + ", ");
                byte[] payload = (byte[]) message.getPayload();
                System.out.println(new String(payload));
            }
        });
    }
}
```
- 定义配置文件：
```yaml
server:
  port: 8080

spring:
  application:
    name: msc-stream-kafka
  cloud:
    stream:
      kafka:
        binder:
          brokers: 192.168.254.128:9092,192.168.254.130:9092,192.168.254.132:9092
          # 指定是否自动创建主题
          auto-create-topics: true
      bindings:
        input:
          destination: persons
```
- 启动工程，提供者工程调用接口发送消息，消费者可以正确接收消息：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210614224005347.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)

#### @ServiceActivator方式

- 该注解所标注的方法是以服务的形式出现的，只要管道中的数据发生了变化就会激活该服务。
- 注释掉前面定义的消费者，然后重新创建消费者类：
```java
@Component
@EnableBinding(Sink.class)
public class ServiceActivatorConsumer {
    @ServiceActivator(inputChannel = Sink.INPUT)
    public void receiveMsg(Object message) {
        System.out.println("@ServiceActivator --- " + message);
    }
}
```
- 重启工程，提供者工程调用接口发送消息，消费者可以正确接收消息：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210614224501740.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)
#### @StreamListener方式
- 该方式是以监听的方式实现，只要管道中的流数据发生变化，其就会触发该注解所标注的方法的执行。
- 注释掉前面定义的消费者，然后重新创建消费者类：
```java
@Component
@EnableBinding(Sink.class)
public class StreamListenerConsumer {
    @StreamListener(Sink.INPUT)
    public void printMsg(Object message){
        System.out.println(message);
    }
}
```
- 重启工程，提供者工程调用接口发送消息，消费者可以正确接收消息：

![在这里插入图片描述](https://img-blog.csdnimg.cn/2021061422470236.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lhbmd3ZWkyMzQ=,size_16,color_FFFFFF,t_70)

### 步骤小结

#### 创建生产者步骤

- 添加依赖 `spring-cloud-stream-binder-kafka`
- 创建消息生产者类，在该类上添加 @EnableBinding(Source.class) 注解，并声明管道
- 定义处理器，在处理器中调用消息生产者，使其发送消息
- 在配置文件中配置 kafka 集群地址，并指定输出管道所绑定的主题和类型

#### 创建消费者步骤

- 添加依赖 `spring-cloud-stream-binder-kafka`
- 创建消息消费者，在该类上添加 @EnableBinding(Sink.class) 注解，并声明管道
- 在消费者类中定义消费方法，在方法上添加相应的注解：
  - @PostConstruct
  - @ServiceActivator
  - @StreamListener
- 在配置文件中配置 kafka 集群地址，并指定输入管道所绑定的主题




