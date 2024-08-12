package in.co.moi.minimizer.data.model;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import lombok.AllArgsConstructor;
import lombok.Data;

@PrimaryKeyClass
@Data
@AllArgsConstructor
public class URLDetailPrimaryKey {

	public URLDetailPrimaryKey() {
		// TODO Auto-generated constructor stub
	}
	@PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private String userId;
	@PrimaryKeyColumn(name = "shortend_url", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
	private String shortendUrl;
}
