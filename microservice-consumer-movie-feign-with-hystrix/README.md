# microservice-simple-consumer-movie-feign-with-hystrix

第一步：首先开启Feign对Hystrix的支持，在properties文件中添加以下配置：

feign.hystrix.enabled=true.

第二步：在上一篇Feign的基础上添加Hystrix（断路由）

@FeignClient(name = "microservice-privider-user", fallback = HystrixClientFallback.class)
public interface UserFeignClient {

	@RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
}
第三步：编写HystrixClientFallback类

@Component
public class HystrixClientFallback implements UserFeignClient {

	@Override
	public User findById(Long id) {
		User user = new User();
		user.setId(0L);
		return user;
	}

}

测试步骤：把你需要调用的服务挂掉，使用Feign调用服务，如果返回 “调用服务失败“ 则Hystrix（断路由）生效
