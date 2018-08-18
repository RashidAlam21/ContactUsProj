/**
 * 
 */
package com.nt.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.dto.ContactDTO;

/**
 * @author abc
 *
 */
public class ContactPdfView extends AbstractPdfView{

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.view.document.AbstractPdfView#buildPdfDocument(java.util.Map, com.lowagie.text.Document, com.lowagie.text.pdf.PdfWriter, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document doc, PdfWriter pw, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		//to change file name & download
		resp.addHeader("Content-Discription","attachment;filename=contactlistpdf.pdf");
		//read data from model map.
		List<ContactDTO> clist=(List<ContactDTO>) map.get("contactlist");
		//pharagraph
		Paragraph p=new Paragraph("Welcome to location PDF file.");
		p.setAlignment("center");
		//doc.add(p);
		//Welcome to location PDF file..
		//table with heading and data
		PdfPTable pTable=new PdfPTable(6);
		pTable.addCell("ContactId");
		pTable.addCell("UserId");
		pTable.addCell("Phone");
		pTable.addCell("Email");
		pTable.addCell("Address");
		pTable.addCell("Remark");
		for(ContactDTO list:clist) {
			pTable.addCell(list.getContactId()+" ");
			pTable.addCell(list.getUserId()+" ");
			pTable.addCell(list.getPhone()+" ");
			pTable.addCell(list.getEmail()+" ");
			pTable.addCell(list.getAddress()+" ");
			pTable.addCell(list.getRemark()+" ");
		}
		//add element to document
		doc.add(p);
		doc.add(pTable);
		doc.add(new Paragraph(new Date().toString()));
	}

}
