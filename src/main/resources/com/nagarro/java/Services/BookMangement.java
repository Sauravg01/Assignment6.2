package com.nagarro.java.Services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.nagarro.java.DTO.BookDTO;
@Service
public class BookMangement {
	public List<BookDTO> getAllBooks() {
		String url = "http://localhost:8081/books/";

		RestTemplate restTemplate = new RestTemplate();

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		// Add the Jackson Message converter
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

		// Note: here we are making this converter to process any kind of response,
		// not only application/*json, which is the default behaviour
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);

		ParameterizedTypeReference<List<BookDTO>> responseType = new ParameterizedTypeReference<List<BookDTO>>() {
		};
		ResponseEntity<List<BookDTO>> response = restTemplate.exchange(url, HttpMethod.GET, null, responseType);
		List<BookDTO> booksDtos = response.getBody();
		return booksDtos;
	}

	public BookDto getBook(int code) {
		String url = "http://localhost:8081/books/" + code;

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, BookDTO.class);
	}

	public void addBook(BookDTO BookDTO) {
		String url = "http://localhost:8081/books/";

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<BookDTO> request = new HttpEntity<>(BookDTO);
		restTemplate.postForObject(url, request, BookDTO.class);
	}

	public void updateBook(BookDTO BookDTO) {
		String url = "http://localhost:8081/employees/";
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<BookDTO> request = new HttpEntity<>(bookDto);
		restTemplate.put(url, request);
	}

	public void deleteBook(int code) {
		String url = "http://localhost:8081/books/" + code;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
	}
	

}
