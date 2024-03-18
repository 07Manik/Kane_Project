package org.example.myapp.pages;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;

public class Search {

    @Property
    private String value;

    @Component
    private Form search;

    void onSuccessFromSearch()
    {

    }
}
