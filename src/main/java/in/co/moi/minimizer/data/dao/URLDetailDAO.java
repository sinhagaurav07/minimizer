package in.co.moi.minimizer.data.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.co.moi.minimizer.data.dto.URLDetailDTO;
import in.co.moi.minimizer.data.model.URLDetailDO;
import in.co.moi.minimizer.data.model.URLDetailPrimaryKey;
import in.co.moi.minimizer.data.repository.URLHandlerRepository;

@Component
public class URLDetailDAO {

	@Autowired
	URLHandlerRepository urlHandlerRepository;
	
	public URLDetailDTO getURLDetailByPrimaryKey(String userId, String shortendURL) {
		
		URLDetailPrimaryKey URLDetailPrimaryKey = new URLDetailPrimaryKey(userId, shortendURL);
		Optional<URLDetailDO> out = urlHandlerRepository.findById(URLDetailPrimaryKey);
		if (out.isPresent()) {
			URLDetailDO urlDetailDO = out.get();
			URLDetailDTO urlDetailDTO = URLDetailDTO.builder()
			.isActive(urlDetailDO.getIsActive())
			.shortendUrl(urlDetailDO.getUrlDetailPrimaryKey().getShortendUrl())
			.targetUrl(urlDetailDO.getTargetUrl())
			.userId(urlDetailDO.getUrlDetailPrimaryKey().getUserId())
			.createdAt(urlDetailDO.getCreationDate())
			.modifiedAt(urlDetailDO.getModifyDate())
			.build();
			
			return urlDetailDTO;
		}else {
			return null;
		}
	}
}
