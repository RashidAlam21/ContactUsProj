/**
 * 
 */
package com.nt.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.nt.dto.ContactDTO;

/**
 * @author Md Rashid Alam
 *
 */
public class ContactExcelView extends AbstractExcelView{

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.view.document.AbstractExcelView#buildExcelDocument(java.util.Map, org.apache.poi.hssf.usermodel.HSSFWorkbook, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void buildExcelDocument(Map<String, Object> map, HSSFWorkbook book, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		resp.addHeader("Content-Disposition", "attachment;filename=contactlist.xls");
		
		//read data from model map
		List<ContactDTO> clist=(List<ContactDTO>) map.get("contactlist");
		//create a sheet
		HSSFSheet sheet=book.createSheet("clist");
		//sheet the head row zero
		setHead(sheet);
		//sheet body. list to rows
		setBody(sheet,clist);
	}
	private void setHead(HSSFSheet sheet) {
		int rowNum=0;
		System.out.println("setHead"+sheet);
		HSSFRow row=sheet.createRow(rowNum);
		row.createCell(0).setCellValue("ContactId");
		row.createCell(1).setCellValue("UserId");
		row.createCell(2).setCellValue("Name");
		row.createCell(3).setCellValue("Phone");
		row.createCell(4).setCellValue("Email");
		row.createCell(5).setCellValue("Address");
		row.createCell(6).setCellValue("Remark");
	}
	private void setBody(HSSFSheet sheet,List<ContactDTO> clist) {
		int rowNum=1;
		for(ContactDTO list:clist) {		
			HSSFRow row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(list.getContactId());
			row.createCell(1).setCellValue(list.getUserId());
			row.createCell(2).setCellValue(list.getName());
			row.createCell(3).setCellValue(list.getPhone());
			row.createCell(4).setCellValue(list.getEmail());
			row.createCell(5).setCellValue(list.getAddress());
			row.createCell(6).setCellValue(list.getRemark());

		}
	}
}
