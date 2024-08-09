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
@Table
public class URLDetailDO {
	@PrimaryKey
	URLDetailPrimaryKey urlDetailPrimaryKey;
	@Column
	private String targetUrl;
	@Column
	private boolean isActive;
	@Column
	private Date creationDate;
	@Column
	private Date modifyDate;
}
