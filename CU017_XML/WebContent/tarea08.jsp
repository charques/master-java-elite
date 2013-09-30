<%@ page language="java" contentType="text/html"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page import="javax.xml.transform.Transformer"%>
<%@ page import="javax.xml.transform.TransformerFactory"%>
<%@ page import="javax.xml.transform.stream.StreamSource"%>
<%@ page import="javax.xml.transform.stream.StreamResult"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	String xml = "agenda.xml";
	String xsl = "agenda.xsl";

	String path = getServletContext().getRealPath("") + System.getProperty("file.separator");
	xsl = path + xsl;
	xml = path + xml;

	TransformerFactory tFactory = TransformerFactory.newInstance();
	Transformer transformer = tFactory.newTransformer(new StreamSource(xsl));
	transformer.transform(new StreamSource(xml), new StreamResult(out));
%>