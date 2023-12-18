package com.example.healthcare2.data.model;

import com.google.gson.annotations.SerializedName;

public class AddMedicines {
    @SerializedName("btnadd")

    private int btnAddImage;
    @SerializedName("name")

    private String nameMedicines;
    @SerializedName("description")

    private String description;

    public AddMedicines(int btnAddImage, String nameMedicines, String description) {
        this.btnAddImage = btnAddImage;
        this.nameMedicines = nameMedicines;
        this.description = description;
    }

    public int getBtnAddImage() {
        return btnAddImage;
    }

    public void setBtnAddImage(int btnAddImage) {
        this.btnAddImage = btnAddImage;
    }

    public String getNameMedicines() {
        return nameMedicines;
    }

    public void setNameMedicines(String nameMedicines) {
        this.nameMedicines = nameMedicines;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AddMedicines{" +
                "btnadd='" + btnAddImage + '\'' +
                ", name='" + nameMedicines + '\'' +
                ", description=" + description +
                '}';
    }
}
