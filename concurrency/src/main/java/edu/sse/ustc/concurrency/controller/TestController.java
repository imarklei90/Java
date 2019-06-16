package main.java.edu.sse.ustc.concurrency.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author imarklei90
 * @since 2019.06.04
 */

@Controller
@Slf4j
public class TestController {

	@RequestMapping("/test")
	@ResponseBody
	public String test(){
		return "test";
	}
}
