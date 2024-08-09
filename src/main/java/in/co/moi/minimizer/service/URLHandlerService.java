package in.co.moi.minimizer.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.co.moi.minimizer.data.dto.URLCreateDTO;
import in.co.moi.minimizer.data.model.URLDetailDO;
import in.co.moi.minimizer.data.model.URLDetailPrimaryKey;
import in.co.moi.minimizer.data.repository.URLHandlerRepository;
import in.co.moi.minimizer.utils.MinimizerUtility;

@Service

public class URLHandlerService {

	@Autowired
	URLHandlerRepository urlHandlerRepository;

	public String createURLHandler(String userId, URLCreateDTO urlCreateDTO) {
		String shortendUrl = MinimizerUtility.getMd5(urlCreateDTO.getTargetUrl());

		URLDetailDO urlDetailDO=URLDetailDO.builder()
				.isActive(false)
				.creationDate(new Date())
				.targetUrl(urlCreateDTO.getTargetUrl())
				.build();
		urlDetailDO.setUrlDetailPrimaryKey(new URLDetailPrimaryKey(userId, shortendUrl));
		urlHandlerRepository.save(urlDetailDO);
		
		return null;
	}

}
