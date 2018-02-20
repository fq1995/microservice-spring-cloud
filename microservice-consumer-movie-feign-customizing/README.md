# microservice-simple-consumer-movie-feign-customizing

UserFeignClient的配置类为Configuration1,feignContract设置为feign.Contract.Default()，
所以UserFeignClient类的方法需要使用feign的注解@RequestLine("GET /simple/{id}")

FeignClient2的配置类为Configuration2，feignContract设置成默认的SpringMvcContract，
所以可以使用springMVC的注解@RequestMapping(value = "/eureka/apps/{serviceName}", method = RequestMethod.GET)

