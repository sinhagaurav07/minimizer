package in.co.moi.minimizer.data.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import lombok.Data;

@Data
public class URLMappingDO {
	@PrimaryKey
	private String shortendUrl;
	@Column
	private String targetUrl;
	@Column
	private boolean isActive;

}
