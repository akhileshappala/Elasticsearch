package demo_elastic.demo_elastic;

import java.net.UnknownHostException;
import java.util.Map;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;

public class ListData {

	public void getResponseData() throws UnknownHostException {

		ElasticClient elasticClient = new ElasticClient();
		Client client = elasticClient.getClient();

		GetResponse actionGet = client
				.prepareGet("demo-elastic", "article", "20").execute()
				.actionGet();

		Map<String, Object> source = actionGet.getSource();

		System.out.println(source);

	}

}
