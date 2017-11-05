<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/include/include-header.jsp"%>
<%@ page session="true"%>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.validate.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $("#sendDelete").click(function(){
        location.href="/messageList.do";
    });
    
    $("#msgSendSave").click(function(){
        var msg_get = $("#msg_get").val(); 
        var msg_name = $("#msg_name").val(); 
        var msg_desc = $("#msg_desc").val(); 

        if(msg_get == "") {
            alert("받는사람의 회원 아이디를 입력해주세요");
            msg_get.foucs();
        } else if (msg_name == "") {
            alert("쪽지의 제목을 입력해주세요");
            msg_name.focus();
        } else if (msg_desc == "") {
            alert("쪽지의 설명을 입력해주세요");
            msg_desc.focus();
        } 
        
        var formData = $("form[name=form1]").serialize();
        
        $.ajax({
			type:"POST",
			url: "<c:url value='/messageWriteSave.do'/>",
			dataType:"text",
			data: formData,
			success: function(result){ 
				if(result == 'ok'){
						alert("쪽지가 정상적으로 발송되었습니다.");
						location.href="/messageSendList.do";
					}
				if(result == 'fal'){
					alert("존재하지않는 회원입니다.");
					$("#msg_get").val('');
				}
			}
		});
    });
});
</script>
<!-- *** -->
<section id="history" class="history sections">
    <div class="container">
        <div class="row">
            <div class="main_history">
                <div class="col-sm-12">
                    <div class="single_history_content">
                        <div class="head_title">
                            <h3>쪽지 작성</h3>
                        </div>
                        <p> 새로운 쪽지를 작성합니다. 받는이에 해당하는 아이디는 반드시 BINO에 가입된 회원이여야 합니다.</p>
                    </div>
                </div>
            </div>
        </div><!--End of row -->
    </div><!--End of container -->
</section><!--End of history -->

<div class="single-product-area">
	<div class="row m-n">
		<div class="col-md-4 col-md-offset-4 m-t-lg">
			<!-- ************************ -->
			<form id="form1" name="form1" method="post">
				<label>받는이</label>
				<input type="text" class="form-control parsley-validated" name="msg_get" id="msg_get" maxlength="100"><br />
				<label>제목</label>
				<input type="text" class="form-control parsley-validated" name="msg_name" id="msg_name" maxlength="100"><br />
				<label>내용</label>
				<textarea class="form-control freeTextarea" maxlength="2000" name="msg_desc" id="msg_desc"></textarea><br />
				<hr>
				<button type="button" class="btn btn-lg btn-primary btn-block" id="msgSendSave">전송</button>
				<button type="button" class="btn btn-lg btn-danger btn-block" id="sendDelete">취소</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>