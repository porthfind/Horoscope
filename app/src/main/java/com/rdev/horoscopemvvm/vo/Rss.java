package com.rdev.horoscopemvvm.vo;

import org.simpleframework.xml.Root;

/**
 * Created by ritacf on 08/09/18.
 */
@Root(name="rss", strict=false)
public class Rss
{
    private Channel channel;

    private String version;

    public Channel getChannel ()
    {
        return channel;
    }

    public void setChannel (Channel channel)
    {
        this.channel = channel;
    }

    public String getVersion ()
    {
        return version;
    }

    public void setVersion (String version)
    {
        this.version = version;
    }

    @Override
    public String toString()
    {
        return this.getChannel().getItem().getDescription().toString();
    }
}
