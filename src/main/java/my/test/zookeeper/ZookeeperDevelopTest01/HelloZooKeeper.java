package my.test.zookeeper.ZookeeperDevelopTest01;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import com.sun.jndi.toolkit.url.UrlUtil;

/**
 * Hello world!
 *
 */
public class HelloZooKeeper 
{
	public static void main(String[] args) {
		try {
			ZooKeeper zk = new ZooKeeper("localhost:2181", 600, null);
			System.out.println("----------------------------------创建前的节点");
			List<String> children = zk.getChildren("/dubbo/com.base.service.DemoService/providers", false);
			System.out.println("节点数："+children.size());
			for (String child : children) {
				String decode = URLDecoder.decode(child, "UTF-8");
				System.out.println("服务地址："+decode);
			}
//			byte[] data = zk.getData("/dubbo/com.base.service.DemoService/providers/dubbo%3A%2F%2F172.16.5.118%3A20880%2Fcom.base.service.DemoService%3Fanyhost%3Dtrue%26application%3Ddemo-provider%26dubbo%3D2.5.3%26group%3DdemoService01%26interface%3Dcom.base.service.DemoService%26methods%3DsayHello%26pid%3D7260%26register%3Dtrue%26side%3Dprovider%26timestamp%3D1533800398206", false, null);
//			System.out.println("数据:"+data);
//			System.out.println("----------------------------------------------");
//			
//			byte[] data = zk.getData("/dubbo/com.smy.framework.dynamic.config.service.ParameterConfigService/providers/zookeepertest01", false, null);
//			System.out.println("数据："+data);
////			zk.create("/dubbo/com.smy.framework.dynamic.config.service.ParameterConfigService/providers/zookeepertest01", "test你妹的".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
////			zk.create("/dubbo/com.smy.framework.dynamic.config.service.ParameterConfigService/providers/zookeepertest02_PERSISTENT_SEQUENTIAL", "test你妹的2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
//			zk.create("/dubbo/com.smy.framework.dynamic.config.service.ParameterConfigService/providers/zookeepertest03_PERSISTENT_SEQUENTIAL", "test你妹的3，临时节点".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
//			
//			System.out.println("----------------------------------创建后的节点");
//			List<String> children_after = zk.getChildren("/dubbo/com.smy.framework.dynamic.config.service.ParameterConfigService/providers", false);
//			System.out.println("节点数："+children_after.size());
//			for (String child : children_after) {
//				System.out.println(child);
//			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeeperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
