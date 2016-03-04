var showError;
var showWarning;
var showInfo;
(function($) {
	// 备份jquery的ajax方法
	var _ajax = $.ajax;
	// 重写jquery的ajax方法
	$.ajax = function(options) {
		var msgArea = $('#msgArea');
		var msgContent = $('#msgArea .msg');
		var complete = options.complete;
		msgContent.empty();
		msgArea.slideUp();	
		var success = options.success;
		options.success = function(data) {
			if(data != null && data.message != null && data.message != ""){
				if(data.hasSuccess == true){
					showInfo(data.message);
				}else if(data.hasSuccess == false){
					showWarning(data.message);
				}
			}
			if (success) {
				success(data);
			}
		};
		options.complete = function(httpRequest, status) {
			msgArea.slideUp(function(){
				if (complete) {
					complete(httpRequest, status);
				}
			});
		};
		var error = options.error;
		options.error = function(XMLHttpRequest, msg, e) {
			showError(XMLHttpRequest.responseText);
			if (error) {
				error(XMLHttpRequest, msg, e);
			}
		};
		options.async = true;
		msgArea.css('color','#38dbf3');
		msgContent.append('<i class="fa fa-spinner fa-pulse"></i> <span>玩命加载中，请稍候...</span>');
		msgArea.slideDown();
		return _ajax(options);
	}
})(jQuery);
$(function() {
	var MSG_COLOR = [];
	MSG_COLOR.push('#f67629');
	MSG_COLOR.push('#ffff00');
	MSG_COLOR.push('#00ff00');

	showError = function(strErr) {
		showMsg("<i class='fa fa-frown-o'></i> " + strErr, MSG_COLOR[0]);
	}
	showWarning = function(strWarn) {
		showMsg("<i class='fa fa-exclamation-triangle'></i> " + strWarn, MSG_COLOR[1]);
	}
	showInfo = function(strInfo) {
		showMsg("<i class='fa fa-info-circle'></i> " + strInfo, MSG_COLOR[2]);
	}
	var showMsg = function(strMsg, txtColor) {
		var msgArea = $('#msgArea');
		var msgContent = $('#msgArea .msg');

		msgArea.slideUp(function(){
			msgContent.empty();		
			msgContent.append(strMsg);
			msgArea.css('color', txtColor);
			msgArea.slideDown();
		});		
		
	}
});