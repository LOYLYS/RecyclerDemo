package edu.ptit.vhlee.recyclerdemo.data.model;

public class Hero {
    private String mName;
    private int mAvatar;
    private boolean mFavorite;

    public Hero(String name, int avatar) {
        mName = name;
        mAvatar = avatar;
        mFavorite = false;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getAvatar() {
        return mAvatar;
    }

    public void setAvatar(int avatar) {
        mAvatar = avatar;
    }

    public boolean isFavorite() {
        return mFavorite;
    }

    public void setFavorite(boolean favorite) {
        mFavorite = favorite;
    }
}
