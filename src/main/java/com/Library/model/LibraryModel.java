package com.Library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryModel {
   String library_name;
   String library_address;
   int library_number;
   String library_facilities;
}
