package com.freelog.misc;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import java.net.URL;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClassLoader cl_thread = Thread.currentThread().getContextClassLoader();
        ClassLoader cl_current = App.class.getClassLoader();

        URL url_thread = cl_thread.getResource("/resource/Text.txt");
        URL url_current = cl_current.getResource("resource/Text.txt");
        
        System.out.println(url_thread == null);
        System.out.println(url_current == null);

        try {
            InputStream input = url_current.openStream();
            System.out.println(new String(input.readAllBytes(), StandardCharsets.UTF_8));
        }
        catch (IOException ioe) {
            System.out.println(ioe);
        }

    }
}
