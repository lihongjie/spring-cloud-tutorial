spring-cloud-zipkin示例

例子主要是通过RestTemplate来调用其他服务的，同样的可以结合Eureka和 Feign调用。

Zipkin Server里面有很多种存储方式，这里默认为内存存储模式。

注意事项：


1.我自己新建的项目，pom.xml文件中版本是2.0.3.RELEASE，跑不起来，降低版本改成1.5.2，就可以了。

2.有时候（并不是每个人的项目都会出现这种情况）在Zipkin-Traces中看不到数据，那是因为默认sleuth收集信息的比率是0.1 ，针对于这个问题有两种解决方法：

方式一：在配置文件中配置

spring.sleuth.sampler.percentage=1

方式二：在代码中声明
@Bean
public AlwaysSampler defaultSampler(){
    return new AlwaysSampler();
}


3.我的AlwaysSampler 一开始也报错，网上找的资料说把上面的代码改成

@Bean
public Sampler defaultSampler() {
    return Sampler.ALWAYS_SAMPLE;
}

实践时，根本不起作用，更改了pom依赖版本来解决。