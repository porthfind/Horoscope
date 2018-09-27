package com.rdev.horoscopemvvm.vo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/**
 * Created by ritadacostaferreira on 08/09/18.
 */

@Root(name="rss", strict=false)
public class Channel
{
    @Element(name = "title", required = false)
    @Path("channel")
    private String title;

    @Element(name = "link", required = false)
    @Path("channel")
    private String link;

    @Element(name = "item", required = false)
    @Path("channel")
    private Item item;

    public String getItemDescription(){

        //Item item = new Item();
        return this.item.getDescription();
    }

    public String setItemDescription(String response){

        //Item item = new Item();
        String descript = this.item.getDescription() ;
        descript = response;
        return descript;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getLink ()
    {
        return link;
    }

    public void setLink (String link)
    {
        this.link = link;
    }

    public Item getItem ()
    {
        return item;
    }

    public void setItem (Item item)
    {
        this.item = item;
    }

    @Override
    public String toString()
    {
        return this.getItemDescription();
    }
}


