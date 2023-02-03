package model;

import java.time.LocalDate;

public class ModelBaseImpl implements  ModelBase {
    Long id;
    LocalDate editDate;

    LocalDate creationDate = LocalDate.now();



    public ModelBaseImpl(Long id) {
        this.id = id;
    }

    public ModelBaseImpl(Long id, LocalDate creationDate) {
        this.id = id;
        this.creationDate = creationDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getEditDate() {
        return editDate;
    }

    public void setEditDate(LocalDate editDate) {
        this.editDate = editDate;
    }
}
