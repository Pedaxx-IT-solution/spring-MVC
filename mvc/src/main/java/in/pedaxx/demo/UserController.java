package in.pedaxx.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
	private UserDao userdao;

	@GetMapping("/signup")
	public ModelAndView signup() {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("signup");

		return mv;
	}

	@GetMapping("/signin")
	public ModelAndView signin() {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("signin");

		return mv;
	}

	@PostMapping("/signup")
	public ModelAndView registration(User user) {

		ModelAndView mv = new ModelAndView();

		this.userdao.inserdb(user);
		mv.setViewName("signin");

		return mv;

	}

	@PostMapping("/signin")
	public ModelAndView signin(User user) {

		ModelAndView mv = new ModelAndView();

		boolean getuser = this.userdao.authenticate(user);

		if (getuser == true) {
			mv.setViewName("home");
		} else {
			mv.setViewName("signup");
		}

		return mv;
	}

	@GetMapping("/thymeleafdemo")
	public String checkthymeleafdependency() {
		
		// adding html file in templates folder
		
		/*
		 * add index.html file on templates folder and for redenring html file use
		 * depandency = spring-boot-starter-thymeleaf
		 * add this dependency for html pages 
		 * <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-
		 * starter-thymeleaf --> <dependency>
		 * <groupId>org.springframework.boot</groupId>
		 * <artifactId>spring-boot-starter-thymeleaf</artifactId>
		 * <version>2.3.1.RELEASE</version> </dependency>
		 * 
		 * and previsouly we where using tomcat jasper so we have to remove that
		 * dependency and also in appplication.properties file remove view.suffix and
		 * view.prefix
		 */
		
		return "index";
	}

}
