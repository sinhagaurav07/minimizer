package in.co.moi.minimizer.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import in.co.moi.minimizer.BaseTest;
import in.co.moi.minimizer.data.dao.URLDetailDAO;
import in.co.moi.minimizer.data.dto.URLCreateDTO;
import in.co.moi.minimizer.data.dto.URLDetailDTO;
import in.co.moi.minimizer.data.dto.URLSearchDTO;
import in.co.moi.minimizer.data.model.URLDetailDO;
import in.co.moi.minimizer.data.model.URLDetailPrimaryKey;
import in.co.moi.minimizer.data.repository.URLHandlerRepository;

@ExtendWith(MockitoExtension.class)
public class URLHandlerServiceTest extends BaseTest{
	
	@InjectMocks
	private URLHandlerService urlHandlerService;
	
	@Mock
	private URLHandlerRepository urlHandlerRepository;
	
	@Mock
	private URLDetailDAO urlDetailDAO;
	  
	
	@Test
	public void searchURLHandlerTest() {
		String userId = "1";
		
		URLSearchDTO urlSearchDTO = new URLSearchDTO();		
		urlSearchDTO.setShortendUrl("asdasd");
		
		URLDetailDTO expected = URLDetailDTO.builder()
									.shortendUrl(urlSearchDTO.getShortendUrl())
									.targetUrl("www.test.com")
									.userId(userId)
									.build();
		
		when(urlDetailDAO.getURLDetailByPrimaryKey(any(), any())).thenReturn(expected);
		URLDetailDTO actual = urlHandlerService.searchURLHandler(userId, urlSearchDTO);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void createURLHandlerTest() {
		String userId = "1";
		URLCreateDTO urlCreateDTO = new URLCreateDTO();
		urlCreateDTO.setTargetUrl("www.test.com");
		
		URLDetailPrimaryKey pk = new URLDetailPrimaryKey(userId, urlCreateDTO.getTargetUrl());
		
		URLDetailDO data = URLDetailDO.builder()
								.urlDetailPrimaryKey(pk)
								.targetUrl("84cc0e5c525dc728e1769ad6663341c8")
								.isActive(false)
								.creationDate(new Date())
								.modifyDate(new Date())
								.build();
		String expected = "Shorthend URL created - 84cc0e5c525dc728e1769ad6663341c8";
		
		when(urlHandlerRepository.save(any())).thenReturn(data);
		String actual = urlHandlerService.createURLHandler(userId, urlCreateDTO);
		
		assertEquals(expected, actual);
	}

}
