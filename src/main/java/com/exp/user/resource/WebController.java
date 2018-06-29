package com.exp.user.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

	
	@GetMapping(value="/2D3D")
    public String samplepage(){
        return "sample1";
    }
	
	@RequestMapping(value="/2D3D",method = RequestMethod.POST)
    public String samplepage1(){
        return "sample1";
    }
}