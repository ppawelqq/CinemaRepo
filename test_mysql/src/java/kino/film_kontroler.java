/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kino;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author PAWEL
 */
@ManagedBean(name ="film_kontroler")
@SessionScoped
public class film_kontroler{
    int startId;
    int endId;
    int selected_film;
    DataModel filmTitles;
    DataModel seanse;
    kinoHQL kino_HQL;
    private int recordCount = 6;
    private int pageSize = 2;
    private Film current;
    private int selectedItemIndex;
    private Seans current_seans;
    

 public film_kontroler() {
    kino_HQL = new kinoHQL();
    startId = 1;
    endId = 10;
 }
 
 public film_kontroler(int startId, int endId) {
    kino_HQL = new kinoHQL();
    this.startId = startId;
    this.endId = endId;
}
 
 public film_kontroler(int selected_film){
     kino_HQL = new kinoHQL();
     this.selected_film = selected_film;
 }
 
 
public Film getSelected() {
    if (current == null) {
        current = new Film();
        selectedItemIndex = -1;
    }
    return current;
}

public DataModel getFilmTitles() {
    if(filmTitles == null){
       filmTitles = new ListDataModel(kino_HQL.getFilmTitles(startId, endId));
    }
    return filmTitles;
}

 
void recreateModel() {
    filmTitles = null;
  
}


   public boolean isHasNextPage() {
if (endId + pageSize <= recordCount) {
return true;
}
return false;
}
 
public boolean isHasPreviousPage() {
if (startId-pageSize > 0) {
return true;
}
return false;
}
 
public String next() {
startId = endId+1;
endId = endId + pageSize;
recreateModel();
return "index";
}
 
public String previous() {
startId = startId - pageSize;
endId = endId - pageSize;
recreateModel();
return "index";
}
 
public int getPageSize() {
return pageSize;
}
 
public String prepareView(){
current = (Film) getFilmTitles().getRowData();
return "browse";
}


public String prepareList(){
//recreateModel();
return "index";
}


    
}
