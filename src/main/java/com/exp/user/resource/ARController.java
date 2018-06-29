package com.exp.user.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exp.user.jqueryfilter.model.ImageName;
import com.exp.user.jsonview.Views;
import com.exp.user.model.ARImageMetadata;
import com.exp.user.model.AjaxResponseBody;
import com.exp.user.repository.ARImageMetadataRepository;
import com.fasterxml.jackson.annotation.JsonView;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;


@RestController
@RequestMapping("api")
public class ARController {


	@Autowired
	ARImageMetadataRepository arImageMetadataRepository;
	
	@Autowired
	GridFsOperations gridOperations;
	
	@Autowired
	Mongo mongo;
	
	//private final String datebase = "WorkSpace2";
	private final String datebase = "test";
	
	@JsonView(Views.Public.class)
	@RequestMapping("/savemogodata")
	public AjaxResponseBody getDeviceById(@RequestParam Map<String, String> queryMap) {
		AjaxResponseBody result = new AjaxResponseBody();
		
		String imagePath = queryMap.get("imagePath");
		String d3ImagePath = queryMap.get("d3ImagePath");
		String videoUrl = queryMap.get("videoUrl");
		String textUrl = queryMap.get("textUrl");
		String text = queryMap.get("text");
		
		ARImageMetadata arImageMetadata = arImageMetadataRepository.findOne(imagePath);
		if(null == arImageMetadata) {
			arImageMetadata = new ARImageMetadata();
		}
		arImageMetadata.setId(imagePath);
		arImageMetadata.setImageFileName(imagePath);
		arImageMetadata.setD3ImageFilename(d3ImagePath);
		arImageMetadata.setVideoUrl(videoUrl);
		arImageMetadata.setTextURL(textUrl);
		arImageMetadata.setText(text);
		arImageMetadataRepository.save(arImageMetadata);
		result.setMsg("Relationship updated Successfully. ");
		return result;
	}
	
	@RequestMapping("/image/2d")
    public ResponseEntity<InputStreamResource> getImage(@RequestParam("name") String imageName) throws IOException {
		String imageNameSplit[] = imageName.split("'");
		System.out.println("Image Name : "+imageNameSplit[1]);
		// get file from MongoDB
		
		GridFSDBFile imageFile1 = gridOperations.findOne(new Query(Criteria.where("filename").is(imageNameSplit[1])));
		
        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(imageFile1.getContentType()))
                .body(new InputStreamResource(imageFile1.getInputStream()));
    }
	
	@RequestMapping("/image/all/2d")
    public List<ImageName> getAllImage() throws IOException {
		
		List<ImageName> cusList = new ArrayList<ImageName>();
		
		List<GridFSDBFile> imageFileList = gridOperations.find(null);
		for (GridFSDBFile gridFDDBfile : imageFileList) {
			ImageName cust = new ImageName();
			cust.setName(gridFDDBfile.getFilename());
			cusList.add(cust);
		}
		return cusList;
    }
	
	
	@RequestMapping("/image/all/3d")
    public  List<ImageName> getImageAllImage3d() throws IOException {
		
		DB db = mongo.getDB(datebase);
		
		List<ImageName> cusList = new ArrayList<ImageName>();
		GridFS gfsPhoto = new GridFS(db, "photo");
		// print the result
		DBCursor cursor = gfsPhoto.getFileList();
		while (cursor.hasNext()) {
			DBObject dbObject = cursor.next();
			dbObject.get("filename");
			ImageName cust = new ImageName();
			cust.setName((String)dbObject.get("filename"));
			cusList.add(cust);
		}
		
        return cusList;
	}
	
	@RequestMapping("/image/3d")
    public ResponseEntity<InputStreamResource> getImage3d(@RequestParam("name") String imageName) throws IOException {
		String imageNameSplit[] = imageName.split("'");
		System.out.println("Image Name : "+imageNameSplit[1]);
		DB db = mongo.getDB(datebase);

		//To Save Image file in collection Photo.
		/*String newFileName = "mkyong-java-image";
		File imageFile = new File("c:\\JavaWebHosting.png");
		GridFS gfsPhoto = new GridFS(db, "photo");
		GridFSInputFile gfsFile = gfsPhoto.createFile(imageFile);
		gfsFile.setFilename(newFileName);
		gfsFile.save();*/
		
		// create a "photo" namespace
		GridFS gfsPhoto = new GridFS(db, "photo");
		GridFSDBFile imageFile1 = gfsPhoto.findOne(imageNameSplit[1]);
		
        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(imageFile1.getContentType()))
                .body(new InputStreamResource(imageFile1.getInputStream()));
    }
}
