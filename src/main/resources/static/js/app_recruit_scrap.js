import * as View from "./view.js";
import * as Request from "./request.js";


$(document).on('click','#deleteScrap',function(e){
		console.log("펑션접근");
		let sendData = {
			id:$(this).val()
		};
		console.log(sendData);
			Request.ajaxRequest('delete-recruit-scrap',
								'POST',
								'application/json;charset=UTF-8',
								JSON.stringify(sendData),
								function(resultJson){
								console.log("제이슨 받아오기 성공");
								View.render("#refresh-scrap-list",resultJson,"#scrap-list");
								},
								true);
			e.preventDefault();	
});