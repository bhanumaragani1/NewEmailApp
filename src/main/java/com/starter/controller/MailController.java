package com.starter.controller;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.starter.model.MailModel;
import com.starter.util.EmailUtil;

@Controller
@RequestMapping("/email")
public class MailController {

	@Autowired
	private EmailUtil util;
	
	@RequestMapping(value="/new")
	public String saveData(@ModelAttribute MailModel product,
			Model map)
	{
		//clean Form Backing Object
		map.addAttribute("mailModel", new MailModel());
		return "Email";
	}
	
	@RequestMapping(value="/sent")
	public String sentMsg(@ModelAttribute MailModel mail,
			Model map,@RequestParam MultipartFile fileObj)
	{
		String[] cc = mail.getCc();
		String[] bcc = mail.getCc();
		
		System.out.println(Arrays.asList(cc));
		System.out.println(Arrays.asList(bcc));
		//clean Form Backing Object
		util.send(mail.getTo(), 
				  mail.getSub(),
				  mail.getText(),
				  mail.getCc(),
//				  mail.getBcc(),				  
				  fileObj);		
//		map.addAttribute("message", "new email: "+
//									" "+mail.getTo()+
//									" "+bcc+
//									" "+mail.getSub()+
//									" "+cc+
//									" "+mail.getText());
		map.addAttribute("message","Sent");
		map.addAttribute("mailModel", new MailModel());
		return "Email";
	}
}
