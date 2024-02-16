<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>

<style>

    #layoutError {
        display : flex;
        height : 100%;
        justify-content: center;
        align-items: center;
    }

    img {
        width : 200px;
        height : 200px;
    }

    #layoutError_content {
        text-align: center;
    }
</style>
<div id="layoutError">
    <div id="layoutError_content">
            <div class="text-center mt-4">
                <img src="images/error-404-monochrome.svg" />
                <p class="lead">페이지를 찾을 수 없습니다.</p>
                <a href="/">
                    HOME
                </a>
            </div>
    </div>
    <div id="layoutError_footer">
    </div>
</div>