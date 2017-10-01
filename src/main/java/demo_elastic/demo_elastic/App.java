package demo_elastic.demo_elastic;

import org.elasticsearch.action.index.IndexResponse;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		addDataCall();
	}

	private static void addDataCall() throws Exception {
		AddData addData = new AddData();
		IndexResponse indexResponse = addData.addData();
		System.out.println(indexResponse.toString());

		ListData demo = new ListData();
		demo.getResponseData();

		RetriveData rdata = new RetriveData();
		rdata.retrieveData();

	}

}
