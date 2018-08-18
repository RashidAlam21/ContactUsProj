/**
 * 
 */
package com.nt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.command.ContactCommand;
import com.nt.dto.ContactDTO;
import com.nt.service.ContactService;
import com.nt.service.UserService;

/**
 * @author Md Rashid Alam
 *
 */
@Controller  
public class ContactController {
	@Autowired
	private ContactService cService;
	@RequestMapping("/user/contact_form")
	public String contactForm(Model m) {
	    ContactCommand ccmd=new ContactCommand();
		m.addAttribute("command", ccmd);
		return "contact_form";
	}
	@RequestMapping("/user/save_contact")
	public String saveOrUpdateContact(@ModelAttribute("command") ContactCommand ccmd,Model m,HttpSession session) {
		Integer contactId=(Integer) session.getAttribute("aContactId");
		if(contactId==null) {
			try {
				System.out.println(ccmd);
				Integer userId=(Integer) session.getAttribute("userId");
				ContactDTO cdto=new ContactDTO();
				cdto.setContactId(ccmd.getContactId());
				cdto.setUserId(userId);
				cdto.setName(ccmd.getName());
				cdto.setPhone(ccmd.getPhone());
				cdto.setEmail(ccmd.getEmail());
				cdto.setAddress(ccmd.getAddress());
				cdto.setRemark(ccmd.getRemark());
				Integer status=cService.save(cdto);
				m.addAttribute("status", status);
				return "redirect:clist?act=sv";
			}catch(Exception e) {
				e.printStackTrace();
				m.addAttribute("err", "Failed to save contact.");
				return "contact_form";
			}
		}else {
			try {
				System.out.println(ccmd);
				Integer userId=(Integer) session.getAttribute("userId");
				ContactDTO cdto=new ContactDTO();
				cdto.setContactId(contactId);//pk
				cdto.setUserId(userId);
				cdto.setName(ccmd.getName());
				cdto.setPhone(ccmd.getPhone());
				cdto.setEmail(ccmd.getEmail());
				cdto.setAddress(ccmd.getAddress());
				cdto.setRemark(ccmd.getRemark());
				Integer status=cService.update(cdto);
				m.addAttribute("status", status);
				return "redirect:clist?act=ed";
			}catch(Exception e) {
				e.printStackTrace();
				m.addAttribute("err", "Failed to edit contact.");
				return "contact_form";
			}
		}
	}
	@RequestMapping("/user/clist")
	public String contactList(Model m,HttpSession session) {
	    //ContactCommand ccmd=new ContactCommand();
		//m.addAttribute("command", ccmd);
		Integer userId=(Integer)session.getAttribute("userId");
		m.addAttribute("contactlist",cService.findUserContact(userId));
		return "clist";
	}
	@RequestMapping("/user/del_contact")
	public String deleteContact(@RequestParam("cid") Integer contactId) {
		Integer status=cService.delete(contactId);
		return "redirect:clist?act=del";
	}
	@RequestMapping("/user/bulk_cdelete")
	public String deleteBulkContact(@RequestParam("cid") Integer[] contactIds) {
		Integer status=cService.delete(contactIds);
		return "redirect:clist?act=del";
	}
	@RequestMapping("/user/edit_contact")
	public String editContact(@RequestParam("cid") Integer contactId,Model m,HttpSession session) {
		session.setAttribute("aContactId", contactId);
		ContactDTO cdto=cService.findById(contactId);
		ContactCommand ccmd=new ContactCommand();
		ccmd.setContactId(cdto.getContactId());
		ccmd.setUserId(cdto.getUserId());
		ccmd.setName(cdto.getName());
		ccmd.setPhone(cdto.getPhone());
		ccmd.setEmail(cdto.getEmail());
		ccmd.setAddress(cdto.getAddress());
		ccmd.setRemark(cdto.getRemark());
		m.addAttribute("command",ccmd);
		return "contact_form";
	}
	@RequestMapping("/user/contact_search")
	public String searchContact(Model m,@RequestParam("freeText") String freeText,HttpSession session) {
		Integer userId=(Integer)session.getAttribute("userId");
		m.addAttribute("contactlist", cService.findUserContact(userId, freeText));
		return "clist";
	}
	@RequestMapping("/user/clistExcelExport")
	public String showExcelClistData(Model m,HttpSession session) {
	    //ContactCommand ccmd=new ContactCommand();
		//m.addAttribute("command", ccmd);
		Integer userId=(Integer)session.getAttribute("userId");
		m.addAttribute("contactlist",cService.findUserContact(userId));
		return "clistExcelView";
	}
	@RequestMapping("/user/clistPDFExport")
	public String showPdfClistData(Model m,HttpSession session) {
	    //ContactCommand ccmd=new ContactCommand();
		//m.addAttribute("command", ccmd);
		Integer userId=(Integer)session.getAttribute("userId");
		m.addAttribute("contactlist",cService.findUserContact(userId));
		return "clistPdfView";
	}
}
