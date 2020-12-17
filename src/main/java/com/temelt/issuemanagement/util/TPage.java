package com.temelt.issuemanagement.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public class TPage<T> {


    private int number;       // şuan kaçıncı sayfa gözüküyor
    private int size;          //frontend den gelecek, client kaçarlı görmek istiyor.
    private Sort sort;        //heahangi kolona tıklayıp sıralama yapacak
    private  int totalPages;   // toplamda kaç sayfa olacak 100 kayıt 10 arlı göster diyorsan 10 total page olur gibi
    private Long totalElements; // size*totalpages
    private List<T> content;            //döneceğim data gösterilecek

    public  void setStat(Page page,List<T> list){
        this.number=page.getNumber();
        this.size=page.getSize();
        this.sort=page.getSort();
        this.totalPages=page.getTotalPages();
        this.totalElements=page.getTotalElements();
        this.content=list;
    }


}
