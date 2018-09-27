package com.rdev.horoscopemvvm.vo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by ritacf on 08/09/18.
 */

@Root(name="item", strict=false)
public class Item
{
    @Element(name = "title", required = false)
    private String title;

    @Element(name = "description", required = false)
    private String description;

    @Element(name = "link", required = false)
    private String link;

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getLink ()
    {
        return link;
    }

    public void setLink (String link)
    {
        this.link = link;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [title = "+title+", description = "+description+", link = "+link+"]";
    }
}


