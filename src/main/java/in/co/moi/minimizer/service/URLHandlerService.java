package in.co.moi.minimizer.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.co.moi.minimizer.data.dto.URLActivateStateDTO;
import in.co.moi.minimizer.data.dto.URLCreateDTO;
import in.co.moi.minimizer.data.dto.URLDeleteDTO;
import in.co.moi.minimizer.data.dto.URLDetailDTO;
import in.co.moi.minimizer.data.dto.URLSearchDTO;
import in.co.moi.minimizer.data.dto.URLUpdateDTO;
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

		URLDetailDO urlDetailDO = URLDetailDO.builder().isActive(false).creationDate(new Date()).modifyDate(new Date())
				.targetUrl(urlCreateDTO.getTargetUrl()).build();
		urlDetailDO.setUrlDetailPrimaryKey(new URLDetailPrimaryKey(userId, shortendUrl));
		urlDetailDO = urlHandlerRepository.save(urlDetailDO);

		if (urlDetailDO.getUrlDetailPrimaryKey().getShortendUrl() != null
				&& !urlDetailDO.getUrlDetailPrimaryKey().getShortendUrl().isEmpty())
			return "Shorthend URL created - " + shortendUrl;
		else
			return "Shorthend URL Not created";
	}

	public String deleteURLHandler(String userId, URLDeleteDTO urlDeleteDTO) {
		String shortendURL = urlDeleteDTO.getShortendURL();

		URLDetailPrimaryKey URLDetailPrimaryKey = new URLDetailPrimaryKey(userId, shortendURL);
		urlHandlerRepository.deleteById(URLDetailPrimaryKey);

		return "Delete Complete";
	}

	public String updateURLHandler(String userId, URLUpdateDTO urlUpdateDTO) {
		String shortendURL = urlUpdateDTO.getShortendUrl();
		String targetURL = urlUpdateDTO.getTargetUrl();
		URLDetailPrimaryKey URLDetailPrimaryKey = new URLDetailPrimaryKey(userId, shortendURL);
		Optional<URLDetailDO> out = urlHandlerRepository.findById(URLDetailPrimaryKey);
		URLDetailDO urlDetailDONew = null;
		if (out.isPresent()) {
			URLDetailDO urlDetailDO = out.get();
			urlDetailDO.setTargetUrl(targetURL);
			urlDetailDO.setModifyDate(new Date());
			urlDetailDO.setIsActive(false);
			urlDetailDONew = urlHandlerRepository.save(urlDetailDO);
		}
		if (urlDetailDONew != null)
			return "Update Complete";
		else
			return "Update not completed";
	}

	public String activateURLHandler(String userId, URLActivateStateDTO urlActivateStateDTO) {
		String shortendURL = urlActivateStateDTO.getShortendUrl();
		boolean isActive = Boolean.valueOf(urlActivateStateDTO.getIsActive());
		URLDetailPrimaryKey URLDetailPrimaryKey = new URLDetailPrimaryKey(userId, shortendURL);

		Optional<URLDetailDO> out = urlHandlerRepository.findById(URLDetailPrimaryKey);
		URLDetailDO urlDetailDONew = null;
		if (out.isPresent()) {
			URLDetailDO urlDetailDO = out.get();
			urlDetailDO.setModifyDate(new Date());
			urlDetailDO.setIsActive(isActive);
			urlDetailDONew = urlHandlerRepository.save(urlDetailDO);
		}
		if (urlDetailDONew != null)
			return "Activate Status is updated ";
		else
			return "Activate Status is not updated";
	}

	public List<URLDetailDTO> searchURLHandler(String userId, URLSearchDTO urlSearchDTO) {
		String shortendURL = urlSearchDTO.getShortendUrl();
		List<URLDetailDTO> list = new ArrayList<URLDetailDTO>();
		URLDetailPrimaryKey URLDetailPrimaryKey = new URLDetailPrimaryKey(userId, shortendURL);
		Optional<URLDetailDO> out = urlHandlerRepository.findById(URLDetailPrimaryKey);
		if (out.isPresent()) {
			URLDetailDO urlDetailDO = out.get();
			URLDetailDTO urlDetailDTO = new URLDetailDTO();
			urlDetailDTO.setActive(urlDetailDO.getIsActive());
			urlDetailDTO.setShortendUrl(shortendURL);
			urlDetailDTO.setUserId(userId);
			urlDetailDTO.setCreatedAt(urlDetailDO.getCreationDate());
			urlDetailDTO.setModifiedAt(urlDetailDO.getModifyDate());
			urlDetailDTO.setTargetUrl(urlDetailDO.getTargetUrl());
			list.add(urlDetailDTO);
		}
		return list;
	}

	public List<URLDetailDTO> searchByUserURLHandler(String userId) {
		List<URLDetailDTO> list = new ArrayList<URLDetailDTO>();
		URLDetailPrimaryKey URLDetailPrimaryKey = new URLDetailPrimaryKey();
		List<URLDetailDO> out = urlHandlerRepository.findAll();
		Iterator itr = out.iterator();
		while (itr.hasNext()) {
			URLDetailDO urlDetailDO = (URLDetailDO) itr.next();
			URLDetailPrimaryKey = urlDetailDO.getUrlDetailPrimaryKey();

			if (URLDetailPrimaryKey.getUserId().equalsIgnoreCase(userId)) {
				URLDetailDTO urlDetailDTO = new URLDetailDTO();
				urlDetailDTO.setActive(urlDetailDO.getIsActive());
				urlDetailDTO.setShortendUrl(urlDetailDO.getUrlDetailPrimaryKey().getShortendUrl());
				urlDetailDTO.setUserId(userId);
				urlDetailDTO.setCreatedAt(urlDetailDO.getCreationDate());
				urlDetailDTO.setModifiedAt(urlDetailDO.getModifyDate());
				urlDetailDTO.setTargetUrl(urlDetailDO.getTargetUrl());
				list.add(urlDetailDTO);
			}
		}
		return list;
	}
}
