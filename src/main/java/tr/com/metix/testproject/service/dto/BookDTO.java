package tr.com.metix.testproject.service.dto;



import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BookDTO implements Serializable {


    private Long id;
    private String bookName;
    private Date publishing_date;
    private Long publisherId; // yayınevi
    private Long authorId;
    /////////////////////////////////

    private List<CategoryDTO> categoryDTO;
    private List<LanguageDTO> languageDTO;

    public List<CategoryDTO> getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(List<CategoryDTO> categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public List<LanguageDTO> getLanguageDTO() {
        return languageDTO;
    }

    public void setLanguageDTO(List<LanguageDTO> languageDTO) {
        this.languageDTO = languageDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getPublishing_date() {
        return publishing_date;
    }

    public void setPublishing_date(Date publishing_date) {
        this.publishing_date = publishing_date;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

}
