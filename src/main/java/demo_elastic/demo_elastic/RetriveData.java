package demo_elastic.demo_elastic;

import java.net.UnknownHostException;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;

public class RetriveData {

	protected final String INDEX_NAME = "demo-elastic";
	protected final int scrollSize = 10;
	protected final int scrollSizeArtisan = 100;

	public void retrieveData()
			throws JsonProcessingException, UnknownHostException

	{
		ElasticClient elasticClient = new ElasticClient();
		Client client = elasticClient.getClient();
		SearchResponse response = null;
		try {
			response = client.prepareSearch().setIndices(INDEX_NAME)
					.setTypes("article")
					.setQuery(QueryBuilders.matchQuery("employeeName", "Hiren"))
					.execute().actionGet();
		} catch (Throwable e) {
			// return new HashSet<String>();
		}

		System.out.println(response);

		// Set<String> result = new HashSet<String>();
		// for (SearchHit hit : response.getHits()) {
		// Long id = hit.field("id").<Long>getValue();
		// result.add(String.valueOf(id));
		// }
	}

}
