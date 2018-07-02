<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <title>AR Image Video Relationship Window</title>

  
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400"></link>    
    <link rel="stylesheet" href="font-awesome-4.5.0/css/font-awesome.min.css"></link>  
    <link rel="stylesheet" href="/css/bootstrap.min.css"></link>
    <link rel="stylesheet" href="/css/hero-slider-style.css"></link>
    <link rel="stylesheet" href="/css/magnific-popup.css"></link> 
    <link rel="stylesheet" href="/css/tooplate-style.css"></link>   
    <link rel="stylesheet" href="/css/modal.css"></link>   
      <!-- load JS files -->
      	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script> 
        <script src="/js/jquery-1.11.3.min.js"></script>        
        <script src="https://www.atlasestateagents.co.uk/javascript/tether.min.js"></script> 
        <script src="/js/bootstrap.min.js"></script>            
        <script src="/js/hero-slider-main.js"></script>          
        <script src="/js/jquery.magnific-popup.min.js"></script>  
     <script src="/js/jqueryScript2.js"></script>
    
    
</head>



<body>
		 <form:form id ="idForm"  method = "post" action = "/2D3D"  style="background-color:white" >
         <h2>Image Video Relationship Window</h2>
  			<br></br>	
			
					<div class="container">
					     <div class="col-md-2" style="width:10"></div>
						<div class="col-md-8">
						<h1 class="tm-figure-title" style="font-size: 24px;font-family: -webkit-pictograph;font-style: inherit;color: blue;margin-left:14px;">Please select the Target image from the bellow List </h1>
						</div>
					    <div class="col-md-2"></div>
					</div>


<br></br>
			
			
			          <div class="cd-full-width">
                        <div class="container-fluid js-tm-page-content" style="border-radius:1rem;border-style:double;overflow-y: scroll;height: 250px;width:75%!important;border-color:aqua!important" data-page-no="1" data-page-type="gallery">
                            <div class="tm-img-gallery-container">
                                <div class="tm-img-gallery gallery-one">
                                <!-- Gallery One pop up connected with JS code below -->   
                                
                                	<p id = "mandatTarget" style="color: red;font-size: 19px;font-style: italic;font-family: -webkit-body;"></p>
                                	<div>
										<ul class="list-group" id="customerList"></ul>
										
									</div>
                                
                                </div>                                 
                            </div>
                        </div>                                                    
                    </div>     
			
			
<br></br>
                   <div class="container">
							     <div class="col-md-2" style="width:10"></div>
										<div class="col-md-8">
											<h1  class="tm-figure-title"  style="font-size: 24px;font-family: -webkit-pictograph;font-style: inherit;color: blue;margin-left:14px;">Please select the 3D image from the bellow List </h1>
										</div>
							    <div class="col-md-2"></div>
					</div>


<br></br>
					

					<div class="cd-full-width">
                        <div class="container-fluid js-tm-page-content" style="border-radius:1rem;border-style:double;overflow-y: scroll;height: 250px;width:75%!important;border-color:aqua!important" data-page-no="1" data-page-type="gallery">
                            <div class="tm-img-gallery-container">
                                <div class="tm-img-gallery gallery-one">
                                <!-- Gallery One pop up connected with JS code below -->   
                                
                                	<p id = "mandat3d" style="color: red;font-size: 19px;font-style: italic;font-family: -webkit-body;"></p>
                                	<div>
										<ul class="list-group" id="customerList2"></ul>
									</div>

  								</div>                                 
                            </div>
                        </div>                                                    
                    </div>     

<br></br>
<br></br>

					<div class="container">		
				    		<div class="col-md-3"></div>	
							<div class="col-md-6">
							<p id = "mandatVideo" style="color: red;font-size: 19px;font-style: italic;font-family: -webkit-body;"></p>
							<div class="form-group">
				      			<label for="videoUrl">URL:</label>
				      			<input type="text" class="form-control inputstl" id="videoUrl"   style="border-radius:1rem;" ></input>
				    		</div>
				    		<div class="form-group">
				      			<label for="textUrl">Text:</label>
				     			<input type="text" class="form-control inputstl" id="textUrl"  style="border-radius:1rem;"></input>
				   			 </div>
							</div>
							<div class="col-md-3"></div>
				    </div>		
					
					

					<div class="container">
					
							<div class="col-md-3"></div>
							 	<div class="col-md-6">
								<div class="form-group">
							  		<label for="comment">Comment:</label>
							  		<textarea class="form-control inputstl" rows="5" id="comment" style="border-radius:1.2rem;"></textarea>
								</div>
							</div>
							<div class="col-md-4"></div>
					</div>





					<div class="container">
					
								<div class="col-md-8"></div>
									 <div class="col-md-1">
										<div class="form-group">
					 						 <input id="submitButton" style="border-radius:1.2rem;font-weight:500!important;font-size:1.5rem!important"  type = "button" value = "Submit" class="btn btn-primary" onClick="radioAlert();"/>
										</div>
									</div>
								<div class="col-md-4"></div>
					</div>
<div id="myModal" class="modal">

  <!-- The Close Button -->
  <span class="close">&times;</span>

  <!-- Modal Content (The Image) -->
  <img class="modal-content" id="img01" >

  <!-- Modal Caption (Image Text) -->
  <div id="caption"></div>
</div>
    
        </form:form>
       
</body>
</html>
