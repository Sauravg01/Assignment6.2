package com.nagarro.java.controller;


@Controller
@SessionAttributes({  "authorized", "error" }
public class loginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private BookManagementService bookManagementService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGet(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean userAuthenticated = loginService.loginAuthentication(username, password);

		if (userAuthenticated) {
			List<BookDto> bookDtos = bookManagementService.getAllBooks();
			mv.addObject("bookDtos", bookDtos);
			mv.addObject("authorized", "true");
			mv.setViewName("homepage");
		} else {
			mv.addObject("error", "Username or Password is Invalid.");
			mv.setViewName("login");
		}
		return mv;
	}
}
