package top.macondo.java.crypto;

import org.junit.Test;

import java.security.Provider;
import java.security.Security;
import java.util.Arrays;

/**
 * @author: zhangchong
 * @Date: 2020/12/14 16:57
 **/
public class ProviderTest {
	/**
	 *查看当前JDK中Cipher的所有提供商
	 */
	@Test
	public void testProviders(){
		Provider[] providers = Security.getProviders();
		Arrays.stream(providers).forEach(provider -> {
			provider.getServices().stream().forEach(service -> {
				if ("Cipher".equals(service.getType())) {
					System.out.println(String.format("provider:%s,type:%s,algorithm:%s", service.getProvider(), service.getType(), service.getAlgorithm()));
				}
			});
		});
	}
}
