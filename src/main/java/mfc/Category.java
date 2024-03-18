package mfc;

enum Category {
    YOUNG, ELDERLY, BUSINESS;

    public static Category fromString(String category) {
        return Category.valueOf(category.toUpperCase());
    }
}
