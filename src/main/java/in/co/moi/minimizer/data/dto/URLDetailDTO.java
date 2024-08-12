package in.co.moi.minimizer.data.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class URLDetailDTO {
	private String userId;
	private String shortendUrl;
	private String targetUrl;
	private Date createdAt;
	private Date modifiedAt;
	private boolean isActive;
}
