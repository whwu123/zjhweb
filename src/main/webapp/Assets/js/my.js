$(function(){
	 $("#service a").hover(function() {
         if ($(this).prop("className") == "weixin_area") {
             $(this).children("img.hides").show();
         } else {
             $(this).children("div.hides").show();
             $(this).children("img.shows").hide();
             $(this).children("div.hides").animate({marginRight: '0px'}, '0');
         }
     }, function() {
         if ($(this).prop("className") == "weixin_area") {
             $(this).children("img.hides").hide();
         } else {
             $(this).children("div.hides").animate({marginRight: '-163px'}, 0, function() {
                 $(this).hide();
                 $(this).next("img.shows").show();
             });
         }
     });

     $("#top_btn").click(function() {
         $("html,body").animate({scrollTop: 0}, 600);
     });

     //右侧导航 - 二维码
     $(".weixin_area").hover(function() {
         $(this).children(".weixin").show();
     },function(){
         $(this).children(".weixin").hide();
     });
});





function AddFavorite(sURL, sTitle) {
	try {
		window.external.addFavorite(sURL, sTitle);
	} catch (e) {
		try {
			window.sidebar.addPanel(sTitle, sURL, "");
		} catch (e) {
			alert("加入收藏失败，请使用Ctrl+D进行添加");
		}
	}
}
function SetHome(obj, vrl) {
	try {
		obj.style.behavior = 'url(#default#homepage)';
		obj.setHomePage(vrl);
	} catch (e) {
		if (window.netscape) {
			try {
				netscape.security.PrivilegeManager
						.enablePrivilege("UniversalXPConnect");
			} catch (e) {
				alert("此操作被浏览器拒绝！\n请在浏览器地址栏输入“about:config”并回车\n然后将 [signed.applets.codebase_principal_support]的值设置为'true',双击即可。");
			}
			var prefs = Components.classes['@mozilla.org/preferences-service;1']
					.getService(Components.interfaces.nsIPrefBranch);
			prefs.setCharPref('browser.startup.homepage', vrl);
		}
	}
}

function getSystemData(){
	/*$.ajax({
		type: "POST",
   		url: "index/getSystemData.do",
		dataType:"json",
		data:{"fkey":"gw_text"},
		async: false,
		success: function(data){
			 var data2 = eval(data);
			 $("#gw_text").html(data2.fContent)
		}
	});*/
	$.ajax({
		type: "POST",
   		url: "index/getSystemData.do",
		dataType:"json",
		data:{"fkey":"company_person"},
		async: false,
		success: function(data){
			if(data!=null){
			 var data2 = eval(data);
			 $("#company_person").html(data2.fContent)
			}
		}
	});
	$.ajax({
		type: "POST",
   		url: "index/getSystemData.do",
		dataType:"json",
		data:{"fkey":"company_address"},
		async: false,
		success: function(data){
			if(data!=null){
			 var data2 = eval(data);
			 $("#company_address").html(data2.fContent)
			}
		}
	});
	$.ajax({
		type: "POST",
   		url: "index/getSystemData.do",
		dataType:"json",
		data:{"fkey":"company_email"},
		async: false,
		success: function(data){
			if(data!=null){
			 var data2 = eval(data);
			 $("#company_email").html(data2.fContent)
			}
		}
	});
	$.ajax({
		type: "POST",
   		url: "index/getSystemData.do",
		dataType:"json",
		data:{"fkey":"postcode"},
		async: false,
		success: function(data){
			if(data!=null){
			 var data2 = eval(data);
			 $("#postcode").html(data2.fContent)
			}
		}
	});
	$.ajax({
		type: "POST",
   		url: "index/getSystemData.do",
		dataType:"json",
		data:{"fkey":"phone"},
		async: false,
		success: function(data){
			if(data!=null){
			 var data2 = eval(data);
			 $("#phone").html(data2.fContent)
			}
		}
	});
	$.ajax({
		type: "POST",
   		url: "index/getSystemData.do",
		dataType:"json",
		data:{"fkey":"company_tel"},
		async: false,
		success: function(data){
			if(data!=null){
				 var data2 = eval(data);
				 $("#company_tel").html(data2.fContent)
				 $("#dhtel").html(data2.fContent);
			}
			
		}
	});
	$.ajax({
		type: "POST",
   		url: "index/getSystemData.do",
		dataType:"json",
		data:{"fkey":"company_qq"},
		async: false,
		success: function(data){
			if(data!=null){
				 var data2 = eval(data);
				 $("#company_qq").html(data2.fContent);
				 $("#qqhref").attr("href","http://wpa.qq.com/msgrd?v=3&uin="+data2.fContent+"&site=qq&menu=yes")
			}
		}
	});
	$.ajax({
		type: "POST",
   		url: "index/getSystemData.do",
		dataType:"json",
		data:{"fkey":"phone2"},
		async: false,
		success: function(data){
			if(data!=null){
				 var data2 = eval(data);
				 $("#phone2").html(data2.fContent);
			}
		}
	});
}