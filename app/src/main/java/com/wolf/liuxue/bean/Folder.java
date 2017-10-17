package com.wolf.liuxue.bean;

import java.util.List;

/**
 * Created by nanchaodong on 2017/5/17.
 */

public class Folder {
    private String name;
    private String path;
    private Image cover;
    private List<Image> images;

    public Folder() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Image getCover() {
        return cover;
    }

    public void setCover(Image cover) {
        this.cover = cover;
    }

    @Override
    public boolean equals(Object o) {
        try {
            Folder other = (Folder) o;
            return this.path.equalsIgnoreCase(other.path);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return super.equals(o);
    }
}
