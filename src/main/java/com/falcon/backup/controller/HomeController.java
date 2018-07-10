package com.falcon.backup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class HomeController {
	

	/**
	 * * Home redirection to swagger api documentation * @return redirect to
	 * swagger docu
	 */
	@RequestMapping(value = "/")
	public String index() {
		return "redirect:swagger-ui.html";
	}
}
