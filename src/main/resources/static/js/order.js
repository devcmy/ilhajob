(function($) {
	$('.call-order-modal').on('click', function(e) {
		e.preventDefault();
		let productId = $(this).data('product-id');
		let productIdJson = JSON.stringify({id: productId});
		console.log(productIdJson);
		let promise = $.ajax({
			type: 'POST',
			url: 'order-popup',
			data: productIdJson,
			contentType: 'application/json',
			dataType: 'json'
		});

		// Promise 객체를 사용하여 Ajax 요청 처리
		promise.then(function(responseData) {
			console.log(responseData)
			 let product = responseData.product;
            // HTML 파일 추가
			$(responseData.html).appendTo('body').modal({
				closeExisting: true,
				fadeDuration: 300,
				fadeDelay: 0.15
			});
			$('.order-name').text(user.userName);
			$('.order-phone').text(user.userPhone);
			$('.order-email').text(user.userEmail);
			$('.product-name').text(product.pname);
			$('.product-total').text(product.pprice);
			$('.amount').text(product.pprice);
		})
			.fail(function(xhr) {
				// Ajax 요청 실패 시 처리
				console.log(xhr);
			});
			
	});
	
	
	/*$(document).on('click', '#log-in', function(e) {
		e.preventDefault();
		let formData = {};
		$.each($('#login-f').serializeArray(), function() {
			formData[this.name] = this.value;
		});
		let jsonData = JSON.stringify(formData);
		// Promise 객체 생성
		let promise = $.ajax({
			type: 'POST',
			url: 'ajaxLogin',
			data: jsonData,
			contentType: 'application/json',
			dataType: 'json'
		});

		// Promise 객체를 사용하여 Ajax 요청 처리
		promise.then(function(response) {
			// 로그인 성공 시 처리
			if (response.success) {
				window.location.href = '/final-project-team1-ilhajob';
			}
			// 로그인 실패 시 처리
			else {
				alert(response.message);
				window.location.href = response.location;
			}
		})
			.fail(function(xhr) {
				// Ajax 요청 실패 시 처리
				let errorMsg = document.createElement('p');
				errorMsg.style.textAlign = 'center';
				errorMsg.style.color = 'red';
				errorMsg.textContent = xhr.responseText;
				let passwordInput = document.getElementById('password-field');
				passwordInput.insertAdjacentElement('afterend', errorMsg);
				if (xhr.status === 5000 || xhr.status === 5300) {
					$('#email').focus();
				} else if (xhr.status === 5301 || xhr.status === 5301) {
					$('#id').focus();
				}
			});
	});*/




})(window.jQuery);