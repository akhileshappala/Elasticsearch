package demo_elastic.demo_elastic;

import java.math.BigDecimal;
import java.net.UnknownHostException;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AddData {

	@SuppressWarnings("deprecation")
	public IndexResponse addData()
			throws JsonProcessingException, UnknownHostException

	{
		ObjectMapper objectMapper = new ObjectMapper();
		EmployeeVO emp = getEmployeeObj();
		String json = objectMapper.writeValueAsString(emp);
		ElasticClient elasticClient = new ElasticClient();
		Client client = elasticClient.getClient();
		return client.prepareIndex("demo-elastic", "article", "20")
				.setSource(json).get();

	}

	private EmployeeVO getEmployeeObj() {
		EmployeeVO emp = new EmployeeVO();
		emp.setEmployeeId("001");
		emp.setEmployeeName("Hiren");
		emp.setAddressLine1("Raj Nagar Society");
		emp.setAddressLine1("Behind NID");
		emp.setBand("level 2");
		emp.setCityName("Ahmedabad");
		emp.setCountryName("India");
		emp.setSalary(new BigDecimal(20000));
		emp.setStateName("Gujarat");
		emp.setZipcode("380007");
		emp.setActive(true);

		return emp;
	}
}
