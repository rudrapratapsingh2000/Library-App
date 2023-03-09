package com.Library.cotroller;

import com.Library.model.LibraryModel;
import com.Library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/library-app")
public class LibraryController {

    @Autowired
    public LibraryService libraryService;

public LibraryController (LibraryService libraryService){
    this.libraryService=libraryService;
}

    //http://localhost:8080/api/v1/library-app/find-all-library
@GetMapping("find-all-library")
    public List<LibraryModel> findAll(){
    return libraryService.getLibraryModelList();
}
    //http://localhost:8080/api/v1/library-app/find-by-name/name/{name}
@GetMapping("find-by-name/name/{name}")
public LibraryModel findByName(@PathVariable String name){
    return libraryService.findbyname(name);
    }

    //http://localhost:8080/api/v1/library-app/add-library
    @PostMapping("/add-library")
    public  void addLibrary(@RequestBody LibraryModel libraryModel){
    libraryService.addLibrary(libraryModel);
}
    //http://localhost:8080/api/v1/library-app/update-library/id/{id
@PutMapping("/update-library/id/{id}")
    public void updatelibrary(@PathVariable int id,@RequestBody LibraryModel newLibraryModel){
        libraryService.updateLibrary(id,newLibraryModel);
    }
    //http://localhost:8080/api/v1/library-app/delete-library/id/{id}
@DeleteMapping("/delete-library/id/{id}")
    public void deleteLibrary(@PathVariable int id){
    libraryService.deleteLibrary(id);
}
}
