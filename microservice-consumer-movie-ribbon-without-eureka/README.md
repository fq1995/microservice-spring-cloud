# microservice-simple-consumer-movie
ribbon默认为轮询
自定义ribbon时，@RibbonClient(name="microservice-privider-user", configuration=TestConfig.class)有三种方式：
1.TestConfig类不能在启动类所在的包以及子包下
2.若TestConfig类在启动类所在的包或子包下，需要在启动类的同级目录下增加一个注解ExcludeFormComponentScan，在启动类上@ComponentScan(excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFormComponentScan.class)})，在配置类TestConfig上添加注解@ExcludeFormComponentScan
3.修改application.yml文件，增加
microservice-privider-user:
  ribbon:
    NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule
NFLoadBalancerRuleClassName为实现了IRule接口的Rule类的全路径名