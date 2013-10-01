<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div id="side-bar">
    <a href="<c:url value="/dashboard/view"/>"><fmt:message key="button.home"/></a>
    
    <sec:authorize ifAllGranted="ROLE_USER">    
        <p><fmt:message key="batch.menu.title"/></p>
            <a href="<c:url value="/batch/add"/>"><fmt:message key="button.create"/></a> 
            <a href="<c:url value="/batch/list"/>"><fmt:message key="button.search"/></a>
    </sec:authorize>
    
    <sec:authorize ifAllGranted="ROLE_USER">    
        <p><fmt:message key="recipe.menu.title"/></p>
            <a href="<c:url value="/recipe/edit"/>"><fmt:message key="button.create"/></a> 
            <a href="<c:url value="/recipe/list"/>"><fmt:message key="button.search"/></a>
    </sec:authorize>
    
    <sec:authorize ifAllGranted="ROLE_USER">    
        <p><fmt:message key="feedstock.menu.title"/></p>
            <a href="<c:url value="/feedstock/edit"/>"><fmt:message key="button.create"/></a> 
            <a href="<c:url value="/feedstock/list"/>"><fmt:message key="button.search"/></a>
    </sec:authorize>
</div>
