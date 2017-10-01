package demo_elastic.demo_elastic;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class ElasticClient {

	TransportClient client;

	String clusterName = "elasticsearch";

	String serverhost = "localhost";

	int serverPort = 9300;

	public Client createElasticClient() throws UnknownHostException {

		Settings settings = Settings.builder().put("cluster.name", clusterName)
				.build();
		client = new PreBuiltTransportClient(settings)
				.addTransportAddress(new InetSocketTransportAddress(
						InetAddress.getByName(serverhost), serverPort));

		// System.out.println("######ElasticClinet is
		// created##################");

		System.out.println("--------------------");

		return client;
	}

	public Client getClient() throws UnknownHostException {
		return createElasticClient();
	}
}
