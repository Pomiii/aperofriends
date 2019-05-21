package pco.aperofriends.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
 
@Service
public class StorageService {
	
	private final Path rootLocation = Paths.get("/Users/macpomiii/Documents/Eclipse/AperoFriends/aperofriends/front/src/assets/images");

    public void store(MultipartFile file) {
        try {
            System.out.println(file.getOriginalFilename());
            System.out.println(rootLocation.toUri());

            String image = rootLocation.toUri() +file.getOriginalFilename();
            System.out.println(image);
            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
    }
    public String photoString(MultipartFile file) {
        try {
            System.out.println(file.getOriginalFilename());
            System.out.println(rootLocation.toUri());

            String image = rootLocation.toUri() +file.getOriginalFilename();
            System.out.println(image);
            return image;

        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }

    }
/* 
  Logger log = LoggerFactory.getLogger(this.getClass().getName());
  private final Path rootLocation = Paths.get("/Users/macpomiii/Documents/Eclipse/AperoFriends/aperofriends/front/src/assets/images");
 
  public void store(MultipartFile file) {
    try {
      Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
    } catch (Exception e) {
      throw new RuntimeException("FAIL!");
    }
  }
 
  public Resource loadFile(String filename) {
    try {
      Path file = rootLocation.resolve(filename);
      Resource resource = new UrlResource(file.toUri());
      if (resource.exists() || resource.isReadable()) {
        return resource;
      } else {
        throw new RuntimeException("FAIL!");
      }
    } catch (MalformedURLException e) {
      throw new RuntimeException("FAIL!");
    }
  }
  
   public void deleteAll() {
    FileSystemUtils.deleteRecursively(rootLocation.toFile());
  }
*/ 
 

}