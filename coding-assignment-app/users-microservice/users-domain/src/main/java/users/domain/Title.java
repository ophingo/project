package users.domain;

public enum Title {
    MR("MR"), MRS("MRS"),MISS("MISS");

    private String title;

    Title(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}


