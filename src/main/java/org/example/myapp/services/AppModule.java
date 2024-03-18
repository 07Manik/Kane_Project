package org.example.myapp.services;


import org.apache.tapestry5.commons.Configuration;


public class AppModule {

    public static void contributeComponentClasses(Configuration<Class<?>> configuration) {
        configuration.add(EmpBday.class);
    }
}
