<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
 <head>
  <title></title>
  <meta http-equiv="Content-type" content="text/html; charset=iso-8859-1" />
  <meta http-equiv="Content-Language" content="en-us" />
 </head>
 
<body>
<h3>Print Confirmation</h3> 
 
<p>This is the last page of the Wizard.</p>
<a href="<c:url value='/app/flows/letterPrinting'/>">Start new Wizard Flow</a>
 
<p>This is the end state of this flow. Notice when you click the above link or click the back button it will
it will start a new flow regardless.... </p>
 
<p>No matter what you do you can not mess up what was submitted in step 3.</p>
</body>
</html>