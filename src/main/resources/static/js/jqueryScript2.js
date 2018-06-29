$(document).ready(function() {
	// DO GET
	$.ajax({
		type : "GET",
		url : "api/image/all/2d",
		success: function(result){
			$.each(result, function(i, customer){
				var cust = customer.name;
				var customerItem = '<div class="grid-item" style="width:18%!important;">'+
                '<figure class="effect-bubba">'+
                		'<img id ="\'' + cust + '\'" src="/api/image/2d?name=\'' + cust + '\' alt="Image" class="img-fluid tm-img"    style="transform: rotate(90deg)" onclick="modalClick90(this.id)">'+
                		"</figure>"+
                		'<div class="col-md-4"></div>'+
		         		'<div class="col-md-6 form-check">'+
		         		"<label>"+
		         		'<input id="\'' + cust + '\'" type="radio" name="radio1" style="margin-top: 10;width: 18px;height: 1em;">'+
		         		"</label>"+
		         		"</div>"+
                		
                	"</div>"; 
					
				$('#customerList').append(customerItem);
	        });
		},
		error : function(e) {
			console.log("ERROR: ", e);
		}
	});
	
	
	$.ajax({
		type : "GET",
		url : "api/image/all/3d",
		success: function(result){
			$.each(result, function(i, customer){
				var cust = customer.name;
				
				var customerItem2 = '<div class="grid-item" style="width:18%!important;">'+
						 '<figure class="effect-bubba">'+
		         		'<img id="\'' + cust + '\'" src="/api/image/3d?name=\'' + cust + '\' alt="Image" class="img-fluid tm-img" onclick="modalClick(this.id)">'+
		         		"</figure>"+
		         		'<div class="col-md-4"></div>'+
		         		'<div class="col-md-6 form-check">'+
		         		"<label>"+
		         		'<input id="\'' + cust + '\'" type="radio" name="radio2" style="margin-top: 10;width: 18px;height: 1em;">'+
		         		"</label>"+
		         		"</div>"+
		         	"</div>"; 
					
				$('#customerList2').append(customerItem2);
				
	        });
		},
		error : function(e) {
			console.log("ERROR: ", e);
		}
	});
	
	
	function adjustHeightOfPage(pageNo) {

        var offset = 80;
        var pageContentHeight = 0;

        var pageType = $('div[data-page-no="' + pageNo + '"]').data("page-type");

        if( pageType != undefined && pageType == "gallery") {
            pageContentHeight = $(".cd-hero-slider li:nth-of-type(" + pageNo + ") .tm-img-gallery-container").height();
        }
        else {
            pageContentHeight = $(".cd-hero-slider li:nth-of-type(" + pageNo + ") .js-tm-page-content").height() + 20;
        }

        if($(window).width() >= 992) { offset = 120; }
        else if($(window).width() < 480) { offset = 40; }
       
        // Get the page height
        var totalPageHeight = $('.cd-slider-nav').height()
                                + pageContentHeight + offset
                                + $('.tm-footer').height();

        // Adjust layout based on page height and window height
        if(totalPageHeight > $(window).height()) 
        {
            $('.cd-hero-slider').addClass('small-screen');
            $('.cd-hero-slider li:nth-of-type(' + pageNo + ')').css("min-height", totalPageHeight + "px");
        }
        else 
        {
            $('.cd-hero-slider').removeClass('small-screen');
            $('.cd-hero-slider li:nth-of-type(' + pageNo + ')').css("min-height", "100%");
        }
    }

    /*
        Everything is loaded including images.
    */
    $(window).load(function(){

        adjustHeightOfPage(1); // Adjust page height

        /* Gallery One pop up
        -----------------------------------------*/
        $('.gallery-one').magnificPopup({
            delegate: 'a', // child items selector, by clicking on it popup will open
            type: 'image',
            gallery:{enabled:true}                
        });		               

        /* Browser resized 
        -----------------------------------------*/
        $( window ).resize(function() {
            var currentPageNo = $(".cd-hero-slider li.selected .js-tm-page-content").data("page-no");
            
            // wait 3 seconds
            setTimeout(function() {
                adjustHeightOfPage( currentPageNo );
            }, 1000);
            
        });

        // Remove preloader (https://ihatetomatoes.net/create-custom-preloading-screen/)
        $('body').addClass('loaded');
                   
    });
	
	
	 function adjustHeightOfPage(pageNo) {

         var offset = 80;
         var pageContentHeight = 0;

         var pageType = $('div[data-page-no="' + pageNo + '"]').data("page-type");

         if( pageType != undefined && pageType == "gallery") {
             pageContentHeight = $(".cd-hero-slider li:nth-of-type(" + pageNo + ") .tm-img-gallery-container").height();
         }
         else {
             pageContentHeight = $(".cd-hero-slider li:nth-of-type(" + pageNo + ") .js-tm-page-content").height() + 20;
         }

         if($(window).width() >= 992) { offset = 120; }
         else if($(window).width() < 480) { offset = 40; }
        
         // Get the page height
         var totalPageHeight = $('.cd-slider-nav').height()
                                 + pageContentHeight + offset
                                 + $('.tm-footer').height();

         // Adjust layout based on page height and window height
         if(totalPageHeight > $(window).height()) 
         {
             $('.cd-hero-slider').addClass('small-screen');
             $('.cd-hero-slider li:nth-of-type(' + pageNo + ')').css("min-height", totalPageHeight + "px");
         }
         else 
         {
             $('.cd-hero-slider').removeClass('small-screen');
             $('.cd-hero-slider li:nth-of-type(' + pageNo + ')').css("min-height", "100%");
         }
     }

     /*
         Everything is loaded including images.
     */
     $(window).load(function(){

         adjustHeightOfPage(1); // Adjust page height

         /* Gallery One pop up
         -----------------------------------------*/
         $('.gallery-one').magnificPopup({
             delegate: 'a', // child items selector, by clicking on it popup will open
             type: 'image',
             gallery:{enabled:true}                
         });		               

         /* Browser resized 
         -----------------------------------------*/
         $( window ).resize(function() {
             var currentPageNo = $(".cd-hero-slider li.selected .js-tm-page-content").data("page-no");
             
             // wait 3 seconds
             setTimeout(function() {
                 adjustHeightOfPage( currentPageNo );
             }, 1000);
             
         });
 
         // Remove preloader (https://ihatetomatoes.net/create-custom-preloading-screen/)
         $('body').addClass('loaded');
                    
     });
})

 function radioAlert() {
	var videoUrl = document.getElementById("videoUrl").value;
	var textUrl = document.getElementById("textUrl").value;
	var text = document.getElementById("comment").value;
	var myRadio1 = $('input[name=radio1]');
	var myRadio1Value = myRadio1.filter(':checked').attr('id');
	var myRadio2 = $('input[name=radio2]');
	var myRadio2Value = myRadio2.filter(':checked').attr('id');
	
	if (myRadio1Value == "" || myRadio1Value == undefined ) {
		document.getElementById("mandatTarget").innerHTML = "Please check the radio button for Target image.";
    }
	if(myRadio1Value == "" || myRadio1Value == undefined ){
    	document.getElementById("mandat3d").innerHTML = "Please check the radio button for 3 D image.";
    }
	if(videoUrl == "" || videoUrl == undefined ){
    	document.getElementById("mandatVideo").innerHTML = "Please provide the Video URL.";
    }else{
		var pattern = /(https?:\/\/(?:www\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.[^\s]{2,}|www\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.[^\s]{2,}|https?:\/\/(?:www\.|(?!www))[a-zA-Z0-9]\.[^\s]{2,}|www\.[a-zA-Z0-9]\.[^\s]{2,})/;
        if (!pattern.test(videoUrl)) {
        	document.getElementById("mandatVideo").innerHTML = "Video Url is not valid!";
            return false;            
        } 
    }
	
	if(myRadio1Value == "" || myRadio1Value == undefined || myRadio1Value == "" || myRadio1Value == undefined || videoUrl == "" || videoUrl == undefined  ){
		return false;
	}
	// DO GET
	$.ajax({
		type : "GET",
		url : "api/savemogodata",
		data: jQuery.param({ imagePath: myRadio1Value, d3ImagePath : myRadio2Value,videoUrl:videoUrl, textUrl:textUrl , text :text}),
		success: function(data){
			var message = data.msg;
			console.log("SUCCESS: ", data);
			swal("Relationship updated Successfully. ");
			if (document.getElementById("idForm")) {
		            setTimeout("submitForm()", 3000); // set timout 
		    }
		},
		error : function(e) {
			console.log("ERROR: ", e);
		}
	});
}

function submitForm() { // submits form
    document.getElementById("idForm").submit();
}

function modalClick90(id){// Get the modal

	console.log('id of image - '+id)
	var modal = document.getElementById('myModal');

	var modalImg = document.getElementById("img01");
	var captionText = document.getElementById("caption"); 

	console.log('modal click function loaded')

	var img = document.getElementById(id);
	modal.style.display = "block";
	
	modalImg.style.transform= "rotate(90deg)";
	modalImg.src = img.src;
	captionText.innerHTML = img.alt;

	var span = document.getElementsByClassName("close")[0];

	// When the user clicks on <span> (x), close the modal
	span.onclick = function() { 
	  modal.style.display = "none";
	}
}


function modalClick(id){// Get the modal

	console.log('id of image - '+id)
	var modal = document.getElementById('myModal');

	var modalImg = document.getElementById("img01");
	var captionText = document.getElementById("caption"); 

	console.log('modal click function loaded')

	var img = document.getElementById(id);
	modal.style.display = "block";
	
	modalImg.src = img.src;
	captionText.innerHTML = img.alt;

	var span = document.getElementsByClassName("close")[0];

	// When the user clicks on <span> (x), close the modal
	span.onclick = function() { 
	  modal.style.display = "none";
	}
}