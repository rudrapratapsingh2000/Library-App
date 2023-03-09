package com.Library.service;

import com.Library.model.LibraryModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class LibraryService {
    private static List<LibraryModel> libraryModelList=new ArrayList<>();
    static {
        libraryModelList.add(new LibraryModel("Quick Learner","Lucknow",001,"Student IT and Learning Support"));
        libraryModelList.add(new LibraryModel("CETPA","Noida",002,"Borrowing and Ordering Material"));
        libraryModelList.add(new LibraryModel("Ducat","Pune",003,"Photocopying/Printing/Scanning"));
        libraryModelList.add(new LibraryModel("JSP","Bangalore",004,"Wireless Access"));
    }

    public List<LibraryModel> getLibraryModelList() {
        return libraryModelList;
    }
    public void addLibrary(LibraryModel libraryModel){
libraryModelList.add(libraryModel);
    }
    public  LibraryModel findbyname(String name){
        Predicate<? super LibraryModel> predicate = libraryModel -> libraryModel.getLibrary_name().equals(name);
        LibraryModel libraryModel = libraryModelList.stream().filter(predicate).findFirst().get();
        return  libraryModel;
    }

    public  LibraryModel findbyId(int id){
        Predicate<? super LibraryModel> predicate =  libraryModel -> libraryModel.getLibrary_number()==id;
        LibraryModel libraryModel = libraryModelList.stream().filter(predicate).findFirst().get();
        return  libraryModel;
    }
    public void deleteLibrary(int id) {
        Predicate<? super LibraryModel> predicate = libraryModel -> libraryModel.getLibrary_number()==id;
        libraryModelList.removeIf(predicate);
    }

    public void updateLibrary(int id,LibraryModel  newLibrary) {
        //step 1: find Library to be update
        //Step 2: update Library

        LibraryModel libraryModel=findbyId(id);// step 1

        libraryModel.setLibrary_name(newLibrary.getLibrary_name());
        libraryModel.setLibrary_address(newLibrary.getLibrary_address());
        libraryModel.setLibrary_number(newLibrary.getLibrary_number());
        libraryModel.setLibrary_facilities(newLibrary.getLibrary_facilities());
    }
}
