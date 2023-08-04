$(document).ready(function() {
	let idcheck_value = '';        // id 중복검사시 값

	// 아이디 중복 확인 부분
	$("#idcheck").click(function() {
		const id = $("#id");

		// jQuery의 trim()을 사용하여 공백 제거
		// 사용법) $.trim(str);
		// 문자열(str)의 앞뒤 공백을 제거합니다.
		const id_value = $.trim(id.val());
		if (id_value == "") {
			alert("아이디를 입력해주세요");
			id.focus();
		} else {
			// 첫 글자는 대문자이고, 두 번째 글자부터는 대문자, 소문자, 숫자, _로 이루어져야 함
			pattern = /^[A-Z][a-zA-Z0-9_]{3,}$/;
			if (pattern.test(id_value)) {
				idcheck_value = id_value;
				const ref = `idcheck.html?id=${id_value}`;
				window.open(ref, "idcheck", "width=350,height=200");
			} else {
				alert("첫 글자는 대문자이고, 두 번째 글자부터는 대문자, 소문자, 숫자, _로 이루어져야 합니다");
				id.val('').focus();
			}
		}
	}); // $("#idcheck").click() 종료

	// 우편번호 검색 버튼 클릭
	$("#postcode").click(function() {
		//window.open("post.html", "post", "width=400,height=500,scrollbars=yes");
		Postcode();

	}); // $("#postcode").click 종료

	// 길명주소 표기법 관련 데이터를 받아와서 올바른 주소를 구성하는 방법을 설명하는 예제
	function Postcode() {
		new daum.Postcode({
			oncomplete: function(data) {
				console.log(data.zonecode);
				// 팝업에서 검색 결과 아이템을 클릭했을 때 실행할 코드를 작성하는 부분

				// 길명주소의 노출 규칙에 따라 주소를 조합합니다.
				// 법정동명이 있으면 추가합니다. (단, 공인인증법 개정으로 제외)
				// 법정동명이 정해진 동의 경우, 마지막 글자로 "동/로/가"로 끝납니다.
				var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
				var extraRoadAddr = ''; // 도로명 조합형 주소 변수

				// 법정동명이 있고, "동/로/가"로 끝나는 경우 추가합니다.
				if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
					extraRoadAddr += data.bname;
				}
				// 건물명이 있고, 아파트일 경우 추가합니다.
				if (data.buildingName !== '' && data.apartment === 'Y') {
					extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
				}
				// 도로명 주소가 있고, 지번 주소가 조합형 주소인 경우 최종 문자열을 괄호로 묶어줍니다.
				if (extraRoadAddr !== '') {
					extraRoadAddr = '(' + extraRoadAddr + ')';
				}
				// 도로명 주소와 조합형 주소를 추가합니다.
				if (fullRoadAddr !== '') {
					fullRoadAddr += extraRoadAddr;
				}

				// 우편번호와 주소 정보를 해당 필드에 넣습니다.
				$("#post1").val(data.zonecode); // 5자리 새우편번호 사용
				$("#address").val(fullRoadAddr);
			}
		}).open();
	}

	// 도메인 선택 부분
	$("#sel").change(function() {
		const domain = $("#domain");
		if ($(this).val() == "") { // 직접 입력이 선택된 경우
			domain.val("").focus().prop("readOnly", false);
		} else { // 도메인이 선택된 경우
			domain.val($(this).val()).prop("readOnly", true);
		}
	}); // $("#sel").change 종료

	$("#jumin1").keyup(function() {
		if ($("#jumin1").val().length == 6) {
			pattern = /^[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|[3][01])$/;
			if (pattern.test($("#jumin1").val())) {
				$("#jumin2").focus(); // 주민등록번호 마지막 자리로 포커스 이동
			} else {
				alert("숫자를 입력하거나 형식에 맞게 [yymmdd] 형식으로 입력하세요");
				$(this).val('').focus();
			}
		}
	}); // $("#jumin1").keyup 종료

	$("#jumin2").keyup(function() {
		if ($.trim($(this).val()).length == 7) {
			pattern = /^[1234][0-9]{6}$/;
			if (pattern.test($(this).val())) {
				const c = $(this).val().substring(0, 1);
				const index = (c - 1) % 2; // c가 1 또는 3이면 index는 0, c가 2 또는 4이면 index는 1
				$("input[type=radio]").eq(index).prop("checked", true);
			} else {
				alert("올바른 형식으로 입력해주세요 [1234][0-9]{6}");
				$(this).val('').focus();
			}
		}
	});

	// 회원 가입 버튼 클릭 시 이벤트 처리 부분
	$("form").submit(function() {
		// jQuery의 trim()을 사용하여 공백 제거
		// 사용법) $.trim(str); - 문자열(str)의 앞뒤 공백을 제거합니다.
		const id = $("#id");
		if ($.trim(id.val()) == "") {
			alert("아이디를 입력해주세요");
			id.focus();
			return false;
		}

		// 제출 시점의 아이디 값이 아이디 중복 확인에 사용된 아이디와 다른 경우 메시지 표시
		let submit_id_value = $.trim(id.val());
		if (submit_id_value != idcheck_value) {
			alert("아이디 중복 확인을 해주세요");
			return false;
		}

		const pass = $("#pass");
		if ($.trim(pass.val()) == "") {
			alert("비밀번호를 입력해주세요");
			pass.focus();
			return false;
		}

		const jumin1 = $("#jumin1");
		if ($.trim(jumin1.val()) == "") {
			alert("주민등록번호 첫 자리를 입력해주세요");
			jumin1.focus();
			return false;
		}

		if ($.trim(jumin1.val()).length != 6) {
			alert("주민등록번호 앞 6자리를 입력해주세요");
			jumin1.val("").focus();
			return false;
		}



		const jumin2 = $("#jumin2");
		if ($.trim(jumin2.val()) == "") {
			alert("주민등록번호 뒷자리를 입력해주세요");
			jumin2.focus();
			return false;
		}

		if ($.trim(jumin2.val()).length != 7) {
			alert("주민등록번호 마지막 7자리를 입력해주세요");
			jumin2.val("").focus();
			return false;
		}

		const email = $("#email");
		if ($.trim(email.val()) == "") {
			alert("이메일 ID를 입력해주세요");
			email.focus();
			return false;
		}

		const domain = $("#domain");
		if ($.trim(domain.val()) == "") {
			alert("이메일 도메인을 입력해주세요");
			domain.focus();
			return false;
		}

		let cnt = $('input:radio:checked').length;
		if (cnt == 0) {
			alert("성별을 선택해주세요");
			return false;
		}

		cnt = $('input:checkbox:checked').length;
		if (cnt < 2) {
			alert("취미는 2개이상 선택하세요");
			return false;
		}

		const post1 = $("#post1");
		if ($.trim(post1.val()) == "") {
			alert("우편번호를 입력해주세요");
			post1.focus();
			return false;
		}

		// $.isNumeric(): 해당 매개변수의 값이 숫자인지 확인하는 메소드
		if (!$.isNumeric(post1.val())) {
			alert("우편번호에는 숫자만 입력할 수 있습니다.");
			post1.val("").focus();
			return false;
		}

		const address = $("#address");
		if ($.trim(address.val()) == "") {
			alert("주소를 입력해주세요");
			address.focus();
			return false;
		}

		const intro = $("#intro");
		if ($.trim(intro.val()) == "") {
			alert("자기 소개를 입력해주세요");
			intro.focus();
			return false;
		}


	});
});
