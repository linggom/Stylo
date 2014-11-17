$(window).bind('load', function(){
	var elemModal = $('.show-modal');
	var intervalScroll = 200;

	elemModal.leanModal({
		closeButton: '.modal .close'
	});
	elemModal.click(function(){
		var miscText = $(this).data('misc');
		if (miscText == 'login-form') {
			$('#txtUsername').focus();
		}
	});

	var dropArea = $('#drop');
	if (dropArea.html() != undefined) {
		var uploadForm = $('#uploadNewStyle');
		var uploadFormClose = uploadForm.find('.m-header .close');
		var uploadFormForm = uploadForm.find('.m-content form');
		var uploadFormLoader = uploadForm.find('.m-content .loader');
		var uploadFormDrop = uploadFormForm.find('.drop-area');

		dropArea.find('a').click(function(){
			$(this).parent().find('input').click();
		});
		uploadFormForm.fileupload({
			dropZone: dropArea,
			add: function (e, data) {
				uploadFormClose.hide();
				uploadFormForm.hide();
				uploadFormLoader.show();
				var jqXHR = data.submit();
			},
			progress: function(e, data) {
				var progress = parseInt(data.loaded / data.total * 100, 10);
			},
			done: function(e, data) {
				// alert(data.result.image); @todo
				
				uploadFormClose.click().show();
				uploadFormLoader.hide();
				uploadFormForm.show();
				uploadFormDrop.removeClass('error');

				$("html, body").animate({scrollTop: $("#add-new").offset().top - 300}, 1000);
			},
			fail: function(e, data) {
				uploadFormDrop.addClass('error');
				uploadFormClose.show();
				uploadFormForm.show();
				uploadFormLoader.hide();
			}
		});
		$(document).on('drop dragover', function(e){
			e.preventDefault();
		});
	}

	var elemGrid = $('#explore-grid');
	var elemGridSearch = $('#search-grid');

	if (elemGrid.html() != undefined) {
		var elemGridTop = elemGrid.offset().top;
		var intervalGridFade = 300;
		var fadeGridOpacity = .8;

		elemGrid.find('li').wookmark({
			align: 'left',
			autoResize: true,
			offset: 2,
			flexibleWidth: 310,
			itemWidth: 160,
			container: elemGrid
		});
		elemGrid.children().hover(function(){
			$(this).siblings().stop().fadeTo(intervalGridFade, fadeGridOpacity);
		}, function() {
			$(this).siblings().stop().fadeTo(intervalGridFade, 1);
		});

		elemGridSearch.find('li').wookmark({
			align: 'left',
			autoResize: true,
			offset: 2,
			flexibleWidth: 310,
			itemWidth: 160,
			container: elemGridSearch
		});
		elemGridSearch.children().hover(function(){
			$(this).siblings().stop().fadeTo(intervalGridFade, fadeGridOpacity);
		}, function() {
			$(this).siblings().stop().fadeTo(intervalGridFade, 1);
		});
	}

	Parse.initialize("vcn3TgIC29UaMJfghDGyyqSC52CbIyrsfjezMz5r", "GOamVTOrsa19IuPryeONdDiiFirftnK9PEwmFONC");
	
	var elemModal = $('#loginForm,#joinForm,#uploadNewStyle,#leanOverlay');
	var btnLogin = $('#btnLogin');	
	var btnJoin = $('#btnJoin');
	var aUpload = $('#aUpload');
	var aTrending = $('#aTrending');
	var aSearch = $('#aSearch');
	var aLogin = $('#aLogin');
	var aJoin = $('#aJoin');
	var aLogout = $('#aLogout');
	var aProfile = $('#aProfile');
	var spnMenuLoggedIn = $('#spanLoggedIn');
	var spnMenuNotLoggedIn = $('#spanNotLoggedIn');
	var txtUsernameLogin = $('#txtUsernameLogin');
	var txtPasswordLogin = $('#txtPasswordLogin');
	var txtUsername = $('#txtUsername');
	var txtPassword = $('#txtPassword');
	var txtEmail = $('#txtEmail');

	var pageProfile = $('#pageProfile');

	aUpload.hide();
	spnMenuNotLoggedIn.show();
	spnMenuLoggedIn.hide();

	var currentUser = Parse.User.current();
	if (currentUser) {
		spnMenuLoggedIn.show();
		spnMenuNotLoggedIn.hide();
		aUpload.show();

		pageProfile.find('.profile-details').html(currentUser.get('username') + ' &mdash; ' + currentUser.get('email'));
	}

	btnJoin.click(function(){
		var username = txtUsername.val();
		var password = txtPassword.val();
		var email = txtEmail.val();

		var uploadForm = $('#joinForm');
		var uploadFormClose = uploadForm.find('.m-header .close');
		var uploadFormForm = uploadForm.find('.m-content form');
		var uploadFormLoader = uploadForm.find('.m-content .loader');

		uploadFormClose.hide();
		uploadFormForm.hide();
		uploadFormLoader.show();

		if (email == '') {
			txtEmail.focus();
		}
		else {
			var user = new Parse.User();
			user.set('username', username);
			user.set('password', password);
			user.set('email', email);

			user.signUp(null, {
				success: function (user) {
					uploadFormLoader.hide();
					uploadFormForm.show();

					spnMenuLoggedIn.show();
					spnMenuNotLoggedIn.hide();
					aUpload.show();
					elemModal.fadeOut();
				},
				error: function (user, error) {
					uploadFormClose.show();
					uploadFormForm.show();
					uploadFormLoader.hide();
					txtEmail.focus();
				}
			});
		}

		return false;
	});
	btnLogin.click(function(){
		var username = txtUsernameLogin.val();
		var password = txtPasswordLogin.val();

		var uploadForm = $('#loginForm');
		var uploadFormClose = uploadForm.find('.m-header .close');
		var uploadFormForm = uploadForm.find('.m-content form');
		var uploadFormLoader = uploadForm.find('.m-content .loader');

		uploadFormClose.hide();
		uploadFormForm.hide();
		uploadFormLoader.show();

		Parse.User.logIn(username, password, {
			success: function(user) {
				spnMenuLoggedIn.show();
				spnMenuNotLoggedIn.hide();
				aUpload.show();
				elemModal.fadeOut();

				uploadFormLoader.hide();
				uploadFormForm.show();
			},
			error: function(user, error) {
				spnMenuLoggedIn.hide();
				spnMenuNotLoggedIn.show();
				aUpload.hide();

				uploadFormClose.show();
				uploadFormForm.show();
				uploadFormLoader.hide();
			}
		});
		return false;
	});
	aLogout.click(function(){
		Parse.User.logOut();
		spnMenuNotLoggedIn.show();
		spnMenuLoggedIn.hide();
		aUpload.hide();
		txtUsernameLogin.val('');
		txtPasswordLogin.val('');
	});

	aProfile.click(function(){
		$("html, body").animate({scrollTop: $("#profile").offset().top - 100}, 1000);
		return false;
	});
	aTrending.click(function(){
		$("html, body").animate({scrollTop: $("#trending").offset().top - 100}, 1000);
		return false;
	});
	aSearch.click(function(){
		$("html, body").animate({scrollTop: $("#search").offset().top - 100}, 1000);
		return false;
	});

	$(window).scroll(function(){
		if ($(this).scrollTop() > 300) {
			$('.menu-top').addClass('with-bg');
		}
		else {
			$('.menu-top').removeClass('with-bg');
		}
	});

	$('.grids a').click(function(){
		$('html, body').animate({
			scrollTop: $('#view').offset().top + 100
		}, 100);
		return false;
	});

	$('#txtSearch').on('keypress', function(e) {
		var code = e.keyCode || e.which;
		var elem = $('#search .grids');

		if (code == 13) {
			elem.hide();
			elem.parent().find('.loader').show();
			setTimeout(function(){
				elem.parent().find('.loader').hide();
				elem.slideDown();
			}, 1000)
		}
	});

	/*var StyleObject = Parse.Object.extend("Styles");
	var styles = new StyleObject();

	styles.save({foo: 'bar'}, {
		success: function(object) {
			alert('S');
		},
		error: function(model, error) {
			alert('E');
		}
	});*/
});
$(window).bind('keyup',function(e){
	if(e.keyCode == 27)
		$('#loginForm,#joinForm,#uploadNewStyle,#leanOverlay').fadeOut();
})