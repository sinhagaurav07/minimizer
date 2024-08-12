package in.co.moi.minimizer.data.model;

import java.util.Date;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table (value = "url_detail")
public class URLDetailDO {
	@PrimaryKey
	URLDetailPrimaryKey urlDetailPrimaryKey;
	@Column (value = "target_url")
	private String targetUrl;
	@Column (value = "is_active")
	private Boolean isActive;
	@Column (value = "created_at")
	private Date creationDate;
	@Column (value = "modified_at")
	private Date modifyDate;
	
}
