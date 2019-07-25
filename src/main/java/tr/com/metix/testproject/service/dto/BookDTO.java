package tr.com.metix.testproject.service.dto;

import java.io.Serializable;
import java.util.Date;

public class BookDTO implements Serializable {


    private Long id;
    private String bookName;
    private Date publishing_date;

    private Long publisherId; // yayınevi
    private Long authorId; // Yazar

    /////////////////////////////////

    private Set<Category> category = new HashSet<>();



    private Set<Language> languages = new HashSet<>(); // Yayımlandığı diller






}
