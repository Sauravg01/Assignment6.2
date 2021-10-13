package com.nagarro.java.controller;
@controller
@SessionAttributes({ "BookDTO", "BookDTOS" })
public class book {
	@Autowired
	private BookManagement BookManagement;

	@RequestMapping(value = "/homepage", method = RequestMethod.GET)
	public ModelAndView resultGet(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		List<BookDTO> bookDTOS = BookManagement.getAllBooks();
		model.addObject("BookDTOS", bookDtos);
		model.setViewName("homepage");
		return model;
	}

	@RequestMapping(value = "/Upload", method = RequestMethod.GET)
	public ModelAndView uploadBookGet(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		model.setViewName("Upload");
		return model;
	}

	@RequestMapping(value = "/Upload", method = RequestMethod.POST)
	public ModelAndView uploadBook(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		int code = Integer.parseInt(request.getParameter("code"));
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String doc = request.getParameter("doc");
		BookDTO bookDTO = new BookDTO(code,name, author, doc);
		BookManagement.addBook(bookDTO);
		List<BookDTO> bookDTOS = BookManagement.getAllBooks();
		model.addObject("BookDTOS", bookDTOS);
		model.setViewName("homepage");
		return model;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editBookGet(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		int code = Integer.parseInt(request.getParameter("code"));
		BookDTO bookDTO = bookManagement.getBook(code);
		model.addObject("BookDTO", BookDTO);
		model.setViewName("edit");
		return model;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editBook(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		int code = Integer.parseInt(request.getParameter("code"));
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String doc = request.getParameter("doc");
		BookDTO BookDTO = new BookDTO(code, name, author, doc);
		BookManagement.updateBook(BookDTO);
		List<BookDTO> bookDTOS = BookManagement.getAllBooks();
		model.addObject("BookDTOS", BookDTOS);
		model.setViewName("homepage");
		return model;
	}

	@RequestMapping(value = "/Delete", method = RequestMethod.GET)
	public ModelAndView deleteBookGet(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		int code = Integer.parseInt(request.getParameter("code"));
		BookManagementService.deleteBook(code);
		List<BookDTO> bookDTOS = BookManagement.getAllBooks();
		model.addObject("BookDTOS", BookDTOS);
		model.setViewName("homepage");
		return model;
	}
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ModelAndView downloadBooks(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		List<BookDTO> bookDTOS = BookManagement.getAllBooks();
		response.setContentType("text/csv");
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", "Books.csv");
		response.setHeader(headerKey, headerValue);
		ICsvBeanWriter csvWriter;

		try {
			csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
			String[] headers = { "Code", "Name", "Author", "Date" };
			csvWriter.writeHeader(headers);
			for (BookDTO BookDTO : BookDTOS) {
				csvWriter.write(BookDTO, headers);
			}
			csvWriter.close();
		} catch (Exception e) {
		}
		mv.addObject("BookDTOS", BookDTOS);
		mv.setViewName("homepage");
		return mv;
	}


}
