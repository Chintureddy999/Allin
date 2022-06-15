package com.zensar.messageapi.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.zensar.messageapi.entity.Message;

@Controller
public class MessageController {
	private List<Message> messages;

    public MessageController()
    {
        this.messages = new ArrayList<Message>();
        Message m1 = new Message();
        m1.setId(1);
        m1.setMessage("Good Morning Chintu");
        this.messages.add(m1);
    }
    @GetMapping("/message")
    public String showAllMessages(Model m) {
    	//in following statement allMessages
    	m.addAttribute("allMessages",this.messages);
    	return"messages";//this String is html page name
    }
    //this method might throw Exception
	@GetMapping("/welcome")
	public String home(Model m) {
		System.out.println("in home()");
		m.addAttribute("name","Zensar India");
		//return "index";//here we are returning name of html page(thymeleaf templeate)
		   throw new RuntimeException();            //this templeate must be present in src/main/resources/templeates folder
	}

}
