	type = "text/javascript" > function checksearch() {
						kw = gde("keyword");
						if (kw.value == "" || kw.value == "Tìm...") {
							Boxy.alert("Vui lòng nhập từ khóa để tìm kiếm", null, {
								title: 'Thông báo'
							});
							kw.focus();
							return false;
						}
					}

					function clearText(field) {
						if (field.defaultValue == field.value) field.value = '';
						else if (field.value == '') field.value = field.defaultValue;
					}
					$(document).mouseup(function(e) {
						var container = $(".search");
						if (!container.is(e.target) && container.has(e.target).length === 0) {
							$("#autocomplete").hide();
						}
					});
					$(document).keydown(function(e) {
						if (e.which == 38 || e.which == 40) {
							var pid = 0;
							var pvalue = 0;
							var active = 0;
							if ($('#autocomplete').length > 0) {
								i = 0;
								$(".vsmall_products").each(function(index) {
									if ($(this).hasClass("headerpactive")) {
										pid = i;
										active = 1;
										$(this).removeClass("headerpactive");
									}
									i++;
								});
								if (e.which == 38) {
									pid--;
								}
								if (e.which == 40 && active == 1) {
									pid++;
								}
								if (pid < 0) {
									$("#productid").val(0);
								}
								if (pid == i) {
									$("#productid").val(0);
								}
								i = 0;
								$(".vsmall_products").each(function(index) {
									if (pid == i) {
										$("#productid").val(this.id);
										$(this).addClass("headerpactive");
									}
									i++;
								});
							}
							e.preventDefault();
						}
					});
					$("#keyword").keyup(function(e) {
						if (e.which == 38 || e.which == 40) {
							return true;
						}
						kw = gde("keyword");
						if (kw == '') {
							$("#autocomplete").hide();
							return true;
						}
						address = '/home/autocomplete/index.html';
						address = addQuery(address, 'keywords=' + kw.value);
						$.ajax({
							url: address,
							dataType: "html",
							type: "GET",
							cache: false,
							error: function(e) {
								Boxy.alert('Lỗi cc', null, {
									title: 'Lỗi'
								});
								return false;
							},
							success: function(data) {
								if (data) {
									$("#autocomplete").empty();
									$("#autocomplete").append(data);
									$('#autocomplete').stop(true, true).slideDown("normal");
								} else {
									$("#autocomplete").hide();
								}
							}
						});
					});

					function getcartnumber() {
						address = '/home/cartnumber/index.html';
						$.ajax({
							url: address,
							dataType: "json",
							type: "GET",
							cache: false,
							error: function(e) {
								Boxy.alert('Lỗi xx', null, {
									title: 'Thông báo'
								});
								return;
							},
							success: function(data) {
								$('.shownumber').empty();
								$('.shownumber').append(data.id);
								if (data.id > 0) {
									getcartslist();
								} else {
									$('#showcartlink').hide();
									$('#cartslist').empty();
									$('#cartslist').append('<span class="empty">Giỏ hàng chưa có sản phẩm</span>');
								}
							}
						});
					}

					function getcartslist() {
						address = '/home/cartslist/index.html';
						$.ajax({
							url: address,
							dataType: "html",
							type: "GET",
							cache: false,
							error: function(e) {
								Boxy.alert('Lỗi ll', null, {
									title: 'Lỗi'
								});
								return false;
							},
							success: function(data) {
								if (data) {
									$("#cartslist").empty();
									$("#cartslist").append(data);
								} else {
									$('#showcartlink').hide();
									$('#cartslist').empty();
									$('#cartslist').append('<span class="empty">Giỏ hàng chưa có sản phẩm</span>');
								}
								return true;
							}
						});
					}

					function delecart(id, pid) {
						address = '/home/delete/index.html';
						address = addQuery(address, 'id=' + id);
						$.ajax({
							url: address,
							dataType: "json",
							type: "GET",
							cache: false,
							error: function(e) {
								Boxy.alert('Lỗi pp', null, {
									title: 'Thông báo'
								});
								return;
							},
							success: function(data) {
								if (data.id > 0) {
									getcartnumber();
								} else {
									Boxy.alert('Lỗi hh', null, {
										title: 'Thông báo'
									});
								}
							}
						});
					}
					$(function() {
						$('.cartlink').boxy({
							ovlay: true,
							unloadOnHide: true
						});
						getcartnumber();
					}); 